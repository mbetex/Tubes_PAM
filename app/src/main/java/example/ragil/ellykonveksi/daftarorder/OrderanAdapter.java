package example.ragil.ellykonveksi.daftarorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import example.ragil.ellykonveksi.R;

public class OrderanAdapter extends RecyclerView.Adapter<OrderanAdapter.ViewHolder> {
    ArrayList<Orderan> orderanArrayList;
    Context context;
    private LayoutInflater mInflater;

    public OrderanAdapter(ArrayList<Orderan> orderanArrayList, Context context) {
        this.orderanArrayList = orderanArrayList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public OrderanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_orderan,parent,false);
        return new ViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(OrderanAdapter.ViewHolder holder, int position) {
        Orderan currentOrder= orderanArrayList.get(position);
        holder.bindTo(currentOrder);
    }

    @Override
    public int getItemCount() {
        return orderanArrayList.size();
    }
    

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView namaText;
        private TextView asalText;
        final OrderanAdapter mAdapter;

        public ViewHolder(View itemView,  OrderanAdapter adapter) {
            super(itemView);

            namaText = (TextView)itemView.findViewById(R.id.nama_siswa);
            asalText = (TextView)itemView.findViewById(R.id.asal_sekolah);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        public void bindTo(Orderan currentOrder) {
            namaText.setText(currentOrder.getNama());
            asalText.setText(currentOrder.getAsalSekolah());
        }

        @Override
        public void onClick(View v) {

            Orderan currentOrder= orderanArrayList.get(getAdapterPosition());

            Toast.makeText(context, "You Clicked Detail Order", Toast.LENGTH_SHORT).show();

            Intent detailOrder = new Intent(context,DetailOrder.class);

            detailOrder.putExtra("Order",currentOrder);

            context.startActivity(detailOrder);

        }
    }
}