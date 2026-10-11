package com.hrydzina.taskarray.reader.impl;

import com.hrydzina.taskarray.exception.InvalidArrayDataException;

import java.util.List;

public interface ArrayReader {

  List<String> read(String filePath) throws InvalidArrayDataException;
}