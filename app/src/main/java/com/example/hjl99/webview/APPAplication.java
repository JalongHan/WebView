package com.example.hjl99.webview;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;

/**
 *
 * Created by hjl99 on 2016/10/17.
 */

public class APPAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       // 搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        TbsDownloader.needDownload(getApplicationContext(), false);

        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback(){


            @Override
            public void onViewInitFinished(boolean b) {

            }

            @Override
            public void onCoreInitFinished() {

            }
        };

        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.d("apptbs","onDownloadFinish");
            }

            @Override
            public void onInstallFinish(int i) {
                Log.d("apptbs","onInstallFinish");
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.d("apptbs","onDownloadProgress:"+i);
            }
        });

        QbSdk.initX5Environment(getApplicationContext(),cb);



    }
}
