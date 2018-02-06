from flask import render_template
from app import app

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

@app.route('/signup')
def signup():
    return render_template('signup.html', title='Sign up')

@app.route('/card')
def card():
    return render_template('card.html', title='Sign up')
