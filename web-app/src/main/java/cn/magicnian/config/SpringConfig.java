package cn.magicnian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * 配置文件注入类
 * @PropertySource(value = { “classpath:application.properties” })注解可以让在application.properties文件中定义的属性对Spring Envirronment bean可用，
 * Environment接口提供了getter方法读取单独的属性值。
 * Created by liunn on 2017/8/1.
 */
@Configuration
@PropertySource("classpath:config/config.properties")
//@PropertySource("classpath:config/test.properties")
public class SpringConfig {

    /**
     * PropertySourcesPlaceholderConfigurer这个bean，这个bean主要用于解决@value中使用的${…}占位符。假如你不使用${…}占位符的话，可以不使用这个bean
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
