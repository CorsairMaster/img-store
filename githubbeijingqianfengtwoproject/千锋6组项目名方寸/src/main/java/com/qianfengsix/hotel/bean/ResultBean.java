package com.qianfengsix.hotel.bean;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                  \\`.
//        .'//                     |                     \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
//    .'//.-"                 `-.  |  .-'                 "-.\\`.
//  .'//______.============-..   \ | /   ..-============.______\\`.
//.'______________________________\|/______________________________`.

/**
 * Create By
 * AdminJen
 * ON
 * 2018 - 11 - 01
 * 星期四 <-> 上午 9:30
 */
public class ResultBean {
//    状态码
    private int code;
//    信息
    private String message;
//    数据
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultBean setError(int code,String message,Object data){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        resultBean.setData(data);
        return resultBean;
    }

    public static ResultBean setOk(int code,String message,Object data){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        resultBean.setData(data);
        return resultBean;
    }
    public static ResultBean setError(Object data){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ResultBeanCodeInterface.ERRORCODE);
        resultBean.setMessage("网络异常请检查网络是否连接");
        resultBean.setData(data);
        return resultBean;
    }
}
