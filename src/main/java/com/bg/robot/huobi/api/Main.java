package com.bg.robot.huobi.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bg.robot.huobi.response.KlineResponse;
import com.bg.robot.rest.dto.ResultDTO;
import com.bg.robot.service.OrderService;
import com.bg.robot.service.generator.APIServiceGenrator;
import com.bg.robot.service.service.bigo.BigoSerivce;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.jooq.tools.json.JSONObject;

import retrofit2.Call;

public class Main {

    private static String URL = "http://47.75.150.232:8080/";

    private static String order_url = "/app/trade/order";

    static final String API_KEY = "2c9e6ce6-9999b552-c1e4cb84-13375";
    static final String API_SECRET = "b422af08-6aee71f3-0edeb441-1ad66";

    public static void main(String[] args) {
        try {
            apiSample();
        } catch (ApiException e) {
            System.err.println("API Error! err-code: " + e.getErrCode() + ", err-msg: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void apiSample() {


        OrderService service = new OrderService();
        service.order();
        // create ApiClient using your api key and api secret:
//        ApiClient client = new ApiClient(API_KEY, API_SECRET);
//        // get symbol list:
////        print(client.getSymbols());
//
//        //获取 K 线
//        //------------------------------------------------------ kline -------------------------------------------------------
//        KlineResponse kline = client.kline("btcusdt", "1min", "1");
//
//        try {
//            JSONArray jsonArr = JSON.parseArray(JsonUtil.writeValue(kline.data));
//
//
//
//            System.out.println(((Map)jsonArr.get(0)).get("close"));
//
//
//
//
////            Map<String,Object> map = JSON.parseObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        print(kline.data);
//
//        BigoSerivce remoteService = APIServiceGenrator.createRemoteService(URL,
//                BigoSerivce.class,"89x188YvA2CaWDC99w84");
//
//
//        Map<String,Object> params=new HashMap<>();
//        params.put("coinId", 0);
//        params.put("tradeCoinId", 1);
//        params.put("price", 10.45);
//        params.put("num", 10);
//        params.put("type",1);
//
//        Call<ResultDTO> call= remoteService.order(order_url,params);
//
//        try {
//            ResultDTO resultDTO = call.execute().body();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    static void print(Object obj) {
        try {
            System.out.println(JsonUtil.writeValue(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
