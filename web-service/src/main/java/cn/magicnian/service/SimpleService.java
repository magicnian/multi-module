package cn.magicnian.service;

import cn.magicnian.enums.ResponseCode;
import cn.magicnian.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.magicnian.mapper.UserMapper;
import cn.magicnian.model.User;

/**
 * Created by liunn on 2017/5/17.
 */
@Service
public class SimpleService
{

    private static final Logger logger = LoggerFactory.getLogger(SimpleService.class);

    @Autowired
    private UserMapper userMapper;


    public String  getUserName(Integer id){

        try {
            User user = userMapper.selectByPrimaryKey(id);
            if(null==user){
                throw new CommonException(ResponseCode.NOT_EXIST.getCode(),ResponseCode.NOT_EXIST.getMsg());
            }
            return user.getName();
        }catch (CommonException e){
            logger.warn("查询用户出错:code:{},msg:{} ",e.getCode(),e.getMsg());
            return e.getMsg();
        }

    }

}
