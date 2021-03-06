package com.bg.robot.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.bg.robot.rest.dto.ResultDTO;
import com.bg.robot.rest.dto.TickerDTO;
import com.bg.robot.service.generator.APIServiceGenrator;
import com.bg.robot.service.service.bigo.BigoSerivce;
import com.bg.robot.service.service.bigo.ZBTickerSerivce;

import org.springframework.stereotype.Service;

import retrofit2.Call;

/**
 * Created by wangpeng on 2018/6/1.
 */

@Service
public class BTCOrderService {


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

        order_btc_eth(remoteService);

        order_btc_ltc(remoteService);
        order_btc_btm(remoteService);

        order_btc_eos(remoteService);

        order_btc_1st(remoteService);

        order_btc_bat(remoteService);
        order_btc_omg(remoteService);
//        order_bg_eth();
//
//
//
//        ApiClient client = new ApiClient(API_KEY, API_SECRET);
//
//        KlineResponse kline = client.kline("eosbtc", "1min", "1");
//
//        JSONArray jsonArr = null;
//        try {
//            jsonArr = JSON.parseArray(JsonUtil.writeValue(kline.data));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String close =  ((Map)jsonArr.get(0)).get("close").toString();
//        BigDecimal price = new BigDecimal(close);
//
//        BigoSerivce remoteService = APIServiceGenrator.createRemoteService(URL,
//                BigoSerivce.class,"89x188YvA2CaWDC99w84");
//
//
//        BigDecimal d = BigDecimal.ONE.divide(new BigDecimal(close));
//        System.out.print(d);
//
//        /**
//         * 下买单
//         */
//        Map<String,Object> params=new HashMap<>();
//        params.put("coinId", 1);
//        params.put("tradeCoinId", 6);
//        params.put("price", price);
//        params.put("num", 2);
//        params.put("type",0);
//
//        ResultDTO resultDTO = null;
//
//        Call<ResultDTO> call= remoteService.order(order_url,params);
//
//        try {
//            resultDTO = call.execute().body();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(resultDTO.getMessage());
//
//        try {
//            Thread.sleep(1000);
//
//            /**
//             * 下卖单
//             */
//            Map<String,Object> params2=new HashMap<>();
//            params2.put("coinId", 1);
//            params2.put("tradeCoinId", 6);
//            params2.put("price", price);
//            params2.put("num", 4);
//            params2.put("type",1);
//
//            ResultDTO resultDTO2 = null;
//
//            Call<ResultDTO> call2= remoteService.order(order_url,params2);
//
//            try {
//                resultDTO2 = call2.execute().body();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(resultDTO2.getMessage());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



    }


    private void order_btc_eth(BigoSerivce bigoSerivce){
        /**
         * 获取eth_qc 市场
         */



        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","eth_btc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,1,2,price,new BigDecimal("0.02"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,1,2,price,new BigDecimal("0.01"),1);

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


    private void order_btc_ltc(BigoSerivce bigoSerivce){
        /**
         * 获取eth_qc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","ltc_btc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,1,3,price,new BigDecimal("0.02"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,1,3,price,new BigDecimal("0.01"),1);

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


    private void order_btc_btm(BigoSerivce bigoSerivce){
        /**
         * 获取btm_btc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","btm_btc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,1,5,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,1,5,price,new BigDecimal("1"),1);

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


    private void order_btc_eos(BigoSerivce bigoSerivce){
        /**
         * 获取btm_btc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","eos_btc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,1,6,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,1,6,price,new BigDecimal("1"),1);

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


    private void order_btc_1st(BigoSerivce bigoSerivce){
        /**
         * 获取btm_btc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","1st_btc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,1,7,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,1,7,price,new BigDecimal("1"),1);

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

    private void order_btc_bat(BigoSerivce bigoSerivce){
        /**
         * 获取btm_btc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","bat_btc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,1,8,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,1,8,price,new BigDecimal("1"),1);

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


    private void order_btc_omg(BigoSerivce bigoSerivce){
        /**
         * 获取btm_btc 市场
         */
        ZBTickerSerivce remoteService = APIServiceGenrator.createRemoteService(ZBURL,
                ZBTickerSerivce.class);
        Map<String,Object> params=new HashMap<>();
        params.put("market","omg_btc");
        Call<TickerDTO> call = remoteService.getTicker(ZBTICJKER,params);

        TickerDTO dto = null;
        try {
            dto = call.execute().body();

            BigDecimal price  = new BigDecimal(dto.getTicker().getLast());

            if(price.compareTo(BigDecimal.ZERO)>0){
                /**
                 * 下买单和卖单
                 */
                order(bigoSerivce,1,9,price,new BigDecimal("2"),0);
                try {
                    Thread.sleep(1000);
                    order(bigoSerivce,1,9,price,new BigDecimal("1"),1);

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

    public static void main(String[] args){

        BTCOrderService service  = new BTCOrderService();
        service.order();
    }




}
