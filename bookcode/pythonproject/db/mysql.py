#!/usr/bin/python3

import pymysql


def selectTable(cursor):
    # SQL 查询语句
    sql = "SELECT * FROM EMPLOYEE \
        WHERE INCOME > %s" % (1000)
    try:
        # 执行SQL语句
        cursor.execute(sql)
        # 获取所有记录列表
        results = cursor.fetchall()
        for row in results:
            fname = row[0]
            lname = row[1]
            age = row[2]
            sex = row[3]
            income = row[4]
            # 打印结果
            print("fname=%s,lname=%s,age=%s,sex=%s,income=%s" %
                  (fname, lname, age, sex, income))
    except:
        print("Error: unable to fetch data")


def insertTable(db, cursor):
    # SQL 插入语句
    # sql = """INSERT INTO EMPLOYEE(FIRST_NAME,LAST_NAME, AGE, SEX, INCOME) VALUES ('Mac', 'Mohan', 20, 'M', 2000)"""

    # SQL 插入语句
    sql = "INSERT INTO EMPLOYEE(FIRST_NAME, \
            LAST_NAME, AGE, SEX, INCOME) \
            VALUES ('%s', '%s',  %s,  '%s',  %s)" % \
        ('Mac', 'Mohan', 20, 'M', 2000)
    try:
        # 执行sql语句
        cursor.execute(sql)
        # 提交到数据库执行
        db.commit()
        print("插入成功")
    except:
        # 如果发生错误则回滚
        db.rollback()
        print("插入失败")


def createTable(cursor):
    # 使用 execute() 方法执行 SQL，如果表存在则删除
    cursor.execute("DROP TABLE IF EXISTS EMPLOYEE")

    # 使用预处理语句创建表
    sql = """CREATE TABLE EMPLOYEE (
         FIRST_NAME  CHAR(20) NOT NULL,
         LAST_NAME  CHAR(20),
         AGE INT,  
         SEX CHAR(1),
         INCOME FLOAT )"""

    cursor.execute(sql)
    print("建表 EMPLOYEE 成功")


def getDB():
    # 打开数据库连接
    db = pymysql.connect(host="127.0.0.1", user="root",
                         password="123456", db="test")
    return db


def getCursor(db):
    # 使用 cursor() 方法创建一个游标对象 cursor
    cursor = db.cursor()
    # 使用 execute()  方法执行 SQL 查询
    cursor.execute("SELECT VERSION()")
    # 使用 fetchone() 方法获取单条数据.
    data = cursor.fetchone()
    print("Database version : %s " % data)
    # 关闭数据库连接
    # db.close()
    return cursor


def run():
    print("hello word!")
    db = getDB()
    cursor = getCursor(db=db)
    # createTable(cursor=cursor)
    insertTable(cursor=cursor, db=db)
    selectTable(cursor=cursor)


# 脚本入口
if __name__ == '__main__':
    run()
