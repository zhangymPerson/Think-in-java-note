package goroutine

import (
	"fmt"
	"testing"
)

func Test_goFunc(t *testing.T) {
	tests := []struct {
		name string
	}{
		// TODO: Add test cases.
		{
			name: "aaa",
		},
		{
			name: "aaa",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			fmt.Print("tt",tt.name)
		})
	}
}