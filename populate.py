# -*- coding: utf-8 -*-
import sqlite3

db = sqlite3.connect("app.db")
c = db.cursor()

c.executemany("INSERT INTO Customer(customer_id, customer_f_name, customer_s_name, customer_dob, customer_mobile, customer_address, customer_postcode) VALUES (?, ?, ?, ?, ?, ?, ?)",
[
(1, u'Ben', u'Ashby', u'19/02/1996', u'+447845775449', u'5 Magna Close', u'AL51RH'),
(2, u'Taran', u'Bola', u'2/01/1997', u'+447400832054', u'6 Winfield Place', u'LS23AB'),
(3, u'Dan', u'Aves', u'1/03/1998', u'+447803849940', u'15 Beckett Garden', u'AL69JE'),
(4, u'Matt', u'Cutts', u'9/02/1997', u'+447908858831', u'6 Allister Drive', u'CH630LH')
])

c.executemany("INSERT INTO Card(card_id, card_number, card_expiry, card_cvv, customer_id) VALUES (?, ?, ?, ?, ?)",
[
(1, u'1234123412341234', u'01/20', u'111', 1),
(2, u'0987098709870987', u'01/21', u'222', 2),
(3, u'9876987698769876', u'03/20', u'234', 3),
(4, u'0294387502984375', u'04/19', u'347', 3),
(5, u'2345243676256456', u'09/21', u'087', 2),
(6, u'0234757982245075', u'11/23', u'654', 4)
])

c.executemany("INSERT INTO Film(film_id, film_name, film_description, film_runtime, film_director, film_age_rating) VALUES (?, ?, ?, ?, ?, ?)",
[
(1, u'The Greatest Showman', u'American musical drama film, written by Jenny Bicks and starring Hugh Jackman, Zac Efront, Michelle Williams, Rebecca Ferguson and Zendaya', 120, u'Michael Gracey', u'12'),
(2, u'Black Panther', u'With the King of Wakanda now dead, his son T’Challa must return home to take his rightful place on the throne. But, it’s going to be a bumpy ride, as an evil faction has other plans for the country’s future.', 134, u'Ryan Coogler', u'12'),
(3, u'Coco', u'Ignoring his family’s baffling ban on music, Miguel embarks on a journey through the enchanting Land of the Dead in search of his dreams of becoming a musician.', 105, u'Adrian Molina', u'U'),
(4, u'Downsizing', u'A married couple decide to escape the daily humdrum of modern life by downsizing – a procedure which will see their bodies shrink to 5 inches tall, but their modest savings turn into millions of pounds.', 135, u'Alexander Payne', u'15'),
(5, u'Early Man', u'As the Bronze Age arrives and the Stone Age is over, a determined caveman and his faithful sidekick must fight for his home and the rights of his people. ', 89, u'Nick Park', u'U'),
(6, u'Jumanji: Welcome To THe Jungle', u'When four kids dust off an old video game and begin to play ‘Jumanji’, they quickly realise this is not a normal game. It’s a game of survival, where only the winners return to the real world.', 119, u'Jake Kasdan', u'12'),
(7, u'Darkest Hour', u'The fate of Britain lies on Winston Churchill’s shoulders, in this historical-drama that tells the story of the country’s darkest – and strongest – hours.', 125, u'Joe Wright', u'U'),
(8, u'The Post', u'In June 1971 The New York Times, the Washington Post and the nations major newspapers took a brave stand for freedom of speech and reported on the Pentagon Papers, the massive cover-up of government secrets that spanned four decades and four Presidents.', 116, u'Steven Spielberg', u'12'),
(9, u'Maze Runner: uThe Death Cure', 'The final battle: Thomas must try to find a cure for the disease that has destroyed most of society. Live or die: everything is about to change...', 142, u'Wes Ball', u'12'),
(10, u'Journeys End', u'With Operation Michael in full swing and a battle on the horizon, a group of British soldiers holed up in a dugout in Aisne in 1918 anxiously await their fate.', 107, u'Saul Dibb', u'12')
])

c.executemany("INSERT INTO Screen(screen_id, screen_capacity) VALUES (?, ?)",
[
(1, 55), (2, 55), (3, 55), (4, 55)
])

c.executemany("INSERT INTO Screening(screening_id, screening_time, screening_date, film_id, screen_id) VALUES (?, ?, ?, ?, ?)",
[
(1, u'20:00', u'28/02/18', 1, 1), (2, u'20:00', u'28/02/18', 2, 2), (3, u'20:00', u'28/02/18', 3, 3),
(4, u'20:00', u'28/02/18', 4, 4), (5, u'22:10', u'28/02/18', 5, 1), (6, u'22:30', u'28/02/18', 6, 2),
(7, u'22:20', u'28/02/18', 7, 3), (8, u'22:30', u'28/02/18', 8, 4), (9, u'20:00', u'29/02/18', 9, 1),
(10, u'20:00', u'29/02/18', 9, 2), (11, u'20:00', u'29/02/18', 10, 3), (12, u'20:00', u'29/02/18', 10, 4)
])

c.executemany("INSERT INTO Login(customer_id, login_email, login_password, login_hint) VALUES (?, ?, ?, ?)",
[
(1, u'ben19feb@hotmail.co.uk', u'password', u'Mwhahahahaha'),
(2, u'taranebola@gmail.com', u'yellow', u'asdfasdfasdf'),
(3, u'dannyboi@outlook.com', u'ilovetaran', u'123456789')
])

c.executemany("INSERT INTO Seat(seat_id) VALUES (?)",
[
('1'), ('2'), ('3'), ('4'), ('5'), ('6'), ('7'), ('8'), ('9')
])

c.executemany("INSERT INTO Ticket(ticket_id, screening_id, customer_id, seat_id) VALUES (?, ?, ?, ?)",
[
(1, 1, 1, 10), (2, 1, 1, 11), (3, 1, 1, 12), (4, 1, 2, 5), (5, 1, 2, 4),
(6, 2, 3, 15), (7, 2, 1, 10), (8, 2, 1, 11), (9, 3, 4, 10), (10, 3, 4, 11),
(11, 4, 1, 10), (12, 4, 1, 9), (13, 4, 4, 20), (14, 4, 4, 21), (15, 4, 4, 22)
])

db.commit()
db.close()
