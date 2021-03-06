最新项目结构

```
├── ssm
│   ├── src                  
│   │   ├── main                
│   │   │   ├── java/com/iris             
│   │   │   │   ├── annotation           // 自定义注解等
│   │   │   │   ├── controller           // 控制层
│   │   │   │   ├── dao                  // dao接口层
│   │   │   │   ├── mapper               // mybatis的 xml 层
│   │   │   │   ├── model                // 实体类
│   │   │   │   ├── service              // service接口层
│   │   │   │   │   ├── impl          // service接口的实现层
│   │   │   │   ├── shiro                // 采用shiro，实现用户的登录与权限控制等
│   │   │   │   ├── utils                // 工具类，包括常量类（运用枚举）、获取ip地址、xss转义、序列化类等
│   │   │   ├── resources                   // 配置资源
│   │   │   ├── webapps        
│   │   │   │   ├── css // 样式
│   │   │   │   ├── images // 图片
│   │   │   │   ├── js // 存放js目录
│   │   │   │   ├── WEB-INF             
│   │   │   │   │   ├── view          //存放jsp目录
│   │   │   │   │   ├── web.xml          
│   │   │   │   ├── static               // 静态资源
│   │   ├── test                               // junit单元测试
│   └── pom.xml                                   //maven管理的 pom 文件
│   └── README.md
```

## 2017-01-14(maven项目初始化)

地址：[SSM框架_1(项目初始化搭建) - 开源小菜鸟2333](https://my.oschina.net/u/3136014/blog/829433)

 ![第1阶段： maven项目初始化结构图](https://raw.githubusercontent.com/jiangcaijun/pictureAsset/HEAD/src/ssm_20170114/2017-01-16_104235.png)

---
## 2017-01-17(maven + spring项目)

![第2阶段：maven + spring项目结构图](https://raw.githubusercontent.com/jiangcaijun/pictureAsset/HEAD/src/ssm_20170114/2017-01-18_004214.png)
 
## 2017-01-22(maven + spring + spring MVC + mybatis项目)

地址：[SSM框架_2（添加mybatis） - 开源小菜鸟2333](https://my.oschina.net/u/3136014/blog/829455)

![maven + spring + spring MVC + mybatis项目项目结构图](https://raw.githubusercontent.com/jiangcaijun/pictureAsset/HEAD/src/ssm_20170114/2017-03-28.png)
---
## 2017-05-01(采用shiro，实现用户的登录与权限控制等)

地址：[SSM框架_3(shiro权限管理) - 开源小菜鸟2333](https://my.oschina.net/u/3136014/blog/903182)

![maven + spring + spring MVC + mybatis + shiro 项目项目结构图](https://raw.githubusercontent.com/jiangcaijun/pictureAsset/HEAD/src/ssm_20170114/shiro/2017-05-17_190619.png)
---
## 2017-05-15(添加log日志管理(aop)+Exception异常统一处理(aop))

地址：[SSM框架_4(添加log日志管理(aop)+Exception异常统一处理(aop)) - 开源小菜鸟2333](https://my.oschina.net/u/3136014/blog/904643)

---
## 2017-05-15(添加spring与redis整合)

地址：[SSM框架_5（spring与redis整合） - 开源小菜鸟2333](https://my.oschina.net/u/3136014/blog/993998)

---

## 2017-05-28(添加spring+ redis + aop)

地址：[SSM框架_6（spring与redis整合）（spring+ redis + aop ） - 开源小菜鸟2333](https://my.oschina.net/u/3136014/blog/994000)

---

## 2017-06-17(spring+ (activeMQ) 实现queue与topic)

地址：[spring+ (activeMQ) 实现queue与topic - 开源小菜鸟2333](https://my.oschina.net/u/3136014/blog/1021839)

---

## 2017-12-15(HttpServletRequest的线程安全问题)

地址：[HttpServletRequest利用 autowire 注入，线程安全问题 - 开源小菜鸟2333](https://my.oschina.net/u/3136014/blog/1590499)

---