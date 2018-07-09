package com.example.examplemod.mc_14_houcecapsule;

import com.example.examplemod.ExampleMod;
import javafx.scene.transform.Rotate;
import net.minecraft.block.*;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import com.example.examplemod.mc_02_myblock.MYBlock;
import scala.tools.nsc.interpreter.Power;


import static net.minecraft.block.BlockLever.POWERED;
import static net.minecraft.block.BlockStainedGlass.COLOR;
import static net.minecraft.block.BlockTrapDoor.HALF;
import static net.minecraft.block.BlockTrapDoor.OPEN;


public class Entityhouse_cupsule extends EntitySnowball {

    public static final PropertyEnum<BlockStairs.EnumHalf> STAIRSHALF = PropertyEnum.<BlockStairs.EnumHalf>create("half", BlockStairs.EnumHalf.class);

    public static final int ENTITY_ID = 3;
    private static final float DAMAGE = 2.0f;

    public Entityhouse_cupsule(World worldIn){
        super(worldIn);
    }

    public Entityhouse_cupsule(World worldIn, EntityLivingBase throwerIn){
        super(worldIn, throwerIn);
    }

    public Entityhouse_cupsule(World worldIn, double x,double y, double z){
        super(worldIn,x,y,z);
    }


        @Override
        protected void onImpact(RayTraceResult result) {
            if(result.typeOfHit == RayTraceResult.Type.BLOCK){

                int xi = 0;
                int yi = 0;
                int zi = 0;

                switch(result.sideHit) {

                    case UP:
                    case DOWN:
                    case NORTH:
                    case SOUTH:
                    case WEST:
                    case EAST:


                        posZ=posZ-10;

//=======中身をくりぬく
                        for (int i = 0; i < 20; i++) {
                            for (int j = 0; j < 11; j++) {
                                for (int k = 0; k < 20; k++) {
                                    BlockPos pos = new BlockPos(posX + i, posY + j, posZ + k);//座標
                                    worldObj.setBlockState(pos, Blocks.AIR.getDefaultState());
                                }
                            }
                        }
//=================建物コード==============================================================================================================================================

                        //====壁=============================================================
                        for (int j = 0; j < 19; j++) {//左側の壁
                            for (int i = 0; i < 11; i++) {
                                BlockPos pos = new BlockPos(posX + j, posY + i, posZ);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 11; i++) {//正面
                            for (int j = 0; j < 11; j++) {
                                BlockPos pos = new BlockPos(posX, posY + j, posZ + i + 10);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int j = 0; j < 11; j++) {
                            for (int k = 0; k < 4; k++) {
                                BlockPos pos = new BlockPos(posX + k, posY + j, posZ + 10);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }

                        for (int j = 0; j < 11; j++) {//右の壁
                            for (int k = 0; k < 19; k++) {
                                BlockPos pos = new BlockPos(posX + k, posY + j, posZ + 20);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int j = 0; j < 11; j++) {//裏面の壁
                            for (int k = 0; k < 11; k++) {
                                BlockPos pos = new BlockPos(posX + 18, posY + k, posZ + 20 - j);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int j = 0; j < 4; j++) {//裏面の壁２
                            for (int k = 0; k < 11; k++) {
                                BlockPos pos = new BlockPos(posX + 18 - j, posY + k, posZ + 10);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        //======床==============================
                        for (int j = 0; j < 17; j++) {
                            for (int k = 0; k < 20; k++) {
                                BlockPos pos = new BlockPos(posX + j + 1, posY, posZ + k + 1);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        //======正面================================
                        //色付きのガラスの説明はBlockStainedGlass.javaにあり、
                        // worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                        //EnumDyeColorのメタデータを参照して色を変えられる。

                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 8; j++) {//門の外側
                                BlockPos pos = new BlockPos(posX + 2 + i, posY + j + 1, posZ + 2);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                                BlockPos pos2 = new BlockPos(posX + 2 + i, posY + 8, posZ + j + 2);//座標
                                worldObj.setBlockState(pos2, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int j = 0; j < 7; j++) {//木
                            for (int k = 0; k < 7; k++) {
                                BlockPos pos = new BlockPos(posX + 3, posY + j + 1, posZ + 3 + k);//座標
                                worldObj.setBlockState(pos, Blocks.LOG.getDefaultState());
                            }
                        }
                        for (int j = 0; j < 3; j++) {//木の壁にガラス
                            for (int k = 0; k < 3; k++) {
                                BlockPos pos = new BlockPos(posX + 3, posY + 2 + j * 2, posZ + 4 + k * 2);//座標
                                worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                            }
                        }
                        for (int j = 0; j < 9; j++) {//門外側２
                            BlockPos pos = new BlockPos(posX + 3, posY + j, posZ + 1);//座標
                            worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                            BlockPos pos1 = new BlockPos(posX + 3, posY + 9, posZ + j + 1);//座標
                            worldObj.setBlockState(pos1, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                            for (int k = 0; k < 3; k++) {
                                BlockPos pos2 = new BlockPos(posX + 1 + k, posY + 10, posZ + 1 + j);//座標
                                worldObj.setBlockState(pos2, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int j = 0; j < 9; j++) {//正面の階段
                            BlockPos pos = new BlockPos(posX + 1, posY, posZ + 1 + j);//座標
                            worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_90));
                        }
                        for (int j = 0; j < 9; j++) {//正面の階段
                            BlockPos pos = new BlockPos(posX + 1, posY - 1, posZ + 1 + j);//座標
                            worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());
                        }
                        //===============裏面=====================================
                        for (int k = 0; k < 2; k++) {
                            for (int i = 0; i < 2; i++) {
                                for (int j = 0; j < 8 - 2 * i; j++) {//門の外側
                                    BlockPos pos = new BlockPos(posX + 16 - k, posY + j + 1, posZ + 2 + 2 * i);//座標
                                    worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                                    BlockPos pos2 = new BlockPos(posX + 16 - k, posY + 8 - 2 * i, posZ + j + 2 + 2 * i);//座標
                                    worldObj.setBlockState(pos2, Blocks.SNOW.getDefaultState());
                                }
                            }
                        }
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 9 - 2 * i; j++) {//門の外側
                                BlockPos pos = new BlockPos(posX + 15, posY + j + 1, posZ + 1 + 2 * i);//座標
                                worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                                BlockPos pos2 = new BlockPos(posX + 15, posY + 9 - 2 * i, posZ + j + 1 + 2 * i);//座標
                                worldObj.setBlockState(pos2, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                            }
                        }
                        for (int j = 0; j < 9; j++) {//裏門の天井
                            for (int k = 0; k < 3; k++) {
                                BlockPos pos2 = new BlockPos(posX + 15 + k, posY + 10, posZ + 1 + j);//座標
                                worldObj.setBlockState(pos2, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 5; i++) {//裏面窓
                            for (int j = 0; j < 5; j++) {
                                BlockPos pos = new BlockPos(posX + 15, posY + i + 1, posZ + 5 + j);//座標
                                worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                            }
                        }
                        for (int j = 0; j < 9; j++) {//裏面の階段
                            BlockPos pos = new BlockPos(posX + 17, posY, posZ + 1 + j);//座標
                            worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.COUNTERCLOCKWISE_90));
                        }
                        for (int j = 0; j < 9; j++) {//裏面の階段したライト
                            BlockPos pos = new BlockPos(posX + 17, posY - 1, posZ + 1 + j);//座標
                            worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());
                        }
                        //===========玄関=======================
                        for (int i = 0; i < 11; i++) {
                            BlockPos pos = new BlockPos(posX, posY + 5, posZ + i + 10);//座標
                            worldObj.setBlockState(pos, Blocks.AIR.getDefaultState());
                        }
                        for (int i = 0; i < 9; i++) {
                            BlockPos pos = new BlockPos(posX + 1, posY + 5, posZ + i + 11);//座標
                            worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                        }
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos1 = new BlockPos(posX + 1, posY + j + 1, posZ + i + 11);//座標
                                worldObj.setBlockState(pos1, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                BlockPos pos = new BlockPos(posX, posY + j + 1, posZ + i + 14);//座標
                                worldObj.setBlockState(pos, Blocks.AIR.getDefaultState());
                                BlockPos pos1 = new BlockPos(posX + 1, posY + j + 1, posZ + i + 14);//座標
                                worldObj.setBlockState(pos1, Blocks.LOG.getDefaultState());
                            }
                        }
                        //============壁の装飾壁の裏
                        for (int i = 0; i < 11; i++) {//壁のライン
                            BlockPos pos = new BlockPos(posX + 18, posY + 5, posZ + i + 10);//座標
                            worldObj.setBlockState(pos, Blocks.AIR.getDefaultState());
                        }
                        for (int i = 0; i < 9; i++) {//壁のラインの装飾
                            BlockPos pos = new BlockPos(posX + 17, posY + 5, posZ + i + 11);//座標
                            worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                        }
                        for (int i = 0; i < 2; i++) {//壁の穴
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos = new BlockPos(posX + 18, posY + 1 + i, posZ - j + 19);//座標
                                worldObj.setBlockState(pos, Blocks.AIR.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 4; i++) {//内側の雪
                            for (int j = 0; j < 9; j++) {
                                BlockPos pos = new BlockPos(posX + 17, posY + 4 - i, posZ + j + 11);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int j = 0; j < 4; j++) {
                            BlockPos pos = new BlockPos(posX + 17, posY + 2, posZ - j + 19);//座標
                            worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                        }

                        for (int i = 0; i < 8; i++) {//内側の壁正面（横）
                            BlockPos pos = new BlockPos(posX + 4, posY + 1 + i, posZ + 1);//座標
                            worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                        }
                        for (int i = 0; i < 10; i++) {//内側の壁正面（上）
                            BlockPos pos = new BlockPos(posX + 4, posY + 9, posZ + 1 + i);//座標
                            worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                        }

                        for (int j = 0; j < 3; j++) {
                            for (int i = 0; i < 8; i++) {//内側の壁背面（横）
                                BlockPos pos = new BlockPos(posX + 14, posY + 1 + i, posZ + 1 + j);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int j = 0; j < 3; j++) {
                            for (int i = 0; i < 10; i++) {//内側の壁背面（上）
                                BlockPos pos = new BlockPos(posX + 14, posY + 9 - j, posZ + 1 + i);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        //=====左壁の装飾
                        for (int i = 0; i < 3; i++) {
                            BlockPos pos = new BlockPos(posX + 12, posY + 3 + 2 * i, posZ + 0);//座標
                            worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));
                        }

                        //=============天井===========================
                        for (int i = 0; i < 13; i++) {
                            for (int j = 0; j < 9; j++) {
                                BlockPos pos = new BlockPos(posX + 3 + i, posY + 10, posZ + j + 1);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 19; i++) {
                            for (int j = 0; j < 11; j++) {
                                BlockPos pos = new BlockPos(posX + i, posY + 10, posZ + j + 10);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                BlockPos pos = new BlockPos(posX +8+i , posY + 10, posZ + 5+j);//座標
                                worldObj.setBlockState(pos, Blocks.GLASS.getDefaultState());
                            }
                        }

                        //=============内装=========================
                        //2階の内装=================================================

                        // ===二回の床================================
                        for (int i = 0; i < 9; i++) {//2回の床
                            for (int j = 0; j < 15; j++) {
                                BlockPos pos = new BlockPos(posX + 16 - j, posY + 5, posZ + i + 11);//座標
                                worldObj.setBlockState(pos, Blocks.WOOL.getDefaultState());
                            }
                        }
                        //========2回の壁================================
                        for (int i = 0; i < 17; i++) {//壁
                            for (int j = 0; j < 5; j++) {
                                BlockPos pos = new BlockPos(posX + 17 - i, posY + 9 - j, posZ + 11);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        //===階段======================================
                        for (int i = 0; i < 2; i++) {//階段
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos = new BlockPos(posX + 14 - j, posY + 5, posZ + 12 + i);//座標
                                worldObj.setBlockState(pos, Blocks.AIR.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 2; i++) {//階段
                            for (int j = 0; j < 5; j++) {
                                BlockPos pos = new BlockPos(posX + 14 - j, posY + 5 - j, posZ + 12 + i);//座標
                                worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_90));
                            }
                        }
                        for (int i = 0; i < 2; i++) {//階段際の壁1
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos = new BlockPos(posX + 10, posY + 6 + j, posZ + i + 12);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 4; i++) {//階段際の壁2
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos = new BlockPos(posX + 11 + i, posY + 6 + j, posZ + 14);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }

                        for (int i = 0; i < 3; i++) {//2階　右壁のガラス
                            BlockPos pos = new BlockPos(posX + 8 + i, posY + 8, posZ + 20);//座標
                            worldObj.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(9)));

                        }

                        //=============1回の壁（内装）========================================================================----
                        //ブロックを置く座標 ====↓/**/xi,yi,zi/**/======= (posX+xi,posY+yi,posZ+zi = 0+xi,0+yi,0+zi)========
                        for (int k = 1; k < 5; k++) {

                            int[] numbers3 = {16, k, 15,/**/15, k, 15/**/, 14, k, 15,/**/13, k, 15/**/, 12, k, 15,//風呂の壁1
                                    /**/11, k, 16,/**/11, k, 17,/**/11, k, 18,//風呂の壁2
                                    /**/9, k, 16,/**///脱衣所の壁
                                    /**/8, k, 17,/**/8, k, 18/**/, 8, k, 19,/**///脱衣所の壁
                                    /**/7, k, 16,/**/6, k, 16,/**/5, k, 16,//トイレの壁
                                    /**/4, k, 18,/**/4, k, 19
                            }; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む

                            for (int i = 0; i * 3 < numbers3.length; i++) {
                                xi = numbers3[3 * i];
                                yi = numbers3[3 * i + 1];
                                zi = numbers3[3 * i + 2];

                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());//置くアイテム
                                // ↑アイテム選択
                            }
                        }
                        for (int i = 0; i < 2; i++) {//ドアの上
                            BlockPos pos = new BlockPos(posX + 10, posY + 3 + i, posZ + 16);//脱衣所
                            worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            BlockPos pos2 = new BlockPos(posX + 5, posY + 3 + i, posZ + 17);//倉庫
                            worldObj.setBlockState(pos2, Blocks.SNOW.getDefaultState());
                            BlockPos pos3 = new BlockPos(posX + 11, posY + 3 + i, posZ + 19);//風呂の入り口
                            worldObj.setBlockState(pos3, Blocks.SNOW.getDefaultState());
                            BlockPos pos4 = new BlockPos(posX + 12, posY + 3 + i, posZ + 14);//映画の上
                            worldObj.setBlockState(pos4, Blocks.SNOW.getDefaultState());
                            BlockPos pos5 = new BlockPos(posX + 11, posY + 3 + i, posZ + 14);//映画の上２
                            worldObj.setBlockState(pos5, Blocks.SNOW.getDefaultState());
                        }
                        for (int i = 0; i < 6; i++) {
                            BlockPos pos5 = new BlockPos(posX + 14, posY + 1 + i, posZ + 10);//映画横の柱
                            worldObj.setBlockState(pos5, Blocks.SNOW.getDefaultState());
                        }

                        for (int i = 0; i <2 ; i++) {//リビング上の端装飾
                            for (int j = 0; j <9 ; j++) {
                                BlockPos pos5 = new BlockPos(posX + 5+j, posY + 9 , posZ + 1);//
                                worldObj.setBlockState(pos5, Blocks.QUARTZ_STAIRS.getDefaultState().withProperty(STAIRSHALF, BlockStairs.EnumHalf.TOP));
                                BlockPos pos = new BlockPos(posX + 13, posY + 9, posZ + 2+j);//
                                worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withProperty(STAIRSHALF, BlockStairs.EnumHalf.TOP).withRotation(Rotation.CLOCKWISE_90));
                                BlockPos pos1 = new BlockPos(posX + 5-i, posY + 9-i, posZ + 2+j);//
                                worldObj.setBlockState(pos1, Blocks.QUARTZ_STAIRS.getDefaultState().withProperty(STAIRSHALF, BlockStairs.EnumHalf.TOP).withRotation(Rotation.COUNTERCLOCKWISE_90));
                            }
                        }
                        //===================装飾=====================================================


                        //1階の内装
                        //=====ドア=======================
                        //ブロックを置く座標 ====↓/**/xi,yi,zi/**/======= (posX+xi,posY+yi,posZ+zi = 0+xi,0+yi,0+zi)========
                        int[] numbers2 = {1, 2, 15,}; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む

                        for (int i = 0; i * 3 < numbers2.length; i++) {
                            xi = numbers2[3 * i];
                            yi = numbers2[3 * i + 1];
                            zi = numbers2[3 * i + 2];

                            BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                            worldObj.setBlockState(pos, Blocks.AIR.getDefaultState());//置くアイテム
                            // ↑アイテム選択
                        }
                        //ブロックを置く座標 ====↓/**/xi,yi,zi/**/======= (posX+xi,posY+yi,posZ+zi = 0+xi,0+yi,0+zi)========
                        int[] numbers1 = {1, 1, 15,}; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む
                        for (int i = 0; i * 3 < numbers1.length; i++) {
                            xi = numbers1[3 * i];
                            yi = numbers1[3 * i + 1];
                            zi = numbers1[3 * i + 2];

                            BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                            worldObj.setBlockState(pos, Blocks.ACACIA_DOOR.getDefaultState());//置くアイテム
                            // ↑アイテム選択
                        }
                        //=====玄関============================
                        for (int i = 0; i < 3; i++) {//階段
                            BlockPos pos = new BlockPos(posX - 1, posY, posZ + 14 + i);//座標
                            worldObj.setBlockState(pos, Blocks.WOODEN_SLAB.getDefaultState());
                        }
                        for (int i = 0; i < 3; i++) {//階段下の間接照明
                            BlockPos pos = new BlockPos(posX - 1, posY - 1, posZ + 14 + i);//座標
                            worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());
                        }
                        for (int i = 0; i < 1; i++) {//ドア
                            Block door = Blocks.OAK_DOOR;
                            BlockPos pos = new BlockPos(posX + 1, posY + 1, posZ + 15);
                            BlockPos pos2 = pos.up();
                            worldObj.setBlockState(pos, door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER).withRotation(Rotation.CLOCKWISE_90), 2);
                            worldObj.setBlockState(pos2, door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER).withRotation(Rotation.CLOCKWISE_90), 2);
                            worldObj.notifyNeighborsOfStateChange(pos, door);
                            worldObj.notifyNeighborsOfStateChange(pos2, door);
                        }

                        //=======お風呂========
                        for (int i = 0; i < 4; i++) {//お風呂のヘリ
                            BlockPos pos = new BlockPos(posX + 14, posY + 1, posZ + 16 + i);//座標
                            worldObj.setBlockState(pos, Blocks.OAK_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_90));

                        }
                        for (int i = 0; i < 2; i++) {//お風呂の水
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos = new BlockPos(posX + 15 + i, posY + 1, posZ + 16 + j);//座標
                                worldObj.setBlockState(pos, Blocks.WATER.getDefaultState());
                            }
                        }
                        int[] numbers5 = {14, 0, 16,/**/14, 0, 19,/**/14, 0, 17/**/, 14, 0, 18}; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む

                        for (int i = 0; i * 3 < numbers5.length; i++) {//お風呂の間接照明
                            xi = numbers5[3 * i];
                            yi = numbers5[3 * i + 1];
                            zi = numbers5[3 * i + 2];

                            BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                            worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());//置くアイテム
                            // ↑アイテム選択
                        }
                        for (int i = 0; i < 2; i++) {//お風呂の湯気
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos = new BlockPos(posX + 15 + i, posY - 1, posZ + 16 + j);//座標
                                worldObj.setBlockState(pos, ExampleMod.blockMyBlock.getDefaultState());              //=======マイブロックの生成
                            }
                        }
                        int[] numbers6 = {16, 2, 19,/**/12, 4, 16}; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む

                        for (int i = 0; i * 3 < numbers6.length; i++) {//蛇口
                            xi = numbers6[3 * i];
                            yi = numbers6[3 * i + 1];
                            zi = numbers6[3 * i + 2];
                            if (i == 0) {//1つめはそのままの向き
                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.TRIPWIRE_HOOK.getDefaultState());//置くアイテム
                                // ↑アイテム選択
                            } else {
                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.TRIPWIRE_HOOK.getDefaultState().withRotation(Rotation.CLOCKWISE_180));
                            }
                        }
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 4; j++) {
                                BlockPos pod = new BlockPos(posX + 15 + i, posY + 0, posZ + 16 + j);//浴槽
                                worldObj.setBlockState(pod, Blocks.GLOWSTONE.getDefaultState());
                            }
                        }

                        for (int j = 0; j < 1; j++) {
                            BlockPos poe = new BlockPos(posX + 11, posY + 0, posZ + 19);//マット
                            worldObj.setBlockState(poe, Blocks.GRASS_PATH.getDefaultState());
                            //======脱衣所==============================
                            BlockPos pod = new BlockPos(posX + 9, posY + 1, posZ + 17);//座標
                            worldObj.setBlockState(pod, Blocks.CAULDRON.getDefaultState());
                            BlockPos pod1 = new BlockPos(posX + 9, posY + 3, posZ + 17);//座標
                            worldObj.setBlockState(pod1, Blocks.WALL_BANNER.getDefaultState().withRotation(Rotation.CLOCKWISE_90), 0);
                            BlockPos pod2 = new BlockPos(posX + 10, posY + 3, posZ + 15);//座標
                            worldObj.setBlockState(pod2, Blocks.WALL_BANNER.getDefaultState(), 11);
                            for (int i = 0; i < 3; i++) {
                                BlockPos pod4 = new BlockPos(posX + 9, posY + 4, posZ + 17 + i);//座標
                                worldObj.setBlockState(pod4, Blocks.TRAPDOOR.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 1; i++) {//ドア
                            Block door = Blocks.OAK_DOOR;
                            BlockPos pos = new BlockPos(posX + 11, posY + 1, posZ + 19);
                            BlockPos pos2 = pos.up();
                            worldObj.setBlockState(pos, door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER).withRotation(Rotation.CLOCKWISE_90), 2);
                            worldObj.setBlockState(pos2, door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER).withRotation(Rotation.CLOCKWISE_90), 2);
                            worldObj.notifyNeighborsOfStateChange(pos, door);
                            worldObj.notifyNeighborsOfStateChange(pos2, door);
                        }
                        for (int i = 0; i < 4; i++) {
                            BlockPos pos = new BlockPos(posX + 11, posY + 1 + i, posZ + 15);//壁
                            worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                        }
                        for (int i = 0; i <1 ; i++) {
                            BlockPos pos3 = new BlockPos(posX + 9, posY + 1, posZ + 18);//かご
                            worldObj.setBlockState(pos3, Blocks.CHEST.getDefaultState());
                            BlockPos pos4 = new BlockPos(posX + 9, posY + 1, posZ + 19);//洗濯機
                            worldObj.setBlockState(pos4, Blocks.HOPPER.getDefaultState());
                            BlockPos pos5 = new BlockPos(posX + 9, posY + 2, posZ + 19);//洗濯機
                            worldObj.setBlockState(pos5, Blocks.IRON_TRAPDOOR.getDefaultState().withProperty(OPEN,Boolean.TRUE));
                        }

                        //========映画============
                        for (int i = 0; i < 4; i++) {//スクリーン
                            for (int j = 0; j < 2; j++) {
                                BlockPos pos = new BlockPos(posX + 17, posY + 2 + j, posZ + 11 + i);//座標
                                worldObj.setBlockState(pos, Blocks.WOOL.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(15)));
                            }
                        }
                        for (int i = 0; i < 5; i++) {//カーペット
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos = new BlockPos(posX + 12 + i, posY + 1, posZ + 11 + j);//座標
                                worldObj.setBlockState(pos, Blocks.CARPET.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(8)));
                            }
                        }
                        for (int i = 0; i < 4; i++) {//スピーカー
                            BlockPos pos = new BlockPos(posX + 17, posY + 1, posZ + 11 + i);//座標
                            worldObj.setBlockState(pos, Blocks.JUKEBOX.getDefaultState());
                        }
                        for (int i = 0; i < 4; i++) {
                            BlockPos pos3 = new BlockPos(posX +17, posY +4 , posZ + 11+i);//本棚
                            worldObj.setBlockState(pos3, Blocks.BOOKSHELF.getDefaultState());
                        }
                        for (int i = 0; i < 2; i++) {
                            BlockPos pos = new BlockPos(posX + 12 + i, posY + 1, posZ + 11);//座標
                            worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                        }

                        for (int i = 0; i < 2; i++) {//階段下スペース
                            for (int j = 0; j < 2; j++) {
                                BlockPos pos = new BlockPos(posX + 11 + i, posY + 1, posZ + 12 + j);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        BlockPos pos10 = new BlockPos(posX + 13, posY + 4, posZ + 14);//座標
                        worldObj.setBlockState(pos10, Blocks.SNOW.getDefaultState());

                        for (int i = 0; i < 3; i++) {//椅子e
                            BlockPos pos = new BlockPos(posX + 14, posY + 1, posZ + 11 + i);//座標
                            if (i == 0) {
                                worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState());
                            } else if (i == 1) {
                                worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.COUNTERCLOCKWISE_90));
                            } else if (i == 2) {
                                worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_180));
                            }
                        }
                        for (int j = 0; j < 4; j++) {
                            for (int i = 0; i < j + 1; i++) {//映画横のしきり
                                BlockPos pos = new BlockPos(posX + 13 - i, posY + 4 - j, posZ + 11);//座標
                                worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 1; i++) {
                            BlockPos pos12 = new BlockPos(posX + 15, posY + 3, posZ + 11);//スイッチ
                            worldObj.setBlockState(pos12, Blocks.LEVER.getDefaultState().withRotation(Rotation.CLOCKWISE_180).withProperty(POWERED, Boolean.valueOf(true)));
                            BlockPos pos19 = new BlockPos(posX + 15, posY + 2, posZ + 10);//ライト
                            worldObj.setBlockState(pos19, Blocks.REDSTONE_LAMP.getDefaultState());
                            BlockPos pos13 = new BlockPos(posX + 12, posY + 2, posZ + 12);//飲み物
                            worldObj.setBlockState(pos13, Blocks.BREWING_STAND.getDefaultState());
                            BlockPos pos14 = new BlockPos(posX + 12, posY + 2, posZ + 13);//蛇口
                            worldObj.setBlockState(pos14, Blocks.TRIPWIRE_HOOK.getDefaultState().withRotation(Rotation.CLOCKWISE_90));
                        }
                        for (int i = 0; i < 1; i++) {//ドア
                            Block door = Blocks.OAK_DOOR;
                            BlockPos pos = new BlockPos(posX + 11, posY + 1, posZ + 14);
                            BlockPos pos2 = pos.up();
                            worldObj.setBlockState(pos, door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER).withRotation(Rotation.COUNTERCLOCKWISE_90), 2);
                            worldObj.setBlockState(pos2, door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER).withRotation(Rotation.COUNTERCLOCKWISE_90), 2);
                            worldObj.notifyNeighborsOfStateChange(pos, door);
                            worldObj.notifyNeighborsOfStateChange(pos2, door);
                        }
                        //===リビング==========================================-
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (i == 0) {
                                    BlockPos pos = new BlockPos(posX + 7 + j, posY + 0, posZ + 3);//階段
                                    worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState());

                                } else {
                                    BlockPos pos = new BlockPos(posX + 7 + j, posY + 0, posZ + 10);//階段
                                    worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_180));
                                }
                            }
                            for (int j = 0; j < 7; j++) {
                                if (i == 0) {
                                    BlockPos pos = new BlockPos(posX + 6, posY + 0, posZ + 4 + j);//階段
                                    worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.COUNTERCLOCKWISE_90));

                                } else {
                                    BlockPos pos = new BlockPos(posX + 12, posY + 0, posZ + 4 + j);//階段
                                    worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_90));
                                }
                            }

                        }
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 5; j++) {
                                BlockPos pos = new BlockPos(posX + 7 + j, posY + 0, posZ + 4 + i);//カーペット
                                worldObj.setBlockState(pos, Blocks.CARPET.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(12)));
                            }
                        }
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 5; j++) {
                                BlockPos pos = new BlockPos(posX + 7 + j, posY - 1, posZ + 4 + i);//ライト
                                worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());
                            }
                        }
                        for (int i = 0; i < 3; i++) {
                            BlockPos pos11 = new BlockPos(posX + 9, posY + 0, posZ + 6 + i);//テーブル
                            worldObj.setBlockState(pos11, Blocks.IRON_BLOCK.getDefaultState());
                            for (int j = 0; j < 2; j++) {
                                if (i == 0) {
                                    BlockPos pos = new BlockPos(posX + 7 + j * 4, posY + 0, posZ + 6);//椅子
                                    worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState());
                                } else if (i == 1 && j == 1) {
                                    BlockPos pos = new BlockPos(posX + 7 + j * 4, posY + 0, posZ + 7);//椅子
                                    worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_90));
                                } else if (i == 1 && j == 0) {
                                    BlockPos pos = new BlockPos(posX + 7 + j * 4, posY + 0, posZ + 7);//椅子
                                    worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.COUNTERCLOCKWISE_90));
                                } else if (i == 2) {
                                    BlockPos pos = new BlockPos(posX + 7 + j * 4, posY + 0, posZ + 8);//椅子
                                    worldObj.setBlockState(pos, Blocks.QUARTZ_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_180));
                                }
                            }
                        }
                        for (int i = 0; i < 3; i++) {
                            BlockPos pos1 = new BlockPos(posX + 7 + 2 * i, posY + 5, posZ + 3);//あかり
                            worldObj.setBlockState(pos1, Blocks.END_ROD.getDefaultState());
                            for (int j = 0; j < 4; j++) {
                                BlockPos pos = new BlockPos(posX + 7 + 2 * i, posY + 6 + j, posZ + 3);//あかり
                                worldObj.setBlockState(pos, Blocks.IRON_BARS.getDefaultState());
                            }
                        }
                        for (int i = 0; i <2 ; i++) {
                            BlockPos pos = new BlockPos(posX + 6 + i * 6, posY + 1, posZ + 3);//カウンター
                            worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                        }
                            for (int j = 0; j < 5; j++) {
                                BlockPos pos = new BlockPos(posX + 7 + j, posY + 1, posZ + 3);//カウンター
                                worldObj.setBlockState(pos, Blocks.IRON_BARS.getDefaultState());
                            }
                                for (int j = 0; j <7 ; j++) {
                                    BlockPos pos2 = new BlockPos(posX + 6 + j, posY + 2, posZ + 3);//カウンター
                                    worldObj.setBlockState(pos2, Blocks.CARPET.getDefaultState());
                            }

                        for (int i = 0; i < 2; i++) {
                            BlockPos pos = new BlockPos(posX + 8 + 2 * i, posY + 0, posZ + 4);//カウンター椅子
                            worldObj.setBlockState(pos, Blocks.OAK_FENCE.getDefaultState());
                            BlockPos pos1 = new BlockPos(posX + 8 + 2 * i, posY + 1, posZ + 4);//カウンター椅子
                            worldObj.setBlockState(pos1, Blocks.OAK_STAIRS.getDefaultState().withRotation(Rotation.CLOCKWISE_180));
                        }


                        //====キッチン=====================
                        for (int i = 0; i <5 ; i++) {
                            for (int j = 0; j < 2; j++) {
                                BlockPos pos = new BlockPos(posX + 7+i , posY + 1, posZ + 1);//キッチン
                                worldObj.setBlockState(pos, Blocks.QUARTZ_BLOCK.getDefaultState());
                                BlockPos pos2 = new BlockPos(posX + 7+i, posY + 4, posZ + 1);//換気扇
                                worldObj.setBlockState(pos2, Blocks.QUARTZ_BLOCK.getDefaultState());
                                BlockPos pos3 = new BlockPos(posX + 7+i, posY + 4, posZ + 2);//換気扇
                                worldObj.setBlockState(pos3, Blocks.IRON_TRAPDOOR.getDefaultState().withRotation(Rotation.CLOCKWISE_180).withProperty(OPEN,Boolean.TRUE));
                            }
                        }
                        for (int i = 0; i <1 ; i++) {
                            BlockPos pos = new BlockPos(posX + 7 , posY + 2, posZ + 1);//キッチン
                            worldObj.setBlockState(pos, Blocks.QUARTZ_BLOCK.getDefaultState());
                            BlockPos pos2 = new BlockPos(posX + 8, posY + 2, posZ + 1);//キッチン
                            worldObj.setBlockState(pos2, Blocks.BREWING_STAND.getDefaultState());
                            BlockPos pos5 = new BlockPos(posX + 10, posY + 1, posZ + 1);//キッチン
                            worldObj.setBlockState(pos5, Blocks.CAULDRON.getDefaultState());
                            BlockPos pos6 = new BlockPos(posX + 9, posY + 2, posZ + 1);//キッチン
                            worldObj.setBlockState(pos6, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultState());
                            BlockPos pos3 = new BlockPos(posX + 10, posY + 2, posZ + 1);//蛇口
                            worldObj.setBlockState(pos3, Blocks.TRIPWIRE_HOOK.getDefaultState().withRotation(Rotation.CLOCKWISE_180));
                        }
                        for (int i = 0; i < 2; i++) {
                            BlockPos pos3 = new BlockPos(posX + 7, posY + 1+i, posZ +2);//冷蔵庫
                            worldObj.setBlockState(pos3, Blocks.IRON_TRAPDOOR.getDefaultState().withRotation(Rotation.CLOCKWISE_180).withProperty(OPEN,Boolean.TRUE));
                        }


                    //===~=倉庫=========================
                        for (int i = 0; i <3; i++) {//床
                            for (int j = 0; j <3 ; j++) {
                                BlockPos pos3 = new BlockPos(posX + 5+i, posY + 0, posZ + 17+j);//蛇口
                                worldObj.setBlockState(pos3, Blocks.WOODEN_SLAB.getDefaultState());
                            }
                        }
                        for (int i = 0; i <2 ; i++) {
                            for (int j = 0; j <4 ; j++) {
                                BlockPos pos3 = new BlockPos(posX + 7, posY + 0+j, posZ + 17+i);//チェスト
                                worldObj.setBlockState(pos3, Blocks.CHEST.getDefaultState());
                                BlockPos pos4 = new BlockPos(posX + 5+i, posY + 0+j, posZ + 19);//チェスト
                                worldObj.setBlockState(pos4, Blocks.CHEST.getDefaultState());
                                BlockPos pos5 = new BlockPos(posX + 7, posY + 1+j, posZ +19);//あかり
                                worldObj.setBlockState(pos5, Blocks.END_ROD.getDefaultState());
                                BlockPos pos6 = new BlockPos(posX + 6, posY + 0, posZ + 18);//作業台
                                worldObj.setBlockState(pos6, Blocks.CRAFTING_TABLE.getDefaultState());
                            }
                        }

                    //========玄関
                        for (int i = 0; i <2 ; i++) {//下駄箱
                            for (int j = 0; j <7 ; j++) {
                                BlockPos pos3 = new BlockPos(posX + 2+i, posY + 0, posZ + 13+j);//床
                                worldObj.setBlockState(pos3, Blocks.WOODEN_SLAB.getDefaultState());
                            }
                            for (int j = 0; j <3 ; j++) {
                                BlockPos pos3 = new BlockPos(posX + 2+i, posY + 1+j, posZ + 19);//床
                                worldObj.setBlockState(pos3, Blocks.WOODEN_SLAB.getDefaultState());
                            }
                        }
                        for (int i = 0; i <5 ; i++) {
                            BlockPos pos3 = new BlockPos(posX +4, posY + 0, posZ + 13+i);//床
                            worldObj.setBlockState(pos3, Blocks.WOODEN_SLAB.getDefaultState());
                            BlockPos pos4 = new BlockPos(posX +1, posY + 0, posZ + 15);//床
                            worldObj.setBlockState(pos4, Blocks.PLANKS.getDefaultState());
                        }
                        for (int i = 0; i < 2; i++) {
                            BlockPos pos3 = new BlockPos(posX +2+i, posY +4 , posZ + 19);//床
                            worldObj.setBlockState(pos3, Blocks.END_ROD.getDefaultState());
                            BlockPos pos4 = new BlockPos(posX +2+i, posY +4 , posZ + 11);//床
                            worldObj.setBlockState(pos4, Blocks.END_ROD.getDefaultState());
                        }
                        for (int i = 0; i <3 ; i++) {
                            for (int j = 0; j < 2; j++) {


                                BlockPos pos3 = new BlockPos(posX + 2+j, posY + 1 + i, posZ + 11);//本棚
                                worldObj.setBlockState(pos3, Blocks.BOOKSHELF.getDefaultState());
                            }
                        }

                        for (int i = 0; i < 4; i++) {
                            BlockPos pos3 = new BlockPos(posX + 8, posY + 1 + i, posZ + 16);//本棚
                            worldObj.setBlockState(pos3, Blocks.GLASS.getDefaultState());
                        }
                        for (int i = 0; i < 2; i++) {
                            BlockPos pos3 = new BlockPos(posX + 8, posY + 2 + i*2, posZ + 17);//本棚
                            worldObj.setBlockState(pos3, Blocks.GLOWSTONE.getDefaultState());
                        }





                        //========-2回の装飾=================================
                        for (int i = 0; i < 8; i++) {//ふちの木
                            BlockPos pos = new BlockPos(posX + 17, posY + 6, posZ + 12 + i);//座標
                            worldObj.setBlockState(pos, Blocks.WOODEN_SLAB.getDefaultState());
                            BlockPos pos2 = new BlockPos(posX + 1, posY + 7, posZ + 12 + i);//座標
                            worldObj.setBlockState(pos2, Blocks.WOODEN_SLAB.getDefaultState());
                        }
                        int[] numbers7 = {17, 6, 12/**/, 17, 6, 19,/**/1, 7, 12,/**/1, 7, 19}; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む

                        for (int i = 0; i * 3 < numbers7.length; i++) {//
                            xi = numbers7[3 * i];
                            yi = numbers7[3 * i + 1];
                            zi = numbers7[3 * i + 2];
                            if (i == 0) {
                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.PLANKS.getDefaultState());//置くアイテム
                            }
                        }
                        int[] numbers = {10, 6, 14,/**/16, 6, 11}; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む
                        for (int i = 0; i * 3 < numbers.length; i++) {//2階のライト
                            xi = numbers[3 * i];
                            yi = numbers[3 * i + 1];
                            zi = numbers[3 * i + 2];

                            BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                            worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());//置くアイテム
                            // ↑アイテム選択
                        }
                        for (int i = 0; i < 8; i++) {
                            BlockPos pos = new BlockPos(posX + 1, posY + 6, posZ + 12 + i);//座標
                            worldObj.setBlockState(pos, Blocks.SNOW.getDefaultState());
                        }
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 3; j++) {
                                BlockPos pos = new BlockPos(posX + 6 + j, posY + 6 + i, posZ + 11);//座標
                                worldObj.setBlockState(pos, Blocks.GLASS_PANE.getDefaultState());
                            }
                        }
                        //====================================二回のライト==========
                        int[] number7 = {10, 5, 13,/**/10, 5, 12/**/, 10, 4, 13/**/, 10, 4, 12/**//**/}; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む
                        for (int i = 0; i * 3 < number7.length; i++) {//二階のライト
                            xi = number7[3 * i];
                            yi = number7[3 * i + 1];
                            zi = number7[3 * i + 2];
                            if (i == 0) {
                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());//置くアイテム
                            } else if (i == 1) {
                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());//置くアイテム
                            } else if (i == 2) {
                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.IRON_TRAPDOOR.getDefaultState().withProperty(HALF, BlockTrapDoor.DoorHalf.TOP));
                            } else if (i == 3) {
                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.IRON_TRAPDOOR.getDefaultState().withProperty(HALF, BlockTrapDoor.DoorHalf.TOP));
                            }
                        }
