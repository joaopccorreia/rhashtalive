DROP DATABASE IF EXISTS rhastalive;
CREATE DATABASE rhastalive;
USE rhastalive;

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
    phone integer unique not null
);

CREATE TABLE customer(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    firstName VARCHAR(256) not null,
    lastName VARCHAR(256) not null,
    vatNumber varchar(256) not null unique,
    email varchar(256) not null,
    phone integer not null
);

CREATE TABLE user (
    userName VARCHAR(256) Primary Key,
    password VARCHAR(256) not null,
    active BIT not null default 1,
    customer_id integer,
    artist_id integer,

    foreign key (customer_id) references customer(id) ON UPDATE CASCADE,
    foreign key (artist_id) references artist(id) ON UPDATE CASCADE
);

CREATE TABLE role (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    name VARCHAR(256) not null
);

CREATE TABLE address(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp,
    updateTime timestamp,
    version integer,
    address varchar(256) not null,
    zipCode varchar(256) not null,
    city varchar(256) not null,
    country varchar(256) not null,
    customer_id integer,
    artist_id integer,

    foreign key (customer_id) references customer(id) ON UPDATE CASCADE,
    foreign key (artist_id) references artist(id) ON UPDATE CASCADE
    );


CREATE TABLE shows(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp,
    updateTime timestamp,
    version integer,
    name varchar(256) not null,
    date date not null,
    durationTime integer not null,
    capacityLimit integer not null,
    description varchar(256) not null,
    highlight BIT not null default 0,
    thumbnail varchar(256),
    link varchar(256)
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
    isActive BIT not null default 1,
    show_id integer,

    FOREIGN key (show_id) references shows(id)
);

CREATE TABLE user_role (
	user_id varchar(256),
    role_id integer,

    foreign key (user_id) references user(userName),
    foreign key (role_id) references role(id)
);

CREATE TABLE customer_product (
	customer_id integer,
    product_id integer,

    foreign key (customer_id) references customer(id),
    foreign key (product_id) references product(id)
);