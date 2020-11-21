#  大数据学习-Java Day17

## 多线程

### 1 基本概念

-  程序和进程的概念 
  - 程序 - 数据结构 + 算法，主要指存放在硬盘上的可执行文件。 
  - 进程 - 主要指运行在内存中的可执行文件。 
  - 目前主流的操作系统都支持多进程，为了让操作系统同时可以执行多个任务，但进程是重量级的， 也就是新建一个进程会消耗CPU和内存空间等系统资源，因此进程的数量比较局限。 

-  线程的概念 
  - 为了解决上述问题就提出线程的概念，线程就是进程内部的程序流，也就是说操作系统内部支持多 进程的，而每个进程的内部又是支持多线程的，线程是轻量的，新建线程会共享所在进程的系统资 源，因此目前主流的开发都是采用多线程。 
  - 多线程是采用时间片轮转法来保证多个线程的并发执行，所谓并发就是指宏观并行微观串行的机 制 

### 2 线程的创建

-  Thread类的概念
  -  java.lang.Thread类代表线程，任何线程对象都是Thread类（子类）的实例。
  -  Thread类是线程的模板，封装了复杂的线程开启等操作，封装了操作系统的差异性。 

-  创建方式 
  - 自定义类继承Thread类并重写run方法，然后创建该类的对象调用start方法。 
  - 自定义类实现Runnable接口并重写run方法，创建该类的对象作为实参来构造Thread类型的对 象，然后使用Thread类型的对象调用start方法。  

- 相关方法

  | 方法声明                             | 功能介绍                                                     |
  | ------------------------------------ | ------------------------------------------------------------ |
  | Thread()                             | 使用无参的方式构造对象                                       |
  | Thread(String name)                  | 根据参数指定的名称来构造对象                                 |
  | Thread(Runnable target)              | 根据参数指定的引用来构造对象，其中Runnable是个接口类 型      |
  | Thread(Runnable target, String name) | 根据参数指定引用和名称来构造对象                             |
  | void run()                           | 若使用Runnable引用构造了线程对象，调用该方法时最终调 用接口中的版本 <br />若没有使用Runnable引用构造线程对象，调用该方法时则啥 也不做 |
  | void start()                         | 用于启动线程，Java虚拟机会自动调用该线程的run方法            |

  ```java
  
  public class ThreadTest {
  
      public static void main(String[] args) {
  
          // 1.使用无参方式构造Thread类型的对象
          // 由源码可知：Thread类中的成员变量target的数值为null。
          Thread t1 = new Thread();
          // 2.调用run方法进行测试
          // 由源码可知：由于成员变量target的数值为null，因此条件if (target != null)不成立，跳过{}中的代码不执行
          //  而run方法中除了上述代码再无代码，因此证明run方法确实啥也不干
          t1.run();
          // 3.打印一句话
          System.out.println("我想看看你到底是否真的啥也不干！");
      }
  }
  
  ```

  

-  执行流程
  -  执行main方法的线程叫做主线程，执行run方法的线程叫做新线程/子线程。 
  - main方法是程序的入口，对于start方法之前的代码来说，由主线程执行一次，当start方法调用成 功后线程的个数由1个变成了2个，新启动的线程去执行run方法的代码，主线程继续向下执行，两 个线程各自独立运行互不影响。 
  - 当run方法执行完毕后子线程结束，当main方法执行完毕后主线程结束。 
  - 两个线程执行没有明确的先后执行次序，由操作系统调度算法来决定。 

  ```java
  
  public class SubThreadRun extends Thread {
  
      @Override
      public void run() {
          // 打印1 ~ 20之间的所有整数
          for (int i = 1; i <= 20; i++) {
              System.out.println("run方法中：i = " + i); // 1 2 ... 20
          }
      }
  }
  
  ```
  
  ```java
  // 测试run方法与start方法
  public class SubThreadRunTest {
  
      public static void main(String[] args) {
  
          // 1.声明Thread类型的引用指向子类类型的对象
          Thread t1 = new SubThreadRun();
          // 2.调用run方法测试，本质上就是相当于对普通成员方法的调用，因此执行流程就是run方法的代码执行完毕后才能继续向下执行
          //t1.run();
          // 用于启动线程，Java虚拟机会自动调用该线程类中的run方法
          // 相当于又启动了一个线程，加上执行main方法的线程是两个线程
          t1.start();
  
          // 打印1 ~ 20之间的所有整数
          for (int i = 1; i <= 20; i++) {
              System.out.println("-----------------main方法中：i = " + i); // 1 2 ... 20
          }
      }
  }
  
  ```
  
  
  
