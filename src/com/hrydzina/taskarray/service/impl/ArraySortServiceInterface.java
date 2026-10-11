package com.hrydzina.taskarray.service.impl;

import com.hrydzina.taskarray.entity.NumberArray;
public interface ArraySortServiceInterface {

  NumberArray sortByBubble(NumberArray numberArray);

  NumberArray sortBySelection(NumberArray numberArray);
}
