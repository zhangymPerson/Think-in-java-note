# java中的笔记

- Java中的静态变量在多线程中是线程非安全的

    [测试代码](../../bookcode/javaproject/ThinkInJavaNote/src/main/java/cn/danao/learning/thread/provide/ProvideThread.java)

- Java中的守护线程简单例子

    [测试代码](../../bookcode/javaproject/ThinkInJavaNote/src/main/java/cn/danao/learning/thread/daemon/DaemonThreadTest.java)

## java中的线程的wait和notify / notifyAll

- wait/notify 机制
    
    一个线程调用 Object 的 wait() 方法，使其线程被阻塞；另一线程调用 Object 的 notify()/notifyAll() 方法，wait() 阻塞的线程继续执行。

- wai/notify 方法说明

    |方法	|说明|
    |-|-|
    |wait()	|当前线程被阻塞，线程进入 WAITING 状态|
    |wait(long)	|设置线程阻塞时长，线程会进入 TIMED_WAITING 状态。如果设置时间内（毫秒）没有通知，则超时返回|
    |wait(long, int)	|纳秒级别的线程阻塞时长设置|
    |notify()	|通知同一个对象上已执行 wait() 方法且获得对象锁的等待线程|
    |notifyAll()	|通知同一对象上所有等待的线程|
    
- 实现 wait/notify 机制的条件：
    
    - 调用 wait 线程和 notify 线程必须拥有相同对象锁。

    - wait() 方法和 notify()/notifyAll() 方法必须在 Synchronized 方法或代码块中。

    - 由于 wait/notify 方法是定义在java.lang.Object中，所以在任何 Java 对象上都可以使用。

- sleep和wait的区别

    - **`sleep` 是 `Thread` 类的方法，`wait` 是 `Object` 类的方法**
    - `Thread.sleep` 不会导致锁行为的改变，如果当前线程是拥有锁的，那么 `Thread.sleep` 不会让线程释放锁。
    - `Thread.sleep` 和 `Object.wait` 都会暂停当前的线程，对于CPU资源来说，不管是哪种方式暂停的线程，都表示它暂时不再需要 CPU 的执行时间。OS 会将执行时间分配给其它线程。区别是，调用 `wait` 后，需要别的线程执行 `notify/notifyAll` 才能够重新获得 CPU 执行时间。
