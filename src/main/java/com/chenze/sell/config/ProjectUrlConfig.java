package com.chenze.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by cz
 * Date： 2019/12/15 21:47
 */
@Data
@Component
@ConfigurationProperties(prefix = "ProjectUrlConfig")
public class ProjectUrlConfig {
    private String sell;

    private String wechatOpenAuthorize;
}
