## mysql json实验

````
DELIMITER;;
CREATE PROCEDURE test_insert_json ( ) BEGIN
	DECLARE
		y int DEFAULT 1;

	WHILE y < 100000 DO
			INSERT INTO `test`.`user` ( `uid`, `info` )
		VALUES
			( 0, '{\"id\": \"0\", \"time\": \"2018-06-22 16:02:28\", \"LOG_USR\": \"N/A\", \"SRC_IP\": \"2887254406\", \"SRC_PORT\": \"43391\", \"SRC_MAC\": \"4C:CC:6A:85:D0:78\", \"SYSTEM_USR\": \"/\", \"SYSTEM_HOST\": \"/\", \"SESSION_ID\": \"1529654084\", \"DATA_SRC\": \"/\", \"DEST_IP\": \"2887188751\", \"DEST_PORT\": \"3306\", \"DEST_MAC\": \"C4:FF:1F:F3:9D:D0\", \"DB_NAME\": \"/\", \"DB_TYPE\": \"MySQL 5.6\", \"TABLE_TYPE\": \"0\", \"TABLE_NAME\": \"ce_queue\", \"TABLE_NUM\": \"1\", \"FIELD_TYPE\": \"0\", \"FIELD_NAME\": \"Shangahai\",\"OPER_TYPE\": \"select\",\"OPER_SENTENCE\": \"select cq.uuid     from ce_queue cq     where cq.status=\'PENDING\'     and not exists(     select 1     from ce_queue cq2     where cq.component_uuid=cq2.component_uuid and cq2.status <> \'PENDING\'     )           order by cq.created_at asc, cq.id asc;\", \"ROW_NUM\": \"0\", \"SQL_EXEC_TIME\": \"0.058\", \"SQL_RESPON\": \"success\", \"RETURNED_CONTENT\": \"/\", \"RULE_NAME\": \" \", \"DEAL_STATE\": \"1\", \"RISK_LEV\": \"4\", \"AUDIT_OBJ_NAME\": \"15MySQL\", \"EXTEND_A\": \"/\", \"EXTEND_B\": \"/\", \"EXTEND_C\": \" \"}' );
		
		SET y = y + 1;
		
	END WHILE;
	COMMIT;
END;;
````
CALL test_insert_json ( );


DELIMITER;;
CREATE PROCEDURE test_insert_mysql ( ) BEGIN
	DECLARE
		y int DEFAULT 1;

	WHILE y < 100000 DO
INSERT INTO `test`.`audit_record`(`ID`, `TIME`, `LOG_USR`, `SRC_IP`, `SRC_PORT`, `SRC_MAC`, `SYSTEM_USR`, `SYSTEM_HOST`, `SESSION_ID`, `DATA_SRC`, `DEST_IP`, `DEST_PORT`, `DEST_MAC`, `DB_NAME`, `DB_TYPE`, `TABLE_TYPE`, `TABLE_NAME`, `TABLE_NUM`, `FIELD_TYPE`, `FIELD_NAME`, `OPER_TYPE`, `OPER_SENTENCE`, `ROW_NUM`, `SQL_EXEC_TIME`, `SQL_RESPON`, `RETURNED_CONTENT`, `RULE_NAME`, `DEAL_STATE`, `RISK_LEV`, `AUDIT_OBJ_NAME`, `EXTEND_A`, `EXTEND_B`, `EXTEND_C`) VALUES (0, '2018-06-22 16:02:28', 'N/A', 2887254406, 43391, '4C:CC:6A:85:D0:78', '/', '/', 1529654084, '/', 2887188751, 3306, 'C4:FF:1F:F3:9D:D0', '/', 'MySQL 5.6', '0', 'ce_queue', 1, '0', 'cq.uuid,cq.status', 'select', 'select cq.uuid     from ce_queue cq     where cq.status=\'PENDING\'     and not exists(     select 1     from ce_queue cq2     where cq.component_uuid=cq2.component_uuid and cq2.status <> \'PENDING\'     )           order by cq.created_at asc, cq.id asc;', 0, 0.58, 'success', '/', '', 1, 4, '15MySQL', ' ', '/', ' ');
		SET y = y + 1;
		
	END WHILE;
	COMMIT;
END;;

CALL test_insert_mysql ( );

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `info` json DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=38616 DEFAULT CHARSET=utf8;

