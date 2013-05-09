package com.github.legendsdev.legends.library.misc;

/**
 *
 * @author YoshiGenius
 */
public interface Measurable<T> extends Comparable<T> {
    
    /**
     * Calculates the maximum object between the .
     * @param other The other object.
     * @return 
     */
    public T max(T other);
    public T min(T other);

}
