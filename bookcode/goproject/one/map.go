package main
import "fmt"
func main()  {

	//集合
	mapname := map[string]string{"k1":"v1","k2":"v2"}
	var map2 map[string]string
	//map 可以根据新增的 key-value 对动态的伸缩 可以指定初始容量
	map2 = make(map[string]string,1)
	map2["key"] = "value"
	map2["key1"] = "value1"
	fmt.Println(map2)
	for k, v := range mapname {
		fmt.Println(k, v)
	}
}