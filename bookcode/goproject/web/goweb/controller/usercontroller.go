package controller

import (
	"encoding/json"
	"fmt"
	"goweb/dao"
	"io"
	"net/http"
	"strconv"
)

func GetUserFromId(w http.ResponseWriter, r *http.Request) {
	value := r.FormValue("id")
	atoi, err := strconv.Atoi(value)
	if err != nil {
		fmt.Errorf(err.Error())
	}
	id := dao.SelectByIdTwo(int64(atoi))
	marshal, err := json.Marshal(&id)
	if err != nil {
		fmt.Errorf(err.Error())
	}
	io.WriteString(w, string(marshal))
}
