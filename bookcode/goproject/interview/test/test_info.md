# Golang 中编写 test 测试代码

- 规则说明

  - 文件名必须是\_test.go 结尾的(文件名必须是*\_test.go 的类型，*代表要测试的文件名），这样在执行 go test 的时候才会执行到相应的代码

  - 你必须 import testing 这个包

  - 所有的测试用例函数必须是 Test 开头（函数名必须以 Test 开头如：TestXxx 或 Test_xxx）

  - 测试用例会按照源代码中写的顺序依次执行

  - 测试函数 TestXxx()的参数是 testing.T，我们可以使用该类型来记录错误或者是测试状态

  - 测试格式：func TestXxx (t \*testing.T),Xxx 部分可以为任意的字母数字的组合，但是首字母不能是小写字母[a-z]，例如 Testintdiv 是错误的函数名。

  - 函数中通过调用 testing.T 的 Error, Errorf, FailNow, Fatal, FatalIf 方法，说明测试不通过，调用 Log 方法用来记录测试的信息。

- 文件命名为 \*\_test.go

- 文件中的函数命名

  ```go
  // 函数必须以Test开头
  // Test后的一个字母不能用小写
  func TestMethod(t *testing.T){}
  ```

- 测试执行

  **不能使用`go run *.go`**

  要使用`go test *_test.go` 运行次测试文件 要打印测试中的内容 需要加参数 `-v` 来显示

- 注意

  **如果包中所有文件都是\*\_test.go 文件,则该包无法导入使用,报错`no non-test Go files`**

  **Go 当中\*\_test.go 结尾的文件不是 go build 命令编译的目标，而是 go test 编译的目标。**
