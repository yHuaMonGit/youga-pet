insert into mysql.user(Host,User,Password) values("%","admin",password("123456"));
grant all privileges on youga_pet.* to admin@"%" identified by '123456';
flush privileges;
