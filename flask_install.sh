# DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd )"
# echo $DIR
module add python/3.4.3
cd website
virtualenv flask
source flask/bin/activate

flask/bin/pip install flask
flask/bin/pip install flask-login
flask/bin/pip install flask-mail
flask/bin/pip install flask-sqlalchemy
flask/bin/pip install sqlalchemy-migrate
flask/bin/pip install flask-whooshalchemy
flask/bin/pip install flask-wtf
flask/bin/pip install flask-babel
flask/bin/pip install coverage
flask/bin/pip install flask-admin

python run.py
