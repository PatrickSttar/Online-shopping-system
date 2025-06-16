# 在线购药系统后端 (Online Medicine Shopping System Backend)

这是一个基于Java Spring Boot的在线购药系统后端项目。项目采用DDD（领域驱动设计）分层架构，目前实现了用户认证和商品中心两大核心模块。

## 技术栈

- Java
- Spring Boot
- MyBatis
- MySQL
- JWT (for Authentication)

## 已实现功能模块

### 1. 用户认证模块

本模块提供了基于JWT (JSON Web Token) 的用户认证功能，确保了接口的安全性。

- **用户注册**: 允许新用户创建账户。
- **用户登录**: 验证用户凭证，成功后返回一个用于后续请求认证的`token`。

### 2. 商品中心模块

本模块负责管理系统中的商品（药品）信息。

- **商品列表查询**: 提供一个公开接口，用于查询系统中所有商品的基本信息。

## 接口测试

本项目的所有核心接口均已在 **Apipost** 工具中通过测试，验证了其功能的正确性和稳定性。

已通过测试的接口包括：

- `POST /api/user/register` (用户注册)
- `POST /api/user/login` (用户登录)
- `GET /api/products` (商品列表查询)

## 如何运行

1.  需要在本地Docker容器的MySQL环境中，创建名为 `online-shopping-system` 的数据库，并执行项目内提供的SQL脚本创建所需表结构。
2.  修改 `application-dev.yml` 文件，配置正确的数据库连接信息（地址、用户名、密码）。
3.  运行 `Application.java` 启动项目。
4.  服务将启动在 `8091` 端口。