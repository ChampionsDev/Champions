package net.dawnfirerealms.legends.library;

/**
 * @author YoshiGenius
 */
public abstract class BasicHandler {
    
    public abstract void registerOption(String option, Registrable registrable);
    
    public abstract Registrable getOption(String option);

}