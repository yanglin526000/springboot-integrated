# springboot-integrated

## 项目介绍
基于SpringBoot集成各种常用技术,是为了自己更好地学习

## 软件架构
基于SpringBoot整合Spring+SpringMVC+MyBatis(Mapper注解开发)+MySQL+Swagger2+Devtools

## 功能说明
### 权限管理
1. xxxx
2. xxxx
3. xxxx

## 使用说明
1. xxxx
2. xxxx
3. xxxx

## 开发说明
> * 2018年8月5日22:50:44--新创建项目，集成了devtools热部署工具
> * 2018年8月6日23:25:50--项目server以及tomcat的相关设置，generator逆向生成pojo，Mapper接口以及Mapper.xml文件（同时还做了一个Mapper类扫描）。修改了数据库连接url（useSSL=false）。添加了druid数据源，并进行了相关的设置
> * 2018年8月7日09:28:09--修改了数据库连接池配置，避免超时出现不能连接数据库的异常情况，在公司好像不能两个项目不能同时使用SpringBoot2.0.4的版本，maven加载包冲突，所以在公司的本地暂时用的是2.0.3的版本
> * 2018年8月7日21:18:51--三层架构整合完成
> * 2018年8月7日23:58:45--集成Swagger2
> * 2018年8月8日15:25:22--返回值工具类