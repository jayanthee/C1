/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.bean.CreativelistBean;
import com.lrl.c1.dao.MediaPlanCreationDAO;
import com.lrl.c1.dao.MediaPlanDAO;
import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Creative;
import com.lrl.c1.entity.Creativelist;
import com.lrl.c1.entity.Invtargeting;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Mediaplanline;
import com.lrl.c1.entity.Placements;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.wrapper.CreativeData;
import com.lrl.c1.wrapper.CreativelistData;
import com.lrl.c1.wrapper.GraphData;
import com.lrl.c1.wrapper.MediaplanData;
import com.lrl.c1.wrapper.PublisherData;
import com.lrl.c1.wrapper.UploadData;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author logic
 */
@Service("mediaPlanCreateService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MediaPlanCreationServiceImpl implements MediaPlanCreationService {

    @Autowired
    private MediaPlanCreationDAO mediaPlanCreateDao;
    @Autowired
    private MediaPlanDAO mediaplanDao;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    NumberFormat nf = new DecimalFormat("0.00");

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Mediaplan createNewMediaPlan(Mediaplan mediaPlan) {
        return mediaPlanCreateDao.createNewMediaPlan(mediaPlan);
    }

    @Override
    public List<Invtargeting> lineList(Integer mpid, Integer lineid) {
        return mediaPlanCreateDao.lineList(mpid, lineid);
    }

    public List<Publisher> publishersSearchList() {
        List<Publisher> publisherList = mediaPlanCreateDao.getPublisherList();
        return publisherList;
    }

    public List<Adunits> publishersAdunitsList(Integer publisherId, Integer mplid) {
        List<Adunits> adunitsList = mediaPlanCreateDao.publishersAdunitsList(publisherId, mplid);
        return adunitsList;
    }

    @Override
    public List<Adunits> publishersSubAdunitsList(Integer mplid, Integer publisherId, Integer adunitId) {
        List<Adunits> adunitsList = mediaPlanCreateDao.publishersSubAdunitsList(mplid, publisherId, adunitId);
        return adunitsList;
    }

    @Override
    public List<Publisher> getPublisherList() {
        return mediaPlanCreateDao.getPublisherList();
    }

    @Override
    public Map<String, Integer> getInventorySelected(Integer mpid) {
        return mediaPlanCreateDao.getInventorySelected(mpid);
    }

    @Override
    public Integer getPublisherImpressions(Integer mpid, Integer pubid) {
        return mediaPlanCreateDao.getPublisherImpressions(mpid, pubid);
    }

    @Override
    public Integer getPublisherData(Integer mpid, Integer pubid) {
        return mediaPlanCreateDao.getPublisherData(mpid, pubid);
    }

    @Override
    public Integer getPublisher(Integer mpid) {
        return mediaPlanCreateDao.getPublisher(mpid);
    }

    @Override
    public Integer getLines(Integer mpid) {
        return mediaPlanCreateDao.getLines(mpid);
    }

    @Override
    public Integer getAdUnits(Integer mpid) {
        return mediaPlanCreateDao.getAdUnits(mpid);
    }

    public boolean AddToLine(Integer mediaplanid, Integer publisherId, Integer adunitId, Integer placementid) {
        return mediaPlanCreateDao.AddToLine(mediaplanid, publisherId, adunitId, placementid);
    }

    // ###
    public List<PublisherData> getGroupofPubList(List<Publisher> list) {
        try {

            if (list == null || list.size() == 0) {
                list = mediaPlanCreateDao.getGroupofPublishersList();
            }

            List<PublisherData> lst = new ArrayList<PublisherData>();
            // Impression and CPM from invtargeting table
            for (Publisher pub : list) {

                Integer impression = this.getPublisherImpressions(0, pub.getId()); // get the impression value
                Integer placementCount = mediaPlanCreateDao.getPublisherPlacementCount(pub.getId());
                Integer adunitsCount = mediaPlanCreateDao.getPublisherAdunitsCount(pub.getId());
                Double CPM = mediaplanDao.getPublisherCPM(0, pub.getId());
                PublisherData publisherData = new PublisherData(pub.getName(), pub.getId(), placementCount, adunitsCount, impression, CPM);
                lst.add(publisherData);
            }

            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PublisherData> getGroupofPlcList(Integer pubid) {

        List<Placements> list = mediaPlanCreateDao.getPlacementsLines(pubid);

        List<PublisherData> lst = new ArrayList<PublisherData>();

        for (Placements placements : list) {
            Integer plcid = placements.getId();
            String name = placements.getName();
            Integer impression = mediaPlanCreateDao.getPlacementImpression(placements.getId());
            Integer adunitsCount = mediaPlanCreateDao.getPlacementAdunitsCount(placements.getId());
            Double CPM = Double.valueOf(placements.getCpm().toString());
            PublisherData publisherData = new PublisherData(name, plcid, adunitsCount, 0, impression, CPM);
            lst.add(publisherData);
        }
        return lst;
    }

    public List<PublisherData> getGroupofAdUnitList(Integer plcid) {
        Integer mplid = 0;
        List<Adunitsplacements> list = mediaPlanCreateDao.getPlcAdUnitsList(plcid);

        List<PublisherData> lst = new ArrayList<PublisherData>();

        for (Adunitsplacements adu : list) {
            Integer adUnitId = adu.getAdUnitId().getId();
            String name = adu.getAdUnitId().getName();
            Integer impression = mediaPlanCreateDao.getAdUnitImpCount(adUnitId);
            Double CPM = mediaPlanCreateDao.getAdUnitCPM(adUnitId);

            PublisherData publisherData = new PublisherData(name, adUnitId, null, null, impression, CPM);

            // Name, Id, InventoryAdUnits, InventoryPlacements, Impressions, CPM

            lst.add(publisherData);
        }
        return lst;
    }

    public List<PublisherData> getGroupofSubAdUnitList(Integer aduid) {

        Integer mplid = 0;
        List<Adunits> list = mediaPlanCreateDao.getPlcSubAdUnitsList(aduid);

        List<PublisherData> lst = new ArrayList<PublisherData>();

        for (Adunits adu : list) {
            Integer adUnitId = adu.getId();
            String name = adu.getName();
            Integer impression = mediaPlanCreateDao.getAdUnitImpCount(adUnitId);
            Double CPM = Double.valueOf(adu.getCpm().toString());// mediaPlanCreateDao.getAdUnitCPM(adUnitId);
            String Style = adu.getStyle();
            String Size = adu.getSizes();

            PublisherData publisherData = new PublisherData(name, adUnitId, impression, CPM, Style, Size);

            lst.add(publisherData);
        }
        return lst;
    }

    public boolean addtoline(Integer mpid, Integer pubid, Integer adunitid, Integer plcid) {

        try {
            boolean value = mediaPlanCreateDao.AddToLine(mpid, pubid, adunitid, plcid);

            return value;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<PublisherData> searchPubList(String catid, String pubname, String plctypeid) {
        try {


            List<Publisher> list = mediaPlanCreateDao.getsearchPublishersList(catid, pubname, plctypeid);


            List<PublisherData> lst = new ArrayList<PublisherData>();
            // Impression and CPM from invtargeting table
            for (Publisher pub : list) {

                Integer impression = this.getPublisherImpressions(0, pub.getId()); // get the impression value
                Integer placementCount = mediaPlanCreateDao.getPublisherPlacementCount(pub.getId());
                Integer adunitsCount = mediaPlanCreateDao.getPublisherAdunitsCount(pub.getId());
                Double CPM = mediaplanDao.getPublisherCPM(0, pub.getId());
                PublisherData publisherData = new PublisherData(pub.getName(), pub.getId(), placementCount, adunitsCount, impression, CPM);
                lst.add(publisherData);
            }

            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ### 3rd page
    @Override
    public boolean DeletePublisher(Integer mpid, Integer publisherId) {
        return mediaPlanCreateDao.DeletePublisher(mpid, publisherId);
    }

    @Override
    public boolean DeletePlacement(Integer mplid) {
        return mediaPlanCreateDao.DeletePlacement(mplid);
    }

    @Override
    public boolean DeleteAdunits(Integer mplid, Integer publisherId, Integer adunitId, Integer plcid) {
        return mediaPlanCreateDao.DeleteAdunits(mplid, publisherId, adunitId, plcid);
    }

    @Override
    public boolean DeleteSubAdunits(Integer mplid, Integer publisherId, Integer adunitId) {
        return mediaPlanCreateDao.DeleteSubAdunits(mplid, publisherId, adunitId);
    }

    public MediaplanData getMediaPlanDetails(Integer mpid) {

        MediaplanData mpd = new MediaplanData();

        Mediaplan mp = mediaPlanCreateDao.getMediaPlan(mpid);

        mpd.setId(mpid);
        mpd.setName(mp.getName());
        mpd.setStartDate(sdf.format(mp.getStartDate()));
        mpd.setEndDate(sdf.format(mp.getEndDate()));
        mpd.setInventoryPublisher(mediaplanDao.getMediaPlanPublishersCount(mpid));
        mpd.setInventoryPlacements(mediaplanDao.getMediaPlanPlacementsCount(mpid));
        mpd.setInventoryAdUnits(mediaplanDao.getMediaPlanAdunitsCount(mpid));
        mpd.setCPM(mediaplanDao.getMediaPlanCPM(mpid));
        mpd.setImpressions(mp.getTotalImpression());
        mpd.setUUs("400K"); // ### hardcode
        return mpd;
    }

    public List<GraphData> getPublisherPieChartData(Integer mpid) {
        List list = mediaPlanCreateDao.getPublisherPieChartData(mpid);

        List<GraphData> data = new ArrayList<GraphData>();

        Iterator i = list.iterator();

        int x = 0;
        while (i.hasNext()) {

            GraphData mdata = new GraphData();

            Object[] obj = (Object[]) i.next();
            mdata.setId(Integer.parseInt(obj[0].toString()));
            mdata.setName(obj[1].toString());
            mdata.setImpressions(Integer.parseInt(obj[2].toString()));
            Double avg = Double.valueOf(obj[2].toString()) / Double.valueOf(obj[3].toString()) * 100;
            mdata.setAvg(Double.valueOf(nf.format(avg)));
            data.add(mdata);

        }

        return data;
    }

    public List<GraphData> getBarChartData(Integer mpid) {

        List list = mediaPlanCreateDao.getBarChartData(mpid);

        List<GraphData> data = new ArrayList<GraphData>();

        Iterator i = list.iterator();

        while (i.hasNext()) {
            GraphData mdata = new GraphData();
            Object[] obj = (Object[]) i.next();
            mdata.setName(obj[0].toString()); // Line Name            
            mdata.setImpressions(Integer.parseInt(obj[4].toString())); // impr
            mdata.setName2(obj[3].toString()); // publisher name
            mdata.setDate(obj[2].toString()); // line date
            data.add(mdata);
        }
        return data;
    }

    // 4th page
    public List<CreativeData> getMediaPlanlineCreatives(Integer mpid, Integer plctype) {

        List<Mediaplanline> mpc = mediaPlanCreateDao.getMediaPlanlineCreatives(mpid, plctype);

        List<CreativeData> cdata = new ArrayList<CreativeData>();

        for (Mediaplanline mpl : mpc) {
            CreativeData data = new CreativeData(mpl.getId(), mpl.getName(), mpl.getPublisherId().getName(), mpl.getInventoryApproved());//, null); // #
            cdata.add(data);
        }

        return cdata;

    }

    public List<CreativeData> getAdUnitCreativessizes(Integer mplid, Integer plcTypeid) {

        List it = mediaPlanCreateDao.getAdUnitCreativesSizes(mplid, plcTypeid);

        List<CreativeData> cdata = new ArrayList<CreativeData>();
        List<CreativelistBean> clbean = new ArrayList<CreativelistBean>();
        for (Object inv : it) {
            CreativelistBean clb = null;

            List<Creativelist> obj = mediaPlanCreateDao.showCreativeList(mplid);
            for (Creativelist cl : obj) {
                clb = new CreativelistBean();
                clb.setId(cl.getId());
                clb.setName(cl.getName());
                clb.setLink(cl.getLink());
                clb.setSizes(cl.getSizes());
                clb.setTag(cl.getTag());
                clbean.add(clb);
            }
        }
        return cdata;

    }

    //not used
    public List<CreativeData> getAdUnitCreatives(Integer mplid, Integer plcTypeid) {

        List<Invtargeting> it = mediaPlanCreateDao.getAdUnitCreatives(mplid, plcTypeid);

        List<CreativeData> cdata = new ArrayList<CreativeData>();

        for (Invtargeting inv : it) {
            CreativeData data = new CreativeData(inv.getAdUnitId().getId(), inv.getAdUnitId().getName(), inv.getPublisherId().getName(), inv.getImpressionBooked());
            cdata.add(data);
        }
        return cdata;

    }

    public List<CreativeData> getSubAdUnitCreatives(Integer mplid, Integer plcTypeid, Integer aduid) {


        List<Invtargeting> it = mediaPlanCreateDao.getSubAdUnitCreatives(mplid, plcTypeid, aduid);

        List<CreativeData> cdata = new ArrayList<CreativeData>();

        for (Invtargeting inv : it) {
            CreativeData data = new CreativeData(inv.getAdUnitId().getId(), inv.getAdUnitId().getName(), inv.getPublisherId().getName(), inv.getImpressionBooked());
            cdata.add(data);
        }
        return cdata;
    }
// NOT USED 

    public List<CreativelistData> showCreativeList(Integer mplid) {
        List<Creativelist> cr = mediaPlanCreateDao.showCreativeList(mplid);
        List<CreativelistData> lst = new ArrayList<CreativelistData>();
        for (Creativelist cl : cr) {

            String name = cl.getName();
            String Size = cl.getSizes();
            CreativelistData cbean = new CreativelistData();
            cbean.setCid(cl.getId());
            cbean.setLink(cl.getLink());
            cbean.setName(name);
            cbean.setSize(Size);
            lst.add(cbean);
        }

        return lst;
    }

    @Override
    public List<CreativelistData> showCreativeListforline(Integer mplid) {

        List<Creative> cr = mediaPlanCreateDao.showCreativeListforline(mplid);
        List<CreativelistData> lst = new ArrayList<CreativelistData>();
        for (Creative cl : cr) {

            String name = cl.getCreativeListId().getName();
            String Size = cl.getCreativeListId().getSizes();
            String link = cl.getCreativeListId().getLink();
            Integer mpid = cl.getCreativeListId().getPlanId().getId();
            Integer cid = cl.getCreativeListId().getId();
            Integer acid = cl.getId();
            CreativelistData cdata = new CreativelistData();
            cdata.setPlanId(mpid);
            cdata.setPlanLineId(mplid);
            cdata.setCid(cid); // parent id
            cdata.setLink(link);
            cdata.setName(name);
            cdata.setSize(Size);
            cdata.setCreativeId(acid);
            lst.add(cdata);
        }

        return lst;


    }

    @Override
    public List<CreativelistData> showCreativeListForMediaplan(Integer mpid) {


        List<Creativelist> cr = mediaPlanCreateDao.showCreativeListForMediaplan(mpid);
        List<CreativelistData> lst = new ArrayList<CreativelistData>();
        for (Creativelist cl : cr) {

            String name = cl.getName();
            String Size = cl.getSizes();
            String link = cl.getLink();
            Integer cid = cl.getId();
            CreativelistData cdata = new CreativelistData();
            cdata.setPlanId(mpid);
            cdata.setCid(cid); // parent id
            cdata.setLink(link);
            cdata.setName(name);
            cdata.setSize(Size);
            lst.add(cdata);
        }

        return lst;


    }

    public boolean MediaplanExist(Integer mpid) {
        return mediaPlanCreateDao.MediaplanExist(mpid);
    }

    public boolean MediaplanlineExist(Integer mplid) {
        return mediaPlanCreateDao.MediaplanlineExist(mplid);
    }

    public UploadData uploadCreative(UploadData ud) {
        return mediaPlanCreateDao.uploadCreative(ud);
    }

    public boolean DeleteCreativeList(Integer cid) {
        return mediaPlanCreateDao.DeleteCreativeList(cid);
    }

    public boolean DeleteCreativeListForPlan(Integer cid) {
        return mediaPlanCreateDao.DeleteCreativeListForPlan(cid);
    }
}
