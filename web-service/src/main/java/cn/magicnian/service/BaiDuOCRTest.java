package cn.magicnian.service;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by liunn on 2017/8/16.
 */
public class BaiDuOCRTest {
    private static final String APP_ID = "9969841";

    private static final String API_KEY = "7vbvdbbs038X0C6nBnLQObwW";

    private static final String SECRET_KEY = "y53dnzhToj4t0dWY0IUZmPUzq09bb3QR";


    public static void main(String[] args) {


        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        String path= "C:\\Users\\liunn\\Desktop\\pics\\1.jpg";

        JSONObject response1 = client.basicGeneral(path, new HashMap<String, String>());

        System.out.println(response1.toString());
    }
}
