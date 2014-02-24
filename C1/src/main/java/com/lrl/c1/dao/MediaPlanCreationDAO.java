/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Creative;
import com.lrl.c1.entity.Creativelist;
import com.lrl.c1.entity.Invtargeting;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Mediaplanline;
import com.lrl.c1.entity.Placements;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.wrapper.UploadData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author logic
 */
public interface MediaPlanCreationDAO {

    public Mediaplan createNewMediaPlan(Mediaplan mediaPlan);

    public List<Invtargeting> lineList(Integer mpid, Integer lineid);

    public List<Publisher> getPublisherList();

    public List<Adunits> publishersAdunitsList(Integer publisherId, Integer mplid);

    public List<Adunits> publishersSubAdunitsList(Integer mplid, Integer publisherId, Integer adunitId);

    public Map<String, Integer> getInventorySelected(Integer mpid);

    public Integer getPublisherImpressions(Integer mpid, Integer pubid);

    public Integer getPublisherData(Integer mpid, Integer pubid);

    public Integer getPublisher(Integer mpid);

    public Integer getLines(Integer mpid);

    public Integer getAdUnits(Integer mpid);

    public boolean AddToLine(Integer mediaplanid, Integer publisherId, Integer adunitId, Integer placementid);

    public List<Publisher> getGroupofPublishersList();

    public Integer getPlacementsLinesAdUnits(Integer mplid, Integer pubid);

    public List<Adunitsplacements> getPlcAdUnitsList(Integer pubid);

    public Integer getPublisherPlacementCount(Integer id);

    public Integer getPublisherAdunitsCount(Integer id);

    public List<Placements> getPlacementsLines(Integer pubid);

    public Integer getPlacementAdunitsCount(Integer id);

    public Integer getPlacementImpression(Integer id);

    public Integer getAdUnitImpCount(Integer adUnitId);

    public Double getAdUnitCPM(Integer adUnitId);

    public List<Adunits> getPlcSubAdUnitsList(Integer adUnitId);

    public List<Publisher> getsearchPublishersList(String catid, String pubname, String plctypeid);
    // ### 3rd page

    public Mediaplan getMediaPlan(Integer mpid);

    public boolean DeletePublisher(Integer mpid, Integer pubid);

    public boolean DeleteSubAdunits(Integer mplid, Integer publisherId, Integer adunitId);

    public boolean DeleteAdunits(Integer mplid, Integer publisherId, Integer adunitId, Integer plcid);

    public boolean DeletePlacement(Integer mplid);

    public List getPublisherPieChartData(Integer mpid);

    public List getBarChartData(Integer mid);

    // 4th page
    public List<Mediaplanline> getMediaPlanlineCreatives(Integer mpid, Integer plcTypeid);

    public List<Invtargeting> getAdUnitCreatives(Integer mplid, Integer plcTypeid);

    public List<Invtargeting> getSubAdUnitCreatives(Integer mplid, Integer plcTypeid, Integer aduid);

    public UploadData uploadCreative(UploadData ud);

    public boolean DeleteCreativeList(Integer cid);

    public List getAdUnitCreativesSizes(Integer mplid, Integer plcTypeid);

    public List<Creativelist> showCreativeList(Integer mplid);

    public List<Creative> showCreativeListforline(Integer mplid);

    public List<Creativelist> showCreativeListForMediaplan(Integer mpid);

    public boolean DeleteCreativeListForPlan(Integer cid);

    public boolean MediaplanExist(Integer mpid);

    public boolean MediaplanlineExist(Integer mplid);
}
