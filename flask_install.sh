# DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd )"
# echo $DIR
module add anaconda3/5.0.1

conda create -n flask python
source activate flask

pip install flask
pip install flask-login
pip install flask-mail
pip install flask-sqlalchemy
pip install sqlalchemy-migrate
pip install flask-whooshalchemy
pip install flask-wtf
pip install coverage
pip install flask-admin
pip install flask-restless
