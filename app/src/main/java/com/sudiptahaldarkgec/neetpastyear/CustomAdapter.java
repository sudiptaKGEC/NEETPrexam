package com.sudiptahaldarkgec.neetpastyear;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder> {

    Context context;
    String []title;

    public CustomAdapter(Context context, String[] title) {
        this.context = context;
        this.title = title;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_front, parent, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomHolder holder, int position) {
        int bookNumber = position;
        String title1 = title[position];
        holder.textView.setText(title1);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, PdfViewPage.class);
                intent.putExtra("key_position", bookNumber);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class CustomHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
        public CustomHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.layImg);
            textView = itemView.findViewById(R.id.nameId);
            linearLayout = itemView.findViewById(R.id.LinearLayoutId);
        }
    }
}
