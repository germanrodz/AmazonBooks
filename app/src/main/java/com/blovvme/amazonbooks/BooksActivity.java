package com.blovvme.amazonbooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blovvme.amazonbooks.model.Book;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class BooksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    BooksAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        recyclerView = (RecyclerView) findViewById(R.id.rvBooks);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);

        Call<ArrayList<Book>> bookCall = RetrofitHelper.getBook();
/*        bookCall.enqueue(new retrofit2.Callback<Book>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                ArrayList<Book> bookArrayList = (ArrayList<Book>) response.body().listIterator();
                BooksAdapter booksAdapter = new BooksAdapter(bookArrayList);

            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });*/

        bookCall.enqueue(new retrofit2.Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                ArrayList<Book> bookArrayList = response.body();
                BooksAdapter booksAdapter = new BooksAdapter(bookArrayList);
                recyclerView.setAdapter(booksAdapter);
                booksAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

            }
        });

    }









}//
