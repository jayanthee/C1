/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.dao.SellsideDAO;
import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Advertiser;
import com.lrl.c1.entity.Ratecard;
import com.lrl.c1.entity.Timeperiod;
import com.lrl.c1.entity.Volumediscount;
import com.lrl.c1.wrapper.AdunitsData;
import com.lrl.c1.wrapper.AdunitsPlacementsData;
import com.lrl.c1.wrapper.AdvertiserData;
import com.lrl.c1.wrapper.PublisherData;
import com.lrl.c1.wrapper.RatecardData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sellsideService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SellsideServiceImpl implements SellsideService {

    @Autowired
    private SellsideDAO sellsideDao;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    SimpleDateFormat sdfhms = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    private static final Logger LOG = Logger.getLogger(SellsideServiceImpl.class.getName());

    @Override
    public List<AdvertiserData> getAllAdvertisers(String advname) {
        try {
            List<Advertiser> adv = sellsideDao.getAllAdvertisers(advname);

            List<AdvertiserData> lst = new ArrayList<AdvertiserData>();
            for (Advertiser a : adv) {
                String sdt = sdf.format(sellsideDao.getMinStartdt(a.getId()));
                String edt = sdf.format(sellsideDao.getMaxEnddt(a.getId()));
                Integer imp = sellsideDao.getAdvertisersImpressions(a.getId());
                Integer adu = sellsideDao.getAdvertisersAdunits(a.getId());
                Integer lines = sellsideDao.getAdvertisersLines(a.getId());
                Double cpm = null;
                Integer[] status = sellsideDao.getAdvertisersStatus(a.getId());
                String sts = status[0].toString() + "Of " + status[0] + status[1] + "Approved";
                AdvertiserData advData = new AdvertiserData(a.getId(), a.getName(), sdt, edt, a.getUpdated().toString(), adu, lines, imp, cpm, "");
                lst.add(advData);
            }

            return lst;
        } catch (Exception e) {
            return null;
        }




    }

    //RATECARD SETTINGS
    public List<RatecardData> getAllTimePeriods(Integer pubid) {

        try {
            List<Timeperiod> tpl = sellsideDao.getAllTimePeriods(pubid);
            List<RatecardData> rcd = new ArrayList<RatecardData>();

            for (Timeperiod tp : tpl) {
                Integer id = tp.getId();
                String name = tp.getName();
                String sdt = tp.getStartDate() != null ? sdf.format(tp.getStartDate()) : "0000-00-00 00:00:00";
                String edt = tp.getEndDate() != null ? sdf.format(tp.getEndDate()) : "0000-00-00 00:00:00";
                String status = tp.getStatus();

                RatecardData rc = new RatecardData(id, null, name, sdt, edt, status, null);
                rcd.add(rc);

            }

            return rcd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<RatecardData> getAllRateCards(Integer tpid) {
        try {
            List<Ratecard> rcl = sellsideDao.getAllRateCards(tpid);
            List<RatecardData> rcdl = new ArrayList<RatecardData>();

            for (Ratecard rc : rcl) {
                Integer id = rc.getId();
                String name = rc.getName();
                String status = rc.getStatus();
                RatecardData rcd = new RatecardData(tpid, id, name, null, null, status, rc.getPrice());
                rcd.setAdunits(sellsideDao.getRatecardAdunitsCount(id));
                rcd.setSubadunits(sellsideDao.getRatecardSubAdunitsCount(id));
                rcd.setPlacements(sellsideDao.getRatecardPlacementsCount(id));
                rcd.setTotalimpressions(sellsideDao.getRatecardTotalImpression(id));
                rcdl.add(rcd);
            }

            return rcdl;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<RatecardData> getAllVolumeDiscount(Integer tpid) {
        try {
            List<Volumediscount> vdl = sellsideDao.getAllVolumeDiscount(tpid);
            List<RatecardData> rcdl = new ArrayList<RatecardData>();

            for (Volumediscount vd : vdl) {
                Integer id = vd.getId();
                String name = vd.getName();
                Integer simp = vd.getStartImpression();
                Integer eimp = vd.getEndImpression();
                Integer days = vd.getTotalDays();
                Double disc = Double.valueOf(vd.getDiscountPercent().toString());
                RatecardData rcd = new RatecardData(tpid, id, name, simp, eimp, disc, days);
                rcdl.add(rcd);
            }

            return rcdl;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean RemoveTimePeriod(Integer tpid) {
        try {

            return sellsideDao.RemoveTimePeriod(tpid);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean RemoveRateCard(Integer rcid) {
        try {
            return sellsideDao.RemoveRateCard(rcid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean RemoveVolumeDiscount(Integer vdid) {
        try {
            return sellsideDao.RemoveVolumeDiscount(vdid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Timeperiod saveTimeperiod(Timeperiod t, Integer pubid) {
        try {
            return t = sellsideDao.saveTimeperiod(t, pubid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Ratecard saveRateCard(Ratecard r, Integer tid) {
        try {
            return r = sellsideDao.saveRateCard(r, tid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Volumediscount saveVolumeDiscount(Volumediscount v, Integer tpid) {
        try {
            return v = sellsideDao.saveVolumeDiscount(v, tpid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Ratecards Inventory
    @Override
    public boolean updateAdunitsRatecard(Integer aduid, Integer rcid) {
        try {
            return sellsideDao.updateAdunitsRatecard(aduid, rcid);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updatePlacementsRatecard(Integer aduid, Integer plcid, Integer rcid) {
        try {
            return sellsideDao.updatePlacementsRatecard(aduid, plcid, rcid);
        } catch (Exception e) {
            return false;
        }

    }

    //## NOT USED 
    public List<AdunitsData> getRatecardAdunitsData_old(Integer rcid) {

        try {
            List<Adunits> adu = sellsideDao.getRatecardAdunitsData(rcid);
            List<AdunitsData> adudata = new ArrayList<AdunitsData>();
            for (Adunits ad : adu) {

                AdunitsData adata = new AdunitsData();
                adata.setId(ad.getId());
                adata.setName(ad.getName());
                adata.setImpression(ad.getImpression());
                adata.setSizes(ad.getSizes());
                adata.setStyle(ad.getStyle());
                adudata.add(adata);
            }
            return adudata;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AdunitsPlacementsData> getRatecardAdunitsData(Integer rcid) {



        List<Adunitsplacements> adu = sellsideDao.getRatecardAdunitsData_Placement(rcid);
        List<AdunitsPlacementsData> adudata = new ArrayList<AdunitsPlacementsData>();
        for (Adunitsplacements ad : adu) {

            AdunitsPlacementsData adata = new AdunitsPlacementsData();

            adata.setPublisher_id(0);

            adata.setAdunit_id(0);
            adata.setPlacement_id(ad.getPlacementId().getId());
            adata.setName(ad.getPlacementId().getName());

            Integer forcast_impression = ad.getAdUnitId().getImpression();

            adata.setImpression(forcast_impression);
            adata.setType(ad.getAdUnitId().getSizes() + ad.getAdUnitId().getPlacementType().getValue());

            adudata.add(adata);
        }
        List<Adunits> aduonly = sellsideDao.getRatecardAdunitsData_Adunits(rcid);
        for (Adunits ad : aduonly) {
            AdunitsPlacementsData adata = new AdunitsPlacementsData();
            adata.setPublisher_id(0);
            adata.setAdunit_id(ad.getId());
            adata.setPlacement_id(0);
            adata.setName(ad.getName());
            adata.setType(ad.getSizes() + ad.getPlacementType().getValue());

            Integer forcast_impression = ad.getImpression();

            adata.setImpression(forcast_impression);

            adudata.add(adata);

        }
        return adudata;
    }

    @Override
    public List<AdunitsPlacementsData> getDoubleClickForPublisher(Integer pubid, Integer month, Integer year) {

        System.out.println("inner to getDoubleClickForPub");

        try {
            Integer[] percent = sellsideDao.getPercentage(month, year);

            List<Adunitsplacements> adu = sellsideDao.PlacementsAdunitsList(pubid);
            List<AdunitsPlacementsData> adudata = new ArrayList<AdunitsPlacementsData>();
            for (Adunitsplacements ad : adu) {

                AdunitsPlacementsData adata = new AdunitsPlacementsData();

                adata.setPublisher_id(pubid);

                adata.setAdunit_id(0);
                adata.setPlacement_id(ad.getPlacementId().getId());
                adata.setName(ad.getPlacementId().getName());
                Integer targeting = sellsideDao.getCountOfAdunitsInPlacements(ad.getPlacementId().getId());
                adata.setInventory(targeting);
                //Integer forcast_impression = sellsideDao.getAdunitsImpression(ad.getPlacementId().getId()); 
                Integer forcast_impression = ad.getPlacementId().getImpression();

                adata.setImpression(forcast_impression);


                Double[] cpm = sellsideDao.getCPM(ad.getPlacementId().getId(), pubid, 0, "Y");

                adata.setPrivate_RFP(Double.valueOf((percent[0] / 100) * sellsideDao.getRFP(ad.getPlacementId().getId(), pubid, 0, "Y")));//in progress or pending
                adata.setPrivate_available(Double.valueOf((percent[0] / 100) * ad.getPlacementId().getPrivateImpressionAvailable()));//available
                adata.setPrivate_booked(Double.valueOf((percent[0] / 100) * sellsideDao.getBooked(ad.getPlacementId().getId(), pubid, 0, "Y"))); //booked
                adata.setPrivateMinCpm(cpm[1]);
                adata.setPrivateMaxCpm(cpm[0]);

                adata.setPublic_RFP(Double.valueOf(percent[1] / 100) * sellsideDao.getRFP(ad.getPlacementId().getId(), pubid, 0, "N"));
                adata.setPublic_available(Double.valueOf(percent[1] / 100) * ad.getPlacementId().getPrivateImpressionAvailable());
                adata.setPublic_booked(Double.valueOf((percent[1] / 100) * sellsideDao.getBooked(ad.getPlacementId().getId(), pubid, 0, "N")));

                Double[] cpm_p = sellsideDao.getCPM(ad.getPlacementId().getId(), pubid, 0, "N");

                adata.setPublicMinCpm(cpm_p[1]);
                adata.setPublicMaxCpm(cpm_p[0]);

                adata.setDefault_ratecard_id(ad.getPlacementId().getDefaultRateCardId().getId() == null ? 0 : ad.getPlacementId().getDefaultRateCardId().getId());
                adata.setSpecial_ratecard_id(ad.getPlacementId().getSpecialRateCardId().getId() == null ? 0 : ad.getPlacementId().getSpecialRateCardId().getId());
                adudata.add(adata);
            }
            List<Adunits> aduonly = sellsideDao.getAllParentAdunits(pubid);
            for (Adunits ad : aduonly) {
                AdunitsPlacementsData adata = new AdunitsPlacementsData();
                adata.setPublisher_id(pubid);
                adata.setAdunit_id(ad.getId());
                adata.setPlacement_id(0);//clarify plcid pk or aduplcid pk
                adata.setName(ad.getName());
                adata.setInventory(0);
                Integer forcast_impression = ad.getImpression();
                adata.setImpression(forcast_impression);
                Double[] cpm = sellsideDao.getCPM(0, pubid, ad.getId(), "Y");
                adata.setPublicMinCpm(cpm[1]);
                adata.setPublicMaxCpm(cpm[0]);
                adata.setPrivate_RFP(Double.valueOf(percent[0] / 100) * sellsideDao.getRFP(0, pubid, ad.getId(), "Y"));//in progress or pending
                adata.setPrivate_available(Double.valueOf((percent[0] / 100) * ad.getPrivateImpressionAvailable()));//available
                adata.setPrivate_booked(Double.valueOf((percent[0] / 100) * sellsideDao.getBooked(0, pubid, ad.getId(), "Y"))); //booked
                adata.setPublic_RFP(Double.valueOf((percent[1] / 100) * sellsideDao.getRFP(0, pubid, ad.getId(), "N")));
                adata.setPublic_available(Double.valueOf((percent[1] / 100) * ad.getPrivateImpressionAvailable()));
                adata.setPublic_booked(Double.valueOf((percent[1] / 100) * sellsideDao.getBooked(0, pubid, ad.getId(), "N")));
                Double[] cpm_p = sellsideDao.getCPM(0, pubid, ad.getId(), "N");
                adata.setPublicMinCpm(cpm_p[1]);
                adata.setPublicMaxCpm(cpm_p[0]);
                adata.setDefault_ratecard_id(ad.getDefaultRateCardId().getId());
                adata.setSpecial_ratecard_id(ad.getSpecialRateCardId().getId());
                adudata.add(adata);
            }
            return adudata;

        } catch (Exception ex) {
            LOG.severe("Exception in getDoubleClickForPublisher " + String.class + ex.getMessage() + "  " + ex.getLocalizedMessage());
            ex.printStackTrace();
            return null;
        }


    }

    public PublisherData getGraphOverview(Integer pubid, Integer month, Integer year) {

        try {
            PublisherData pd = new PublisherData();
            Integer[] percent = sellsideDao.getPercentage(month, year);
            List<Adunitsplacements> adu = sellsideDao.PlacementsAdunitsList(pubid);
            List<Adunits> aduonly = sellsideDao.getAllParentAdunits(pubid);

            List<Adunits> pls = sellsideDao.getAllChildAdunits(pubid);
            List<Adunitsplacements> cls = sellsideDao.ChildPlacementsAdunitsList(pubid);

            pd.setInventoryPlacements(adu.size());
            pd.setInventoryAdUnits(aduonly.size());
            pd.setInventorySubAdUnits(pls.size() + cls.size());


            Integer imp = sellsideDao.getOverviewImpression(pubid);
            pd.setExpectedTotImpression(imp);
            Integer booked = sellsideDao.getPublisherBooked(pubid);
            Double imppercent = (Double.valueOf(booked) / Double.valueOf(imp)) * 100;
            pd.setPercentageInvBooked(imppercent);
            pd.setCPM(sellsideDao.getPublisherCPM(pubid) / 2);
            pd.setTotRevenue(sellsideDao.getPublisherTotalRevenue(pubid));
            pd.setNonC1(month);
            pd.setPrivatePercent(Double.valueOf(percent[0]));
            pd.setPublicPercent(Double.valueOf(percent[1]));
            return pd;

        } catch (Exception ex) {
            LOG.severe("Exception in getDoubleClickForPublisher " + String.class + ex.getMessage() + "  " + ex.getLocalizedMessage());
            ex.printStackTrace();
            return null;
        }


    }
}
