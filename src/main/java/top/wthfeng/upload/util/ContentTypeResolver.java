package top.wthfeng.upload.util;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;

/**
 * 文件类型解析类
 *
 * @author wangtonghe
 * @date 2016/3/26 23:01
 * @email wthfeng@126.com
 */
public class ContentTypeResolver {

//    @Value("${application.service.file.music}")
    private static String musicUrl="F:/hfmusic/music/";

    @Value("${application.service.file.photo}")
    private static String photoUrl;

//    @Value("${application.service.file.lyrics}")
    private static String lyricsUrl="F:/hfmusic/lyrics/";
//    @Value("${application.service.file.video}")
    private static String videoUrl="F:/hfmusic/video/";


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
        } else if ("text/plain".equalsIgnoreCase(contentType)) {
            return ".lrc";
        } else if ("video/mp3".equalsIgnoreCase(contentType)) {
            return ".mp3";
        } else if ("video/mp4".equalsIgnoreCase(contentType)) {
            return ".mp4";
        } else return "error";
    }

    /**
     * 获取上传文件url
     * @param suffix
     * @return
     */
    public static String getFileUrl(String suffix){
        String fileUrl="";
        if(".jpg".equals(suffix)){
            File dir = new File(photoUrl);
            if (!dir.exists() || !dir.isDirectory())  //若文件夹不存在，则创建文件夹
            {
                dir.mkdirs();  //可创建多级文件夹
            }
            fileUrl= photoUrl+GUIDUtil.normalGUID()+suffix;
        }else if(".png".equals(suffix)){
            File dir = new File(photoUrl);
            if (!dir.exists() || !dir.isDirectory())  //若文件夹不存在，则创建文件夹
            {
                dir.mkdirs();  //可创建多级文件夹
            }
            fileUrl= photoUrl+GUIDUtil.normalGUID()+suffix;
        }else if(".lrc".equals(suffix)){
            File dir = new File(lyricsUrl);
            if (!dir.exists() || !dir.isDirectory())  //若文件夹不存在，则创建文件夹
            {
                dir.mkdirs();  //可创建多级文件夹
            }
            fileUrl= lyricsUrl+GUIDUtil.normalGUID()+suffix;
        }else if (".mp4".equals(suffix)){
            File dir = new File(videoUrl);
            if (!dir.exists() || !dir.isDirectory())  //若文件夹不存在，则创建文件夹
            {
                dir.mkdirs();  //可创建多级文件夹
            }
            fileUrl= videoUrl+GUIDUtil.normalGUID()+suffix;
        }
        return fileUrl;
    }


}
