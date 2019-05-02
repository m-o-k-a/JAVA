package com.moka;

import java.util.Map;

public class DistributionCenters {
    private Map<Integer, Adress> distribution;

    public DistributionCenters(Map<Integer, Adress> distribution) {
        this.distribution = distribution;
    }

    public Map<Integer, Adress> getDistribution() { return distribution; }
}
