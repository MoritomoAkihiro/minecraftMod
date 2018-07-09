package com.example.examplemod.mc_14_houcecapsule;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class Rendererhouse_cupsule extends RenderSnowball{
    private static final ResourceLocation texture=
            new ResourceLocation("examplemod:textures/items/house_cupsule.png");

    public Rendererhouse_cupsule(RenderManager renderManagerIn, Item itemIn, RenderItem itemRenderIn){
        super(renderManagerIn,itemIn, itemRenderIn);
    }

    @Override
    protected  ResourceLocation getEntityTexture(Entity entity){
        return texture;
    }
}
