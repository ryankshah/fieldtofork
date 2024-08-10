package com.ryankshah.fieldtofork.entity.model;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.entity.SilkMoth;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;


public class SilkMothModel extends DefaultedEntityGeoModel<SilkMoth>
{
    public SilkMothModel() {
        super(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "silkmoth"), true);
    }

//    @Override
//    public ResourceLocation getModelResource(SilkMoth object)
//    {
//        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "geo/silkmoth.geo.json");
//    }
//
//    @Override
//    public ResourceLocation getTextureResource(SilkMoth object)
//    {
//        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "textures/entity/silkmoth.png");
//    }
//
//    @Override
//    public ResourceLocation getAnimationResource(SilkMoth object)
//    {
//        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "animations/silkmoth.animation.json");
//    }
}
