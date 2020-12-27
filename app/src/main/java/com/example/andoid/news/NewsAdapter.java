package com.example.andoid.news;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public List<News> cartList;
    public List<News> origList;

    public NewsAdapter(Activity context, ArrayList<News> News) {
        super(context, 0, News);
        cartList = News;
    }

    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<News> results = new ArrayList<>();
                if (origList == null)
                    origList = cartList;
                if (constraint != null) {
                    if (origList != null && origList.size() > 0) {
                        for (final News g : origList) {
                            if (g.getmTitle().toLowerCase().contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                cartList = (ArrayList<News>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            if ( position == 0){
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_big, parent, false);
            }else
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_small, parent, false);
        }
        News currentnews = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.thumbnail);
        Glide.with(listItemView).load(currentnews.getmThumbnail()).into(imageView);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        titleTextView.setText(currentnews.getmTitle());

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        descriptionTextView.setText(currentnews.getmDetailes());

        TextView categoryTextView = (TextView) listItemView.findViewById(R.id.category);
        categoryTextView.setText(currentnews.getmCategory());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(currentnews.getmDate());

        return listItemView;
    }
    public List<News> getItems(){
        return cartList;
    }
}