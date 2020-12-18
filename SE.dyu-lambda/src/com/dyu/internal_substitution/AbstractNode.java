package com.dyu.internal_substitution;

public interface AbstractNode<A, B> {
    B getVal();

    A getKey();

    void add(A key, B val);
}