-   方式的比较 
  
- 继承Thread类的方式代码简单，但是若该类继承Thread类后则无法继承其它类，而实现 Runnable接口的方式代码复杂，但不影响该类继承其它类以及实现其它接口，因此以后的开发中 推荐使用第二种方式。  
  
    ```java
    
    public class SubRunnableRun implements Runnable {
        @Override
        public void run() {
            // 打印1 ~ 20之间的所有整数
            for (int i = 1; i <= 20; i++) {
                System.out.println("run方法中：i = " + i); // 1 2 ... 20
            }
        }
    }
    
    ```
  
    ```java
    
    public class SubRunnableRunTest {
    
        public static void main(String[] args) {
    
            // 1.创建自定义类型的对象，也就是实现Runnable接口类的对象
            SubRunnableRun srr = new SubRunnableRun();
            // 2.使用该对象作为实参构造Thread类型的对象
            // 由源码可知：经过构造方法的调用之后，Thread类中的成员变量target的数值为srr。
            Thread t1 = new Thread(srr);
            // 3.使用Thread类型的对象调用start方法
            // 若使用Runnable引用构造了线程对象，调用该方法(run)时最终调用接口中的版本
            // 由run方法的源码可知：if (target != null) {
            //                         target.run();
            //                    }
            // 此时target的数值不为空这个条件成立，执行target.run()的代码，也就是srr.run()的代码
            t1.start();
            //srr.start();  Error
    
            // 打印1 ~ 20之间的所有整数
            for (int i = 1; i <= 20; i++) {
                System.out.println("-----------------main方法中：i = " + i); // 1 2 ... 20
            }
        }
    }
    
    ```
  
    
  
-   匿名内部类的方式 
  
  - 使用匿名内部类的方式来创建和启动线程。 
  
    ```java
    
    public class ThreadNoNameTest {
    
        public static void main(String[] args) {
    
            // 匿名内部类的语法格式：父类/接口类型 引用变量名 = new 父类/接口类型() { 方法的重写 };
            // 1.使用继承加匿名内部类的方式创建并启动线程
            /*Thread t1 = new Thread() {
                @Override
                public void run() {
                    System.out.println("张三说：在吗？");
                }
            };
            t1.start();*/
            new Thread() {
                @Override
                public void run() {
                    System.out.println("张三说：在吗？");
                }
            }.start();
    
            // 2.使用实现接口加匿名内部类的方式创建并启动线程
            /*Runnable ra = new Runnable() {
                @Override
                public void run() {
                    System.out.println("李四说：不在。");
                }
            };
            Thread t2 = new Thread(ra);
            t2.start();*/
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("李四说：不在。");
                }
            }).start();*/
            // Java8开始支持lambda表达式： (形参列表)->{方法体；}
            /*Runnable ra = ()-> System.out.println("李四说：不在。");
            new Thread(ra).start();*/
    
            new Thread(()-> System.out.println("李四说：不在。")).start();
        }
    }
    
    ```
  
    

### 3 线程的生命周期

![](./picture/Snipaste_2020-11-14_19-49-21.png)

 新建状态 - 使用new关键字创建之后进入的状态，此时线程并没有开始执行。 

就绪状态 - 调用start方法后进入的状态，此时线程还是没有开始执行。 

运行状态 - 使用线程调度器调用该线程后进入的状态，此时线程开始执行，当线程的时间片执行完 毕后任务没有完成时回到就绪状态。 

消亡状态 - 当线程的任务执行完成后进入的状态，此时线程已经终止。

 阻塞状态 - 当线程执行的过程中发生了阻塞事件进入的状态，如：sleep方法。 阻塞状态解除后进入就绪状态。  

