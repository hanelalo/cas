create table users
(
    user_id  varchar(20) primary key,
    username varchar(20) not null,
    password varchar(64) not null,
    valid    varchar(2),
    roles    varchar(50)
);
insert into users value ('yexuwei', '叶旭葳',
                         '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',
                         '1', 'FRONT');

create table cas_client_details
(
    CLIENT_ID       varchar(64) primary key,
    CLIENT_SECRET   varchar(64) not null,
    GRANT_TYPE      varchar(50) not null,
    VALID           varchar(2)  not null,
    USER_TABLE_NAME varchar(20)
);

insert into cas_client_details value ('948fe603f61dc036b5c596dc09fe3ce3f3d30dc90f024c85f3c82db2ccab679d',
                                      '83d151a98eac0d0cd336a12859ee555ca1c07ecbc7e5a79fe1fba23098d38ea7',
                                      'password,refresh_token',
                                      '1',
                                      'users');