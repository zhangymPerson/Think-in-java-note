package bean

// ResultCodeError 错误的返回对象无法返回 json无法解析 字段名小写的对象
type ResultCodeError struct {
	Str  string
	Data interface{} `json:"data"`
}

// ResultCode 构建返回对象
type ResultCode struct {
	//json注释必须 `json:"key"` 中间不能有任何空格
	Status int         `json:"status"`
	Msg    string      `json:"msg"`
	Data   interface{} `json:"data"`
}
