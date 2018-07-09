package com.example.examplemod;

import com.example.examplemod.magumagufood.MagumaguFood;
import com.example.examplemod.magumagufood.MagumaguHandler;
import com.example.examplemod.mc_02_myblock.MYBlock;
import com.example.examplemod.mc_03_myitem.ItemMySword;
import com.example.examplemod.mc_03_myitem.ItemOnigiri;
import com.example.examplemod.mc_04_rainbowblock.BlockRainbow;
import com.example.examplemod.mc_05_soundblock.BlockSound;
import com.example.examplemod.mc_07_redstone.BlockRedstoneClock;
import com.example.examplemod.mc_07_redstone.BlockRedstoneInput;
import com.example.examplemod.mc_09_footprints_sand.BlockFootprintsSand;
import com.example.examplemod.mc_10_biome.BiomeIceberg;
import com.example.examplemod.mc_10_biome.BiomeMyBiome;
import com.example.examplemod.mc_11_explosive_arrow.EntityExplosiveArrow;
import com.example.examplemod.mc_11_explosive_arrow.ItemExplosiveArrow;
import com.example.examplemod.mc_11_explosive_arrow.RenderExplosiveArrow;
import com.example.examplemod.mc_12_bull_fighting.EntityBull;
import com.example.examplemod.mc_12_bull_fighting.RenderBull;
import com.example.examplemod.mc_13_tobisuke.EntityTobisuke;
import com.example.examplemod.mc_13_tobisuke.RenderTobisuke;
import com.example.examplemod.houcecapsule.BlockVillagersNose;
import com.example.examplemod.houcecapsule.Entityhouse_cupsule;
import com.example.examplemod.houcecapsule.house_cupsule;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
//02_MyBlock
    public static Block blockMyBlock =new MYBlock();
//03_MyItem
    public static Item itemMySword = new ItemMySword();
    public static Item itemOnigiri = new ItemOnigiri();
    public static Item itemMagumagu = new MagumaguFood();
//04_Rainbowblock
    public static Block blockRainbow = new BlockRainbow();
//05_sound
    public static Block blockSound = new BlockSound();
    public static SoundEvent[] soundEvents = {
            new SoundEvent(new ResourceLocation(MODID, "sound1")),
            new SoundEvent(new ResourceLocation(MODID, "sound2")),
            new SoundEvent(new ResourceLocation(MODID, "sound3")),
    };
//07_redstone
    public static Block blockRedstoneInput = new BlockRedstoneInput();
    public static Block blockRedstoneClock = new BlockRedstoneClock();
//08_雪合戦
//    public static Item itemMySnowball = new ItemMySnowball();
//09_footprint_sand
    public static Block blockFootprintsSand = new BlockFootprintsSand();
//10_biome
    public static BiomeManager.BiomeEntry myBiomeEntry = new BiomeManager.BiomeEntry(new BiomeMyBiome(),30);
    public static BiomeManager.BiomeEntry icebergBiomeEntry = new BiomeManager.BiomeEntry(new BiomeIceberg(),30);
//11爆発矢
    public static Item itemExplosiveArrow = new ItemExplosiveArrow();
//オリジナル　カプセルハウス
    public static Item house_cupsule= new house_cupsule();//インスタンス化
//オリジナル　村人の鼻
    public static Block BlockVillagersNose= new BlockVillagersNose();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        boolean isClient = event.getSide().isClient();
//        registerRecipe();
        registerBlock(blockMyBlock, isClient);
//        registerBlock(blockRainbow, isClient);
        registerMyItem(isClient);
//        registerSoundBlock(isClient);
//        registerRedstone(isClient);
////        registerSnowballFight(isClient);
////        registerSnowballFightRenderer();
//        registerFootprintsSand(isClient);
//        registerBiome();
//        registerExplosiveArrow(isClient);
//        registerExplosiveArrowRenderer();
//        registerBull();
//        registerBullRenderer();
//        registerTobisuke();
//        registerTobisukeRenderer();
        registerhouse_cupsuleFight(isClient);
        registerhouse_cupsuleFightRenderer();
        registerVillagersNose(isClient);

//        registerDrawLineEvent();
        registerMagumaguHandler();


    }
    //==課題１===========================
    private void registerRecipe(){
        GameRegistry.addRecipe(new ItemStack(Blocks.DIAMOND_BLOCK),
                "AAA",
                "AAA",
                "AAA",
                'A', new ItemStack(Blocks.DIRT));

        NBTTagCompound creeperId =new NBTTagCompound();
        creeperId.setString("id","Creeper");
        ItemStack creeperSpawnEgg =new ItemStack(Items.SPAWN_EGG);
        creeperSpawnEgg.setTagInfo("EntityTag",creeperId);
        GameRegistry.addRecipe(creeperSpawnEgg,
                " A ",
                "CBC",
                "CBC",
                'A', new ItemStack(Items.SKULL, 1, 4),
                'B',new ItemStack(Blocks.TNT),
                'C',new ItemStack(Items.GUNPOWDER));
        }
