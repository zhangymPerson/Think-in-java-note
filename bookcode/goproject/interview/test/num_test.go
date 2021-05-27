package test

import (
	"fmt"
	"testing"
)

func TestNum(t *testing.T) {
	DivisionOne()
}

func TestSlice(t *testing.T) {
	var list = make([]int, 5, 10)
	list[0] = 1
	list[2] = 3
	list[30] =30
	fmt.Printf("%v", list)
}
