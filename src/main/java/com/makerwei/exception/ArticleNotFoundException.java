package com.makerwei.exception;

/**
 * @author weixianbin
 * @date 2016/12/17
 * Copyright (C) 2014-2016 All Rights Reserved.
 */
public class ArticleNotFoundException extends Exception {
    public ArticleNotFoundException(String msg){
        super(msg);
    }
    public ArticleNotFoundException(String msg, Throwable t){
        super(msg,t);
    }
}
