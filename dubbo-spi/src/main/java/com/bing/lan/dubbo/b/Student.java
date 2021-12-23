package com.bing.lan.dubbo.b;

public class Student implements People {

  public Student() {
    System.out.println("学生来了");
  }

  @Override
  public void doWork() {
    System.out.println("学生在写作业~");
  }
}
