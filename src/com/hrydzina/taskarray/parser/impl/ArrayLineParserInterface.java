package com.hrydzina.taskarray.parser.impl;
import com.hrydzina.taskarray.exception.InvalidArrayDataException;

public interface ArrayLineParserInterface {

  int[] parse(String source) throws InvalidArrayDataException;
}
