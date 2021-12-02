INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (1, 'Nova Santo Amaro', '44200000', 'Santo Amaro', '', 'Rua K', 'BA');
INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (2, 'Verde Vale', '44200000', 'Santo Amaro', '', 'Irma Dulce', 'BA');
INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (3, 'Bairro X', '44200000', 'Santo Amaro', '', 'Rua X', 'BA');
INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (4, 'Bairro Y', '44200000', 'Santo Amaro', '', 'Rua Y', 'BA');
INSERT INTO ADDRESS(id ,bairro, cep, cidade, ibge, rua, uf) VALUES (5, 'Bairro Z', '44200000', 'Santo Amaro', '', 'Rua Z', 'BA');

INSERT INTO OCCUPATION(id, name) VALUES (1, 'Dev');
INSERT INTO OCCUPATION(id, name) VALUES (2, 'Tester');
INSERT INTO OCCUPATION(id, name) VALUES (3, 'Devops');

INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (1, 19, TO_DATE('03-03-2002', 'MM-DD-YYYY'), 'Male', 'Wanderley', 'Eduardo', 1, 1);
INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (2, 19, TO_DATE('06-16-2002', 'MM-DD-YYYY'), 'Female', 'Oliveira', 'Giovana', 2, 2);
INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (3, 19, TO_DATE('07-02-1998', 'MM-DD-YYYY'), 'Female', 'Sapecoense', 'Jubiscreide', 3, 3);
INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (4, 19, TO_DATE('02-25-1997', 'MM-DD-YYYY'), 'Female', 'Famosa', 'Creudimar', 4, 3);
INSERT INTO PERSON(id, age, birth_date, gender , last_name, name, address_id, person_occupation_id) VALUES (5, 19, TO_DATE('06-09-1996', 'MM-DD-YYYY'), 'Male', 'Guri', 'Dianho', 5, 3);

INSERT INTO PHONE(id, number, type, person_id) VALUES (1, '75982074248', 'personal', 1);
INSERT INTO PHONE(id, number, type, person_id) VALUES (2, '75992584632', 'personal', 1);
INSERT INTO PHONE(id, number, type, person_id) VALUES (3, '23411234', 'home', 1);
INSERT INTO PHONE(id, number, type, person_id) VALUES (4, '75991266778', 'personal', 2);
INSERT INTO PHONE(id, number, type, person_id) VALUES (5, '23411234', 'home', 2);