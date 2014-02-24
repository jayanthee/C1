/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

//import c1.buyside.entity.Mediaplan;
import com.lrl.c1.bean.MediaplanBean;
import com.lrl.c1.entity.Invtargeting;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Mediaplanline;
import com.lrl.c1.entity.Targeting;
import java.util.Date;
import java.util.List;

/**
 *
 * @author logic
 */
public interface MediaPlanDAO {

    public List<Mediaplan> FetchAllMediaPlan(int userid);

    public List<Mediaplan> FetchReqProposals();

    public MediaplanBean getPublisherCount(Integer mpid);

    public boolean DeleteMediaPlan(Integer mpid);

    public boolean DeletePublisherLine(Integer mpid, Integer mplid, Integer pid);

    public boolean DeleteAdunits(Integer mplid, Integer pid, Integer auid);

    public boolean DeleteSubAdunits(Integer mplid, Integer pid, Integer auid);

    public Integer getPlacementImpression(Integer mplid, Integer pubid);

    public Double getPlacementCPM(Integer mplid, Integer pubid);

    public Integer getAdUnitImpCount(Integer mplid, Integer pubid, Integer adUnitId);

    public Double getAdUnitAvgCPM(Integer mplid, Integer pubid, Integer adUnitId);

    // ### first row start
    
    public List<Mediaplan> getMediaPlanList(String name,String adname,String status);

    public Integer getMediaPlanTargetingCount(Integer mpid);

    public Integer getMediaPlanPublishersCount(Integer mpid);

    public Integer getMediaPlanPlacementsCount(Integer mpid);

    public Integer getMediaPlanAdunitsCount(Integer mpid);

    public Double getMediaPlanCPM(Integer mpid);
    
     // ### second row start
    public List<Mediaplanline> getMediaPlanPublisherList(Integer mpid);
     
    public Date getMinStartdt(Integer mpid, Integer pubid);

    public Date getMaxEnddt(Integer mpid, Integer pubid);
    
     public Integer getPublisherTargetingCount(Integer mpid, Integer pubid);
    
    public Integer getPublisherPlacementCount(Integer i, Integer id);

    public Integer getPublisherImpressions(Integer mpid, Integer pubid);
    
    public Double getPublisherCPM(Integer mpid, Integer pubid);

    public Integer getPublisherAdunitCount(Integer mpid, Integer pubid);

    public String getPublisherStatus(Integer mpid, Integer pubid);

    public List<Mediaplanline> getMediaPlanPlacementList(Integer mpid, Integer pubid);

    public List<Targeting> getPlacementTargetingCount(Integer mpid);

    public Integer getPlacementAdUnitsCount(Integer mplid, Integer pubid);

    public List<Invtargeting> getMediaPlanAdUnitList(Integer mplid, Integer pubid);

    public Integer getInvTarAdunitsCount(Integer mplid, Integer pubid, Integer aduid);

    public Integer getInvTarAdunitsImpression(Integer mplid, Integer pubid, Integer aduid);

    public List<Invtargeting> getMediaPlanSubAdUnitList(Integer mplid, Integer pubid, Integer adid);

   // ### 3rd Page
    
    public boolean updateMediaPlanLine(Integer mpid, Integer mplid,  Date stdt,  Date enddt, Integer impr);

    public List<Invtargeting> getMediaPlanAdunitsPlacementList(Integer mplid, Integer pid);
    public List<Invtargeting> getMediaPlanSubAdUnitPlacementList(Integer mplid, Integer pid, Integer plcid);
}
