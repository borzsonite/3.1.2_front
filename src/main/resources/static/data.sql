insert into users(department, password, salary, username) VALUES ('IT', '$2a$12$nlV7/1J78YOTXoR8RhVr0.fPgyHYSwB4t.Y/rRBdCdOEJJ5Z4Wci6', 1000, 'admin');
insert into users(department, password, salary, username) VALUES ('HR', '$2a$12$nlV7/1J78YOTXoR8RhVr0.fPgyHYSwB4t.Y/rRBdCdOEJJ5Z4Wci6', 500, 'user');
insert into roles(role) values ('ROLE_ADMIN'), ('ROLE_USER');
insert into users_roles(user_id, role_id) VALUES (1,1),(1,2),(2,2);
