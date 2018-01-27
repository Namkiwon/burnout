//package com.project.unithon.unithon;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.nhn.android.naverlogin.OAuthLogin;
//import com.nhn.android.naverlogin.OAuthLoginHandler;
//import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;
//
//import junit.framework.Test;
//
//import org.xmlpull.v1.XmlPullParser;
//import org.xmlpull.v1.XmlPullParserFactory;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by namgiwon on 2018. 1. 24..
// */
//
//public class LoginActivity extends AppCompatActivity {
////*************Naver 로그인
//    public static OAuthLogin mOAuthLoginInstance;
//    public Map<String,String>  mUserInfoMap;
//    private static String OAUTH_CLIENT_ID = "X1NNlajIFiGs4YNeuZY5";  // 1)에서 받아온 값들을 넣어좁니다
//    private static String OAUTH_CLIENT_SECRET = "7alTyAR0Ia";
//    private static String OAUTH_CLIENT_NAME = "네이버 로그인";
//    private static Context mContext;
////**********************
//
//    private UserInfoVO userinfo;
//    private String token;
//    private String type;
//    EditText ID;
//    EditText PW;
//    Button SignUp;
//    Button SignIn;
//    Intent SignupIntent;
//    InputMethodManager imm1;
//    LinearLayout loginLayout;
//    String answer;
//    Gson gson;
//    SharedMemory sharedMemory;
//    OAuthLoginButton authLoginButton;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        int titlecolor = Color.parseColor("#00BBBB");
//        getSupportActionBar().setTitle("Log In");
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(titlecolor));
//
//        mContext = getApplicationContext();
//        userinfo = new UserInfoVO();
//        gson = new Gson();
//        imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        SignupIntent = new Intent(this,SignupActivity.class);
////==================================================================================
//        ID = (EditText) findViewById(R.id.id);
//        PW = (EditText) findViewById(R.id.passwd);
//
//        SignIn = (Button) findViewById(R.id.signIn);
//        SignIn.setOnClickListener(bListener);
//
//        SignUp = (Button) findViewById(R.id.signUp);
//        SignUp.setOnClickListener(bListener);
//
//        loginLayout = (LinearLayout) findViewById(R.id.loginlayout);
//        loginLayout.setOnClickListener(bListener);
//        initNaver();
//
//        authLoginButton = (OAuthLoginButton) findViewById(R.id.button_naverlogin);
//        authLoginButton.setOnClickListener(bListener);
//
//        token = getIntent().getStringExtra("token");
//        type = getIntent().getStringExtra("type");
//
//    }
//
//    Button.OnClickListener bListener = new Button.OnClickListener(){
//        @Override
//
//        public void onClick(View v) {
//            hidekeyboard();
//            switch (v.getId()){
//                case R.id.signUp :  startActivity(SignupIntent); break;
//                case R.id.signIn :
//                    Intent home = new Intent(LoginActivity.this, HomeActivity.class);
//                    home.putExtra("token",token);
//                    home.putExtra("type",type);
//                    startActivity(home);
//                    finish();
//                    break;
//                case R.id.button_naverlogin :
//                    mOAuthLoginInstance.startOauthLoginActivity(LoginActivity.this, mOAuthLoginHandler);
//                    Log.d("asdf","asdfasdf7");
//                    break;
//
//            }
//        }
//    };
//
//    private void hidekeyboard(){
//        imm1.hideSoftInputFromWindow(ID.getWindowToken(),0);
//        imm1.hideSoftInputFromWindow(PW.getWindowToken(),0);
//    }
//
//
//
//
//
//
//
//    //************************************************************************************************
//    //********************************************  Naver  *******************************************
//    //************************************************************************************************
//    private  void initNaver(){
//        //Naver Init
//        mOAuthLoginInstance = OAuthLogin.getInstance();
//        mOAuthLoginInstance.init(LoginActivity.this, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);
//        Log.d("asdf","asdfasdf");
//        /*
//         * 2015년 8월 이전에 등록하고 앱 정보 갱신을 안한 경우 기존에 설정해준 callback intent url 을 넣어줘야 로그인하는데 문제가 안생긴다.
//         * 2015년 8월 이후에 등록했거나 그 뒤에 앱 정보 갱신을 하면서 package name 을 넣어준 경우 callback intent url 을 생략해도 된다.
//         */
//        //mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME, OAUTH_callback_intent_url);
//
//    }
//
//    /**
//     * startOAuthLoginActivity() 호출시 인자로 넘기거나, OAuthLoginButton 에 등록해주면 인증이 종료되는 걸 알 수 있다.
//     */
//    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
//        @Override
//        public void run(boolean success) {
//            if (success) {
//                String accessToken = mOAuthLoginInstance.getAccessToken(mContext);
//                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
//                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
//                String tokenType = mOAuthLoginInstance.getTokenType(mContext);
//                Log.d("asdf11",accessToken);
//                Log.d("asdf22",refreshToken);
//                Log.d("asdf33",String.valueOf(expiresAt));
//                Log.d("asdf44",tokenType);
//                Log.d("asdf55", mOAuthLoginInstance.getState(mContext).toString());
//                new RequestApiTask().execute();
//                Intent a = new Intent(mContext,TestActivity.class);
//                startActivity(a);
//
//            } else {
//                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
//                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
////                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
//            }
//        };
//    };
//
//
//    private class RequestApiTask extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected void onPreExecute() {
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            String url = "https://openapi.naver.com/v1/nid/getUserProfile.xml";
//            String at = mOAuthLoginInstance.getAccessToken(mContext);
//            mUserInfoMap = requestNaverUserInfo(mOAuthLoginInstance.requestApi(mContext, at, url));
//            Log.d("asdf","asdfasdf1");
//            return null;
//        }
//
//        protected void onPostExecute(Void content) {
//            if (mUserInfoMap.get("email") == null) {
//                Toast.makeText(mContext, "로그인 실패하였습니다.  잠시후 다시 시도해 주세요!!", Toast.LENGTH_SHORT).show();
//            } else {
////                Log.d(TAG, String.valueOf(mUserInfoMap));
//
//            }
//
//        }
//    }
//    private Map<String,String> requestNaverUserInfo(String data) { // xml 파싱
//        String f_array[] = new String[9];
//
//        try {
//            Log.d("asdf","asdfasdf2");
//            XmlPullParserFactory parserCreator = XmlPullParserFactory
//                    .newInstance();
//            XmlPullParser parser = parserCreator.newPullParser();
//            InputStream input = new ByteArrayInputStream(
//                    data.getBytes("UTF-8"));
//            parser.setInput(input, "UTF-8");
//
//            int parserEvent = parser.getEventType();
//            String tag;
//            boolean inText = false;
//            boolean lastMatTag = false;
//
//            int colIdx = 0;
//
//            while (parserEvent != XmlPullParser.END_DOCUMENT) {
//
//                switch (parserEvent) {
//                    case XmlPullParser.START_TAG:
//                        tag = parser.getName();
//                        if (tag.compareTo("xml") == 0) {
//                            inText = false;
//                        } else if (tag.compareTo("data") == 0) {
//                            inText = false;
//                        } else if (tag.compareTo("result") == 0) {
//                            inText = false;
//                        } else if (tag.compareTo("resultcode") == 0) {
//                            inText = false;
//                        } else if (tag.compareTo("message") == 0) {
//                            inText = false;
//                        } else if (tag.compareTo("response") == 0) {
//                            inText = false;
//                        } else {
//                            inText = true;
//
//                        }
//                        break;
//                    case XmlPullParser.TEXT:
//                        tag = parser.getName();
//                        if (inText) {
//                            if (parser.getText() == null) {
//                                f_array[colIdx] = "";
//                            } else {
//                                f_array[colIdx] = parser.getText().trim();
//                            }
//
//                            colIdx++;
//                        }
//                        inText = false;
//                        break;
//                    case XmlPullParser.END_TAG:
//                        tag = parser.getName();
//                        inText = false;
//                        break;
//
//                }
//
//                parserEvent = parser.next();
//            }
//        } catch (Exception e) {
//            Log.e("dd", "Error in network call", e);
//        }
//
//        Map<String,String> resultMap = new HashMap<>();
//        //0 : name
//        //1 : enc_id
//        //2 : profile_url
//        //3 : age (연령대)
//        //4 : gender
//        //5 :
//        //6 : 이름
//        //7 : email
//        //8 : birth
//        userinfo.setName(f_array[6]);
//        userinfo.setEmail(f_array[7]);
//        userinfo.setProfile_path(f_array[2]);
//        userinfo.setBirth(f_array[8]);
//
//        resultMap.put("nickname"           ,f_array[0]);
//        resultMap.put("enc_id"        ,f_array[1]);
//        resultMap.put("profile_image"          ,f_array[2]);
//        resultMap.put("age"   ,f_array[3]);
//        resultMap.put("gender"             ,f_array[4]);
//        resultMap.put("nothing"          ,f_array[5]);
//        resultMap.put("name"              ,f_array[6]);
//        resultMap.put("email"            ,f_array[7]);
//        resultMap.put("birthday"        ,f_array[8]);
//        Log.d("asdf",userinfo.getEmail());
//        Log.d("tt0",f_array[0]);
//        Log.d("tt1",f_array[1]);
//        Log.d("tt2",f_array[2]);
//        Log.d("tt3",f_array[3]);
//        Log.d("tt4",f_array[4]);
//        Log.d("tt5",f_array[5]);
//        Log.d("tt6",f_array[6]);
//        Log.d("tt7",f_array[7]);
//        Log.d("tt8",f_array[8]);
//        return resultMap;
//    }
//
//    //************************************************************************************************
//    //********************************************  Naver  *******************************************
//    //************************************************************************************************
//
//}