create database education default character set utf8;

create table lib_article
(
    id bigint not null auto_increment,
    book_id bigint,
    chapter_id bigint,
    volume_id bigint,
    order_num int,
    title varchar(512),
    description varchar(1024),
    create_time timestamp null,
    last_modify_time timestamp null,
    primary key (id),
    constraint pk_lib_article_volume_id foreign key (volume_id) references `lib_volume` (`id`),
    constraint pk_lib_article_book_id foreign key (book_id) references `lib_book` (`id`) ,
    constraint pk_lib_article_chapter_id foreign key (chapter_id) references `lib_chapter`(`id`),
    index pk_lib_article_book_id (book_id),
    index pk_lib_article_chapter_id (chapter_id),
    index pk_lib_article_volume_id (volume_id)
)
engine=innodb default charset=utf8;

create table lib_book
(
    id bigint not null auto_increment,
    title varchar(500),
    author varchar(100),
    subject1 varchar(100),
    subject2 varchar(100),
    datetime varchar(100),
    description varchar(500),
    language varchar(3),
    publisher varchar(100),
    translator varchar(100),
    asin varchar(255),
    cover varchar(255),
    uuid varchar(255),
    create_time timestamp null,
    last_modify_time timestamp null,
    primary key (id)
)
engine=innodb default charset=utf8;

create table lib_chapter
(
    id bigint not null auto_increment,
    book_id bigint,
    volume_id bigint,
    order_num int,
    title varchar(512),
    description varchar(1024),
    create_time timestamp null,
    last_modify_time timestamp null,
    primary key (id),
    constraint pk_lib_chapter_book_id foreign key (book_id) references `lib_book` (`id`) ,
    constraint pk_lib_chapter_volume_id foreign key (volume_id) references `lib_volume` (`id`),
    index pk_lib_chapter_book_id (book_id),
    index pk_lib_chapter_volume_id (volume_id)
)
engine=innodb default charset=utf8;

create table lib_section
(
    id bigint not null auto_increment,
    article_id bigint,
    order_num int,
    content varchar(1024),
    description varchar(1024),
    create_time timestamp null,
    last_modify_time timestamp null,
    primary key (id),
    constraint pk_lib_section_article_id foreign key (article_id) references `lib_article`
    (`id`),
    index pk_lib_section_article_id (article_id)
)
engine=innodb default charset=utf8;

create table lib_volume
(
    id bigint not null auto_increment,
    book_id bigint,
    order_num int,
    title varchar(512),
    description varchar(1024),
    create_time timestamp null,
    last_modify_time timestamp null,
    primary key (id),
    constraint pk_lib_volume_book_id foreign key (book_id) references `lib_book` (`id`),
    index pk_lib_volume_book_id (book_id)
)
engine=innodb default charset=utf8;
