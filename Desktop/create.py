# Creates a simple SQLite database for testing
# (NDE, 2017-02-23)

import sqlite3

db = sqlite3.connect("films.db")
c = db.cursor()

c.execute("DROP TABLE IF EXISTS Screening")
c.execute("DROP TABLE IF EXISTS Film")

# Publisher



c.execute("""
CREATE TABLE Screening (
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
CREATE TABLE Film (
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

c.executemany("INSERT INTO Film(film_id, film_name, film_desc, film_runtime, film_director, film_age_rating) VALUES (?,?,?,?,?,?)", [
  (1,'The Greatest Showman','American musical drama film, written by Jenny Bicks and starring Hugh Jackman, Zac Efront, Michelle Williams, Rebecca Ferguson and Zendaya',120,'Michael Gracey',12),

])

db.commit()
db.close()
