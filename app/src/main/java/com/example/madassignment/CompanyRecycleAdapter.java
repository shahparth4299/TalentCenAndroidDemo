package com.example.madassignment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CompanyRecycleAdapter extends RecyclerView.Adapter<CompanyRecycleAdapter.ViewHolder>{
    Context context;
    int layout;
    String [] companyNames;
    int [] companyLogos;
    String[] companyVision;
    RecyclerViewInterface recyclerViewInterface;

    public CompanyRecycleAdapter(Context context, int layout, String [] companyNames, int [] companyLogos, String[] companyVision,
                                 RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.layout = layout;
        this.companyNames = companyNames;
        this.companyLogos = companyLogos;
        this.companyVision = companyVision;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.label1.setText(this.companyNames[position]);
        holder.icon.setImageResource(this.companyLogos[position]);
        holder.label2.setText(this.companyVision[position]);
    }

    @Override
    public int getItemCount() {
        return this.companyNames.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and return a viewholder
        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
        return new CompanyRecycleAdapter.ViewHolder(view, recyclerViewInterface);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView label1, label2;
        ImageView icon;
        public ViewHolder(View item, RecyclerViewInterface recyclerViewInterface){
            super(item);
            this.label1 = item.findViewById(R.id.companyName);
            this.icon = item.findViewById(R.id.companyLogo);
            this.label2 = item.findViewById(R.id.companyVision);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    recyclerViewInterface.onItemClick(position);
                }
            });
        }
    }
}
