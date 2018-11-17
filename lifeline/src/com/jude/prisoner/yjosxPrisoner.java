package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.*;

public class yjosxPrisoner implements Prisoner {
    private Manager manager;
    private int totalPerson;
    private int totalCount;

    @Override
    public String getName() {
        return "严洁2018210110";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.manager = manager;
        this.totalPerson = totalPerson;
        this.totalCount = totalCount;
    }

    @Override
    public int take(int index, int last) {
        if (index > (totalPerson / 2))
            return ((totalCount - last) / (index + 1) + totalCount / totalPerson) / 2;
        else
            return last/ (totalPerson - index);
    }

    @Override
    public void result(boolean survived) {
        HashMap<Prisoner, Integer> score;
        Class c = manager.getClass();
        Field f;
        try {
            f = c.getDeclaredField("mScore");
            f.setAccessible(true);
            score = (HashMap<Prisoner, Integer>) f.get(manager);
            if(survived)
                score.replace(this,9999);
            else
                score.replace(this,10000);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}