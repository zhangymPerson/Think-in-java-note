package main

import (
	"database/sql"
	"fmt"

	_ "github.com/go-sql-driver/mysql"
)

type user struct {
	id   string
	name string
	age  string
}

// 需要 go get -u github.com/go-sql-driver/mysql  拉取包
// 连接数据库
func connectMysql(username, password, host, port, dbname string) *sql.DB {
	conn := fmt.Sprintf("%s:%s@tcp(%s:%s)/%s", username, password, host, port, dbname)
	// fmt.Println(conn)
	// db, err := sql.Open("mysql", "root:123456@tcp(localhost:3306)/test")
	db, err := sql.Open("mysql", conn)
	if err != nil {
		panic(err)
	}
	// 测试连接是否成功
	err2 := db.Ping()
	if err2 != nil {
		panic(err2)
	} else {
		fmt.Println("连接成功")
	}
	return db
}

// query 查询 mysql中的数据
func query(db *sql.DB) {
	sqlStr := "select id, name, age from user where id=?"
	var u user
	// 非常重要：确保QueryRow之后调用Scan方法，否则持有的数据库链接不会被释放
	err := db.QueryRow(sqlStr, 1).Scan(&u.id, &u.name, &u.age)
	if err != nil {
		fmt.Printf("scan failed, err:%v\n", err)
		return
	}
	fmt.Printf("id:%s name:%s age:%s\n", u.id, u.name, u.age)
}

func main() {
	fmt.Println("hello word!")
	db := connectMysql("root", "123456", "127.0.0.1", "3306", "test")
	query(db)

}
