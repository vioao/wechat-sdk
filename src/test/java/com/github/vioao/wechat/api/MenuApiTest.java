package com.github.vioao.wechat.api;


import com.github.vioao.wechat.bean.entity.menu.Button;
import com.github.vioao.wechat.bean.entity.menu.MenuButtons;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.menu.GetMenuResponse;
import com.github.vioao.wechat.bean.response.menu.selfmenu.GetCurrentSelfMenuInfoResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 菜单相关API测试.
 *
 * @author vioao
 */
public class MenuApiTest extends BaseApiTest {

    @Test
    public void testCreate() {
        Button click = new Button();
        click.setType("click");
        click.setName("今日歌曲");
        click.setKey("V1001_TODAY_MUSIC");

        Button view = new Button();
        view.setType("view");
        view.setName("搜索");
        view.setUrl("http://www.soso.com/");
        Button click2 = new Button();
        click2.setType("click");
        click2.setName("赞一下我们");
        click2.setKey("V1001_GOOD");
        Button complex = new Button();
        complex.setName("菜单");
        complex.setSubButton(Arrays.asList(view, click2));

        MenuButtons menuButtons = new MenuButtons();
        menuButtons.setButton(Arrays.asList(click, complex));
        BaseResponse result = MenuApi.create(TOKEN, menuButtons);

        System.out.println("Create Menu: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testGet() {
        GetMenuResponse result = MenuApi.get(TOKEN);
        boolean flag = result.isSuccess() || result.getErrcode().equals(46003);
        System.out.println("Get Menu: " + result);
        Assert.assertEquals(true, flag);
    }

    @Test
    public void testGetCurrentSelfMenuInfo() {
        GetCurrentSelfMenuInfoResponse result = MenuApi.getCurrentSelfMenuInfo(TOKEN);
        System.out.println("GetCurrentSelfMenuInfo: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testDelete() {
        BaseResponse result = MenuApi.delete(TOKEN);
        System.out.println("Delete Menu: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
