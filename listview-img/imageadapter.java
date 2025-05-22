
package com.example.uiexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int[] images;

    public ImageAdapter(Context c, int[] imgs) {
        context = c;
        images = imgs;
    }

    public int getCount() { return images.length; }
    public Object getItem(int pos) { return null; }
    public long getItemId(int pos) { return 0; }

    public View getView(int pos, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(context);
        iv.setImageResource(images[pos]);
        iv.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
        return iv;
    }
}
