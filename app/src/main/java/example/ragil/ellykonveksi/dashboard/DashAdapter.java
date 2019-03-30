package example.ragil.ellykonveksi.dashboard;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import example.ragil.ellykonveksi.daftarorder.DaftarOrderan;
import example.ragil.ellykonveksi.daftarpegawai.DaftarPegawai;
import example.ragil.ellykonveksi.R;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.ViewHolder> {
    Context context;
    ArrayList<DashModel> dashModelArrayList;

    public DashAdapter(ArrayList<DashModel> dashModelArrayList, Context context) {
        this.dashModelArrayList = dashModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        String get_header = dashModelArrayList.get(i).getHeader();
        viewHolder.setTextHeader(get_header);

        int get_img = dashModelArrayList.get(i).getImage();
        viewHolder.setImage(get_img);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i) {
                    case 0 :
                        Toast.makeText(context, "You Clicked Daftar Pegawai", Toast.LENGTH_SHORT).show();
                        Intent daftarPegawai = new Intent(context, DaftarPegawai.class);
                        context.startActivity(daftarPegawai);
                        break;

                    case 1 :
                        Toast.makeText(context, "You Clicked Daftar Orderan", Toast.LENGTH_SHORT).show();
                        Intent daftarOrderan = new Intent(context, DaftarOrderan.class);
                        context.startActivity(daftarOrderan);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dashModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textHeader;
        ImageView images;
        View myView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
            cardView = itemView.findViewById(R.id.cardview);
        }

        public void setTextHeader(String text) {
            textHeader = myView.findViewById(R.id.header);
            textHeader.setText(text);
        }

        public void setImage (int   i){
            images = myView.findViewById(R.id.dash_img);
            images.setImageResource(i);
        }

    }
}
