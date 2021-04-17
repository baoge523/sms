package com.manage.sys.sms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    List<String> list = Collections.synchronizedList(new ArrayList<>());

    public void add(String a) {
        list.add(a);
    }

    public int size() {
        return list.size();
    }


    public static void main(String[] args) {
        Test test = new Test();



        // 被观察者
        new Thread(()-> {
            try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            for (int i = 0; i < 10; i++) {
                test.add("aa");
                System.out.println(i);
//                if (i == 5) {
//
//                }
            }
        }).start();

        // 相当于是观察者
        new Thread(()->{
            while (true) {
                // 这里可能没有抢到锁
                if (test.size() == 5) {
                    break;
                }
            }
        }).start();

        System.out.println("---------");


    }

}
