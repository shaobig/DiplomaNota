package com.shaobig.diplomanota.entities.analyzer;

import com.shaobig.diplomanota.entities.enums.Degree;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChordDegreeAnalyzer implements DegreeAnalyzer {

    @Override
    public Degree getNext(Degree current) {
        List<Degree> degrees;

        switch (current) {
            case FIRST: degrees = Arrays.asList(Degree.SECOND, Degree.THIRD, Degree.FOURTH, Degree.FIFTH, Degree.SIXTH, Degree.SEVENTH); break;
            case SECOND: degrees = Arrays.asList(Degree.THIRD, Degree.FIFTH); break;
            case THIRD: degrees = Arrays.asList(Degree.FIRST, Degree.FOURTH, Degree.FIFTH, Degree.SIXTH, Degree.SEVENTH); break;
            case FOURTH: degrees = Arrays.asList(Degree.FIRST, Degree.FIFTH); break;
            case FIFTH: degrees = Arrays.asList(Degree.FIRST, Degree.THIRD, Degree.SEVENTH); break;
            case SIXTH: degrees = Arrays.asList(Degree.FIRST, Degree.THIRD, Degree.FIFTH); break;
            case SEVENTH: degrees = Arrays.asList(Degree.FIRST); break;
            default: degrees = Arrays.asList(Degree.FIRST);
        }

        int index = new Random().nextInt(degrees.size());
        return degrees.get(index);
    }
}
