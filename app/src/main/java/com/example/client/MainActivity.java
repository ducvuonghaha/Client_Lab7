package com.example.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AsyncTask asyncTask = new AsyncTask() {
//            @Override
//            protected Object doInBackground(Object[] objects) {
//                String host = "192.168.162.102";
//                try {
//                    Socket socket = new Socket(host, 5554);
//
//                    if (socket.isConnected()) Log.e("KQ","CONNECTED");
//
//                    else Log.e("NOT","NOT");
//
//                    // tao du lieu gui
//                    BufferedWriter os = new BufferedWriter(new
//                            OutputStreamWriter(socket.getOutputStream()));
//
//                    os.write("Hello from Simulator" + System.currentTimeMillis());
//                    os.newLine();
//                    os.flush();
//
//                    os.close();
//                    socket.close();
//
//                } catch (Exception e) {
//                    Log.e("loi",e.getMessage());
//                }
//                return null;
//            }
//        };
//        asyncTask.execute();


        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                String host = "192.168.162.103";
                try {
                    Socket socket = new Socket(host, 5555);

                    if (socket.isConnected()) Log.e("STATUS_CLIENT", "CONNECTED");

                    else Log.e("STATUS_CLINET", "NOT CONNECTED");

                        BufferedWriter os = new BufferedWriter(new
                                OutputStreamWriter(socket.getOutputStream()));

                        os.write("From Simulator, connection time(milliseconds): " + System.currentTimeMillis());
                        os.newLine();
                        os.flush();

                        os.close();

                    // tao du lieu gui


                } catch (Exception e) {
                    Log.e("ERROR IN ASYNCTASK", e.getMessage());
                }
                return null;
            }
        };
        asyncTask.execute();

    }
}