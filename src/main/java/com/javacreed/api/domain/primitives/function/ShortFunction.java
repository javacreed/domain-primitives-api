package com.javacreed.api.domain.primitives.function;

import java.util.function.Function;

/**
 * Represents a function that accepts a short-valued argument and produces a result. This is the {@code short}-consuming
 * primitive specialization for {@link Function}.
 *
 * @param <R>
 *          the type of the result of the function
 *
 * @see Function
 */
@FunctionalInterface
public interface ShortFunction<R> {

  /**
   * Applies this function to the given argument.
   *
   * @param value
   *          the function argument
   * @return the function result
   */
  R apply(short value);
}