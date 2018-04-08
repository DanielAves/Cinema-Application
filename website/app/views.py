# -*- coding: utf-8 -*-
from flask import render_template, flash, make_response, redirect, session, url_for, request
from app import app, db, admin
from flask_bcrypt import Bcrypt
from flask_admin.contrib.sqla import ModelView
from flask_mail import Mail, Message
from .forms import CreateForm, SessionForm, SignupForm, PasswordForm, CardForm, CheckoutForm, SearchForm
from app.models import Customer,Card,Film,Screen,Screening,Login,Seat,Staff,Ticket
import datetime,pyqrcode
mail=Mail(app)
bcrypt = Bcrypt(app)

@app.route('/search',methods=['GET', 'POST'])
def search():
    films = Film.query.filter(Film.film_name.like("")).all()
    screenings = Screening.query.filter(Screening.screening_date.like("")).all()
    searchform= SearchForm()
    if searchform.validate_on_submit():
        films = Film.query.filter(Film.film_name.contains(searchform.search.data)).all()
        screenings = Screening.query.filter(Screening.screening_date.contains(searchform.search.data)).all()
    return render_template('search.html', title='Search',searchform=searchform,films=films,screenings=screenings)

@app.route('/')
def index():
    return render_template('index.html', title='Home')

@app.route('/whatson')
def whatson():
    film = Film.query.all()
    return render_template('whatson.html', title='What is on?',film=film)

@app.route('/aboutus')
def aboutus():
    return render_template('aboutus.html', title='About us')

@app.route('/myaccount')
def myaccount():
    if 'variable' not in session:
        return redirect(url_for('login'))
    value = session['variable']
    variableFind = Login.query.filter_by(login_email=value).first()
    if variableFind:
        customer = Customer.query.filter_by(customer_id=variableFind.customer_id).first()
        #add validation if there is no card added.
        card = Card.query.filter_by(customer_id=variableFind.customer_id).first()
        tickets = Ticket.query.filter_by(customer_id=variableFind.customer_id).all()
    return render_template('myaccount.html', title='My Account',customer=customer,tickets=tickets,card=card)

@app.route('/unsetvariable')
def logout():
	session.pop('variable', None)					#gets rid of the session
	return redirect(url_for('index'))

@app.route('/movie/<movieID>') #Consider renaming to 'filmpage'
def movie(movieID):
    current = datetime.date.today()
    film = Film.query.filter_by(film_id=movieID).first()
    screening = Screening.query.filter_by(film_id=movieID).filter_by(screening_date=current).all()
    screeningtomorrow = Screening.query.filter_by(film_id=movieID).filter_by(screening_date=(current + datetime.timedelta(days=1))).all()
    screeningplus2 = Screening.query.filter_by(film_id=movieID).filter_by(screening_date=(current + datetime.timedelta(days=2))).all()
    screeningplus3 = Screening.query.filter_by(film_id=movieID).filter_by(screening_date=(current + datetime.timedelta(days=3))).all()
    screeningplus4 = Screening.query.filter_by(film_id=movieID).filter_by(screening_date=(current + datetime.timedelta(days=4))).all()
    screeningplus5 = Screening.query.filter_by(film_id=movieID).filter_by(screening_date=(current + datetime.timedelta(days=5))).all()
    screeningplus6 = Screening.query.filter_by(film_id=movieID).filter_by(screening_date=(current + datetime.timedelta(days=6))).all()
    return render_template('movie.html', title='Movie', film=film, screening=screening, screeningtomorrow=screeningtomorrow,screeningplus2=screeningplus2,screeningplus3=screeningplus3,screeningplus4=screeningplus4,screeningplus5=screeningplus5,screeningplus6=screeningplus6)

@app.route('/seatchoice/<screeningID>')
def seatchoice(screeningID):
    screening = Screening.query.filter_by(screening_id=screeningID).first()
    if screening:
        film = Film.query.filter_by(film_id=screening.film_id).first()
        capacity = Screen.query.filter_by(screen_id=screening.screen_id).first()
        seats = Seat.query.all()
    else:
        return redirect(url_for('whatson'))
    return render_template('seatchoice.html', title='Choose Seat',screening=screening, film=film, seats=seats)

