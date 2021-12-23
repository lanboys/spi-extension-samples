package com.bing.lan.dubbo.a;

public class Dog implements Animal {

  public Dog() {
    System.out.println("小狗出生了");
  }

  @Override
  public void run() {
    System.out.println("小狗飞奔～");
  }
}