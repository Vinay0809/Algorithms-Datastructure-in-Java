package edu.uncc.ad.problems.string;

/**
 * @author venky on 2019-03-03
 * @project AlgorithmAndDataStructure
 * @package edu.uncc.ad.string
 */

/**
 * Testing String for immutability.
 */
public class ImmutableTest {

    public static void main(String[] args) {
        String str = "Hello world";
        //str[5] = ",";  // compilation error here shows we can't modify a string.
        System.out.println (str);
    }
}
