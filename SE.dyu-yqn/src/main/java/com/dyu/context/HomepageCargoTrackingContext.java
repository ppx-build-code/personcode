package com.dyu.context;

import com.dyu.domain.ReqDTO;
import com.dyu.domain.RespDTO;

/**
 * @author dyu 2019/12/27 13:54
 */
public class HomepageCargoTrackingContext extends AbstractCargoTrackingContext<RespDTO> {

    public HomepageCargoTrackingContext(ReqDTO req) {
        super(req);
    }

    @Override
    public RespDTO assembly() {
        return null;
    }
}
