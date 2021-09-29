#!/usr/bin/python3

import time

ticks = time.time()
print("时间戳 time = :%s" % (ticks))

# 格式化成2016-03-20 11:45:39形式
timeOne = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())

print("timeOne is %s" % (timeOne))

# 格式化成Sat Mar 28 22:24:24 2016形式
timeTwo=time.strftime("%a %b %d %H:%M:%S %Y", time.localtime())
print("timeTwo is %s" % (timeTwo))

# 将格式字符串转换为时间戳
a="Sat Mar 28 22:24:24 2016"
timeThree=time.mktime(time.strptime(a, "%a %b %d %H:%M:%S %Y"))
print("timeThree is %s" % (timeThree))
