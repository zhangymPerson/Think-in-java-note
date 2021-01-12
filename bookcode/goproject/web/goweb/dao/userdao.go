package dao

import (
	"fmt"
	"goweb/bean"
	"goweb/common"
)

func SelectById(id int64) (user *bean.User) {
	//defer common.CloseDB()
	sqlStr := "select id,username,password,email from users where id = ?"
	row := common.QueryRow(sqlStr, id)
	user = &bean.User{
		Id:       id,
		Username: string(row[1].([]byte)),
		Password: string(row[2].([]byte)),
		Email:    string(row[3].([]byte)),
	}
	fmt.Printf("user = %v", user)
	return
}

func SelectByIdTwo(id int64)(user *bean.User){
	sqlStr := "select id,username,password,email from users where id = ?"
	rows := common.QueryRows(sqlStr, id)
	//必须初始化下这个user.否则空指针
	user = &bean.User{}
	if rows.Next(){
		//查询出来的sql内容转换成对象属性 orm 过程调用此方法
		rows.Scan(&user.Id,&user.Username,&user.Email,&user.Password)
	}
	fmt.Printf("user = %v", user)
	return
}