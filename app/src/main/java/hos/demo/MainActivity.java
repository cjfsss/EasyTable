package hos.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.evrencoskun.tableview.TableView;

import java.util.List;

import hos.table.model.Cell;
import hos.table.model.ColumnHeader;
import hos.table.model.RowHeader;
import hos.table.simple.SimpleTableAdapter;

public class MainActivity extends AppCompatActivity {

    private TableView mTableView;
    private SimpleTableAdapter mTableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTableView = (TableView) findViewById(R.id.tableView);
        mTableAdapter = new SimpleTableAdapter(true);
        mTableView.setAdapter(mTableAdapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                TableViewModel tableViewModel = new TableViewModel();
                List<ColumnHeader> columnHeaderList = tableViewModel.getColumnHeaderList();
                List<RowHeader> rowHeaderList = tableViewModel.getRowHeaderList();
                List<List<Cell>> cellList = tableViewModel.getCellList();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTableAdapter.setAllItems(columnHeaderList, rowHeaderList, cellList);
                    }
                });
            }
        }).start();

    }
}