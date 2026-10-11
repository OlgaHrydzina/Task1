package com.hrydzina.taskarray.service;
import com.hrydzina.taskarray.entity.NumberArray;
import com.hrydzina.taskarray.service.impl.ArraySortServiceInterface;

public class ArraySortService
        implements ArraySortServiceInterface {

  @Override
  public NumberArray sortByBubble(NumberArray numberArray) {
    if (numberArray == null) {
      return new NumberArray(new int[0]);
    }
    int[] values = numberArray.getValues();
    for (int i = 0; i < values.length - 1; i++) {
      for (int j = 0; j < values.length - 1 - i; j++) {
        if (values[j] > values[j + 1]) {
          int temp = values[j];
          values[j] = values[j + 1];
          values[j + 1] = temp;
        }
      }
    }
    return new NumberArray(values);
  }
  @Override
  public NumberArray sortBySelection(NumberArray numberArray) {
    if (numberArray == null) {
      return new NumberArray(new int[0]);
    }
    int[] values = numberArray.getValues();

    for (int i = 0; i < values.length - 1; i++) {
      int minIndex = i;

      for (int j = i + 1; j < values.length; j++) {
        if (values[j] < values[minIndex]) {
          minIndex = j;
        }
      }
      int temp = values[i];
      values[i] = values[minIndex];
      values[minIndex] = temp;
    }
    return new NumberArray(values);
  }
}
