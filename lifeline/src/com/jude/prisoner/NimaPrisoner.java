package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

/**
 * Created by Mr.Jude on 2015/10/28.
 */
public class NimaPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "王尼玛2016210409";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        //经过我王尼玛缜密的计算，我算出我拿这个数最能活
        return ((totalCount - last) / (index + 1) + totalCount / totalPerson) / 2;
    }

    @Override
    public void result(boolean survived) {

    }

}
