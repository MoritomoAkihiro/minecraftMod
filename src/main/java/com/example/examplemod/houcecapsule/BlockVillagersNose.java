package com.example.examplemod.mc_14_houcecapsule;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockVillagersNose extends BlockButton {


    public BlockVillagersNose(){
        super(true);
        setCreativeTab(CreativeTabs.REDSTONE);
        setRegistryName("villagersnose");
        setUnlocalizedName(ExampleMod.MODID+"_block_VillagersNose");
        setHardness(30);



    }
    protected void playClickSound(@Nullable EntityPlayer player, World worldIn, BlockPos pos)
    {
        worldIn.playSound(player, pos, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
    }

    protected void playReleaseSound(World worldIn, BlockPos pos)
    {
        worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
    }


    public void updateTick(World worldIn, BlockPos pos, IBlockState state,Random rand){//5tick後に起こる動作
        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY(), pos.getZ());//座標

        worldIn.setBlockState(pos1, Blocks.AIR.getDefaultState());
        EntityVillager VillagerA = new EntityVillager(worldIn);
        VillagerA.setPosition(pos.getX() , pos.getY(), pos.getZ());
        worldIn.spawnEntityInWorld(VillagerA);
    }
    @Override
    //右クリックしたときの処理。
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3; j++) {
                for (int k = 0; k <3; k++) {
                    double random1 = Math.random();
                    worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX(), pos.getY() + k, pos.getZ(), 0.5-random1, 0.05-random1/10, 0, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX(), pos.getY() + k, pos.getZ(), -0.5+random1, 0.05-random1/10, 0, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX(), pos.getY() + k, pos.getZ(), 0, 0.05-random1/10, 0.5-random1, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX(), pos.getY() + k, pos.getZ(), 0, 0.05-random1/10, -0.5+random1, new int[0]);

                    System.out.println(random1);
                }
            }
        }
            worldIn.setBlockState(pos, state.withProperty(POWERED, Boolean.valueOf(true)), 3);
            worldIn.markBlockRangeForRenderUpdate(pos, pos);
            this.playClickSound(playerIn, worldIn, pos);

        if(!worldIn.isRemote){
                worldIn.scheduleBlockUpdate(pos,this,5,100);//村人の鼻を押した5tick後にupdatetickのメソッドが呼ばれる。
                System.out.println("spawn_villager");
                }
            return true;

//        }
    }


}
