DROP DATABASE IF EXISTS hackathon;
CREATE DATABASE hackathon;
USE hackathon;

CREATE TABLE person(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256)
    );