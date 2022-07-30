# springcloud gateway

## zuul

zuul1.x *Netflix*  基于servlet

zuul2.x 基于Netty 异步

filter实现

## springcloud gateway

也是基于netty

鉴权

业务网关

返回的数据要过网关吗？

​	要过网关，只有LVS不用过

使用

​	path断言

​	method断言

​	

### 过滤器

#### 全局过滤器

实现GlobalFilter接口

```
ApiLoggingFilter implements GlobalFilter
```

#### 局部过滤器

继承AbstractGatewayFilterFactory抽象类，实现apply方法

```
PasswordDecoderFilter extends AbstractGatewayFilterFactory 
```

![image-20210929155808948](..\picture\image-20210929155808948.png)

## nginx + lua(openresty 、 kong)

性能最高





# pig-gateway

PigRequestGlobalFilter 

