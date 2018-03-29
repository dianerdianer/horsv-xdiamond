package com.horsv.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lzh
 * @description
 * @since 2018/3/25-上午11:49
 */
@Component
@Data
public class DemoConfigInstance {

    @Value(value = "${memcached.serverlist:}")
    private String memcachedAddress;

    @Value(value = "${zookeeper.address}")
    private String zookeeperAddress;

    @Value(value = "${database.url}")
    private String databaseUrl;

}
