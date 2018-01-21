package me.vioao.wechat.api.material;

import me.vioao.wechat.api.BaseApiTest;
import me.vioao.wechat.bean.MediaFile;
import me.vioao.wechat.bean.response.media.VideoUrlResponse;
import me.vioao.wechat.bean.response.media.MediaResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * 临时素材接口测试.
 *
 * @author vioao
 */
@SuppressWarnings("ConstantConditions")
public class TemporaryMediaApiTest extends BaseApiTest {
    private File IMG = new File(getClass().getClassLoader().getResource("vio.png").getFile());
    private File THUMB = new File(getClass().getClassLoader().getResource("vio.jpg").getFile());
    private File VIDEO = new File(getClass().getClassLoader().getResource("video.mp4").getFile());
    private File VOICE = new File(getClass().getClassLoader().getResource("voice.mp3").getFile());

    @Test
    public void testUploadAndGetImg() {
        MediaResponse result = TemporaryMediaApi.uploadImg(TOKEN, IMG);
        System.out.println("Upload img: " + result);
        Assert.assertEquals(true, result.isSuccess());

        MediaFile result2 = TemporaryMediaApi.download(TOKEN, result.getMediaId());
        System.out.println("Download img: " + result2);
        Assert.assertNotNull(result2.getFileStream());
    }

    @Test
    public void testUploadThumb() {
        MediaResponse result = TemporaryMediaApi.uploadThumb(TOKEN, THUMB);
        System.out.println("Upload thumb: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testUploadVoice() {
        MediaResponse result = TemporaryMediaApi.uploadVoice(TOKEN, VOICE);
        System.out.println("Upload voice: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testUploadAndDownLoadVideo() {
        MediaResponse result = TemporaryMediaApi.uploadVideo(TOKEN, VIDEO);
        System.out.println("Upload video: " + result);
        Assert.assertEquals(true, result.isSuccess());

        VideoUrlResponse result2 = TemporaryMediaApi.downloadVideo(TOKEN, result.getMediaId());
        System.out.println("Download video: " + result2);
        Assert.assertEquals(true, result2.isSuccess());
    }
}
