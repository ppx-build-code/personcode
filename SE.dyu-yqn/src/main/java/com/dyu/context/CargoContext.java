package com.dyu.context;

/**
 * @author dyu 2019/12/27 13:51
 */
public interface CargoContext {

    <T> T get(Class<T> cla);
}
