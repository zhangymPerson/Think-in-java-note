package function
import "testing"
func TestFuncUse(t *testing.T) {
    t.Log("hello world")
    p :=Person{
        Id : 1,
        Age:12,
        Name:"张三",
        Sex:"男",
    }
    p.anonymityFunc()
    p.Print()
}