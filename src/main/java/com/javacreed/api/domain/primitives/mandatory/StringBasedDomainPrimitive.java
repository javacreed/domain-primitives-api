package com.javacreed.api.domain.primitives.mandatory;

import java.util.Comparator;

import javax.annotation.concurrent.Immutable;

@Immutable
public class StringBasedDomainObject extends ComparableBasedDomainObject<String> {

  public static final Comparator<StringBasedDomainObject> CASE_INSENSITIVE = (a, b) -> a.compareToIgnoreCase(b);

  protected StringBasedDomainObject(final String value) throws NullPointerException {
    super(value);
  }

  public int compareToIgnoreCase(final StringBasedDomainObject other) {
    return compareTo(other, (a, b) -> a.compareToIgnoreCase(b));
  }

  public boolean equalsIgnoreCase(final StringBasedDomainObject other) {
    return value.equalsIgnoreCase(other.value);
  }
}