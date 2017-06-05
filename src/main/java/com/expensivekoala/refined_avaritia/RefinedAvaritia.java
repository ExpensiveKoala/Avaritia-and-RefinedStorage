package com.expensivekoala.refined_avaritia;

import com.expensivekoala.refined_avaritia.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Logger;

@Mod(modid = RefinedAvaritia.MODID, name = RefinedAvaritia.MODNAME ,version = RefinedAvaritia.VERSION, dependencies = RefinedAvaritia.DEPENDENCIES)
public class RefinedAvaritia {
    public static final String MODID = "refined_avaritia";
    public static final String MODNAME = "Refined Avaritia";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required-after:refinedstorage;required-after:avaritia";

    @SidedProxy(clientSide = "com.expensivekoala.refined_avaritia.proxy.ClientProxy", serverSide = "com.expensivekoala.refined_avaritia.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static RefinedAvaritia instance;

    public static Logger logger;

    public SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

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
