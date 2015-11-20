
-- DROP DATABASE IF EXISTS demo;
-- CREATE DATABASE IF NOT EXISTS demo;
GRANT ALL PRIVILEGES ON *.* TO 'demo'@'localhost' IDENTIFIED BY 'demo' WITH GRANT OPTION;

create table demo.EMPLOYEE (
   id bigint(20) NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);

select * from demo.EMPLOYEE;
