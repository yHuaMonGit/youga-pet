DROP TABLE IF EXISTS youga_pet.member_info;
CREATE TABLE youga_pet.member_info
(
	openid VARCHAR(64) PRIMARY KEY ,
	memberID VARCHAR(8),
	username VARCHAR(128),
	msisdn VARCHAR(16),
	integral VARCHAR(8),
	memberFlag VARCHAR(1),
	memberLevel VARCHAR(8),
	Amount VARCHAR(16),
	balance VARCHAR(16)
);