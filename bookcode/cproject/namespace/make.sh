#bin/bash
# 构建脚本
# 分别编译
g++ -c one.cpp
g++ -c namespace.cpp
g++ -c two.cpp
# 链接程序
g++ namespace.o one.o two.o -o namespace
rm one.o two.o namespace.o
