package com.bing.lan.dubbo.b;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.List;

@Adaptive
public class AdaptivePeople implements People {

  int i = 0;

  public AdaptivePeople() {
    System.out.println("AdaptivePeople 初始化");
  }

  @Override
  public void doWork() {
    System.out.print("AdaptivePeople doWork ~ ");
    i++;
    ExtensionLoader<People> extensionLoaderPeople = ExtensionLoader.getExtensionLoader(People.class);
    List<People> loadedExtensionInstances = extensionLoaderPeople.getLoadedExtensionInstances();

    int index = this.i % loadedExtensionInstances.size();
    People people = loadedExtensionInstances.get(index);
    people.doWork();
  }
}
