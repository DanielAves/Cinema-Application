from flask_wtf import Form
from wtforms import TextAreaField, StringField, TextField,IntegerField, DateField,PasswordField, SelectField, BooleanField
from wtforms.validators import DataRequired,InputRequired, Length, Email, EqualTo, NumberRange, ValidationError #Imports needed for forms
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

class PasswordForm(Form):
    changeusername = TextField('changeusername', validators=[DataRequired()])
    changepassword = TextField('changepassword', validators=[DataRequired()]) #Used for changing password
    newpassword = TextField('newpassword', validators=[DataRequired()])

def validate_cardnumber(form, field):
        str(field.data).strip()
        if len(str(field.data)) != 16:
            if len(str(field.data)) != 15:
                if len(str(field.data)) != 14:
                    raise ValidationError('Card Number must be 14-16 characters long')

def validate_cvv(form, field):
        str(field.data).strip()
        if len(str(field.data)) != 3:
            if len(str(field.data)) != 4:
                raise ValidationError('CVV must be 3 or 4 characters')

class CardForm(Form):
    number = IntegerField('number',validators=[validate_cardnumber])
    expirymonth = SelectField(choices=[(1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12)],coerce=int)
    expiryyear = SelectField(choices=[(2018,2018),(2019,2019),(2020,2020),(2021,2021),(2022,2022),(2023,2023),(2024,2024),(2025,2025)],coerce=int)
    cvv = IntegerField('cvv', validators=[validate_cvv])

class CheckoutForm(Form):
    check = BooleanField('Agree?', validators=[DataRequired(), ])
