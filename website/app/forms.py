from flask_wtf import Form
from wtforms import TextAreaField, StringField, TextField
from wtforms.validators import DataRequired #Imports needed for forms
# from .models import Task

class CreateForm(Form):
    number2 = TextAreaField('number2', validators=[DataRequired()]) #The description field

class SessionForm(Form):
    value = TextField('value', validators=[DataRequired()]) #Used for login
    pw = TextField('pw', validators=[DataRequired()])

class SignupForm(Form):
    username = TextField('username', validators=[DataRequired()]) #Used for signing up
    password = TextField('password', validators=[DataRequired()])

class PasswordForm(Form):
    changeusername = TextField('changeusername', validators=[DataRequired()])
    changepassword = TextField('changepassword', validators=[DataRequired()]) #Used for changing password
    newpassword = TextField('newpassword', validators=[DataRequired()])
