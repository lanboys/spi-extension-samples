package com.bing.lan.dubbo.c;

import org.apache.dubbo.common.extension.Activate;

/**
 * 没有配置 value 那么不需要 在URL 中加参数进行添加或
 */
@Activate(group = {"group-provider", "group-consumer"}, order = 3)
public class FilterC implements Filter {

  @Override
  public void doFilter() {
    System.out.println("doFilter(): " + this.getClass().getSimpleName());
  }
}
