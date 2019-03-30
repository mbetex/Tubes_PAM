package example.ragil.ellykonveksi.daftarorder;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import java.util.ArrayList;

import example.ragil.ellykonveksi.R;
import example.ragil.ellykonveksi.daftarpegawai.Karyawan;
import example.ragil.ellykonveksi.daftarpegawai.KaryawanAdapter;

public class DaftarOrderan extends AppCompatActivity {

    ArrayList<Orderan> orderanArrayList;
    RecyclerView recyclerView3;
    OrderanAdapter orderanAdapter;
    AlertDialog.Builder form_dialog;
    View dialogView;
    LayoutInflater inflater;
    EditText namaText,kelasText,hpText,hargaText,ketText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_order);
        orderanArrayList = new ArrayList<>();
        recyclerView3 = (RecyclerView) findViewById(R.id.recyclerview3);

        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        orderanAdapter = new OrderanAdapter(orderanArrayList,this);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setAdapter(orderanAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogForm();
                int orderSize = orderanArrayList.size();
                recyclerView3.getAdapter().notifyItemInserted(orderSize);
                recyclerView3.smoothScrollToPosition(orderSize);

            }
        });
    }

    private void DialogForm() {
        form_dialog = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_pesanan,null);
        form_dialog.setView(dialogView);
        form_dialog.setCancelable(true);
        form_dialog.setIcon(R.drawable.icon_shopping_basket);
        form_dialog.setTitle("Form Order");

        namaText = dialogView.findViewById(R.id.nama_siswaNgukur);
        kelasText = dialogView.findViewById(R.id.kelas_siswaNgukur);
        hpText = dialogView.findViewById(R.id.hp_siswaNgukur);
        hargaText = dialogView.findViewById(R.id.totalBiaya);
        ketText = dialogView.findViewById(R.id.keterangan);

        form_dialog.setPositiveButton("TAMBAH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Orderan order = new Orderan();
                order.setNama(namaText.getText().toString());
                order.setAsalSekolah("AR");
                order.setKelas(kelasText.getText().toString());
                order.setNoHP(hpText.getText().toString());
                order.setBayaran(hargaText.getText().toString());
                order.setKeterangan(ketText.getText().toString());
                orderanArrayList.add(order);
                orderanAdapter.notifyDataSetChanged();
            }
        });

        form_dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        form_dialog.show();
    }


}
