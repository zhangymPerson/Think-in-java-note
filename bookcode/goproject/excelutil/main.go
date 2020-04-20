package main

import (
	"fmt"
	"github.com/360EntSecGroup-Skylar/excelize"
)

func main(){
	fmt.Println("读取excel")
	path := "test.xlsx"
	f,err := excelize.OpenFile(path)
	if err != nil {
        fmt.Println(err)
        return
    }
    // 获取工作表中指定单元格的值
    cell := f.GetCellValue("Sheet1", "B2")
    if err != nil {
        fmt.Println(err)
        return
    }
    fmt.Println(cell)
    // 获取 Sheet1 上所有单元格
    rows := f.GetRows("Sheet1")
    for key, row := range rows {
		fmt.Print(key,row)
        for _, colCell := range row {
            fmt.Print(colCell, "\t")
        }
        fmt.Println()
    }

}
