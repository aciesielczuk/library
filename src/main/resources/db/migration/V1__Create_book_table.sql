create table BOOK (
    ID int unsigned primary key auto_increment,
    AUTHOR varchar(100) not null,
    TITLE varchar(100) not null,
    AVAILABILITY boolean not null
);
