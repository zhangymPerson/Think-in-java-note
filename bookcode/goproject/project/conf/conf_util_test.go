package conf

import (
	"reflect"
	"testing"
)

func TestGetConfValue(t *testing.T) {
	type args struct {
		confPath string
	}
	tests := []struct {
		name string
		args args
		want JsonValue
	}{
		// TODO: Add test cases.
		{"1", args{"conf.json"}, JsonValue{}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := GetConfValue(tt.args.confPath); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("GetConfValue() = %v, want %v", got, tt.want)
			}
		})
	}
}
