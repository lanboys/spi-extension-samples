package com.bing.lan.jdk;

import java.util.ServiceLoader;

public class JdkSPI {

  public static void main(String[] s) {
    System.out.println("======this is jdk SPI======");
    ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
    for (Animal animal : serviceLoader) {
      animal.run();
    }
  }
}
