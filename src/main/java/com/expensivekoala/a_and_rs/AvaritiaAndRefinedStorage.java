package com.expensivekoala.a_and_rs;

import com.expensivekoala.a_and_rs.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = AvaritiaAndRefinedStorage.MODID, name = AvaritiaAndRefinedStorage.MODNAME ,version = AvaritiaAndRefinedStorage.VERSION, dependencies = AvaritiaAndRefinedStorage.DEPENDENCIES)
public class AvaritiaAndRefinedStorage {
    public static final String MODID = "a_and_rs";
    public static final String MODNAME = "Avaritia and Refined Storage";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required-after:refinedstorage;required-after:avaritia";

    @SidedProxy(clientSide = "com.expensivekoala.a_and_rs.proxy.ClientProxy", serverSide = "com.expensivekoala.a_and_rs.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static AvaritiaAndRefinedStorage instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}