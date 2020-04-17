use rhastalive;

INSERT INTO customer(id, creationTime, updateTime, version, firstName, lastName, vatNumber, email, phone) VALUES

  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Fabio', 'Veloso', 2223423 , 'fabioveloso@gmail.com', 913958877),
  (2, TIMESTAMP '2017-10-10 08:45:56.481', TIMESTAMP '2017-10-10 08:45:56.481', 0, 'João', 'Gouveia',12321,'joao@gmail.com', 7788),
  (3, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'Tiago', 'Ferreira', 23432,'tiago@gmail.com', 12412),
  (4, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'Diego', 'No last name', 23242354, 'diego@gmail.com', 64567547),
  (5, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'Paulo', 'Sousa', 33242354, 'paulosousa@gmail.com', 6567547);

INSERT INTO artist(id, creationTime, updateTime, version, firstName, lastName, artisticName ,vatNumber, email, phone) VALUES
(1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Joaquim', 'Almeida', "Jo Jo", 2223423 , 'jojo@gmail.com', 9124);

INSERT INTO user(userName, password, active, customer_id, artist_id) VALUES

  ('Fabio', 'pass', 1 , 1, 1),
  ('João', 'pass',1, 2, 1 ),
  ('Tiago', 'pass', 1, 3, 1),
  ('Diego', 'pass', 1, 4, 1),
  ('Paulo', 'pass', 1, 5, 1);



INSERT INTO role(id, creationTime, updateTime, version, name) VALUES
(1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'USER'),
(2, TIMESTAMP '2017-10-10 08:45:56.481', TIMESTAMP '2017-10-10 08:45:56.481', 0, 'ADMIN'),
(3, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'ARTIST');

INSERT INTO user_role(user_id, role_id) VALUES
  ('fabio', 1),
  ('joao', 1),
  ('tiago', 3),
  ('diego', 2),
  ('paulo', 1);



DELETE FROM shows;
INSERT INTO shows(ID, CREATIONTIME, UPDATETIME, VERSION, NAME, DATE , DURATIONTIME, capacityLimit, description, highlight, thumbnail) VALUES
  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'Queen', '2020-04-20', 1, 200, 'nice show to whats whit all my friends', 0, 'https://4.bp.blogspot.com/-1t8xbeOjfCs/T6eaGEeyf1I/AAAAAAAAA_A/fAdG9dEvc_s/s1600/queen-union-jack-t-shirt-hr.jpg'),
  (2, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'AC-DC', '2020-04-19', 1, 150,'please more nooooo', 0,'https://i.ebayimg.com/images/i/173595953512-0-1/s-l1000.jpg'),
  (3, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'Beyonce', '2020-04-18', 1, 300, 'to see alone', 1, 'http://static.gigwise.com/artists/Beyonce2014TourPost600.jpg'),
  (4, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'Quim Barreiros', '2020-04-18', 1, 100, 'all by my selfe', 1, 'https://2.bp.blogspot.com/-mX7sVJM8mS0/UkcQfjEVN0I/AAAAAAAAAAs/oE8tbmS4IcM/s1600/kimd.png'),
  (5, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'Chico da Tina', '2020-04-17', 1, 30, 'nice show to whats whit all my friends', 0, 'https://www.branditmusic.com/wp-content/uploads/2020/01/chico-da-tina-minho-trapstar-1024x1024.jpg'),
  (6, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 'Metallica', '2020-04-17', 1, 30,'please more nooooo', 0,'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fen.metal-tracker.com%2Ftorrents%2Fimages%2F1515410.jpg&f=1&nofb=1');


INSERT INTO product(id, creationTime, updateTime, version, name, availableQuantity, availableDate, productType, isActive, show_id) VALUES
(1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Metalica', 500, '2020-04-18', 'TICKET', 1, 1),
(2, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'U2', 1000, '2020-04-17', 'TICKET', 1, 2),
(3, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Pink Floyd', 2000, '2020-04-25', 'TICKET', 1, 3),
(4, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Led Zeplin', 100, '2020-05-16', 'TICKET', 1, 4);

INSERT INTO customer_product(customer_id, product_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);

