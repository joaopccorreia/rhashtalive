DROP DATABASE IF EXISTS rhastalive;
CREATE DATABASE rhastalive;
USE rhastalive;

CREATE TABLE user (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    userName VARCHAR(256) not null,
    password VARCHAR(256) not null,
    active BIT not null default 1,
    role_id varchar(256) not null,

    foreign key (role_id) references role(id)
);

CREATE TABLE role (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    name VARCHAR(256) not null,
    user_id varchar(256) not null,

    foreign key (user_id) references user(id)
);

CREATE TABLE artist(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    firstName VARCHAR(256) not null,
    lastName VARCHAR(256) not null,
    artisticName varchar(256) not null,
    vatNumber varchar(256) not null unique,
    email varchar(256) not null,
    password varchar(256) not null,
    phone integer unique not null,
    active BIT not null default 1,
    roles varchar(256) not null
);

CREATE TABLE customer(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp,
    updateTime timestamp,
    version integer,
    firstName VARCHAR(256) not null,
    lastName VARCHAR(256) not null,
    vatNumber varchar(256) unique,
    email varchar(256) not null,
    password varchar(256) not null,
    phone integer,
    active BIT not null default 1,
    roles varchar(256) not null
);

CREATE TABLE address(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp,
    updateTime timestamp,
    version integer,
    address varchar(256) not null,
    zipcode varchar(256) not null,
    city varchar(256) not null,
    country varchar(256) not null,
    customer_id integer,
    artist_id integer,

    foreign key (customer_id) references customer(id),
    foreign key (artist_id) references artist(id)
    );

CREATE TABLE shows(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp,
    updateTime timestamp,
    version integer,
    name varchar(256) not null,
    date date not null,
    durationTime time not null,
    capacityLimit integer not null,
    highlight BIT not null default 0
    );

create table product (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp,
    updateTime timestamp,
    version integer,
    name varchar(256) not null,
    availableQuantity integer not null,
    availableDate date not null,
    productType varchar(256) not null,
    isActive BIT not null default 1
    );
