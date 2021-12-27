package com.bing.lan.dubbo.a;

import com.bing.lan.dubbo.b.People;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.DisableInject;

public class Dog implements Animal {

  private People owner;

  private Animal friend;

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

  public void setOwner(People owner) {
    this.owner = owner;
  }

  /**
   *  将自动注入 People 的自适应扩展类
   */
  public People getOwner() {
    return owner;
  }

  public Animal getFriend() {
    return friend;
  }

  /**
   * 加了注解 将不自动注入
   */
  @DisableInject
  public void setFriend(Animal friend) {
    this.friend = friend;
  }
}