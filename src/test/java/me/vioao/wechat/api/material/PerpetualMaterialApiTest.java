package me.vioao.wechat.api.material;

import me.vioao.wechat.api.BaseApiTest;
import me.vioao.wechat.bean.entity.material.Description;
import me.vioao.wechat.bean.entity.material.MaterialType;
import me.vioao.wechat.bean.response.material.MaterialBatchGetResponse;
import me.vioao.wechat.bean.response.material.MaterialCountResponse;
import me.vioao.wechat.bean.response.media.MediaResponse;
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
    private File VIDEO = new File(getClass().getClassLoader().getResource("video.mp4").getFile());

    @Test
    public void testUploadImg() {
        UrlResponse result = PerpetualMaterialApi.uploadImg(TOKEN, TEST_IMG);
        System.out.println("Upload img: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testAddImageMaterial() {
        MediaResponse result = PerpetualMaterialApi.addImgMaterial(TOKEN, TEST_IMG);
        System.out.println("Add image material: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testAddThumbMaterial() {
        MediaResponse result = PerpetualMaterialApi.addThumbMaterial(TOKEN, TEST_IMG);
        System.out.println("Add thumb material: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testAddVideoMaterial() {
        MediaResponse result = PerpetualMaterialApi
                .addVideoMaterial(TOKEN, VIDEO, new Description("title", "description"));
        System.out.println("Add video material: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testGetMaterialCount() {
        MaterialCountResponse result = PerpetualMaterialApi.getMaterialCount(TOKEN);
        System.out.println("Get material count: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testBatchGetMaterial() {
        MaterialBatchGetResponse result = PerpetualMaterialApi
                .batchGetMaterial(TOKEN, MaterialType.IMAGE.name().toLowerCase(), 0, 3);
        System.out.println("Batch get material: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
