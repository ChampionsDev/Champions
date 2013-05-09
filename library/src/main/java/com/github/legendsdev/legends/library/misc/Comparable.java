package com.github.legendsdev.legends.library.misc;

/**
 *
 * @author YoshiGenius
 */
public interface Comparable<T> {
    
    /**
     * Checks if the provided object is greater than the given object.
     * @param other The other object to compare with this one.
     * @return True if this object is greater.
     */
    public boolean greaterThan(T other);
    
    /**
     * Checks if the provided object is less than the given object.
     * @param other The other object to compare with this one.
     * @return True if this object is less.
     */
    public boolean lessThan(T other);
    
    /**
     * Checks if the provided object is equal to the given object.
     * @param other The other object to compare with this one.
     * @return True if the objects are equal.
     */
    public boolean isEqualTo(T other);

}
