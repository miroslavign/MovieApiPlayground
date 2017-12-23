
/*
 * ApiServiceInterceptor.java
 * Heyandroid
 *
 * Created by Miroslav Ignjatovic on 12/15/2016
 * Copyright (c) 2015 CommonSun All rights reserved.
 */

package rs.novotek.domain.backend;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiServiceInterceptor implements Interceptor {
    private static ApiServiceInterceptor instance;
    private final String homeApiBaseUrl;
    private final String authKey;

    private ApiServiceInterceptor(String authKey, String homeApiBaseUrl) {
        this.homeApiBaseUrl = homeApiBaseUrl;
        this.authKey = authKey;
    }

    public static ApiServiceInterceptor newInstance(String authKey,
                                                    String homeApiBaseUrl) {
        if (instance == null) {
            instance = new ApiServiceInterceptor(authKey, homeApiBaseUrl);
        }
        return  instance;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (authKey != null) {
            String url = request.url().url().toString();
            if (url.contains(homeApiBaseUrl)) {
                if (request.header(RestApi.NO_AUTH_TOKEN) == null) {
                    String toAppend = "api_key=";
                    if (!url.contains("?"))
                        toAppend = "?" + toAppend;
                    else
                        toAppend = "&" + toAppend;
                    request = request.newBuilder()
                            .url(url.concat(toAppend).concat(authKey))
                            .build();
                }
            }
        }
        return chain.proceed(request);
    }
}
