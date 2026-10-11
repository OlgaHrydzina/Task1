package com.hrydzina.taskarray.service.impl;
import com.hrydzina.taskarray.entity.NumberArray;
import java.util.OptionalDouble;

public interface ArrayAverageServiceInterface {

  OptionalDouble calculateAverage(NumberArray numberArray);
}
