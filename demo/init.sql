/*权限表*/
CREATE TABLE permission(
  pid int(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL DEFAULT '',
  url VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (pid)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

INSERT INTO permission VALUES ('1','add','123');
INSERT INTO permission VALUES ('2','delete','123');
INSERT INTO permission VALUES ('3','select','123');
INSERT INTO permission VALUES ('4','update','123');
/*用户表*/
CREATE TABLE user(
  uid int(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL DEFAULT '',
  password VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (uid)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

INSERT INTO user VALUES ('1','admin','123');
INSERT INTO user VALUES ('1','demo','123');

/*角色表*/
CREATE TABLE role(
  rid int(11) NOT NULL AUTO_INCREMENT,
  rname VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (rid)
)ENGINE  = InnoDB DEFAULT CHARSET = UTF8;

INSERT INTO role VALUES ('1','admin');
INSERT INTO role VALUES ('2','customer');

/*权限角色关系表*/
CREATE TABLE permission_role(
  rid int(11) NOT NULL ,
  pid int(11) NOT NULL ,
  KEY idx_rid (rid),
  KEY idx_pid (pid)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;
INSERT INTO permission_role VALUES ('1','1');
INSERT INTO permission_role VALUES ('1','2');
INSERT INTO permission_role VALUES ('2','3');
INSERT INTO permission_role VALUES ('2','4');

/*用户角色表*/
CREATE TABLE user_role(
  rid int(11) NOT NULL ,
  uid int(11) NOT NULL ,
  KEY idx_rid (rid),
  KEY idx_uid (uid)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;
INSERT INTO user_role VALUES ('1','1');
INSERT INTO user_role VALUES ('2','2');




/*--------------------------------------------------------*/



























