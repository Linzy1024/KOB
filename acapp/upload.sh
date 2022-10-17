scp dist/js/*.js kobimage:/home/linzy/kob/acapp/
scp dist/css/*.css kobimage:/home/linzy/kob/acapp/

ssh kobimage 'cd /home/linzy/kob/acapp && ./rename.sh'
