# JDK21 SpringBoot3 SpringCloud Alibaba 微服务架构

## 系统模块信息

1. 使用**Nacos**做为**服务发现**与**配置管理**
2. 使用**多模块**开发，减少模块之间的依赖
3. 使用Sa-Token配置SameToken，所有请求只能通过网关，确保各个微服务的安全

- [ateng-gateway](ateng-gateway) ：网关模块，所有请求均通过网关
- [ateng-auth](ateng-auth) ：认证模块，包含登录、用户、权限等认证操作
- [ateng-api](ateng-api) ：RPC远程调用模块，使用Dobbo进行远程调用
- [ateng-modules](ateng-modules) ：业务模块，业务系统
    - [ateng-modules-system](ateng-modules/ateng-modules-system) ：系统模块，系统设置相关
- [ateng-example](ateng-example) ：示例模块，用于各种服务的测试
    - [ateng-example-demo](ateng-example/ateng-example-demo) ：测试模块，测试各个模块的功能
- [ateng-common](ateng-common) ：通用模块
    - [ateng-common-admin](ateng-common/ateng-common-admin) ：监控模块，注册到 Spring Boot Admin
      服务中，从而实现应用程序的监控和管理，参考[官网](https://docs.spring-boot-admin.com/current/getting-started.html)
    - [ateng-common-aop-log](ateng-common/ateng-common-aop-log) ：日志模块，使用SpringBoot
      AOP进行接口日志访问记录，并通过[ateng-modules-system](ateng-modules\ateng-modules-system) 模块将日志写入到**PostgreSQL**数据库中
    - [ateng-common-core](ateng-common/ateng-common-core) ：核心模块，包含SpringBoot3相关的配置
    - [ateng-common-dobbo](ateng-common/ateng-common-dobbo)
      ：Web和RPC远程调用模块，用于对各个微服务之间调用服务，参考[官网](https://cn.dubbo.apache.org/zh-cn/overview/mannual/java-sdk/quick-start/spring-boot/)
    - [ateng-common-easy-excel](ateng-common/ateng-common-easy-excel) ：Excel模块，参考[官网](https://easyexcel.opensource.alibaba.com/)
    - [ateng-common-file](ateng-common/ateng-common-file) ：文件模块，参考[官网](https://x-file-storage.xuyanwu.cn/#/)
    - [ateng-common-forest](ateng-common/ateng-common-forest) ：HTTP模块，参考[官网](https://forest.dtflyx.com/)
    - [ateng-common-graceful-response](ateng-common/ateng-common-graceful-response)
      ：响应处理器模块，参考[官网](https://doc.feiniaojin.com/graceful-response/home.html)
    - [ateng-common-idempotent](ateng-common/ateng-common-idempotent) ：幂等模块，接口防刷
    - [ateng-common-lock4j](ateng-common/ateng-common-lock4j) ：分布式锁模块，参考[官网](https://github.com/baomidou/lock4j)
    - [ateng-common-mail](ateng-common/ateng-common-mail) ：邮件模块，发送邮件
    - [ateng-common-mybatis-flex](ateng-common/ateng-common-mybatis-flex) ：数据库模块，参考[官网](https://mybatis-flex.com/)
    - [ateng-common-openfeign](ateng-common/ateng-common-openfeign)
      ：RPC远程调用模块，参考[官网](https://spring.io/projects/spring-cloud-openfeign)
    - [ateng-common-redis](ateng-common/ateng-common-redis) ：Redis缓存模块，使用Fastjson2集成RedisTemplate
    - [ateng-common-satoken](ateng-common/ateng-common-satoken) ：Sa-Token权限认证模块，参考[官网](https://sa-token.cc/)
    - [ateng-common-seata](ateng-common/ateng-common-seata) ：分布式事务模块，参考[官网](https://seata.apache.org/zh-cn/docs/user/quickstart/)
    - [ateng-common-sentinel](ateng-common/ateng-common-sentinel) ：流控防护模块，参考[官网](https://sentinelguard.io/zh-cn/)
    - [ateng-common-sms4j](ateng-common/ateng-common-sms4j) ：短信模块，发送短信，参考[官网](https://sms4j.com/)
    - [ateng-common-snail-job](ateng-common/ateng-common-snail-job) ：任务调度模块，参考[官网](https://snailjob.opensnail.com/)
    - [ateng-common-stream-kafka](ateng-common/ateng-common-stream-kafka)
      ：Kafka消息模块，参考[官网](https://github.com/spring-cloud/spring-cloud-stream/tree/main/binders/kafka-binder)
    - [ateng-common-stream-rabbit](ateng-common/ateng-common-stream-rabbit)
      ：RabbitMQ消息模块，参考[官网](https://github.com/spring-cloud/spring-cloud-stream/tree/main/binders/rabbit-binder)
    - [ateng-common-utils](ateng-common/ateng-common-utils) ：工具模块，集成Lombok、Fastjson2、Hutool、Apache Commons等
    - [ateng-common-web](ateng-common/ateng-common-web) ：Web模块，使用Fastjson2集成Web MVC
    - [ateng-common-websocket](ateng-common/ateng-common-websocket) ：websocket模块
    - [ateng-common-jetcache](ateng-common/ateng-common-jetcache) ：缓存模块，参考[官网](https://github.com/alibaba/jetcache)

## 系统服务信息

**服务接口**

- 网关：http://localhost:20520
    - 认证：/auth/**
    - 系统：/system/**
    - 测试：/example-demo/**

- 认证：http://localhost:20521
- 系统：http://localhost:20522

**服务状态**

| 信息 | 接口                 | 说明              |
|----|--------------------|-----------------|
| 状态 | /actuator/health   | 检测系统的健康状态接口     |
| 关闭 | /actuator/shutdown | 关闭系统的接口（POST请求） |

## 服务打包

### 打包所有模块

1. 打包所有模块

```shell
C:\software\apache-maven-3.9.6\bin\mvn.cmd clean install -DskipTests
```

### 打包指定模块

1. 如果存在多个JDK，需要在IDEA终端里面配置环境变量

```shell
JAVA_HOME=C:\software\Java\jdk-21.0.2+13
```

2. 执行打包命令

```shell
C:\software\apache-maven-3.9.6\bin\mvn.cmd clean install -DskipTests -pl ateng-gateway -am
```


