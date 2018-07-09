package com.example.examplemod.DrawLine;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class DrawLineEventHandler {
    private final int SEARCH_RANGE = 40;
    private final  Minecraft mc=Minecraft.getMinecraft();

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void renderWorldLastEvent(RenderWorldLastEvent event){
        if(mc.thePlayer.getHeldItemMainhand()==null) {
            return;
        }

        if(mc.thePlayer.getHeldItemMainhand().getItem()== Items.STICK) {
            drawLineFromPlayerToEntity(event);
        }
    }

    private void drawLineFromPlayerToEntity(RenderWorldLastEvent event){
        //敵などの検索
        AxisAlignedBB boundingBox =new AxisAlignedBB(
                mc.thePlayer.posX - SEARCH_RANGE/2,
                mc.thePlayer.posY - SEARCH_RANGE/2,
                mc.thePlayer.posZ - SEARCH_RANGE/2,
                mc.thePlayer.posX + SEARCH_RANGE/2,
                mc.thePlayer.posY + SEARCH_RANGE/2,
                mc.thePlayer.posZ + SEARCH_RANGE/2
                );
        List<EntityLiving> list =mc.theWorld.getEntitiesWithinAABB(EntityLiving.class,boundingBox);
//       for (int i = 0; i <list.size() ; i++) {
//            EntityLiving aroundEntity= list.get(i);
//            //aroundEntity.posX;
//            //mc.thePlayer.posX
            GL11.glPushMatrix();
            //初期設定
            GL11.glLineWidth(1.5f);
            GL11.glEnable(GL11.GL_LINE_SMOOTH);//滑らか
            GL11.glEnable(GL11.GL_DEPTH_TEST);//これがないと上をすべる
            GL11.glTranslated(-1*mc.thePlayer.posX,-1*mc.thePlayer.posY,-1*mc.thePlayer.posZ);//プレイヤーの
            GL11.glColor3ub((byte)100,(byte)255,(byte)100);//色の変化
            GL11.glEnable(GL11.GL_LIGHTING);
            //操作


            GL11.glBegin(GL11.GL_LINE_STRIP);//描写はじめ

            GL11.glVertex3d(mc.thePlayer.posX-10.0f,mc.thePlayer.posY,mc.thePlayer.posZ+10.0f);//開始位置の設定
            GL11.glVertex3d(mc.thePlayer.posX+10.0f,mc.thePlayer.posY,mc.thePlayer.posZ+10.0f);//開始位置の設定

//            GL11.glVertex3d(aroundEntity.posX,aroundEntity.posY,aroundEntity.posZ);//終了位置
//
            GL11.glEnd();//描写終了


            GL11.glPopMatrix();
//        }
   }
}
