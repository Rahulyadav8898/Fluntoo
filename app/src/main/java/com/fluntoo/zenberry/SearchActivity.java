package com.fluntoo.zenberry;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Adapter.SearchAdapter;
import com.fluntoo.zenberry.ApIInterface.SearchInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;

public class SearchActivity extends AppCompatActivity {
    EditText editText;
    ImageView img;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    RecyclerView recyclerView;
    SearchAdapter adapter;
    ArrayList<String> searchList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.result_serach_recyclerview);
        editText = findViewById(R.id.edt_search);
        img = findViewById(R.id.search_img);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SearchAdapter(searchList, getApplicationContext());
        recyclerView.setAdapter(adapter);
//        listdata();


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getsearch();

            }
        });

    }

//    private void listdata() {
//
//
//
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
//
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
////        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
//
//
//        String Url = "https://www.api.playflixx.com/searchs/"+ user;
//        Log.d("comment", Url);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        SearchInterface searchInterface=retrofit.create(SearchInterface.class);
//        Call<List<Search>> call=searchInterface.getsearchlist(Url);
//        call.enqueue(new Callback<List<Search>>() {
//            @Override
//            public void onResponse(Call<List<Search>> call, Response<List<Search>> response) {
//                searchList.clear();
//                searchList.addAll(response.body());
//                adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Search>> call, Throwable t) {
//Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//
//
//    }


    private void getsearch() {

        String keyword = editText.getText().toString();

        if (keyword.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No Search Result Found", Toast.LENGTH_LONG).show();
        }


        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

        Long userid = Long.parseLong(user);

//        String Url = "https://www.api.playflixx.com/searchs/" + user;
        String Url="https://api.fluntoo.com/search/search/Suggest";
        Log.d("search", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SearchInterface searchInterface = retrofit.create(SearchInterface.class);
//
        Call<ArrayList<String>> call = searchInterface.postsearch(Url, keyword, userid);

        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if (response.isSuccessful()) {
//                    if (!keyword.isEmpty()) {
//                        String res = response.body().get(0).toString();
//                        searchList.clear();
//                        searchList.addAll(response.body());
//                        adapter.notifyDataSetChanged();
//                        Log.d("respo", res);
//                        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();

                    searchList.clear();
                    searchList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }


//
            }




            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ero", t.toString());
            }
        });

    }
}