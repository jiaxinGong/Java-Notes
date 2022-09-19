# 什么是tomcat

实现了Jakarta Servlet、Server Pages 、Expression Language、WebSocket、Annotations、Authentication等规范的开源软件

# 什么是规范

规范在java层面就是面向接口编程

# 如何获取源码并调试

百度：如何idea调试tomcat8.5源码

# 如何阅读源码

1、看项目结构

2、看readme

3、找到官方文档所在地

4、查看配置文件

5、注意：不要立马进行调试递进的方式进行源码研究，不利于整合思维+深入记忆

​	一定要：利用自己的语言知识来进行推理和阅读

6、看接口定模块（微服务解耦：接口规范）

7、模块划分好后，逐个突破，切记广度优先，而非深度优先（模块之间必定存在联系，不要深纠，一定要先掌握脉络，再细节）

8、融会贯通（根据掌握的整体脉络，研究细节即可）

9、剩下的交给时间+努力+坚持



# tomcat文档

https://tomcat.apache.org/tomcat-8.5-doc/index.html

# tomcat源码初览

一个web应用就是一个Context

/bin 二进制文件

/conf 配置文件

/logs 日志文件

/webapps  web应用



catalina_home 安装目录 catalina是tomcat的核心，好比猫的心脏

catalina_base 配置文件的目录





