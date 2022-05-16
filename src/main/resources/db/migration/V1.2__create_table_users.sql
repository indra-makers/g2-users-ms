create table public.tbl_users(
    username varchar(45) primary key,
    mail varchar(55) not null,
    displayName varchar(65) not null,
    id_categoryUser serial not null,
    foreign key (id_categoryUser) references tbl_categoryUsers(id_categoryUser)
)