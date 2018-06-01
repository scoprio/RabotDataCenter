package com.bg.robot.service.service.bigo;

import java.util.Map;

import com.bg.robot.rest.dto.ResultDTO;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by wangpeng on 2018/6/1.
 */
public interface BigoSerivce {

    @POST
    Call<ResultDTO> order(@Url String url, @QueryMap Map<String,Object> params);

}
