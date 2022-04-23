package com.fluntoo.zenberry;

import static com.google.android.gms.common.util.CollectionUtils.listOf;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
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
import com.fluntoo.zenberry.ApIInterface.SkipInterface;
import com.fluntoo.zenberry.Model.OurDataSet1;
import com.fluntoo.zenberry.Model.OurDataSet2;
import com.fluntoo.zenberry.Model.OurDataSet5;
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

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivityNew extends AppCompatActivity {
    TextView signtv, forgottv;
    Button fbtn, googlebtn;
    private Button fbloginbtn;
    CallbackManager callbackManager;

    String loginType = "register";
    Boolean isLogin = false;

    GoogleSignInClient mGoogleSignInClient;
    ConstraintLayout layout;

    private static int RC_SIGN_INN = 100;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static final String MY_PREFS_NAME1 = "MyPrefsFile1";
    EditText phonedt, passwordedt;
    Button loginbtn, skipbtn;
    String phone, pass;

    String registerationType;
    String facebookEmail;
    String facebookId;
    String userName;
    String UserProfileimagepath;

    private static int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_LOAD_IMAGE_2 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);
        forgottv = findViewById(R.id.Forgetpass_tv);
        phonedt = findViewById(R.id.editTextphone);
        passwordedt = findViewById(R.id.editTextpassword);
        loginbtn = findViewById(R.id.Loginbtn);
        skipbtn = findViewById(R.id.Skipbtn);
        fbloginbtn = findViewById(R.id.Fbbtn);


        signtv = findViewById(R.id.Signup_tv);
//        googlebtn=findViewById(R.id.Googlebtn);
        layout = findViewById(R.id.conlay);

        callbackManager = CallbackManager.Factory.create();

        allowPermissionForFile();


        fbloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fblogin();
            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phone = phonedt.getText().toString().trim();
                pass = passwordedt.getText().toString().trim();

                if (phone.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill Fields", Toast.LENGTH_SHORT).show();
                } else {

                    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.fluntoo.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                    OurDataSet5 ourDataSet$ = new OurDataSet5(phone, pass);
                    Call<OurDataSet5> call = ourRetrofit.PostData5(ourDataSet$);

                    call.enqueue(new Callback<OurDataSet5>() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onResponse(Call<OurDataSet5> call, Response<OurDataSet5> response) {
//                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
//                            Log.d("log", response.toString());
                            if (response.isSuccessful()) {
//
                                String token = response.body().getToken();
                                String userid = response.body().getUserId();

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("tokenid", token);
                                editor.putString("userId", userid);
                                editor.putBoolean("isLogin", true);
                                editor.apply();


//                                Toast.makeText(getApplicationContext(), token, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onFailure(Call<OurDataSet5> call, Throwable t) {
//                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            Snackbar snackbar = Snackbar.make(layout, "Please Check Number or Password", Snackbar.LENGTH_SHORT);
                            snackbar.show();

                        }
//
                    });

                }
            }

        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
// Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);

        SignInButton signInButton2 = findViewById(R.id.Googlebtn);
        signInButton2.setSize(SignInButton.SIZE_STANDARD);


        signtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Signup_Activity_New.class));
            }
        });

        check();
        signInButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        forgottv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgotPasswordActivityNew.class));
            }
        });
    }

    private void skip() {
        String url = "https://api.fluntoo.com/skip/getid";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fluntoo.com/skip/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SkipInterface skipInterface = retrofit.create(SkipInterface.class);
        Call<ResponseBody> call = skipInterface.getskip();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody res = response.body();
                Log.d("es", res.toString());
//
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
//                    editor.putString("tokenid",token);
                editor.putString("userId", String.valueOf(res));
                editor.clear();
                editor.apply();
                Snackbar snackbar = Snackbar
                        .make(layout, "You Skipped Login", Snackbar.LENGTH_LONG);
                snackbar.show();
//                    Toast.makeText(getApplicationContext(), String.valueOf(res), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("er", t.getMessage());
//

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


    private void check() {

        SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);
        isLogin = prefs.getBoolean("isLogin", false);
        if (isLogin) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_INN);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_INN) {
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
                            .baseUrl("https://api.fluntoo.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                    OurDataSet2 ourDataSet2 = new OurDataSet2(facebookEmail, userName, userName, userName, facebookId, registerationType);
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

                            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.fluntoo.com/")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
                            OurRetrofitLogin ourRetrofitLogin = retrofit.create(OurRetrofitLogin.class);
                            OurDataSetLogin ourDataSetLogin = new OurDataSetLogin(facebookId, "facebook");
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

                                        layout = findViewById(R.id.conlay);
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
//                    pic1="https://data.fluntoo.com/PlayflixxData/276/Play/Channel/THELIONKING/Images/Profile_Image/rupesh.jpg.webp";
                } else {
                    pic1 = account.getPhotoUrl().getPath();
                }

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.fluntoo.com/")
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


                        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.fluntoo.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        OurRetrofitLogin ourRetrofitLogin = retrofit.create(OurRetrofitLogin.class);
                        OurDataSetLogin ourDataSetLogin = new OurDataSetLogin(personEmail, "google");
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

                                    layout = findViewById(R.id.conlay);
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

    private void allowPermissionForFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, RESULT_LOAD_IMAGE);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, RESULT_LOAD_IMAGE_2);
        }

    }
}