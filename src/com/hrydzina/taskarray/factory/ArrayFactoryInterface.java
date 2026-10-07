package com.hrydzina.taskarray.factory;

import com.hrydzina.taskarray.entity.NumberArray;

public interface ArrayFactoryInterface {

    NumberArray createArray(int[] values);
}
