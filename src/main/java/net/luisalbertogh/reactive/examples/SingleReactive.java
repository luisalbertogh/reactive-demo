/**
 * 
 */
package net.luisalbertogh.reactive.examples;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * @author loga
 *
 */
public class SingleReactive {
    /* Observer */
    private DisposableSingleObserver<List<String>> disobs;
    
    @SuppressWarnings("unused")
    public void run(){
        /* Observable on string collection */
        Single<List<String>> obs = Single.create(emitter -> {
            try {
                emitter.onSuccess(getStrings());
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
        
        /* Observer */
        disobs = obs.subscribeWith(new DisposableSingleObserver<List<String>>(){

            @Override
            public void onError(Throwable arg0) {
                System.err.println(arg0.getMessage());
            }

            @Override
            public void onSuccess(List<String> arg0) {
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
