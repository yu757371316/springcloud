package com.example.register.practice;

import rx.Observable;
import rx.Subscriber;

/**
 * @author :  20160301301
 * @date : 2018/9/26 16:20
 */
public class SubAndPub {

    public static void main(String[] args) {
        Observable<String> observable = Observable.create(subscriber -> {
            subscriber.onNext("Hello RxJava");
            subscriber.onNext("I am tes");
            subscriber.onCompleted();
        });

        Subscriber<String> stringSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNexts :" + s);
            }
        };

        observable.subscribe(stringSubscriber);
    }
}
