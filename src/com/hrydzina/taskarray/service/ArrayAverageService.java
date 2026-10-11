package com.hrydzina.taskarray.service;

import com.hrydzina.taskarray.entity.NumberArray;
import com.hrydzina.taskarray.service.impl.ArrayAverageServiceInterface;
import com.hrydzina.taskarray.service.impl.ArraySumServiceInterface;

import java.util.OptionalDouble;
import java.util.OptionalLong;

public class ArrayAverageService
        implements ArrayAverageServiceInterface {

  private final ArraySumServiceInterface sumService;

  public ArrayAverageService(
          ArraySumServiceInterface sumService) {
    this.sumService = sumService;
  }
  @Override
  public OptionalDouble calculateAverage(NumberArray numberArray) {
    if (numberArray == null || numberArray.getLength() == 0) {
      return OptionalDouble.empty();
    }
    OptionalLong sum = sumService.calculateSum(numberArray);
    if (!sum.isPresent()) {
      return OptionalDouble.empty();
    }
    double average = (double) sum.getAsLong()
            / numberArray.getLength();
    return OptionalDouble.of(average);
  }
}
