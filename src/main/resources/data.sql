-- INSERT INTO ADDRESS(bairro, cep, cidade, ibge, rua, uf) VALUES ('Nova Santo Amaro', '44200000', 'Santo Amaro', '', 'Rua K', 'BA');
-- INSERT INTO ADDRESS(bairro, cep, cidade, ibge, rua, uf) VALUES ('Verde Vale', '44200000', 'Santo Amaro', '', 'Irma Dulce', 'BA');
-- INSERT INTO ADDRESS(bairro, cep, cidade, ibge, rua, uf) VALUES ('Bairro X', '44200000', 'Santo Amaro', '', 'Rua X', 'BA');
-- INSERT INTO ADDRESS(bairro, cep, cidade, ibge, rua, uf) VALUES ('Bairro Y', '44200000', 'Santo Amaro', '', 'Rua Y', 'BA');
-- INSERT INTO ADDRESS(bairro, cep, cidade, ibge, rua, uf) VALUES ('Bairro Z', '44200000', 'Santo Amaro', '', 'Rua Z', 'BA');
-- INSERT INTO ADDRESS(bairro, cep, cidade, ibge, rua, uf) VALUES ('Bairro 0', '44200000', 'Santo Amaro', '', 'Rua 0', 'BA');
-- INSERT INTO ADDRESS(bairro, cep, cidade, ibge, rua, uf) VALUES ('Bairro 1', '44200000', 'Santo Amaro', '', 'Rua 1', 'BA');

INSERT INTO OCCUPATION(name) VALUES ('Dev');
INSERT INTO OCCUPATION(name) VALUES ('Tester');
INSERT INTO OCCUPATION(name) VALUES ('Devops');

-- INSERT INTO PERSON(age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (19, TO_DATE('03-03-2002', 'MM-DD-YYYY'), 'Male', 'Wanderley', 'Eduardo', 1, 1);
-- INSERT INTO PERSON(age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (19, TO_DATE('06-16-2002', 'MM-DD-YYYY'), 'Female', 'Oliveira', 'Giovana', 2, 2);
-- INSERT INTO PERSON(age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (19, TO_DATE('07-02-1998', 'MM-DD-YYYY'), 'Female', 'Sapecoense', 'Jubiscreide', 3, 3);
-- INSERT INTO PERSON(age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (19, TO_DATE('02-25-1997', 'MM-DD-YYYY'), 'Female', 'Famosa', 'Creudimar', 4, 3);
-- INSERT INTO PERSON(age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Male', 'Guri', 'Dianho', 5, 3);
-- INSERT INTO PERSON(age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Female', 'Alcantra', 'Doroteia', 5, 3);
-- INSERT INTO PERSON(age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Male', 'fumaca', 'Alec', 6, 3);
-- INSERT INTO PERSON(age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Male', 'hondi', 'rinho', 7, 3);

-- INSERT INTO PHONE(number, type, person_id) VALUES ('4984134516', 'personal', 1);
-- INSERT INTO PHONE(number, type, person_id) VALUES ('4984132358', 'personal', 1);
-- INSERT INTO PHONE(number, type, person_id) VALUES ('498413513217', 'home', 1);
-- INSERT INTO PHONE(number, type, person_id) VALUES ('598413515', 'personal', 2);
-- INSERT INTO PHONE(number, type, person_id) VALUES ('1597894123', 'home', 2);

INSERT INTO ROLE (role_name) VALUES ('ADMIN');
INSERT INTO ROLE (role_name) VALUES ('USER');

INSERT INTO USER_SECURITY (id, username, password) VALUES (1, 'admin', '$2a$10$HrJkJc.RqiS/MoTq0MLfQe3A3H.2cQgT/7qbv8AjZlTi2FhGUvrvO');
INSERT INTO USER_SECURITY (id, username, password) VALUES (2, 'user', '$2a$10$KQU6ryviOv0v6rRATM5iqecPbWbIo9g3rjJ05J553TdO0SSxmgCWi');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);