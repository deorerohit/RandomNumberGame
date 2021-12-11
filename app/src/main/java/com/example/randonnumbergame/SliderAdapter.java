package com.example.randonnumbergame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.UserViewHolder> {

    Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }


    String[] headings = {
            "Choose Level",
            "Enter Number",
            "Check It",
            "Enjoy"
    };

    String[] desc = {
            "Choose one of the 3 levels according to your convenience",
            "Enter any random number and try your luck",
            "If you gussed it right congratulations, otherwise try it again",
            "It's a light game just for enjoyment"
    };


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.slide_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.headingTextView.setText(headings[position]);
        holder.descriptionTextView.setText(desc[position]);
    }

    @Override
    public int getItemCount() {


        return headings.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView headingTextView;
        TextView descriptionTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);


            headingTextView = itemView.findViewById(R.id.heading_slider_layout);
            descriptionTextView = itemView.findViewById(R.id.desc_slider_layout);
        }
    }
}
