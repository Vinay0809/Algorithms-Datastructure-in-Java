package edu.uncc.ad.queue;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author venky
 */
public class PalindromeTest {

    @Test
    public void isPalindrome() {
        Assert.assertEquals (true,Palindrome.isPalindrome ("abccba"));
        Assert.assertEquals (true,Palindrome.isPalindrome ("Was it a car or a cat I saw?"));
        Assert.assertEquals (true,Palindrome.isPalindrome ("I did, did I?"));
        Assert.assertEquals (false,Palindrome.isPalindrome ("hello"));
        Assert.assertEquals (true,Palindrome.isPalindrome ("Don't nod"));
    }
}