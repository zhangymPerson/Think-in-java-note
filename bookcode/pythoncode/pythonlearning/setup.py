from setuptools import setup, find_packages

"""
python项目构建
"""
setup(
    # pypi中的名称，pip或者easy_install安装时使用的名称，或生成egg文件的名称
    name="python_learning_test",
    version="1.0",
    keywords=("test", "xxx"),
    description="python learing sdk",
    long_description="learning python project",
    license="MIT Licence",

    url="http://test.com",
    author="danao",
    author_email="zhangyanmingjiayou@163.com",

    # 需要打包的目录列表
    packages=find_packages(),
    include_package_data=True,
    platforms="any",

    # 需要安装的依赖
    install_requires=[
        'setuptools>=16.0',
    ],

    scripts=[],
    entry_points={
        'console_scripts': [
            'test = test.help:main'
        ]
    },
    # 此项需要，否则卸载时报windows error
    zip_safe=False
)
