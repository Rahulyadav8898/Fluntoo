package com.fluntoo.zenberry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Model.Category;
import com.fluntoo.zenberry.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

//import com.example.playflix.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewholder> {

    private Context context;
    public static List<Category> items = new ArrayList<>();

    public CategoryAdapter(Context context, ArrayList<Category> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item_category, parent, false);
        return new MyViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryAdapter.MyViewholder holder, int position) {
        Category item = items.get(position);
        List<Category.Video> videos = item.getVideo();

        holder.txt.setText("  " + item.getName() + "  ");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
////for update comment has to be done

//                Intent intent = new Intent(context, CategoryActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelableArrayList("mylist", (ArrayList<? extends Parcelable>) videos);
//                intent.putExtras(bundle);
////                this.startActivity(intent);
/////
//                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView txt;
        CardView crdv;

        public MyViewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.category_tv);
            crdv = itemView.findViewById(R.id.crdv);

        }
    }
}
