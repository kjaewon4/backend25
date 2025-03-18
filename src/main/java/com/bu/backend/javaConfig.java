package com.bu.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 자바 코드에서 직접 빈(Bean)을 등록하고 관리할 수 있음
 * 즉, XML 파일에서 <bean> 태그로 설정을 작성하던 것을 자바 클래스의 메서드와 어노테이션으로 대체
 *
 * @Configuration
 * public class AppConfig {
 *     @Bean
 *     public Car car() {
 *         return new Car("myCar");
 *     }
 * }
 * 이렇게 작성하면 XML에서 <bean id="car" class="Car" ...>로 설정하던 것과 동일한 효과
 * */

@ComponentScan("com.bu.backend")
@Configuration
@Import({WheelConfig.class})
public class javaConfig {

    @Bean
    public Car car(CarFrame frame) {
        Car car = new Car();
        car.setFrame(frame);

        return car;
    }

    @Bean
    public CarFrame frame(Wheel hdWheel){
        CarFrame frame = new CarFrame();
        frame.setWheel(hdWheel);

        return frame;
    }

//    @Bean
//    public Wheel hdWheel(){
//        HDWheel wheel = new HDWheel();
//        wheel.setPrice(5000);
//
//        return wheel;
//    }
//
//    @Bean
//    public Wheel adwheel(){
//        ADWheel wheel = new ADWheel();
//        wheel.setPrice(6000);
//        return new ADWheel();
//    }

}
