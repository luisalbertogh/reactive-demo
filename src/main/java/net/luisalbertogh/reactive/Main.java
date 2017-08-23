/**
 * Main class.
 */
package net.luisalbertogh.reactive;

import net.luisalbertogh.reactive.examples.MoreReactive;
import net.luisalbertogh.reactive.examples.SimpleReactive;
import net.luisalbertogh.reactive.examples.SingleReactive;

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
        mr.disposeObserver();
        
        System.out.println("");
        
        /* Single reactive */
        System.out.println("Single reactive");
        SingleReactive slr = new SingleReactive();
        slr.run();
        slr.disposeObserver();
    }
}
