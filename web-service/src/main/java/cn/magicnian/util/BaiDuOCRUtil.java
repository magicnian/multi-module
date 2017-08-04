package cn.magicnian.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by liunn on 2017/8/4.
 */
public class BaiDuOCRUtil {

    private static final Logger logger = LoggerFactory.getLogger(BaiDuOCRUtil.class);

    private static RestTemplate restTemplate;

    static{
        restTemplate = SpringUtil.getBean(RestTemplate.class);
    }

    private static final String API_KEY="7vbvdbbs038X0C6nBnLQObwW";

    private static final String SECRET_KEY = "y53dnzhToj4t0dWY0IUZmPUzq09bb3QR";

    public static String getToken(){

        StringBuilder sb = new StringBuilder();
        sb.append("https://aip.baidubce.com/oauth/2.0/token");
        sb.append("?grant_type=client_credentials");
        sb.append("&client_id="+API_KEY);
        sb.append("&client_secret="+SECRET_KEY);

        String url = sb.toString();

        ResponseEntity<JSONObject> response = restTemplate.getForEntity(url, JSONObject.class);
        if(HttpStatus.OK==response.getStatusCode()){
            String token = response.getBody().getString("access_token");
            logger.info("token:{}",token);
            return token;
        }else{
            logger.info("get token fail,the responsecode is :{}",response.getStatusCode());
            return null;
        }
    }
}
