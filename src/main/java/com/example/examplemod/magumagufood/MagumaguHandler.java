package com.example.examplemod.magumagufood;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.example.examplemod.ExampleMod.itemMagumagu;

public class MagumaguHandler {

    private final  Minecraft mc=Minecraft.getMinecraft();
    public static Item itemMagumagu = new MagumaguFood();

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void renderWorldLastEvent(RenderWorldLastEvent event){

        EntityPlayer player = mc.thePlayer;
        World world= mc.theWorld;

        if(player.getHeldItemMainhand() == null && player.isBurning()== false) {
            return;
        }


        IBlockState lavaBlockState = Blocks.LAVA.getDefaultState();
        if(player.getHeldItemMainhand().getItem() == Items.BONE){
            for (int i = 0; i < 5; i++) {
                BlockPos lavaPos = new BlockPos(player.posX,player.posY,player.posZ + 5 + i);
                world.setBlockState(lavaPos, lavaBlockState);
            }
        }

        BlockPos pos = player.getPosition().add(0, -1, 0);
        if(player.isBurning()==true) {

            if (world.getBlockState(pos).getBlock() != Blocks.AIR) {
                world.setBlockState(pos, Blocks.MAGMA.getDefaultState());
                for (int i = 0; i <3 ; i++) {
                    for (int j = 0; j <3 ; j++) {
                        world.setBlockState(pos.add(-i, 0, -i), Blocks.MAGMA.getDefaultState());
                    }
                }
//                for (int i = -1; i < 2; i = i + 2) {
//                    world.setBlockState(pos.add(i, 0, i), Blocks.LAVA.getDefaultState());
//                    world.setBlockState(pos.add(i, 0, -i), Blocks.LAVA.getDefaultState());
//
//
//                }
            }
        }
    }
}