###  4 线程的编号和名称 

| 方法声明                      | 功能介绍                            |
| ----------------------------- | ----------------------------------- |
| long getId()                  | 获取调用对象所表示线程的编号        |
| String getName()              | 获取调用对象所表示线程的名称        |
| void setName(String name)     | 设置/修改线程的名称为参数指定的数值 |
| static Thread currentThread() | 获取当前正在执行线程的引用          |

##### 案例  自定义类继承Thread类并重写run方法，在run方法中先打印当前线程的编号和名称，然后将线程 的名称修改为"zhangfei"后再次打印编号和名称。 要求在main方法中也要打印主线程的编号和名称。

```java

public class ThreadIdNameTest extends Thread {

    public ThreadIdNameTest(String name) {
        super(name); // 表示调用父类的构造方法
    }

    @Override
    public void run() {
        System.out.println("子线程的编号是：" + getId() + "，名称是：" + getName()); // 14  Thread-0 guanyu
        // 修改名称为"zhangfei"
        setName("zhangfei");
        System.out.println("修改后子线程的编号是：" + getId() + "，名称是：" + getName()); // 14  zhangfei
    }

    public static void main(String[] args) {

        ThreadIdNameTest tint = new ThreadIdNameTest("guanyu");
        tint.start();

        // 获取当前正在执行线程的引用，当前正在执行的线程是主线程，也就是获取主线程的引用
        Thread t1 = Thread.currentThread();
        System.out.println("主线程的编号是：" + t1.getId() + ", 名称是：" + t1.getName());
    }
}

```

```java

public class RunnableIdNameTest implements Runnable {
    @Override
    public void run() {
        // 获取当前正在执行线程的引用，也就是子线程的引用
        Thread t1 = Thread.currentThread();
        System.out.println("子线程的编号是：" + t1.getId() + "， 名称是：" + t1.getName()); // 14 guanyu
        t1.setName("zhangfei");
        System.out.println("修改后子线程的编号是：" + t1.getId() + "， 名称是：" + t1.getName()); // 14 zhangfei
    }

    public static void main(String[] args) {

        RunnableIdNameTest rint = new RunnableIdNameTest();
        //Thread t2 = new Thread(rint);
        Thread t2 = new Thread(rint, "guanyu");
        t2.start();

        // 获取当前正在执行线程的引用，当前正在执行的线程是主线程，也就是获取主线程的引用
        Thread t1 = Thread.currentThread();
        System.out.println("主线程的编号是：" + t1.getId() + ", 名称是：" + t1.getName());
    }
}

```



### 5 常用方法

| 方法声明                          | 功能介绍                                                     |
| --------------------------------- | ------------------------------------------------------------ |
| static void yield()               | 当前线程让出处理器（离开Running状态），使当前线程进入Runnable 状态等待 |
| static void sleep(times)          | 使当前线程从 Running 放弃处理器进入Block状态, 休眠times毫秒, 再返 回到Runnable如果其他线程打断当前线程的Block(sleep), 就会发生 InterruptedException。 |
| int getPriority()                 | 获取线程的优先级                                             |
| void setPriority(int newPriority) | 修改线程的优先级。 优先级越高的线程不一定先执行，但该线程获取到时间片的机会会更多 一些 |
| void join()                       | 等待该线程终止                                               |
| void join(long millis)            | 等待参数指定的毫秒数                                         |
| boolean isDaemon()                | 用于判断是否为守护线程                                       |
| void setDaemon(boolean on)        | 用于设置线程为守护线程                                       |

```java

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

//static void sleep(times)方法测试

public class ThreadSleepTest extends Thread {
    // 声明一个布尔类型的变量作为循环是否执行的条件
    private boolean flag = true;

    // 子类中重写的方法不能抛出更大的异常
    @Override
    public void run() {
        // 每隔一秒获取一次系统时间并打印，模拟时钟的效果
        while (flag) {
            // 获取当前系统时间并调整格式打印
//            LocalDateTime.now();
            Date d1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(d1));

            // 睡眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ThreadSleepTest tst = new ThreadSleepTest();
        tst.start();

        // 主线程等待5秒后结束子线程
        System.out.println("主线程开始等待...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 停止子线程  过时  不建议使用
        //tst.stop();
        tst.flag = false;
        System.out.println("主线程等待结束！");
    }
}

```

