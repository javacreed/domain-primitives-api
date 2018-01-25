package com.javacreed.api.domain.primitives.optional;

import java.util.Optional;

import javax.annotation.concurrent.Immutable;

@Immutable
public class NumberBasedDomainObject<T extends Number & Comparable<T>> extends ComparableBasedDomainObject<T> {

  protected NumberBasedDomainObject(final Optional<T> value) throws NullPointerException {
    super(value);
  }

  public String orBlank() {
    return map(String::valueOf).orElse("");
  }
}