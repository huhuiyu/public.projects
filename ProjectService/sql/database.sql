use information_schema;
drop database if exists ProjectsDB;
create database ProjectsDB default charset utf8 collate utf8_general_ci;
use ProjectsDB;

create table TbConfig
(
  configKey varchar(50) primary key comment '配置键值，主键',
  configValue varchar(2000) comment '配置值',
  lastupdate timestamp comment '最后更新时间'
)comment '系统配置表';

create table TbToken
(
  token varchar(50) primary key comment '令牌值，自然主键',
  lastupdate timestamp comment '令牌环最后更新时间'
)comment 'token追踪表';

create table TbTokenInfo
(
  token varchar(50) comment '令牌',
  infoKey varchar(50) comment '令牌信息key值',
  info varchar(2000) comment '令牌信息值',
  lastupdate timestamp comment '令牌信息最后更新时间',
  constraint pkTbTokenInfo primary key(token,infoKey)
)comment 'token附加信息表';

/* 系统配置数据 */
/* token过期时间配置，值是分钟数 */
insert into TbConfig(configKey,configValue,lastupdate) values('token.timeout','10080',now());

/* 查询 */
select configKey,configValue,lastupdate from TbConfig;
select token,lastupdate from TbToken;
select token,infoKey,info,lastupdate from TbTokenInfo;

/* 后台管理 */
create table TbAdmin
(
  aid int auto_increment primary key not null comment '主键',
  username varchar(20) unique not null comment '用户名',
  password varchar(50) not null comment '密码',
  pwdsalt varchar(10) not null comment '密码盐',
  enable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp not null on update now() default now() comment '最后更新时间'
)comment '管理员用户表';

/* 默认管理员账户 */
insert into TbAdmin(username,password,pwdsalt) values('test','81743726017d7456a523ec02cf28e317','92HDJ4');

select aid,username,password,pwdsalt,enable,lastupdate from TbAdmin;

/* 公共部分 */
create table TbSysConfig
(
  scid int auto_increment primary key not null comment '主键',
  typeCode varchar(50) not null comment '配置代码',
  infoCode varchar(50) not null comment '信息代码',
  infoValue varchar(1000) not null comment '配置信息值',
  lastupdate timestamp not null on update now() default now() comment '最后更新时间',
  constraint uniTbSysConfig_typeCode_infoCode unique(typeCode,infoCode)
)comment '系统配置信息表';

/* oss访问地址 */
insert into TbSysConfig(typeCode,infoCode,infoValue) values('oss','oss-url','http://39.108.124.237/myossdataservice/common/getOssObjUrl?tbOssInfo.objectName=');
insert into TbSysConfig(typeCode,infoCode,infoValue) values('teach-info-type','t01','oss链接');
insert into TbSysConfig(typeCode,infoCode,infoValue) values('teach-info-type','t02','外部链接');

select scid,typeCode,infoCode,infoValue,lastupdate from TbSysConfig;

/* 在线教学 */
create table TbTeachType
(
  ttid int auto_increment primary key not null comment '主键',
  typeName varchar(20) unique not null comment '分类名',
  iconfont varchar(20) not null default '' comment '分类图标',
  info varchar(500) not null comment '分类描述信息',
  enable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp not null on update now() default now() comment '最后更新时间'
)comment '教学信息分类表';

select ttid,typeName,iconfont,info,enable,lastupdate from TbTeachType;

create table TbTeachSubtype
(
  tstid int auto_increment primary key not null comment '主键',
  ttid int not null comment '外键,TbTeachType(ttid)，所属分类',
  subtypeName varchar(20) not null comment '小类名',
  iconfont varchar(20) not null default '' comment '小类图标',
  info varchar(500) not null comment '分类描述信息',
  enable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp not null on update now() default now() comment '最后更新时间',
  constraint uniTbTeachSubtype_ttid_subtypeName unique(ttid,subtypeName)
)comment '教学信息小类表';

select tstid,ttid,subtypeName,iconfont,info,enable,lastupdate from TbTeachSubtype;

create table TbTeachInfo
(
  tiid int auto_increment primary key not null comment '主键',
  tstid int not null comment '外键,TbTeachSubtype(tstid)，所属分类',
  scid int not null comment '外键,TbSysConfig(scid)，信息类型',
  link varchar(1000) not null comment '信息链接',
  info varchar(500) not null comment '信息描述',
  enable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp not null on update now() default now() comment '最后更新时间'
)comment '教学信息表';

select tiid,tstid,scid,link,info,enable,lastupdate from TbTeachInfo;


