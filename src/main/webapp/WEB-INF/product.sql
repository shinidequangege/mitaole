#米淘乐
#手机表
create table tb_mobile(
  mobile_id int primary key auto_increment,
  mobile_name varchar(100) not null,
  mobile_old_price int
);

#手机类型表
create table tb_type(
  type_id  int primary key auto_increment,
  type_name varchar(100) not null
);

#手机子类型表
create table tb_sub_type(
  sub_type_id int primary key auto_increment,
  sub_type_name varchar(100),
  parent_type_id int,
  foreign key (parent_type_id) references tb_type(type_id)
);

#手机和子类型的关系表
create table tb_mobile_sub(
  ms_id int primary key auto_increment,
  ms_mobile_id int,
  ms_sub_type_id int,
  ms_price int,
  foreign key (ms_mobile_id) references tb_mobile(mobile_id),
  foreign key (ms_sub_type_id) references tb_sub_type(sub_type_id)
);

select ms.ms_price,m.mobile_name,m.mobile_old_price,s.sub_type_name,t.type_name from tb_mobile_sub ms
  join tb_mobile m on ms.ms_mobile_id=m.mobile_id
  join tb_sub_type s on ms.ms_sub_type_id=s.sub_type_id
  join tb_type t on t.type_id=s.parent_type_id
                    and m.mobile_name='iphone7';
