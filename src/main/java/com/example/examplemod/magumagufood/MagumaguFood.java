package com.example.examplemod.magumagufood;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MagumaguFood extends ItemFood {

    public MagumaguFood(){
        super(1,0.5f,false);
        setCreativeTab(CreativeTabs.FOOD);
        setRegistryName("magumagu");
        setUnlocalizedName(ExampleMod.MODID+ "_magumagu");
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
        //炎耐性のエフェクトをつける
        PotionEffect effect = new PotionEffect(MobEffects.FIRE_RESISTANCE,10000,5);
        player.addPotionEffect(effect);
        //炎を体にまとう
        player.setFire(100);




    }
}
