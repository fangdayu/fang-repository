# 传感器智能分析引擎

---

### 开发工具

| 工具   | 用途 | 版本号 |
| :------: |  :---------: | :-------: |
| JDK       | JAVA版本    | 1.8 |
| IDEA      | 后端开发环境 | 2019.2 |
| VS Code   | 前端开发环境 | 1.39.2 |
| Maven | 项目管理 | - |
| Git | 版本管理 | - |
| Spring Boot | 后端框架 | 2.2.0 |
| Vue | 前端框架 | - |
| MySQL | 数据库 | 8.0.17 |
| MyBatis | 数据库连接框架 | 2.1.1 |
| c3p0 | 数据库连接池 | 0.9.5.3 |

如果各位同学使用其他版本的开发工具，可以在本地的pom.xml中修改对应的版本号，但不要将修改上传到远程仓库。

---

### 文件管理

**Java文件** 请放在main文件夹内对应位置。（所有上传的类和接口，要求以Java doc形式简明标出功能和作者）

1. 配置文件：config文件夹
2. 实体文件：entity文件夹
3. 数据访问层：dao文件夹
4. 业务层：service文件夹
5. 控制层：controller文件夹

**其他文件** 请放在resources文件夹内对应位置。

1. 全局配置：application.properties(各位同学自行修改，但不要将修改上传到远程仓库)
2. mybatis配置：mybatis-config.xml(不建议修改)
3. Html文件：templates文件夹
4. css/js/image文件：static文件夹
5. SQL语句：mapper文件夹（由mybatis自动配置）

---

### 分支管理

不同功能的文件分开commit，并在commit时简要标明功能或修改。

主功能开发完成前，所有的更新全部push到master分支。


