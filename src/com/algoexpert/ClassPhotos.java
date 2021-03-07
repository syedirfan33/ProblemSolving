package com.algoexpert;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights, (a, b) -> b - a);
        Collections.sort(blueShirtHeights, (a, b) -> b - a);
        boolean blueBack = blueShirtHeights.get(0) > redShirtHeights.get(0) ? true : false;
        for (int i = 0; i < redShirtHeights.size(); i++) {
            if (blueBack && blueShirtHeights.get(i) <= redShirtHeights.get(i)) return false;
            else if (blueBack == false && blueShirtHeights.get(i) >= redShirtHeights.get(i)) return false;
        }
        return true;
    }
}
