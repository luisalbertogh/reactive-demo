/**
 * Simple reactive.
 */
package net.luisalbertogh.reactive.examples;

import io.reactivex.Observable;

/**
 * @author loga
 *
 */
public class SimpleReactive {
    public void run() {
        /* Observable on string collection */
        Observable<String> obs = Observable.fromArray("foo","bar","foobar");

        /* Simple suscriber with lambda expression */
        obs.subscribe(s -> System.out.println(s));
    }
}
