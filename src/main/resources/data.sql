INSERT INTO user_roles (name) VALUES ('ADMIN');
INSERT INTO user_roles (name) VALUES ('DEV');
INSERT INTO user_roles (name) VALUES ('BASIC_USER');
INSERT INTO user_roles (name) VALUES ('PREMIUM_USER');
INSERT INTO user_roles (name) VALUES ('LOCKED');

INSERT INTO app_users (username, password, first_name, last_name, role_id, email, confirmed) VALUES ('wsingleton', 'revature', 'Wezley', 'Singleton', 1, 'wezley.singleton@revature.com', 1);
INSERT INTO app_users (username, password, first_name, last_name, role_id, email, confirmed) VALUES ('rconnell', 'rolltide', 'Robert', 'Connell', 1, 'robert.connell@revature.com', 1);
INSERT INTO app_users (username, password, first_name, last_name, role_id, email, confirmed) VALUES ('skelsey', 'revasteve', 'Steven', 'Kelsey', 2, 'steven.kelsey@revature.com', 1);
INSERT INTO app_users (username, password, first_name, last_name, role_id, email, confirmed) VALUES ('mknighten', 'knifehand', 'Jason', 'Knighten', 3, 'jason.knighten@revature.com', 1);
INSERT INTO app_users (username, password, first_name, last_name, role_id, email, confirmed) VALUES ('bkruppa', 'revature', 'Blake', 'Kruppa', 4, 'blake.kruppa@revature.com', 1);
INSERT INTO app_users (username, password, first_name, last_name, role_id, email, confirmed) VALUES ('trolluser', 'banned', 'Eric', 'Cartman', 5, 'eric.cartman@gmail.com', 1);

INSERT INTO categories (name) VALUES ('Core Java');
INSERT INTO categories (name) VALUES ('Java Threads');
INSERT INTO categories (name) VALUES ('Java Reflection');
INSERT INTO categories (name) VALUES ('Java Collections');
INSERT INTO categories (name) VALUES ('Java Streams');
INSERT INTO categories (name) VALUES ('Oracle SQL');
INSERT INTO categories (name) VALUES ('PostgreSQL');
INSERT INTO categories (name) VALUES ('Oracle PL/SQL');
INSERT INTO categories (name) VALUES ('Postgre PL/pgSQL');
INSERT INTO categories (name) VALUES ('JDBC');
INSERT INTO categories (name) VALUES ('HTML');
INSERT INTO categories (name) VALUES ('CSS');
INSERT INTO categories (name) VALUES ('Core JavaScript');
INSERT INTO categories (name) VALUES ('JavaScript DOM Manipulation');
INSERT INTO categories (name) VALUES ('AJAX');
INSERT INTO categories (name) VALUES ('Fetch API');
INSERT INTO categories (name) VALUES ('Axios');
INSERT INTO categories (name) VALUES ('Java Servlets');
INSERT INTO categories (name) VALUES ('TypeScript');
INSERT INTO categories (name) VALUES ('Node.js');
INSERT INTO categories (name) VALUES ('Angular');
INSERT INTO categories (name) VALUES ('React');
INSERT INTO categories (name) VALUES ('Redux');
INSERT INTO categories (name) VALUES ('Express');
INSERT INTO categories (name) VALUES ('AWS Cloud');
INSERT INTO categories (name) VALUES ('MS Azure Cloud');
INSERT INTO categories (name) VALUES ('DevOps Principles');
INSERT INTO categories (name) VALUES ('Jenkins');
INSERT INTO categories (name) VALUES ('Containerization');
INSERT INTO categories (name) VALUES ('Container Orchestration');
INSERT INTO categories (name) VALUES ('Hibernate');
INSERT INTO categories (name) VALUES ('Core Spring Framework');
INSERT INTO categories (name) VALUES ('Spring Boot');
INSERT INTO categories (name) VALUES ('Spring Data');
INSERT INTO categories (name) VALUES ('Service Oriented Architecture');
INSERT INTO categories (name) VALUES ('REST Web Services');
INSERT INTO categories (name) VALUES ('SOAP Web Services');
INSERT INTO categories (name) VALUES ('Microservice Architecture');
INSERT INTO categories (name) VALUES ('Messaging Queues');

INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core Java Question 1', 'Dummy Answer', 1);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core Java Question 2', 'Dummy Answer', 1);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core Java Question 3', 'Dummy Answer', 1);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Java Threads Question 1', 'Dummy Answer', 2);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Oracle SQL Question 1', 'Dummy Answer', 6);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Oracle SQL Question 2', 'Dummy Answer', 6);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core JavaScript Question 1', 'Dummy Answer', 13);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core JavaScript Question 2', 'Dummy Answer', 13);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core JavaScript Question 3', 'Dummy Answer', 13);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core JavaScript Question 4', 'Dummy Answer', 13);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Angular Question 1', 'Dummy Answer', 21);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy React Question 1', 'Dummy Answer', 22);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy React Question 2', 'Dummy Answer', 22);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy DevOps Principles Question 1', 'Dummy Answer', 27);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Containerization Question 1', 'Dummy Answer', 29);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Containerization Question 2', 'Dummy Answer', 29);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Hibernate Question 1', 'Dummy Answer', 31);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Hibernate Question 2', 'Dummy Answer', 31);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core Spring Question 1', 'Dummy Answer', 32);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Core Spring Question 2', 'Dummy Answer', 32);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Spring Boot Question 1', 'Dummy Answer', 33);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Spring Boot Question 2', 'Dummy Answer', 33);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Microservice Architecture Question 1', 'Dummy Answer', 38);
INSERT INTO flashcards (question, answer, category_id) VALUES ('Dummy Microservice Architecture Question 2', 'Dummy Answer', 38);

INSERT INTO study_sets (name, owner_id) VALUES ('Core Java Study Set', 4);
INSERT INTO study_sets (name, owner_id) VALUES ('Spring Study Set', 4);
INSERT INTO study_sets (name, owner_id) VALUES ('Core JavaScript Study Set', 5);
INSERT INTO study_sets (name, owner_id) VALUES ('React Study Set', 5);
INSERT INTO study_sets (name, owner_id) VALUES ('DevOps Study Set', 5);

INSERT INTO study_set_cards VALUES (1, 1);
INSERT INTO study_set_cards VALUES (1, 2);
INSERT INTO study_set_cards VALUES (1, 3);
INSERT INTO study_set_cards VALUES (2, 19);
INSERT INTO study_set_cards VALUES (2, 20);
INSERT INTO study_set_cards VALUES (2, 21);
INSERT INTO study_set_cards VALUES (2, 22);
INSERT INTO study_set_cards VALUES (3, 7);
INSERT INTO study_set_cards VALUES (3, 8);
INSERT INTO study_set_cards VALUES (3, 9);
INSERT INTO study_set_cards VALUES (3, 10);
INSERT INTO study_set_cards VALUES (4, 12);
INSERT INTO study_set_cards VALUES (4, 13);
INSERT INTO study_set_cards VALUES (5, 14);
INSERT INTO study_set_cards VALUES (5, 15);
INSERT INTO study_set_cards VALUES (5, 16);

COMMIT;
