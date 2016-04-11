package top.wthfeng.upload.model.view;

/**
 * 返回错误格式模型
 * @author wangtonghe
 * @date 2016/3/26 22:19
 * @email wthfeng@126.com
 */
public class ViewErrorModel {
    public ViewErrorModel(String error){
        this.error=error;
    }
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
