package com.example.madassignment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class SectionRecycleAdapter extends RecyclerView.Adapter<SectionRecycleAdapter.ViewHolder>{
    Context context;
    int layout;
    String [] sections;
    int [] imageIds;
    String[] totalCompanies;
    RecyclerViewInterface recyclerViewInterface;

    public SectionRecycleAdapter(Context context, int layout, String [] sections, int [] imageIds, String[] totalCompanies,
                               RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.layout = layout;
        this.sections = sections;
        this.imageIds = imageIds;
        this.totalCompanies = totalCompanies;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.label1.setText(this.sections[position]);
        holder.icon.setImageResource(this.imageIds[position]);
        holder.label2.setText(this.totalCompanies[position]);
    }

    @Override
    public int getItemCount() {
        return this.sections.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and return a viewholder

        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
        return new SectionRecycleAdapter.ViewHolder(view, recyclerViewInterface);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView label1, label2;
        ImageView icon;
        public ViewHolder(View item, RecyclerViewInterface recyclerViewInterface){
            super(item);
            this.label1 = item.findViewById(R.id.sectionName);
            this.icon = item.findViewById(R.id.sectionImage);
            this.label2 = item.findViewById(R.id.sectionCompanies);
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
