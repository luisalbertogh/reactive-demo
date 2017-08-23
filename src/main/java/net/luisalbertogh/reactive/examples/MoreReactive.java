/**
 * 
 */
package net.luisalbertogh.reactive.examples;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * @author loga
 *
 */
public class MoreReactive {
    /* Observer */
    private DisposableObserver<String> disobs;
    
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
        
        /* Observer */
        disobs = obs.subscribeWith(new DisposableObserver<String>(){

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
     * Dispose observer.
     */
    public void disposeObserver() {
        disobs.dispose();
    }
    
    /**
     * Get strings.
     * @return
     */
    protected List<String> getStrings() {
        return Arrays.asList("one","two","three");
    }
}
