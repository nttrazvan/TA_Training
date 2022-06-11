Prerequisite MySQL Server and MySQL Workbench they can be downloaded via MySQL Installer
from https://dev.mysql.com/downloads/installer/

The password for the server should be "root1".

A new schema should be created with the name "test", and a table "users"
The table should contain the following:

`CREATE TABLE users (
idusers int NOT NULL AUTO_INCREMENT,
name varchar(45) NOT NULL,
password varchar(45) NOT NULL,
email varchar(45) DEFAULT NULL,
isActive tinyint DEFAULT '1',
createdOn datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (idusers),
UNIQUE KEY idusers_UNIQUE (idusers)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci`



