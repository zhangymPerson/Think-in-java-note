package main

import "fmt"

func method(a int, b int) int {
	fmt.Printf("%d + %d = %d\n", a, b, a+b)
	return a + b
}
