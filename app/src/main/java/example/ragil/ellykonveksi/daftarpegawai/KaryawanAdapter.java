package example.ragil.ellykonveksi.daftarpegawai;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.ragil.ellykonveksi.R;

public class KaryawanAdapter extends RecyclerView.Adapter<KaryawanAdapter.ViewHolder> {
    ArrayList<Karyawan> karyawans;
    Context context;


    public KaryawanAdapter(ArrayList<Karyawan> karyawans, Context context) {
        this.context = context;
        this.karyawans = karyawans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_pegawai,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String getNama = karyawans.get(i).getNama();
        viewHolder.setNama(getNama);

        String getHP = karyawans.get(i).getNo_hp();
        viewHolder.setHp(getHP);

        int getFoto = karyawans.get(i).getFoto();
        viewHolder.setFoto(getFoto);

    }

    @Override
    public int getItemCount() {
        return karyawans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView namaText,hpText;
        ImageView foto;
        View myView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
            cardView = itemView.findViewById(R.id.card_pegawai);
        }

        public void setNama(String text) {
            namaText = myView.findViewById(R.id.nama_pegawai);
            namaText.setText(text);
        }

        public void setHp(String hp){
            hpText = myView.findViewById(R.id.hp_pegawai);
            hpText.setText(hp);
        }

        public void setFoto(int id){
            foto = myView.findViewById(R.id.profile_image);
            foto.setImageResource(id);
        }
    }

}
