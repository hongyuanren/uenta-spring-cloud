# 基于 Spring Cloud 微服务架构实战

@作者：hongyuanren
地址：https://github.com/hongyuanren/uenta-spring-cloud

在学习Spring Cloud时看了很多程序，都说的很好，但是搭建测试都是有各种问题，于是基于经典的piggymetrics基础上作了修改，搭建了一个微服务架构。
本项目是一个基于 Spring Boot、Spring Cloud、Spring Oauth2 和 Spring Cloud Netflix 等框架构建的微服务项目。
今后目标是增加各种通用的组件，搭建一个完整的微服务生态。

# 技术栈
* Spring boot - 微服务的入门级微框架，用来简化 Spring 应用的初始搭建以及开发过程。
* Eureka - 云端服务发现，一个基于 REST 的服务，用于定位服务，以实现云端中间层服务发现和故障转移。
* Spring Cloud Config - 配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，目前支持本地存储、Git 以及 Subversion。
* Hystrix - 熔断器，容错管理工具，旨在通过熔断机制控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。
* Zuul - Zuul 是在云平台上提供动态路由，监控，弹性，安全等边缘服务的框架。Zuul 相当于是设备和 Netflix 流应用的 Web 网站后端所有请求的前门。
* Spring Cloud Bus - 事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与 Spring Cloud Config 联合实现热部署。
* Spring Cloud Sleuth - 日志收集工具包，封装了 Dapper 和 log-based 追踪以及 Zipkin 和 HTrace 操作，为 SpringCloud 应用实现了一种分布式追踪解决方案。
* Ribbon - 提供云端负载均衡，有多种负载均衡策略可供选择，可配合服务发现和断路器使用。
* Turbine - Turbine 是聚合服务器发送事件流数据的一个工具，用来监控集群下 hystrix 的 metrics 情况。
* Spring Cloud Stream - Spring 数据流操作开发包，封装了与 Redis、Rabbit、Kafka 等发送接收消息。
* Feign - Feign 是一种声明式、模板化的 HTTP 客户端。
* Spring Cloud OAuth2 - 基于 Spring Security 和 OAuth2 的安全工具包，为你的应用程序添加安全控制。

# 应用架构

该项目包含 8 个服务

uenta-account-service - 帐户服务
uenta-auth-server - OAuth2 认证服务
uenta-config-server - 外部配置
uenta-gateway-server - 代理所有微服务的接口网关
uenta-monitor-server - 监控
uenta-notification-service - 通知服务
uenta-registry-server  - 服务注册与发现
uenta-statistics-service - 统计服务
uenta-zipkin-server - 分布式跟踪

