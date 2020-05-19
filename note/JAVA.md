# 多线程与高并 发

## 进程、线程、纤程

### 什么是进程、线程（面试高频）

回答1：进程就是一个程序运行起来的状态，线程是一个进程中不同的执行路径。

回答2（专业）：进程是OS分配资源的进本单位，线程是执行调度的基本单位。

### 进程

**概念：** Linux中也称为task，是系统分配资源的基本单位。

**资源：** 独立的地址空间，内核数据结构，全局变量数据段。

**僵尸进程：** 父进程产生子进程后，会维护子进程的一个PCB结构，子进程退出，由父进程释放。如果父进程没有释放，那么子进程成为一个僵尸进程。

**孤儿进程：** 子进程结束之前，父进程已经退出。（孤儿进程会成为init进程的孩子，由1号进程维护）

**进程调度：** 内核进程调度器决定。

1. 该哪一个进程运行。
2. 何时开始。
3. 运行多长时间。

Linux中每一个进程都有自己的调度方案。

### 线程

**概念：** 一个程序里不同的执行路径。

#### **线程常用方法：** 

1. start()：线程启动

2. wait()：使线程处于一种等待状态，释放所持有的对象锁。

3. sleep()：当前线程暂停一段时间让给其他线程。是一个静态方法，调用它时要捕获InterruptedException异常，不释放对象锁。

4. join()：当我们调用某个线程的这个方法时，这个方法会挂起调用线程，直到被调用线程结束执行，调用线程才会继续执行。

5. yield()：yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获取执行权；但是，并不能保证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；也有可能是当前线程又进入到“运行状态”继续运行！

6. notify()：唤醒一个正在等待状态的线程。注意调用此方法时，并不能确定唤醒的是哪一个等待状态的线程，是由JVM来决定唤醒哪个线程，不是由线程优先级决定的。

7. notiflyAll()：唤醒所有等待状态的线程，注意并不是给所有唤醒线程一个对象锁，而是让它们竞争。

#### **线程创建的几种方式**

1、继承Thread类创建线程。

（1）   定义Thread类的子类MyThread，并重写run()方法，run()方法的方法体（线程执行体）就是线程要执行的任务。

（2）   创建MyThread类的实例

（3）   调用子类实例的start()方法来启动线程。

例：

```java
public class Mythread extends Thread {
	
	private int i;
	public void run(){//run()是线程类的核心方法
		for(int i=0;i<10;i++){
			System.out.println(this.getName()+":"+i);
		}
	}
	public static void main(String[] args) {
		Mythread t1 = new Mythread();
		Mythread t2 = new Mythread();
		Mythread t3 = new Mythread();
		t1.start();
		t2.start();
		t3.start();
	}

```

2、实现Runnable接口创建线程。

（1）   定义Runable接口的实现类，必须重写run()方法，这个run()方法和Thread中的run()方法一样，是线程的执行体。

（2）   创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象。

（3）   调用start()方法。

```java
public class MyThread implements Runnable{
 
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
		
	}
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread1 = new Thread(myThread,"线程1");
		Thread thread2 = new Thread(myThread,"线程2");
		Thread thread3 = new Thread(myThread,"线程3");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

```

3、 使用Callable和Future创建线程。

和Runnable接口不一样，Callable接口提供了一个call()方法作为线程执行体，call()方法功能要强大。

Call()方法可以有返回值

Call()方法可以声明抛出异常

（1）   创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例。

（2）   使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值

（3）   使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）

（4）   调用FutureTask对象的get()方法来获得子线程执行结束后的返回值。

```java
public class MyThread implements Callable<String>{//Callable是一个泛型接口
 
	@Override
	public String call() throws Exception {//返回的类型就是传递过来的V类型
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
		
		return "Hello Tom";
	}
	public static void main(String[] args) throws Exception {
		MyThread myThread=new MyThread();
		FutureTask<String> futureTask=new FutureTask<>(myThread);
		Thread t1=new Thread(futureTask,"线程1");
		Thread t2=new Thread(futureTask,"线程2");
		Thread t3=new Thread(futureTask,"线程3");
		t1.start();
		t2.start();
		t3.start();
		System.out.println(futureTask.get());
		
	}
}

```

4、 使用线程池创建（使用java.util.concurrent.Executor接口）

​	线程池提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁额外开销，提交了响应速度。

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//线程池实现
public class ThreadPoolExecutorTest {
 
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPool threadPool = new ThreadPool();
        for(int i =0;i<5;i++){
            //为线程池分配任务
            executorService.submit(threadPool);
        }
        //关闭线程池
        executorService.shutdown();
    }
}
 
