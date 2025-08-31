package com.rmalvadkar.pocworks.globalaopmethodlogger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("app")
public record AppCpnfigProperties(String message) {

}
