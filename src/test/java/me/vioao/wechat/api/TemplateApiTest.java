package me.vioao.wechat.api;

import me.vioao.wechat.bean.entity.template.TemplateMessage;
import me.vioao.wechat.bean.entity.template.TemplateMessageItem;
import me.vioao.wechat.bean.response.BaseResponse;
import me.vioao.wechat.bean.response.template.IndustryResponse;
import me.vioao.wechat.bean.response.template.SendTemplateMsgResponse;
import me.vioao.wechat.bean.response.template.TemplateListResponse;
import me.vioao.wechat.bean.response.template.TemplateResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * 模版相关API测试.
 *
 * @author vioao
 */
public class TemplateApiTest extends BaseApiTest {
    @Test
    public void testSetIndustry() {
        String industryId1 = "1";
        String industryId2 = "9";
        BaseResponse result = TemplateApi.setIndustry(TOKEN, industryId1, industryId2);
        System.out.println("Set industry: " + result);
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetIndustry() {
        IndustryResponse result = TemplateApi.getIndustry(TOKEN);
        System.out.println("Get industry: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testGetAllPrivateTemplate() {
        TemplateListResponse result = TemplateApi.getAllPrivateTemplate(TOKEN);
        System.out.println("Get all private template: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    /**
     * TM00354
     * 标题保单交费提醒
     * 行业金融业 - 保险
     * {{first.DATA}}
     * <p>
     * {{headinfo.DATA}}
     * 保单号：{{policyno.DATA}}
     * 险种：{{product.DATA}}
     * 交费期次：{{period.DATA}}
     * 应交费日期：{{paydate.DATA}}
     * 应交费金额:{{amount.DATA}}
     * 交费方式：{{paycode.DATA}}
     * 交费账号：{{account.DATA}}
     * 服务人员：{{contno.DATA}}
     * {{remark.DATA}}
     */

    @Test
    public void testAddAndSendAndDelTemplate() {
        String templateIdShort = "TM00354";
        TemplateResponse result = TemplateApi.addTemplate(TOKEN, templateIdShort);
        System.out.println("Add template: " + result);
        Assert.assertEquals(true, result.isSuccess());

        String templateId = result.getTemplateId();
        LinkedHashMap<String, TemplateMessageItem> data = new LinkedHashMap<>();
        data.put("first", new TemplateMessageItem("first"));
        data.put("headinfo", new TemplateMessageItem("headinfo"));
        data.put("policyno", new TemplateMessageItem("policyno"));
        data.put("product", new TemplateMessageItem("product"));
        data.put("paydate", new TemplateMessageItem("2018-01-01"));
        data.put("amount", new TemplateMessageItem("10000"));
        data.put("paycode", new TemplateMessageItem("wechat"));
        data.put("account", new TemplateMessageItem("account"));
        data.put("contno", new TemplateMessageItem("contno"));
        data.put("remark", new TemplateMessageItem("remark"));
        TemplateMessage msg = TemplateMessage.builder().templateId(templateId).touser(OPENID).data(data).build();
        SendTemplateMsgResponse resultSend = TemplateApi.sendTemplateMessage(TOKEN, msg);
        System.out.println("Send template message: " + resultSend);
        Assert.assertEquals(true, resultSend.isSuccess());

        BaseResponse resultDel = TemplateApi.delPrivateTemplate(TOKEN, templateId);
        System.out.println("Delete private template : " + resultDel);
        Assert.assertEquals(true, resultDel.isSuccess());
    }

}
