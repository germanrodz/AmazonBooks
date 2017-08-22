package com.blovvme.amazonbooks;

import com.blovvme.amazonbooks.model.Book;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Blovvme on 8/20/17.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com";
    public static final String PATH = "books.json";

    //kjkx

    public static Retrofit create() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


    public static Call<ArrayList<Book>> getBook(){
        Retrofit retrofit = create();
        BookService BookService = retrofit.create(BookService.class);
        return BookService.getBook();
    }

    public interface BookService {

        @GET(PATH)
        Call<ArrayList<Book>> getBook();
    }


}//
