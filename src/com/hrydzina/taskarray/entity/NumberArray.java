package com.hrydzina.taskarray.entity;

import java.util.Arrays;

public class NumberArray {
    private final int[] values;
    public NumberArray(int[] values) {
        this.values = values.clone();
    }
    public int[] getValues() {
        return values.clone();
    }
    public int getLength() {
        return values.length;
    }
    public NumberArray clone() {
        return new NumberArray(values);
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NumberArray)) {
            return false;
        }
        NumberArray other = (NumberArray) object;
        return Arrays.equals(values, other.values);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("NumberArray{");
        builder.append("values=");
        builder.append("[");
        for (int index = 0; index < values.length; index++) {
        }
        builder.append("]");
        builder.append("}");
        return builder.toString();
    }
}
