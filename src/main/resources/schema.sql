create table employee(
    id int not null auto_increment,
    first_name varchar(60),
    last_name varchar(60),
    email varchar(60),
    phone_number varchar(60),
    salary float,
    primary key (id)
);