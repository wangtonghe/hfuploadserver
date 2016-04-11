package top.wthfeng.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传Service
 * @author wangtonghe
 * @date 2016/3/26 22:45
 * @email wthfeng@126.com
 */
public interface FileUploadService {
    /**
     * 上传文件，返回文件路径
     * @param file
     * @return
     * @throws Exception
     */
    String fileUpload(MultipartFile file)throws Exception;

}
