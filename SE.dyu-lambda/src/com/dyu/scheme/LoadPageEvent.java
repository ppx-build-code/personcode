package com.dyu.scheme;

import java.util.EventObject;

/**
 * @author dyu 2019.04.29
 */
public class LoadPageEvent extends EventObject {

    private int id;

    public static final int PAGELOAD_SUCCESS = 1;
    public static final int PAGELOAD_ERROR = 2;
    public static final int PAGELOAD_START = 3;
    public static final int PAGELOAD_CLOSE = 4;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public LoadPageEvent(Object source) {
        super(source);
    }

    public LoadPageEvent(Object source, int id) {
        super(source);

        switch (id) {
            case PAGELOAD_SUCCESS: this.id = PAGELOAD_SUCCESS; break;
            case PAGELOAD_ERROR: this.id = PAGELOAD_ERROR; break;
            case PAGELOAD_START: this.id = PAGELOAD_START; break;
            case PAGELOAD_CLOSE: this.id = PAGELOAD_CLOSE; break;
        }
    }

    public int getId() {
        return id;
    }
}
