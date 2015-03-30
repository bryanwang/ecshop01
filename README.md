IOS代码
===================================
目录结构
-----------------------------------
### 1,使用开源类库
1,AKTabBarController<br/>
2,REMenu<br/>

### 2,自定义类功能说明
1, [AppDelegate] 主要是设定了4个TabBar的设定和每个Tab要表示的视图类 <br/>
2, [ContentViewController] 每个Tab视图的父类，统一定义了NavigationBar内容<br/>
3, [NavigationViewController]实现了NavigationBar具体内容的类<br/>
4, [NaviContentViewController]NavigationBar相关视图的父类<br/>

5, [FirstViewController]主页视图<br/>
6, [SecondViewController]活动视图<br/>
7, [ThirdViewController]个人视图<br/>
8, [FourthViewController]购物车视图<br/>
9, [CategoryViewController]分类视图<br/>
10,[BarcodeViewController]二维码扫描视图<br/>

