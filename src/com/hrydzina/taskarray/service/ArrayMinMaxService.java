package com.hrydzina.taskarray.service;

import com.hrydzina.taskarray.entity.NumberArray;
import com.hrydzina.taskarray.service.impl.ArrayMinMaxServiceInterface;

import java.util.OptionalInt;

public class ArrayMinMaxService
        implements ArrayMinMaxServiceInterface {

  @Override
  public OptionalInt findMin(NumberArray numberArray) {
    if (numberArray == null) {
      return OptionalInt.empty();
    }
    int[] values = numberArray.getValues();

    if (values.length == 0) {
      return OptionalInt.empty();
    }
    int min = values[0];

    for (int value : values) {
      if (value < min) {
        min = value;
      }
    }
    return OptionalInt.of(min);
  }
  @Override
  public OptionalInt findMax(NumberArray numberArray) {
    if (numberArray == null) {
      return OptionalInt.empty();
    }
    int[] values = numberArray.getValues();

    if (values.length == 0) {
      return OptionalInt.empty();
    }
    int max = values[0];
    for (int value : values) {
      if (value > max) {
        max = value;
      }
    }
    return OptionalInt.of(max);
  }
}
