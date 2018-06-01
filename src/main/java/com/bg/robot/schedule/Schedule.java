package com.bg.robot.schedule;


import javax.inject.Inject;

import com.bg.robot.service.BTCOrderService;
import com.bg.robot.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *  定时任务
 */
@Service
public class Schedule {

    public static final Logger LOGGER = LoggerFactory.getLogger(Schedule.class);


    public final static long ONE_Minute =  1 * 60 * 1000;


    @Inject
    private OrderService orderService;


    @Inject
    private BTCOrderService orderService2;

    @Transactional
    @Scheduled(fixedDelay= ONE_Minute)
    public void order() {
        LOGGER.info("机器人-----{}-----start",System.currentTimeMillis());
        orderService.order();
        LOGGER.info("机器人-----{}-----end",System.currentTimeMillis());

    }


    @Transactional
    @Scheduled(fixedDelay= ONE_Minute)
    public void order2() {
        LOGGER.info("机器人-----{}-----start",System.currentTimeMillis());
        orderService2.order();
        LOGGER.info("机器人-----{}-----end",System.currentTimeMillis());

    }


}
