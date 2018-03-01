from app import db

class Customer(db.Model):
    customer_id = db.Column(db.Integer, primary_key=True)
    customer_f_name = db.Column(db.String(20))
    customer_s_name = db.Column(db.String(30))
    customer_dob = db.Column(db.Date)
    customer_mobile = db.Column(db.String(13), unique=True)
    customer_address = db.Column(db.String(40))
    customer_postcode = db.Column(db.String(8))
    card = db.relationship('Card', backref = 'customer', lazy = 'dynamic')
    login = db.relationship('Login', backref = 'customer', lazy = 'dynamic')
    ticket = db.relationship('Ticket', backref = 'customer', lazy = 'dynamic')

    def __repr__(self):
            return '' % (self.customer_id, self.customer_f_name,
            self.customer_s_name, self.customer_dob, self.customer_mobile,
            self.customer_address, self.customer_postcode)

class Card(db.Model):
    card_id = db.Column(db.Integer, primary_key=True)
    customer_id = db.Column(db.Integer, db.ForeignKey('customer.customer_id'))
    card_number = db.Column(db.Integer, unique=True)
    card_expiry = db.Column(db.Integer)
    card_cvv = db.Column(db.Integer)

    def __repr__(self):
            return '' % (self.card_id, self.card_number, self.card_expiry,
            self.card_cvv, self.customer_id)

class Film(db.Model):
    film_id = db.Column(db.Integer, primary_key=True)
    film_name = db.Column(db.String(30), unique=True)
    film_description = db.Column(db.String(500))
    film_runtime = db.Column(db.Integer)
    film_director = db.Column(db.String(50))
    film_age_rating = db.Column(db.String(3))
    screening = db.relationship('Screening', backref = 'film', lazy = 'dynamic')

    def __repr__(self):
        return '' % (self.film_id, self.film_name, self.film_desc,
        self.film_runtime, self.film_director, self.film_age_rating)

class Screen(db.Model):
    screen_id = db.Column(db.Integer, primary_key=True)
    screen_capacity = db.Column(db.Integer)
    screening = db.relationship('Screening', backref = 'screen', lazy = 'dynamic')

    def __repr__(self):
        return '' % (self.screen_id, self.screen_capacity)


class Screening(db.Model):
    screening_id = db.Column(db.Integer, primary_key=True)
    film_id  = db.Column(db.Integer, db.ForeignKey('film.film_id'))
    screen_id = db.Column(db.Integer, db.ForeignKey('screen.screen_id'))
    screening_time = db.Column(db.String(5))
    screening_date = db.Column(db.DateTime)
    ticket = db.relationship('Ticket', backref = 'screening', lazy = 'dynamic')

    def __repr__(self):
        return '' % (self.screening_id, self.film_id, self.screen_id,
        self.screening_time, self.screening_date)

class Login(db.Model):
    customer_id  = db.Column(db.Integer, db.ForeignKey('customer.customer_id'),
                     primary_key=True)
    login_email = db.Column(db.String(30), unique=True)
    login_password = db.Column(db.String(30))
    login_hint = db.Column(db.String(30))

    def __repr__(self):
        return '' % (self.customer_id, self.login_email, self.login_pwd,
        self.login_hint)

class Seat(db.Model):
    seat_id = db.Column(db.Integer, primary_key=True)
    ticket = db.relationship('Ticket', backref = 'seat', lazy = 'dynamic')

    def __repr__(self):
        return '' % (self.seat_id)

class Staff(db.Model):
    staff_id = db.Column(db.Integer, primary_key=True)
    staff_f_name = db.Column(db.String(20))
    staff_s_name = db.Column(db.String(30))
    staff_dob = db.Column(db.DateTime)
    staff_mobile = db.Column(db.String(13), unique=True)
    staff_address = db.Column(db.String(40))
    staff_postcode = db.Column(db.String(8))
    staff_ni = db.Column(db.String(9), unique=True)

    def __repr__(self):
        return '' % (self.staff_id, self.staff_f_name, self.staff_s_name,
        self.staff_dob, self.staff_mobile, self.staff_address,
        self.staff_postcode, self.staff_nin)

class Ticket(db.Model):
    ticket_id = db.Column(db.Integer, primary_key=True)
    customer_id  = db.Column(db.Integer, db.ForeignKey('customer.customer_id'))
    screening_id = db.Column(db.Integer, db.ForeignKey('screening.screening_id'))
    seat_id      = db.Column(db.Integer, db.ForeignKey('seat.seat_id'))

    def __repr__(self):
        return '' % (self)
