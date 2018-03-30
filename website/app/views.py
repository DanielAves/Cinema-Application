from flask import render_template, flash, make_response, redirect, session, url_for, request
from app import app, db, admin
from flask_admin.contrib.sqla import ModelView
from .forms import CreateForm, SessionForm, SignupForm, PasswordForm, CardForm
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
    # for each in tickets:
    #         screening = Screening.query.filter_by(screening_id=each.screening_id).all()
    return render_template('myaccount.html', title='My Account',customer=customer,tickets=tickets,card=card)

@app.route('/unsetvariable')
def logout():
	session.pop('variable', None)					#gets rid of the session
	return redirect(url_for('index'))

@app.route('/movie/<movieID>') #Consider renaming to 'filmpage'
def movie(movieID):
    film = Film.query.filter_by(film_id=movieID).first()
    screening = Screening.query.filter_by(film_id=movieID).all()
    return render_template('movie.html', title='Movie', film=film, screening=screening)


@app.route('/seatchoice/<screeningID>')
def seatchoice(screeningID):
    screening = Screening.query.filter_by(screening_id=screeningID).first()
    if screening:
        film = Film.query.filter_by(film_id=screening.film_id).first()
        capacity = Screen.query.filter_by(screen_id=screening.screen_id).first()
        seats = Seat.query.all()[0:capacity.screen_capacity]
        tickets = Ticket.query.filter_by(screening_id=screening.screening_id).all()
    return render_template('seatchoice.html', title='Choose Seat',screening=screening, film=film, seats=seats, tickets=tickets)

@app.route('/checkout')
def checkout():
    return render_template('checkout.html', title='Checkout')

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
    signform = SignupForm()
    if signform.validate_on_submit():
        form_thing = Customer(customer_f_name=signform.firstname.data,
        customer_s_name=signform.surname.data,customer_dob=signform.dob.data,
        customer_mobile=signform.mobile.data,customer_address=signform.address.data,
        customer_postcode=signform.postcode.data)
        db.session.add(form_thing)
        db.session.commit()

        another_form = Login(customer_id=form_thing.customer_id,login_email=signform.email.data,
        login_password=signform.confirm.data,login_hint=signform.hint.data)
        db.session.add(another_form)
        db.session.commit()
        return redirect(url_for('login'))
    # customer = Customer.query.all()
    return render_template('signup.html', title='Sign up',signform=signform)

@app.route('/card', methods=['GET', 'POST'])
def card():
    if 'variable' not in session:
        return redirect(url_for('login'))
    value = session['variable']
    variableFind = Login.query.filter_by(login_email=value).first()
    cardform = CardForm()
    if cardform.validate_on_submit():
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

    return render_template('card.html', title='Card', cardform=cardform)
