-- INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (1,'Nova Santo Amaro', '44200000', 'Santo Amaro', '', 'Rua K', 'BA');
-- INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (2, 'Verde Vale', '44200000', 'Santo Amaro', '', 'Irma Dulce', 'BA');
-- INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (3, 'Bairro X', '44200000', 'Santo Amaro', '', 'Rua X', 'BA');
-- INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (4, 'Bairro Y', '44200000', 'Santo Amaro', '', 'Rua Y', 'BA');
-- INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (5, 'Bairro Z', '44200000', 'Santo Amaro', '', 'Rua Z', 'BA');
-- INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (6, 'Bairro 0', '44200000', 'Santo Amaro', '', 'Rua 0', 'BA');
-- INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (7, 'Bairro 1', '44200000', 'Santo Amaro', '', 'Rua 1', 'BA');

INSERT INTO OCCUPATION(id, name) VALUES (1, 'Dev');
INSERT INTO OCCUPATION(id, name) VALUES (2, 'Tester');
INSERT INTO OCCUPATION(id, name) VALUES (3, 'Devops');

-- INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (1, 19, TO_DATE('03-03-2002', 'MM-DD-YYYY'), 'Male', 'Wanderley', 'Eduardo', 1, 1);
-- INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (2, 19, TO_DATE('06-16-2002', 'MM-DD-YYYY'), 'Female', 'Oliveira', 'Giovana', 2, 2);
-- INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (3, 19, TO_DATE('07-02-1998', 'MM-DD-YYYY'), 'Female', 'Sapecoense', 'Jubiscreide', 3, 3);
-- INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (4, 19, TO_DATE('02-25-1997', 'MM-DD-YYYY'), 'Female', 'Famosa', 'Creudimar', 4, 3);
-- INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (5, 19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Male', 'Guri', 'Dianho', 5, 3);
-- INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (6, 19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Female', 'Alcantra', 'Doroteia', 5, 3);
-- INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (7, 19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Male', 'fumaca', 'Alec', 6, 3);
-- INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (8, 19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Male', 'hondi', 'rinho', 7, 3);

-- INSERT INTO PHONE(id, number, type, person_id) VALUES (1, '4984134516', 'personal', 1);
-- INSERT INTO PHONE(id, number, type, person_id) VALUES (2, '4984132358', 'personal', 1);
-- INSERT INTO PHONE(id, number, type, person_id) VALUES (3, '498413513217', 'home', 1);
-- INSERT INTO PHONE(id, number, type, person_id) VALUES (4, '598413515', 'personal', 2);
-- INSERT INTO PHONE(id, number, type, person_id) VALUES (5, '1597894123', 'home', 2);

INSERT INTO ROLE (role_name) VALUES ('ADMIN');
INSERT INTO ROLE (role_name) VALUES ('USER');

INSERT INTO USER_SECURITY (id, username, password) VALUES (1, 'admin', '$2a$10$HrJkJc.RqiS/MoTq0MLfQe3A3H.2cQgT/7qbv8AjZlTi2FhGUvrvO');
INSERT INTO USER_SECURITY (id, username, password) VALUES (2, 'user', '$2a$10$KQU6ryviOv0v6rRATM5iqecPbWbIo9g3rjJ05J553TdO0SSxmgCWi');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);