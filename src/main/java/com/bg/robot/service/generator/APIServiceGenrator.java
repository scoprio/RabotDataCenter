package com.bg.robot.service.generator;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangpeng on 25/07/2017.
 *
 * API service 生成
 */
public class APIServiceGenrator {




    public static <S> S createRemoteService(String url, Class<S> serviceClass, final String token) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(chain -> {
                    Request request = chain.request();
                    Request authorised = request.newBuilder()
                            .header("token", token)
                            .build();
                    return chain.proceed(authorised);
                })
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit builder = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return builder.create(serviceClass);
    }

    public static <S> S createRemoteService(String url,Class<S> serviceClass) {
        return createRemoteService(url,serviceClass,"");
    }
}
