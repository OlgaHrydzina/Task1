package com.hrydzina.taskarray.service;
import com.hrydzina.taskarray.entity.NumberArray;
import com.hrydzina.taskarray.service.impl.ArraySumServiceInterface;

import java.util.OptionalLong;

public class ArraySumService
        implements ArraySumServiceInterface {

  @Override
  public OptionalLong calculateSum(NumberArray numberArray) {
    if (numberArray == null) {
      return OptionalLong.empty();
    }
    int[] values = numberArray.getValues();
    if (values.length == 0) {
      return OptionalLong.empty();
    }
    long sum = 0;

    for (int value : values) {
      sum += value;
    }
    return OptionalLong.of(sum);
  }
}
