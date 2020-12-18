package com.dyu.segment;

import com.dyu.domain.ReqDTO;

import java.util.List;
import java.util.Map;

/**
 * @author dyu 2019/12/27 15:02
 */
public interface CargoSegment<T,E extends ReqDTO> {

    //Map<String, T> get(E req);

    T get(E req);

    List<T> list(E req);


}
