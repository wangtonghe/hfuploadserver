package top.wthfeng.upload.util;

import java.util.UUID;

/**
 * 生成guid的工具类
 * @author wangtonghe
 * @date 2016/3/29 21:54
 * @email wthfeng@126.com
 */
public class GUIDUtil {
    /**
     * 生成标准UUID
     * @return
     */
    public static String  standardGUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 返回自然UUID
     * @return
     */
    public static String normalGUID(){
        String standardGUID = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder();
        char c= '_';
        for(int i=0;i<standardGUID.length();i++){
            char ch =standardGUID.charAt(i);
            if(ch!=c){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
