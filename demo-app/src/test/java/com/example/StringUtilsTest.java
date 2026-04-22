package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("StringUtils Tests")
class StringUtilsTest {

    private StringUtils utils;

    @BeforeEach
    void setUp() {
        utils = new StringUtils();
    }

    @Nested
    @DisplayName("reverse()")
    class ReverseTests {

        @Test
        void reversesNormalString() {
            assertThat(utils.reverse("hello")).isEqualTo("olleh");
        }

        @Test
        void returnsNullForNullInput() {
            assertThat(utils.reverse(null)).isNull();
        }

        @Test
        void handlesEmptyString() {
            assertThat(utils.reverse("")).isEmpty();
        }
    }

    @Nested
    @DisplayName("wordCount()")
    class WordCountTests {

        @Test
        void countsWords() {
            assertThat(utils.wordCount("hello world foo")).isEqualTo(3);
        }

        @Test
        void returnsZeroForBlank() {
            assertThat(utils.wordCount("   ")).isEqualTo(0);
        }

        @Test
        void returnsZeroForNull() {
            assertThat(utils.wordCount(null)).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("isPalindrome()")
    class PalindromeTests {

        @ParameterizedTest(name = "\"{0}\" is a palindrome")
        @ValueSource(strings = {"racecar", "A man a plan a canal Panama", "Was it a car or a cat I saw"})
        void detectsPalindromes(String input) {
            assertThat(utils.isPalindrome(input)).isTrue();
        }

        @ParameterizedTest(name = "\"{0}\" is NOT a palindrome")
        @ValueSource(strings = {"hello", "world", "java"})
        void detectsNonPalindromes(String input) {
            assertThat(utils.isPalindrome(input)).isFalse();
        }

        @Test
        void returnsFalseForNull() {
            assertThat(utils.isPalindrome(null)).isFalse();
        }
    }
}
