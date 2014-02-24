/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.bean.MediaplanBean;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.wrapper.MediaplanData;
import java.util.Date;
import java.util.List;
import org.codehaus.jettison.json.JSONObject;

public interface MediaPlanService {

    public List<Mediaplan> FetchReqProposals();

    public List<Mediaplan> FetchMediaPlan(int userid);

    public MediaplanBean getPublisherCount(Integer mpid);

    public List<MediaplanData> getMediaPlanGrpList(String name, String adname, String status);

    public List<MediaplanData> getMediaPlanPublishersList(Integer mpid);

    public List<MediaplanData> getMediaPlanPlcList(Integer mpid, Integer pubid);

    public List<MediaplanData> getMediaPlanAdunitList(Integer mplid, Integer pubid);

    public List<MediaplanData> getMediaPlanSubAdunitList(Integer mplid, Integer pubid, Integer aduid, Integer plcid);

    public boolean MediaplanlineUpdate(Integer mpid, Integer mplid, Date sdt, Date edt, Integer imp);
}
