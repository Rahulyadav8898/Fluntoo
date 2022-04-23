package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fluntoo.zenberry.Adapter.CategoryActivityAdapter;
import com.fluntoo.zenberry.Model.Category;
import com.fluntoo.zenberry.Model.Video;
//import com.example.playflix.R;
//import com.fluntoo.zenberry.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView recyclerViewcat;
    List<Category> itemslist = new ArrayList<>();
List<Video> videoList=new ArrayList<>();
    CategoryActivityAdapter categoryActivityAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerViewcat = findViewById(R.id.recyclerView_category);


        Bundle bundle = getIntent().getExtras();
        ArrayList<Video> arraylist = bundle.getParcelableArrayList("mylist");





        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewcat.setLayoutManager(layoutManager);
        categoryActivityAdapter = new CategoryActivityAdapter(getApplicationContext(), arraylist);
        recyclerViewcat.setAdapter(categoryActivityAdapter);



    }

//    private void data() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        CategoryInterface categoryInterface = retrofit.create(CategoryInterface.class);
//        Call<List<Category>> call = categoryInterface.getcategory();
//        call.enqueue(new Callback<List<Category>>() {
//            @Override
//            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
//                itemslist.clear();
//                itemslist.addAll(response.body());
//                categoryActivityAdapter.notifyDataSetChanged();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Category>> call, Throwable t) {
//
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }

}