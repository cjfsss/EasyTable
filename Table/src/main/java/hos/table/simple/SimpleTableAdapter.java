package hos.table.simple;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.evrencoskun.tableview.listener.ITableViewListener;

import java.util.ArrayList;
import java.util.List;

import hos.table.BaseTableAdapter;
import hos.table.R;
import hos.table.model.Cell;
import hos.table.model.ColumnHeader;
import hos.table.model.RowHeader;

/**
 * <p>Title: SimpleTableAdapter </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @version : 1.0
 * @date : 2022/7/7 22:06
 */
public class SimpleTableAdapter extends BaseTableAdapter {

    private final boolean isRanking;

    private final List<SimpleColumnHeaderViewHolder> mHeaderList = new ArrayList<>();

    public SimpleTableAdapter() {
        this(false);
    }

    public SimpleTableAdapter(boolean isRanking) {
        this.isRanking = isRanking;
    }

    @NonNull
    public List<SimpleColumnHeaderViewHolder> getHeaderList() {
        return mHeaderList;
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateCellViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimpleCellViewHolder(View.inflate(parent.getContext(), R.layout.simple_table, null));
    }

    @Override
    public void onBindCellViewHolder(@NonNull AbstractViewHolder holder, @Nullable Cell cellItemModel, int columnPosition, int rowPosition) {
        if (holder instanceof SimpleCellViewHolder) {
            ((SimpleCellViewHolder) holder).bind(this, cellItemModel, columnPosition, rowPosition);
        }
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateColumnHeaderViewHolder(@NonNull ViewGroup parent, int viewType) {
        SimpleColumnHeaderViewHolder viewHolder;
        if (isRanking) {
            viewHolder = new SimpleColumnHeaderViewHolder(this, View.inflate(parent.getContext(), R.layout.simple_table_ranking, null), isRanking);
        } else {
            viewHolder = new SimpleColumnHeaderViewHolder(this, View.inflate(parent.getContext(), R.layout.simple_table, null));
        }
        if (!mHeaderList.contains(viewHolder)) {
            mHeaderList.add(viewHolder);
        }
        return viewHolder;
    }

    @Override
    public void onBindColumnHeaderViewHolder(@NonNull AbstractViewHolder holder, @Nullable ColumnHeader columnHeaderItemModel, int columnPosition) {
        if (holder instanceof SimpleColumnHeaderViewHolder) {
            ((SimpleColumnHeaderViewHolder) holder).bind(this, columnHeaderItemModel, columnPosition, 0);
        }
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateRowHeaderViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimpleRowHeaderViewHolder(View.inflate(parent.getContext(), R.layout.simple_table, null),isRanking);
    }

    @Override
    public void onBindRowHeaderViewHolder(@NonNull AbstractViewHolder holder, @Nullable RowHeader rowHeaderItemModel, int rowPosition) {
        if (holder instanceof SimpleRowHeaderViewHolder) {
            ((SimpleRowHeaderViewHolder) holder).bind(this, rowHeaderItemModel, 0, rowPosition);
        }
    }

    @NonNull
    @Override
    public View onCreateCornerView(@NonNull ViewGroup viewGroup) {
        View view = View.inflate(viewGroup.getContext(), R.layout.simple_table, null);
        View root = view.findViewById(R.id.root);
        View dividerRight = view.findViewById(R.id.dividerRight);
        View dividerBottom = view.findViewById(R.id.dividerBottom);
        ITableView tableView = getTableView();
        int rowHeaderWidth = getRowHeaderWidth();
        int columnHeaderHeight = getColumnHeaderHeight();
        int separatorColor = tableView.getSeparatorColor();
        dividerRight.setBackgroundColor(separatorColor);
        dividerBottom.setBackgroundColor(separatorColor);
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.MarginLayoutParams(rowHeaderWidth, columnHeaderHeight);
        }
        layoutParams.height = columnHeaderHeight;
        layoutParams.width = rowHeaderWidth;
        root.setLayoutParams(layoutParams);
        if (tableView.isShowVerticalSeparators()) {
            dividerBottom.setVisibility(View.VISIBLE);
        } else {
            dividerBottom.setVisibility(View.GONE);
        }
        if (tableView.isShowHorizontalSeparators()) {
            dividerRight.setVisibility(View.VISIBLE);
        } else {
            dividerRight.setVisibility(View.GONE);
        }
        return view;
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

    @Override
    public void setTableViewListener(@Nullable ITableViewListener tableViewListener) {
        super.setTableViewListener(tableViewListener);
    }
}
