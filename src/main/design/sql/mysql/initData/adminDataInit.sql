USE cms;

-- 初始化菜单数据
INSERT INTO `permission` (`strId`, `strPid`, `strName`, `strPermission`, `strDescription`, `nType`, `nState`, `dtCreateTime`) 
VALUES ('001', '0', '系统管理', "sys:query", '系统管理', '0', '0', now()),

('001-001', '001', '部门管理', '/system/department/list', '部门管理', '0', '0', now()),
('001-001-001', '001-001', '部门详情查看', 'dept:detail', '部门详情查看', '1', '0', now()),
('001-001-002', '001-001', '部门添加修改', 'dept:saveOrUpdate', '部门添加修改', '1', '0', now()),
('001-001-003', '001-001', '部门删除', 'dept:del', '部门删除', '1', '0', now()),
('001-001-004', '001-001', '部门添加', 'dept:add', '部门添加', '1', '0', now()),

('001-002', '001', '用户管理', '/system/user/list', '用户管理', '0', '0', now()),
('001-002-001', '001-002', '部门用户列表', 'sysuser:query', '部门用户列表', '1', '0', now()),
('001-002-002', '001-002', '用户详情查看', 'sysuser:detail', '用户详情查看', '1', '0', now()),
('001-002-003', '001-003', '用户添加修改', 'sysuser:saveOrUpdate', '用户添加修改', '1', '0', now()),

('001-003', '001', '栏目管理', '/system/category/list', '栏目管理', '0', '0', now()),
('001-003-001', '001-003', '栏目详情查看', 'category:detail', '栏目详情查看', '1', '0', now()),
('001-003-002', '001-003', '栏目添加', 'category:add', '栏目添加', '1', '0', now()),
('001-003-003', '001-003', '栏目添加修改', 'category:saveOrUpdate', '栏目添加修改', '1', '0', now()),
('001-003-004', '001-003', '栏目删除', 'category:del', '栏目删除', '1', '0', now());

-- 初始化角色数据
INSERT INTO `role` (`strId`, `strName`, `strDescription`, `nState`) 
VALUES ('1', 'admin', '管理员', '0');

-- 初始化角色权限数据
INSERT INTO `rolepermission` (`strId`, `strRoleId`, `strPermissionId`) 
VALUES ('1', '1', '001'),
('2', '1', '001-001'),
('3', '1', '001-002'),
('4', '1', '001-002-001'),
('5', '1', '001-002-002'),
('6', '1', '001-002-003'),
('7', '1', '001-003'),
('8', '1', '001-003-001'),
('9', '1', '001-003-002'),
('10', '1', '001-003-003'),
('11', '1', '001-003-004');

-- 初始化部门数据
INSERT INTO `department` (`strId`,`strPid`,`strName`,`strDescription`,`nState`,`dtCreateTime`,`nChild`,`strLevel`)
VALUES('1' ,'0','组织机构' ,'组织机构' ,'0',now() ,'0' ,'001');

-- 初始化栏目数据
INSERT INTO `category` (`strId`,`strPid`,`strName`,`strDescription`,`nState`,`dtCreateTime`,`nChild`,`strLevel`)
VALUES('1' ,'0','栏目库' ,'栏目库' ,'0',now() ,'0' ,'001');

-- 初始化用户数据
INSERT INTO `systemuser` (`strUserId`,`strLoginName`, `strPassword`, `strName`, `nSex`, `strMobile`, `strPhone`, `strEmail`, `strQQ`, `strWeChar`, `dtBirthday`, `strAddress`, `strHeadURL`, `nState`, `strDeptId`, `dtCreateTime`, `dtUpdateTime`) 
VALUES ('1', 'admin', '00000000', 'admin', '0', NULL , NULL, NULL , NULL, NULL , now() , NULL , NULL, '1', '1', now() , now());

-- 初始化用户角色数据
INSERT INTO `userrole` (`strId`, `strLoginId`, `strRoleId`) 
VALUES ('1', '1', '1');





