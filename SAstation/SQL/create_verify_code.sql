DROP TABLE IF EXISTS youga_pet.verify_code;
CREATE TABLE youga_pet.verify_code
(
    openid VARCHAR(64) PRIMARY KEY ,
    verify_code VARCHAR(6),
    timestamp VARCHAR(16),
    veriFlag VARCHAR(1)
);