```java
// int getPriority(), void setPriority(int newPriority)  方法测试

public class ThreadPriorityTest extends Thread {
    @Override
    public void run() {
        //System.out.println("子线程的优先级是：" + getPriority()); // 5  10  优先级越高的线程不一定先执行。
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程中：i = " + i);
        }
    }

    public static void main(String[] args) {

        ThreadPriorityTest tpt = new ThreadPriorityTest();
        // 设置子线程的优先级
        tpt.setPriority(Thread.MAX_PRIORITY);
        tpt.start();

        Thread t1 = Thread.currentThread();
        //System.out.println("主线程的优先级是：" + t1.getPriority()); // 5 普通的优先级
        for (int i = 0; i < 20; i++) {
            System.out.println("--主线程中：i = " + i);
        }
    }

}

```

```java
// void join() 方法测试

public class ThreadJoinTest extends Thread {
    @Override
    public void run() {
        // 模拟倒数10个数的效果
        System.out.println("倒计时开始...");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("新年快乐！");
    }

    public static void main(String[] args) {

        ThreadJoinTest tjt = new ThreadJoinTest();
        tjt.start();

        // 主线程开始等待
        System.out.println("主线程开始等待...");
        try {
            // 表示当前正在执行的线程对象等待调用线程对象，也就是主线程等待子线程终止
            //tjt.join();
            tjt.join(5000); // 最多等待5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("终于等到你，还好没放弃！");
        System.out.println("可惜不是你，陪我到最后！");
    }
}

```

```java
// boolean isDaemon()	void setDaemon(boolean on)  方法测试

public class ThreadDaemonTest extends Thread {
    @Override
    public void run() {
        //System.out.println(isDaemon()? "该线程是守护线程": "该线程不是守护线程"); // 默认不是守护线程
        // 当子线程不是守护线程时，虽然主线程先结束了，但是子线程依然会继续执行，直到打印完毕所有数据为止
        // 当子线程是守护线程时，当主线程结束后，则子线程随之结束
        for (int i = 0; i < 50; i++) {
            System.out.println("子线程中：i = " + i);
        }
    }

    public static void main(String[] args) {

        ThreadDaemonTest tdt = new ThreadDaemonTest();
        // 必须在线程启动之前设置子线程为守护线程
        tdt.setDaemon(true);
        tdt.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("-------主线程中：i = " + i);
        }
    }
}

```



##### 案例  编程创建两个线程，线程一负责打印1 ~ 100之间的所有奇数，其中线程二负责打印1 ~ 100之间的 所有偶数。 在main方法启动上述两个线程同时执行,主线程等待两个线程终止。 

```java
// 接口方式线程1
public class SubRunnable1 implements Runnable {
    @Override
    public void run() {
        // 打印1 ~ 100之间的所有奇数
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("子线程一中： i = " + i);
        }
    }
}

```

```java
// 接口方式线程2
public class SubRunnable2 implements Runnable {
    @Override
    public void run() {
        // 打印1 ~ 100之间的所有偶数
        for (int i = 2; i <= 100; i += 2) {
            System.out.println("------子线程二中： i = " + i);
        }
    }
}

```

```java
// 接口方式执行类
public class SubThreadTest {

    public static void main(String[] args) {

        SubThread1 st1 = new SubThread1();
        SubThread2 st2 = new SubThread2();

        st1.start();
        st2.start();

        System.out.println("主线程开始等待...");
        try {
            st1.join();
            st2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程等待结束！");
    }
}

```



```java
// 继承方式 线程1


public class SubThread1 extends Thread {
    @Override
    public void run() {
        // 打印1 ~ 100之间的所有奇数
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("子线程一中： i = " + i);
        }
    }
}

```