//ライト

                        for (int i = 0; i <8 ; i++) {
                            BlockPos pos = new BlockPos(posX + 15, posY , posZ + i+2);//ガラスの下ライト
                            worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());//
                            BlockPos pos2 = new BlockPos(posX + 1, posY+6 , posZ + i+12);//ガラスの下ライト
                            worldObj.setBlockState(pos2, Blocks.GLOWSTONE.getDefaultState());//
                        }

                        int[] numbers9 = {5,0,1,/**/6,0,1,/**/12,0,1,13,0,1,/**/8,16,2,8,16,9/**/}; //ここに置きたいブロックの着地点を{(x1,y1,z1),(x2,y2,z2),････････}として座標を打ち込む

                        for (int i = 0; i * 3 < numbers9.length; i++) {//
                            xi = numbers9[3 * i];
                            yi = numbers9[3 * i + 1];
                            zi = numbers9[3 * i + 2];
                            if (i == 0) {//1つめはそのままの向き
                                BlockPos pos = new BlockPos(posX + xi, posY + yi, posZ + zi);//座標
                                worldObj.setBlockState(pos, Blocks.GLOWSTONE.getDefaultState());//置くアイテム
                                // ↑アイテム選択
                            }
                        }


//===========パーティクル========================================================================

                        int x = result.getBlockPos().getX();
                        int y = result.getBlockPos().getY();
                        int z = result.getBlockPos().getZ();
                        for (int m = 0; m <2 ; m++) {
                            for (int i = 0; i < 2; i++) {
                                for (int j = 0; j < 13; j++) {
                                    for (int k = 0; k < 23; k++) {
                                        double random1 = Math.random();
                                        this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, posX + -i, posY + j + 0.5D, posZ + k + 1, 0.05D - random1 / 10, 0.01D, 0.05D - random1 / 10, new int[0]);
                                        this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, posX - 1 + i, posY + j + 0.5D, posZ + k + 1, 0.05D - random1 / 10, 0.01D, 0.05D - random1 / 10, new int[0]);
                                        this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, posX + -i, posY + j + 0.5D, posZ + k + 1, 0.0D - random1 / 8, 0.0D + random1 / 10, 0.05D - random1 / 10, new int[0]);

                                        this.worldObj.spawnParticle(EnumParticleTypes.END_ROD, posX + -i, posY + j + 0.5D, posZ + k - 1, 0.0D - random1 / 4, 0.01D, 0.05D - random1 / 10, new int[0]);
                                        this.worldObj.spawnParticle(EnumParticleTypes.END_ROD, posX - 1 + i, posY + j + 0.5D, posZ + k - 1, 0.0D - random1 / 4, 0.01D, 0.05D - random1 / 10, new int[0]);
                                    }
                                }
                            }
                        }
                }
//====================================================================================-


            }else if (result.typeOfHit == RayTraceResult.Type.ENTITY){
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this,getThrower()),DAMAGE);
            }
            for(int i=0;i<8;i++) {
                setDead();
            }
            super.onImpact(result);
        }
}

