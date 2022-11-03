么是tomcat

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



# tomcat的web.xml

web.xml 是所有项目的默认配置值，自己配置的web.xml是可以覆盖默认配置的，好比类的继承



# tomcat的Context.xml

每个应用斗加载conf/context.xml，context代表 了一个web应用，WEB-INFO web元数据目录，META-INFO元数据目录

WatchedResource标签是用来监听资源的，默认监听了WEB-INF/web.xml ￥{catalina.base}/conf/web.xml



# tomcat结构

树形结构，结构中的父节点管理子节点的生命周期

![image-20220921071926347](image\image-20220921071926347.png)





![image-20220921080817500](image\image-20220921080817500.png)



![image-20221104000023189](D:\soft\IdeaProjects\Java-Notes\docs\markdown\tomcat\image\image-20221104000023189.png)

Server  管理整个应用的启动和关闭

Service 一组连接器的组合

Connector 处理连接、协议

Engine 多个主机的组合

Host 多个Context的组合

Context 多个Servlet的组合



tomcat线程池默认200



# Tomcat的生命周期管理

Lifecycle接口定义了Tomcat中所有组件的生命周期函数，定义该接口，主要是为了统一管理组件中的生命周期。该接口定义了常用事件字符串和监听器的支持函数。

```
*            start()
*  -----------------------------
*  |                           |
*  | init()                    |
* NEW -»-- INITIALIZING        |
* | |           |              |     ------------------«-----------------------
* | |           |auto          |     |                                        |
* | |          \|/    start() \|/   \|/     auto          auto         stop() |
* | |      INITIALIZED --»-- STARTING_PREP --»- STARTING --»- STARTED --»---  |
* | |         |                                                            |  |
* | |destroy()|                                                            |  |
* | --»-----«--    ------------------------«--------------------------------  ^
* |     |          |                                                          |
* |     |         \|/          auto                 auto              start() |
* |     |     STOPPING_PREP ----»---- STOPPING ------»----- STOPPED -----»-----
* |    \|/                               ^                     |  ^
* |     |               stop()           |                     |  |
* |     |       --------------------------                     |  |
* |     |       |                                              |  |
* |     |       |    destroy()                       destroy() |  |
* |     |    FAILED ----»------ DESTROYING ---«-----------------  |
* |     |                        ^     |                          |
* |     |     destroy()          |     |auto                      |
* |     --------»-----------------    \|/                         |
* |                                 DESTROYED                     |
* |                                                               |
* |                            stop()                             |
* ----»-----------------------------»------------------------------
```

```java
// ----------------------------------------------------- Manifest Constants
// 定义字符串事件
public static final String BEFORE_INIT_EVENT = "before_init";
public static final String AFTER_INIT_EVENT = "after_init";
public static final String START_EVENT = "start";
public static final String BEFORE_START_EVENT = "before_start";
public static final String AFTER_START_EVENT = "after_start";
public static final String STOP_EVENT = "stop";
public static final String BEFORE_STOP_EVENT = "before_stop";
public static final String AFTER_STOP_EVENT = "after_stop";
public static final String AFTER_DESTROY_EVENT = "after_destroy";
public static final String BEFORE_DESTROY_EVENT = "before_destroy";
public static final String PERIODIC_EVENT = "periodic";
public static final String CONFIGURE_START_EVENT = "configure_start";
public static final String CONFIGURE_STOP_EVENT = "configure_stop";
// --------------------------------------------------------- Public Methods
// 监听器支持方法
public void addLifecycleListener(LifecycleListener listener);
public LifecycleListener[] findLifecycleListeners();
public void removeLifecycleListener(LifecycleListener listener);

// 生命周期支持方法
public void init() throws LifecycleException;
public void start() throws LifecycleException;
public void stop() throws LifecycleException;
public void destroy() throws LifecycleException;

public LifecycleState getState();
public String getStateName();

// 标记接口，比如Serializable序列化接口
public interface SingleUse {
}
```

```java
// 生命周期状态
public enum LifecycleState {
    NEW(false, null),
    INITIALIZING(false, Lifecycle.BEFORE_INIT_EVENT),
    INITIALIZED(false, Lifecycle.AFTER_INIT_EVENT),
    STARTING_PREP(false, Lifecycle.BEFORE_START_EVENT),
    STARTING(true, Lifecycle.START_EVENT),
    STARTED(true, Lifecycle.AFTER_START_EVENT),
    STOPPING_PREP(true, Lifecycle.BEFORE_STOP_EVENT),
    STOPPING(false, Lifecycle.STOP_EVENT),
    STOPPED(false, Lifecycle.AFTER_STOP_EVENT),
    DESTROYING(false, Lifecycle.BEFORE_DESTROY_EVENT),
    DESTROYED(false, Lifecycle.AFTER_DESTROY_EVENT),
    FAILED(false, null);

    // 是否可用
    private final boolean available;
    // 生命周期事件
    private final String lifecycleEvent;

    private LifecycleState(boolean available, String lifecycleEvent) {
        this.available = available;
        this.lifecycleEvent = lifecycleEvent;
    }

 
    public boolean isAvailable() {
        return available;
    }

    public String getLifecycleEvent() {
        return lifecycleEvent;
    }
}
```



# Tomcat的容器生命周期管理

容器是一个组件，它继承Lifecycle接口，那么就可用说，组件不一定是容器，容器一定是组件。容器可用拥有自己的生命周期事件、监听器，容器之间可拥有父子关系，容器执行后台周期性的方法，也定义了周期执行的时间。



stack线程安全

# tomcat用的比较多的设计模式

责任链模式

监听器模式

模板方法



# tomcat生命周期函数模板实现

