package org.datastr.visitor;

/**
 * 
 * @author Lennarth Anaya
 *
 * @param <V> type of elements the Tree can contain.
 */
@FunctionalInterface
public interface DataVisitor<T> {
    void visited(T element);
}
