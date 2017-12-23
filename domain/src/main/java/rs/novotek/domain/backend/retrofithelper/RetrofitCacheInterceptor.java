
/*
 * RetrofitCacheInterceptor.java
 * Heyandroid
 *
 * Created by Miroslav Ignjatovic on 6/30/2017
 * Copyright (c) 2015 CommonSun All rights reserved.
 */

package rs.novotek.domain.backend.retrofithelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;

public class RetrofitCacheInterceptor implements Interceptor {

    private final int maxStale;
    public RetrofitCacheInterceptor(int maxStale) {
        this.maxStale = maxStale;
    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response response = chain.proceed(chain.request());
        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge(maxStale, TimeUnit.SECONDS)
                .build();
        return response.newBuilder()
                .header("Cache-Control", cacheControl.toString())
                .build();
    }
}
