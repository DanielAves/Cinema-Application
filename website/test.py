import os
import unittest
import tempfile
from app import *
from app.models import *


class TestCase(unittest.TestCase):
    def setUp(self):
        self.db_fd, app.config['DATABASE'] = tempfile.mkstemp()
        app.testing = True                                              #initial set up of the testing
        self.app = app.test_client()

    def tearDown(self):
        os.close(self.db_fd)                                #what it gets rid of at the end
        os.unlink(app.config['DATABASE'])

    def test_indexLoads(self):
        response = self.app.get('/',follow_redirects=True, content_type='html/text')        #test the / page
        self.assertEqual(response.status_code, 200)

    def test_aboutus(self):
        response = self.app.get('/aboutus',follow_redirects=True, content_type='html/text')     #tests the /aboutus page loads
        self.assertEqual(response.status_code, 200)

    def test_card(self):
        response = self.app.get('/card',follow_redirects=True, content_type='html/text')     #tests the /card page loads
        self.assertEqual(response.status_code, 200)

    def test_checkout(self):
        response = self.app.get('/checkout/1/1',follow_redirects=True, content_type='html/text')     #tests the /checkout page loads
        self.assertEqual(response.status_code, 200)

    def test_login(self):
        response = self.app.get('/login',follow_redirects=True, content_type='html/text')     #tests the /login page loads
        self.assertEqual(response.status_code, 200)

    def test_movie(self):
        response = self.app.get('/movie/1',follow_redirects=True, content_type='html/text')     #tests the /movie page loads
        self.assertTrue(b'Movie' in response.data)

    def test_myaccount(self):
        response = self.app.get('/myaccount',follow_redirects=True, content_type='html/text')     #tests the /myaccount page loads
        self.assertTrue(b'Login' in response.data)

    def test_seat(self):
        response = self.app.get('/seatchoice/1',follow_redirects=True, content_type='html/text')     #tests the /seatchoice page loads
        self.assertEqual(response.status_code, 200)

    def test_signup(self):
        response = self.app.get('/signup',follow_redirects=True, content_type='html/text')     #tests the /signup page loads
        self.assertEqual(response.status_code, 200)

    def test_whatson(self):
        response = self.app.get('/whatson',follow_redirects=True, content_type='html/text')     #tests the /test page loads
        self.assertTrue(b'What is on?' in response.data)

    def test_invalid_login(self):
        response = self.app.post('/login', data=dict(login="sdfdsfsd", password="dsfdsf"), follow_redirects=True)
        print(response.data)
        self.assertIn(b'Login', response.data)

    def test_valid_login(self):
        response = self.app.post('/login', data=dict(login="taran.s.bola@gmail.com",password="yellow"), follow_redirects=True)
        #print(response.data)
        # is doing login not password
        self.assertIn(b'My Account', response.data)


if __name__ == '__main__':
    unittest.main()
