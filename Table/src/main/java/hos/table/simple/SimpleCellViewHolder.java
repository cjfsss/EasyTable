package hos.table.simple;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import hos.table.BaseTableAdapter;
import hos.table.R;
import hos.table.holder.BaseTableSorterHolder;
import hos.table.model.Cell;


public class SimpleCellViewHolder extends BaseTableSorterHolder<Cell> {
    private final TextView value;
    private final View root;

    public SimpleCellViewHolder(@NonNull View itemView) {
        super(itemView);
        value = itemView.findViewById(R.id.value);
        root = itemView.findViewById(R.id.root);
        View dividerRight = itemView.findViewById(R.id.dividerRight);
        View dividerBottom = itemView.findViewById(R.id.dividerBottom);
        dividerRight.setVisibility(View.GONE);
        dividerBottom.setVisibility(View.GONE);
    }

    @Override
    public void bind(@NonNull BaseTableAdapter adapter, @Nullable Cell model, int columnPosition, int rowPosition) {
        if (model == null) {
            return;
        }
        value.setText(String.valueOf(model.getContent()));
        int columnHeaderHeight = adapter.getColumnHeaderHeight();
        if (rowPosition % 2 == 0) {
            // 偶数 白色
            root.setBackgroundColor(Color.WHITE);
        } else {
            root.setBackgroundResource(R.color.table_single_bg);
        }
        int columnHeaderMinWidth = adapter.getColumnHeaderMinWidth();
        int width = getWidth(model, columnHeaderMinWidth, columnPosition, rowPosition);
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.MarginLayoutParams(width, columnHeaderHeight);
        }
        layoutParams.width = width;
        layoutParams.height = columnHeaderHeight;
        root.setLayoutParams(layoutParams);
        value.requestLayout();
        root.requestLayout();
    }

    public int getWidth(@Nullable Cell model, int columnHeaderMinWidth, int columnPosition, int rowPosition) {
        if (columnHeaderMinWidth == 0) {
            return ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        return columnHeaderMinWidth;
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
