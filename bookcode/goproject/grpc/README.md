# grpc 测试 grpc

## 创建项目

mkdir grpc

## 编写 proto 文件

vim Person.proto

- 注意

  要添加 `option go_package = "/pd";` 不然报错

## 编译这些文件为 go 代码

需要依赖以下工具

- protobuf

  `brew install protobuf`

- google.golang.org/grpc

  `go get -u google.golang.org/grpc`

- github.com/golang/protobuf/protoc-gen-go

  `go get -u github.com/golang/protobuf/protoc-gen-go`

- 执行

  `protoc --proto_path=proto proto/*.proto --go_out=plugins=grpc:./`
