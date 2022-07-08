package hos.table.holder;

import android.content.res.Resources;
import android.view.View;

import androidx.annotation.NonNull;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

/**
 * <p>Title: BaseTableHolder </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @version : 1.0
 * @date : 2022/7/6 22:53
 */
public abstract class BaseTableHolder<T> extends AbstractViewHolder implements DataHolder<T> {
    public BaseTableHolder(@NonNull View itemView) {
        super(itemView);
    }


    /**
     * Value of dp to value of px.
     *
     * @param dpValue The value of dp.
     * @return value of px
     */
    public int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
