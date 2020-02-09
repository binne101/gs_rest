package nl.pdptst.hateoas.mutationtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {

    @DisplayName("old junit version")
    @Test
    public void whenPalindrom_thenAccept() {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome("noon"));
    }

    //negated conditional
    @DisplayName("Single test unsuccessful")
    @Test
    public void whenNearPalindrom_thanReject() {
        Palindrome palindromeTester = new Palindrome();
        assertFalse(palindromeTester.isPalindrome("neon"));
    }

    @DisplayName("junit 5, parameterized test")
    @ParameterizedTest(name = "{index} => input=''{0}''")
    @ValueSource(strings = {"aa", "naan", ""})
    void multiple_palindromes(String input) {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome(input));
    }

    @DisplayName("junit 5, parameterized test unsuccesful")
    @ParameterizedTest
    @ValueSource(strings = {"neon","a", "tst"})
    void multiple_non_palindromes(String input){
        Palindrome palindromeTester = new Palindrome();
        assertFalse(palindromeTester.isPalindrome(input));
    }

    @DisplayName("junit 5, multiple input parameters, sample from https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/")
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5"
    })
    public void sum(int a, int b, int sum){
        assertEquals(sum, a + b);
    }

    @DisplayName("multiple parameters of a different type")
    @ParameterizedTest
    @MethodSource("tstFactory")
    public void tstFac(int a, int b, int sum, String tst){
        Junit5Test junit5Test = new Junit5Test();
        if (junit5Test.isSum(a,b,sum)){
            assertTrue("naan".equals(tst));
        } else {
            assertTrue("neon".equals(tst));
        }

    }

    private static Stream<Arguments> tstFactory(){
        return Stream.of(
                Arguments.of(1,1,2,"naan"),
                Arguments.of(2,3,7,"neon"));
    }
}