package com.bu.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WheelConfig {


    @Bean
    public Wheel hdWheel(){
        HDWheel wheel = new HDWheel();
        wheel.setPrice(5000);

        return wheel;
    }

    @Bean
    public Wheel adwheel(){
        ADWheel wheel = new ADWheel();
        wheel.setPrice(6000);

        return wheel;
    }
}
