package com.bing.lan.dubbo.b;

public class Teacher implements People {

  public Teacher() {
    System.out.println("老师来了");
  }

  @Override
  public void doWork() {
    System.out.println("老师在批改作业~");
  }
}
