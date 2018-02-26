# Creates a simple SQLite database for testing
# (NDE, 2017-02-23)

import sqlite3

db = sqlite3.connect("films.db")
c = db.cursor()

c.execute("DROP TABLE IF EXISTS Screening")
c.execute("DROP TABLE IF EXISTS Film")
c.execute("DROP TABLE IF EXISTS Screen")
c.execute("DROP TABLE IF EXISTS Seat")
c.execute("DROP TABLE IF EXISTS Staff")
c.execute("DROP TABLE IF EXISTS StaffLogin")
c.execute("DROP TABLE IF EXISTS Customer")
c.execute("DROP TABLE IF EXISTS Card")
c.execute("DROP TABLE IF EXISTS Login")
c.execute("DROP TABLE IF EXISTS Ticket")



# Publisher
c.execute("""
CREATE TABLE Customer
(
  customer_id INT NOT NULL,
  customer_f_name VARCHAR(20) NOT NULL,
  customer_s_name VARCHAR(30) NOT NULL,
  customer_dob DATE NOT NULL,
  customer_mobile INT NOT NULL,
  customer_address VARCHAR(40) NOT NULL,
  customer_postcode VARCHAR(8) NOT NULL,
  PRIMARY KEY (customer_id),
  UNIQUE (customer_mobile)
);
""")

c.execute("""
CREATE TABLE Card
(
  card_id INT NOT NULL,
  card_number INT NOT NULL,
  card_expiry DATE NOT NULL,
  card_cvv INT NOT NULL,
  customer_id INT NOT NULL,
  PRIMARY KEY (card_id),
  FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
  UNIQUE (card_number)
);
""")

c.execute("""
CREATE TABLE Login
(
  login_email VARCHAR(30) NOT NULL,
  login_pwd VARCHAR(30) NOT NULL,
  login_hint VARCHAR(30),
  customer_id INT NOT NULL,
  PRIMARY KEY (customer_id),
  FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
  UNIQUE (login_email)
);
""")

c.execute("""
CREATE TABLE Ticket
(
  ticket_id INT NOT NULL,
  screening_id INT NOT NULL,
  customer_id INT NOT NULL,
  seat_id INT NOT NULL,
  PRIMARY KEY (ticket_id),
  FOREIGN KEY (screening_id) REFERENCES Screening(screening_id),
  FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
  FOREIGN KEY (seat_id) REFERENCES Seat(seat_id),
  UNIQUE (screening_id, seat_id)
);
""")

c.execute("""
CREATE TABLE Screen
(
  screen_id INT NOT NULL,
  screen_capacity INT,
  PRIMARY KEY (screen_id)
);
""")

c.execute("""
CREATE TABLE Seat
(
  seat_id VARCHAR(3) NOT NULL,
  PRIMARY KEY (seat_id)
);
""")

c.execute("""
CREATE TABLE Screening
(
  screening_id INTEGER PRIMARY KEY,
  screening_date DATE NOT NULL,
  screening_time INTEGER NOT NULL,
  film_id INTEGER NOT NULL,
  screen_id INTEGER NOT NULL,
  FOREIGN KEY (film_id) REFERENCES Film(film_id),
  FOREIGN KEY (screen_id) REFERENCES Screen(screen_id),
  UNIQUE (screen_id, screening_time, screening_date)
);
""")


# Book

c.execute("""
CREATE TABLE Film
(
  film_id INT NOT NULL,
  film_name VARCHAR(30) NOT NULL,
  film_desc VARCHAR(500) NOT NULL,
  film_runtime INT NOT NULL,
  film_director VARCHAR(50) NOT NULL,
  film_age_rating INT NOT NULL,
  PRIMARY KEY (film_id),
  UNIQUE (film_name)
);
""")

