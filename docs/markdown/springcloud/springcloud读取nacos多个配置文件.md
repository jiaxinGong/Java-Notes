# springcloud读取nacos多个配置文件

第一个：

${spring.application.name}-${spring.profiles.active}.propertie  或者 ${spring.application.name}-${spring.profiles.active}.yml

第二个及第N个：

${spirng.cloud.nacos.config.shared-configs}

![image-20210928100901750](..\picture\image-20210929155808948.png)
