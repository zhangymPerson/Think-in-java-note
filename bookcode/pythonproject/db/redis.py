#!/usr/bin/python3

import redis


class DB():
    def __init__(self, host='localhost', port=6379):
        # 建立连接
        self.conn = redis.Redis(host=host, port=port)

    def __enter__(self):
        # 返回连接
        return self.conn

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.conn.close()


if __name__ == '__main__':
    with DB(host='127.0.0.1', port='6379') as redis:
        redis.llen('key')
