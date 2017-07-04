package me.creepinson.capability;

import java.util.concurrent.Callable;

public class DisguiseFactory implements Callable<Disguise> 
{
    
    @Override
    public Disguise call() throws Exception 
    {
        return new Disguise();
    }
    
}

