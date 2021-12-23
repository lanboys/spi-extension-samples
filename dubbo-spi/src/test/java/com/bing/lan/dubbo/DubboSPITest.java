package com.bing.lan.dubbo;

import com.bing.lan.dubbo.a.Animal;
import com.bing.lan.dubbo.b.People;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class DubboSPITest {

  @Test
  public void testSPI() {
    System.out.println("======this is dubbo SPI======");
    ExtensionLoader<Animal> extensionLoaderAnimal = ExtensionLoader.getExtensionLoader(Animal.class);

    Animal cat = extensionLoaderAnimal.getExtension("cat");
    cat.run();
    Animal dog = extensionLoaderAnimal.getExtension("dog");
    dog.run();

    ExtensionLoader<People> extensionLoaderPeople = ExtensionLoader.getExtensionLoader(People.class);
    People student = extensionLoaderPeople.getExtension("student");
    student.doWork();
    People teacher = extensionLoaderPeople.getExtension("teacher");
    teacher.doWork();
  }
}
