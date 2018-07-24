# MicroMessage
mybatis vs servlet jdbc
# 数据库
**配置**  
[mysql]  
\# 设置mysql客户端默认字符集  
default-character-set=utf8  
 
[mysqld]  
\#skip-grant-tables  
\# 设置3306端口  
port = 3306  
\# 设置mysql的安装目录  
\#basedir=..\  
\# 设置mysql数据库的数据的存放目录  
\#datadir=..\data  
\# 允许最大连接数  
max_connections=20  
\# 服务端使用的字符集默认为8比特编码的latin1字符集  
character-set-server=utf8  
\# 创建新表时将使用的默认存储引擎  
default-storage-engine=INNODB  
default_authentication_plugin=mysql_native_password  
**创建数据**  
create table `MESSAGE` (
ID INT UNSIGNED AUTO_INCREMENT,
COMMAND CHAR(255) NOT NULL,
DESCRIPTION CHAR(255),
CONTENT CHAR(255) NOT NULL,
PRIMARY KEY(`ID`)
);  
alter table message modify COMMAND char(255) not null;  
alter table message modify DESCRIPTION char(255);  
alter table message modify CONTENT char(255) not null;  
insert into message (COMMAND, DESCRIPTION, CONTENT) values ('test', 'test desc', 'test content');