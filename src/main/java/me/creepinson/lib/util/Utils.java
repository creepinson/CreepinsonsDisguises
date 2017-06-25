package me.creepinson.lib.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.creepinson.lib.util.render.RenderHelper;

public class Utils {

	
//MAIN MOD STUFF
    public static final String MODID = "creepzdisguises";
    public static final String VERSION = "Beta";
 
    public static final String SEVERPROXY = "me.creepinson.lib.proxy.CommonProxy";
    public static final String CLIENTPROXY = "me.creepinson.lib.proxy.ClientProxy";
    
//END MAIN MOD STUFF
	
	private static Logger logger;
	
	public static Logger getLogger(){
		
		if(logger == null){
			logger = LogManager.getFormatterLogger(MODID);
		}
		
		return logger;
		
	}
    
    
}
