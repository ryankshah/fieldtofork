package com.ryankshah.fieldtofork.entity.render;

import com.ryankshah.fieldtofork.entity.SilkMoth;
import com.ryankshah.fieldtofork.entity.model.SilkMothModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SilkMothRenderer extends GeoEntityRenderer<SilkMoth>
{
    public SilkMothRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx, new SilkMothModel());
        this.shadowRadius = 0.5f;
    }
}