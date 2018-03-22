from flask_wtf import Form
from wtforms import TextAreaField, StringField, TextField,IntegerField, DateField,PasswordField
from wtforms.validators import DataRequired,InputRequired, Length, Email, EqualTo #Imports needed for forms
# from .models import Task

class CreateForm(Form):
    number2 = TextAreaField('number2', validators=[DataRequired()]) #The description field

class SessionForm(Form):
    login = TextField('login', validators=[DataRequired()]) #Used for login
    password = PasswordField('password', validators=[DataRequired()])

class SignupForm(Form):
    firstname = TextField('firstname', validators=[DataRequired()])
    surname = TextField('surname', validators=[DataRequired()])
    dob = DateField('dob', validators=[DataRequired()],format='%Y-%m-%d')
    mobile = TextField('mobile', validators=[DataRequired(),Length(min=9, message="Mobile number not entered")])
    address = TextField('address', validators=[DataRequired()])
    postcode = TextField('postcode', validators=[DataRequired()])
    email = TextField('email', validators=[DataRequired(),Email(message="Incorrect email")]) #Used for signing up
    password = PasswordField('New Password', [InputRequired(), EqualTo('confirm', message='Passwords must match')])
    confirm  = PasswordField('Repeat Password')
    hint = TextField('hint', validators=[DataRequired()])
    # card_number = IntegerField('cardnumber', validators=[DataRequired()])
    # card_expiry = TextField('card_expiry', validators=[DataRequired()])
    # card_cvv = IntegerField('card_cvv', validators=[DataRequired()])

class PasswordForm(Form):
    changeusername = TextField('changeusername', validators=[DataRequired()])
    changepassword = TextField('changepassword', validators=[DataRequired()]) #Used for changing password
    newpassword = TextField('newpassword', validators=[DataRequired()])

# class cardForm(Form):
#     card_number = IntegerField('cardnumber', validators=[DataRequired()])
#     card_expiry = TextField('card_expiry', validators=[DataRequired()])
#     card_cvv = IntegerField('card_cvv', validators=[DataRequired()])
