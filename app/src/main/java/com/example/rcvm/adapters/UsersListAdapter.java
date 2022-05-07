package com.example.rcvm.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rcvm.ProfileActivity;
import com.example.rcvm.R;
import com.example.rcvm.models.DataModel;

import java.util.List;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.myviewholder> {
    List<DataModel> userslist;

    public UsersListAdapter(List<DataModel> list) {
        this.userslist = list;
    }

    public void updateuserslist(List<DataModel> list) {
        this.userslist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.name.setText(userslist.get(position).getFirstName() +" "+userslist.get(position).getLastName());
        holder.email.setText(userslist.get(position).getEmail());
        Glide.with(holder.name.getContext()).load(userslist.get(position).getAvatar()).circleCrop().into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                intent.putExtra("email", userslist.get(position).getEmail());
                intent.putExtra("id", userslist.get(position).getId().toString());
                intent.putExtra("name", userslist.get(position).getFirstName() +" "+ userslist.get(position).getLastName());
                intent.putExtra("avatar", userslist.get(position).getAvatar());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(this.userslist != null)
            return this.userslist.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name, email;
        ImageView img;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.uName);
            email=itemView.findViewById(R.id.uEmail);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}
