package xyz.gitsieg.recyclerview2;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

/**
 * Created by gitsieg on 01.02.18.
 */

public class BildeAdapter extends BaseAdapter {

    private static final String TAG = BildeAdapter.class.getSimpleName();

    private int[] imageArray;
    private Context context;

    public BildeAdapter(Context c) {
        context = c;
        imageArray = c.getResources().getIntArray(R.array.norske_kommuner);
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        return imageArray[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        Log.d(TAG, "create View");
        ImageView currentImageView;

        if (convertView == null) {
            currentImageView = new ImageView(context);
            currentImageView.setLayoutParams(new GridView.LayoutParams(300,300));
            currentImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            currentImageView.setPadding(2, 2, 2,2);
        } else {
            currentImageView = (ImageView) convertView;
        }
        currentImageView.setImageResource(imageArray[i]);
        return currentImageView;
    }
}
