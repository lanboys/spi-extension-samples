package com.bing.lan.dubbo.c;

import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"group-consumer"}, value = {"fd"}, order = 4)
public class FilterD implements Filter {

  @Override
  public void doFilter() {
    System.out.println("doFilter(): " + this.getClass().getSimpleName());
  }
}
