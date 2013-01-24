package com.springapp.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SampleWriter implements ItemWriter<SampleItem> {
    private static Logger log = LoggerFactory.getLogger(SampleWriter.class);

    @Override
    public void write(List<? extends SampleItem> items) throws Exception {
        log.info("Write items: " + items.size());
        for (SampleItem item : items) {
            log.info(item.getName());
        }
    }
}
