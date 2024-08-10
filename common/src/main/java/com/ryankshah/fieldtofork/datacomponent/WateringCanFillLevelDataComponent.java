package com.ryankshah.fieldtofork.datacomponent;

import java.util.Objects;

public class WateringCanFillLevelDataComponent
{
    private final int currentFillLevel;
    private final int maxFillLevel;

    public WateringCanFillLevelDataComponent(int currentFillLevel, int maxFillLevel) {
        this.currentFillLevel = currentFillLevel;
        this.maxFillLevel = maxFillLevel;
    }

    public int getCurrentFillLevel() {
        return this.currentFillLevel;
    }

    public int getMaxFillLevel() {
        return this.maxFillLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currentFillLevel, this.maxFillLevel);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof WateringCanFillLevelDataComponent ex
                    && this.currentFillLevel == ex.currentFillLevel
                    && this.maxFillLevel == ex.maxFillLevel;
        }
    }
}