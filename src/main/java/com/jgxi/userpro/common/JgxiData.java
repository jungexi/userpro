package com.jgxi.userpro.common;

public class JgxiData {

    private Integer status;

    private String info;

    private Object data;// 介绍一下 object


    private JgxiData(){

    }

    private JgxiData(Object data){
        this.data=data;
        this.status=200;
        this.info="处理成功";
    }

    private JgxiData(String info){
        this.data=null;
        this.status=500;
        this.info=info;
    }

    public static JgxiData getSuccessJgxiData(Object data){
        return new JgxiData(data);
    }

    public static JgxiData getErrorJgxiData(String info){
        return new JgxiData(info);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
