INSERT User (id, email, enabled, password, role, username) VALUES
  (1, 'test@gmail.com', TRUE, '$2a$10$1H1ZxpsA/BrP0w..71Fu2e93w28hiuzSj8DUiZ.7p/BzqUdoQxUS2', 'ROLE_ADMIN', 'admin'),
  (2, 'tester@gamil.com', TRUE, '$2a$10$WMPMRVn/ePex.14FytR.qOkPMjc3uZq8yAWTgI9oEezwirW1WG716', 'ROLE_USER', 'user');

INSERT superior (id, name, department, comment) VALUES
  (1, 'Andreev Alexander Alexandrovich', 'back-end', 'no comment'),
  (2, 'Vovk Miroslav Mihajlovich', 'front-end', 'no comment'),
  (3, 'Barbon Mikola Borisovich', 'QA', 'no comment');

INSERT employee (id, name, department, comment, superior_id) VALUES
  (1, 'Novak Grigoriy Onisimovich', 'back-end', 'no comment', 1),
  (2, 'Pelyp Dmitry Petrovich', 'front-end', 'no comment', 2),
  (3, 'Panas Vladimir Atanasovych', 'QA', 'no comment', 3),
  (4, 'Dmitry Shevchuk Nestorovych', 'back-end', 'no comment', 1),
  (5, 'Yakubovsʹkyy Volodymyr Yosypovych', 'back-end', 'no comment', 1),
  (6, 'Okhrymovych Basil Ostapovych', 'back-end', 'no comment', 1),
  (7, 'Bogdan M. Fedyk', 'front-end', 'no comment', 2),
  (8, 'Husyak Darya Urievna', 'QA', 'no comment', 3),
  (9, 'Vasily Antonovich Brylevskyy', 'back-end', 'no comment', 1);
