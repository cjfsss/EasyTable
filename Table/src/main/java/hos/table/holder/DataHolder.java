package hos.table.holder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import hos.table.BaseTableAdapter;
import hos.table.model.RowHeader;

/**
 * <p>Title: DataHolder </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @version : 1.0
 * @date : 2022/7/6 22:55
 */
public interface DataHolder<T> {

 void bind(@NonNull BaseTableAdapter adapter, @Nullable T model, int columnPosition, int rowPosition);
}
