package hos.table.model;

import com.evrencoskun.tableview.sort.ISortableModel;

/**
 * <p>Title: RowHeader </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @version : 1.0
 * @date : 2022/7/6 22:25
 */
public class RowHeader extends TableInfo implements RowHeaderItemType, ISortableModel {

    private int rowHeaderItemType;

    public RowHeader(String id, String code, Object data) {
        super(id, code, data);
    }

    public RowHeader(String id, Object data) {
        super(id, data);
    }

    public RowHeader(Object data) {
        super(String.valueOf(System.currentTimeMillis()) + data.hashCode(), data);
    }

    public RowHeader(int rowHeaderItemType, Object data) {
        this(data);
        this.rowHeaderItemType = rowHeaderItemType;
    }

    @Override
    public int getRowHeaderItemType(int position) {
        return rowHeaderItemType;
    }

    public void setRowHeaderItemType(int rowHeaderItemType) {
        this.rowHeaderItemType = rowHeaderItemType;
    }
}
