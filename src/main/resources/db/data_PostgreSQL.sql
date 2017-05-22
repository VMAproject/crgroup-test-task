INSERT INTO "user" (id, email, enabled, password, role, username) VALUES
  (1, 'admin@jordanec.com', TRUE, '$2a$10$0sDyWkFXQj7PQVXsjijg6O4O2clhfyjpvSwmouaCgBUypJTqKsipG', 'ROLE_ADMIN',
   'admin'),
  (2, 'user@jordanec.com', TRUE, '$2a$10$oj9OJwL6ww.ADlG4wefYbern8k0AJSbKplBkzdRQOCRDhDzULdxMK', 'ROLE_USER', 'user');

INSERT INTO superior (id, name, department, comment) VALUES
  (1, 'Andreev Alexander Alexandrovich', 'back-end', 'no comment'),
  (2, 'Vovk Miroslav Mihajlovich', 'front-end', 'no comment'),
  (3, 'Barbon Mikola Borisovich', 'QA', 'no comment');

INSERT INTO employee (id, name, department, comment, superior_id) VALUES
  (1, 'Novak Grigoriy Onisimovich', 'back-end', 'no comment', 1),
  (2, 'Pelyp Dmitry Petrovich', 'front-end', 'no comment', 2),
  (3, 'Panas Vladimir Atanasovych', 'QA', 'no comment', 3),
  (4, 'Dmitry Shevchuk Nestorovych', 'back-end', 'no comment', 1),
  (5, 'Yakubovsʹkyy Volodymyr Yosypovych', 'back-end', 'no comment', 1),
  (6, 'Okhrymovych Basil Ostapovych', 'back-end', 'no comment', 1),
  (7, 'Bogdan M. Fedyk', 'front-end', 'no comment', 2),
  (8, 'Husyak Darya Urievna', 'QA', 'no comment', 3),
  (9, 'Vasily Antonovich Brylevskyy', 'back-end', 'no comment', 1);