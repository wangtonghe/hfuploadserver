package top.wthfeng.upload.model.view;

/**
 * 文件上传返回结果类
 * @author wangtonghe
 * @date 2016/3/26 22:40
 * @email wthfeng@126.com
 */
public class ViewFileResult {
    /**
     * 文件url
     */
    private String fileUrl;
    /**
     * 文件md5值
     */
    private String md5;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