```java
// 继承方式 线程2

public class SubThread2 extends Thread {
    @Override
    public void run() {
        // 打印1 ~ 100之间的所有偶数
        for (int i = 2; i <= 100; i += 2) {
            System.out.println("------子线程二中： i = " + i);
        }
    }
}

```

```java
// 继承方式 实现类

public class SubThreadTest {

    public static void main(String[] args) {

        SubThread1 st1 = new SubThread1();
        SubThread2 st2 = new SubThread2();

        st1.start();
        st2.start();

        System.out.println("主线程开始等待...");
        try {
            st1.join();
            st2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程等待结束！");
    }
}

```



### 6   线程同步机制 

-  基本概念 
  - 当多个线程同时访问同一种共享资源时，可能会造成数据的覆盖等不一致性问题，此时就需要对线 程之间进行通信和协调，该机制就叫做线程的同步机制。 
  - 多个线程并发读写同一个临界资源时会发生线程并发安全问题。 
  - 异步操作:多线程并发的操作，各自独立运行。
  -  同步操作:多线程串行的操作，先后执行的顺序。 

-  解决方案
  -  由程序结果可知：当两个线程同时对同一个账户进行取款时，导致最终的账户余额不合理。 
  - 引发原因：线程一执行取款时还没来得及将取款后的余额写入后台，线程二就已经开始取款。 
  - 解决方案：让线程一执行完毕取款操作后，再让线程二执行即可，将线程的并发操作改为串行操 作。 
  - 在以后的开发尽量减少串行操作的范围，从而提高效率。 


-  实现方式 

  - 在Java语言中使用synchronized关键字来实现同步/对象锁机制从而保证线程执行的原子性，具体 方式如下： 

    ```java
    使用同步代码块的方式实现部分代码的锁定，格式如下：
     synchronized(类类型的引用) {
     编写所有需要锁定的代码；
     }
    使用同步方法的方式实现所有代码的锁定。
    直接使用synchronized关键字来修饰整个方法即可
    该方式等价于:
     synchronized(this) { 整个方法体的代码 } 
    ```




```java
import java.util.concurrent.locks.ReentrantLock;

// 接口方式 锁定

public class AccountRunnableTest implements Runnable {
    private int balance; // 用于描述账户的余额
    private Demo dm = new Demo();
    private ReentrantLock lock = new ReentrantLock();  // 准备了一把锁

    public AccountRunnableTest() {
    }

    public AccountRunnableTest(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public /*synchronized*/ void run() {
        // 开始加锁
        lock.lock();

        // 由源码可知：最终是account对象来调用run方法，因此当前正在调用的对象就是account，也就是说this就是account
        //synchronized (this) { // ok
        System.out.println("线程" + Thread.currentThread().getName() + "已启动...");
        //synchronized (dm) { // ok
        //synchronized (new Demo()) { // 锁不住  要求必须是同一个对象
            // 1.模拟从后台查询账户余额的过程
            int temp = getBalance(); // temp = 1000  temp = 1000
            // 2.模拟取款200元的过程
            if (temp >= 200) {
                System.out.println("正在出钞，请稍后...");
                temp -= 200;  // temp = 800   temp = 800
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("请取走您的钞票！");
            } else {
                System.out.println("余额不足，请核对您的账户余额！");
            }
            // 3.模拟将最新的账户余额写入到后台
            setBalance(temp); // balance = 800  balance = 800
        //}
        lock.unlock(); // 实现解锁
    }

    public static void main(String[] args) {

        AccountRunnableTest account = new AccountRunnableTest(1000);
        //AccountRunnableTest account2 = new AccountRunnableTest(1000);
        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);
        //Thread t2 = new Thread(account2);
        t1.start();
        t2.start();

        System.out.println("主线程开始等待...");
        try {
            t1.join();
            //t2.start(); // 也就是等待线程一取款操作结束后再启动线程二
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的账户余额为：" + account.getBalance()); // 600  800
    }
}

class Demo{}

```



