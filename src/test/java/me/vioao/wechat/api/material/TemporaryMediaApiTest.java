package me.vioao.wechat.api.material;

import me.vioao.wechat.api.BaseApiTest;
import me.vioao.wechat.bean.response.media.MediaResponse;
import me.vioao.wechat.bean.response.media.UrlResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * 临时素材接口测试.
 *
 * @author vioao
 */
public class TemporaryMediaApiTest extends BaseApiTest {
    private File TEST_IMG = new File(getClass().getClassLoader().getResource("vio.png").getFile());

    @Test
    public void testUploadImg() {
        MediaResponse result = TemporaryMediaApi.uploadImg(TOKEN, TEST_IMG);
        System.out.println("Upload img: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
