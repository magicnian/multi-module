package cn.magicnian.exception;

/**
 * Created by liunn on 2017/5/19.
 */
public class CommonException extends Exception{


    public CommonException(String message) {
        super(message);
    }

    public CommonException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }


    private int code;

    private String msg;

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

    @Override
    public String toString() {
        return "CommonException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
