package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        if(inputNumbers.contains(null)) throw new CannotBuildPyramidException();
        int h = isPyramid(inputNumbers.size());
        if (h != 0) {
            int[][] resArray = new int[h][2 * h - 1];
            Collections.sort(inputNumbers);
            int num = 0;
            for (int i = 0; i < h; i++) {
                int k = h - i - 1;
                for (int j = 0; j <= i; j++) {
                    resArray[i][k] = inputNumbers.get(num);
                    num += 1;
                    k += 2;
                }
            }
            return resArray;
        }
        throw new CannotBuildPyramidException();
    }

    private int isPyramid(int size) {
        if (size == 0) return 0;
        for (int i = 1; i <= size / 2 + 1; i++) {
            if (size == i * (i + 1) / 2) {
                return i;
            }
        }
        return 0;
    }
}
