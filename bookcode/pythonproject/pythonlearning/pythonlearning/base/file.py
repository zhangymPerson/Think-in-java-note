#!/usr/bin/python3
# 读文件 写文件


def run():
    #写 w 追加 a
    with open('test.txt', 'w', encoding='utf-8') as f:
        f.write('test')
    #读 r
    with open('a.txt', 'r', encoding='utf-8') as f:
        res = f.readlines()
        print(res)

if __name__ == '__main__':
    run()
