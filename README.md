手撕几个注解：autowired,service,init,destroy

在手撕这些注解中，会涉及到class的解析和结构、注解逻辑和容器托管的逻辑



理论没什么用的，直接看代码，了解逻辑和设计思想

---

目前：手撕了这些注解，底层到class的解析了  
接下来： 开始写这些代码的单元测试，后面加上容器初始化过程注册的循环依赖的判断  
肝不动了



---



2019-8-18：趁着周末，加了切面aspect注解和动态代理，最后调整了一下handler的顺序



最最后就是，扫描替换成递归扫描全部的父类的autowired属性  



循环依赖的问题下一周，明天继续搬砖  

---

2019-8-20： 为了防止爆栈，还是不用递归了，太蠢了  

基本的功能已经结束了，spring估计以后也用不上了，web框架太老了  



---



2019-8-24： 加了test和循环依赖的解决问题



在实际的使用中，这一套IOC和AOP思想需要接受实际项目的摧残，后面一周将是不断的提bug的过程