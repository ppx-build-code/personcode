package com.dyu.scheme;

import java.util.EventObject;

/**
 * @author dyu 2019.04.29
 */
public class ClickEvent extends EventObject {

    private int id;

    public static final int SINGLE_CLICK = 1;
    public static final int DOUBLE_CLICK = 2;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ClickEvent(Object source) {
        super(source);
    }

    public ClickEvent(Object source, int id) {
        super(source);

        switch (id) {
            case SINGLE_CLICK: this.id = id; break;
            case DOUBLE_CLICK: this.id = id; break;
        }
    }

    public int getId() {
        return id;
    }
}
