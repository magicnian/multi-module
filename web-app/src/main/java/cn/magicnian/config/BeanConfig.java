package cn.magicnian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.magicnian.model.User;

/**
 * bean配置类
 * Created by liunn on 2017/8/3.
 */
@Configuration
public class BeanConfig {

    @Bean
    public User user(){
        User user = new User("tom",12,1);
        return user;
    }
}
