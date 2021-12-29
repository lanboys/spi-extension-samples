package com.bing.lan.dubbo.c;

import org.apache.dubbo.common.extension.Activate;

/**
 * 配置了 value ，所以需要通过URL参数来控制是否激活，如果没配置 activateValue 为空，isActive 直接返回 true
 *
 * ExtensionLoader 280行
 *
 *         if (isMatchGroup(group, activateGroup) // 匹配group
 *                 && !names.contains(name) // 匹配扩展名
 *                 && !names.contains(REMOVE_VALUE_PREFIX + name) // 如果包含"-"表示不激活该扩展实现
 *                 && isActive(activateValue, url)) // 检测URL中是否出现了指定的Key
 *         {
 *             activateExtensions.add(getExtension(name)); // 加载扩展实现
 *         }
 *
 *     private boolean isActive(String[] keys, URL url) {
 *         if (keys.length == 0) {
 *             return true;// 没配置的话 匹配通过
 *         }
 *         for (String key : keys) {
 *             // @Active(value="key1:value1, key2:value2")
 *             String keyValue = null;
 *             if (key.contains(":")) {
 *                 String[] arr = key.split(":");
 *                 key = arr[0];
 *                 keyValue = arr[1];
 *             }
 *
 *             for (Map.Entry<String, String> entry : url.getParameters().entrySet()) {
 *                 String k = entry.getKey();
 *                 String v = entry.getValue();
 *                 if ((k.equals(key) || k.endsWith("." + key))
 *                     && ((keyValue != null && keyValue.equals(v)) // 如果配置了 value, 那么必须值能匹配上
 *                     || (keyValue == null && ConfigUtils.isNotEmpty(v)))) {// 如果没配置 value, 那url中的v也不能为空
 *                     // 总结就是url中必须配置 v ，不能为空，如果 keyValue 也存在，还必须相等，否则允许不相等
 *                     return true;
 *                 }
 *             }
 *         }
 *         return false;
 *     }
 */
@Activate(group = {"group-provider"}, value = {"fa"}, order = 1)
public class FilterA implements Filter {

  @Override
  public void doFilter() {
    System.out.println("doFilter(): " + this.getClass().getSimpleName());
  }
}
