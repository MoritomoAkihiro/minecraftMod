package com.example.examplemod.WatermelonSplitting;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

public class BlockGoldenWatermelon extends Block {
    private final Minecraft mc=Minecraft.getMinecraft();

    public BlockGoldenWatermelon() {

        super(Material.GOURD);//ウリ系のブロック
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);//タブの設定
        setRegistryName("goldenwatermelon");//名前
        setUnlocalizedName(ExampleMod.MODID + "_goldenmelon");
        setHardness(1);
    }

    //距離10以内に入ったら盲目のエフェクトかかる
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand){
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        double distance = mc.thePlayer.getDistance(posX,posY,posZ);//プレイヤーとスイカブロックの距離

//距離10以内かつ盲目ついていなかったら
        if(distance<15 && !mc.thePlayer.isPotionActive(MobEffects.BLINDNESS)){
            //ポーションエフェクトをつける
            PotionEffect effect = new PotionEffect(MobEffects.BLINDNESS,10000,100);
            mc.thePlayer.addPotionEffect(effect);
            mc.thePlayer.addChatComponentMessage(new TextComponentString("スイカわりモードが始まった！！"));
            mc.thePlayer.addChatComponentMessage(new TextComponentString("スイカを棒で叩くんだ！！"));


            //距離10以上かつ盲目ついていたらエフェクトなくす
        }else if(distance>15 && mc.thePlayer.isPotionActive(MobEffects.BLINDNESS)){
            //ポーションエフェクト（盲目）をはずす。
            mc.thePlayer.removePotionEffect(MobEffects.BLINDNESS);
            mc.thePlayer.addChatComponentMessage(new TextComponentString("スイカわりモードが終了した！！"));

        }
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

        mc.thePlayer.removePotionEffect(MobEffects.BLINDNESS);//ポーションエフェクト（盲目）をはずす。
        worldIn.setBlockState(pos,Blocks.AIR.getDefaultState());//スイカブロック壊す

        //スイカブロックを出現させる。
        ItemStack melon = new ItemStack(Items.MELON,10);
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX()-0.5+0.5*i, pos.getY()+0.5*k, pos.getZ()-0.5+0.5*j, melon));
                }
            }
        }

        //壊れた後をつけたい
        Vec3d direction=mc.thePlayer.getForward();//今向いている方角をVec3d型で受け取る
        String str = direction.toString().replace("(","").replace(")","").replaceAll(" ","");//Vec3d型をString型に変換
        String[] angle = str.split(",",0);//String型のx,y,zをそれぞれ配列に分ける
        //x,y,zをdouble型に変換する。、
        //x,y,zはベクトルとして得られる。
        double x=Double.parseDouble(angle[0]);
        double y=Double.parseDouble(angle[1]);
        double z=Double.parseDouble(angle[2]);

        if(!worldIn.isRemote) {
            System.out.println("xは"+x + " , yは" + y + " , zは" + z);//配列を表示する。

        }
    }
}
