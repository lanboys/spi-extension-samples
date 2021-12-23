package com.bing.lan.dubbo.a;

import org.apache.dubbo.common.extension.SPI;

/**
 * 必须加上 SPI 注解
 * Extension type (interface xxx) is not an extension,  because it is NOT annotated with @SPI!
 */
@SPI
public interface Animal {

  void run();
}