package hos.table.simple;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.evrencoskun.tableview.ITableView;

import hos.table.BaseTableAdapter;
import hos.table.R;
import hos.table.holder.BaseTableHolder;
import hos.table.model.RowHeader;


public class SimpleRowHeaderViewHolder extends BaseTableHolder<RowHeader> {
    private final TextView value;
    private final View root;
    private final View dividerRight;
    private final View dividerBottom;

    private final boolean isRanking;

    public SimpleRowHeaderViewHolder(@NonNull View itemView, boolean isRanking) {
        super(itemView);
        this.isRanking = isRanking;
        value = itemView.findViewById(R.id.value);
        root = itemView.findViewById(R.id.root);
        dividerRight = itemView.findViewById(R.id.dividerRight);
        dividerBottom = itemView.findViewById(R.id.dividerBottom);
    }

    @Override
    public void bind(@NonNull BaseTableAdapter adapter, RowHeader model, int columnPosition, int rowPosition) {
        if (model == null) {
            return;
        }
        if (isRanking) {
            value.setText(String.valueOf(rowPosition + 1));
        } else {
            value.setText(String.valueOf(model.getContent()));
        }
        ITableView tableView = adapter.getTableView();
        int rowHeaderWidth = adapter.getRowHeaderWidth();
        int columnHeaderHeight = adapter.getColumnHeaderHeight();
        int separatorColor = tableView.getSeparatorColor();
        dividerRight.setBackgroundColor(separatorColor);
        dividerBottom.setBackgroundColor(separatorColor);
        dividerBottom.setVisibility(View.GONE);
        if (tableView.isShowHorizontalSeparators()) {
            dividerRight.setVisibility(View.VISIBLE);
        } else {
            dividerRight.setVisibility(View.GONE);
        }
        if (rowPosition % 2 == 0) {
            // 偶数 白色
            root.setBackgroundColor(Color.WHITE);
        } else {
            root.setBackgroundResource(R.color.table_single_bg);
        }
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.MarginLayoutParams(rowHeaderWidth, columnHeaderHeight);
        }
        layoutParams.width = rowHeaderWidth;
        layoutParams.height = columnHeaderHeight;
        root.setLayoutParams(layoutParams);
    }

    @Override
    public void setBackgroundColor(int p_nColor) {
//        if (getBindingAdapterPosition() % 2 == 0) {
//            // 偶数 白色
//            root.setBackgroundColor(Color.WHITE);
//        } else {
//            root.setBackgroundResource(R.color.table_single_bg);
//        }
    }
}
