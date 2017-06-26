package me.creepinson.capability;

public class Disguise  implements IDisguise
{
    protected int id = 0;

    @Override
    public int getID() 
    {
        return id;
    }

    @Override
    public void setID(int id) 
    {
        this.id = id;
    }
}