//========課題２===============
    private void registerMyBlock(boolean isClient) {
        ItemBlock itemBlock = new ItemBlock(blockMyBlock);

        GameRegistry.register(blockMyBlock);
        GameRegistry.register(itemBlock,blockMyBlock.getRegistryName());

        if(isClient) {
            ModelResourceLocation modelName =new ModelResourceLocation(blockMyBlock.getRegistryName(),"inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlock,0,modelName);
        }

    }
//========課題３=======================================
    private void registerMyItem(boolean isClient) {
        GameRegistry.register(itemMySword);

        if (isClient) {
            ModelResourceLocation modelName =new ModelResourceLocation(itemMySword.getRegistryName(),"inventory");
            ModelLoader.setCustomModelResourceLocation(itemMySword,0,modelName);
        }

        GameRegistry.register(itemOnigiri);

        if (isClient){
            ModelResourceLocation modelName =new ModelResourceLocation(itemOnigiri.getRegistryName(),"inventory");
            ModelLoader.setCustomModelResourceLocation(itemOnigiri,0,modelName);
        }
        GameRegistry.register(itemMagumagu);

        if (isClient){
            ModelResourceLocation modelName =new ModelResourceLocation(itemMagumagu.getRegistryName(),"inventory");
            ModelLoader.setCustomModelResourceLocation(itemOnigiri,0,modelName);
        }

    }
//======課題5sound======================
    @EventHandler
    public void Init(FMLInitializationEvent event){
//        registerWoodCut();//課題６
        }
        private void registerSoundBlock(boolean isClient) {
        ItemBlock itemBlock = new ItemBlock(blockSound);

        GameRegistry.register(blockSound);
        GameRegistry.register(itemBlock,blockSound.getRegistryName());
        for (int i=0;i<soundEvents.length; i++) {
            GameRegistry.register(soundEvents[i], soundEvents[i].getSoundName());
        }

        if(isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(blockSound.getRegistryName(),"inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlock,0,modelName);
        }
        }
//=====---課題６木こりmod==============-
//     private void registerWoodCut(){
//         MinecraftForge.EVENT_BUS.register(new BlockBreakEventHandler());
//     }
//========課題７redstone================-
    private void registerRedstone(boolean isClient) {
        ItemBlock itemBlockInput = new ItemBlock(blockRedstoneInput);

        GameRegistry.register(blockRedstoneInput);
        GameRegistry.register(itemBlockInput, blockRedstoneInput.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(blockRedstoneInput.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlockInput, 0, modelName);
        }

        ItemBlock itemBlockClock = new ItemBlock(blockRedstoneClock);

        GameRegistry.register(blockRedstoneClock);
        GameRegistry.register(itemBlockClock, blockRedstoneClock.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(blockRedstoneClock.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlockInput, 0, modelName);
        }
    }
//課題08＿雪合戦==========================================
//    private void registerSnowballFight(boolean isClient){
//        GameRegistry.register(itemMySnowball);
//
//        if(isClient){
//            ModelResourceLocation modelName = new ModelResourceLocation(Items.SNOWBALL.getRegistryName(),"inventory");
//            ModelLoader.setCustomModelResourceLocation(itemMySnowball,0,modelName);
//        }
//
//        EntityRegistry.registerModEntity(EntityMySnowball.class,"my_snowball",EntityMySnowball.ENTITY_ID,this,10,10,true);
//    }
//    private void registerSnowballFightRenderer(){
//        RenderingRegistry.registerEntityRenderingHandler(EntityMySnowball.class, new IRenderFactory<EntityMySnowball>() {
//            @Override
//            public Render<? super EntityMySnowball>createRenderFor(RenderManager manager){
//                return new RenderSnowball<EntityMySnowball>(manager,Items.SNOWBALL, Minecraft.getMinecraft().getRenderItem());
//            }
//        });
//    }
//課題09足跡砂=======================================
    private void registerFootprintsSand(boolean isClient){
        ItemBlock itemBlock = new ItemBlock(blockFootprintsSand);

        GameRegistry.register(blockFootprintsSand);
        GameRegistry.register(itemBlock,blockFootprintsSand.getRegistryName());

        if(isClient){
            ModelResourceLocation modelName = new ModelResourceLocation(blockFootprintsSand.getRegistryName(),"inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlock,0,modelName);

        }
    }
//===課題10バイオーム=============
    private void  registerBiome(){
       // GameRegistry.registerWorldGenerator(new MyWorldGenerator(blockMyBlock,1000),1);

        BiomeManager.oceanBiomes.clear();
        BiomeProvider.allowedBiomes.clear();

        Biome.registerBiome(40,"mybiome",myBiomeEntry.biome);
        BiomeManager.addSpawnBiome(myBiomeEntry.biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT,myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY,myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,myBiomeEntry);

        Biome.registerBiome(41,"iceberg",icebergBiomeEntry.biome);
        BiomeManager.addSpawnBiome(icebergBiomeEntry.biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,icebergBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT,icebergBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY,icebergBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,icebergBiomeEntry);

    }


//===============課題11爆発する矢=================================================-
    private void registerExplosiveArrow(boolean isClient){
        GameRegistry.register(itemExplosiveArrow);
        EntityRegistry.registerModEntity(EntityExplosiveArrow.class,
                "explosive_arrow", EntityExplosiveArrow.ENTITY_ID,this,10,10,true);

        if(isClient){
            ModelResourceLocation modelName =
                    new ModelResourceLocation(itemExplosiveArrow.getRegistryName(),"iventory");
            ModelLoader.setCustomModelResourceLocation(itemExplosiveArrow,0,modelName);
        }
    }

    private void registerExplosiveArrowRenderer(){

        RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class,
                new IRenderFactory<EntityExplosiveArrow>(){
            @Override
                    public Render<? super EntityExplosiveArrow>createRenderFor(RenderManager manager){
                return new RenderExplosiveArrow(manager);
            }
                });
    }

//===========課題11闘牛========================
    private void registerBull(){
        EntityRegistry.registerModEntity(EntityBull.class,"bull",EntityBull.ENTITY_ID,this,10,10,true,0xFFFF00,0xFF0000);
        }

        private void registerBullRenderer(){
        RenderingRegistry.registerEntityRenderingHandler(EntityBull.class, RenderBull::new);
        }
//======課題１２トビスケ==================================-
    private void registerTobisuke(){
        EntityRegistry.registerModEntity(
                EntityTobisuke.class,"tobisuke",
                EntityTobisuke.ENTITY_ID,
                this,10,10,true,
                0xFF0000,0x00FF00
        );
    }

    private void registerTobisukeRenderer(){
        RenderingRegistry.registerEntityRenderingHandler(
                EntityTobisuke.class,
                RenderTobisuke::new
        );
    }


//=========カプセルハウス==================
    private void registerhouse_cupsuleFight(boolean isClient){
        GameRegistry.register(house_cupsule);//登録

        if(isClient){
            ModelResourceLocation modelName = new ModelResourceLocation(house_cupsule.getRegistryName(),"inventory");
            ModelLoader.setCustomModelResourceLocation(house_cupsule,0,modelName);
        }

        EntityRegistry.registerModEntity(Entityhouse_cupsule.class,"house_cupsule",Entityhouse_cupsule.ENTITY_ID,this,10,10,true);
    }
    private void registerhouse_cupsuleFightRenderer(){
        RenderingRegistry.registerEntityRenderingHandler(Entityhouse_cupsule.class, new IRenderFactory<Entityhouse_cupsule>() {
            @Override
            public Render<? super Entityhouse_cupsule>createRenderFor(RenderManager manager){
                return new RenderSnowball<Entityhouse_cupsule>(manager,house_cupsule, Minecraft.getMinecraft().getRenderItem());
            }
        });
    }


//======村人の鼻=================
    private void registerVillagersNose(boolean isClient){
        ItemBlock itemBlock = new ItemBlock(BlockVillagersNose);

        GameRegistry.register(BlockVillagersNose);
        GameRegistry.register(itemBlock,BlockVillagersNose.getRegistryName());

        if(isClient) {
            ModelResourceLocation modelName =new ModelResourceLocation(BlockVillagersNose.getRegistryName(),"inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlock,0,modelName);
        }

    }
    //====================================
//    private void registerDrawLineEvent(){
//        MinecraftForge.EVENT_BUS.register(new DrawLineEventHandler());
//    }
    //==================
    private void registerMagumaguHandler(){
        MinecraftForge.EVENT_BUS.register(new MagumaguHandler());

    }



    // ======================================================================================================
    // ここから下はいじらないよ！

    private void registerBlock(Block block, boolean isClient) {
        ItemBlock itemBlockInput = new ItemBlock(block);

        GameRegistry.register(block);
        GameRegistry.register(itemBlockInput, block.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlockInput, 0, modelName);
        }
    }

    private void registerItem(Item item, boolean isClient) {
        GameRegistry.register(item);
        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelName);
        }
    }
}
