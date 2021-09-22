package com.vvs.springreactivebackend.util;

import java.nio.channels.IllegalSelectorException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListUtils {
  
  public static <T> Collector<T, ?, T> toSingleton() {
    return Collectors.collectingAndThen(
      Collectors.toList(), 
      list -> {
        if (list.size() != 1) {
          throw new IllegalSelectorException();
        }
        return list.get(0);
      }
    );
  }
}
