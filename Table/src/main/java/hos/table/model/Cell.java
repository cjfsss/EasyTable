package hos.table.model;

import com.evrencoskun.tableview.sort.ISortableModel;

/**
 * <p>Title: Content </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @version : 1.0
 * @date : 2022/7/6 22:19
 */
public class Cell extends TableInfo implements ISortableModel, CellItemType {
    private int cellItemViewType;

    public Cell(String id, String code, Object data) {
        super(id, code, data);
    }

    public Cell(String id, Object data) {
        super(id, data);
    }

    public Cell(int cellItemViewType, String id, Object data) {
        super(id, data);
        this.cellItemViewType = cellItemViewType;
    }

    public Cell(int cellItemViewType, String id, String code, Object data) {
        super(id, code, data);
        this.cellItemViewType = cellItemViewType;
    }

    @Override
    public int getCellItemType(int columnHeaderPosition) {
        return cellItemViewType;
    }

    public void setCellItemViewType(int cellItemViewType) {
        this.cellItemViewType = cellItemViewType;
    }
}
