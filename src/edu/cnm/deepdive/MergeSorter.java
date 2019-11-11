package edu.cnm.deepdive;

import java.util.Arrays;

public class MergeSorter {

  public static void sort(int[] data) {
   sort(data, 0, data.length);
  }

  private static void sort(int[] data, int from, int to) {
    if (to - from <= 1) {
      return;
    }
    int midpoint = (from + to) / 2;
    sort(data, from, midpoint); // sort left pile
    sort(data, midpoint, to); // sort right pile
    int[] merged = new int[to - from];
    int leftIndex = from;
    int rightIndex = midpoint;
    int mergedIndex = 0;
    while (leftIndex < midpoint && rightIndex < to) {
      if (data[leftIndex] <= data[rightIndex]) {
        merged[mergedIndex++] = data[leftIndex++];
      } else {
        merged[mergedIndex++] = data[rightIndex++];
      }
    }
    for (int i = leftIndex; i < midpoint; i++) {
      merged[mergedIndex++] = data[leftIndex++];
    }
    for (int i = rightIndex; i < to; i++) {
      merged[mergedIndex++] = data[rightIndex++];
    }
    System.arraycopy(merged, 0, data, from, merged.length);
  }

  public static void main(String[] args) {
    int[] test = new int[]{4,2,3,1};
    System.out.println(Arrays.toString(test));
    sort(test);
    System.out.println(Arrays.toString(test));
  }

}
