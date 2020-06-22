# Java 基本类型和引用类型

## 数据类型

Java中的数据类型分为两大类，基本数据类型和引用数据类型。**

### 1、基本数据类型

基本数据类型只有8种，可按照如下分类
①整数类型：`long、int、short、byte`
②浮点类型：`float、double`
③字符类型：`char`
④布尔类型：`boolean`

| No.  |      数据类型      | 大小/位 |              可表示数据范围              |  默认值  |
| :--: | :----------------: | :-----: | :--------------------------------------: | :------: |
|  1   |  `byte`（字节型）  |    8    |                 -128~127                 |    0     |
|  2   | `short`（短整型）  |   16    |               -32768~32767               |    0     |
|  3   |   `int`（整型）    |   32    |          -2147483648~2147483647          |    0     |
|  4   |  `long`（长整型）  |   64    | -9223372036854775808~9223372036854775807 |    0     |
|  5   | `float`（单精度）  |   32    |              -3.4E38~3.4E38              |   0.0    |
|  6   | `double`（双精度） |   64    |             -1.7E308~1.7E308             |   0.0    |
|  7   |   `char`（字符）   |   16    |                  0~255                   | '\u0000' |
|  8   | `boolean`（布尔）  |    -    |               true或false                |  false   |

### 2、引用数据类型

引用数据类型非常多，大致包括：
类、 接口类型、 数组类型、 枚举类型、 注解类型、 字符串型

例如，`String`类型就是引用类型。
**简单来说，所有的非基本数据类型都是引用数据类型。**

## 基本数据类型和引用数据类型的区别

### 1、存储位置

#### 基本变量类型

- 在方法中定义的非全局基本数据类型变量的具体内容是存储在栈中的

#### 引用变量类型

- 只要是引用数据类型变量，其具体内容都是存放在堆中的，而栈中存放的是其具体内容所在内存的地址
  *ps:通过变量地址可以找到变量的具体内容，就如同通过房间号可以找到房间一般*

```java
public class Main{
   public static void main(String[] args){
       //基本数据类型
       int i=1;
       double d=1.2;
       
       //引用数据类型
       String str="helloworld";
   }
}
```

![img](https://img2018.cnblogs.com/blog/1537987/201811/1537987-20181117143815305-1391925376.png)

### 2、传递方式

#### 基本变量类型

- 在方法中定义的非全局基本数据类型变量，调用方法时作为参数是按**数值传递**的

```java
//基本数据类型作为方法参数被调用
public class Main{
   public static void main(String[] args){
       int msg = 100;
       System.out.println("调用方法前msg的值：\n"+ msg);    //100
       fun(msg);
       System.out.println("调用方法后msg的值：\n"+ msg);    //100
   }
   public static void fun(int temp){
       temp = 0;
   }
}
```

![img](https://img2018.cnblogs.com/blog/1537987/201811/1537987-20181117152204524-2019844954.png)

#### 引用变量类型

- 引用数据类型变量，调用方法时作为参数是按**引用传递**的

```java
//引用数据类型作为方法参数被调用

class Book{
    String name;
    double price;

    public Book(String name,double price){
        this.name = name;
        this.price = price;
    }
    public void getInfo(){
        System.out.println("图书名称："+ name + "，价格：" + price);
    }

    public void setPrice(double price){
        this.price = price;
    }
}

public class Main{
   public static void main(String[] args){
       Book book = new Book("Java开发指南",66.6);
       book.getInfo();  //图书名称：Java开发指南，价格：66.6
       fun(book);
       book.getInfo();  //图书名称：Java开发指南，价格：99.9
   }

   public static void fun(Book temp){
       temp.setPrice(99.9);
   }
}
```

**调用时为temp在栈中开辟新空间，并指向book的具体内容，方法执行完毕后temp在栈中的内存被释放掉**

![img](https://img2018.cnblogs.com/blog/1537987/201811/1537987-20181117160912759-229459932.png)

## 比较

当两个基本类型使用”==”比较时，他们比较的是**值**。 
当两个引用类型使用”==”比较时，他们比较的是**地址**。 
当两个引用类型使用方法equals()比较时，他们比较的是**值**。

```java
int i = 1234;
Integer i1 = new Integer(1234);
Integer i2 = new Integer(1234);
System.out.print("i1 == i2 : "+(i1 == i2));
System.out.println("\ti1.equals(i2) : "+(i1.equals(i2)));
System.out.print("i == i1 : "+(i == i1));
System.out.println("\t\ti1.equals(i) : "+(i1.equals(i)));
System.out.print("i == i2 : "+(i == i2));
System.out.println("\t\ti2.equals(i) : "+(i2.equals(i)));

```

打印： 
i1 == i2 : false i1.equals(i2) : true 
i == i1 : true i1.equals(i) : true 
i == i2 : true i2.equals(i) : true

我们可以看到 i == i1, i == i2, i1 != i2, 
但使用equals()他们都是相等的。

equals()源码

```java
public boolean equals(Object obj) {
        return this == obj;
    }
```

Integer重写equals()方法

```java
public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return this.value == (Integer)obj;
        } else {
            return false;
        }
    }
```



# JAVA代码执行顺序

```java
class HelloA {

       public HelloA(){
           System.out.println("Hello A!父类构造方法");
       }

      {        System.out.println("i'm A class.父类非静态代码块");


      }
      static{
           System.out.println("static A 父类静态代码块");
       }
}

     class HelloB extends HelloA {
        public HelloB(){
            System.out.println("Hello B! 构造方法");
        }
        {
            System.out.println("i'm B class.非静态代码块");
        }
        static{
            System.out.println("static B 静态代码块");
        }
        public static void main(String[] args) {
            System.out.println("---start---");
            new HelloB();
            new HelloB();
            System.out.println("---end---");
        }
}

```

**打印结果**

static A 父类静态代码块
static B 静态代码块
---start---
i'm A class.父类非静态代码块
Hello A!父类构造方法
i'm B class.非静态代码块
Hello B! 构造方法
i'm A class.父类非静态代码块
Hello A!父类构造方法
i'm B class.非静态代码块
Hello B! 构造方法
---end---