c.execute("""
CREATE TABLE Staff
(
  staff_id INT NOT NULL,
  staff_f_name VARCHAR(20) NOT NULL,
  staff_s_name VARCHAR(30) NOT NULL,
  staff_dob DATE NOT NULL,
  staff_mobile INT NOT NULL,
  staff_address VARCHAR(40) NOT NULL,
  staff_postcode VARCHAR(8) NOT NULL,
  staff_NIN INT NOT NULL,
  PRIMARY KEY (staff_id),
  UNIQUE (staff_mobile),
  UNIQUE (staff_NIN)
);
""")

c.execute("""
CREATE TABLE StaffLogin
(
  staff_username VARCHAR(20) NOT NULL,
  staff_password VARCHAR(30) NOT NULL,
  staff_id INT NOT NULL,
  PRIMARY KEY (staff_id),
  FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
  UNIQUE (staff_username)
);
""")

c.executemany("INSERT INTO Film(film_id, film_name, film_desc, film_runtime, film_director, film_age_rating) VALUES (?,?,?,?,?,?)", [
  (1,'The Greatest Showman','American musical drama film, written by Jenny Bicks and starring Hugh Jackman, Zac Efront, Michelle Williams, Rebecca Ferguson and Zendaya',120,'Michael Gracey',12),
  (2, 'Black Panther', 'With the King of Wakanda now dead, his son T’Challa must return home to take his rightful place on the throne. But, it’s going to be a bumpy ride, as an evil faction has other plans for the country’s future.', 134, 'Ryan Coogler', 12),
  (3, 'Coco', 'Ignoring his family’s baffling ban on music, Miguel embarks on a journey through the enchanting Land of the Dead in search of his dreams of becoming a musician.', 105, 'Adrian Molina', 1),
  (4, 'Downsizing', 'A married couple decide to escape the daily humdrum of modern life by downsizing – a procedure which will see their bodies shrink to 5 inches tall, but their modest savings turn into millions of pounds.', 135, 'Alexander Payne', 15),
  (5, 'Early Man', 'As the Bronze Age arrives and the Stone Age is over, a determined caveman and his faithful sidekick must fight for his home and the rights of his people. ', 89, 'Nick Park', 1),
  (6, 'Jumanji: Welcome To THe Jungle', 'When four kids dust off an old video game and begin to play ‘Jumanji’, they quickly realise this is not a normal game. It’s a game of survival, where only the winners return to the real world.', 119, 'Jake Kasdan', 12),
  (7, 'Darkest Hour', 'The fate of Britain lies on Winston Churchill’s shoulders, in this historical-drama that tells the story of the country’s darkest – and strongest – hours.', 125, 'Joe Wright', 1),
  (8, 'The Post', 'In June 1971 The New York Times, the Washington Post and the nations major newspapers took a brave stand for freedom of speech and reported on the Pentagon Papers, the massive cover-up of government secrets that spanned four decades and four Presidents.', 116, 'Steven Spielberg', 12),
  (9, 'Maze Runner: The Death Cure', 'The final battle: Thomas must try to find a cure for the disease that has destroyed most of society. Live or die: everything is about to change...', 142, 'Wes Ball', 12),
  (10, 'Journeys End', 'With Operation Michael in full swing and a battle on the horizon, a group of British soldiers holed up in a dugout in Aisne in 1918 anxiously await their fate. ', 107, 'Saul Dibb', 12)
])

# c.executemany("INSERT INTO Screen(screen_id, screen_capacity) VALUES (?,?)", [
#     (1,50), (2,50), (3,50), (4,50), (4,50), (5,50), (6,50), (7,50), (8,50), (9,50), (10,50),
# ])

# c.executemany("INSERT INTO Seat(seat_id) VALUES (?)", [
#     ('A1'),('A2'),('A3'),('A4'),('A5'),('A6'),('A7'),('A8'),('A9'),('A10'),
#     ('B1'),('B2'),('B3'),('B4'),('B5'),('B6'),('B7'),('B8'),('B9'),('B10'),
#     ('C1'),('C2'),('C3'),('C4'),('C5'),('C6'),('C7'),('C8'),('C9'),('C10'),
#     ('D1'),('D2'),('D3'),('D4'),('D5'),('D6'),('D7'),('D8'),('D9'),('D10'),
#     ('E1'),('E2'),('E3'),('E4'),('E5'),('E6'),('E7'),('E8'),('E9'),('E10')
# ])

