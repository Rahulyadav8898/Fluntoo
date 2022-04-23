package com.fluntoo.zenberry;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.fluntoo.zenberry.ApIInterface.AboutmeInterface;
import com.fluntoo.zenberry.Fragment.Flix_Fragment;
import com.fluntoo.zenberry.Fragment.Home_Fragment;
import com.fluntoo.zenberry.Fragment.Music_Frag;
import com.fluntoo.zenberry.Fragment.Webserie_Fragment;
import com.fluntoo.zenberry.Model.Aboutme;
import com.fluntoo.zenberry.Model.NetworkChangeListener;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import androidx.navigation.ui.AppBarConfiguration;
//import com.example.playflix.R;

public class MainActivity extends AppCompatActivity {

    //    private AppBarConfiguration mAppBArConfiguration;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();


    BottomNavigationView bottomNavigationView;
    private FloatingActionButton showSheet;
    private BottomSheetDialog bottomSheetDialog;

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    EditText editText;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private SharedPreferences sharedPreference;
    Boolean isLogin = false;
    GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInClient GoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        Intent intent=getIntent();
//       String user=intent.getStringExtra("userid");
//        Toast.makeText(getApplicationContext(),user,Toast.LENGTH_SHORT).show();
//        Log.d("tag",user.toString());


        drawerLayout = findViewById(R.id.drawer);

        nav = findViewById(R.id.navmenu);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        checkdrawer();
//

//        phonemodel
//        Toast.makeText(getApplicationContext(), getPhoneModel(), Toast.LENGTH_SHORT).show();

//        nav.setBackgroundColor(getResources().getColor(R.color.black));

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
//                    case R.id.nav_downloads:
//                        startActivity(new Intent(getApplicationContext(), DownloadActivity.class));
//                        break;

                    case R.id.nav_subscriptions:
                        Intent s = new Intent(getApplicationContext(), SubscriptionActivityNew.class);
                        startActivity(s);
                        break;

                    case R.id.nav_notification:
                        startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                        break;


//                    case R.id.nav_music:
//                    case R.id.nav_premium:
//                    case R.id.nav_trending:
                    case R.id.nav_channels:
                        Intent intentc = new Intent(getApplicationContext(), ChannelActivity.class);
                        startActivity(intentc);
                        break;

                    case R.id.nav_watchlist:
                        Intent intent = new Intent(getApplicationContext(), WatchListActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_genres:
                        Intent intentg = new Intent(getApplicationContext(), GenresActivity.class);
                        startActivity(intentg);
                        break;
//                    case R.id.nav_videoPlaylist:
//                    case R.id.nav_myPlaylist:
//                    case R.id.nav_goLive:
                    case R.id.nav_watchHistory:
                        break;
                    case R.id.nav_dataSaver:
                        break;
                    case R.id.nav_signOut:
//
                        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                .requestEmail()
                                .build();

                        mGoogleSignInClient = GoogleSignIn.getClient(getApplicationContext(), gso);

                        mGoogleSignInClient.signOut()
                                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        // ...
                                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                        editor.putBoolean("isLogin", false);
                                        editor.apply();
                                        editor.clear();
                                        startActivity(new Intent(getApplicationContext(), LoginActivityNew.class));
                                        finish();
                                    }
                                });

//
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putBoolean("isLogin", false);
                        editor.apply();
                        editor.clear();
                        startActivity(new Intent(getApplicationContext(), LoginActivityNew.class));
                        finish();


