#!/usr/bin/bash
mysql -umyddl -pmyddl -e '
use myddl;
drop table myddl_course_project;
drop table myddl_deadline;
drop table myddl_group;
drop table myddl_group_course_project;
drop table myddl_group_deadline;
drop table myddl_group_message;
drop table myddl_push_deadline;
drop table myddl_user_course_project;
drop table myddl_user_deadline;
drop table myddl_user_group;
drop table myddl_user_info;
drop table myddl_user_password;

create table myddl_group_message(group_message_id bigint primary key auto_increment, content varchar(100) not null, time varchar(30) not null, group_id bigint not null);
create table myddl_push_deadline(push_deadline_id bigint primary key auto_increment, user_id bigint not null, deadline_id bigint not null);
create table myddl_user_password(user_id bigint primary key auto_increment, username varchar(50) not null unique, password varchar(50) not null);
'
