USE cms;

-- 创建文章表
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`(
	strId							VARCHAR(32)		NOT NULL			COMMENT "主键Id",	
	strCategoryId					VARCHAR(32)		NOT NULL			COMMENT "栏目id",	
	strTitle						VARCHAR(50)		NOT NULL			COMMENT "标题",	
	strAuthor						VARCHAR(32)		NOT NULL			COMMENT "作者",	
	strDescription					VARCHAR(200)	DEFAULT	NULL		COMMENT "描述",
	tContent						TEXT			DEFAULT	NULL		COMMENT "内容",
	nState							TINYINT			NOT NULL DEFAULT 0	COMMENT "状态:0-正常,-1-禁用",
	dtCreateTime					DATETIME		NOT NULL			COMMENT "创建时间:yyyy-mm-dd HH:mm:ss",
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;