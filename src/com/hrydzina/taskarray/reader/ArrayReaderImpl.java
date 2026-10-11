package com.hrydzina.taskarray.reader;

import com.hrydzina.taskarray.exception.InvalidArrayDataException;
import com.hrydzina.taskarray.reader.impl.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {

  private static final Logger LOGGER = LogManager.getLogger(ArrayReaderImpl.class);

  @Override
  public List<String> read(String filePath) throws InvalidArrayDataException {
    if (filePath == null) {
      throw new InvalidArrayDataException("File path must not be null");
    }
    if (filePath.isBlank()) {
      throw new InvalidArrayDataException("File path must not be blank");
    }

    Path path = Paths.get(filePath);

    try {
      List<String> lines = Files.readAllLines(path);
      LOGGER.info("File read successfully: {}", filePath);
      return lines;
    } catch (IOException exception) {
      LOGGER.error("Failed to read file: {}", filePath, exception);
      throw new InvalidArrayDataException(
              "Cannot read file: " + filePath, exception);
    }
  }
}
