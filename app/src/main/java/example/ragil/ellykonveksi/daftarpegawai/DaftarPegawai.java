package example.ragil.ellykonveksi.daftarpegawai;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.ragil.ellykonveksi.R;

public class DaftarPegawai extends AppCompatActivity {

    ArrayList<Karyawan> karyawanArrayList;
    RecyclerView recyclerView2;
    KaryawanAdapter karyawanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pegawai);
        karyawanArrayList = new ArrayList<>();
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerview2);
        initializeData();
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        karyawanAdapter = new KaryawanAdapter(karyawanArrayList,this);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(karyawanAdapter);
    }

    private void initializeData() {
        String[] listNama = getResources().getStringArray(R.array.item_namapegawai);
        String[] no_hp = getResources().getStringArray(R.array.item_hppegawai);
        TypedArray images = getResources().obtainTypedArray(R.array.item_dashboard_img);
        for (int i=0; i < listNama.length; i++ ){
            Karyawan karyawan= new Karyawan();
            karyawan.setNama(listNama[i]);
            karyawan.setNo_hp(no_hp[i]);
            karyawan.setFoto(images.getResourceId(i,0));
            karyawanArrayList.add(karyawan);
        }
        images.recycle();

    }
}
