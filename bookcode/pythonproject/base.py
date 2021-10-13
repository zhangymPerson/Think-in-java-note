#!/usr/bin/python3
# _*_encoding:utf-8_*_
"""
python 脚本的基本模板
标准脚本模板
"""
import logging
LOG_FORMAT = "%(asctime)s - %(levelname)s - %(message)s"  # 日志格式化输出
DATE_FORMAT = "%m/%d/%Y %H:%M:%S %p"  # 日期格式
# 配置脚本日志记录文件，可不记录到日志文件中
# 取消方式 注释掉 fp 并在 handlers 中去掉 fp
fp = logging.FileHandler('script-run.txt', encoding='utf-8')
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
        res = f.readlines()
        print(res)


# 读写 mysql redis 见 db目录下的脚本


def run():
    """
    自定义的实现逻辑和代码
    :return:
    """
    # 自定义输入
    text = input("要输入的内容是：")
    logging.info("你输入的内容是[%s]" % (text))
    logging.info("自定义实现")


def main():
    logging.info("script start ...")
    run()
    logging.info("script end ...")


if __name__ == '__main__':
    main()
