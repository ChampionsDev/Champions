package net.dawnfirerealms.legends.library.level;

import net.dawnfirerealms.legends.library.restriction.Restrictable;


/**
 * @author YoshiGenius
 */
public class Exp extends Number implements Restrictable {
    
    private double exp;
    
    public Exp(double exp) {
        this.exp = exp;
    }

    public Exp() {
        this.exp = 0;
    }

    public Exp set(double exp) {
        this.exp = exp;
        return this;
    }

    public Exp add(double exp) {
        this.exp += exp;
        return this;
    }

    @Override
    public int intValue() {
        return Math.round(Math.round(exp));
    }

    @Override
    public long longValue() {
        return Math.round(exp);
    }

    @Override
    public float floatValue() {
        return Math.round(exp);
    }

    @Override
    public double doubleValue() {
        return exp;
    }

}