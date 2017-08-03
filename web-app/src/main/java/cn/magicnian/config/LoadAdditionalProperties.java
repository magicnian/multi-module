package cn.magicnian.config;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * 自定义配置文件处理类
 * 通过监听ApplicationEnvironmentPreparedEvent事件，往Environment注入相应的配置文件
 * 通过@Value可获取
 * Created by liunn on 2017/8/3.
 */
public class LoadAdditionalProperties implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private ResourceLoader loader = new DefaultResourceLoader();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        try {
            Resource resource = loader.getResource("classpath:config/test.properties");
            PropertySource<?> propertySource = new PropertySourcesLoader().load(resource);
            applicationEnvironmentPreparedEvent.getEnvironment().getPropertySources().addLast(propertySource);
        }catch(IOException e){
            throw new IllegalStateException(e);
        }
    }
}