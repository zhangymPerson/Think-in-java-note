package goroutine

import (
	"fmt"
)

func goFunc() {
	fmt.Println("Test")
	go func() {
		fmt.Println("协程创建")
	}()
}
