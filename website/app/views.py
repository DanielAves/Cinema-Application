from flask import render_template, flash, make_response, redirect, session, url_for, request
from app import app, db, admin
from flask_admin.contrib.sqla import ModelView
from .forms import CreateForm, SessionForm, SignupForm, PasswordForm, CardForm, CheckoutForm
from app.models import Customer,Card,Film,Screen,Screening,Login,Seat,Staff,Ticket
import datetime

@app.route('/')
def index():
    user = {'name': 'Team Osprey'}
    return render_template('index.html', title='Home', user=user)

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
        seats = Seat.query.all()[0:capacity.screen_capacity]
        tickets = Ticket.query.filter_by(screening_id=screening.screening_id).all()
    return render_template('seatchoice.html', title='Choose Seat',screening=screening, film=film, seats=seats, tickets=tickets)

@app.route('/checkout/<screeningID>/<seatID>',methods=['GET', 'POST'])
def checkout(screeningID,seatID):
    message = ""
    if 'variable' not in session:
        return redirect(url_for('login'))
    value = session['variable']
    variableFind = Login.query.filter_by(login_email=value).first()
    if variableFind:
        customer = Customer.query.filter_by(customer_id=variableFind.customer_id).first()
        cardFind = Card.query.filter_by(customer_id=variableFind.customer_id).first()
        if cardFind:
            message = "You can checkout"
            screening = Screening.query.filter_by(screening_id=screeningID).first()
            film = Film.query.filter_by(film_id=screening.film_id).first()
            seatID = int(seatID)
            seat = Seat.query.filter_by(seat_id=seatID).first()
            checkoutform = CheckoutForm()
            if checkoutform.validate_on_submit():
                another_form = Ticket(customer_id=customer.customer_id,screening_id=screening.screening_id,seat_id=seatID)
                db.session.add(another_form)
                db.session.commit()
                return redirect(url_for('index'))
        else:
            message = "You need to enter card details into your account to continue."
    return render_template('checkout.html', title='Checkout', message=message,customer=customer,film=film, seat=seat, screening=screening, checkoutform=checkoutform)

@app.route('/login', methods=['GET', 'POST'])
def login():
    message=""
    sessionform = SessionForm()
    if sessionform.validate_on_submit():
        variableFind = Login.query.filter_by(login_email=sessionform.login.data).first()
        if variableFind:
            if variableFind.login_password == sessionform.password.data:					#validation to check user data
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

            another_form = Login(customer_id=form_thing.customer_id,login_email=signform.email.data,login_password=signform.confirm.data,login_hint=signform.hint.data)
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
