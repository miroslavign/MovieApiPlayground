
/*
 * RestApi.java
 * Heyandroid
 *
 * Created by Miroslav Ignjatovic on 12/7/2015
 * Copyright (c) 2015 CommonSun All rights reserved.
 */

package rs.novotek.domain.backend;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rs.novotek.domain.backend.retrofithelper.RetryCallAdapterFactory;
import rs.novotek.domain.util.SchedulerProvider;

public class RestApi {
    private static RestApi instance;
    private final String API_BASE_URL;
    static final String AUTH_TOKEN = "X-Emb-Security-Token";
    static final String NO_AUTH_TOKEN = "No-Authentication";

    private OkHttpClient okHttpClient;
    private static Retrofit retrofit;
    private static ApiEndpointInterfaces apiEndpointInterfaces;

    private RestApi(OkHttpClient okHttpClient, SchedulerProvider schedulerProvider, String apiHome) {
        this.API_BASE_URL = apiHome;
        this.okHttpClient = okHttpClient;
        setContext(schedulerProvider);
    }

    public static RestApi newInstance(OkHttpClient okHttpClient,
            SchedulerProvider schedulerProvider,
            String apiHome) {
        if (instance == null) {
            instance = new RestApi(okHttpClient, schedulerProvider, apiHome);
        }
        return  instance;
    }

    private void setContext(SchedulerProvider schedulerProvider) {
        RxJava2CallAdapterFactory rxAdapter =
                RxJava2CallAdapterFactory.createWithScheduler(schedulerProvider.backgroundThread());

        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RetryCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .client(okHttpClient)
                .build();
    }

    public ApiEndpointInterfaces getRestService() {
        if (apiEndpointInterfaces == null)
            apiEndpointInterfaces = retrofit.create(ApiEndpointInterfaces.class);
        return apiEndpointInterfaces;
    }

}
