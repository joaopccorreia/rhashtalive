use rhastalive;

INSERT INTO customer(id, creationTime, updateTime, version, firstName, lastName, vatNumber, email, phone) VALUES
  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Rui', 'Ferrão', 2223423 , 'ruiferrao@gmail.com', 913958877),
  (2, TIMESTAMP '2017-10-10 08:45:56.481', TIMESTAMP '2017-10-10 08:45:56.481', 0, 'Sergio', 'Gouveia',12321,'sergiogouveia@gmail.com', 7788),
  (3, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'Bruno', 'Ferreira', 23432,'brunoferreira@gmail.com', 12412),
  (4, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'No name', 'No last name', 23242354, 'noname@gmail.com', 64567547);

INSERT INTO artist(id, creationTime, updateTime, version, firstName, lastName, artisticName ,vatNumber, email, phone) VALUES
  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Joaquim', 'Almeida', "Jo Jo", 2223423 , 'jojo@gmail.com', 9124);

INSERT INTO user(userName, password, active, customer_id, artist_id) VALUES
  ('rui', 'pass', 1 , 1, 1),
  ('sergio', 'pass',1, 2, 1 ),
  ('bruno', 'pass', 1, 3, 1),
  ('noname', 'pass', 1, 4, 1);

INSERT INTO role(id, creationTime, updateTime, version, name) VALUES
  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'USER'),
  (2, TIMESTAMP '2017-10-10 08:45:56.481', TIMESTAMP '2017-10-10 08:45:56.481', 0, 'ADMIN'),
  (3, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'ARTIST');

INSERT INTO user_role(user_id, role_id) VALUES
  ('rui', 1),
  ('sergio', 1),
  ('rui', 3),
  ('bruno', 2),
  ('noname', 1),
  ('noname', 3);

DELETE FROM shows;
INSERT INTO shows(ID, CREATIONTIME, UPDATETIME, VERSION, NAME, DATE , DURATIONTIME, capacityLimit, description, highlight) VALUES
  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'batata', '2020-04-16', '01:00:00', 20, 'nice show to whats whit all my friends', 0),
  (2, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'dragao', '2020-04-15', '01:00:00', 15,'please more nooooo', 0),
  (3, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'uvas a dançar', '2020-04-17', '01:00:00', 100, 'to see alone', 1),
  (4, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'ricardo rap', '2020-04-16', '01:00:00', 300, 'all by my selfe', 1);