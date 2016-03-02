package com.dstvdm.bamf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class BamfApplication {

    public static void main(String... args) {
        new SpringApplicationBuilder()
                .sources(BamfApplication.class)
                // .showBanner(false)
                .run(args);
    }

}