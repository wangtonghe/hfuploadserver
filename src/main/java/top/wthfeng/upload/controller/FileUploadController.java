package top.wthfeng.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.wthfeng.upload.model.view.ViewErrorModel;
import top.wthfeng.upload.model.view.ViewFileResult;
import top.wthfeng.upload.service.FileUploadService;
import top.wthfeng.upload.util.ContentTypeResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传
 * @author wangtonghe
 * @date 2016/3/6 13:02
 * @email wthfeng@126.com
 */
@Controller
public class FileUploadController {

    @Autowired
    private FileUploadService uploadService;

    /**
     * 文件上传
     * @param file_data
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload/file",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> fileUpload(@RequestParam MultipartFile file_data)throws Exception{
        Map<String,Object> result = new HashMap<String,Object>();
        if(file_data==null||file_data.getOriginalFilename().length()<=0){
            result.put("code",1);
            result.put("data",new ViewErrorModel("file字段不能为空！"));
        }
        if("error".equals(ContentTypeResolver.resolver(file_data.getContentType()))){
            result.put("code",1);
            result.put("data",new ViewErrorModel("传入文件格式不合法！"));
        }
        ViewFileResult fileResult = new ViewFileResult();
        fileResult.setFileUrl( uploadService.fileUpload(file_data));
        result.put("code",0);
        result.put("data",fileResult);
        return result;
    }


}
