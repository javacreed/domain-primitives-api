package com.javacreed.api.domain.primitives.mandatory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.concurrent.Immutable;

import com.google.common.base.Preconditions;

@Immutable
public class LocalDateTimeBasedDomainPrimitive extends ObjectBasedDomainPrimitive<LocalDateTime>
    implements Comparable<LocalDateTimeBasedDomainPrimitive> {

  private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  protected LocalDateTimeBasedDomainPrimitive(final LocalDateTime value) throws NullPointerException {
    super(value);
  }

  @Override
  public int compareTo(final LocalDateTimeBasedDomainPrimitive other) {
    return compareTo(other, LocalDateTime::compareTo);
  }

  public String format() {
    return format(LocalDateTimeBasedDomainPrimitive.DEFAULT_FORMATTER);
  }

  public String format(final DateTimeFormatter formatter) throws NullPointerException {
    Preconditions.checkNotNull(formatter);
    return map(formatter::format);
  }

  /**
   *
   * @param pattern
   * @return
   * @throws NullPointerException
   * @throws IllegalArgumentException
   *           if the pattern is invalid
   */
  public String format(final String pattern) throws NullPointerException, IllegalArgumentException {
    Preconditions.checkNotNull(pattern);
    return format(DateTimeFormatter.ofPattern(pattern));
  }

  public Timestamp toSqlTimestamp() {
    return map(Timestamp::valueOf);
  }

  public ZonedDateTime toZone(final ZoneId zoneId) throws NullPointerException {
    return ZonedDateTime.of(value, zoneId);
  }
}