```java
// 继承方式

public class AccountThreadTest extends Thread {
    private int balance; // 用于描述账户的余额
    private static Demo dm = new Demo(); // 隶属于类层级，所有对象共享同一个

    public AccountThreadTest() {
    }

    public AccountThreadTest(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public /*static*/ /*synchronized*/ void run() {
        /*System.out.println("线程" + Thread.currentThread().getName() + "已启动...");
        //synchronized (dm) { // ok
            //synchronized (new Demo()) { // 锁不住  要求必须是同一个对象
            // 1.模拟从后台查询账户余额的过程
            int temp = getBalance(); // temp = 1000  temp = 1000
            // 2.模拟取款200元的过程
            if (temp >= 200) {
                System.out.println("正在出钞，请稍后...");
                temp -= 200;  // temp = 800   temp = 800
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("请取走您的钞票！");
            } else {
                System.out.println("余额不足，请核对您的账户余额！");
            }
            // 3.模拟将最新的账户余额写入到后台
            setBalance(temp); // balance = 800  balance = 800
        //}*/
        test();
    }

    public /*synchronized*/ static void test() {
        synchronized (AccountThreadTest.class) { // 该类型对应的Class对象，由于类型是固定的，因此Class对象也是唯一的，因此可以实现同步
            System.out.println("线程" + Thread.currentThread().getName() + "已启动...");
            //synchronized (dm) { // ok
            //synchronized (new Demo()) { // 锁不住  要求必须是同一个对象
            // 1.模拟从后台查询账户余额的过程
            int temp = 1000; //getBalance(); // temp = 1000  temp = 1000
            // 2.模拟取款200元的过程
            if (temp >= 200) {
                System.out.println("正在出钞，请稍后...");
                temp -= 200;  // temp = 800   temp = 800
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("请取走您的钞票！");
            } else {
                System.out.println("余额不足，请核对您的账户余额！");
            }
            // 3.模拟将最新的账户余额写入到后台
            //setBalance(temp); // balance = 800  balance = 800
        }
    }

    public static void main(String[] args) {

        AccountThreadTest att1 = new AccountThreadTest(1000);
        att1.start();

        AccountThreadTest att2 = new AccountThreadTest(1000);
        att2.start();

        System.out.println("主线程开始等待...");
        try {
            att1.join();
            //t2.start(); // 也就是等待线程一取款操作结束后再启动线程二
            att2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的账户余额为：" + att1.getBalance()); // 800

    }

    }

```



-  静态方法的锁定 

  - 当我们对一个静态方法加锁，如: 

    ```
    public synchronized static void xxx(){….}
    ```

  -  那么该方法锁的对象是类对象。每个类都有唯一的一个类对象。获取类对象的方式:类名.class。

  - 静态方法与非静态方法同时使用了synchronized后它们之间是非互斥关系的。 

  - 原因在于：静态方法锁的是类对象而非静态方法锁的是当前方法所属对象。 

-  注意事项 
  - 使用synchronized保证线程同步应当注意: 
    - 多个需要同步的线程在访问同步块时，看到的应该是同一个锁对象引用。 
    - 在使用同步块时应当尽量减少同步范围以提高并发的执行效率。 

-  线程安全类和不安全类 
  - StringBuffer类是线程安全的类，但StringBuilder类不是线程安全的类。 
  - Vector类和 Hashtable类是线程安全的类，但ArrayList类和HashMap类不是线程安全的类。 
  - Collections.synchronizedList() 和 Collections.synchronizedMap()等方法实现安全。 

-   死锁的概念 

  - 线程一执行的代码：

    ```java
    public void run(){
     	synchronized(a){ //持有对象锁a，等待对象锁b
     		synchronized(b){
     		编写锁定的代码;
     		}
     	}
    }
    
    ```

    

  - 线程二执行的代码： 

    ```
    public void run(){
     	synchronized(b){ //持有对象锁b，等待对象锁a
     		synchronized(a){
     			编写锁定的代码;
     		}
     	}
    }
    ```

    

  - 注意： 在以后的开发中尽量减少同步的资源，减少同步代码块的嵌套结构的使用！ 

