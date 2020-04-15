DROP DATABASE IF EXISTS rhastalive;
CREATE DATABASE rhastalive;
USE rhastalive;

CREATE TABLE address(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    address varchar(256) not null,
    zipcode varchar(256) not null,
    city varchar(256) not null,
    country varchar(256) not null
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
    address_id integer not null,

    foreign key (address_id) references address(id)
    );

CREATE TABLE customer(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    firstName VARCHAR(256) not null,
    lastName VARCHAR(256) not null,
    vatNumber varchar(256) unique,
    email varchar(256) not null,
    password varchar(256) not null,
    phone integer,
    address_id integer,

    foreign key (address_id) references address(id)
    );

CREATE TABLE shows(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    name varchar(256) not null,
    date date not null,
    durationTime time not null,
    capacityLimit integer not null
    );

create table product (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    name varchar(256) not null,
    availableQuantity integer not null,
    availableDate time not null,
    productType varchar(256) not null
    );