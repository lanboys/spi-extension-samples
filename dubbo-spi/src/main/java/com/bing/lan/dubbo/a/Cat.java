package com.bing.lan.dubbo.a;

public class Cat implements Animal {

  public Cat() {
    System.out.println("小猫出生了");
  }

  @Override
  public void run() {
    System.out.println("小猫步走起来～");
  }
}