package cn.magicnian.service;

import cn.magicnian.util.BaiDuOCRUtil;
import org.springframework.stereotype.Service;

/**
 * Created by liunn on 2017/8/4.
 */
@Service
public class BaiDuOCRService {



    public String commonpic(String image){
        //获取token
        String token = BaiDuOCRUtil.getToken();

        return token;
    }


}
