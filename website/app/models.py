from app import db

class Customer(db.Model):
    customer_id = db.Column(db.Integer, primary_key=True)
    customer_f_name = db.Column(db.String(50), index=True)
    customer_s_name = db.Column(db.String(70), index=True)
    customer_dob = db.Column(db.DateTime)
    customer_mobile = db.Column(db.String(9),unique=True)  #needs to be a string
    customer_address = db.Column(db.String(80))
    customer_postcode = db.Column(db.String(10))

    def __repr__(self):                                 #these initialised the columns
            return '' % (self.customerID,self.customer_f_name, self.customer_s_name, self.customer_dob, self.customer_mobile, self.customer_address, customer_postcode)

class Card(db.Model):
    card_id = db.Column(db.Integer, primary_key=True)
    card_number = db.Column(db.Integer,unique=True)
    card_expiry = db.Column(db.String(10))                #can't be a date datatype
    card_cvv = db.Column(db.Integer)
    #THIS IS WHERE THE customer_id WOULD BE
    #rel = db.relationship('Task', secondary=rel, backref=db.backref('rel', lazy='dynamic'))

    def __repr__(self):                                 #these initialised the columns
            return '' % (self.card_id,self.card_number,self.card_expiry,self.card_cvv)

class Film(db.Model):
    film_id = db.Column(db.Integer, primary_key=True)
    film_name = db.Column(db.String(10),unique=True)
    film_desc = db.Column(db.String(500))
    film_runtime = db.Column(db.Integer)
    film_director = db.Column(db.String(40))
    film_age_rating = db.Column(db.String(5))

    def __repr__(self):                                 #these initialised the columns
        return '' % (self.film_id,self.film_name,self.film_desc,self.film_runtime,self.film_director,self.film_age_rating)

class Screen(db.Model):
    screen_id = db.Column(db.Integer, primary_key=True)
    screen_capacity = db.Column(db.Integer)

    def __repr__(self):                                 #these initialised the columns
        return '' % (self.screen_id,self.screen_capacity)


class Screening(db.Model):
    screening_id = db.Column(db.Integer, primary_key=True)
    screening_time = db.Column(db.DateTime, unique=True)
    screening_date = db.Column(db.DateTime,unique=True)
    #THIS IS WHERE THE film_id WOULD BE
    #THIS IS WHERE THE screen_id WOULD BE

    def __repr__(self):                                 #these initialised the columns
        return '' % (self.screening_id,self.screening_time,self.screening_date)

class Login(db.Model):
    login_id = db.Column(db.Integer, primary_key=True)
    login_email = db.Column(db.String(50),unique=True)
    login_pwd = db.Column(db.String(40))
    login_hint = db.Column(db.String(30))
    #THIS IS WHERE THE customer_id WOULD BE

    def __repr__(self):                                 #these initialised the columns
        return '' % (self.login_id,self.login_email,self.login_pwd,self.login_hint)

class Seat(db.Model):
    seat_id = db.Column(db.Integer, primary_key=True)

    def __repr__(self):                                 #these initialised the columns
        return '' % (self.seat_id)

class Staff(db.Model):
    staff_id = db.Column(db.Integer, primary_key=True)
    staff_username = db.Column(db.String(50), index=True,unique=True)
    staff_pwd = db.Column(db.String(40))
    staff_hint = db.Column(db.String(30))
    staff_f_name = db.Column(db.String(50), index=True)
    staff_s_name = db.Column(db.String(70), index=True)
    staff_dob = db.Column(db.DateTime)
    staff_mobile = db.Column(db.String(9),unique=True)
    staff_address = db.Column(db.String(80))
    staff_postcode = db.Column(db.String(10))
    staff_nin = db.Column(db.Integer, unique=True)

    def __repr__(self):                                 #these initialised the columns
        return '' % (self.staff_id,self.staff_username,self.staff_pwd,self.staff_hint,self.staff_f_name,self.staff_s_name,self.staff_dob,self.staff_mobile,self.staff_address,self.staff_postcode,self.staff_nin)

class Ticket(db.Model):
    ticket_id = db.Column(db.Integer, primary_key=True)
    #THIS IS WHERE THE screening_id WOULD BE
    #THIS IS WHERE THE customer_id WOULD BE
    #THIS IS WHERE THE seat_id WOULD BE

    def __repr__(self):                                 #these initialised the columns
        return '' % (self.ticket_id)
