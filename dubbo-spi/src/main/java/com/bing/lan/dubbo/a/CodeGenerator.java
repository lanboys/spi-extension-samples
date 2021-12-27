package com.bing.lan.dubbo.a;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class CodeGenerator {

  /**
   * 自动生成的代码
   */
  // package com.bing.lan.dubbo.a;
  // import org.apache.dubbo.common.extension.ExtensionLoader;
  public class Animal$Adaptive implements com.bing.lan.dubbo.a.Animal {

    public void run() {
      throw new UnsupportedOperationException("The method public abstract void com.bing.lan.dubbo.a.Animal.run() " +
          "of interface com.bing.lan.dubbo.a.Animal is not adaptive method!");
    }

    public void adaptive(org.apache.dubbo.common.URL arg0) {
      if (arg0 == null)
        throw new IllegalArgumentException("url == null");
      org.apache.dubbo.common.URL url = arg0;
      String extName = url.getParameter("animalName");
      if (extName == null)
        throw new IllegalStateException("Failed to get extension (com.bing.lan.dubbo.a.Animal) " +
            "name from url (" + url.toString() + ") use keys([animalName])");

      com.bing.lan.dubbo.a.Animal extension = (com.bing.lan.dubbo.a.Animal) ExtensionLoader
          .getExtensionLoader(com.bing.lan.dubbo.a.Animal.class)
          .getExtension(extName);
      extension.adaptive(arg0);
    }
  }
}