@app.route('/checkout/<screeningID>/<seatID>',methods=['GET', 'POST'])
def checkout(screeningID,seatID):
    price = ""
    if 'variable' not in session:
        return redirect(url_for('login'))
    value = session['variable']
    variableFind = Login.query.filter_by(login_email=value).first()
    if variableFind:
        customer = Customer.query.filter_by(customer_id=variableFind.customer_id).first()
        cardFind = Card.query.filter_by(customer_id=variableFind.customer_id).first()
        screening = Screening.query.filter_by(screening_id=screeningID).first()
        film = Film.query.filter_by(film_id=screening.film_id).first()
        seatID = int(seatID)
        seat = Seat.query.filter_by(seat_id=seatID).first()
        ticketTaken = Ticket.query.filter_by(seat_id=seat.seat_id).first()
        if ticketTaken:
            print ticketTaken.screening.screening_id
            if ticketTaken.seat_id == seat.seat_id:
                return redirect(url_for('seatchoice', screeningID=screening.screening_id))


        #checks if user allowed to watch this film
        age = ""
        ratings = {'U': 4, 'PG': 8, '12': 12,'15': 15,'18': 18}
        if str(film.film_age_rating) in ratings:
            if (agefinder(customer.customer_dob) < (ratings[str(film.film_age_rating)]) ):
                age = "You are underage to watch this film"
        if seatID < 10 and agefinder(customer.customer_dob) <= 64:
            price = "7.50"
        elif seatID < 10 and agefinder(customer.customer_dob) > 64:
            price = "6.00 (Over 65 Discount)"
        elif seatID > 10 and agefinder(customer.customer_dob) > 64:
            price = "3.50 (Over 65 Discount)"
        else:
            price = "5.00"

        checkoutform = CheckoutForm()
        cardform = CardForm()
        if checkoutform.validate_on_submit() and cardform.validate_on_submit:
            another_form = Ticket(customer_id=customer.customer_id,screening_id=screening.screening_id,seat_id=seatID)
            db.session.add(another_form)
            db.session.commit()

            info = [film.film_name,str(screening.screening_date),str(screening.screening_time)
                    ,str(seat.seat_id), str(screening.screen_id),
                    str(customer.customer_f_name + " " + customer.customer_s_name)]
            print(info[0], info[1])
            subject = 'Osprey Cinema: Ticket for ' + info[0] + ' on ' + info[1]
            content = ("<h1>Ticket Information<h1>" + "<br> <b>Customer: </b>" + info[5]
                 + "<br> <b>Film: </b>" + info[0]  + "<br> <b>Date: </b>" + info[1]
                 + "<br> <b>Time: </b>" + info[2] + "<br> <b>Seat: </b>" + info[3]
                 + "<br> <b>Screen: </b>" + info[4] + "<br> <b>Price:  </b>" + price)

            ticketinfo = ("<Osprey Cinema Valid Ticket> \nCustomer Name: " + info[5]
                       + "\nScreening Date: " + info[1] + "\nScreening Time: " + info[2]
                       + "\nScreen Number: " + info[4] + "\nSeat Number: " + info[3]
                       + "\nPrice: " + price)
            ticketcode = pyqrcode.create(ticketinfo, error='L', version=8, mode='binary')
            ticketcode.svg('app/static/img/ticket.svg', scale=8)

            msg = Message(subject, sender = 'Osprey Cinema', recipients = [value])
            msg.html = content
            with app.open_resource("static/img/ticket.svg") as fp:
                msg.attach("ticket.svg", "image/svg", fp.read())
            mail.send(msg)

            return redirect(url_for('index'))
    return render_template('checkout.html', title='Checkout', price=price,customer=customer,film=film, seat=seat, screening=screening, checkoutform=checkoutform, cardform=cardform, age=age, cardFind=cardFind)

@app.route('/login', methods=['GET', 'POST'])
def login():
    if 'variable' in session:
        return redirect(url_for('myaccount'))
    message=""
    sessionform = SessionForm()
    if sessionform.validate_on_submit():
        variableFind = Login.query.filter_by(login_email=sessionform.login.data).first()
        if variableFind:
            if (bcrypt.check_password_hash(variableFind.login_password, sessionform.password.data) == True):
                session['variable'] = sessionform.login.data				#creates the session
                return redirect(url_for('myaccount'))
        message="Invalid Username or Password"
    return render_template('login.html', title='Login', sessionform=sessionform,message=message)

@app.route('/signup', methods=['GET', 'POST'])
def signup():
    i = 0
    message1 = ""
    message2 = ""
    signform = SignupForm()
    if signform.validate_on_submit():
        variableFind = Login.query.filter_by(login_email=signform.email.data).first()
        findMobile = Customer.query.filter_by(customer_mobile=signform.mobile.data).first()
        if variableFind:
            message1 = "Email is already being used"
            i = 1

        if findMobile:
            message2 = "Mobile number is already being used"
            i = 2

        if i == 0:
            form_thing = Customer(customer_f_name=signform.firstname.data,customer_s_name=signform.surname.data,customer_dob=signform.dob.data,customer_mobile=signform.mobile.data,customer_address=signform.address.data,customer_postcode=signform.postcode.data)
            db.session.add(form_thing)
            db.session.commit()

            pw_hash = bcrypt.generate_password_hash(signform.confirm.data)
            another_form = Login(customer_id=form_thing.customer_id,login_email=signform.email.data,login_password=pw_hash,login_hint=signform.hint.data)
            db.session.add(another_form)
            db.session.commit()
            return redirect(url_for('login'))
    return render_template('signup.html', title='Sign up',signform=signform,message1=message1,message2=message2)

@app.route('/card', methods=['GET', 'POST'])
def card():
    message = ""
    if 'variable' not in session:
        return redirect(url_for('login'))
    value = session['variable']
    variableFind = Login.query.filter_by(login_email=value).first()
    cardform = CardForm()
    if cardform.validate_on_submit():
        numberFind = Card.query.filter_by(card_number=cardform.number.data).first()
        if numberFind:
            message = "Card Number is already being used"
        else:
            cardFind = Card.query.filter_by(customer_id=variableFind.customer_id).first()
            expirydate = int(str(cardform.expirymonth.data) + str(cardform.expiryyear.data))
            if cardFind:
                cardFind.card_number=cardform.number.data
                cardFind.card_expiry=expirydate
                cardFind.card_cvv=cardform.cvv.data
                db.session.commit()
                return redirect(url_for('myaccount'))
            else:
                form_thing = Card(customer_id=variableFind.customer_id,card_number=cardform.number.data,
                card_expiry=expirydate,card_cvv=cardform.cvv.data)
                db.session.add(form_thing)
                db.session.commit()

                return redirect(url_for('myaccount'))

    return render_template('card.html', title='Card', cardform=cardform,message=message)

def agefinder(dob):
        today = datetime.date.today()
        return today.year - dob.year - ((today.month, today.day) < (dob.month, dob.day))

def seatfinder(seat,screening):
    ticket = Ticket.query.filter_by(screening_id=screening.screening_id).all()
    if ticket:
        for each in ticket:
            if each.seat_id == seat.seat_id:
                return True
    else:
        return False

app.jinja_env.globals.update(seatfinder=seatfinder)
