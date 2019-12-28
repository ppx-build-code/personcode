package com.dyu.module;

import com.dyu.domain.ReqDTO;
import com.dyu.segment.CargoSegment;

import java.util.Collection;

/**
 * @author dyu 2019/12/27 15:02
 */
public interface CargoModule<T> {

    T composite();
}
