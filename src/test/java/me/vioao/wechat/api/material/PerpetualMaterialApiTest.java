package me.vioao.wechat.api.material;

import me.vioao.wechat.api.BaseApiTest;
import me.vioao.wechat.bean.response.media.UrlResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * 永久素材接口测试.
 *
 * @author vioao
 */
@SuppressWarnings("ConstantConditions")
public class PerpetualMaterialApiTest extends BaseApiTest {
    private File TEST_IMG = new File(getClass().getClassLoader().getResource("vio.png").getFile());

    @Test
    public void testUploadImg() {
        UrlResponse result = PerpetualMaterialApi.uploadImg(TOKEN, TEST_IMG);
        System.out.println("Upload img: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
