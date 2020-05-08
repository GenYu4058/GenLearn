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

可重入锁

程序在执行过程中，如果出现异常，默认情况锁会被释放

















