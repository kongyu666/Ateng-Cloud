# JetCache 是一个 Java 缓存框架。

https://github.com/alibaba/jetcache

## 简介

JetCache是一个基于Java的缓存系统封装，提供统一的API和注解来简化缓存的使用。
JetCache提供了比SpringCache更加强大的注解，可以原生的支持TTL、两级缓存、分布式自动刷新，还提供了```Cache```接口用于手工缓存操作。
当前有四个实现，```RedisCache```、```TairCache```（此部分未在github开源）、```CaffeineCache```(in memory)和一个简易的```LinkedHashMapCache```(in memory)
，要添加新的实现也是非常简单的。

全部特性:

* 通过统一的API访问Cache系统
* 通过注解实现声明式的方法缓存，支持TTL和两级缓存
* 通过注解创建并配置```Cache```实例
* 针对所有```Cache```实例和方法缓存的自动统计
* Key的生成策略和Value的序列化策略是可以配置的
* 分布式缓存自动刷新，分布式锁 (2.2+)
* 异步Cache API (2.2+，使用Redis的lettuce客户端时)
* Spring Boot支持

