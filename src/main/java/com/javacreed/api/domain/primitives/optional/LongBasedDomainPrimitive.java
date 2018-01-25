package com.javacreed.api.domain.primitives.optional;

import java.util.Optional;

import javax.annotation.concurrent.Immutable;

@Immutable
public class LongBasedDomainObject extends NumberBasedDomainObject<Long> {

  protected LongBasedDomainObject(final Optional<Long> value) {
    super(value);
  }
}