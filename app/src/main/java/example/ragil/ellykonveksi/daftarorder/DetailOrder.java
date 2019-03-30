package example.ragil.ellykonveksi.daftarorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

import example.ragil.ellykonveksi.R;

public class DetailOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        Orderan order = getIntent().getParcelableExtra("Order");

        TextView nama = findViewById(R.id.Dnama_siswaNgukur);
        TextView asal = findViewById(R.id.Dasal_siswaNgukur);
        TextView kelas = findViewById(R.id.Dkelas_siswaNgukur);
        TextView hp = findViewById(R.id.Dhp_siswaNgukur);
        TextView biaya = findViewById(R.id.DtotalBiaya);
        TextView ket = findViewById(R.id.Dketerangan);

        nama.setText(order.getNama());
        asal.setText(order.getAsalSekolah());
        kelas.setText(order.getKelas());
        hp.setText(order.getNoHP());
        biaya.setText(order.getBayaran());
        ket.setText(order.getKeterangan());


    }
}