class ThreadPool implements Runnable {
 
    @Override
    public void run() {
        for(int i = 0 ;i<10;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}

```

#### 线程状态

+ 新建（new）：创建后尚未启动的线程处于这种状态。
+ 运行（Runable）：Runable包含了操作系统线程状态的*Running*和*Ready*，也就是处于此状态的线程有可能正在执行，也可能正在等待着CPU为它分配执行时间。
+ 等待（waiting）：处于这种状态的线程不会被分配CPU执行时间。等待状态又分为无限期等待和有限期等待，处于无限期等待的线程需要被其他线程显示地唤醒，没有设置Timeout参数的Object.wait()、没有设置Timeout参数的Thread.join()方法都会使线程进入无限期等待状态；有限期等待状态无须等待被其他线程显示地唤醒，在一定时间之后它们会由系统自动唤醒，Thread.sleep()、设置了Timeout参数的Object.wait()、设置了Timeout参数的Thread.join()方法都会使线程进入有限期等待状态。
+ **阻塞（Blocked）：**线程被阻塞了，“阻塞状态”与“等待状态”的区别是，“阻塞状态”在等待着获取到一个排他锁，这个时间将在另一个线程放弃这个锁的时候发生；而“等待状态”则是在等待了一段时间或者唤醒动作的发生。在程序等待进入同步区域的时候，线程将进入这种状态。
+ **结束（Terminated）：**已终止线程的线程状态，线程已经结束执行。

![](JAVA.assets/线程状态转换图.png)

​                                                     (线程状态转换图)

### 纤程

**概念：** 线程中的线程，用户空间的线程，用户态的线程，切换和调度不需要经过OS。

**纤程优势：** 

1.  占有资源少。     OS：纤程1M， Fiber：4k
2. 切换比较简单。
3. 可以启动很多个    10w

**纤程应用场景：** 很短的计算任务，不需要和内核打交道，并发量高。

### 附

分配资源最重要的是有独立的内存空间。

线程调度执行线程共享进程的内存空间，没有自己的内存空间。

在Linux中，线程是一个普通的进程。只不过和其他进程共享资源（内存空间，全局数据）。

1. **start()和run()的区别**

   Start会新开一个线程来执行，而run只是一个普通方法，相当于当前线程来调用，不会启动新线程。

2. **sleep()和wait()的区别**

   ​    Sleep()方法是线程类（Thread）的静态方法，让调用线程进入睡眠状态，让出执行机会给其他线程，等到休眠时间结束后，线程进入就绪状态和其他线程一起竞争cpu的执行时间。

   ​    因为sleep()是static静态方法，他不能改变对象的机锁，当一个synchronized块中调用了sleep()方法，线程虽然进入休眠，但是对象的机锁没有被释放，其他线程依然无法访问这个对象。

   ​    wait()是Object类的方法，当一个线程执行到wait方法时，它就进入到一个和该对象相关的等待池，同时释放对象的机锁，使得其他线程能够访问，可以通过notify，notifyAll方法来唤醒等待的线程。

**线程的生命周期图**

![](JAVA.assets/线程的生命周期.png)

## synchronized关键字

### 概念

多个线程去访问一个资源的时候需要对这个资源上锁。

### 底层实现

JDK早期的synchronized重量级，都是要去找OS申请锁。造成synchronized效率很低。后来做过改进，有一个锁升级的概念。

**锁升级**：

+ **偏向锁**：第一个访问某把锁的线程，sync (object) ，先在Object的头上面的markword记录这个线程（线程号），没有加锁。如果有线程争用，升级为 **自旋锁**
+ **自旋锁**：默认自旋10次后，如果还得不到这把锁。升级为**重量级锁**
+ **重量级锁**：去OS系统申请资源。

自旋锁占用CPU资源，重量级锁不占用CPU资源，所以执行时间长、线程多重量级锁更好。执行时间短、线程少用自旋锁。

> 《我就是厕所所长》一 二

### 附

既保证了原子性，又保证了可见性。

锁的是对象而不是代码。

可重入锁

程序在执行过程中，如果出现异常，默认情况锁会被释放

## volatile

### 两个作用

1. 保证线程可见性。
2. 禁止指令重排序
   - DCL单例
   - Double Check Lock
   - Mgr06.java

深入的原理是loadfence CPU原语指令，和storefence原语指令。（读写屏障）

### 线程的可见性

一个线程对共享变量值的修改，能够及时的被其他线程看到。

本质上使用了CPU的缓存一致性协议（MESI）

### 指令重排序

new一个对象的时候分为三步

1. 为对象申请内存。（此时的值为默认值，如int i = 0;）
2. 对象的成员变量初始化。（此时的值为真正的值，如int i = 8;）
3. 把变量指向内存。

如果此时发生指令重排序，步骤3在步骤2之前发生，此时下一个线程进来，会发现对象应该创建完毕，会使用默认的值（int i = 0;）。

volatile不能保证线程的原子性，无法替代synchronized。

## 详解volatile

![image-20200515161923319](JAVA.assets/image-20200515161923319.png)

### 概念 

在多线程并发场景中**volatile**能够保障共享变量的可见性。

那么问题来了，什么是可见性？volatile是怎么保障共享变量的可见性的？

### 线程与线程间的通信

在说可见性之前，我们先来了解在多线程的条件下，线程与线程之间是怎么通信的，如下图。

![image-20200515162419616](JAVA.assets/image-20200515162419616.png)

在Java线程中每次的**读取**和**写入**不会直接操作主内存，因为CPU的速度远快于主内存的速度，若是直接操作主内存，大大限制了CPU的性能，对性能有很大的影响，所以每条线程都有各自的**工作内存**。

这里的**工作内存**类似于**缓存**，并非实际存在的，因为缓存的读取和写入速度远大于主内存，这样就大大提高了CPU与**数据交互的性能**。

所有的**共享变量**都是直接存储于**主内存**中，工作内存保存线程在使用主内存共享变量的**副本**，当操作完工作内存的变量，会写入主内存，完成对共享变量的读取和写入。

在单线程时代，不存在数据不一致性的问题，线程都是排队的顺序执行，前面的线程执行完才会到后面的线程执行。

![image-20200519141457210](JAVA.assets/image-20200519141457210.png)

随着计算机的发展，到了**多核多线程**时代，**缓存**的出现虽然提升了CPU的执行效率，但是却出现了**缓存一致性**的问题，为了解决数据的一致性问题，提出两种解决方案：

1. **总线上加Lock锁**：该方法简单粗暴，在总线上加锁，其他CPU的线程只能排队等候，效率低下。
2. **缓存一致性协议**：该方案是JMM提出的解决方案，通过对变量地址加锁，减小锁的粒度，执行变得更加高效。

为了提高程序的执行效率，设计者们提出了底层对编译器和执行器（处理器）的优化方案，分别是**编译器**和**处理器**的**重排序**。

### 编译器和处理器的重排序

**编译器重排序**就是在不改变单线程的语义前提下，可以重新排列语句的执行顺序。

**处理器重排序**是在机器指令层面，假如不存在数据依赖，处理器可以改变机器指令的执行顺序，为了提高程序的执行效率，在多线程中假如两行代码存在数据依赖，将会被禁止重排序。

不管是**编译器重排序**和**处理器重排序**，前提条件都**不能改变单线程语义**的前提下进行重排序，说白了就是最后的**执行结果要准确无误**。

我们的程序用高级语言写完后是不能被各大平台的机器所执行的，需要执行**编译**，然后将编译后的**字节码文件**处理成**机器指令**，才能被计算机执行。

从java源代码到最终的机器执行指令，分别会经过下面三种重排序：

![image-20200519142712777](JAVA.assets/image-20200519142712777.png)

### 什么是数据依赖

数据依赖就是假设一句代码中对一个变量 `a++` 自增，然后后一句代码 `b = a` 将a的值赋值给b，便表示这两句代码存在数据依赖，两局代码执行顺序不能互换。

前面提到编译器和处理器重排序，在编译器和处理器进行重排序的时候，就会遵守数据的依赖性，编译器和处理器就会禁止存在数据依赖的两个操作进行重排序，保证了数据的准确性。

从`JDK5`开始，为了保证程序的有序性，便提出了`happen-before`原则。假如两个操作符合该原则，那么这两个操作可以随意的进行重排序，并不会影响结果的正确性。

### happen-before原则

1. 同一个线程中前面的操作先于后续的操作（但是这个并不是绝对的，假如在单线程的环境下，重排序后不会影响结果的准确性，是可以进行重排序，不按代码的顺序直行）。
2. `Synchronized` 规则中解锁操作先于后续的加锁操作。
3. `volatile` 规则中写操作先于后续的读取操作，保证数据的可见性。
4. 一个线程的`start()`方法先于任何该线程的所有后续操作。
5. 线程的所有操作先于其他该线程在该线程上调用`Join()`返回成功的操作。
6. 如果操作a先于操作b，操作b先于操作c，那么操作a先于操作c，传递性原理。

### volatile关键字

我们来看重点第三条，也就是我们今天所了解的重点volatile关键字，为了实现volatile内存语义，规定有volatile修饰的共享变量在机器指令层面会出现Lock前缀的指令。

我们来看一个经典的例子，具体的代码如下：

```java
public class TestVolatile extends Thread {
    private static boolean flag = false;

    public void run() {
        while (!flag) ;
        System.out.println("run方法退出了")
    }

    public static void main(String[] args) throws Exception {
        new TestVolatile().start();
        Thread.sleep(5000);
        flag = true;
    }
}
```

看上面的代码执行run方法能执行退出吗？是不能的，因为对于这两个线程来说，首先`new TestVolatile().start()`线程拿到`flag`共享变量的值为false，并存储在于自己的工作内存中。

第一个线程到while循环中，就直接进入死循环，即使主线程读取flag的值，然后改变该值为true。

但是对于第一个线程来说并不知道，flag的值已经被修改，在第一个线程的工作内存中flag仍然为false。具体的执行原理图如下：

![image-20200519150836460](JAVA.assets/image-20200519150836460.png)

这样对于共享变量flag，主线程修改后，对于线程1来说是不可见的，然后我们加上volatile变量修饰该变量，修改代码如下：

```java
private static volatile boolean flag = false;
```

输出的结果中，就会输出run方法退出了，具体的原理假如一个共享变量被`volatile`修饰，该指令在多核处理器下会引发两件事情。

1. 将当前处理器缓存行数据写回主内存中。
2. 这个写入操作会让其他处理器中已经缓存了该变量的内存地址失效，当其它处理器需求再次使用该变量时，必须从主内存中重新读取该值。

让我们具体从idea的输出的**汇编指令**中可以看出，我们看到红色线框里面的那行指令：`putstatic flag` ，将静态变量`flag`入栈，注意观察add指令前面有一个`lock`前缀指令。

![image-20200519151500392](JAVA.assets/image-20200519151500392.png)

> 注意：让idea输出程序的汇编指令，在启动程序的时候，可以加上
> `-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly`作为启动参数，就可以查看汇编指令。

简单的说被volatile修饰的共享变量，在lock指令后是一个原子操作，该原子操作不会被其它线程的调度机制打断，该原子操作一旦执行就会运行到结束，中间不会切换到任意一个线程。

当使用lock前缀的机器指令，它会向cpu发送一个LOCK#信号，这样能保证在多核多线程的情况下互斥的使用该共享变量的内存地址。直到执行完毕，该锁定才会消失。



## CAS(无锁优化 自旋 乐观锁)

### 概念

CAS : Compare And Swap/Set

### 实现

CPU原语支持，处理中不能被打断。

 CAS操作中包含三个操作数——需要读写的内存位置（V）、进行比较的预期原值（A）和拟写入的新值（B）。如果内存位置V的值与预期原值A相匹配，那么处理器会自动将该位置值更新为新值B。否则处理器不做任何操作。无论哪种情况，它都会在CAS指令之前返回该位置的值。（在CAS的一些特殊情况下将仅返回CAS是否成功，而不提取当前值。）CAS有效地说明了“我认为位置V应该包含值A；如果包含该值，则将B放到这个位置；否则，不要更改该位置，只告诉我这个位置现在的值即可。”这其实和乐观锁的冲突检查+数据更新的原理是一样的。

cas(V, Expected, NewValue)

if V == Expected

V = New

otherwise try again or fail

### ABA问题

如果内存地址V初次读取的值是A，并且在准备赋值的时候检查到它的值仍然是A，那我们就能说它的值没有被其他线程改变过了么？如果在这段期间它的值曾经被改成了B，后来又被改回为A，那CAS操作就会误认为它从来没有被改变过。这个漏洞称为CAS操作的“ABA”问题。AVA并发包为了解决这个问题，提供了一个带有标记的原子引用类“AtomicStampedReference”，它可以通过控制变量值的版本来保证CAS的正确性。因此，在使用CAS前要考虑清楚“ABA”问题是否会影响程序并发的正确性，如果需要解决ABA问题，改用传统的互斥同步可能会比原子类更高效。



### AtomicInteger：线程安全

```java
AtomicInteger count = new AtomicInteger(0);

for(int i = 0; i < 10000; i++){
    count.incrementAndGet();//count++
}
```

















