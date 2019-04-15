package edu.uncc.ad.search;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author venky
 */
public class BinarySearchTest {

    @Test
    public void binarySearch() {
        Assert.assertEquals (3,BinarySearch.binarySearch (new int[]{2,6,8,10,12,14,16,18}, 10));
        Assert.assertEquals (-1,BinarySearch.binarySearch (new int[]{}, 10));
        Assert.assertEquals (-1,BinarySearch.binarySearch (null, 10));
        Assert.assertEquals (4,BinarySearch.binarySearch (new int[]{15, 21, 81,90,98,112,134}, 98));
    }

    @Test
    public void recursiveBinarySearch() {
        Assert.assertEquals (3,BinarySearch.recursiveBinarySearch (new int[]{2,6,8,10,12,14,16,18}, 10));
        Assert.assertEquals (-1,BinarySearch.recursiveBinarySearch (new int[]{}, 10));
        Assert.assertEquals (-1,BinarySearch.recursiveBinarySearch (null, 10));
        Assert.assertEquals (4,BinarySearch.recursiveBinarySearch (new int[]{15, 21, 81,90,98,112,134}, 98));
    }
}