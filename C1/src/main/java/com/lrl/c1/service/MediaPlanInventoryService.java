/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.wrapper.AdunitsData;
import com.lrl.c1.wrapper.PublisherData;
import java.util.List;

/**
 *
 * @author logic
 */
public interface MediaPlanInventoryService {

    public List<PublisherData> getGroupofPlcList(Integer pubid);

    public List<PublisherData> getGroupofAdUnitList(Integer plcid, Integer pubid);

    public List<AdunitsData> getSubAdUnitList(Integer id, Integer flag);

    public Integer AddToLine(Integer mpid, Integer pubid, Integer adunitid, Integer plcid, Integer parauid, Integer flag);

    public boolean invokePlaceIO(Integer mpid);

    public List<PublisherData> getListofParentFromPlacementsAndAdunits(Integer pubid, String catid);

    public List<AdunitsData> getChildFromPlacementsAndAdunits(Integer placementid, Integer adunitid, String plctypeid);
}
