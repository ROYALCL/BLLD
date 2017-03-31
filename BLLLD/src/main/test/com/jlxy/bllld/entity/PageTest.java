package com.jlxy.bllld.entity;

import com.jlxy.bllld.utils.PageUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ORCHID on 2017/3/25.
 */
public class PageTest {

    Page page;

    @Before
    public void setUp() throws Exception {
        page= PageUtil.createPage(5,34,7);
    }

    @Test
    public void getEveryPage() throws Exception {
        System.out.println(page.getEveryPage());
    }

    @Test
    public void getTotalCount() throws Exception {
        System.out.println(page.getTotalCount());
    }

    @Test
    public void getTotalPage() throws Exception {
        System.out.println(page.getTotalPage());
    }

    @Test
    public void getCurrentPage() throws Exception {
        System.out.println(page.getCurrentPage());
    }

    @Test
    public void getBeginIndex() throws Exception {
        System.out.println(page.getBeginIndex());
    }

    @Test
    public void isHasPrePage() throws Exception {
        System.out.println(page.isHasPrePage());
    }

    @Test
    public void isHasNextPage() throws Exception {
        System.out.println(page.isHasNextPage());
    }

}