package Exceptions.averageCalculator;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberSource implements INumberSource {
    List<Integer> nums = new ArrayList<>();


    public RandomNumberSource(int maxNums) {
        for(int i = 0; i<maxNums;i++){
            nums.add((int)(100*Math.random()));
        }
    }

    @Override
    public boolean hasMoreNumbers() {
        if(nums.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public int nextNumber() {
        return nums.remove(0);
    }
}
