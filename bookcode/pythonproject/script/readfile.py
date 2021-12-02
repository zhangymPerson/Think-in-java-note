#!/usr/bin/python3
import sys
import os


def exec(command):
    lines = os.popen(command).read()
    print("commaand {} exec res: \n {}".format(command, lines))

def run(fileName):
    print("task start")
    print("log is [{}]".format(fileName))
    if fileName == "":
        return
    if bool(fileName):
        return
    with open(fileName, 'r', encoding='utf-8') as f:
        lines = f.readlines()
        for line in lines:
            print(line)
    print("task end")


if __name__ == '__main__':
    print("this script is %s args num is %s" %
          (sys.argv[0], len(sys.argv) - 1))
    fileName = ""
    if len(sys.argv) > 1:
        fileName = sys.argv[1]
    # run(fileName=fileName)
    exec(fileName)
