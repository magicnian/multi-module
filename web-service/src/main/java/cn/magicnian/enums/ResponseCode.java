package cn.magicnian.enums;

/**
 * Created by liunn on 2017/5/19.
 */
public enum ResponseCode {

    NOT_EXIST(404,"用户不存在");


    private int code;

    private String msg;

    private ResponseCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
