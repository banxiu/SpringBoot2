package com.banxian.springboot;

import ch.qos.logback.core.db.DBHelper;
import com.banxian.springboot.bean.Pet;
import com.banxian.springboot.bean.User;
import com.banxian.springboot.config.Myconfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.ConfigurableReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Method;

/**
 * 主程序类
 * @program: SpringBoot2
 * @description: 告诉springboot 这是一个springboot应用
 * @author: Wangly
 * @create: 2021-01-28 11:01
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//        // 从容器中获取组件 注册的组件默认是单例的
//        Pet tom01 = context.getBean("tom", Pet.class);
//        Pet tom02 = context.getBean("tom", Pet.class);
//        System.out.println(tom01 == tom02);
//        // com.banxian.springboot.config.Myconfig$$EnhancerBySpringCGLIB$$e1c4a025@712ca57b
//        Myconfig bean = context.getBean(Myconfig.class);
//        System.out.println(bean);
//        // @Configuration(proxyBeanMethods = true) 代理对象调用方法
//        //SpringBoot总会检查这个组件是否在容器中有。
//        //保持组件单实例
//        User u1 = bean.user01();
//        User u2 = bean.user01();
//
//        System.out.println(u1 == u2);
//
//        User user01 = context.getBean("user01", User.class);
//        Pet tom = context.getBean("tom", Pet.class);
//        System.out.println("用户的宠物：" + (user01.getPet() == tom));
//
//        // 获取组件
//        String[] beanNamesForType = context.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        DBHelper dbHelper = context.getBean(DBHelper.class);
//        System.out.println(dbHelper
//        );
//
//        // 反射获取对象
//        try {
//            Class clazz = Class.forName("com.banxian.springboot.bean.User");
//            User ureflect = (User)clazz.newInstance();
//            System.out.println(ureflect);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Object tom = context.containsBean("tom");
        System.out.println("容器中Tom组件" + tom);

        Object user = context.containsBean("user01");
        System.out.println("容器中user组件" + user);


        Object tom22 = context.containsBean("tom22");
        System.out.println("容器中tom22组件" + tom22);
    }
}