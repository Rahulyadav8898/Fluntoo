package com.fluntoo.zenberry;

import static com.google.android.gms.common.util.CollectionUtils.listOf;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.fluntoo.zenberry.ApIInterface.OurRetrofit;
import com.fluntoo.zenberry.ApIInterface.OurRetrofitLogin;
import com.fluntoo.zenberry.Model.GpsTracker;
import com.fluntoo.zenberry.Model.OurDataSet1;
import com.fluntoo.zenberry.Model.OurDataSet2;
import com.fluntoo.zenberry.Model.OurDataSetLogin;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity4 extends AppCompatActivity {

    private TextView SignUp, forgetpasstv;
    private TextView Skip;
    EditText e1, e2;
    String userMail, userPassword;
    TextView lres;
    String tokenid, userid;
    Button btn;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static final String MY_PREFS_NAME1 = "MyPrefsFile1";
    String loginType = "register";
    Boolean isLogin = false;
    private GpsTracker gpsTracker;
    ConstraintLayout layout;
    private Button fbloginbtn;
    CallbackManager callbackManager;


    GoogleSignInClient mGoogleSignInClient;

    private static int RC_SIGN_IN = 100;

//
//    String fbemail;
//    String fbid;
//    String fbname;
//    String fbuserimg;
//    String fbregistertype;

    String registerationType;
    String facebookEmail;
    String facebookId;
    String userName;
    String UserProfileimagepath;

    Button fbbtn;

    private static final String EMAIL = "email";



    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        fbbtn = findViewById(R.id.fbbtng);
//        fbloginbtn = findViewById(R.id.fblogin_button);
        callbackManager = CallbackManager.Factory.create();
//        fbloginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fblogin();
//            }
//        });

        fbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fblogin();
            }
        });

//         google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
// Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();
            }
        });


        check();
        SignUp = (TextView) findViewById(R.id.takemetosignup);
        e1 = findViewById(R.id.userMail);
        e2 = findViewById(R.id.userPassword);
        btn = findViewById(R.id.login_btn);
        forgetpasstv = findViewById(R.id.forgetpass_tv);
        layout = findViewById(R.id.layoutmainlogin);
//        lres = findViewById(R.id.loginresponse);


        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//ipaddressv4
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

//        Toast.makeText(getApplicationContext(), String.valueOf(Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress())), Toast.LENGTH_SHORT).show();

//        ipaddressv6


        forgetpasstv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgetPasswordActivity.class));
            }
        });


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity4.this, Signup_Page.class));
            }
        });

        Skip = (TextView) findViewById(R.id.tv_skip);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                startActivity(new Intent(Login_Page.this, MainActivity.class));
//                skip();

            }
        });


    }

    private void fblogin() {
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.WEB_ONLY)
                .logInWithReadPermissions(this, listOf("email", "public_profile"));

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//                Toast.makeText(getApplicationContext(), "sucess done", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(@NonNull FacebookException e) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    private void check() {

        SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
        isLogin = prefs.getBoolean("isLogin", false);
        if (isLogin) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }


