package com.shaobig.diplomanota.entities.analyzer;

import com.shaobig.diplomanota.entities.enums.Degree;

public interface DegreeAnalyzer {
    Degree getNext(Degree current);
}
