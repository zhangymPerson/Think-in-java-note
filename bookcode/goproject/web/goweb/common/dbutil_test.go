package common

import (
	"database/sql"
	"fmt"
	"reflect"
	"testing"
)

func TestCloseDB(t *testing.T) {
	tests := []struct {
		name string
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
		})
	}
}

func TestDelete(t *testing.T) {
	type args struct {
		sql  string
		args []interface{}
	}
	tests := []struct {
		name       string
		args       args
		wantResult int64
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotResult := Delete(tt.args.sql, tt.args.args...); gotResult != tt.wantResult {
				t.Errorf("Delete() = %v, want %v", gotResult, tt.wantResult)
			}
		})
	}
}

func TestGetDB(t *testing.T) {
	tests := []struct {
		name string
		want *sql.DB
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := GetDB(); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("GetDB() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestInsert(t *testing.T) {
	type args struct {
		sql  string
		args []interface{}
	}
	tests := []struct {
		name       string
		args       args
		wantResult int64
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotResult := Insert(tt.args.sql, tt.args.args...); gotResult != tt.wantResult {
				t.Errorf("Insert() = %v, want %v", gotResult, tt.wantResult)
			}
		})
	}
}

func TestQuery(t *testing.T) {
	type args struct {
		sqlstr string
		args   []interface{}
	}
	tests := []struct {
		name     string
		args     args
		wantRest [][]interface{}
	}{
		// TODO: Add test cases.
		{
			name: "test",
			args: args{
				sqlstr: "select * from users limit 1",
				args:   []interface{}{},
			},
			wantRest: [][]interface{}{},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotRest := Query(tt.args.sqlstr, tt.args.args...); !reflect.DeepEqual(gotRest, tt.wantRest) {
				t.Errorf("Query() = %v, want %v", gotRest, tt.wantRest)
			}
		})
	}
}

func TestQueryCount(t *testing.T) {
	type args struct {
		sql  string
		args []interface{}
	}
	tests := []struct {
		name      string
		args      args
		wantCount int64
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotCount := QueryCount(tt.args.sql, tt.args.args...); gotCount != tt.wantCount {
				t.Errorf("QueryCount() = %v, want %v", gotCount, tt.wantCount)
			}
		})
	}
}

func TestQueryRow(t *testing.T) {
	type args struct {
		sqlstr string
		args   []interface{}
	}
	tests := []struct {
		name     string
		args     args
		wantRest []interface{}
	}{
		// TODO: Add test cases.
		{
			name: "test",
			args: args{
				sqlstr: "select * from users where id = ?",
				args:   []interface{}{5},
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotRest := QueryRow(tt.args.sqlstr, tt.args.args...); !reflect.DeepEqual(gotRest, tt.wantRest) {
				for i, i2 := range gotRest {
					fmt.Printf("i=%v,i2=%v\n", i, i2)
				}
				t.Errorf("QueryRow() = %v, want %v", gotRest, tt.wantRest)
			}
		})
	}
}

func TestQueryUnique(t *testing.T) {
	type args struct {
		sql  string
		args []interface{}
	}
	tests := []struct {
		name     string
		args     args
		wantDest interface{}
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotDest := QueryUnique(tt.args.sql, tt.args.args...); !reflect.DeepEqual(gotDest, tt.wantDest) {
				t.Errorf("QueryUnique() = %v, want %v", gotDest, tt.wantDest)
			}
		})
	}
}

func TestUpdate(t *testing.T) {
	type args struct {
		sql  string
		args []interface{}
	}
	tests := []struct {
		name       string
		args       args
		wantResult int64
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotResult := Update(tt.args.sql, tt.args.args...); gotResult != tt.wantResult {
				t.Errorf("Update() = %v, want %v", gotResult, tt.wantResult)
			}
		})
	}
}

func Test_connDB(t *testing.T) {
	tests := []struct {
		name   string
		wantDb *sql.DB
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotDb := connDB(); !reflect.DeepEqual(gotDb, tt.wantDb) {
				t.Errorf("connDB() = %v, want %v", gotDb, tt.wantDb)
			}
		})
	}
}

func Test_execute(t *testing.T) {
	type args struct {
		sql  string
		args []interface{}
	}
	tests := []struct {
		name       string
		args       args
		wantResult sql.Result
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotResult := execute(tt.args.sql, tt.args.args...); !reflect.DeepEqual(gotResult, tt.wantResult) {
				t.Errorf("execute() = %v, want %v", gotResult, tt.wantResult)
			}
		})
	}
}

func Test_readIni(t *testing.T) {
	tests := []struct {
		name         string
		wantUsername string
		wantPassword string
		wantHost     string
		wantDatabase string
		wantErr      bool
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			gotUsername, gotPassword, gotHost, gotDatabase, err := readIni()
			if (err != nil) != tt.wantErr {
				t.Errorf("readIni() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if gotUsername != tt.wantUsername {
				t.Errorf("readIni() gotUsername = %v, want %v", gotUsername, tt.wantUsername)
			}
			if gotPassword != tt.wantPassword {
				t.Errorf("readIni() gotPassword = %v, want %v", gotPassword, tt.wantPassword)
			}
			if gotHost != tt.wantHost {
				t.Errorf("readIni() gotHost = %v, want %v", gotHost, tt.wantHost)
			}
			if gotDatabase != tt.wantDatabase {
				t.Errorf("readIni() gotDatabase = %v, want %v", gotDatabase, tt.wantDatabase)
			}
		})
	}
}
