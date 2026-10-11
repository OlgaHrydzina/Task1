package com.hrydzina.taskarray.service.impl;
import com.hrydzina.taskarray.entity.NumberArray;

import java.util.OptionalInt;

public interface ArrayMinMaxServiceInterface {
  OptionalInt findMin(NumberArray numberArray);
  OptionalInt findMax(NumberArray numberArray);
}