//    private void skip() {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.playflixx.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        SkipInterface skipInterface = retrofit.create(SkipInterface.class);
//        com.fluntoo.zenberry.Model.Skip skip = new Skip();
//        Call<Skip> call = skipInterface.Postskip(skip);
//        call.enqueue(new Callback<com.fluntoo.zenberry.Model.Skip>() {
//            @Override
//            public void onResponse(Call<com.fluntoo.zenberry.Model.Skip> call, Response<com.fluntoo.zenberry.Model.Skip> response) {
//                if (response.isSuccessful()) {
//                    Skip skip = response.body();
//
//                    String userid = skip.getSkipUserId().toString();
//
//
//                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
////                    editor.putString("tokenid",token);
//                    editor.putString("userId", userid);
//                    editor.clear();
//                    editor.apply();
//
//                    Snackbar snackbar = Snackbar
//                            .make(layout, "You Skipped Login", Snackbar.LENGTH_LONG);
//                    snackbar.show();
////                    Toast.makeText(getApplicationContext(), userid, Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<com.fluntoo.zenberry.Model.Skip> call, Throwable t) {
////                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }


    public void PostLogin(View view) {


        userMail = e1.getText().toString();
        userPassword = e2.getText().toString();


        if (userMail.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(getApplicationContext(), "please fill above fields", Toast.LENGTH_SHORT).show();
        } else {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.playflixx.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            OurRetrofitLogin ourRetrofitLogin = retrofit.create(OurRetrofitLogin.class);
            OurDataSetLogin ourDataSetLogin = new OurDataSetLogin(userMail,  loginType);
            Call<OurDataSetLogin> call = ourRetrofitLogin.PostLogin(ourDataSetLogin);

            call.enqueue(new Callback<OurDataSetLogin>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<OurDataSetLogin> call, Response<OurDataSetLogin> response) {

//                    lres.setText(response.body().getJson().getUserMail()+" "+response.body().getJson().getUserPassword());
                    if (response.isSuccessful()) {
//
                        String token = response.body().getToken();
                        String userid = response.body().getUserId();
//                        getuserid();


                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("tokenid", token);
                        editor.putString("userId", userid);
                        editor.putBoolean("isLogin", true);
                        editor.apply();

                        layout = findViewById(R.id.layoutmainlogin);
                        Snackbar snackbar = Snackbar
                                .make(layout, "Succesfully Logged In", Snackbar.LENGTH_LONG);
                        snackbar.show();

//                        Toast.makeText(getApplicationContext(),token,Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                       intent.putExtra("userid",userid.toString());
                        startActivity(intent);
//                        getLocation();


                    } else {
                        Snackbar snackbar = Snackbar
                                .make(layout, "Succesfully Logged In", Snackbar.LENGTH_LONG);
                        snackbar.show();

//                        Toast.makeText(getApplicationContext(), "email or password is incoorect", Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onFailure(Call<OurDataSetLogin> call, Throwable t) {
//                lres.setText("connection failed");
//                    Toast.makeText(getApplicationContext(), "email or password is incorrect", Toast.LENGTH_SHORT).show();
                    Snackbar snackbar = Snackbar
                            .make(layout, "email or password is incorrect", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            });

        }


        //userid

//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.playflixx.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        OurRetrofitLogin login=retrofit.create(OurRetrofitLogin.class);
//       Call<Logintoken> call=login.gettokenid();
//       call.enqueue(new Callback<Logintoken>() {
//           @Override
//           public void onResponse(Call<Logintoken> call, Response<Logintoken> response) {
//               Logintoken logintoken=response.body();
//               tokenid=logintoken.getToken();
//               Log.d("token",tokenid);
//           }
//
//           @Override
//           public void onFailure(Call<Logintoken> call, Throwable t) {
//
//           }
//       });


    }

//    public void getLocation() {
//        gpsTracker = new GpsTracker(getApplicationContext());
//        if (gpsTracker.canGetLocation()) {
//            double latitude = gpsTracker.getLatitude();
//            double longitude = gpsTracker.getLongitude();
////            tvLatitude.setText(String.valueOf(latitude));
////            tvLongitude.setText(String.valueOf(longitude));
//            Log.d("lat", String.valueOf(latitude));
//            Log.d("lat", String.valueOf(longitude));
//
////            Toast.makeText(getApplicationContext(), String.valueOf(longitude) + "/" + String.valueOf(latitude), Toast.LENGTH_SHORT).show();
//
//
//        } else {
//            gpsTracker.showSettingsAlert();
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }


    }

    AccessTokenTracker t = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            if (currentAccessToken == null) {
                Toast.makeText(getApplicationContext(), "null acess token", Toast.LENGTH_SHORT).show();
            } else {
                loaduserprofile(currentAccessToken);
            }
        }
    };

    private void loaduserprofile(AccessToken newAcessToken) {
        GraphRequest request = GraphRequest.newMeRequest(newAcessToken, (jsonObject, graphResponse) -> {
//
            if (jsonObject != null) {
                try {
                    facebookEmail = jsonObject.getString("email");
                    facebookId = jsonObject.getString("id");
                    userName = (String) jsonObject.get("first_name");
                    UserProfileimagepath = "https://graph.facebook.com/" + facebookId + "/picture?type=normal";
                    registerationType = "facebook";


//                    Toast.makeText(getApplicationContext(), UserProfileimagepath, Toast.LENGTH_SHORT).show();

//                    String e = facebookEmail;
//                    String id = facebookId;
//                    String u = userName;
//                    String upi = UserProfileimagepath;
//                    String r = registerationType;

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://www.api.playflixx.com")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                    OurDataSet2 ourDataSet2 = new OurDataSet2(registerationType, facebookEmail, facebookId, userName, UserProfileimagepath);
                    Call<OurDataSet2> call = ourRetrofit.PostData2(ourDataSet2);
                    call.enqueue(new Callback<OurDataSet2>() {
                        @Override
                        public void onResponse(Call<OurDataSet2> call, Response<OurDataSet2> response) {
//                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                            Snackbar snackbar = Snackbar
                                    .make(layout, response.toString(), Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }

                        @Override
                        public void onFailure(Call<OurDataSet2> call, Throwable t) {
//                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            Snackbar snackbar = Snackbar
                                    .make(layout, "sucessfully signed up", Snackbar.LENGTH_SHORT);

                            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.playflixx.com")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
                            OurRetrofitLogin ourRetrofitLogin = retrofit.create(OurRetrofitLogin.class);
                            OurDataSetLogin ourDataSetLogin = new OurDataSetLogin(facebookId,  "facebook");
                            Call<OurDataSetLogin> call2 = ourRetrofitLogin.PostLogin(ourDataSetLogin);

                            call2.enqueue(new Callback<OurDataSetLogin>() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onResponse(Call<OurDataSetLogin> call, Response<OurDataSetLogin> response) {

//                    lres.setText(response.body().getJson().getUserMail()+" "+response.body().getJson().getUserPassword());
                                    if (response.isSuccessful()) {
//
                                        String token = response.body().getToken();
                                        String userid = response.body().getUserId();
//                        getuserid();


                                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                        editor.putString("tokenid", token);
                                        editor.putString("userId", userid);
                                        editor.putBoolean("isLogin", true);
                                        editor.apply();

                                        layout = findViewById(R.id.layoutmainlogin);
                                        Snackbar snackbar = Snackbar
                                                .make(layout, "Succesfully Logged In", Snackbar.LENGTH_LONG);
                                        snackbar.show();

//                        Toast.makeText(getApplicationContext(),token,Toast.LENGTH_SHORT).show();


                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                       intent.putExtra("userid",userid.toString());
                                        startActivity(intent);
//                                        getLocation();


                                    } else {
                                        Snackbar snackbar = Snackbar
                                                .make(layout, "Succesfully Logged In", Snackbar.LENGTH_LONG);
                                        snackbar.show();

//                        Toast.makeText(getApplicationContext(), "email or password is incoorect", Toast.LENGTH_SHORT).show();
                                    }


                                }

                                @Override
                                public void onFailure(Call<OurDataSetLogin> call, Throwable t) {
//                lres.setText("connection failed");
//                    Toast.makeText(getApplicationContext(), "email or password is incorrect", Toast.LENGTH_SHORT).show();
                                    Snackbar snackbar = Snackbar
                                            .make(layout, "email or password is incorrect", Snackbar.LENGTH_LONG);
                                    snackbar.show();

                                }
                            });


                        }
                    });


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "failed in loaduser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }

        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "email,id,first_name");
        request.setParameters(parameters);
        request.executeAsync();


    }


    //google
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();
//                String pic = personPhoto.toString();
                String loginType1 = "google";
                String pic1;

                if (personPhoto == null) {
                    pic1 = "https://www.data.playflixx.com/newuser/ProfileImage.png";
                } else {
                    pic1 = account.getPhotoUrl().getPath();
                }

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.playflixx.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                OurDataSet1 ourDataSet1 = new OurDataSet1(personEmail, personFamilyName, personName, personId, personGivenName, loginType1);
                Call<OurDataSet1> call1 = ourRetrofit.PostData1(ourDataSet1);

                call1.enqueue(new Callback<OurDataSet1>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(Call<OurDataSet1> call, Response<OurDataSet1> response) {

                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
//
                    }

                    @Override
                    public void onFailure(Call<OurDataSet1> call, Throwable t) {
//                    tres.setText("connection failed");


//

                        Snackbar snackbar = Snackbar
                                .make(layout, "sucessfully signed up", Snackbar.LENGTH_SHORT);


                        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.playflixx.com")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        OurRetrofitLogin ourRetrofitLogin = retrofit.create(OurRetrofitLogin.class);
                        OurDataSetLogin ourDataSetLogin = new OurDataSetLogin(personEmail,  "google");
                        Call<OurDataSetLogin> callg = ourRetrofitLogin.PostLogin(ourDataSetLogin);

                        callg.enqueue(new Callback<OurDataSetLogin>() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onResponse(Call<OurDataSetLogin> call, Response<OurDataSetLogin> response) {

//                    lres.setText(response.body().getJson().getUserMail()+" "+response.body().getJson().getUserPassword());
                                if (response.isSuccessful()) {
//
                                    String token = response.body().getToken();
                                    String userid = response.body().getUserId();
//                        getuserid();


                                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                    editor.putString("tokenid", token);
                                    editor.putString("userId", userid);
                                    editor.putBoolean("isLogin", true);
                                    editor.apply();

                                    layout = findViewById(R.id.layoutmainlogin);
                                    Snackbar snackbar = Snackbar
                                            .make(layout, "Succesfully Logged In", Snackbar.LENGTH_LONG);
                                    snackbar.show();

//                        Toast.makeText(getApplicationContext(),token,Toast.LENGTH_SHORT).show();


                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                       intent.putExtra("userid",userid.toString());
                                    startActivity(intent);
//                                    getLocation();

                                } else {
                                    Snackbar snackbar = Snackbar
                                            .make(layout, "Succesfully Logged In", Snackbar.LENGTH_LONG);
                                    snackbar.show();

//                        Toast.makeText(getApplicationContext(), "email or password is incoorect", Toast.LENGTH_SHORT).show();
                                }


                            }

                            @Override
                            public void onFailure(Call<OurDataSetLogin> call, Throwable t) {
//                lres.setText("connection failed");
//                    Toast.makeText(getApplicationContext(), "email or password is incorrect", Toast.LENGTH_SHORT).show();
                                Snackbar snackbar = Snackbar
                                        .make(layout, "email or password is incorrect", Snackbar.LENGTH_LONG);
                                snackbar.show();
                            }
                        });


                    }
                });


            }

            // Signed in successfully, show authenticated UI.
//            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("message", "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }

    }


}