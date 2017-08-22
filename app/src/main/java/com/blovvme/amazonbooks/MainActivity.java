package com.blovvme.amazonbooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.blovvme.amazonbooks.model.Book;

public class MainActivity extends AppCompatActivity {


    ImageView imgMain;
    Button btnBooksList,btnSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgMain = (ImageView) findViewById(R.id.imgMain);
        btnBooksList = (Button) findViewById(R.id.btnBooksList);
        //btnSMS = (Button) findViewById(R.id.btnSMS);
    }

    public void onBooks(View view) {
        Intent intent = new Intent(this, BooksActivity.class);
        startActivity(intent);
    }
}