CREATE TABLE `audit_record` (
  `ID` bigint(8) unsigned NOT NULL AUTO_INCREMENT,
  `TIME` datetime NOT NULL,
  `LOG_USR` varchar(50) DEFAULT NULL,
  `SRC_IP` int(4) unsigned DEFAULT NULL,
  `SRC_PORT` int(4) unsigned DEFAULT NULL,
  `SRC_MAC` varchar(50) DEFAULT NULL,
  `SYSTEM_USR` varchar(50) DEFAULT NULL,
  `SYSTEM_HOST` varchar(50) DEFAULT NULL,
  `SESSION_ID` int(4) unsigned DEFAULT NULL,
  `DATA_SRC` varchar(50) DEFAULT NULL,
  `DEST_IP` int(4) unsigned DEFAULT NULL,
  `DEST_PORT` int(4) unsigned DEFAULT NULL,
  `DEST_MAC` varchar(50) DEFAULT NULL,
  `DB_NAME` varchar(50) DEFAULT NULL,
  `DB_TYPE` varchar(100) DEFAULT NULL,
  `TABLE_TYPE` varchar(50) DEFAULT NULL,
  `TABLE_NAME` varchar(200) DEFAULT NULL,
  `TABLE_NUM` int(4) unsigned DEFAULT NULL,
  `FIELD_TYPE` varchar(50) DEFAULT NULL,
  `FIELD_NAME` varchar(200) DEFAULT NULL,
  `OPER_TYPE` varchar(30) DEFAULT NULL,
  `OPER_SENTENCE` longtext,
  `ROW_NUM` int(4) unsigned DEFAULT NULL,
  `SQL_EXEC_TIME` double DEFAULT NULL,
  `SQL_RESPON` varchar(500) DEFAULT NULL,
  `RETURNED_CONTENT` longtext,
  `RULE_NAME` varchar(50) DEFAULT NULL,
  `DEAL_STATE` tinyint(1) unsigned DEFAULT NULL,
  `RISK_LEV` tinyint(1) unsigned DEFAULT NULL,
  `AUDIT_OBJ_NAME` varchar(50) DEFAULT NULL,
  `EXTEND_A` varchar(50) DEFAULT NULL,
  `EXTEND_B` varchar(50) DEFAULT NULL,
  `EXTEND_C` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`,`TIME`) USING BTREE,
  KEY `TIME` (`TIME`) USING BTREE,
  KEY `LOG_USR` (`LOG_USR`) USING BTREE,
  KEY `DATA_SRC` (`DATA_SRC`) USING BTREE,
  KEY `SRC_IP` (`SRC_IP`) USING BTREE,
  KEY `OPER_TYPE` (`OPER_TYPE`) USING BTREE,
  KEY `AUDIT_OBJ_NAME` (`AUDIT_OBJ_NAME`) USING BTREE,
  KEY `RISK_LEV` (`RISK_LEV`) USING BTREE,
  KEY `SESSION_ID` (`SESSION_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

查看文件路径
show global variables like "%datadir%";
十万数据

|system| user.ibd|audit_record.ibd |
| ---- | ---|---|
|linux|116M|56M |
|window|118.784M|77.824M|
 物理文件大一倍
 
select id,OPER_TYPE,OPER_SENTENCE  from audit_record  where  OPER_TYPE = 'select'  limit  0,20;
SELECT uid, info -> '$.OPER_TYPE' AS OPER_TYPE, info -> '$.OPER_SENTENCE' AS OPER_SENTENCE FROM `user` where info -> '$.OPER_TYPE' = 'select'  limit 200;
SELECT uid,info -> '$.OPER_TYPE' AS OPER_TYPE, info -> '$.OPER_SENTENCE' AS OPER_SENTENCE  FROM `user` where info -> '$.OPER_SENTENCE' like '%lwrong%'  limit 0,20;
SELECT id,OPER_TYPE,OPER_SENTENCE  FROM `audit_record` where  OPER_SENTENCE like '%lwrong%'  limit  0,20;
EXPLAIN select id,OPER_TYPE,OPER_SENTENCE  from audit_record_risk  where  time = '2018-06-22 16:02:29' and OPER_TYPE = 'delete' and OPER_SENTENCE like '%lwrong%'   
结论：
第一轮比较：物理文件json表比普通表大一倍
第二轮比较：普通查询两个差不多，关键字查询json比普通的查询要慢；
第三轮比较：一千万数据，5.7(50s)关键字查询比5.6（130s）快一倍多，一般查询时间差不多
