package com.blovvme.amazonbooks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blovvme.amazonbooks.model.Book;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Blovvme on 8/20/17.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> bookList = new ArrayList<>();
    private Context context;
    Book book;
    //constructor
//    public BooksAdapter(List<Book> bookList, Context context) {
//        this.bookList = bookList;
//        this.context = context;
//    }

    public BooksAdapter(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .books_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.rvBookTitle.setText(bookList.



                get(position).getTitle());
        holder.rvBookAuthor.setText(bookList.get(position).getAuthor());
        Glide.with(holder.itemView.getContext()).load(bookList.get(position).getImageURL()).into(holder.rvImage);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rvImage;
        TextView rvBookTitle;
        TextView rvBookAuthor;

        public ViewHolder(View itemView) {
            super(itemView);

            rvImage = (ImageView) itemView.findViewById(R.id.rvImage);
            rvBookTitle = (TextView) itemView.findViewById(R.id.rvBookTitle);
            rvBookAuthor = (TextView) itemView.findViewById(R.id.rvBookAuthor);

        }
    }
}
