package edu.uncc.ad.queue;

/**
 * @author venky
 */
public class Run {


}

class B extends Run{

}
class C extends B{

    public static void main(String[] args) {
        B b = new B ();
        System.out.println (b instanceof Run);
    }
}
