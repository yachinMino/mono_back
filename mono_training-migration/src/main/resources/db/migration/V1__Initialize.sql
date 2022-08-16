
CREATE TABLE user_info(
    id int not null,
    name char(100),
    ${commonColumns},
    CONSTRAINT user_info_pk PRIMARY KEY (id)
);
