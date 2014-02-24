/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Invtargeting;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.wrapper.CreativeData;
import com.lrl.c1.wrapper.CreativelistData;
import com.lrl.c1.wrapper.GraphData;
import com.lrl.c1.wrapper.MediaplanData;
import com.lrl.c1.wrapper.PublisherData;
import com.lrl.c1.wrapper.UploadData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author logic
 */
public interface MediaPlanCreationService {

    public Mediaplan createNewMediaPlan(Mediaplan mediaplan);

    public List<Invtargeting> lineList(Integer mpid, Integer lineid);

    public List<Publisher> getPublisherList();

    public List<Adunits> publishersAdunitsList(Integer pubId, Integer mplid);

    public List<Adunits> publishersSubAdunitsList(Integer mplid, Integer publisherId, Integer adunitId);

    public Map<String, Integer> getInventorySelected(Integer mpid);

    public Integer getPublisherImpressions(Integer mpid, Integer pubid);

    public Integer getPublisherData(Integer mpid, Integer pubid);

    public Integer getAdUnits(Integer mpid);

    public Integer getPublisher(Integer mpid);

    public Integer getLines(Integer mpid);

    // 2nd page
    public List<PublisherData> getGroupofPubList(List<Publisher> list);

    public List<PublisherData> getGroupofPlcList(Integer pubid);

    public List<PublisherData> getGroupofAdUnitList(Integer pubid);

    public List<PublisherData> getGroupofSubAdUnitList(Integer adunitid);

    public List<PublisherData> searchPubList(String catid, String pubname, String plctypeid);

    // 3rd page
    public boolean AddToLine(Integer mpid, Integer pubid, Integer adunitid, Integer plcid);

    public MediaplanData getMediaPlanDetails(Integer mpid);

    public boolean DeletePublisher(Integer mpid, Integer publisherId);

    public boolean DeletePlacement(Integer mplid);

    public boolean DeleteAdunits(Integer mplid, Integer publisherId, Integer adunitId, Integer plcid);

    public boolean DeleteSubAdunits(Integer mplid, Integer publisherId, Integer adunitId);

    public List<GraphData> getPublisherPieChartData(Integer mpid);

    public List<GraphData> getBarChartData(Integer mpid);

    //4th page
    public List<CreativeData> getMediaPlanlineCreatives(Integer mpid, Integer plcType);

    public List<CreativeData> getAdUnitCreatives(Integer mplid, Integer plcType);

    public List<CreativeData> getSubAdUnitCreatives(Integer mplid, Integer invType, Integer aduid);

    public List<CreativelistData> showCreativeList(Integer mplid);

    public UploadData uploadCreative(UploadData ud);

    public boolean DeleteCreativeList(Integer cid);

    public List<CreativeData> getAdUnitCreativessizes(Integer mplid, Integer plcTypeid);

    public List<CreativelistData> showCreativeListforline(Integer mplid);

    public List<CreativelistData> showCreativeListForMediaplan(Integer mpid);

    public boolean DeleteCreativeListForPlan(Integer cid);

    public boolean MediaplanExist(Integer mpid);

    public boolean MediaplanlineExist(Integer mpid);
}