//
                        break;

                    case R.id.nav_signIn:
                        SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
                        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
                        String user = prefs.getString("userId", "no value");
                        prefs.edit().clear();

                        startActivity(new Intent(getApplicationContext(), LoginActivityNew.class));

                        finish();

                        break;

                }
                return true;
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);


        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();


        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        showSheet = findViewById(R.id.fab);
        showSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_layout,
                        (ViewGroup) findViewById(R.id.bottom_sheet));


                sheetView.findViewById(R.id.golive).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, Goive.class));

                        bottomSheetDialog.dismiss();
                    }
                });

                sheetView.findViewById(R.id.upload).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "Upload", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), VideoUploadActivity.class));
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });


       /* Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        nav = findViewById(R.id.navmenu);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_downloads:

                    case R.id.nav_subscriptions:
                    case R.id.nav_notification:
                    case R.id.nav_music:
                    case R.id.nav_premium:
                    case R.id.nav_trending:
                    case R.id.nav_channels:
                    case R.id.nav_genres:
                    case R.id.nav_videoPlaylist:
                    case R.id.nav_myPlaylist:
                    case R.id.nav_goLive:
                    case R.id.nav_watchHistory:
                    case R.id.nav_dataSaver:
                    case R.id.nav_signOut:
                }
                return true;
            }
        });





        bottomNavigationView=findViewById(R.id.bottom_navigation);

        BottomNavigationView bottomNavigationView =(BottomNavigationView)findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home_Fragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment selectedfrag=null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedfrag=new Home_Fragment();
                        break;
                    case R.id.nav_flix:
                        selectedfrag=new Flix_Fragment();
                        break;
                    case R.id.nav_add:
                        selectedfrag=new Add_Fragment();
                        break;
                    case R.id.nav_movies:
                        selectedfrag=new Movies_Fragment();
                        break;
                    case R.id.webseries:
                        selectedfrag=new WebSeries_Fragment();
                        break;



                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedfrag).commit();


                return true;
            }
        });*/


    }


    private void checkdrawer() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
        isLogin = prefs.getBoolean("isLogin", false);
        if (isLogin) {
            nav.getMenu().findItem(R.id.nav_signIn).setVisible(false);
            nav.getMenu().findItem(R.id.nav_signOut).setVisible(true);
        } else {
            nav.getMenu().findItem(R.id.nav_signIn).setVisible(true);
            nav.getMenu().findItem(R.id.nav_signOut).setVisible(false);

        }
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.play:
                            selectedFragment = new Home_Fragment();
                            break;
                        case R.id.flix:
                            selectedFragment = new Flix_Fragment();
                            break;
                        // case R.id.nav_add:
                        //   selectedFragment = new PLayFragment();
                        // break;
                        case R.id.web:
                            selectedFragment = new Webserie_Fragment();
                            break;
                        case R.id.music:
                            selectedFragment = new Music_Frag();
                            break;


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;

                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_two);

        View view = MenuItemCompat.getActionView(menuItem);
//        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
//            @Override
//            public boolean onMenuItemActionExpand(MenuItem item) {
//                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
//                getpost();
//                return true;
//            }
//
//            @Override
//            public boolean onMenuItemActionCollapse(MenuItem item) {
//                Toast.makeText(MainActivity.this, "search is coll", Toast.LENGTH_SHORT).show();
//
//                return true;
//            }
//        };
//
//        menu.findItem(R.id.menu_one).setOnActionExpandListener(onActionExpandListener);
//
//
//        SearchView searchView = (SearchView) menu.findItem(R.id.menu_one).getActionView();
//        searchView.setQueryHint("Search");

        CircleImageView profileImage = view.findViewById(R.id.toolbar_profile_image);
//        Glide
//                .with(this)
//                .load("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80")
//                .into(profileImage);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
        String token = prefs.getString("tokenid", "No token");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no value");
//        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/aboutme/aboutme/" + user;
        Log.d("profile", Url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AboutmeInterface aboutmeInterface = retrofit.create(AboutmeInterface.class);
        Call<Aboutme> call = aboutmeInterface.getaboutme(Url);
        call.enqueue(new Callback<Aboutme>() {
            @Override
            public void onResponse(Call<Aboutme> call, Response<Aboutme> response) {
                if (response.isSuccessful()) {
                    Aboutme aboutme = response.body();
                    String imgpr = aboutme.getUserProfileimagepath();
                    Glide.with(getApplicationContext())
                            .load(imgpr)
                            .into(profileImage);


                }
            }


            @Override
            public void onFailure(Call<Aboutme> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {

                    startActivity(new Intent(getApplicationContext(), MyAccountActivity.class));
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), LoginActivityNew.class));
                                    finish();
                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void getpost() {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_one:
//                Toast.makeText(MainActivity.this, "Menu one clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                return true;
            case R.id.menu_two:
                Toast.makeText(MainActivity.this, "Menu two clicked", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.menu_three:
//                Toast.makeText(MainActivity.this, "Menu three clicked", Toast.LENGTH_SHORT).show();
//                break;
            // case R.id.menu_four:
            //   Toast.makeText(MainActivity.this, "Menu four clicked", Toast.LENGTH_SHORT).show();
            // break;

        }
        return super.onOptionsItemSelected(item);
    }



   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_two);
        View view = MenuItemCompat.getActionView(menuItem);
        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this, "search is coll", Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        menu.findItem(R.id.menu_one).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_one).getActionView() ;
        searchView.setQueryHint("Search");


        CircleImageView profileImage = view.findViewById(R.id.toolbar_profile_image);

        Glide
                .with(this)
                .load("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80")
                .into(profileImage);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "profile clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_one:
                Toast.makeText(MainActivity.this, "Menu One clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_two:
                Toast.makeText(MainActivity.this, "Menu two clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_three:
                Toast.makeText(MainActivity.this, "Menu three clicked", Toast.LENGTH_SHORT).show();
                break;
            // case R.id.menu_four:
            //   Toast.makeText(MainActivity.this, "Menu four clicked", Toast.LENGTH_SHORT).show();
            // break;

        }
        return super.onOptionsItemSelected(item);
    }
*/


    private String getPhoneModel() {

        return Build.MODEL;
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, intentFilter);

        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);

        super.onStop();
    }
}
