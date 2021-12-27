package com.bing.lan.dubbo.a;

import org.apache.dubbo.common.URL;

public class Cat implements Animal {

  public Cat() {
    System.out.println("小猫出生了");
  }

  @Override
  public void adaptive(URL url) {
    System.out.println("小猫 adaptive ～");
  }

  @Override
  public void run() {
    System.out.println("小猫步走起来～");
  }
}