package com.banxian.springboot.config;

import ch.qos.logback.core.db.DBHelper;
import com.banxian.springboot.bean.Pet;
import com.banxian.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: SpringBoot2
 * @description: 告诉springboot这是一个配置类
 * @author: Wangly
 * @create: 2021-01-28 14:57
 */
/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 *
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 *Method annotated with @Bean is called directly in a @Configuration where proxyBeanMethods set to false. Set proxyBeanMethods to true or use dependency injection.
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
public class Myconfig {
    /**
     * 外部无论调用多少次，都拿到的是单实例对象
    *给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    * */
    @Bean
    public User user01() {
        User user =  new User("zhangsan", 23);
        user.setPet(tomcatPet());
        return user;
    }
    @Bean("tom22")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}