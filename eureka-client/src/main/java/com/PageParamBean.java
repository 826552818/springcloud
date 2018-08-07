package com;

import java.util.List;

/**
 * <p/>
 * <li>Description: 页面参数bean </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2018/3/21 10:13</li>
 */
public class PageParamBean {

    private long dateTime;

    private List< String > ids;

    public long getDateTime () {

        return dateTime;
    }

    public void setDateTime ( long dateTime ) {

        this.dateTime = dateTime;
    }

    public List< String > getIds () {

        return ids;
    }

    public void setIds ( List< String > ids ) {

        this.ids = ids;
    }
}
