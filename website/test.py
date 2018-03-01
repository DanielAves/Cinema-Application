import os
import unittest
import tempfile
from app import *


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
        response = self.app.get('/checkout',follow_redirects=True, content_type='html/text')     #tests the /checkout page loads
        self.assertEqual(response.status_code, 200)

    def test_login(self):
        response = self.app.get('/login',follow_redirects=True, content_type='html/text')     #tests the /login page loads
        self.assertEqual(response.status_code, 200)

    def test_movie(self):
        response = self.app.get('/moviepage',follow_redirects=True, content_type='html/text')     #tests the /movie page loads
        self.assertEqual(response.status_code, 200)

    def test_myaccount(self):
        response = self.app.get('/myaccount',follow_redirects=True, content_type='html/text')     #tests the /myaccount page loads
        self.assertEqual(response.status_code, 200)

    def test_seat(self):
        response = self.app.get('/seatchoice',follow_redirects=True, content_type='html/text')     #tests the /seatchoice page loads
        self.assertEqual(response.status_code, 200)

    def test_signup(self):
        response = self.app.get('/signup',follow_redirects=True, content_type='html/text')     #tests the /signup page loads
        self.assertEqual(response.status_code, 200)

    def test_whatson(self):
        response = self.app.get('/whatson',follow_redirects=True, content_type='html/text')     #tests the /test page loads
        self.assertEqual(response.status_code, 200)

if __name__ == '__main__':
    unittest.main()
