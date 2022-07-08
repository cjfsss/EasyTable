package hos.table;

import androidx.annotation.Nullable;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.TableView;
import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.listener.ITableViewListener;

import java.util.List;

import hos.table.model.Cell;
import hos.table.model.ColumnHeader;
import hos.table.model.RowHeader;


/**
 * <p>Title: TableAdapter </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @version : 1.0
 * @date : 2022/7/6 22:36
 */
public abstract class BaseTableAdapter extends AbstractTableAdapter<ColumnHeader, RowHeader,
        Cell> {

    private int mColumnHeaderHeight;

    private int mColumnHeaderMinWidth;

    @Override
    public int getColumnHeaderItemViewType(int position) {
        ColumnHeader columnHeaderItem = getColumnHeaderItem(position);
        if (columnHeaderItem == null) {
            return 0;
        }
        return columnHeaderItem.getColumnHeaderItemType(position);
    }

    @Override
    public int getRowHeaderItemViewType(int position) {
        RowHeader rowHeaderItem = getRowHeaderItem(position);
        if (rowHeaderItem == null) {
            return 0;
        }
        return rowHeaderItem.getRowHeaderItemType(position);
    }

    @Override
    public int getCellItemViewType(int column) {
        Cell cellItem = getCellItem(column, 0);
        if (cellItem == null) {
            return 0;
        }
        return cellItem.getCellItemType(column);
    }

    @Override
    public void setColumnHeaderHeight(int columnHeaderHeight) {
        super.setColumnHeaderHeight(columnHeaderHeight);
        mColumnHeaderHeight = columnHeaderHeight;
    }

    public int getColumnHeaderMinWidth() {
        return mColumnHeaderMinWidth;
    }

    public void setColumnHeaderMinWidth(int mColumnHeaderMinWidth) {
        this.mColumnHeaderMinWidth = mColumnHeaderMinWidth;
    }

    public int getRowHeaderWidth() {
        return getTableView().getRowHeaderWidth();
    }

    public int getColumnHeaderHeight() {
        return mColumnHeaderHeight;
    }

    @Override
    public void setAllItems(@Nullable List<ColumnHeader> columnHeaderItems, @Nullable List<RowHeader> rowHeaderItems, @Nullable List<List<Cell>> cellItems) {
        super.setAllItems(columnHeaderItems, rowHeaderItems, cellItems);
    }

    @Override
    public void setCellItems(@Nullable List<List<Cell>> cellItems) {
        super.setCellItems(cellItems);
    }

    @Override
    public void setColumnHeaderItems(@Nullable List<ColumnHeader> columnHeaderItems) {
        super.setColumnHeaderItems(columnHeaderItems);
    }

    @Override
    public void setRowHeaderItems(@Nullable List<RowHeader> rowHeaderItems) {
        super.setRowHeaderItems(rowHeaderItems);
    }

    public void setTableViewListener(@Nullable ITableViewListener tableViewListener) {
        ITableView tableView = getTableView();
        if (tableView instanceof TableView) {
            ((TableView) tableView).setTableViewListener(tableViewListener);
        }
    }
}
