package com.dyu.segment;

import com.dyu.domain.ReqDTO;

import java.util.List;

/**
 * @author dyu 2019/12/28 11:27
 */
public abstract class AbstractCargoSegment<T, E extends ReqDTO> implements CargoSegment<T, E> {

    @Override
    public T get(E req) {
        return doGetReq(req);
    }

    @Override
    public List<T> list(E req) {
        return doListReq(req);
    }

    protected abstract List<T> doListReq(E req);

    protected abstract T doGetReq(E req);
}
