module add anaconda3/5.0.1
source activate flask
cd website
[ -e app.db ] && rm app.db
python db_create.py
python db_populate.py
