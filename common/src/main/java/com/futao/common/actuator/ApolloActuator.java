package com.futao.common.actuator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author futao
 * @date 2020/1/3.
 */
@Component
public class ApolloActuator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        RestTemplate restTemplate = new RestTemplate();
        String property = System.getProperty("apollo.meta");
        if (StringUtils.isNotEmpty(property)) {
            ResponseEntity<String> entity = restTemplate.getForEntity(property, String.class);
            if (HttpStatus.OK.equals(entity.getStatusCode())) {
                builder.up().withDetail("meta", property).build();
            } else {
                builder.down().withDetail("reason", "无法连接到apollo meta, code:" + entity.getStatusCode()).build();
            }
        } else {
            builder.down().withDetail("reason", "apollo meta未配置").build();
        }
    }
}
