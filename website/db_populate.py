from app import db
from app.models import Card, Film, Customer, Screen, Screening, Seat, Login

import datetime

def populate_seats():

	for i in range(1,100):
		s = Seat(seat_id=i)
		db.session.add(s)
	db.session.commit()

def populate_films():

	data = [
(1, u'The Greatest Showman', u'American musical drama film, written by Jenny Bicks and starring Hugh Jackman, Zac Efront, Michelle Williams, Rebecca Ferguson and Zendaya', 120, u'Michael Gracey', u'12',u'showman.jpg'),
(2, u'Black Panther', u'With the King of Wakanda now dead, his son T’Challa must return home to take his rightful place on the throne. But, it’s going to be a bumpy ride, as an evil faction has other plans for the country’s future.', 134, u'Ryan Coogler', u'12',u'BlackPanther.jpg'),
(3, u'Coco', u'Ignoring his family’s baffling ban on music, Miguel embarks on a journey through the enchanting Land of the Dead in search of his dreams of becoming a musician.', 105, u'Adrian Molina', u'U',u'cocoKids.jpg'),
(4, u'Downsizing', u'A married couple decide to escape the daily humdrum of modern life by downsizing – a procedure which will see their bodies shrink to 5 inches tall, but their modest savings turn into millions of pounds.', 135, u'Alexander Payne', u'15',u'downsizingTeen.jpg'),
(5, u'Early Man', u'As the Bronze Age arrives and the Stone Age is over, a determined caveman and his faithful sidekick must fight for his home and the rights of his people. ', 89, u'Nick Park', u'U',u'earlymanKids.jpg'),
(6, u'Jumanji: Welcome To The Jungle', u'When four kids dust off an old video game and begin to play ‘Jumanji’, they quickly realise this is not a normal game. It’s a game of survival, where only the winners return to the real world.', 119, u'Jake Kasdan', u'12',u'jumanji.jpg'),
(7, u'Darkest Hour', u'The fate of Britain lies on Winston Churchill’s shoulders, in this historical-drama that tells the story of the country’s darkest – and strongest – hours.', 125, u'Joe Wright', u'U',u'darkestHour.jpg'),
(8, u'The Post', u'In June 1971 The New York Times, the Washington Post and the nations major newspapers took a brave stand for freedom of speech and reported on the Pentagon Papers, the massive cover-up of government secrets that spanned four decades and four Presidents.', 116, u'Steven Spielberg', u'12',u'thepostSenior.jpg'),
(9, u'Maze Runner: The Death Cure', u'The final battle: Thomas must try to find a cure for the disease that has destroyed most of society. Live or die: everything is about to change...', 142, u'Wes Ball', u'12',u'mazerunnerTeen.jpg'),
(10, u'Journeys End', u'With Operation Michael in full swing and a battle on the horizon, a group of British soldiers holed up in a dugout in Aisne in 1918 anxiously await their fate.', 107, u'Saul Dibb', u'12',u'journeysend.jpg')
]
	for d in data:
		film = Film(film_id=d[0],film_name=d[1],film_description=d[2],film_runtime=d[3], film_director=d[4], film_age_rating=d[5],film_poster=d[6])
		db.session.add(film)
	db.session.commit()

def populate_screenings():
	i=0;
	for screen in Screen.query.all():
		for film in Film.query.all():
			i = i+1
			screening = Screening(screening_id=i,screen_id=screen.screen_id,film_id=film.film_id,screening_time=datetime.time(),screening_date=datetime.date(2017,1,17))
			db.session.add(screening)
	db.session.commit()

def populate_customers():
	data = [
(1, u'Ben', u'Ashby',u'+447845775449', u'5 Magna Close', u'AL51RH'),
(2, u'Taran', u'Bola',  u'+447400832054', u'6 Winfield Place', u'LS23AB'),
(3, u'Dan', u'Aves',  u'+447803849940', u'15 Beckett Garden', u'AL69JE'),
(4, u'Matt', u'Cutts',  u'+447908858831', u'6 Alistair Drive', u'CH630LH')
]
	i = 1
	for d in data:
		customer = Customer(customer_id=d[0], customer_f_name=d[1], customer_s_name=d[2],customer_dob=datetime.date(2017,1,17),customer_mobile=d[3],customer_address=d[4], customer_postcode=d[5])
		# customer.card.append(Card(card_number=123412341234123 +i, card_expiry=datetime.date(2017,1,17),card_cvv=111))
		customer.card.append(Card(card_number = d.card_number, card_expiry = datetime.date(),card_cvv = d.card_cvv))
		db.session.add(customer)
		i = i+1
	db.session.commit()

def populate_tickets():
	pass

def populate_screen():
	for i in range(1,11):
		screen = Screen(screen_capacity=100)
		db.session.add(screen)    </form>
	db.session.commit()

def populate_login():
	data = [(1, u'ben19feb@hotmail.co.uk', u'password', u'Mwhahahahaha'),
	(2, u'taran.s.bola@gmail.com', u'yellow', u'colour')    </form>,
	(3, u'danaves@outlook.com', u'1234', u'123456789'),
	(4, u'mattycutts@hotmail.com', u'password', u'pd')]

	for d in data:
		login = Login(customer_id=d[0], login_email=d[1], login_password=d[2],login_hint=d[3])
		db.session.add(login)
	db.session.commit()


populate_seats()
populate_films()
populate_customers()
populate_tickets()
populate_screen()
populate_screenings()
populate_login()
