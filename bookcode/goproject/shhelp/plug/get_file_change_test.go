package plug

import (
	"testing"
)

func TestFileChange(t *testing.T) {
	type args struct {
		dir string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		// TODO: Add test cases.
		{
			name: "one",
			args: args{
				dir: "/Users/zhangyanming02/person/github/Think-in-java-note/bookcode/goproject/shhelp/plug",
			},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := FileChange(tt.args.dir); got != tt.want {
				t.Errorf("FileChange() = %v, want %v", got, tt.want)
			}
		})
	}
}
