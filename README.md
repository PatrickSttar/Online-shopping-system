# 在线购药系统后端 (Online Medicine Shopping System Backend)

这是一个基于Java Spring Boot的在线购药系统后端项目。项目采用DDD（领域驱动设计）分层架构，实现了用户认证和商品中心两大核心模块，并配备了完整的接口测试与单元测试。

## 技术栈

- **核心框架**: Java, Spring Boot
- **数据持久化**: MyBatis, MySQL
- **认证技术**: JWT (JSON Web Token)
- **测试框架**: JUnit 5, Mockito

## 已实现功能模块

### 1. 用户认证模块

本模块提供了基于JWT的用户认证功能，确保了接口的安全性。

- **用户注册**: 允许新用户创建账户。
- **用户登录**: 验证用户凭证，成功后返回一个用于后续请求认证的`token`。

### 2. 商品中心模块

本模块负责管理系统中的商品（药品）信息。

- **商品列表查询**: 提供一个公开接口，用于查询系统中所有商品的基本信息。

## 软件测试说明

本项目经过了两个维度的测试，以确保功能的稳定与代码逻辑的正确。

### 1. 接口测试 (集成测试)

所有核心API接口均已在 **Apipost** 工具中通过测试，验证了整个系统的端到端流程。

- `POST /api/user/register` (用户注册)
- `POST /api/user/login` (用户登录)
- `GET /api/products` (商品列表查询)

### 2. 单元测试

根据项目要求，已对核心业务逻辑编写了单元测试，以在隔离环境中验证代码的健壮性。

- **测试框架**: 使用 **JUnit 5** 和 **Mockito**。
- **测试目标**: `UserDomainService` (用户领域服务)。
- **测试代码位置**: `Online-shopping-system-app/src/test/java/org/example/test/domain/UserDomainServiceTest.java`
- **已覆盖的测试用例**:
    - **注册逻辑**:
        - `test_register_success`: 新用户注册成功。
        - `test_register_failure_when_user_exists`: 用户名已存在导致注册失败。
    - **登录逻辑**:
        - `test_login_success`: 用户名和密码正确，登录成功。
        - `test_login_failure_when_user_not_found`: 用户不存在导致登录失败。
        - `test_login_failure_when_password_is_wrong`: 密码错误导致登录失败。

## 如何运行

1.  在本地MySQL环境中，创建名为 `online-shopping-system` 的数据库，并执行项目内提供的SQL脚本创建所需表结构。
2.  修改 `application-dev.yml` 文件，配置正确的数据库连接信息（地址、用户名、密码）。
3.  运行 `Application.java` 启动项目。
4.  服务将启动在 `8091` 端口。