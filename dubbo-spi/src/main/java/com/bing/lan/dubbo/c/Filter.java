package com.bing.lan.dubbo.c;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Filter {

  public void doFilter();
}
