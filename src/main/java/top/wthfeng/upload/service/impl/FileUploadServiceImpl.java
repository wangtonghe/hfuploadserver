package top.wthfeng.upload.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.wthfeng.upload.service.FileUploadService;
import top.wthfeng.upload.util.ContentTypeResolver;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

/**
 * @author wangtonghe
 * @date 2016/3/26 22:47
 * @email wthfeng@126.com
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    private static final String HOSTADDRESS = "http://wthfeng.top:8080/";


    public String  fileUpload(MultipartFile file) throws Exception {
        String suffix = ContentTypeResolver.resolver(file.getContentType());  //文件后缀
        String fileUrl = ContentTypeResolver.getFileUrl(suffix);//根据后缀得到文件上传地址
        ByteArrayInputStream in = (ByteArrayInputStream)file.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(fileUrl);
        byte[] buf = new byte[1024];
        int length =0;
        while((length=in.read(buf))>0){
            outputStream.write(buf,0,length);
        }
        in.close();
        outputStream.close();
        return HOSTADDRESS+fileUrl;
    }


}
