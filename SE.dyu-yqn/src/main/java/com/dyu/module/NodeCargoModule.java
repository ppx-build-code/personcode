package com.dyu.module;

import com.dyu.domain.NodeModuleDTO;
import com.dyu.segment.CargoSegment;

import java.util.List;

/**
 * @author dyu 2019/12/27 14:09
 */
public class NodeCargoModule implements CargoModule<NodeModuleDTO>{

    private List<CargoSegment> segments;

    public NodeCargoModule(List<CargoSegment> segments) {
        this.segments = segments;
    }

    @Override
    public NodeModuleDTO composite() {
        return null;
    }
}
