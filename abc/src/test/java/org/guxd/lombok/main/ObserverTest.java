package org.guxd.lombok.main;

import org.guxd.lombok.vo.StudentVO;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by hyunji on 2016. 7. 12..
 */
public class ObserverTest {

    @Test
    public void justTest(){

        System.out.println("create test");
        StudentVO student = new StudentVO();
        student.setName("최현묵");
        Observable<StudentVO> observable = Observable.just(student);
                //Observable.just("개미");
        System.out.println("observable start");

        observable.subscribe(new Subscriber<StudentVO>() {
            @Override
            public void onNext(StudentVO s) {

                System.out.println("on Next : " + s.getName() );
            }

            @Override
            public void onCompleted() {

                System.out.println("onCompleted");

            }

            @Override
            public void onError(Throwable e) {

                System.out.println("error : " + e.getMessage());

            }

        });
    }

    @Test
    public void deferTest(){
        System.out.println("start Defer");
        System.out.println(Thread.currentThread().getName() + "create Observable");
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            // 멀티 스레딩 , 동시성 , closure
            @Override
            public Observable<String> call() {
                System.out.println(Thread.currentThread().getName() + "  :    defer function");
                return Observable.just("hello!jelly");
            }
        });
        System.out.println(Thread.currentThread().getName() + "  :  defer Function call");
        observable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onNext(String s) {

                        System.out.println(Thread.currentThread().getName() + "  :   onNext call" + s);

                    }

                    @Override
                    public void onCompleted() {

                        System.out.println(Thread.currentThread().getName() + "  :   onCompleted call");

                    }

                    @Override
                    public void onError(Throwable e) {

                        System.out.println(Thread.currentThread().getName() + "  :   error call" + e.getMessage());

                    }

                });

    }

    @Test
    public void deferTest2 (){
        System.out.println(Thread.currentThread().getName() + "  :1  defer Test 2 ");
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                System.out.println(Thread.currentThread().getName() + "  :2   defer Observer");
                return Observable.just("deferTest2");
            }
        });
        System.out.println(Thread.currentThread().getName() + "  :3  do Subcribe !!!");

        Observable<String> observable2 = observable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        System.out.println(Thread.currentThread().getName() + "  :4  map");
                        return "( " + s + " )";
                    }
                });

        observable2
                .observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onNext(String s) {

                        System.out.println(Thread.currentThread().getName() + "   :5  " + s);
                    }

                    @Override
                    public void onCompleted() {

                        System.out.println(Thread.currentThread().getName() + "    :6  " + "onCompleted");

                    }

                    @Override
                    public void onError(Throwable e) {

                        System.out.println(Thread.currentThread().getName() + "    :7  " + "onError");

                    }

                });
    }
}