package cn.magicnian;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.magicnian.config.LoadAdditionalProperties;
import cn.magicnian.model.User;
import cn.magicnian.service.SimpleService;


@RestController
@EnableTransactionManagement
@MapperScan("cn.magicnian.mapper")
@SpringBootApplication
public class SpringbootmbatisdemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootmbatisdemoApplication.class);

	@Autowired
	private SimpleService simpleService;

	@Value("${APPname}")
    private String appName;

	@Value("${dog.name}")
    private String dogName;

	@Autowired
    private User user;

	@Autowired
    private Environment env;


    @RequestMapping("/testproperties1")
    String testproperties1(){
        System.out.println(appName);
        return env.getProperty("APPname");
    }

    @RequestMapping("/testproperties2")
    String testproperties2(){
        System.out.println(dogName);
        return env.getProperty("dog.name");
    }

    @RequestMapping("/beantest")
    User beantest(){
        return user;
    }



	@RequestMapping("/{id}")
	String test(@PathVariable("id") Integer id){

        return simpleService.getUserName(id);

	}

	public static void main(String[] args) {

        /**
         * 增加配置文件监听的启动方式
         */
		new SpringApplicationBuilder(SpringbootmbatisdemoApplication.class)
				.listeners(new LoadAdditionalProperties())
				.run(args);

        /**
         * 最常用的启动方式
         */
//        SpringApplication application = new SpringApplication(SpringbootmbatisdemoApplication.class);
//        application.run(args);

    }
}
