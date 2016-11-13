package com.example.hjl99.webview.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hjl99.webview.R;

/**
 * Created by hjl99 on 2016/11/13.
 */

public class Tools {

    private static ProgressDialog progressDialog;
    private static ImageView progressbar;

    /**
     * 显示进度条
     *
     * @param activity
     */
    public static void showProgressDialog(Activity activity) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(activity);
            progressDialog.show();

            View view=View.inflate(activity, R.layout.dialog,null);

            progressbar = (ImageView)view.findViewById(R.id.progressbar_iv);

            Animation anim = AnimationUtils.loadAnimation(activity, R.anim.rotate);
            progressbar.startAnimation(anim);

            //progressDialog.setMessage(msg);
//			TextView tv= (TextView) view.findViewById(R.id.tv_dialog);
//			tv.setText(msg);
            progressDialog.getWindow().setContentView(view);
            view.measure(0,0);

            progressDialog.getWindow().setLayout(view.getMeasuredWidth(),view.getMeasuredHeight());

            progressDialog.setCanceledOnTouchOutside(false);

        }
    }

    public static void closeProgressDialog() {
        if (progressDialog != null) {
            progressbar.clearAnimation();
            progressDialog.cancel();
            progressDialog = null;
            System.gc();
        }
    }
}
