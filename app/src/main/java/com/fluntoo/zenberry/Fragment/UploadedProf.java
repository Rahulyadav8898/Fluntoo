package com.fluntoo.zenberry.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fluntoo.zenberry.Adapter.UploadedProfileAdapter;
import com.fluntoo.zenberry.ApIInterface.UploadedInterface;
import com.fluntoo.zenberry.Model.UploadedProfile;
import com.fluntoo.zenberry.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadedProf extends Fragment {
    RecyclerView recyclerView;
    UploadedProfileAdapter adapter;
    List<UploadedProfile> uploadlist = new ArrayList<>();

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.uploaded_prof, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview_profileuploaded);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UploadedProfileAdapter(uploadlist, getContext());
        recyclerView.setAdapter(adapter);
        listdata();
    }

    private void listdata() {
        SharedPreferences prefs = getContext().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");

        String Url = "https://www.api.playflixx.com/getGallery/" + user;
        Log.i("end", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UploadedInterface uploadedInterface = retrofit.create(UploadedInterface.class);
        Call<List<UploadedProfile>> call = uploadedInterface.getpro(Url);
        call.enqueue(new Callback<List<UploadedProfile>>() {
            @Override
            public void onResponse(Call<List<UploadedProfile>> call, Response<List<UploadedProfile>> response) {
                uploadlist.clear();
                uploadlist.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<UploadedProfile>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
