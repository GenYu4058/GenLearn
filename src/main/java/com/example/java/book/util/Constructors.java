package com.example.java.book.util;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Constructors {
    //吧一个字符串的第一个字母大写、效率是最高的
    private static String getMethodName(String fildeName)throws Exception{
        byte[] items = fildeName.getBytes();
        items[0] = (byte)((char)items[0] - 'a' + 'A');
        return new String(items);
    }

    public static void main(String[] args) {
        //1、加载Class对象
        try{
            Class clazz = Class.forName("com.example.java.book.model.Student");

            //2、获取所有公有构造方法
            System.out.println("-----------所有公有构造方法----------");
            Constructor[] conArray = clazz.getConstructors();
            for(Constructor c : conArray){
                System.out.println(c);
            }

            System.out.println("-----------所有构造方法（包括：私有、受保护、默认、公有）-----------");
            conArray = clazz.getDeclaredConstructors();
            for(Constructor c : conArray){
                System.out.println(c);
            }

            System.out.println("-----------获取公有、无参的构造方法-----------");
            Constructor con = clazz.getConstructor(null);
            //1>、因为是无参的构造方法所以类型是一个null，不写也可以;这里需要的是一个参数的类型，切记是类型
            //2>、返回的是面熟这个无参构造函数的类对象
            System.out.println("con = " + con);
            //调用构造方法
            Object obj = con.newInstance();
            //System.out.println("obj = " + obj);
            //Student stu = (Student) obj;

            System.out.println("-----------获取私有构造方法，并调用-----------");
            con = clazz.getDeclaredConstructor(char.class);
            System.out.println(con);
            //调用构造方法
            con.setAccessible(true);//暴力访问（忽略访问修饰符）
            obj = con.newInstance('男');

            System.out.println("-----------获取所有普通方法-----------");
            Method[] methods = clazz.getDeclaredMethods();//调用public方法
            for (Method m : methods){
                System.out.println(m);
            }

            System.out.println("-----------获取普通方法并调用-----------");
            Method method = clazz.getMethod("testStudent",String.class);
            System.out.println(method);
            method.invoke(clazz.newInstance(),"yugen");

            //获取属性
            System.out.println("-----------获取属性-----------");
            Field[] fields1 = clazz.getFields();               //返回属性为public的字段
            Field[] fields2 = clazz.getDeclaredFields();       //返回所有属性
            Field field = clazz.getDeclaredField("age");//获取属性为age的
            Object object = clazz.newInstance();

            for(Field f : fields2){
                System.out.println(f);
                System.out.println(f.getGenericType());
                if(f.getGenericType().toString().equals("class java.lang.String"))
                {
                    /**
                    * 这里需要说明一下：他是根据拼凑的字符来找你写的getter方法的
                    * 在Boolean值的时候是isXXX（默认使用ide生成getter的都是isXXX）
                    * 如果出现NoSuchMethod异常 就说明它找不到那个gettet方法 需要做个规范
                    */
                    System.out.println("f.getName() = " + f.getName());
                    Method m = (Method)object.getClass().getMethod("get" + getMethodName(f.getName()));
                    String val = (String)m.invoke(object);
                    if(val != null){
                        System.out.println("yugen String :" + val);
                    }
                }
            }




        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


















