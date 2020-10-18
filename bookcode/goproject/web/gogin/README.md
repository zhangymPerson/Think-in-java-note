# gin 网络项目

- 创建项目

  `go mod init gogin`

* 注意事项

  go struct 转 json 注意事项：

  **字段首字母要大写**
  
  **配置 `json:"key"` 中间不能有任何空格**

  ```go
  //构建返回对象
  type ResultCode struct {
      //json注释必须 `json:"key"` 中间不能有任何空格
      Status int         `json:"status"`
      Msg    string      `json:"msg"`
      Data   interface{} `json:"data"`
  }
  ```
