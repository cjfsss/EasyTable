package hos.table.model;

import androidx.annotation.NonNull;

/**
 * <p>Title: Content </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @version : 1.0
 * @date : 2022/7/6 22:19
 */
public class TableInfo {
    private String id;
    private String code;
    private Object data;
    private Object extra;

    public TableInfo(String id, String code, Object data) {
        this.id = id;
        this.code = code;
        this.data = data;
    }

    public TableInfo(String id, Object data) {
        this.id = id;
        this.data = data;
    }


    public String getCode() {
        return code;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public Object getContent() {
        return data;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

}
