package com.example.java.book.test.Base64;


import org.apache.commons.codec.binary.Base64;
import org.omg.IOP.Encoding;

/**
 * Created with IntelliJ IDEA
 *
 * @author Gen
 * @date 28/5/2020
 * @time 下午 3:09
 * Descriptioin No Descriptioin
 */
public class Base64Bug {
    public static void main(String[] args) {
        String data = "EAAAAAAAAAAAAAAAAAAAAAAseXVnZW4NClAwNDgwLDI3LDANClAwMTEzLDI3LDE1DQoNCg0K";
        String s = new String(Base64.decodeBase64(data.getBytes()));
        System.out.println(s);
    }
}
