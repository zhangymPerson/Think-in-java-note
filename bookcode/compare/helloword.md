# 多语言对比

## hello word

- java 

    HelloWord.java

    ```java
    package cn.danao.code.one;

    /**
    * date 2020/1/1 9:37 <br/>
    * descriptionclass <br/>
    * 打印 helloword
    *
    * @author Thinkpad
    * @version 1.0
    * @since 1.0
    */
    public class HelloWord {
        public static void main(String[] args) {
            //java 打印helloword
            System.out.println("Hello Word");
        }
    }

    ```

    javac HelloWord.java
    在cn目录下执行
    java cn.danao.code.one.HelloWord

- python

    HelloWord.py

    ```py
    # 直接执行
    print("one Hello Word")


    def main():
        """
        函数调用打印
        :return:
        """
        print("two Hello Word")


    if __name__ == '__main__':
        main()
    ```

- js

    helloword.js

    ```js
    //脚本执行
    console.log("one Hello Word");

    /**
    * 函数执行
    */
    function f() {
    console.log("two Hello Word");
    }
    //函数调用
    f();
    ```