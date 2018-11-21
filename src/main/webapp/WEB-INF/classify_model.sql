drop table if EXISTS model_config_tb ;
drop table if EXISTS config_tb;
drop table if EXISTS model_tb ;
drop table if EXISTS type_tb ;
drop table if EXISTS classify_brand_tb;
drop table if EXISTS brand_tb ;
drop table if EXISTS classify_tb ;

-- 创建分类表
create table classify_tb(
  classify_id int auto_increment PRIMARY key,
  classify_name varchar(50)
);

-- 创建品牌表
create table brand_tb(
  brand_id int auto_increment PRIMARY key,
  brand_name varchar(50),
  brand_img varchar(100)
);

-- 创建分类品牌表
CREATE TABLE classify_brand_tb(
  cb_id int auto_increment PRIMARY key,
  cb_classify_id int,
  cb_brand_id int,
  FOREIGN KEY (cb_classify_id)  REFERENCES classify_tb(classify_id),
  FOREIGN KEY (cb_brand_id)  REFERENCES brand_tb(brand_id)
);

-- 创建手机型号表
create table model_tb(
  model_id int auto_increment PRIMARY key,
  model_name varchar(50),
  model_img varchar(100),
  model_price INT,
  brand_id int,
  FOREIGN KEY (brand_id)  REFERENCES brand_tb(brand_id)
);

#手机类型表
create table type_tb(
  type_id  int primary key auto_increment,
  type_name varchar(100) NOT NULL,
  type_step INT NOT NULL
);

#手机子类型表
create table config_tb(
  config_id int primary key auto_increment,
  config_name varchar(100) NOT NULL,
  config_type_id int,
  foreign key (config_type_id) references type_tb(type_id)
);

#手机和子类型的关系表
create table model_config_tb(
  mc_id int primary key auto_increment,
  mc_model_id int,
  ms_config_id int,
  ms_describe VARCHAR(100),
  ms_price int,
  foreign key (mc_model_id) references model_tb(model_id),
  foreign key (ms_config_id) references config_tb(config_id)
);

insert into classify_tb(classify_name) values('手机');
insert into classify_tb(classify_name) values('苹果系列');
insert into classify_tb(classify_name) values('平板电脑');
insert into classify_tb(classify_name) values('笔记本');
insert into classify_tb(classify_name) values('数码相机');
insert into classify_tb(classify_name) values('游戏机');
insert into classify_tb(classify_name) values('镜头');
insert into classify_tb(classify_name) values('无人机');


INSERT INTO brand_tb(brand_name) VALUES("华为");
INSERT INTO brand_tb(brand_name) VALUES("三星");
INSERT INTO brand_tb(brand_name) VALUES("魅族");


INSERT INTO classify_brand_tb(cb_classify_id,cb_brand_id) VALUES(1,1);
INSERT INTO classify_brand_tb(cb_classify_id,cb_brand_id) VALUES(1,2);
INSERT INTO classify_brand_tb(cb_classify_id,cb_brand_id) VALUES(1,3);

INSERT INTO model_tb(model_name,model_price,brand_id) VALUES('华为P10',459900,1);
INSERT INTO model_tb(model_name,model_price,brand_id) VALUES('荣耀8',180000,1);
INSERT INTO model_tb(model_name,model_price,brand_id) VALUES('三星S7',230000,2);
INSERT INTO model_tb(model_name,model_price,brand_id) VALUES('三星S8',469900,2);
INSERT INTO model_tb(model_name,model_price,brand_id) VALUES('魅族',249900,3);

INSERT INTO type_tb(type_name,type_step) VALUES('版本',1);
INSERT INTO type_tb(type_name,type_step) VALUES('保修期',1);
INSERT INTO type_tb(type_name,type_step) VALUES('机身内存',1);
INSERT INTO type_tb(type_name,type_step) VALUES('颜色',1);
INSERT INTO type_tb(type_name,type_step) VALUES('开机情况',1);
INSERT INTO type_tb(type_name,type_step) VALUES('功能情况',2);
INSERT INTO type_tb(type_name,type_step) VALUES('外观情况',3);
INSERT INTO type_tb(type_name,type_step) VALUES('触摸屏情况',3);

#版本
INSERT INTO config_tb(config_name,config_type_id) VALUES

  ('大陆行货',1),
  ('香港行货',1),
  ('水货无锁',1),
  ('水货有锁',1);

#保修期
INSERT INTO config_tb(config_name,config_type_id) VALUES
  ('保修一个月以上',2),
  ('保修一个月内或过保',2);

#机身内存
INSERT INTO config_tb(config_name,config_type_id) VALUES
  ('16GB',3),
  ('32GB',3),
  ('64GB',3),
  ('128GB',3),
  ('256GB',3);

#颜色
INSERT INTO config_tb(config_name,config_type_id) VALUES
  ('红色',4),
  ('粉色',4),
  ('金色',4),
  ('白色',4);


#开机情况
INSERT INTO config_tb(config_name,config_type_id) VALUES
  ('开机正常',5),
  ('开机不正常',5);

#功能情况
INSERT INTO config_tb(config_name,config_type_id) VALUES
  ('有换机',6),
  ('按键接口及卡槽不正常',6),
  ('指纹功能不正常',6),
  ('蓝牙/wifi功能不正常',6),
  ('iCloud账号不能解除',6),
  ('机身有变形',6);

#外观情况
INSERT INTO config_tb(config_name,config_type_id) VALUES
  ('全新机',7),
  ('95新',7),
  ('8-9新',7),
  ('6-7新',7);

#触摸屏情况
INSERT INTO config_tb(config_name,config_type_id) VALUES
  ('完好无破损',8),
  ('屏幕划痕/爆胶',8),
  ('碎角及破裂',8),
  ('触摸失灵',8);