package com.ryankshah.fieldtofork.block.silkworm_habitat;

import net.minecraft.world.inventory.ContainerData;

public class SilkwormHabitatContainerData implements ContainerData
{
    private final SilkwormHabitatBlockEntity te;

    public SilkwormHabitatContainerData(SilkwormHabitatBlockEntity te)
    {
        this.te = te;
    }

    public int get(int p_58431_) {
        switch (p_58431_) {
            case 0:
                return this.te.producingTime;
            case 1:
                return this.te.producingDuration;
            case 2:
                return this.te.producingProgress;
            case 3:
                return this.te.producingTotalTime;
            default:
                return 0;
        }
    }

    public void set(int p_58433_, int p_58434_) {
        switch (p_58433_) {
            case 0:
                this.te.producingTime = p_58434_;
                break;
            case 1:
                this.te.producingDuration = p_58434_;
                break;
            case 2:
                this.te.producingProgress = p_58434_;
                break;
            case 3:
                this.te.producingTotalTime = p_58434_;
        }

    }

    public int getCount() {
        return 4;
    }
}
