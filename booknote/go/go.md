# Java -> Go

## 打印日志
 - Java

```java
System.out.print("Hello word");
System.out.println("Hello word");
```

-  go

```go
fmt.Println("Hello danao")
fmt.Print("Hello danao")
```

---

## 常量与变量
- Java

```java
String name = "Amit Shekhar";
final String name = "Amit Shekhar";
```

- go

```go
//var name type
var str string = "hello"
//自动类型推导
var str = "hello"
//名字 := 表达式
str := "hello"
//空值
var a string
```

---
## null声明
- Java

```java
String otherName;
otherName = null;
```

- go

```go
//go中也没有null的概念，取而代之的是nil：意思为0、无的意思。
//没有进行赋值，但是指明了是什么类型、go会自动加上空值。
//在 Go 中，任何类型在未初始化时都对应一个零值：
//布尔类型是 false ，整型是 0 ，字符串是 "" ，
//而指针，函数，interface，slice，channel和map的零值都是 nil
var a string
```

---
## 空判断
-  Java

```java
if (text != null) {
    int length = text.length();
}
```

-  go

```go
var arr []string
if arr != nil {
    fmt.Println("正确")
}else{
    fmt.Println("错误")
}
```

---
## 字符串拼接

-  Java

```java
String firstName = "Amit";
String lastName = "Shekhar";
String message = "My name is: " + firstName + " " + lastName;
```

-  go

```go
var hello string = "hello"
var word string = "word"
var str = hello + word
fmt.Println(str)

//需要先导入Strings包
import "strings"
s1 := "hello"
s2 := "word"
var build strings.Builder
build.WriteString(s1)
build.WriteString(s2)
s3 := build.String()
fmt.Println(s3)
```

---
## 换行
- Java

```java
String text = "First Line\n" +
              "Second Line\n" +
              "Third Line";
```

- go

```go

```

---

## 三元表达式
- Java

```java
String text = x > 5 ? "x > 5" : "x <= 5";
```

- go

    Go语言**明确不支持三元表达式**，这里是相关的讨论： https://groups.google.com/d/msg/golang-nuts/dbyqx_LGUxM/tLFFSXSfOdQJ

    官方FAQ的说明在这里： http://golang.org/doc/faq#Does_Go_have_a_ternary_form

    **使用if-else**
```go
var n int
if expr {
    n = trueVal
} else {
    n = falseVal
}
println(n)
```

---
## 操作符
- java

```java
final int andResult  = a & b;
final int orResult   = a | b;
final int xorResult  = a ^ b;
final int rightShift = a >> 2;
final int leftShift  = a << 2;
final int unsignedRightShift = a >>> 2;
```

- go

```go
a = false
b = true
f1 := a&&b
f2 := a||b
f3 := !a
fmt.Println(f1,f2,f3)
```

---
## 类型判断和转换
- Java

```java
if (object instanceof Car) {
}
Car car = (Car) object;
```

- go

```go
//go只能显示转换，不能隐式转换
type_name(expression)
var sum int = 17
var count int = 5
var mean float32
//显示转化
mean = float32(sum)/float32(count)
fmt.Printf("mean 的值为: %f\n",mean)
```

---
## 多重条件
- Java

```java
if (score >= 0 && score <= 300) { }
```

- go

```go
num :=1000
if num >0 && num <100 {
    fmt.Printf("0<%v<100",num)
}else {
    fmt.Printf("%v <= 0 或者 %v >= 100 ",num,num)
}
```

---
## 更灵活的case语句
- Java

```java
int score = // some score;
String grade;
switch (score) {
    case 10:
    case 9:
        grade = "Excellent";
        break;
    case 8:
    case 7:
    case 6:
        grade = "Good";
        break;
    case 5:
    case 4:
        grade = "OK";
        break;
    case 3:
    case 2:
    case 1:
        grade = "Fail";
        break;
    default:
        grade = "Fail";
}
```

- go

