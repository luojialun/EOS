package com.android.eos.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.android.eos.net.GlideApp;
import com.bigkoo.convenientbanner.holder.Holder;

/**
 * Created by luojialun on 2018/11/11.
 */

public class NetworkImageHolderView implements Holder<String> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        GlideApp.with(context).load(data).into(imageView);
    }
}
