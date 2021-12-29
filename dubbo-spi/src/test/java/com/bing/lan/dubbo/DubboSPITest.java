package com.bing.lan.dubbo;

import com.bing.lan.dubbo.a.Animal;
import com.bing.lan.dubbo.b.People;
import com.bing.lan.dubbo.c.Filter;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionFactory;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DubboSPITest {

  @Test
  public void testSPI() {
    ExtensionLoader<Animal> extensionLoaderAnimal = ExtensionLoader.getExtensionLoader(Animal.class);
    Animal cat = extensionLoaderAnimal.getExtension("cat");
    cat.run();
    Animal dog = extensionLoaderAnimal.getExtension("dog");
    dog.run();

    ExtensionLoader<People> extensionLoaderPeople = ExtensionLoader.getExtensionLoader(People.class);
    People student = extensionLoaderPeople.getExtension("student");
    student.doWork();
    People teacher = extensionLoaderPeople.getExtension("teacher");
    teacher.doWork();

    System.out.println("testSPI(): ");
  }

  /**
   * 类上 配置 @Adaptive
   *
   * 如果多个类都加了注解，最终也只有一个生效，因为这是按顺序加载的，
   * 后面加载的类是否覆盖前面加载的类，取决于 LoadingStrategy.overridden()方法
   *
   * 加了注解 Adaptive 后不能再通过名字获取，因为在加载的时候 ExtensionLoader.loadClass()
   * 方法里面的处理是互斥的
   */
  @Test
  public void getAdaptiveExtension() {
    ExtensionLoader<People> extensionLoaderPeople = ExtensionLoader.getExtensionLoader(People.class);
    // AdaptivePeople上加了注解 Adaptive
    People adaptiveExtension = extensionLoaderPeople.getAdaptiveExtension();
    adaptiveExtension.doWork();

    People teacher = extensionLoaderPeople.getExtension("teacher");
    teacher.doWork();

    People student = extensionLoaderPeople.getExtension("student");
    student.doWork();

    // 加了注解 Adaptive 后不能再通过名字获取
    People adaptive = extensionLoaderPeople.getExtension("adaptive");
    adaptive.doWork();

    System.out.println("getAdaptiveExtension(): ");
  }

  /**
   * 方法上配置 @Adaptive
   *
   * ExtensionLoader.getAdaptiveExtension() 首先找配置文件中的类是否
   * 加了注解 @Adaptive, 找不到的话再从方法上面寻找，如果找到了则自动生成一个类，如 Animal$Adaptive，
   * 被 @Adaptive注解的方法里面根据URL参数来决定执行哪个扩展类
   *
   * 好处：不用动原来的代码，就可以进行扩展，比如，如果要增加一种动物 a , 只需要在配置文件中
   * 增加 a 的类, 并在 url 的参数中设置，就能使用动物 a 了
   */
  @Test
  public void getAdaptiveExtensionFromMethod() {
    ExtensionLoader<Animal> extensionLoaderAnimal = ExtensionLoader.getExtensionLoader(Animal.class);
    Animal animal = extensionLoaderAnimal.getAdaptiveExtension();

    Map<String, String> parameters = new HashMap<>();
    // 通过参数决定用哪个扩展类
    parameters.put("animalName", "cat");
    //parameters.put("animalName", "dog");

    URL url = new URL("http", "127.0.0.1", 8888, parameters);
    animal.adaptive(url);// 调用 cat 扩展类

    System.out.println("getAdaptiveExtensionFromMethod(): ");
  }

  /**
   * injectExtension 自动注入
   */
  @Test
  public void testInjectExtension1() {
    ExtensionLoader<Animal> extensionLoaderAnimal = ExtensionLoader.getExtensionLoader(Animal.class);
    Animal cat = extensionLoaderAnimal.getExtension("cat");
    cat.run();
    Animal dog = extensionLoaderAnimal.getExtension("dog");
    dog.run();

    System.out.println("testInjectExtension1(): ");
  }

  /**
   * injectExtension 自动注入实现主要类 ExtensionFactory
   */
  @Test
  public void testInjectExtension2() {
    ExtensionLoader<ExtensionFactory> loader = ExtensionLoader.getExtensionLoader(ExtensionFactory.class);
    ExtensionFactory extensionFactory = loader.getAdaptiveExtension();

    // 通过 ExtensionFactory 获取自适应扩展类
    // 后面 name 参数没什么用
    Animal dog1 = extensionFactory.getExtension(Animal.class, "dog");

    People student1 = extensionFactory.getExtension(People.class, "student");
    // 具体执行哪个类，看自适应扩展类内部逻辑
    student1.doWork();
    student1.doWork();
    student1.doWork();
    student1.doWork();

    System.out.println("testInjectExtension2(): ");
  }

  /**
   * 源码注释见【有道云笔记】 或者 git@github.com:lanboys/dubbo-1.git
   */
  @Test
  public void testActivate() {
    Map<String, String> parameters = new HashMap<>();

    //parameters.put("filter", "cache,log");// 指定必须激活的扩展类，相当于  parameters.put("filter", "default,cache,log") 默认的排在最前面
    parameters.put("filter", "cache,default,log"); // 默认的排在中间
    //parameters.put("filter", "cache,log,-default"); //-default 表示默认的扩展类全部都不激活，除非显式添加扩展类名字进行激活

    parameters.put("fa", "xxx");// 默认扩展 fa 需要通过参数控制是否激活
    parameters.put("fb", "fb-value");// 默认扩展 fc 需要通过参数控制是否激活, fb-value 也需要匹配上
    //parameters.put("fc", "xxx");// 默认扩展 fc 不需要参数控制，因为没配置value

    URL url = new URL("http", "127.0.0.1", 8888, parameters);

    ExtensionLoader<Filter> loader = ExtensionLoader.getExtensionLoader(Filter.class);
    List<Filter> filters = loader.getActivateExtension(url, "filter", "group-provider");

    for (Filter filter : filters) {
      filter.doFilter();
    }

    System.out.println("testActivate(): ");
  }
}
