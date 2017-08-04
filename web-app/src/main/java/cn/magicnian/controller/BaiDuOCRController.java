package cn.magicnian.controller;

import cn.magicnian.service.BaiDuOCRService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by liunn on 2017/8/4.
 */
@Controller
@RequestMapping("/ocr")
public class BaiDuOCRController {

    private static final Logger logger = LoggerFactory.getLogger(BaiDuOCRController.class);

    @Autowired
    private BaiDuOCRService baiDuOCRService;

    @RequestMapping(value="/commonpic",method = RequestMethod.POST)
    public String commonpic(HttpServletRequest request,@RequestParam String path){
        FileInputStream inputStream = null;
        String image = null;
        try {

            File file = new File(path);
            BASE64Encoder encoder = new BASE64Encoder();
            inputStream = new FileInputStream(file);
            byte[] buffer = IOUtils.toByteArray(inputStream);

            image = encoder.encode(buffer);



        }catch (IOException e){
            logger.info("IO exception:{}",e);
        }finally{
            IOUtils.closeQuietly(inputStream);
        }
        return baiDuOCRService.commonpic(image);
    }
}
