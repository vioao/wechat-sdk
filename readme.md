# wechat-sdk

微信JAVA SDK,实现了微信提供的生态HTTP接口的封装。
本项目主要参考了[weixin-popular](https://github.com/liyiorg/weixin-popular)来实现。
结构良好,实现简单，可扩展性强可以开箱即用也可以自定义对应的实现。能够满足不同程度的开发需求。

---

目前只实现了一些微信基本的SDK。按照微信公众平台接口文档分类。
对应API的使用可以查看项目的的测试代码。

**已实现功能:**
 - 自定义菜单[√]
 - 消息管理[√]
 - 微信网页开发(网页授权)[√]
 - 素材管理[√]
 - 图文消息留言管理[√]
 - 用户管理[√]
 - 账号管理[√]
 - 数据统计[√]
 - 新版客服功能[√]
 - 微信第三方平台[√]
 - 微信门店[√]

**未实现的功能:**
  - 微信摇一摇周边[x]
  - 微信卡券[x]
  - 微信小店[x]
  - 语义理解[x]
  - 微信连WI-FI[x]
  - 微信扫一扫[x]
  - 微信设备功能[x]
  - 微信发票[x]

**项目依赖:**
- jackson(可选，默认的序列化工具类依赖于jsckson。可自定义实现对应的序列化接口)
- slf4j(日志用)
- httpcomponents (可选，默认的HTTP请求工具类依赖于httpcomponents 。可自定义实现对应的HTTP请求接口)
- junit (测试用)
- lombok(便捷开发,provided)

---

**maven**
```
<dependency>
  <groupId>com.github.vioao</groupId>
  <artifactId>wechat-sdk</artifactId>
  <version>1.0.0</version>
</dependency>
```

项目总体基本可用,目前还在完善改进中...