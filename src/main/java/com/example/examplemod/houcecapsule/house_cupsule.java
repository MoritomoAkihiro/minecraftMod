package com.example.examplemod.houcecapsule;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class house_cupsule extends ItemSnowball {


    public house_cupsule() {                //コンストラクタの設定
        setCreativeTab(CreativeTabs.COMBAT);//種類の設定
        setRegistryName("house_cupsule");  //名前の設定
        setUnlocalizedName(ExampleMod.MODID+"_house_cupsule");//名前の設定
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand){

        if(!playerIn.capabilities.isCreativeMode){
            --itemStackIn.stackSize;
        }

        worldIn.playSound(null,playerIn.posX,playerIn.posY,playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW,
                SoundCategory.NEUTRAL,0.5F,0.4F/(itemRand.nextFloat()*0.4F+0.8F));

        if(!worldIn.isRemote){
            com.example.examplemod.houcecapsule.Entityhouse_cupsule entity=new com.example.examplemod.houcecapsule.Entityhouse_cupsule(worldIn,playerIn);
            entity.setHeadingFromThrower(playerIn,playerIn.rotationPitch,playerIn.rotationYaw,0.0F,1.5F,1.0F);
            worldIn.spawnEntityInWorld(entity);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS,itemStackIn);

    }
}

