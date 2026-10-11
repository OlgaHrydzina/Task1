package com.hrydzina.taskarray.validator;

import com.hrydzina.taskarray.validator.impl.ArrayDataValidatorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayDataValidatorInterface {

  private static final Logger LOGGER =
          LogManager.getLogger(ArrayValidatorImpl.class);

  private static final String VALID_DATA_REGEX = "^\\s*\\d+(\\s*[;,\\-\\s]\\s*\\d+)*\\s*$";

  private static final Pattern VALID_DATA_PATTERN = Pattern.compile(VALID_DATA_REGEX);

  @Override
  public boolean isValid(String data) {

    if (data == null) {
      LOGGER.warn("Array data is null");
      return false;
    }
    return checkData(data);
  }
  private boolean checkData(String data) {

    if (data.isBlank()) {
      return true;
    }
    Matcher matcher = VALID_DATA_PATTERN.matcher(data);
    boolean valid = matcher.matches();

    if (!valid) {
      LOGGER.warn("Invalid array data: {}", data);
    }
    return valid;
  }
}