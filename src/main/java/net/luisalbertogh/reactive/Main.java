/**
 * Main class.
 */
package net.luisalbertogh.reactive;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * @author loga
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /* Simple reactive */
        System.out.println("Simple reactive");
        SimpleReactive sr = new SimpleReactive();
        sr.run();
        
        System.out.println("");
        
        /* More reactive */
        System.out.println("More reactive");
        MoreReactive mr = new MoreReactive();
        mr.run();
    }
}

/**
 * Simple RxJava example.
 * @author loga
 *
 */
class SimpleReactive {
    public void run(){
        /* Observable on string collection */
        Observable<String> obs = Observable.fromArray("foo","bar","foobar");
        
        /* Simple suscriber with lambda expression */
        obs.subscribe(s -> System.out.println(s));
    }
}

/**
 * Other reactive example.
 * @author loga
 *
 */
class MoreReactive {
    @SuppressWarnings("unused")
    public void run(){
        /* Observable on string collection */
        Observable<String> obs = Observable.create(emitter -> {
            try {
                List<String> strings = getStrings();
                for (String s : strings) {
                    emitter.onNext(s);
                }
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
        
        /* Suscriber */
        DisposableObserver<String> disobs = obs.subscribeWith(new DisposableObserver<String>(){

            @Override
            public void onComplete() {
                System.out.println("Finished!");
            }

            @Override
            public void onError(Throwable arg0) {
                System.err.println(arg0.getMessage());
            }

            @Override
            public void onNext(String arg0) {
                System.out.println(arg0);
            }
            
        });
    }
    
    /**
     * Get strings.
     * @return
     */
    protected List<String> getStrings() {
        return Arrays.asList("one","two","three");
    }
}
