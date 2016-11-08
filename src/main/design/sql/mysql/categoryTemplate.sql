USE cms;

-- 创建栏目模版对应表
DROP TABLE IF EXISTS `categoryTemplate`;
CREATE TABLE `categoryTemplate`(
	strCategoryId					VARCHAR(32)		NOT NULL				COMMENT "主键Id(栏目Id)",	
	strPageId						VARCHAR(32)		DEFAULT	NULL			COMMENT "分页模版Id",
	strMetaId						VARCHAR(32)		DEFAULT	NULL			COMMENT "Meta模版Id",
	strHeadId						VARCHAR(32)		DEFAULT	NULL			COMMENT "头部模版Id",
	strNavId						VARCHAR(32)		DEFAULT	NULL			COMMENT "导航模版Id",
	strFooterId						VARCHAR(32)		DEFAULT	NULL			COMMENT "尾部模版Id",
	strInfoPageId					VARCHAR(32)		DEFAULT	NULL			COMMENT "信息页模版Id",
	strCssId						VARCHAR(32)		DEFAULT	NULL			COMMENT "css模版Id",
	nState							TINYINT			NOT NULL DEFAULT 0		COMMENT "状态:0-正常,-1-禁用",
	dtUpdateTime					DATETIME		NOT NULL DEFAULT now()	COMMENT "更新时间:yyyy-mm-dd HH:mm:ss",
	PRIMARY KEY(strCategoryId),
	UNIQUE(strCategoryId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;