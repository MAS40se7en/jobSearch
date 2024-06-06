insert into company(created, modified, name, description) values (now(), now(), 'tech company', 'a company for testing');

insert into company(created, modified, name, description) values (now(), now(), 'another company', 'a company for testing');

insert into company(created, modified, name, description) values (now(), now(), 'third company', 'a company for testing');


insert into job (title, created, modified, description, min_salary, max_salary, located_at, company) values ('Developer', now(), now(), 'development testing job', '50000.0', '80000.0', 'New York', 1);

insert into job (title, created, modified, description, min_salary, max_salary, located_at, company) values ('Designer', now(), now(), 'Design testing job', '50000.0', '80000.0', 'New York', 1);