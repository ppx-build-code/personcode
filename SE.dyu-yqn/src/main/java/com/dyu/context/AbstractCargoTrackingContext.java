package com.dyu.context;

import com.dyu.domain.ReqDTO;
import com.dyu.module.CargoModule;
import com.dyu.segment.CargoSegment;
import com.dyu.segment.ContainerCargoSegment;
import com.dyu.segment.ShipPlanCargoSegment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyu 2019/12/27 13:51
 */
public abstract class AbstractCargoTrackingContext<E> implements CargoContext {

    private List<CargoModule> modules;
    private List<CargoSegment> segments;
    private ReqDTO req;
    private boolean isLoad;


    public AbstractCargoTrackingContext(ReqDTO req) {
        this.req = req;
    }


    public void load() {

        // valid need param

        // get all segment


        // assembly

        // set modules
    }

    private void doServices() {

        List<CargoSegment> segments = new ArrayList<>();

        ShipPlanCargoSegment shipPlanCargoSegment = new ShipPlanCargoSegment(req);
        shipPlanCargoSegment.get(req);
        segments.add(shipPlanCargoSegment);

        // ...

        this.segments = segments;
    }

    public void validate() {

        // validate modules. filter
    }

    public abstract E assembly();

    @Override
    public <T> T get(Class<T> cla) {
        return null;
    }


}
