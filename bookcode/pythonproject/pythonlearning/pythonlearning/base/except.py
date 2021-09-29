#!/usr/bin/python3

def test():
    """
    异常处理
    """
    try:
        a = 10/0
        print("a is %s" % (a))
    except Exception as e:
        print("exception is %s" % (e))


def run():
    print("hello world!")
    test()


if __name__ == '__main__':
    run()