-  使用Lock（锁）实现线程同步

  - 基本概念 

    -  从Java5开始提供了更强大的线程同步机制—使用显式定义的同步锁对象来实现。 
    - java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。 
    - 该接口的主要实现类是ReentrantLock类，该类拥有与synchronized相同的并发性，在以后的线程 安全控制中，经常使用ReentrantLock类显式加锁和释放锁。 

  - 常用方法

    - | 方法声明        | 功能介绍             |
      | --------------- | -------------------- |
      | ReentrantLock() | 使用无参方式构造对象 |
      | void lock()     | 获取锁               |
      | void unlock()   | 释放锁               |

  -  与synchronized方式的比较 
    - Lock是显式锁，需要手动实现开启和关闭操作，而synchronized是隐式锁，执行锁定代码后自动 释放。 
    - Lock只有同步代码块方式的锁，而synchronized有同步代码块方式和同步方法两种锁。 
    - 使用Lock锁方式时，Java虚拟机将花费较少的时间来调度线程，因此性能更好。 

-  Object类常用的方法 

  | 方法声明                | 功能介绍                                                     |
  | ----------------------- | ------------------------------------------------------------ |
  | void wait()             | 用于使得线程进入等待状态，直到其它线程调用notify()或notifyAll()方 法 |
  | void wait(long timeout) | 用于进入等待状态，直到其它线程调用方法或参数指定的毫秒数已经过 去为止 |
  | void notify()           | 用于唤醒等待的单个线程                                       |
  | void notifyAll()        | 用于唤醒等待的所有线程                                       |



```java


public class ThreadCommunicateTest implements Runnable {
    private int cnt = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 每当有一个线程进来后先大喊一声，调用notify方法
                notify();
                if (cnt <= 100) {
                    System.out.println("线程" + Thread.currentThread().getName() + "中：cnt = " + cnt);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cnt++;
                    // 当前线程打印完毕一个整数后，为了防止继续打印下一个数据，则调用wait方法
                    try {
                        wait(); // 当前线程进入阻塞状态，自动释放对象锁，必须在锁定的代码中调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        ThreadCommunicateTest tct = new ThreadCommunicateTest();
        Thread t1 = new Thread(tct);
        t1.start();

        Thread t2 = new Thread(tct);
        t2.start();
    }
}

```



![](./picture/01 生产者消费者模型.png)

```java

/**
 * 编程实现仓库类
 */
public class StoreHouse {
    private int cnt = 0; // 用于记录产品的数量

    public synchronized void produceProduct() {
        notify();
        if (cnt < 10) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在生产第" + (cnt+1) + "个产品...");
            cnt++;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct() {
        notify();
        if (cnt > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "消费第" + cnt + "个产品");
            cnt--;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

```

```java

/**
 * 编程实现生产者线程，不断地生产产品
 */
public class ProduceThread extends Thread {
    // 声明一个仓库类型的引用作为成员变量，是为了能调用调用仓库类中的生产方法   合成复用原则
    private StoreHouse storeHouse;
    // 为了确保两个线程共用同一个仓库
    public ProduceThread(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    @Override
    public void run() {
        while (true) {
            storeHouse.produceProduct();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

```

```java

public class ConsumerThread extends Thread {
    // 声明一个仓库类型的引用作为成员变量，是为了能调用调用仓库类中的生产方法   合成复用原则
    private StoreHouse storeHouse;
    // 为了确保两个线程共用同一个仓库
    public ConsumerThread(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    @Override
    public void run() {
        while (true) {
            storeHouse.consumerProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

```

```java

public class StoreHouseTest {

    public static void main(String[] args) {

        // 创建仓库类的对象
        StoreHouse storeHouse = new StoreHouse();
        // 创建线程类对象并启动
        ProduceThread t1 = new ProduceThread(storeHouse);
        ConsumerThread t2 = new ConsumerThread(storeHouse);
        t1.start();
        t2.start();
    }
}

```



