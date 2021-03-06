package com.javacreed.api.domain.primitives.utils;

import org.junit.Assert;
import org.junit.Test;

public class ComparatorUtilsTest {

  @Test
  public void should_safely_compare_null_values() {
    Assert.assertEquals(0, ComparatorUtils.compare(null, null, String.CASE_INSENSITIVE_ORDER));
    Assert.assertEquals(-1, ComparatorUtils.compare(null, "a", String.CASE_INSENSITIVE_ORDER));
    Assert.assertEquals(1, ComparatorUtils.compare("a", null, String.CASE_INSENSITIVE_ORDER));
  }

  @Test
  public void should_sort_values_using_the_given_comparator() {
    Assert.assertEquals(0, ComparatorUtils.compare("a", "A", String.CASE_INSENSITIVE_ORDER));
    Assert.assertEquals(0, ComparatorUtils.compare("A", "a", String.CASE_INSENSITIVE_ORDER));
    Assert.assertEquals(-1, ComparatorUtils.compare("a", "B", String.CASE_INSENSITIVE_ORDER));
    Assert.assertEquals(-1, ComparatorUtils.compare("A", "b", String.CASE_INSENSITIVE_ORDER));
    Assert.assertEquals(1, ComparatorUtils.compare("b", "A", String.CASE_INSENSITIVE_ORDER));
    Assert.assertEquals(1, ComparatorUtils.compare("B", "a", String.CASE_INSENSITIVE_ORDER));
  }

  @Test
  public void should_throw_an_NullPointerException_when_given_null_comparator() {
    Assert.assertThrows(NullPointerException.class, () -> ComparatorUtils.compare("a", "A", null));
  }
}