该类实现了Lifecycle生命周期接口，定义了组件生命周期函数

```java
LifecycleBase
```



# MBean JMX相关

LifecycleMBeanBase,该模板类，实现了Tomcat组件注册到JMX中和从JMX中解除注册的函数，初始化时注册，销毁时解除注册。



# bootStrap启动执行原理

tomcat核心：catalina

```java
bootstrap.init();//初始化类加载器
// 这里只是个代理，真正加载在catalina里面
// 为什么这么设计，因为类加载器的原因
bootstrap.load();
bootstrap.start();
```



tomcat类加载器

```java
      Bootstrap
          |
       System
          |
       Common
       /     \
  Webapp1   Webapp2 .. Tomcat与应用共享了库
```



```java
   Bootstrap
      |
    System
      |
    Common
     /  \
Server  Shared  可用决定共享的库和不共享的库
         /  \
   Webapp1  Webapp2 ...
```

```java
public void init() throws Exception {

    initClassLoaders();

    Thread.currentThread().setContextClassLoader(catalinaLoader);

    SecurityClassLoad.securityClassLoad(catalinaLoader);

    // Load our startup class and call its process() method
    if (log.isDebugEnabled()) {
        log.debug("Loading startup class");
    }
    // 这里为什么要用反射？
    // catalinaLoader.loadClass 可用决定使用哪个类加载器。
    // 当前加载Bootstrap的类加载器的是System class loader,假如这里直接new Catalina(),
    // 这时Catalina就在system class loader里，如果通过反射加载，catalina就在catalinaLoader里
    Class<?> startupClass = catalinaLoader.loadClass("org.apache.catalina.startup.Catalina");
    Object startupInstance = startupClass.getConstructor().newInstance();

    // Set the shared extensions class loader
    if (log.isDebugEnabled()) {
        log.debug("Setting startup class properties");
    }
    String methodName = "setParentClassLoader";
    Class<?> paramTypes[] = new Class[1];
    paramTypes[0] = Class.forName("java.lang.ClassLoader");
    Object paramValues[] = new Object[1];
    paramValues[0] = sharedLoader;
    Method method =
        startupInstance.getClass().getMethod(methodName, paramTypes);
    method.invoke(startupInstance, paramValues);

    catalinaDaemon = startupInstance;
}
```

# catalina原理

```java
// 创建对象树，然后调用生命周期的init方法初始化
public void load() {
	// 只能执行一次
    if (loaded) {
        return;
    }
    loaded = true;

    long t1 = System.nanoTime();

    initDirs();// 废弃

    // Before digester - it may be needed
    initNaming();// JNDI 过时了

    // Create and execute our Digester
    Digester digester = createStartDigester();

    InputSource inputSource = null;
    InputStream inputStream = null;
    File file = null;
    try {
        try {
            file = configFile();
            inputStream = new FileInputStream(file);
            inputSource = new InputSource(file.toURI().toURL().toString());
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug(sm.getString("catalina.configFail", file), e);
            }
        }
        if (inputStream == null) {
            try {
                inputStream = getClass().getClassLoader()
                    .getResourceAsStream(getConfigFile());
                inputSource = new InputSource
                    (getClass().getClassLoader()
                     .getResource(getConfigFile()).toString());
            } catch (Exception e) {
                if (log.isDebugEnabled()) {
                    log.debug(sm.getString("catalina.configFail",
                            getConfigFile()), e);
                }
            }
        }

        // This should be included in catalina.jar
        // Alternative: don't bother with xml, just create it manually.
        if (inputStream == null) {
            try {
                inputStream = getClass().getClassLoader()
                        .getResourceAsStream("server-embed.xml");
                inputSource = new InputSource
                (getClass().getClassLoader()
                        .getResource("server-embed.xml").toString());
            } catch (Exception e) {
                if (log.isDebugEnabled()) {
                    log.debug(sm.getString("catalina.configFail",
                            "server-embed.xml"), e);
                }
            }
        }


        if (inputStream == null || inputSource == null) {
            if  (file == null) {
                log.warn(sm.getString("catalina.configFail",
                        getConfigFile() + "] or [server-embed.xml]"));
            } else {
                log.warn(sm.getString("catalina.configFail",
                        file.getAbsolutePath()));
                if (file.exists() && !file.canRead()) {
                    log.warn("Permissions incorrect, read permission is not allowed on the file.");
                }
            }
            return;
        }

        try {
            inputSource.setByteStream(inputStream);
            digester.push(this);
            // 这段代码执行完毕后，server.xml定义的整个对象以及监听器都会创建好，会按照degester定义的规则创建
            digester.parse(inputSource);
        } catch (SAXParseException spe) {
            log.warn("Catalina.start using " + getConfigFile() + ": " +
                    spe.getMessage());
            return;
        } catch (Exception e) {
            log.warn("Catalina.start using " + getConfigFile() + ": " , e);
            return;
        }
    } finally {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }

    getServer().setCatalina(this);
    getServer().setCatalinaHome(Bootstrap.getCatalinaHomeFile());
    getServer().setCatalinaBase(Bootstrap.getCatalinaBaseFile());

    // Stream redirection
    initStreams();

    // Start the new server
    try {
        getServer().init();
    } catch (LifecycleException e) {
        if (Boolean.getBoolean("org.apache.catalina.startup.EXIT_ON_INIT_FAILURE")) {
            throw new java.lang.Error(e);
        } else {
            log.error("Catalina.start", e);
        }
    }

    long t2 = System.nanoTime();
    if(log.isInfoEnabled()) {
        log.info("Initialization processed in " + ((t2 - t1) / 1000000) + " ms");
    }
}
```



# Catalina原理 load方法





# apache digester

解析xml ,配置路径直接创建对象



