DROP TABLE IF EXISTS youga_pet.user_wx_info;
CREATE TABLE youga_pet.user_wx_info
(
	userid INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	openid VARCHAR(64),
	username VARCHAR(128),
	headimgurl VARCHAR(256),
	country VARCHAR(64),
	province VARCHAR(64),
	city VARCHAR(64),
	sex VARCHAR(1)
);