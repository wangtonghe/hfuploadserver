package top.wthfeng.upload.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.wthfeng.upload.service.FileUploadService;
import top.wthfeng.upload.util.ContentTypeResolver;
import top.wthfeng.upload.util.GUIDUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author wangtonghe
 * @date 2016/3/26 22:47
 * @email wthfeng@126.com
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${application.service.file.music}")
    private  String uploadmusicUrl;

    @Value("${application.service.file.photo}")
    private  String uploadphotoUrl;

    @Value("${application.service.file.lyrics}")
    private  String uploadlyricsUrl;

    @Value("${application.service.file.video}")
    private  String uploadvideoUrl;

    @Value("${application.service.file.musicurl}")
    private  String musicUrl;

    @Value("${application.service.file.photourl}")
    private  String photoUrl;

    @Value("${application.service.file.lyricsurl}")
    private  String lyricsUrl;

    @Value("${application.service.file.videourl}")
    private  String videoUrl;


    public String  fileUpload(MultipartFile file) throws Exception {
        String suffix = ContentTypeResolver.resolver(file.getContentType());  //文件后缀
        String fileUrl = getFileUrl(suffix);//根据后缀得到文件上传地址
        ByteArrayInputStream in = (ByteArrayInputStream)file.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(fileUrl);
        byte[] buf = new byte[1024];
        int length =0;
        while((length=in.read(buf))>0){
            outputStream.write(buf,0,length);
        }
        in.close();
        outputStream.close();
        return getAccessUrl(fileUrl);
    }


    /**
     * 获取上传文件url
     * @param suffix
     * @return
     */
    public  String getFileUrl(String suffix){
        String fileUrl="";
        if(".jpg".equals(suffix)){
            File dir = new File(uploadphotoUrl);
            if (!dir.exists() || !dir.isDirectory())  //若文件夹不存在，则创建文件夹
            {
                dir.mkdirs();  //可创建多级文件夹
            }
            fileUrl= uploadphotoUrl+ GUIDUtil.normalGUID()+suffix;
        }else if(".png".equals(suffix)){
            File dir = new File(uploadphotoUrl);
            if (!dir.exists() || !dir.isDirectory())  //若文件夹不存在，则创建文件夹
            {
                dir.mkdirs();  //可创建多级文件夹
            }
            fileUrl= uploadphotoUrl+GUIDUtil.normalGUID()+suffix;
        }else if(".lrc".equals(suffix)){
            File dir = new File(uploadlyricsUrl);
            if (!dir.exists() || !dir.isDirectory())  //若文件夹不存在，则创建文件夹
            {
                dir.mkdirs();  //可创建多级文件夹
            }
            fileUrl= uploadlyricsUrl+GUIDUtil.normalGUID()+suffix;
        }else if (".mp4".equals(suffix)){
            File dir = new File(uploadvideoUrl);
            if (!dir.exists() || !dir.isDirectory())  //若文件夹不存在，则创建文件夹
            {
                dir.mkdirs();  //可创建多级文件夹
            }
            fileUrl= uploadvideoUrl+GUIDUtil.normalGUID()+suffix;
        }
        return fileUrl;
    }

    /**
     * 根据文件上传地址得到文件访问地址
     * @param fileUrl
     * @return
     */
    private String getAccessUrl(String fileUrl){
        String result =fileUrl.substring(fileUrl.lastIndexOf("/"));
      if(fileUrl.contains("photo")){
          result=photoUrl+result;
      }else if(fileUrl.contains("video")){
          result=videoUrl+result;
      }else if(fileUrl.contains("music")){
          result=musicUrl+result;
      }else if(fileUrl.contains("lyrics")){
          result=lyricsUrl+result;
      }
        return result;

    }



}
