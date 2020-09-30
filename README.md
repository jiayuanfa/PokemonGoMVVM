# PokemonGoMVVM
##使用JetPack + MVVM的练手项目

### 推送记录
- 创建buildSrc文件夹，gradle自动识别 2020.9.21
- 引入并使用BuildConfig配置信息  2020.9.21
- 创建项目文件夹，以及必须要的类 2020.9.21
- 设置icon，增加Hilt注入模块 2020.9.22
- 引入DataBinding库 2020.9.22 5:35
- 创建PokemonItemModel文件，同时使用DiffUtils来比对数据以实现增量刷新 2020.9.22
- 引入Kotlin Core库
- 引入Coil图片加载库，因为要使用里面的Kotlin coroutines 协程库 2020.9.23
- 引入Paging3数据管理框架
- 编写Pokemon列表页以及详情页数据模型、格式化数据的方式、接口请求成功失败的泛型类、主仓库的获取数据的方法
- 引入gson框架，为了实现数据模型的数据库存储
- 编写PokemonService API
- 引入Room数据库框架
- 编写Pokemon项目的数据库文件、以及数据库的操作类 2020.9.24
- 引入Fragment.runtimeKtx以编写MainViewModel，主要用到了里面的viewModelScope，为了旋转屏幕数据不丢失 2020.9.27
- 编写MainViewModel
- 引入下拉加载刷新库 2020.9.28
- 顶部MotionLayout动画编写 2020.9.29
- 解决@OptIn注解的报错问题并同步app和project两个里面的kotlin版本 2020.9.30
- 添加Mapper类，数据往外面转一层，防止由于服务器数据的变化 错误引起的大规模修改业务的问题

