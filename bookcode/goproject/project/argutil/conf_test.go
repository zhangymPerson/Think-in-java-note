package argutil

import "testing"

func TestGetJsonFile(t *testing.T) {
	type args struct {
		file string
	}
	tests := []struct {
		name string
		args args
	}{
		// TODO: Add test cases.
		{name: "test", args: args{
			file: "conf/args.json",
		}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			GetJsonFile(tt.args.file)
		})
	}
}
