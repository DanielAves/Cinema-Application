from flask import render_template, flash, redirect, session, url_for, request, make_response
from app import app
from .forms import CreateForm, SessionForm, SignupForm, PasswordForm         #all the imports needed for the functions
import datetime

@app.route('/')
def index():
    user = {'name': 'Team Osprey'}
    return render_template('index.html', title='Home', user=user)

@app.route('/whatson')
def whatson():
    return render_template('whatson.html', title='What is on?')

@app.route('/aboutus')
def aboutus():
    return render_template('aboutus.html', title='About us')

@app.route('/myaccount')
def myaccount():
    return render_template('myaccount.html', title='My Account')

@app.route('/moviepage')
def movie():
    return render_template('movie.html', title='Movie')

@app.route('/seatchoice')
def seatchoice():
    return render_template('seatchoice.html', title='Choose Seat')

@app.route('/checkout')
def checkout():
    return render_template('checkout.html', title='Checkout')

@app.route('/login')
def login():
    return render_template('login.html', title='Login')

@app.route('/signup', methods=['GET', 'POST'])
def signup():
    signform = SignupForm()
	# message=""
	# user = User.query.all()
	# signform = SignupForm()										#use validation for forms
	# if signform.validate_on_submit():
	# 	variableFind = User.query.filter_by(username = signform.username.data).first()
	# 	if variableFind:
	# 		message="Username Already Taken"
	# 	else:
	# 		username_form = User(username = signform.username.data, password = signform.password.data)
	# 		db.session.add(username_form)									#checks user data and adds to db
	# 		db.session.commit()
	# 		return redirect(url_for('create_task'))
    return render_template('signup.html', title='Sign up',signform=signform)

@app.route('/card')
def card():
    return render_template('card.html', title='Sign up')
