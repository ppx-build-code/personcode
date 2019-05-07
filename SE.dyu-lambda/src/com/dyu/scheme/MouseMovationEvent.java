package com.dyu.scheme;

import java.util.EventObject;

/**
 * @author dyu 2019.04.29
 */
public class MouseMovationEvent extends EventObject {

    private int id;

    public static final int LEFT_MOVATION = 1;
    public static final int RIGHT_MOVATION = 2;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MouseMovationEvent(Object source) {
        super(source);
    }

    public MouseMovationEvent(Object source, int id) {
        super(source);

        switch (id) {
            case LEFT_MOVATION: this.id = id; break;
            case RIGHT_MOVATION: this.id = id; break;
        }
    }

    public int getId() {
        return id;
    }
}