- 线程池

  

  -  实现Callable接口 

    - 从Java5开始新增加创建线程的第三种方式为实现java.util.concurrent.Callable接口。 

    - 常用的方法如下： 
  
      | 方法声明 | 功能介绍       |
    | -------- | -------------- |
      | V call() | 计算结果并返回 |

  -  FutureTask类

    - java.util.concurrent.FutureTask类用于描述可取消的异步计算，该类提供了Future接口的基本实 现，包括启动和取消计算、查询计算是否完成以及检索计算结果的方法，也可以用于获取方法调用 后的返回结果。 

    - 常用的方法如下： 
  
      | 方法声明                         | 功能介绍                             |
      | -------------------------------- | ------------------------------------ |
    | FutureTask(Callable<V> callable) | 根据参数指定的引用来创建一个未来任务 |
      | V get()                          | 获取call方法计算的结果               |

  ```java
  import java.util.concurrent.Callable;
    import java.util.concurrent.ExecutionException;
  import java.util.concurrent.FutureTask;
  
    public class ThreadCallableTest implements Callable {
  
        @Override
      public Object call() throws Exception {
            // 计算1 ~ 10000之间的累加和并打印返回
          int sum = 0;
            for (int i = 1; i <= 10000; i++) {
              sum +=i;
            }
            System.out.println("计算的累加和是：" + sum); // 50005000
            return sum;
        }
        
      public static void main(String[] args) {
        
          ThreadCallableTest tct = new ThreadCallableTest();
            FutureTask ft = new FutureTask(tct);
            Thread t1 = new Thread(ft);
            t1.start();
            Object obj = null;
            try {
              obj = ft.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("线程处理方法的返回值是：" + obj); // 50005000
        }
  
    }
  ```



  -  线程池的由来 
  
    - 在服务器编程模型的原理，每一个客户端连接用一个单独的线程为之服务，当与客户端的会话结束 时，线程也就结束了，即每来一个客户端连接，服务器端就要创建一个新线程。 
    - 如果访问服务器的客户端很多，那么服务器要不断地创建和销毁线程，这将严重影响服务器的性 能。  
  
  -  概念和原理 
  
    - 线程池的概念：首先创建一些线程，它们的集合称为线程池，当服务器接受到一个客户请求后，就 从线程池中取出一个空闲的线程为之服务，服务完后不关闭该线程，而是将该线程还回到线程池 中。 
    - 在线程池的编程模式下，任务是提交给整个线程池，而不是直接交给某个线程，线程池在拿到任务 后，它就在内部找有无空闲的线程，再把任务交给内部某个空闲的线程，任务是提交给整个线程 池，一个线程同时只能执行一个任务，但可以同时向一个线程池提交多个任务。  
  
  -  相关类和方法 
  
    - 从Java5开始提供了线程池的相关类和接口：java.util.concurrent.Executors类和 java.util.concurrent.ExecutorService接口。 
    
    -  其中Executors是个工具类和线程池的工厂类，可以创建并返回不同类型的线程池，常用方法如下
    
      | 方法声明                                                | 功能介绍                              |
      | ------------------------------------------------------- | ------------------------------------- |
      | static ExecutorService newCachedThreadPool()            | 创建一个可根据需要创建新线程的 线程池 |
      | static ExecutorService newFixedThreadPool(int nThreads) | 创建一个可重用固定线程数的线程 池     |
      | static ExecutorService newSingleThreadExecutor()        | 创建一个只有一个线程的线程池          |
    
    -  其中ExecutorService接口是真正的线程池接口，主要实现类是ThreadPoolExecutor，常用方法 如下 
    
      | 方法声明                           | 功能介绍                             |
      | ---------------------------------- | ------------------------------------ |
      | void execute(Runnable command)     | 执行任务和命令，通常用于执行Runnable |
      | <T>Future<T> submit(Callable task) | 执行任务和命令，通常用于执行Callable |
      | void shutdown()                    | 启动有序关闭                         |
    
      ```java
      
      import java.util.concurrent.ExecutorService;
      import java.util.concurrent.Executors;
      
      public class ThreadPoolTest {
      
          public static void main(String[] args) {
      
              // 1.创建一个线程池
              ExecutorService executorService = Executors.newFixedThreadPool(10);
              // 2.向线程池中布置任务
              executorService.submit(new ThreadCallableTest());
              // 3.关闭线程池
              executorService.shutdown();
          }
      }
      
      ```

​      