package com.bg.robot.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bg.robot.huobi.api.ApiClient;
import com.bg.robot.huobi.response.KlineResponse;
import com.bg.robot.rest.dto.ResultDTO;
import com.bg.robot.rest.dto.TickerDTO;
import com.bg.robot.service.generator.APIServiceGenrator;
import com.bg.robot.service.service.bigo.BigoSerivce;
import com.bg.robot.service.service.bigo.ZBTickerSerivce;
import com.bg.robot.util.JsonUtil;

import org.springframework.stereotype.Service;

import retrofit2.Call;

/**
 * Created by wangpeng on 2018/6/1.
 */

@Service
public class OrderService {


    private static String URL = "http://47.75.150.232:8080/";

    private static String order_url = "/bigo/app/trade/order";


    private static String ZBURL = "http://api.zb.com/";

    private static String ZBTICJKER = "/data/v1/ticker/";


    private static final String API_KEY = "2c9e6ce6-9999b552-c1e4cb84-13375";
    private static final String API_SECRET = "b422af08-6aee71f3-0edeb441-1ad66";

    /**
     *
     */
    public void order() {

        BigoSerivce remoteService = APIServiceGenrator.createRemoteService(URL,
                BigoSerivce.class,"89x188YvA2CaWDC99w84");

        order_bg_btc(remoteService);
        order_bg_eth(remoteService);

        order_bg_ltc(remoteService);
        order_bg_btm(remoteService);

        order_bg_eos(remoteService);

        order_bg_1st(remoteService);

        order_bg_bat(remoteService);
        order_bg_omg(remoteService);

    }

    private void order_bg_btc(BigoSerivce bigoSerivce){

        /**
         * 获取btc_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","btc_qc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,0,1,price,new BigDecimal("0.02"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,0,1,price,new BigDecimal("0.01"),1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                BigDecimal price2 = BigDecimal.ONE.divide(price).setScale(8,RoundingMode.DOWN);
//                order(bigoSerivce,1,0,price2,new BigDecimal("2"),0);
//                try {
//                    Thread.sleep(1000);
//                    order(bigoSerivce,1,0,price2,new BigDecimal("1"),1);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void order_bg_eth(BigoSerivce bigoSerivce){
        /**
         * 获取eth_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","eth_qc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,0,2,price,new BigDecimal("0.02"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,0,2,price,new BigDecimal("0.01"),1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


//                BigDecimal price2 = BigDecimal.ONE.divide(price).setScale(8,RoundingMode.DOWN);
//                order(bigoSerivce,2,0,price2,new BigDecimal("2"),0);
//                try {
//                    Thread.sleep(1000);
//                    order(bigoSerivce,2,0,price2,new BigDecimal("1"),1);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void order_bg_ltc(BigoSerivce bigoSerivce){
        /**
         * 获取eth_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","ltc_qc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,0,3,price,new BigDecimal("0.02"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,0,3,price,new BigDecimal("0.01"),1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void order_bg_btm(BigoSerivce bigoSerivce){
        /**
         * 获取btm_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","btm_qc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,0,5,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,0,5,price,new BigDecimal("1"),1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void order_bg_eos(BigoSerivce bigoSerivce){
        /**
         * 获取btm_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","eos_qc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,0,6,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,0,6,price,new BigDecimal("1"),1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void order_bg_1st(BigoSerivce bigoSerivce){
        /**
         * 获取btm_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","1st_qc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,0,7,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,0,7,price,new BigDecimal("1"),1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void order_bg_bat(BigoSerivce bigoSerivce){
        /**
         * 获取btm_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","bat_qc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,0,8,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,0,8,price,new BigDecimal("1"),1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void order_bg_omg(BigoSerivce bigoSerivce){
        /**
         * 获取btm_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","omg_qc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,0,9,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,0,9,price,new BigDecimal("1"),1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private void order(BigoSerivce bigoSerivce,Integer coinId,Integer tradeCoinId,BigDecimal price,BigDecimal num,Integer type){

        Map<String,Object> params=new HashMap<>();
        params.put("coinId", coinId);
        params.put("tradeCoinId", tradeCoinId);
        params.put("price", price);
        params.put("num", num);
        params.put("type",type);

        ResultDTO resultDTO = null;

        Call<ResultDTO> call= bigoSerivce.order(order_url,params);

        try {
            resultDTO = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(resultDTO.getMessage());


    }




}
