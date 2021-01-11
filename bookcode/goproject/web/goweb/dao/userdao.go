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
