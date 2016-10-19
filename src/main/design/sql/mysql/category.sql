USE cms;

-- 创建栏目表
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`(
	strId							VARCHAR(32)		NOT NULL			COMMENT "主键Id",	
	strPid							VARCHAR(32)		NOT NULL			COMMENT "父级id",	
	strName							VARCHAR(50)		NOT NULL			COMMENT "名称",	
	strDescription					VARCHAR(200)						COMMENT "描述",
	strLevel						VARCHAR(32)		NOT NULL			COMMENT "级别",
	nChild							INT				NOT NULL DEFAULT 0	COMMENT "子级数: 0:无 (1:有一个子栏目  2：有两个子栏目)",
	nState							TINYINT			NOT NULL DEFAULT 0	COMMENT "状态:0-正常,-1-禁用",
	dtCreateTime					DATETIME		NOT NULL			COMMENT "创建时间:yyyy-mm-dd HH:mm:ss",
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;