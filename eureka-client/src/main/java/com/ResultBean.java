package com;

import java.util.List;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2018/3/21 10:20</li>
 */
public class ResultBean {

    private long dateTime;

    private List< ResultDataBean > values;

    public long getDateTime () {

        return dateTime;
    }

    public void setDateTime ( long dateTime ) {

        this.dateTime = dateTime;
    }

    public List< ResultDataBean > getValues () {

        return values;
    }

    public void setValues ( List< ResultDataBean > values ) {

        this.values = values;
    }
}
