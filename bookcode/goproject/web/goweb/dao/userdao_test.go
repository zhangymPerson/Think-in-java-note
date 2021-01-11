package dao

import (
	"goweb/bean"
	"reflect"
	"testing"
)

func Test_selectById(t *testing.T) {
	type args struct {
		id int64
	}
	tests := []struct {
		name     string
		args     args
		wantUser *bean.User
	}{
		// TODO: Add test cases.
		{
			name: "test",
			args: args{
				id: 5,
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotUser := SelectById(tt.args.id); !reflect.DeepEqual(gotUser, tt.wantUser) {
				t.Errorf("selectById() = %v, want %v", gotUser, tt.wantUser)
			}
		})
	}
}
