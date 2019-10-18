package com.yang;

import org.junit.Test;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserTest {
    @Test
    public void userTest(){
        //字节输入输出流
        InputStream in=null;
        OutputStream out=null;
        byte[] data=new byte[1024];

        //java5以前两种创建匿名线程方式
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        //java5创建多线程方式
        ExecutorService pool=Executors.newFixedThreadPool(3);
        for (int i=0;i<10;i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Test
    public void testIO(){
        //字节输入输出流
        InputStream in=null;
        OutputStream out=null;
        byte[] data=new byte[1024];
        int len;
        try {
            in=new FileInputStream("");
            out=new FileOutputStream("");
            while ((len=in.read(data,0,data.length))!=-1){
                out.write(data,0,data.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
