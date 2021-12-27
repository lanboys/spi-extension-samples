package com.bing.lan.dubbo.a;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * 必须加上 SPI 注解
 * Extension type (interface xxx) is not an extension,  because it is NOT annotated with @SPI!
 */
@SPI
public interface Animal {

  // 从 URL 中获取参数 animalName 的值 xxx , 来选择扩展类，比如 xxx = cat,
  // 则执行 cat 中的 adaptive 方法，其中cat 在配置文件配置了
  @Adaptive("animalName")
  void adaptive(URL url);

  // 自动生成的自适应扩展类，不支持没 @Adaptive 注解的方法调用，看自动生成的代码可知道
  void run();
}