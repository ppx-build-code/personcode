package com.dyu.segment;

import com.dyu.domain.ReqDTO;

import java.util.List;

/**
 * @author dyu 2019/12/27 15:03
 */
public class ShipPlanCargoSegment extends AbstractCargoSegment<ShipPlanCargoSegment, ReqDTO> {
    private ReqDTO req;

    public ShipPlanCargoSegment(ReqDTO req) {
        this.req = req;
    }

    @Override
    protected List<ShipPlanCargoSegment> doListReq(ReqDTO req) {
        return null;
    }

    @Override
    protected ShipPlanCargoSegment doGetReq(ReqDTO req) {
        return null;
    }
}
