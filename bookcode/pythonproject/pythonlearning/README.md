# python 项目结构说明
> python参考手册的代码练习 

> python https://github.com/jackfrued/Python-100-Days 代码学习

## 项目结构

Python 小项目的通用目录结构
```
ProjectName
│ readme 项目说明文档
│ requirements.txt 存放依赖的外部Python包列表
│ setup.py 安装、部署、打包的脚本
├─ bin 存放脚本，执行文件等
│ └─ projectname
├─ docs 文档和配置
│ └─ abc.rst
│ └─ conf.py 配置文件
└─ projectname 工程源码（包括源码、测试代码等）
│ main.py 程序入口
│ init.py
└─ tests 测试代码
└─ test_main.py
└─ init.py
```

- python项目

setup.py 的说明

```
--name 包名称
--version (-V) 包版本
--author 程序的作者
--author_email 程序的作者的邮箱地址
--maintainer 维护者
--maintainer_email 维护者的邮箱地址
--url 程序的官网地址
--license 程序的授权信息
--description 程序的简单描述
--long_description 程序的详细描述
--platforms 程序适用的软件平台列表
--classifiers 程序的所属分类列表
--keywords 程序的关键字列表
--packages 需要处理的包目录（包含__init__.py的文件夹）
--py_modules 需要打包的python文件列表
--download_url 程序的下载地址
--cmdclass
--data_files 打包时需要打包的数据文件，如图片，配置文件等
--scripts 安装时需要执行的脚步列表
--package_dir 告诉setuptools哪些目录下的文件被映射到哪个源码包。一个例子：package_dir = {'': 'lib'}，表示“root package”中的模块都在lib 目录中。
--requires 定义依赖哪些模块
--provides定义可以为哪些模块提供依赖
--find_packages() 对于简单工程来说，手动增加packages参数很容易，刚刚我们用到了这个函数，它默认在和setup.py同一目录下搜索各个含有 __init__.py的包。

                          其实我们可以将包统一放在一个src目录中，另外，这个包内可能还有aaa.txt文件和data数据文件夹。另外，也可以排除一些特定的包

                          find_packages(exclude=["*.tests", "*.tests.*", "tests.*", "tests"])

--install_requires = ["requests"] 需要安装的依赖包
--entry_points 动态发现服务和插件，下面详细讲
```