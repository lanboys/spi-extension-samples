package com.bing.lan.dubbo.c;

import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"group-consumer"}, value = {"fe"}, order = 5)
public class FilterE implements Filter {

  @Override
  public void doFilter() {
    System.out.println("doFilter(): " + this.getClass().getSimpleName());
  }
}