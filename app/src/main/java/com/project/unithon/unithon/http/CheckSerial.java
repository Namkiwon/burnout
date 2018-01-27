package com.project.unithon.unithon.http;

import android.os.AsyncTask;

import com.project.unithon.unithon.SharedMemory;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by namgiwon on 2018. 1. 28..
 */

public class CheckSerial extends AsyncTask<Void,Void,String> {
    ;
    private String answer;
    private SharedMemory sharedMemory;


    public CheckSerial() {
        sharedMemory = SharedMemory.getinstance();
    }

    @Override
    protected String doInBackground(Void... params) {

        //request 를 보내줄 클라이언트 생성   (okhttp 라이브러리 사용)
        OkHttpClient client = new OkHttpClient();
        Response response;
        RequestBody requestBody =null;

        requestBody = new FormBody.Builder()
                .add("userKey",sharedMemory.getSerialnumber())
                .build();
        Request request = new Request.Builder()
                .url("http://58.232.198.231:8000/Unithon/chkUser")
                .post(requestBody)
                .build();

        try {
            response = client.newCall(request).execute();
            /////////////////////////////////// newcall 하고 응답받기를 기다리는중
            answer = response.body().string();
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
    }
}
