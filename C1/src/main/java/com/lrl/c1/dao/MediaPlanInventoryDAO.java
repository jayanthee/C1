/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Mediaplanline;
import com.lrl.c1.entity.Placements;
import java.util.List;

/**
 *
 * @author logic
 */
public interface MediaPlanInventoryDAO {

    public List<Adunits> getPlacementsAdLines(Integer pid);

    public List<Placements> getPlacementsLines(Integer pubid);

    public Integer getAdUnitPlcImpr(Integer aduid);

    public Integer getAdUnitPlcCount(Integer aduid);

    public Integer getPlcImpr(Integer id);

    public Integer getPlcAdunitsCount(Integer id);

    public Integer getAdUnitImpCount(Integer adUnitId);

    public Double getAdUnitCPM(Integer adUnitId);

    public List<Adunits> getAduAdUnitsList(Integer id);

    public List<Adunits> getAduSubAdUnitsList(Integer aduid, String catid);

    public List<Adunitsplacements> getPlcSubAdUnitsList(Integer aduid, String catid);

    public List<Adunitsplacements> getPlcAdUnitsList(Integer plcid);

    public Integer getParentId(Integer adUnitId);

    public Integer AddToLine(Integer mediaplanid, Integer publisherId, Integer adunitId, Integer placementid, Integer parentAdUnitId, Integer flagid);

    public Mediaplan getMediaplan(Integer mpid);

    public boolean updateMediaplan(Integer mpid, String integid, String stat);

    public List<Mediaplanline> getMediaplanlineList(Integer mpid);

    public Integer getMediaplanlineImpCount(Integer mplid);

    public List<Adunits> getAdunitsList(Integer mplId);

    public List<Placements> getPlcTarAdunitsList(Integer mplid);

    public boolean insertMediaplanlineIntegrationId(Integer mplid, String orderLineId);

    public List getListofValuesInPlacement(Integer plcmntTypeId, Integer placementId);

    public Integer getPacementAdunitsCount(Integer publisherId, String plcmntTypeId);

    public Double getAdUnitAvgCPM(Integer adUnitId);
}
