package com.company;

import java.util.Comparator;

public class SceneComparator implements Comparator<Staty> {
    @Override
    public int compare(Staty o1, Staty o2) {
        return (o1.getPlnaSazbaDPH()> o2.getPlnaSazbaDPH()) ? -1
                : (o1.getPlnaSazbaDPH() < o2.getPlnaSazbaDPH()) ? 1 : 0;
    }

}