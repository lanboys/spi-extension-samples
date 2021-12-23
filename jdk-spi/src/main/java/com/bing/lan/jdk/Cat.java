package com.bing.lan.jdk;

public class Cat implements Animal {

  public Cat() {
    System.out.println("小猫出生了");
  }

  @Override
  public void run() {
    System.out.println("小猫步走起来～");
  }
}