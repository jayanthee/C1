/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Advertiser;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Mediaplanline;
import com.lrl.c1.entity.Placements;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.entity.Ratecard;
import com.lrl.c1.entity.Timeperiod;
import com.lrl.c1.entity.Userprofile;
import com.lrl.c1.entity.Volumediscount;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author logic
 */
@Repository("sellsideDao")
public class SellsideDAOImpl implements SellsideDAO {

    @Autowired
    private SessionFactory sessionFactory;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
    private static final Logger LOG = Logger.getLogger(SellsideDAOImpl.class.getName());

    @Override
    public List<Advertiser> getAllAdvertisers(String advname) {
        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT A FROM Advertiser A,Mediaplan M WHERE A.id = M.advertiserId AND A.name like '%" + advname + "%' GROUP BY M.advertiserId";

            Query query = session.createQuery(qstr);
            List<Advertiser> adv = query.list();
            return adv;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer getAdvertisersImpressions(Integer advid) {
        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT SUM(totalImpression) AS imp FROM Mediaplan M WHERE M.advertiserID =:advid GROUP BY M.advertiserID";

            Query query = session.createQuery(qstr);

            Integer adv = Integer.parseInt(query.list().get(0).toString());
            return adv;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer getAdvertisersAdunits(Integer advid) {
        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT M FROM Mediaplan M  WHERE M.advertiserID =:advid";

            Query query = session.createQuery(qstr);
            Integer adUnits = 0;
            List<Mediaplan> mplist = query.list();
            for (Mediaplan mpl : mplist) {
                adUnits += this.getMediaPlanAdunitsCount(mpl.getId());
            }

            return adUnits;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Date getMinStartdt(Integer advid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT MIN(M.startDate) AS dt FROM Mediaplan M WHERE M.advertiserID =:advid GROUP BY M.advertiserID";
            Query query = session.createQuery(qstr).setInteger("mpid", advid);
            return (Date) query.list().get(0);

        } catch (Exception e) {
            System.out.println(" Min start date" + e);
            return null;
        }

    }

    @Override
    public Date getMaxEnddt(Integer advid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT MAX(M.endDate) AS dt FROM Mediaplan M WHERE M.advertiserID = :advid GROUP BY M.advertiserID";
            Query query = session.createQuery(qstr).setInteger("mpid", advid);
            return (Date) query.list().get(0);
        } catch (Exception e) {

            return null;
        }

    }

    @Override
    public Integer getAdvertisersLines(Integer advid) {
        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT M FROM Mediaplan M  WHERE M.advertiserID =:advid";

            Query query = session.createQuery(qstr);
            Integer lines = 0;
            List<Mediaplan> mplist = query.list();
            for (Mediaplan mpl : mplist) {
                lines += this.getMediaPlanPlacementsCount(mpl.getId());
            }

            return lines;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //### USED
    public Integer getMediaPlanPlacementsCount(Integer mpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT M FROM Mediaplanline M WHERE M.planId = :mpid";
            query = session.createQuery(qstr).setInteger("mpid", mpid);
            Integer placements = query.list().size();
            return placements;

        } catch (Exception e) {
            return 0;
        }
    }

    //### USED
    public Integer getMediaPlanAdunitsCount(Integer mpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT M FROM Mediaplanline M WHERE M.planId = :mpid ";
            query = session.createQuery(qstr).setInteger("mpid", mpid);
            List<Mediaplanline> mplist = query.list();
            Integer adUnits = 0;

            for (Mediaplanline mpl : mplist) {
                adUnits += mpl.getInvtargetingList().size(); // point to targeting table               
            }

            return adUnits;

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer[] getAdvertisersStatus(Integer id) {

        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT M.status,COUNT(M.status) FROM Mediaplan M WHERE M.advertiserId =:advid GROUP BY M.advertiserId,M.status";

            Query query = session.createQuery(qstr).setInteger("advid", id);
            Integer approved = 0, Pending = 0;
            List l = query.list();
            for (Iterator it = l.iterator(); it.hasNext();) {
                Object[] result = (Object[]) it.next();

                approved += (Integer) result[0];
                Pending += (Integer) result[1];
            }


            Integer[] sts = {approved, Pending};

            return sts;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /*
     * 
     * Rate Card Started
     */
    @Override
    public List<Timeperiod> getAllTimePeriods(Integer pubid) {

        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            if (pubid.equals(0)) {
                qstr = "SELECT T FROM Timeperiod T";
                query = session.createQuery(qstr);
            } else {
                qstr = "SELECT T FROM Timeperiod T WHERE T.publisherId=:pubid";
                query = session.createQuery(qstr).setInteger("pubid", pubid);
            }

            List<Timeperiod> tp = query.list();
            return tp;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Ratecard> getAllRateCards(Integer tpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT R FROM Ratecard R WHERE R.timePeriodId =:tpid";
            Query query = session.createQuery(qstr).setInteger("tpid", tpid);
            List<Ratecard> tp = query.list();
            return tp;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Volumediscount> getAllVolumeDiscount(Integer tpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT V FROM Volumediscount V WHERE V.timePeriodId =:tpid";
            Query query = session.createQuery(qstr).setInteger("tpid", tpid);
            List<Volumediscount> vd = query.list();
            return vd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean RemoveTimePeriod(Integer tpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Timeperiod tp = (Timeperiod) session.get(Timeperiod.class, tpid);
            session.delete(tp);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean RemoveRateCard(Integer rcid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Ratecard rc = (Ratecard) session.get(Ratecard.class, rcid);
            session.delete(rc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean RemoveVolumeDiscount(Integer vdid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Volumediscount vd = (Volumediscount) session.get(Volumediscount.class, vdid);
            session.delete(vd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //* Update special rate card id to null 
    @Override
    public boolean RemoveRatecardAdunits(Integer rcid, Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Adunits vd = (Adunits) session.get(Volumediscount.class, aduid);
            vd.setSpecialRateCardId(null);
            Adunitsplacements adup = (Adunitsplacements) session.get(Adunitsplacements.class, aduid);
            Placements p = adup.getPlacementId();
            p.setSpecialRateCardId(null);
            session.update(p);
            session.update(vd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Timeperiod saveTimeperiod(Timeperiod t, Integer publisherid) {

        try {

            Session session = sessionFactory.getCurrentSession();
            Publisher p = (Publisher) session.get(Publisher.class, publisherid);
            t.setPublisherId(p);
            t.setCreated(new Date());
            t.setUpdated(new Date());
            t.setCreatedBy(new Userprofile(1));
            t.setUpdatedBy(new Userprofile(1));
            session.saveOrUpdate(t);
            return t;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getCountOfAdunitsInPlacements {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});

            return null;
        }
    }

    @Override
    public Ratecard saveRateCard(Ratecard r, Integer tpid) {

        try {
            Session session = sessionFactory.getCurrentSession();

            Timeperiod t = (Timeperiod) session.get(Timeperiod.class, tpid);
            r.setTimePeriodId(t);
            session.saveOrUpdate(r);
            return r;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Volumediscount saveVolumeDiscount(Volumediscount v, Integer tpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Timeperiod t = (Timeperiod) session.get(Timeperiod.class, tpid);
            v.setTimePeriodId(t);
            session.saveOrUpdate(v);
            return v;
        } catch (Exception e) {
            return null;
        }

    }

    //Ratecards Inventory // NOT USED
    @Override
    public boolean updateAdunitsRatecard(Integer aduid, Integer rcid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Ratecard r = (Ratecard) session.get(Ratecard.class, rcid);
            Adunits adu = (Adunits) session.get(Adunits.class, aduid);
            adu.setSpecialRateCardId(r);
            session.saveOrUpdate(adu);
            session.flush();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updatePlacementsRatecard(Integer aduid, Integer plcid, Integer rcid) {
        try {

            if (plcid > 0) {
                Session session = sessionFactory.getCurrentSession();
                Ratecard r = (Ratecard) session.get(Ratecard.class, rcid);
                Placements adup = (Placements) session.get(Placements.class, plcid);
                adup.setSpecialRateCardId(r);
                session.saveOrUpdate(adup);


                for (Adunitsplacements al : adup.getAdunitsplacementsList()) {
                    Adunits adu = (Adunits) session.get(Adunits.class, al.getAdUnitId());
                    adu.setSpecialRateCardId(r);
                    session.saveOrUpdate(r);

                    session.flush();

                }
            } else {

                Session session = sessionFactory.getCurrentSession();
                Ratecard r = (Ratecard) session.get(Ratecard.class, rcid);
                Adunits adu = (Adunits) session.get(Adunits.class, aduid);
                adu.setSpecialRateCardId(r);
                session.saveOrUpdate(adu);
                session.flush();


            }

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     *
     * @param rcid
     * @return
     */
    @Override
    public Integer getRatecardAdunitsCount(Integer rcid) {

        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT A FROM Adunits A WHERE A.specialRateCardId =:rcid";// AND A.parentId IS NULL";
            Query query = session.createQuery(qstr).setInteger("rcid", rcid);
            return query.list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Integer getRatecardSubAdunitsCount(Integer rcid) {

        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT AP FROM Placements P,Adunitsplacements AP WHERE P.specialRateCardId =:rcid AND P.id = AP.placementId";
            Query query = session.createQuery(qstr).setInteger("rcid", rcid);
            Integer count = query.list().size();

            List<Adunitsplacements> Ap = query.list();
            for (Adunitsplacements ap : Ap) {
                Integer id = ap.getAdUnitId().getId();

                String qstr1 = "SELECT A FROM Adunits A WHERE A.specialRateCardId =:rcid AND A.id =:aid";
                Query query1 = session.createQuery(qstr1).setInteger("rcid", rcid).setInteger("aid", id);
                count += query1.list().size();

            }

            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Integer getRatecardPlacementsCount(Integer rcid) {

        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT P FROM Placements P WHERE P.specialRateCardId =:rcid";
            Query query = session.createQuery(qstr).setInteger("rcid", rcid);
            return query.list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Integer getRatecardTotalImpression(Integer rcid) {

        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT SUM(A.impression) FROM Adunits A WHERE A.specialRateCardId =:rcid";
            Query query = session.createQuery(qstr).setInteger("rcid", rcid);
            return Integer.parseInt(query.list().get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override //## Not USED
    public List<Adunits> getRatecardAdunitsData(Integer rcid) {

        try {
            List<Adunits> lst = new ArrayList<Adunits>();

            Session session = sessionFactory.getCurrentSession();
            // String qstr = "SELECT AP FROM Placements P,Adunitsplacements AP WHERE P.specialRateCardId =:rcid AND P.id = AP.placementId";
            String qstr = "SELECT A  FROM Placements P,Adunitsplacements AP,Adunits A WHERE P.specialRateCardId =:rcid AND P.id = AP.placementId AND AP.adUnitId=A.id AND A.specialRateCardId =:rcid";
            Query query = session.createQuery(qstr).setInteger("rcid", rcid);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Adunitsplacements> getRatecardAdunitsData_Placement(Integer rcid) {
        try {
            List<Adunitsplacements> lst = new ArrayList<Adunitsplacements>();

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT AP FROM Placements P,Adunitsplacements AP WHERE P.specialRateCardId =:rcid AND P.id = AP.placementId";
            Query query = session.createQuery(qstr).setInteger("rcid", rcid);
            return query.list();
        } catch (Exception e) {
            return null;
        }

    }

    public List<Adunits> getRatecardAdunitsData_Adunits(Integer rcid) {
        try {
            List<Adunits> lst = new ArrayList<Adunits>();

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT A  FROM Adunits A WHERE A.specialRateCardId =:rcid AND A.parentId IS NULL";
            Query query = session.createQuery(qstr).setInteger("rcid", rcid);
            return query.list();
        } catch (Exception e) {
            return null;
        }

    }

    // DOUBLE CLICK for publisher
    @Override
    public List<Adunitsplacements> PlacementsAdunitsList(Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr1 = "SELECT AP FROM Placements P , Adunitsplacements AP WHERE P.id = AP.placementId AND P.publisherId =:pubid GROUP BY AP.placementId";
            Query query1 = session.createQuery(qstr1).setInteger("pubid", pubid);
            List<Adunitsplacements> ap = query1.list();
            return ap;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in PlacementsAdunitsList {0}  {1}", new Object[]{ex.getMessage(), "localized" + ex.getLocalizedMessage()});
            return null;
        }

    }

    @Override
    public List<Adunitsplacements> ChildPlacementsAdunitsList(Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr1 = "SELECT AP FROM Placements P , Adunitsplacements AP WHERE P.id = AP.placementId AND P.publisherId =:pubid";
            Query query1 = session.createQuery(qstr1).setInteger("pubid", pubid);
            List<Adunitsplacements> ap = query1.list();
            return ap;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in PlacementsAdunitsList {0}  {1}", new Object[]{ex.getMessage(), "localized" + ex.getLocalizedMessage()});
            return null;
        }

    }

    @Override
    public List<Adunits> getAllChildAdunits(Integer pubid) {

        try {
            Session session = sessionFactory.getCurrentSession();

            String qstr = "SELECT A FROM  Adunits A WHERE  A.publisherId =:pubid AND A.parentId IS NOT NULL ";


            Query query = session.createQuery(qstr).setInteger("pubid", pubid);//.setString("booked", "Approved");
            List<Adunits> a = query.list();

            return a;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getAllParentAdunits {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return null;
        }

    }

    @Override
    public List<Adunits> getAllParentAdunits(Integer pubid) {

        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT A FROM  Adunits  A WHERE A.publisherId =:pubid AND A.parentId IS NULL ";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid);
            List<Adunits> a = query.list();

            return a;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getAllParentAdunits {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return null;
        }

    }

    /**
     *
     * @param plcid
     * @return
     */
    @Override
    public Integer getCountOfAdunitsInPlacements(Integer plcid) {

        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT P FROM Invtargeting I, Adunitsplacements P WHERE  I.placementId = P.placementId AND P.placementId=:plcid GROUP BY I.placementId ";
            Query query = session.createQuery(qstr).setInteger("plcid", plcid);
            Integer a = query.list().size();
            return a;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getCountOfAdunitsInPlacements {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return 0;
        }

    }

    @Override
    public Integer getOverviewImpression(Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT SUM(P.impression)  FROM Placements P WHERE P.publisherId =:pubid";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid);
            Integer a = Integer.parseInt(query.list().get(0).toString());
            String qstr1 = "SELECT SUM(A.impression)  FROM Adunits A  WHERE A.publisherId =:pubid";
            Query query2 = session.createQuery(qstr).setInteger("pubid", pubid);
            Integer a1 = Integer.parseInt(query.list().get(0).toString());


            return a + a1;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getOverviewImpression {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return 0;
        }

    }

    public Integer[] getPercentage(Integer month, Integer year) {
        try {

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT publicInventoryPercent,privateInventoryPercent  FROM Impressionsettings I  WHERE I.month =:month AND I.year=:year";

            Query query = session.createQuery(qstr).setInteger("month", month).setInteger("year", year);
            System.out.println("   query == " + query.getQueryString());
            Object[] a = (Object[]) query.list().get(0);

            //0 = public  //  1 = private 
            return new Integer[]{Integer.valueOf(a[0].toString()), Integer.valueOf(a[1].toString())};

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getPercentage111 {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});

            ex.printStackTrace();
            return new Integer[]{0, 0};
        }

    }

    @Override
    public Integer getPrivateAvailable(Integer plcid, Integer aduid) {
        try {

            Session session = sessionFactory.getCurrentSession();

            if (plcid > 0) {
                String qstr = "SELECT SUM(A.privateInventoryImpression) FROM Adunitimpression AI WHERE AI.placementId =:plcid ";
                Query query = session.createQuery(qstr).setInteger("plcid", plcid);
                Integer privateavailable = Integer.parseInt(query.list().get(0).toString());
                return privateavailable;
            } else {

                String qstr = "SELECT SUM(A.privateInventoryImpression) FROM Adunitimpression AI WHERE AI.adunitId =:aduid ";
                Query query = session.createQuery(qstr).setInteger("aduid", aduid);
                Integer privateavailable = Integer.parseInt(query.list().get(0).toString());
                return privateavailable;

            }

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getPrivateAvailable {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return 0;
        }

    }

    @Override
    public Integer getPublisherBooked(Integer pubid) {
        try {

            Integer privateavailable = 0;

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT SUM(I.impressionBooked) FROM Invtargeting I WHERE  I.publisherId =:pubid AND I.status ='APPROVED'";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid);

            if (query.list().size() > 0 && query.list() != null) {
                privateavailable = Integer.parseInt(query.list().get(0).toString());
            }
            return privateavailable;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getBooked {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            ex.printStackTrace();
            return 0;
        }

    }

    @Override
    public Double getPublisherCPM(Integer pubid) {
        try {

            Double privateavailable = 0.0;

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT AVG(I.cpm) FROM Invtargeting I WHERE  I.publisherId =:pubid";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid);

            if (query.list().size() > 0 && query.list() != null) {
                privateavailable = Double.parseDouble(query.list().get(0).toString());
            }
            return privateavailable;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getBooked {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            ex.printStackTrace();
            return 0.0;
        }

    }

    @Override
    public Double getPublisherTotalRevenue(Integer pubid) {
        try {

            Double privateavailable = 0.0;

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT I.mediaCost FROM Invtargeting I WHERE  I.publisherId =:pubid AND I.mediaCost IS NOT NULL";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid);

            if (query.list().size() > 0 && query.list() != null) {
                privateavailable = Double.parseDouble(query.list().get(0).toString());
            }
            return privateavailable;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getBooked {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            ex.printStackTrace();
            return 0.0;
        }

    }

    @Override
    public Integer getBooked(Integer plcid, Integer pubid, Integer aduid, String flag) {
        try {
            String str = "";
            Integer privateavailable = 0;

            str = (plcid > 0) ? "I.placementId =:plcid" : "I.adUnitId =:aduid";


            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT SUM(I.impressionBooked) FROM Invtargeting I WHERE " + str + " AND I.publisherId =:pubid AND I.status ='APPROVED' AND I.privateFlag=:flag ";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid).setString("flag", flag);
            if (plcid > 0) {
                query.setInteger("plcid", plcid);
            } else {
                query.setInteger("aduid", aduid);
            }

            if (query.list().size() > 0 && query.list() != null) {
                privateavailable = Integer.parseInt(query.list().get(0).toString());
            }
            return privateavailable;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getBooked {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            ex.printStackTrace();
            return 0;
        }

    }

    @Override
    public Integer getRFP(Integer plcid, Integer pubid, Integer aduid, String flag) {
        try {
            String str = "";
            Integer privateRFP = 0;
            str = (plcid > 0) ? "I.placementId =:plcid" : "I.adUnitId =:aduid";

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT SUM(I.impressionBooked) FROM Invtargeting I WHERE " + str + " AND  I.publisherId =:pubid AND (I.status = 'Pending' OR I.status = 'In Progress') AND I.privateFlag=:flag ";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid).setString("flag", flag);
            if (plcid > 0) {
                query.setInteger("plcid", plcid);
            } else {
                query.setInteger("aduid", aduid);
            }

            if (query.list().size() > 0 && query.list() != null) {
                privateRFP = Integer.parseInt(query.list().get(0).toString());
            }


            return privateRFP;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in RFP {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            ex.printStackTrace();
            return 0;
        }

    }

    @Override
    public Double[] getCPM(Integer plcid, Integer pubid, Integer aduid, String flag) {
        try {
            String str = "";

            str = (plcid > 0) ? "I.placementId =:plcid" : "I.adUnitId =:aduid";

            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT MAX(I.cpm),MIN(I.cpm) FROM Invtargeting I WHERE " + str + " AND  I.publisherId =:pubid  AND I.privateFlag=:flag ";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid).setString("flag", flag);

            if (plcid > 0) {
                query.setInteger("plcid", plcid);
            } else {
                query.setInteger("aduid", aduid);
            }

            Object[] a = (Object[]) query.list().get(0);

            //0 = public  //  1 = private 
            return new Double[]{Double.valueOf(a[0].toString()), Double.valueOf(a[1].toString())};

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in CPM {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});

            ex.printStackTrace();
            return new Double[]{0.0, 0.0};
        }

    }

    //NOT USED
    @Override
    public Integer getPublicAvailable(Integer plcid, Integer aduid) {
        try {

            Session session = sessionFactory.getCurrentSession();

            if (plcid > 0) {
                String qstr = "SELECT SUM(A.publicInventoryImpression) FROM Adunitimpression AI WHERE AI.placementId =:plcid ";
                Query query = session.createQuery(qstr).setInteger("plcid", plcid);
                Integer publicAvailable = Integer.parseInt(query.list().get(0).toString());
                return publicAvailable;

            } else {
                String qstr = "SELECT SUM(A.publicInventoryImpression) FROM Adunitimpression AI WHERE AI.adUnitId =:aduid ";
                Query query = session.createQuery(qstr).setInteger("aduid", aduid);
                Integer publicAvailable = Integer.parseInt(query.list().get(0).toString());
                return publicAvailable;

            }

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getPublicAvailable {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return 0;
        }

    }

    //NOT USED
    @Override
    public Integer getPublicBooked(Integer plcid, Integer pubid, Integer aduid) {
        try {
            String str = "";
            Integer percent = 20;


            str = (plcid > 0) ? "I.placementId =:plcid" : "I.adUnitId =:aduid";
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT SUM(I.impressionBooked) FROM Invtargeting I WHERE I.placementId =:plcid AND I.publisherId =:pubid AND I.status ='Approved'";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid);

            if (plcid > 0) {
                query.setInteger("plcid", plcid);
            } else {
                query.setInteger("aduid", aduid);
            }


            Integer privateavailable = Integer.parseInt(query.list().get(0).toString());
            return privateavailable;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getPublicBooked {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return 0;
        }

    }

    //NOT USED
    @Override
    public Integer getPublicRFP(Integer plcid, Integer pubid, Integer aduid) {
        try {
            String str = "";

            str = (plcid > 0) ? "I.placementId =:plcid" : "I.adUnitId =:aduid";
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT SUM(I.impressionBooked) FROM Invtargeting I WHERE  " + str + " AND I.publisherId =:pubid AND I.status = 'Pending' OR I.status = 'In Progress' ";
            Query query = session.createQuery(qstr).setInteger("pubid", pubid);

            if (plcid > 0) {
                query.setInteger("plcid", plcid);
            } else {
                query.setInteger("aduid", aduid);
            }

            Integer privateRFP = Integer.parseInt(query.list().get(0).toString());

            return privateRFP;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getPublicRFP {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return 0;
        }

    }

    @Override
    public Ratecard getRatecardforadunits(Integer plcid, Integer pubid, Integer aduid) {

        try {
            Session session = sessionFactory.getCurrentSession();
            Ratecard r = null;
            if (plcid > 0) {

                String qstr = "SELECT R FROM Placement P,Ratecard R WHERE  P.id =:plcid AND P.specialRateCardId = R.Id";
                Query query = session.createQuery(qstr).setInteger("pubid", pubid).setString("booked", "Approved");
                r = (Ratecard) query.uniqueResult();

            } else {

                String qstr = "SELECT R FROM Adunits A,Ratecard R WHERE  A.id =:aduid AND A.specialRateCardId = R.Id";
                Query query = session.createQuery(qstr).setInteger("pubid", pubid).setString("booked", "Approved");
                r = (Ratecard) query.uniqueResult();
            }
            return r;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getRatecardforadunits {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return null;
        }

    }
} // end class

