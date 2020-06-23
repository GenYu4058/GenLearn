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





# 类加载-初始化

## 加载过程

1. Loading : 加载
2. Linking
   1. Verification ：验证class文件格式
   2. Preparation ：赋默认值
   3. Resolution ：常量池里面的符号引用转化成内存地址
3. Initializing ：静态变量赋初始值

![image-20200622222204531](JVM.assets/image-20200622222204531.png)

## 类加载器

![image-20200622222243127](JVM.assets/image-20200622222243127.png)









# 运行时内存结构



# JVM常用指令

# GC与调优

