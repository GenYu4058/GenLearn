# 虚拟机基础概念

## Java 从编码到执行

![image-20200619174340469](JVM.assets/image-20200619174340469.png)

## Javac的过程

![image-20200619175827491](JVM.assets/image-20200619175827491.png)

## 各种虚拟机

![image-20200619180024244](JVM.assets/image-20200619180024244.png)

## JDK、JRE、JVM的区别联系

马士兵：

JVM与java没有关系，任何语言，只要能编译成class文件，jvm都可以执行。

JVM是一种规范。是虚构出来的一台计算机

- 字节码指令集（汇编语言）
- 内存管理：堆 栈 方法区等

![image-20200619182503093](JVM.assets/image-20200619182503093.png)



JDK是Java开发工具包，是Sun Microsystems针对Java开发员的产品。

JDK中包含JRE，在JDK的安装目录下有一个名为jre的目录，里面有两个文件夹bin和lib，在这里可以认为bin里的就是jvm，lib中则是jvm工作所需要的类库，而jvm和 lib和起来就称为jre。

JDK是整个JAVA的核心，包括了Java运行环境JRE（Java Runtime Envirnment）、一堆Java工具（javac/java/jdb等）和Java基础的类库（即Java API 包括rt.jar）。



# class文件结构



# 内存加载过程


# 类加载-初始化

## 加载过程

1. Loading : 加载

   1. 双亲委派，主要出于安全考虑

   2. LazyLoading五种情况

   3. ClassLoader的源码 

      ​	findInCache -> parent.loadClass -> findClass()

   4. 自定义类加载器

   5. 混合执行 编译执行 解释执行

2. Linking
   1. Verification ：验证class文件格式
   2. Preparation ：赋默认值
   3. Resolution ：常量池里面的符号引用转化成内存地址

3. Initializing ：静态变量赋初始值

![image-20200622222204531](JVM.assets/image-20200622222204531.png)

## 类加载器

类加载器采用双亲委派机制

![image-20200622222243127](JVM.assets/image-20200622222243127.png)

![image-20200623221340531](JVM.assets/image-20200623221340531.png)

## lazyloading

- 严格讲应该叫lazyInitializing
- JVM规范并没有规定何时加载
- 但是严格规定了什么时候必须初始化
  - new getstatic putstatic invokestatic 指令，访问final变量除外
  - java.lang.reflect对类进行反射调用时
  - 初始化子类的时候，父类首先初始化
  - 虚拟机启动时，被执行的主类必须初始化
  - 动态语言支持java.lang.invoke.MethodHandle解析的结果为REF_getstatic REF_putstatic REF_invokestatic的方法语柄时，该类必须初始化

## 自定义加载器

1. extends ClassLoader

2. overwrite findClass() -> defineClass(byte[] -> Class clazz)

3. 加密

4. 第一节课遗留问题：parent是如何指定的，打破双亲委派，学生问题桌面图片

5. 用super(parent)指定

6. 双亲委派的打破
   1. 如何打破：重写loadClass（）

   2. 何时打破过？

      1. JDK1.2之前，自定义ClassLoader都必须重写loadClass()

      2. ThreadContextClassLoader可以实现基础类调用实现类代码，通过thread.setContextClassLoader指定

      3. 热启动，热部署

         osgi tomcat 都有自己的模块指定classloader（可以加载同一类库的不同版本）

## 编译

java是一种解释和编译 混合模式的语言

![image-20200628230124253](JVM.assets/image-20200628230124253.png)



# 运行时内存结构



# JVM常用指令

# GC与调优

