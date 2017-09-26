package cn.magicnian.service;

import com.baidu.aip.ocr.AipOcr;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by liunn on 2017/8/4.
 */
@Service
public class BaiDuOCRService {

    private static final String APP_ID = "9969841";

    private static final String API_KEY = "7vbvdbbs038X0C6nBnLQObwW";

    private static final String SECRET_KEY = "y53dnzhToj4t0dWY0IUZmPUzq09bb3QR";



    public String commonpic(String path){

        // 初始化一个OcrClient
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        org.json.JSONObject response =  client.basicGeneral(path,new HashMap<String,String>());

        System.out.println(response.toString());

        return  response.toString();

    }


}
