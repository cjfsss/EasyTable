package hos.table.simple;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.sort.SortState;

import hos.table.BaseTableAdapter;
import hos.table.R;
import hos.table.holder.BaseTableSorterHolder;
import hos.table.model.ColumnHeader;


public class SimpleColumnHeaderViewHolder extends BaseTableSorterHolder<ColumnHeader> {
    private final TextView value;
    private final View root;
    private final View dividerRight;
    private final View dividerBottom;
    private final boolean isRanking;
    private ImageView ranking;

    public SimpleColumnHeaderViewHolder(@NonNull SimpleTableAdapter tableView, @NonNull View itemView) {
        this(tableView, itemView, false);
    }

    public SimpleColumnHeaderViewHolder(@NonNull SimpleTableAdapter tableView, @NonNull View itemView, boolean isRanking) {
        super(itemView);
        value = itemView.findViewById(R.id.value);
        root = itemView.findViewById(R.id.root);
        dividerRight = itemView.findViewById(R.id.dividerRight);
        dividerBottom = itemView.findViewById(R.id.dividerBottom);
        this.isRanking = isRanking;
        if (isRanking) {
            ranking = itemView.findViewById(R.id.ranking);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (SimpleColumnHeaderViewHolder viewHolder : tableView.getHeaderList()) {
                        if (viewHolder != SimpleColumnHeaderViewHolder.this) {
                            viewHolder.resetSort();
                        }
                    }
                    if (getSortState() == SortState.ASCENDING) {
                        tableView.getTableView().sortColumn(getBindingAdapterPosition(), SortState.DESCENDING);
                    } else if (getSortState() == SortState.DESCENDING) {
                        tableView.getTableView().sortColumn(getBindingAdapterPosition(), SortState.ASCENDING);
                    } else {
                        // Default one
                        tableView.getTableView().sortColumn(getBindingAdapterPosition(), SortState.DESCENDING);
                    }
                    tableView.getTableView().scrollToRowPosition(0);
                }
            });
        }
    }

    @Override
    public void bind(@NonNull BaseTableAdapter adapter, @Nullable ColumnHeader model, int columnPosition, int rowPosition) {
        if (model == null) {
            return;
        }
        value.setText(String.valueOf(model.getContent()));
        ITableView tableView = adapter.getTableView();
        int columnHeaderHeight = adapter.getColumnHeaderHeight();
        int separatorColor = tableView.getSeparatorColor();
        dividerRight.setBackgroundColor(separatorColor);
        dividerBottom.setBackgroundColor(separatorColor);
        dividerRight.setVisibility(View.GONE);
        if (tableView.isShowVerticalSeparators()) {
            dividerBottom.setVisibility(View.VISIBLE);
        } else {
            dividerBottom.setVisibility(View.GONE);
        }
        root.setBackgroundResource(R.color.table_header_bg);
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        int columnHeaderMinWidth = adapter.getColumnHeaderMinWidth();
        int width = getWidth(model, columnHeaderMinWidth, columnPosition, rowPosition);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.MarginLayoutParams(width, columnHeaderHeight);
        }
        layoutParams.width = width;
        layoutParams.height = columnHeaderHeight;
        root.setLayoutParams(layoutParams);
        value.requestLayout();
        root.requestLayout();
        itemView.requestLayout();
    }

    public int getWidth(@Nullable ColumnHeader model, int columnHeaderMinWidth, int columnPosition, int rowPosition) {
        if (columnHeaderMinWidth == 0) {
            return ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        return columnHeaderMinWidth;
    }

    @Override
    public void setBackgroundColor(int p_nColor) {

    }

    public void resetSort() {
        onSortingStatusChanged(SortState.UNSORTED);
    }

    @Override
    public void onSortingStatusChanged(@NonNull SortState pSortState) {
        super.onSortingStatusChanged(pSortState);
        if (ranking == null) {
            return;
        }
        if (getSortState() == SortState.ASCENDING) {
            ranking.setSelected(true);
            ranking.setActivated(false);
        } else if (getSortState() == SortState.DESCENDING) {
            ranking.setSelected(false);
            ranking.setActivated(true);
        } else {
            // Default one
            ranking.setSelected(false);
            ranking.setActivated(false);
        }
        itemView.requestLayout();
    }
}
