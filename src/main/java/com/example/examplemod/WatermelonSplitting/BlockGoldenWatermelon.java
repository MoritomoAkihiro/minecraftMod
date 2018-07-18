package com.example.examplemod.WatermelonSplitting;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
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

        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        double distance = mc.thePlayer.getDistance(posX,posY,posZ);
        if(distance==8){
            PotionEffect effect = new PotionEffect(MobEffects.BLINDNESS,10,10);
            playerIn.addPotionEffect(effect);
        }
        System.out.println("distance"+posX+" ,  "+posY+"  ,  "+posZ);
        System.out.println("distance"+distance);

        //メインハンドに棒をもってブロックを叩いた時の処理を下に記す。
        Vec3d direction=mc.thePlayer.getForward();//今向いている方角をVec3d型で受け取る
        String str = direction.toString().replace("(","").replace(")","").replaceAll(" ","");//Vec3d型をString型に変換
        String[] angle = str.split(",",0);//String型のx,y,zをそれぞれ配列に分ける
        double x=Double.parseDouble(angle[0]);
        double y=Double.parseDouble(angle[1]);
        double z=Double.parseDouble(angle[2]);

        if(!worldIn.isRemote) {
            System.out.println(x + " , " + y + " , " + z);//配列を表示する。
            System.out.println("足し算"+(x+y+z));
            System.out.println("掛け算"+x*y*z);
        }
    }
}
