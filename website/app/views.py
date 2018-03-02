from flask import render_template, flash, make_response, redirect, session, url_for, request
from app import app, db, admin
from flask_admin.contrib.sqla import ModelView
from .forms import CreateForm, SessionForm, SignupForm, PasswordForm
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
        customer = Customer.query.filter_by(customer_id=variableFind.customer_id).all()
    return render_template('myaccount.html', title='My Account',customer=customer)

@app.route('/unsetvariable')
def logout():
	session.pop('variable', None)					#gets rid of the session
	return redirect(url_for('index'))

@app.route('/movie/<movieID>') #Consider renaming to 'filmpage'
def movie(movieID):
    film = Film.query.filter_by(film_id=movieID).first()
    return render_template('movie.html', title='Movie', film=film)


@app.route('/seatchoice')
def seatchoice():
    return render_template('seatchoice.html', title='Choose Seat')

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
        form_thing = Customer(customer_f_name=signform.firstname.data,customer_s_name=signform.surname.data,customer_dob=signform.dob.data,customer_mobile=signform.mobile.data,customer_address=signform.address.data,customer_postcode=signform.postcode.data)
        db.session.add(form_thing)
        db.session.commit()
        # another_form = Login(login_email=signform.email.data,login_password=signform.confirm.data,login_hint=signform.hint.data)
        # db.session.add(another_form)
        # db.session.commit()
    # customer = Customer.query.all()
    return render_template('signup.html', title='Sign up',signform=signform)

@app.route('/card')
def card():
    return render_template('card.html', title='Sign up')
