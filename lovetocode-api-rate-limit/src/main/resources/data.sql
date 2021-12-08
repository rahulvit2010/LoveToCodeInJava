insert into rate_limit_config(id,user_id,api_uri,rate_limit,reset_interval)
values(1001,'user1','/api/v1/developers',4,1);
insert into rate_limit_config(id,user_id,api_uri,rate_limit,reset_interval)
values(1002,'user2','/api/v1/developers',2,2);
insert into rate_limit_config(id,user_id,api_uri,rate_limit,reset_interval)
values(1003,'user1','/api/v1/organizations',10,1);
insert into rate_limit_config(id,user_id,api_uri,rate_limit,reset_interval)
values(1004,'user2','/api/v1/organizations',2,2);


insert into developers(id,name,position,project_assigned,primary_skill)
values(1111,'rahul','architect','city bank','java');
insert into developers(id,name,position,project_assigned,primary_skill)
values(1112,'john','developer','dell','php');
insert into organizations(id,name,domain,head_count,head_quater)
values(1234,'city bank','financial service','10000','usa');
insert into organizations(id,name,domain,head_count,head_quater)
values(1235,'tata mototr','automotiv','50000','india');