```go
// :=这个符号直接取代了var和type,这种形式叫做简短声明。不过它有一个限制，那就是它只能用在函数内部；在函数外部使用则会无法编译通过，
//所以一般用var方式来定义全局变量。
/* 定义局部变量 */
var grade string = "B"
var marks int = 90

switch marks {
    case 90: grade = "A"
    case 80: grade = "B"
    case 50,60,70 : grade = "C"
    default: grade = "D"  
}

switch {
    case grade == "A" :
        fmt.Printf("优秀!\n" )    
    case grade == "B", grade == "C" :
        fmt.Printf("良好\n" )      
    case grade == "D" :
        fmt.Printf("及格\n" )      
    case grade == "F":
        fmt.Printf("不及格\n" )
    default:
        fmt.Printf("差\n" );
}
fmt.Printf("你的等级是 %s\n", grade ); 
```

---
## for循环
- Java

```java
for (int i = 1; i <= 10 ; i++) { }

for (int i = 1; i < 10 ; i++) { }

for (int i = 10; i >= 0 ; i--) { }

for (int i = 1; i <= 10 ; i+=2) { }

for (int i = 10; i >= 0 ; i-=2) { }

for (String item : collection) { }

for (Map.Entry<String, String> entry: map.entrySet()) { }
```

- go

```go
//普通循环
sum := 0
for i := 0; i <= 10; i++ {
        sum += i
}
fmt.Println(sum)

//无限循环
sum := 0
for {
    sum++ // 无限循环下去
}
fmt.Println(sum) // 无法输出

// range 循环 切片
strings := []string{"google", "runoob"}
for i, s := range strings {
        fmt.Println(i, s)
}
numbers := [6]int{1, 2, 3, 5}
for i,x:= range numbers {
        fmt.Printf("第 %d 位 x 的值 = %d\n", i,x)
}  
```

---
## 更方便的集合操作
- Java

```java
final List<Integer> listOfNumber = Arrays.asList(1, 2, 3, 4);

final Map<Integer, String> keyValue = new HashMap<Integer, String>();
map.put(1, "Amit");
map.put(2, "Ali");
map.put(3, "Mindorks");

// Java 9
final List<Integer> listOfNumber = List.of(1, 2, 3, 4);

final Map<Integer, String> keyValue = Map.of(1, "Amit",
                                             2, "Ali",
                                             3, "Mindorks");
```

- go

```go
//切片
var slice1 []type = make([]type, len)
//也可以简写为
slice1 := make([]type, len)
//初始化
strings := []string{"google", "runoob"}
//空判断
if(strings == nil){
      fmt.Printf("切片是空的")
}
// 集合 类似 Java中map对象
 /*创建集合 */
 var countryCapitalMap map[string]string 
 //初始化  类似 new HashMap<String,String>
 countryCapitalMap = make(map[string]string)
/* map插入key - value对,各个国家对应的首都 */
countryCapitalMap [ "France" ] = "巴黎"
countryCapitalMap [ "Italy" ] = "罗马"
countryCapitalMap [ "Japan" ] = "东京"
countryCapitalMap [ "India " ] = "新德里"

//快速初始化
 countryCapitalMap := map[string]string{"France": "Paris", "Italy": "Rome", "Japan": "Tokyo", "India": "New delhi"}
//删除元素
delete(countryCapitalMap, "France")
```

---
## 遍历
- Java

```java
// Java 7 and below
for (Car car : cars) {
  System.out.println(car.speed);
}

// Java 8+
cars.forEach(car -> System.out.println(car.speed));

// Java 7 and below
for (Car car : cars) {
  if (car.speed > 100) {
    System.out.println(car.speed);
  }
}

// Java 8+
cars.stream().filter(car -> car.speed > 100).forEach(car -> System.out.println(car.speed));
```

- go

