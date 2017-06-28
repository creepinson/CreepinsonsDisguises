package me.creepinson.core;
import java.util.Random;
import java.util.concurrent.Callable;

import me.creepinson.capability.Disguise;
import me.creepinson.capability.DisguiseStorage;
import me.creepinson.capability.IDisguise;
import me.creepinson.handler.KeysHandler;
import me.creepinson.lib.proxy.CommonProxy;
import me.creepinson.lib.util.Utils;
import me.creepinson.packet.CreepPacket;
import me.creepinson.packet.PacketHandler;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
@Mod(modid = Utils.MODID, version = Utils.VERSION)
public class CreepzDisguises
{
	 
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("mechannel");

	@SidedProxy(serverSide = Utils.SEVERPROXY, clientSide = Utils.CLIENTPROXY)
public static CommonProxy proxy;

public int movingBlockID;
@Mod.Instance(Utils.MODID)
public static CreepzDisguises instance;
 
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	int entityID = MathHelper.getRandomUUID().hashCode();
    	movingBlockID = entityID;

     	Utils.getLogger().info("Pre Init");
    	
    
    	proxy.preInit();
    	proxy.registerRenderers();
    
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        INSTANCE.registerMessage(PacketHandler.class, CreepPacket.class, 0, Side.SERVER);
        CapabilityManager.INSTANCE.register(IDisguise.class, new DisguiseStorage(),  Disguise.class);
    	Utils.getLogger().info("Init");
    	MinecraftForge.EVENT_BUS.register(new me.creepinson.handler.event.EventHandler());
    	FMLCommonHandler.instance().bus().register(new KeysHandler());
    	proxy.init();

    }

public static class DisguiseFactory implements Callable<Disguise> 
{
@Override
public Disguise call() throws Exception 
{
	return new Disguise();
}
}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
      
     	Utils.getLogger().info("Post Init");
    	
    	proxy.postInit();
    	
    }

    public static void registerEntity(Class entityClass, String name, int ID, int color1, int color2){
        
        
    long seed = name.hashCode();
    Random rand = new Random(seed);
    int primaryColor = rand.nextInt() * 16777215;
    int secondaryColor = rand.nextInt() * 16777215;

    EntityRegistry.registerModEntity(entityClass, name, ID, instance, 64, 10, true, color1, color2);
    }
    public static void registerEntityNoEgg(Class entityClass, String name, int ID){
        
        
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        EntityRegistry.registerModEntity(entityClass, name, ID, instance, 64, 10, true);

	}
    
    
}
