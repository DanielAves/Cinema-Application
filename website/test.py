import os
import unittest
import tempfile
from app import *
from app.models import *


class TestCase(unittest.TestCase):
    def setUp(self):
        app.config['TESTING'] = True
        app.config['WTF_CSRF_ENABLED'] = False
        app.config['DEBUG'] = False
        self.db_fd, app.config['DATABASE'] = tempfile.mkstemp()                                              #initial set up of the testing
        self.app = app.test_client()

    def tearDown(self):
        os.close(self.db_fd)                                #what it gets rid of at the end
        os.unlink(app.config['DATABASE'])

    def test_index(self):
        response = self.app.get('/',follow_redirects=True, content_type='html/text')        #test the index page loads
        self.assertEqual(response.status_code, 200)

    def test_index_correct(self):
        response = self.app.get('/',follow_redirects=True, content_type='html/text')        #test the index page goes to the correct page
        self.assertTrue(b'myCarousel' in response.data)

    def test_card(self):
        response = self.app.get('/card',follow_redirects=True, content_type='html/text')     #tests the /card page loads
        self.assertEqual(response.status_code, 200)

    def test_card_correct(self):
        response = self.app.get('/card',follow_redirects=True, content_type='html/text')     #tests the /card page redirects to the login page
        self.assertTrue(b'Login' in response.data)

    def test_checkout(self):
        response = self.app.get('/checkout/1/1',follow_redirects=True, content_type='html/text')     #tests the /checkout page loads
        self.assertEqual(response.status_code, 200)

    def test_checkout_correct(self):
        response = self.app.get('/checkout/1/1',follow_redirects=True, content_type='html/text')     #tests the /checkout redirects to the login page
        self.assertTrue(b'Login' in response.data)

    def test_login(self):
        response = self.app.get('/login',follow_redirects=True, content_type='html/text')     #tests the /login page loads
        self.assertEqual(response.status_code, 200)

    def test_login_correct(self):
        response = self.app.get('/login',follow_redirects=True, content_type='html/text')     #tests the /login page goes to correct page
        self.assertTrue(b'Login' in response.data)

    def test_movie(self):
        response = self.app.get('/movie/1',follow_redirects=True, content_type='html/text')     #tests the /movie page loads
        self.assertTrue(b'Movie' in response.data)

    def test_movie_correct(self):
        response = self.app.get('/movie/1',follow_redirects=True, content_type='html/text')     #tests the /movie page loads the first movie
        self.assertTrue(b'The Greatest Showman' in response.data)

    def test_myaccount(self):
        response = self.app.get('/myaccount',follow_redirects=True, content_type='html/text')     #tests the /myaccount page loads
        self.assertEqual(response.status_code, 200)

    def test_myaccount_correct(self):
        response = self.app.get('/myaccount',follow_redirects=True, content_type='html/text')     #tests the /myaccount page goes to the correct page
        self.assertTrue(b'Login' in response.data)

    def test_seat(self):
        response = self.app.get('/seatchoice/3',follow_redirects=True, content_type='html/text')     #tests the /seatchoice page loads
        self.assertEqual(response.status_code, 200)

    def test_seat_correct(self):
        response = self.app.get('/seatchoice/137',follow_redirects=True, content_type='html/text')     #tests the /seatchoice page loads
        self.assertTrue(b'Darkest Hour' in response.data)

    def test_signup(self):
        response = self.app.get('/signup',follow_redirects=True, content_type='html/text')     #tests the /signup page loads
        self.assertEqual(response.status_code, 200)

    def test_signup_correct(self):
        response = self.app.get('/signup',follow_redirects=True, content_type='html/text')     #tests the /signup page loads
        self.assertTrue(b'Sign Up' in response.data)

    def test_whatson(self):
        response = self.app.get('/whatson',follow_redirects=True, content_type='html/text')     #tests the /whatson page loads
        self.assertEqual(response.status_code, 200)

    def test_whatson_correct(self):
        response = self.app.get('/whatson',follow_redirects=True, content_type='html/text')     #tests the /whatson page goes to the correct page
        self.assertTrue(b'What is on?' in response.data)

    def test_confirm(self):
        response = self.app.get('/confirm',follow_redirects=True, content_type='html/text')     #tests the /confirm page loads
        self.assertEqual(response.status_code, 200)

    def test_confirm_correct(self):
        response = self.app.get('/confirm',follow_redirects=True, content_type='html/text')     #tests the /confirm page goes to the correct page
        self.assertTrue(b'Enjoy ;)' in response.data)

    def test_invalid_login(self):
        response = self.app.post('/login', data=dict(login="sdfdsfsd", password="dsfdsf"), follow_redirects=True)
        self.assertIn(b'Login', response.data)                                                 #tries to login with an Invalid login

    def test_valid_login(self):
        response = self.app.post('/login', data=dict(login="taran.s.bola@gmail.com",password="yellow"), follow_redirects=True)
        self.assertIn(b'6 Winfield Place', response.data)                                     #logs in with a valid login

    def test_logout(self):
        response = self.app.get('/unsetvariable', follow_redirects=True, content_type='html/text')      #logs you out
        self.assertTrue(b'myCarousel' in response.data)

    def test_valid_search(self):
        response = self.app.post('/search', data=dict(search="the"), follow_redirects=True)             #will test if the correct search results
        self.assertIn(b'The Greatest Showman', response.data)                                           #come when searched

if __name__ == '__main__':
    unittest.main()
