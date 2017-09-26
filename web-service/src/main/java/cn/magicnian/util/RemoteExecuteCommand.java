package cn.magicnian.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.*;

/**
 * Created by liunn on 2017/8/17.
 */
public class RemoteExecuteCommand {
    //字符编码默认是utf-8
    private static String  DEFAULTCHART="UTF-8";
    private Connection conn;
    private String ip;
    private int port;
    private String userName;
    private String userPwd;

    public RemoteExecuteCommand(String ip,int port,String userName,String userPwd){
        this.ip=ip;
        this.port=port;
        this.userName=userName;
        this.userPwd=userPwd;
    }

    /**
     * 登录远程主机
     * @return
     */
    public boolean login(){
        boolean flag = false;
        try{
            conn = new Connection(ip,port);
            conn.connect();//连接
            flag = conn.authenticateWithPassword(userName,userPwd);
        }catch (IOException e){
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 执行远程脚本或命令
     * @param command
     * @return
     */
    public String exec(String command){
        String result="";
        try{
            if(login()){
                Session session = conn.openSession();
                session.execCommand(command);
                result=processStdout(session.getStdout(),DEFAULTCHART);
                conn.close();
                session.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 解析脚本执行返回的结果集
     * @param in
     * @param charset
     * @return
     */
    private String processStdout(InputStream in,String charset){
        InputStream stdout = new StreamGobbler(in);
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout,charset));
            String line=null;
            while((line=br.readLine()) != null){
                buffer.append(line+"\n");
            }
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
