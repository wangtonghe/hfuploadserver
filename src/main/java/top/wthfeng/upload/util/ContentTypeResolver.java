package top.wthfeng.upload.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * 文件类型解析类
 *
 * @author wangtonghe
 * @date 2016/3/26 23:01
 * @email wthfeng@126.com
 */
public class ContentTypeResolver {

    @Value("${application.service.file.music}")
    private  String musicUrl;

    @Value("${application.service.file.photo}")
    private  String photoUrl;

    @Value("${application.service.file.lyrics}")
    private  String lyricsUrl;
    @Value("${application.service.file.video}")
    private  String videoUrl;


    /**
     * 解析文件类型并得到文件地址
     *
     * @param contentType
     * @return
     */
    public static final String resolver(String contentType) {
        if ("image/jpeg".equalsIgnoreCase(contentType)) {
            return ".jpg";
        } else if ("image/png".equalsIgnoreCase(contentType)) {
            return ".png";
        } else if ("audio/mp3".equalsIgnoreCase(contentType)) {
            return ".mp3";
        } else if ("video/mp4".equalsIgnoreCase(contentType)) {
            return ".mp4";
        }else if("application/octet-stream".equalsIgnoreCase(contentType)){
            return ".lrc";
        }
        else return "error";
    }




}
