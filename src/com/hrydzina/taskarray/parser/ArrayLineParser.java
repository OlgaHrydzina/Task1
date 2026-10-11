package com.hrydzina.taskarray.parser;

import com.hrydzina.taskarray.exception.InvalidArrayDataException;

import com.hrydzina.taskarray.parser.impl.ArrayLineParserInterface;
import com.hrydzina.taskarray.validator.impl.ArrayDataValidatorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayLineParserInterface {

  private static final Logger LOGGER =
          LogManager.getLogger(ArrayParserImpl.class);

  private final ArrayDataValidatorInterface validator;

  public ArrayParserImpl(ArrayDataValidatorInterface validator) {
    this.validator = validator;
    LOGGER.info("ArrayParserImpl created");
  }
  @Override
  public int[] parse(String line) throws InvalidArrayDataException {

    LOGGER.info("Starting parsing array data");

    if (line == null) {
      LOGGER.error("Cannot parse null line");
      throw new InvalidArrayDataException(
              "Cannot parse null line."
      );
    }
    if (!validator.isValid(line)) {
      LOGGER.error("Invalid array data: {}", line);
      throw new InvalidArrayDataException(
              "Invalid array data: " + line
      );
    }
    if (line.isBlank()) {
      LOGGER.warn("Array data is empty");
      return new int[0];
    }
    String[] stringParts = line.strip().split("[;,\\s-]+");
    int[] result = new int[stringParts.length];

    for (int i = 0; i < stringParts.length; i++) {
      try {
        result[i] = Integer.parseInt(stringParts[i]);
        LOGGER.debug("Parsed number: {}", result[i]);
      } catch (NumberFormatException e) {
        LOGGER.error(
                "Cannot parse integer from: {}",
                stringParts[i], e
        );
        throw new InvalidArrayDataException(
                "Cannot parse integer from: " + stringParts[i], e
        );
      }
    }

    LOGGER.info("Array parsing completed. Number of elements: {}",
            result.length);

    return result;
  }
}