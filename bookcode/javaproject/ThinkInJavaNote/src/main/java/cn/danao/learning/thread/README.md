# Thread相关得测试

- [开源学习地址](https://github.com/RedSpider1/concurrent)


- 继承Thread和实现Runnable接口两种方式比较

    由于Java“单继承，多实现”的特性，Runnable接口使用起来比Thread更灵活。

    Runnable接口出现更符合面向对象，将线程单独进行对象的封装。

    Runnable接口出现，降低了线程对象和线程任务的耦合性。

    如果使用线程时不需要使用Thread类的诸多方法，显然使用Runnable接口更为轻量。所以，我们通常优先使用“实现Runnable接口”这种方式来自定义线程类。
    
- 线程的状态(Enum Thread.State)

    NEW
    A thread that has not yet started is in this state.
    
    RUNNABLE
    A thread executing in the Java virtual machine is in this state.
    
    BLOCKED
    A thread that is blocked waiting for a monitor lock is in this state.
    
    WAITING
    A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
    
    TIMED_WAITING
    A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
    
    TERMINATED
    A thread that has exited is in this state.
    
- 线程通讯问题 / 线程通讯的几种方式

