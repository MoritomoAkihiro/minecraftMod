package com.example.examplemod.WatermelonSplitting;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGoldenWatermelon extends Block {

    public BlockGoldenWatermelon() {

        super(Material.GOURD);//ウリ系のブロック
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);//タブの設定
        setRegistryName("golden_melon");//名前
        setUnlocalizedName(ExampleMod.MODID + "_golden_melon");
        setHardness(30);
    }
}
