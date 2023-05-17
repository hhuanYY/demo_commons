package com.utils.反应式编程;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/5
 */
public class MonoDemo {


    public static Mono<ReactorDemo> monoMethod() {
        return Mono.just(new ReactorDemo(100, "mono"));
    }

    public static void main(String[] args) {
//        Mono<ReactorDemo> reactorDemoMono = monoMethod();
//        System.out.println(reactorDemoMono.map(ReactorDemo::getUsername).block());


        Flux<Integer> range = Flux
                .range(1, 5);
        range.subscribe(System.out::println);


    }


}
