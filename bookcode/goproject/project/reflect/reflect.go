package reflect

import (
	"log"
	"reflect"
)

//将 interface{} 对象转成数组
//需要使用到反射知识
func InterfaceToSlice(obj interface{}) []interface{} {
	//获取反射后的Value对象
	v := reflect.ValueOf(obj)
	t := reflect.TypeOf(obj)
	log.Println("反射后 vale = ", v.Kind(), "type = ", t)
	if v.Kind() != reflect.Slice {
		panic("toslice arr not slice")
	}
	l := v.Len()
	res := make([]interface{}, l)
	for i := 0; i < l; i++ {
		res[i] = v.Index(i).Interface()
	}
	return res
}

func InterfaceToSliceTwo(obj interface{}) []interface{} {
	//interface 类型转换 直接 interface obj.(type)
	//接口对象.(要转换的类型)
	return obj.([]interface{})
}
