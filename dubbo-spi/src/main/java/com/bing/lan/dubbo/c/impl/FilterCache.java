package com.bing.lan.dubbo.c.impl;

import com.bing.lan.dubbo.c.Filter;

public class FilterCache implements Filter {

  @Override
  public void doFilter() {
    System.out.println("doFilter(): " + this.getClass().getSimpleName());
  }
}
