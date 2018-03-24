package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 获取校验文件名称及内容接口返回.
 *
 * @author vioao
 */
public class QrCodeJumpDownloadResponse extends BaseResponse {
    private String fileName; // 文件名称
    private String fileContent; // 文件内容

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public String toString() {
        return "QrCodeJumpDownloadResponse{"
                + "fileName='" + fileName + '\''
                + ", fileContent='" + fileContent + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
