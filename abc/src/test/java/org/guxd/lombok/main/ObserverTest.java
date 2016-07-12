package org.guxd.lombok.main;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;


/**
 * Created by hyunji on 2016. 7. 12..
 */
public class ObserverTest {

    @Test
    public void justTest(){

        System.out.println("create test");
        Observable<String> observable = Observable.just("개미");
        System.out.println("observable start");

        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        });
    }
}