package com.medianet.fishingCompetiton.DTOs.tournament;

import jakarta.persistence.criteria.CriteriaBuilder;

public class RecordDTO {
    Integer fishCount;
    Float totalWeight;
    Boolean isAbsent;
    Boolean isEliminated;

    public Integer getFishCount() {
        return fishCount;
    }

    public void setFishCount(Integer fishCount) {
        this.fishCount = fishCount;
    }

    public Float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Float totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Boolean getAbsent() {
        return isAbsent;
    }

    public void setAbsent(Boolean absent) {
        isAbsent = absent;
    }

    public Boolean getEliminated() {
        return isEliminated;
    }

    public void setEliminated(Boolean eliminated) {
        isEliminated = eliminated;
    }
}
