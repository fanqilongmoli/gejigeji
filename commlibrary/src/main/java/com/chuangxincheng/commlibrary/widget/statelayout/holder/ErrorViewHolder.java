package com.chuangxincheng.commlibrary.widget.statelayout.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chuangxincheng.commlibrary.R;


public class ErrorViewHolder extends BaseHolder {

    public ImageView ivImg;

    public ErrorViewHolder(View view) {
        tvTip = (TextView) view.findViewById(R.id.tv_message);
        ivImg = (ImageView) view.findViewById(R.id.iv_img);
    }


}
