package com.bing.lan.dubbo.a;

import org.apache.dubbo.common.URL;

public class Dog implements Animal {

  public Dog() {
    System.out.println("小狗出生了");
  }

  @Override
  public void adaptive(URL url) {
    System.out.println("小狗 adaptive ～");
  }

  @Override
  public void run() {
    System.out.println("小狗飞奔～");
  }
}