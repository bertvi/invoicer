DROP DATABASE invoicer;
DROP USER invoicer;
CREATE USER invoicer WITH PASSWORD 'invoicer';
CREATE DATABASE invoicer WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE ='en_US.UTF-8' OWNER invoicer;