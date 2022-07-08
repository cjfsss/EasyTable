package hos.table.model;

/**
 * <p>Title: ColumnHeader </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @version : 1.0
 * @date : 2022/7/6 22:22
 */
public class ColumnHeader extends TableInfo implements ColumnHeaderItemType {

    private int columnHeaderItemViewType;

    public ColumnHeader(String id, String code, Object data) {
        super(id, code, data);
    }

    public ColumnHeader(String id, Object data) {
        super(id, data);
    }

    public ColumnHeader(Object data) {
        super(String.valueOf(System.currentTimeMillis()) + data.hashCode(), data);
    }

    public ColumnHeader(int cellItemViewType, Object data) {
        this(data);
        this.columnHeaderItemViewType = cellItemViewType;
    }


    public void setColumnHeaderItemViewType(int columnHeaderItemViewType) {
        this.columnHeaderItemViewType = columnHeaderItemViewType;
    }

    @Override
    public int getColumnHeaderItemType(int position) {
        return columnHeaderItemViewType;
    }
}