c.executemany("INSERT INTO Screening(screen_id, screening_date, screening_time, film_id) VALUES (?,?,?,?)", [
  (1,16/4/18,900,1),(1,16/4/18,1130,2),(1,16/4/18,1330,3),(1,16/4/18,1430,4),(1,16/4/18,1830,5),(1,16/4/18,2030,6),
  (2,16/4/18,900,2),(2,16/4/18,1130,3),(2,16/4/18,1330,4),(2,16/4/18,1430,5),(2,16/4/18,1830,6),(2,16/4/18,2030,7),
  (3,16/4/18,900,3),(3,16/4/18,1130,4),(3,16/4/18,1330,5),(3,16/4/18,1430,6),(3,16/4/18,1830,7),(3,16/4/18,2030,8),
  (4,16/4/18,900,4),(4,16/4/18,1130,5),(4,16/4/18,1330,6),(4,16/4/18,1430,7),(4,16/4/18,1830,8),(4,16/4/18,2030,9),
  (5,16/4/18,900,5),(5,16/4/18,1130,6),(5,16/4/18,1330,7),(5,16/4/18,1430,8),(5,16/4/18,1830,9),(5,16/4/18,2030,10),
  (6,16/4/18,900,6),(6,16/4/18,1130,7),(6,16/4/18,1330,8),(6,16/4/18,1430,9),(6,16/4/18,1830,10),(6,16/4/18,2030,1),
  (7,16/4/18,900,7),(7,16/4/18,1130,8),(7,16/4/18,1330,9),(7,16/4/18,1430,10),(7,16/4/18,1830,1),(7,16/4/18,2030,2),
  (8,16/4/18,900,8),(8,16/4/18,1130,9),(8,16/4/18,1330,10),(8,16/4/18,1430,1),(8,16/4/18,1830,2),(8,16/4/18,2030,3),
  (9,16/4/18,900,9),(9,16/4/18,1130,10),(9,16/4/18,1330,11),(9,16/4/18,1430,2),(9,16/4/18,1830,3),(9,16/4/18,2030,4),
  (10,16/4/18,900,10),(10,16/4/18,1130,11),(10,16/4/18,1330,12),(10,16/4/18,1430,3),(10,16/4/18,1830,4),(10,16/4/18,2030,5),

  (1,17/4/18,900,1),(1,17/4/18,1130,2),(1,17/4/18,1330,3),(1,17/4/18,1430,4),(1,17/4/18,1830,5),(1,17/4/18,2030,6),
  (2,17/4/18,900,2),(2,17/4/18,1130,3),(2,17/4/18,1330,4),(2,17/4/18,1430,5),(2,17/4/18,1830,6),(2,17/4/18,2030,7),
  (3,17/4/18,900,3),(3,17/4/18,1130,4),(3,17/4/18,1330,5),(3,17/4/18,1430,6),(3,17/4/18,1830,7),(3,17/4/18,2030,8),
  (4,17/4/18,900,4),(4,17/4/18,1130,5),(4,17/4/18,1330,6),(4,17/4/18,1430,7),(4,17/4/18,1830,8),(4,17/4/18,2030,9),
  (5,17/4/18,900,5),(5,17/4/18,1130,6),(5,17/4/18,1330,7),(5,17/4/18,1430,8),(5,17/4/18,1830,9),(5,17/4/18,2030,10),
  (6,17/4/18,900,6),(6,17/4/18,1130,7),(6,17/4/18,1330,8),(6,17/4/18,1430,9),(6,17/4/18,1830,10),(6,17/4/18,2030,1),
  (7,17/4/18,900,7),(7,17/4/18,1130,8),(7,17/4/18,1330,9),(7,17/4/18,1430,10),(7,17/4/18,1830,1),(7,17/4/18,2030,2),
  (8,17/4/18,900,8),(8,17/4/18,1130,9),(8,17/4/18,1330,10),(8,17/4/18,1430,1),(8,17/4/18,1830,2),(8,17/4/18,2030,3),
  (9,17/4/18,900,9),(9,17/4/18,1130,10),(9,17/4/18,1330,11),(9,17/4/18,1430,2),(9,17/4/18,1830,3),(9,17/4/18,2030,4),
  (10,17/4/18,900,10),(10,17/4/18,1130,11),(10,17/4/18,1330,12),(10,17/4/18,1430,3),(10,17/4/18,1830,4),(10,17/4/18,2030,5),

  (1,18/4/18,900,1),(1,18/4/18,1130,2),(1,18/4/18,1330,3),(1,18/4/18,1430,4),(1,18/4/18,1830,5),(1,18/4/18,2030,6),
  (2,18/4/18,900,2),(2,18/4/18,1130,3),(2,18/4/18,1330,4),(2,18/4/18,1430,5),(2,18/4/18,1830,6),(2,18/4/18,2030,7),
  (3,18/4/18,900,3),(3,18/4/18,1130,4),(3,18/4/18,1330,5),(3,18/4/18,1430,6),(3,18/4/18,1830,7),(3,18/4/18,2030,8),
  (4,18/4/18,900,4),(4,18/4/18,1130,5),(4,18/4/18,1330,6),(4,18/4/18,1430,7),(4,18/4/18,1830,8),(4,18/4/18,2030,9),
  (5,18/4/18,900,5),(5,18/4/18,1130,6),(5,18/4/18,1330,7),(5,18/4/18,1430,8),(5,18/4/18,1830,9),(5,18/4/18,2030,10),
  (6,18/4/18,900,6),(6,18/4/18,1130,7),(6,18/4/18,1330,8),(6,18/4/18,1430,9),(6,18/4/18,1830,10),(6,18/4/18,2030,1),
  (7,18/4/18,900,7),(7,18/4/18,1130,8),(7,18/4/18,1330,9),(7,18/4/18,1430,10),(7,18/4/18,1830,1),(7,18/4/18,2030,2),
  (8,18/4/18,900,8),(8,18/4/18,1130,9),(8,18/4/18,1330,10),(8,18/4/18,1430,1),(8,18/4/18,1830,2),(8,18/4/18,2030,3),
  (9,18/4/18,900,9),(9,18/4/18,1130,10),(9,18/4/18,1330,11),(9,18/4/18,1430,2),(9,18/4/18,1830,3),(9,18/4/18,2030,4),
  (10,18/4/18,900,10),(10,18/4/18,1130,11),(10,18/4/18,1330,12),(10,18/4/18,1430,3),(10,18/4/18,1830,4),(10,18/4/18,2030,5),

  (1,19/4/18,900,1),(1,19/4/18,1130,2),(1,19/4/18,1330,3),(1,19/4/18,1430,4),(1,19/4/18,1830,5),(1,19/4/18,2030,6),
  (2,19/4/18,900,2),(2,19/4/18,1130,3),(2,19/4/18,1330,4),(2,19/4/18,1430,5),(2,19/4/18,1830,6),(2,19/4/18,2030,7),
  (3,19/4/18,900,3),(3,19/4/18,1130,4),(3,19/4/18,1330,5),(3,19/4/18,1430,6),(3,19/4/18,1830,7),(3,19/4/18,2030,8),
  (4,19/4/18,900,4),(4,19/4/18,1130,5),(4,19/4/18,1330,6),(4,19/4/18,1430,7),(4,19/4/18,1830,8),(4,19/4/18,2030,9),
  (5,19/4/18,900,5),(5,19/4/18,1130,6),(5,19/4/18,1330,7),(5,19/4/18,1430,8),(5,19/4/18,1830,9),(5,19/4/18,2030,10),
  (6,19/4/18,900,6),(6,19/4/18,1130,7),(6,19/4/18,1330,8),(6,19/4/18,1430,9),(6,19/4/18,1830,10),(6,19/4/18,2030,1),
  (7,19/4/18,900,7),(7,19/4/18,1130,8),(7,19/4/18,1330,9),(7,19/4/18,1430,10),(7,19/4/18,1830,1),(7,19/4/18,2030,2),
  (8,19/4/18,900,8),(8,19/4/18,1130,9),(8,19/4/18,1330,10),(8,19/4/18,1430,1),(8,19/4/18,1830,2),(8,19/4/18,2030,3),
  (9,19/4/18,900,9),(9,19/4/18,1130,10),(9,19/4/18,1330,11),(9,19/4/18,1430,2),(9,19/4/18,1830,3),(9,19/4/18,2030,4),
  (10,19/4/18,900,10),(10,19/4/18,1130,11),(10,19/4/18,1330,12),(10,19/4/18,1430,3),(10,19/4/18,1830,4),(10,19/4/18,2030,5),

  (1,20/4/18,900,1),(1,20/4/18,1130,2),(1,20/4/18,1330,3),(1,20/4/18,1430,4),(1,20/4/18,1830,5),(1,20/4/18,2030,6),
  (2,20/4/18,900,2),(2,20/4/18,1130,3),(2,20/4/18,1330,4),(2,20/4/18,1430,5),(2,20/4/18,1830,6),(2,20/4/18,2030,7),
  (3,20/4/18,900,3),(3,20/4/18,1130,4),(3,20/4/18,1330,5),(3,20/4/18,1430,6),(3,20/4/18,1830,7),(3,20/4/18,2030,8),
  (4,20/4/18,900,4),(4,20/4/18,1130,5),(4,20/4/18,1330,6),(4,20/4/18,1430,7),(4,20/4/18,1830,8),(4,20/4/18,2030,9),
  (5,20/4/18,900,5),(5,20/4/18,1130,6),(5,20/4/18,1330,7),(5,20/4/18,1430,8),(5,20/4/18,1830,9),(5,20/4/18,2030,10),
  (6,20/4/18,900,6),(6,20/4/18,1130,7),(6,20/4/18,1330,8),(6,20/4/18,1430,9),(6,20/4/18,1830,10),(6,20/4/18,2030,1),
  (7,20/4/18,900,7),(7,20/4/18,1130,8),(7,20/4/18,1330,9),(7,20/4/18,1430,10),(7,20/4/18,1830,1),(7,20/4/18,2030,2),
  (8,20/4/18,900,8),(8,20/4/18,1130,9),(8,20/4/18,1330,10),(8,20/4/18,1430,1),(8,20/4/18,1830,2),(8,20/4/18,2030,3),
  (9,20/4/18,900,9),(9,20/4/18,1130,10),(9,20/4/18,1330,11),(9,20/4/18,1430,2),(9,20/4/18,1830,3),(9,20/4/18,2030,4),
  (10,20/4/18,900,10),(10,20/4/18,1130,11),(10,20/4/18,1330,12),(10,20/4/18,1430,3),(10,20/4/18,1830,4),(10,20/4/18,2030,5),

  (1,21/4/18,900,1),(1,21/4/18,1130,2),(1,21/4/18,1330,3),(1,21/4/18,1430,4),(1,21/4/18,1830,5),(1,21/4/18,2030,6),
  (2,21/4/18,900,2),(2,21/4/18,1130,3),(2,21/4/18,1330,4),(2,21/4/18,1430,5),(2,21/4/18,1830,6),(2,21/4/18,2030,7),
  (3,21/4/18,900,3),(3,21/4/18,1130,4),(3,21/4/18,1330,5),(3,21/4/18,1430,6),(3,21/4/18,1830,7),(3,21/4/18,2030,8),
  (4,21/4/18,900,4),(4,21/4/18,1130,5),(4,21/4/18,1330,6),(4,21/4/18,1430,7),(4,21/4/18,1830,8),(4,21/4/18,2030,9),
  (5,21/4/18,900,5),(5,21/4/18,1130,6),(5,21/4/18,1330,7),(5,21/4/18,1430,8),(5,21/4/18,1830,9),(5,21/4/18,2030,10),
  (6,21/4/18,900,6),(6,21/4/18,1130,7),(6,21/4/18,1330,8),(6,21/4/18,1430,9),(6,21/4/18,1830,10),(6,21/4/18,2030,1),
  (7,21/4/18,900,7),(7,21/4/18,1130,8),(7,21/4/18,1330,9),(7,21/4/18,1430,10),(7,21/4/18,1830,1),(7,21/4/18,2030,2),
  (8,21/4/18,900,8),(8,21/4/18,1130,9),(8,21/4/18,1330,10),(8,21/4/18,1430,1),(8,21/4/18,1830,2),(8,21/4/18,2030,3),
  (9,21/4/18,900,9),(9,21/4/18,1130,10),(9,21/4/18,1330,11),(9,21/4/18,1430,2),(9,21/4/18,1830,3),(9,21/4/18,2030,4),
  (10,21/4/18,900,10),(10,21/4/18,1130,11),(10,21/4/18,1330,12),(10,21/4/18,1430,3),(10,21/4/18,1830,4),(10,21/4/18,2030,5),

  (1,22/4/18,900,1),(1,22/4/18,1130,2),(1,22/4/18,1330,3),(1,22/4/18,1430,4),(1,22/4/18,1830,5),(1,22/4/18,2030,6),
  (2,22/4/18,900,2),(2,22/4/18,1130,3),(2,22/4/18,1330,4),(2,22/4/18,1430,5),(2,22/4/18,1830,6),(2,22/4/18,2030,7),
  (3,22/4/18,900,3),(3,22/4/18,1130,4),(3,22/4/18,1330,5),(3,22/4/18,1430,6),(3,22/4/18,1830,7),(3,22/4/18,2030,8),
  (4,22/4/18,900,4),(4,22/4/18,1130,5),(4,22/4/18,1330,6),(4,22/4/18,1430,7),(4,22/4/18,1830,8),(4,22/4/18,2030,9),
  (5,22/4/18,900,5),(5,22/4/18,1130,6),(5,22/4/18,1330,7),(5,22/4/18,1430,8),(5,22/4/18,1830,9),(5,22/4/18,2030,10),
  (6,22/4/18,900,6),(6,22/4/18,1130,7),(6,22/4/18,1330,8),(6,22/4/18,1430,9),(6,22/4/18,1830,10),(6,22/4/18,2030,1),
  (7,22/4/18,900,7),(7,22/4/18,1130,8),(7,22/4/18,1330,9),(7,22/4/18,1430,10),(7,22/4/18,1830,1),(7,22/4/18,2030,2),
  (8,22/4/18,900,8),(8,22/4/18,1130,9),(8,22/4/18,1330,10),(8,22/4/18,1430,1),(8,22/4/18,1830,2),(8,22/4/18,2030,3),
  (9,22/4/18,900,9),(9,22/4/18,1130,10),(9,22/4/18,1330,11),(9,22/4/18,1430,2),(9,22/4/18,1830,3),(9,22/4/18,2030,4),
  (10,22/4/18,900,10),(10,22/4/18,1130,11),(10,22/4/18,1330,12),(10,22/4/18,1430,3),(10,22/4/18,1830,4),(10,22/4/18,2030,5)
])

# c.executemany("INSERT INTO Staff(staff_id, staff_f_name, staff_s_name, staff_dob) VALUES (?,?,?,?)", [
#     (1,"Matt", "Cutts", 9/2/97 ),
#     (2,"Dan", "Aves", 1/3/98 ),
#     (3,"Ben", "Ashby", 19/2/96 ),
#     (4,"Taran", "Bola", 6/1/97 ),
#     (5,"Mitchel", "Gladstone", 20/12/97 ),
#     (6,"Qasim", "Hussain", 1/1/97 ),
# ])
#
# c.executemany("INSERT INTO StaffLogin(staff_username, staff_password) VALUES (?,?,?)", [
#     ("m.cutts", "123", 1), ("d.aves", "123", 2), ("b.ashby","123",3), ("t.bola","123",4), ("m.gladstone","123",5), ("q.hussain","123",6)
# ])

db.commit()
db.close()
