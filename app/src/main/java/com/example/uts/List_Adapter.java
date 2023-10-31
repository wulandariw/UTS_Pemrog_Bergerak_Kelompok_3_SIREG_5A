package com.example.uts;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class List_Adapter extends RecyclerView.Adapter<List_Adapter.ListViewHolder> {
    private ArrayList<List> Listaja;

    public List_Adapter(ArrayList<List> list) {
        this.Listaja = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        List list = Listaja.get(position);
        holder.imgPhoto.setImageResource(list.getPhoto());
        holder.tvName.setText(list.getName());
        holder.tvDescription.setText(list.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mendapatkan data pengguna yang ditekan
                List user = Listaja.get(holder.getAdapterPosition());


                // Membuat Intent untuk memulai DetailUserActivity
                Intent intent = new Intent(view.getContext(), Detail_User.class);
                Intent tail = new Intent(view.getContext(), Detail_User.class);
                intent.putExtra("position", position);

                // Mengirim data pengguna ke DetailUserActivity
                intent.putExtra("name", user.getName()); //
                intent.putExtra("description", user.getDescription());
                intent.putExtra("photo", user.getPhoto());

                view.getContext().startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return Listaja.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
