package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.fluntoo.zenberry.Model.ListChannel;
//import com.example.playflix.R;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    String user;
    TextView txt, txt1;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private ArrayList<ListChannel> listchannel;
    private ArrayList<String> channelname = new ArrayList<String>();
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        txt = findViewById(R.id.text_user);
        txt1 = findViewById(R.id.txxt_1);
        spinner = findViewById(R.id.spCompany);
//        fetchJSON();



    }

//    private void fetchJSON() {
//
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//
//        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
//        String user = prefs.getString("userId", "no vale");
////
//
//        String Url = "https://www.api.playflixx.com/listchannel/" + user;
//        Log.d("comment", Url);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ListChannelInterface listChannelInterface = retrofit.create(ListChannelInterface.class);
//
//        Call<List<ListChannel>> call = listChannelInterface.getchannelist(Url);
//
//        call.enqueue(new Callback<List<ListChannel>>() {
//            @Override
//            public void onResponse(Call<List<ListChannel>> call, Response<List<ListChannel>> response) {
//                String jsonresponse = response.body().toString();
//                spinJSON(jsonresponse);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<ListChannel>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
//
//    private void spinJSON(String response) {
//
//        try {
//
//            JSONObject obj = new JSONObject(response);
//
//
//                listchannel = new ArrayList<>();
//                JSONArray dataArray  = obj.getJSONArray("");
//
//                for (int i = 0; i < dataArray.length(); i++) {
//
//                    ListChannel listChannel=new ListChannel();
//                    JSONObject dataobj = dataArray.getJSONObject(i);
//
//                    listChannel.setChannelName(listChannel.getChannelName());
//
//
//                    listchannel.add(listChannel);
//
//                }
//
//                for (int i = 0; i < listchannel.size(); i++){
//                    channelname.add(listchannel.get(i).getChannelName().toString());
//                }
//
//                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), simple_spinner_item, channelname);
//                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
//                spinner.setAdapter(spinnerArrayAdapter);
//
//            } catch (JSONException jsonException) {
//            jsonException.printStackTrace();
//        }
//
//    }

    }
