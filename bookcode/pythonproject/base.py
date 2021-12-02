#!/usr/bin/python3
# _*_encoding:utf-8_*_
"""
python 脚本的基本模板
标准脚本模板
"""
import logging
from os import linesep
import sys
LOG_FORMAT = "%(asctime)s - %(levelname)s - %(message)s"  # 日志格式化输出
DATE_FORMAT = "%m/%d/%Y %H:%M:%S %p"  # 日期格式
# 配置脚本日志记录文件，可不记录到日志文件中
# 取消方式 注释掉 fp 并在 handlers 中去掉 fp
# sys.argv[0] 是脚本名称 截取掉 .py 字符
logName = ("%s.log") % sys.argv[0][0:-3]
fp = logging.FileHandler(logName, encoding='utf-8')
fs = logging.StreamHandler()
logging.basicConfig(level=logging.DEBUG, format=LOG_FORMAT,
                    datefmt=DATE_FORMAT, handlers=[fs, fp])  # 调用

# 简单读写文件


def fileCommand():
    # 写 w 追加 a
    with open('test.txt', 'w', encoding='utf-8') as f:
        f.write('test')
    # 读 r
    with open('a.txt', 'r', encoding='utf-8') as f:
        lines = f.readlines()
        for line in lines:
            print(line)


def run():
    """
    自定义的实现逻辑和代码
    :return:
    """
    # 自定义输入
    text = input("you input:")
    # 如果要自定义输入中文
    # 则部分环境下要先处理字符编码问题
    info = "要输入的字符串是："
    # python 字符串转码的方式
    r_info = "要输入的字符串是：".encode('utf-8').decode('latin1')
    print(("原中文内容[%s],转编码后[%s]") % (info, r_info))
    logging.info("你输入的内容是[%s]" % (text))
    logging.info("自定义实现")


def main():
    logging.info("script start ...")
    run()
    logging.info("script end ...")


def arg():
    """
    python获取脚本参数
    """
    print("脚本名：", sys.argv[0])
    for i in range(1, len(sys.argv)):
        print("参数", i, sys.argv[i])


if __name__ == '__main__':
    # main()
    arg()
