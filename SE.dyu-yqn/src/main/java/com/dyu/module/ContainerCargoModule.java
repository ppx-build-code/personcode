package com.dyu.module;

import com.dyu.domain.ContainerModuleDTO;
import com.dyu.domain.ReqDTO;
import com.dyu.segment.CargoSegment;

import java.util.Collection;
import java.util.List;

/**
 * @author dyu 2019/12/27 15:01
 */
public class ContainerCargoModule implements CargoModule<ContainerModuleDTO> {
    private List<CargoSegment> segments;

    public ContainerCargoModule(List<CargoSegment> segments) {
        this.segments = segments;
    }

    @Override
    public ContainerModuleDTO composite() {
        return null;
    }
}
