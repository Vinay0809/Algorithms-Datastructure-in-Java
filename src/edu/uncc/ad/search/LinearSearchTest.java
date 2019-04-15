package edu.uncc.ad.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author venky
 */
public class LinearSearchTest {

    @Test
    public void linearSearch() {
        Assert.assertEquals (3,LinearSearch.linearSearch (new int[]{2,5,1,10,15,8}, 10));
        Assert.assertEquals (-1,LinearSearch.linearSearch (new int[]{}, 10));
        Assert.assertEquals (-1,LinearSearch.linearSearch (null, 10));
        Assert.assertEquals (8,LinearSearch.linearSearch (new int[]{2,5,1,10,15,8,19,14,151,76}, 151));
    }
}