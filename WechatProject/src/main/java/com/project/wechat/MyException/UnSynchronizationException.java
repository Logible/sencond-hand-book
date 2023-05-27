package com.project.wechat.MyException;

//关注表和粉丝表未同时更新产生异常
public class UnSynchronizationException extends Exception {
    public UnSynchronizationException(){
        super();
    }

    public UnSynchronizationException(String msg){
        super(msg);
    }
}
