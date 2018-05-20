package com.jd.batch.listener;

import com.jd.batch.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.jsr.RetryListener;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by majinxin1 on 2017/8/27.
 * 读取监听、重试监听 进行日志记录
 */
public class DBJobListener implements ItemReadListener<List<Order>>,SkipListener{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void afterRead(List<Order> orders) {
        if(CollectionUtils.isEmpty(orders)){
            logger.error("DBJobListener.afterRead orders is empty");
        }else {
            logger.info("DBJobListener.afterRead orders:[{}]",orders);
        }
    }


    @Override
    public void beforeRead() {
        logger.info("DBJobListener.beforeRead. ItemReader started.....");
    }

    @Override
    public void onReadError(Exception e) {
        logger.error("DBJobListener.onReadError exception:[{}]",e);
    }

    @Override
    public void onSkipInRead(Throwable throwable) {
        logger.error("DBJobListener.onSkipInRead [ItemReaderError.TtemSkiped] object:[{}],exception:[{}]",throwable);
    }

    @Override
    public void onSkipInWrite(Object o, Throwable throwable) {
        logger.error("DBJobListener.onSkipInWrite [ItemWriterError.TtemSkiped] object:[{}],exception:[{}]",o,throwable);
    }

    @Override
    public void onSkipInProcess(Object o, Throwable throwable) {

    }

}
