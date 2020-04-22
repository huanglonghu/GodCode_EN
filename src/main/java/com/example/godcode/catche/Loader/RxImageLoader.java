package com.example.godcode.catche.Loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.example.godcode.catche.Creator.RequestCreator;
import com.example.godcode.bean.ImageBean;
import com.example.godcode.utils.ImagUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxImageLoader {

    static RxImageLoader singleton;
    private String mUrl;
    private RequestCreator requestCreator;
    private int type;


    //防止用户可以创建该对象
    private RxImageLoader(Builder builder) {
        requestCreator = new RequestCreator(builder.mContext);
        this.type = builder.type;
    }

    public static RxImageLoader with(Context context) {
        if (singleton == null) {
            synchronized (RxImageLoader.class) {
                if (singleton == null) {
                    singleton = new Builder(context).build();
                }
            }
        }
        return singleton;
    }

    public RxImageLoader load(String url) {
        this.mUrl = url;
        return singleton;
    }

    public void into(final ImageView imageView, int type) {
        Observable
                .concat(
                        requestCreator.getImageFromMemory(mUrl),
                        requestCreator.getImageFromDisk(mUrl),
                        requestCreator.getImageFromNetwork(mUrl)
                )
                .first(new ImageBean(null, mUrl)).toObservable()
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ImageBean imageBean) {
                        Bitmap bitmap = imageBean.getBitmap();
                        if (bitmap != null) {
                            if (type == 2) {
                                imageView.setImageBitmap(bitmap);
                            } else if (type == 1) {
                                imageView.setBackground(new BitmapDrawable(bitmap));
                            } else if (type == 3) {
                                Drawable drawable = ImagUtil.conner(bitmap);
                                imageView.setImageDrawable(drawable);
                            }

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.e("onComplete", "onComplete");
                    }
                });
    }


    public Observable<ImageBean> getBitmap(String url) {
        return Observable.concat(
                requestCreator.getImageFromMemory(url),
                requestCreator.getImageFromDisk(url),
                requestCreator.getImageFromNetwork(url)
        )
                .first(new ImageBean(null, url)).toObservable();

    }


    public static class Builder {

        private Context mContext;

        private int type;

        public Builder(Context mContext) {
            this.mContext = mContext;
        }

        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public RxImageLoader build() {
            return new RxImageLoader(this);
        }
    }
}
