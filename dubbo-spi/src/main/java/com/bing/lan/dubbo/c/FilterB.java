package com.bing.lan.dubbo.c;

import org.apache.dubbo.common.extension.Activate;

/**
 * 配置了 value ，所以需要通过URL参数来控制是否激活，并且 key:value 都得完全匹配上
 */
@Activate(group = {"group-provider"}, value = {"fb:fb-value"}, order = 2)
public class FilterB implements Filter {

  @Override
  public void doFilter() {
    System.out.println("doFilter(): " + this.getClass().getSimpleName());
  }
}
