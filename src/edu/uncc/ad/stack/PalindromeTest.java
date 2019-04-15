package edu.uncc.ad.stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author venky
 */
public class PalindromeTest {

    @Test
    public void checkForPalindrome() {
        Assert.assertEquals (true,Palindrome.checkForPalindrome ("abccba"));
        Assert.assertEquals (true,Palindrome.checkForPalindrome ("Was it a car or a cat I saw?"));
        Assert.assertEquals (true,Palindrome.checkForPalindrome ("I did, did I?"));
        Assert.assertEquals (false,Palindrome.checkForPalindrome ("hello"));
        Assert.assertEquals (true,Palindrome.checkForPalindrome ("Don't nod"));

    }

}