```go
//切片遍历
for i := 0; i < len(slice); i++{
    fmt.Printf("index slice[%d] = %d\n", i, slice[i])
}
//方式二
for index, val := range slice {
    fmt.Printf("index slice[%d] = %d\n", slice, val)
}
//遍历集合

for k, v := range mapname {
    fmt.Println(k, v)
}
```

---
##  方法定义
- Java

```java
void doSomething() {
   // logic here
}

void doSomething(int... numbers) {
   // logic here
}
```

- go

```go
func funcname(){
	//do
}
//带参数的函数
func funcnameA(arg string,num int,f float64){
	fmt.Printf("参数1=%v,参数2=%v,参数3=%v",arg,num,f)
}
```

---
## 带返回值的方法
- Java

```java
int getScore() {
   // logic here
   return score;
}
```

- go

```go
func funcnameB(arg string) string {
	return arg+"..."
}
//支持多个返回值
func funcnameC() (string,int,float32){
	return "123",12,12.3
}
func funcnameD()(arg string,num int,f float32){
	arg = "funcD"
	num = 23
	f = 23.3
	return
}
```

---


---
## constructor 构造器
- Java

```java
public class Utils {

    private Utils() { 
      // This utility class is not publicly instantiable 
    }
    
    public static int getScore(int value) {
        return 2 * value;
    }
    
}
```

- go

```go
class Utils private constructor() {

    companion object {
    
        fun getScore(value: Int): Int {
            return 2 * value
        }
        
    }
}

// another way

object Utils {

    fun getScore(value: Int): Int {
        return 2 * value
    }

}
```

---
## Get Set 构造器
- Java

```java
public class Developer {

    private String name;
    private int age;

    public Developer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (age != developer.age) return false;
        return name != null ? name.equals(developer.name) : developer.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

-  go

```go
//结构体
type Student struct {
    Name  string //大写表示public属性 非大写开头就只能在包内使用（相当于private，变量或常量也可以下划线开头）
	Age   int
	Score int
}
// Set方法
func (stu * Student) SetName(name string) {
    stu.Name = name
}


//大写字母开头转json，需要额外定义
//依赖 
import "encoding/json"
//用户
type User struct {
	UserName string `json:"username"`
	Age 	 int    `json:"age"`
	Sex      string `json:"sex"`
	Email    string `json:"email"`
	Phone    string `json:"phone"`
}
//构造对象
user := User{
    UserName: "itbsl",
    Age:   	  18,
    Sex:      "itbsl@gmail.com",
    Phone:    "176XXXX6688", //最后一个逗号必须有
}
//转json
data, err := json.Marshal(user)
```
---
## 原型扩展
- Java

```java
public class Utils {

    private Utils() { 
      // This utility class is not publicly instantiable 
    }
    
    public static int triple(int value) {
        return 3 * value;
    }
    
}

int result = Utils.triple(3);

```

-  go

```go
fun Int.triple(): Int {
  return this * 3
}

var result = 3.triple()
```

- Java

```java
public enum Direction {
        NORTH(1),
        SOUTH(2),
        WEST(3),
        EAST(4);

        int direction;

        Direction(int direction) {
            this.direction = direction;
        }

        public int getDirection() {
            return direction;
        }
    }
```
- go

```go
//go本身没提供枚举
//自定义结构体 然后通过 const 常量实现
package main

import  (
  "fmt"
)

type PolicyType int32

const (
    Policy_MIN      PolicyType = 0 
    Policy_MAX      PolicyType = 1 
    Policy_MID      PolicyType = 2 
    Policy_AVG      PolicyType = 3 
)

func (p PolicyType) String() string {
    switch (p) {
    case Policy_MIN: return "MIN"
    case Policy_MAX: return "MAX"
    case Policy_MID: return "MID"
    case Policy_AVG: return "AVG"
    default:         return "UNKNOWN"
    }
}

func foo(p PolicyType) {
    fmt.Printf("enum value: %v\n", p)
}

func main() {
    foo(Policy_MAX)
}
```

---

