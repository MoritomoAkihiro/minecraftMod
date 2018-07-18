package com.example.examplemod.WatermelonSplitting;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BlockGoldenWatermelon extends Block {
    private final Minecraft mc=Minecraft.getMinecraft();

    public BlockGoldenWatermelon() {

        super(Material.GOURD);//ウリ系のブロック
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);//タブの設定
        setRegistryName("golden_melon");//名前
        setUnlocalizedName(ExampleMod.MODID + "_golden_melon");
        setHardness(30);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn){//このブロックをクリックしたときの処理
        if(playerIn==null){//おまじない
            return;
        }
        if(playerIn.getHeldItemMainhand()==null){//メインハンドに何も持ってなかったら処理終了
            return;
        }
        Item item=playerIn.getHeldItemMainhand().getItem();//簡単のためItem型のitemにプレイヤーの右手に持ってるものを代入する。

        if(item!= Items.STICK){//メインハンドに棒じゃなかったら処理終了
            return;
        }

        //メインハンドに棒をもってブロックを叩いた時の処理を下に記す。
        //EnumFacing angle=mc.thePlayer.getHorizontalFacing();//方向を得る
         Vec3d angle=mc.thePlayer.getForward();
        System.out.println(angle);
    }
}
