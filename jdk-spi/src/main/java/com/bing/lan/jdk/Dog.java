package com.bing.lan.jdk;

public class Dog implements Animal {

  public Dog() {
    System.out.println("小狗出生了");
  }

  @Override
  public void run() {
    System.out.println("小狗飞奔～");
  }
}