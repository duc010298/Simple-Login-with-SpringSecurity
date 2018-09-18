-- Create database
drop database testDatabase;
create database testDatabase;
use testDatabase;
-- Create table
create table APP_USER(
  USER_ID           BIGINT not null primary key,
  USER_NAME         VARCHAR(36) not null unique,
  ENCRYTED_PASSWORD VARCHAR(128) not null,
  ENABLED           BIT not null
);
create table APP_ROLE(
  ROLE_ID   BIGINT not null primary key,
  ROLE_NAME VARCHAR(30) not null unique
) ;
create table USER_ROLE
(
  ID      BIGINT not null primary key,
  USER_ID BIGINT not null,
  ROLE_ID BIGINT not null
);
alter table USER_ROLE
  add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);
alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (USER_ID)
  references APP_USER (USER_ID);
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (ROLE_ID)
  references APP_ROLE (ROLE_ID);

--------------------------------------

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

---

insert into app_role (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');


---

insert into user_role (ID, USER_ID, ROLE_ID)
values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID)
values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID)
values (3, 2, 2);
--