package com;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2018/3/21 10:14</li>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult< T > {

    /**
     * 成功代码
     */
    public static final int CODE_SUCCESS = 1;

    /**
     * 失败代码
     */
    public static final int CODE_FAILURE = 0;

    private int code;

    private T data;

    private String msg;

    public RestResult ( T data ) {

        this.code = CODE_SUCCESS;
        this.data = data;
    }

    public RestResult ( int code, T data, String msg ) {

        this.msg = msg;
        this.code = code;
        this.data = data;
    }


    public int getCode () {

        return code;
    }

    public void setCode ( int code ) {

        this.code = code;
    }

    public T getData () {

        return data;
    }

    public void setData ( T data ) {

        this.data = data;
    }

    public String getMsg () {

        return msg;
    }

    public void setMsg ( String msg ) {

        this.msg = msg;
    }
}
