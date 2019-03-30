package example.ragil.ellykonveksi.dashboard;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.ragil.ellykonveksi.R;

public class Dashboard extends AppCompatActivity {

    ArrayList<DashModel> dashModelArrayList;
    RecyclerView recyclerView;
    DashAdapter dashAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        dashModelArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        initializeData();
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        dashAdapter = new DashAdapter(dashModelArrayList,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dashAdapter);
    }

    public void initializeData(){
        String[] listHeader = getResources().getStringArray(R.array.item_dashboard);
        TypedArray images = getResources().obtainTypedArray(R.array.item_dashboard_img);
        for (int i=0; i < listHeader.length; i++ ){
            DashModel dashModel = new DashModel();
            dashModel.setHeader(listHeader[i]);
            dashModel.setImage(images.getResourceId(i,0));
            dashModelArrayList.add(dashModel);
        }
        images.recycle();
    }

}
