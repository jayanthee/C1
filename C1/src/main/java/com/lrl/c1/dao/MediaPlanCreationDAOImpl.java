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
import com.lrl.c1.entity.Userprofile;
import com.lrl.c1.wrapper.UploadData;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author logic
 */
@Repository("mediaPlanCreateDao")
public class MediaPlanCreationDAOImpl implements MediaPlanCreationDAO {

    @Autowired
    private SessionFactory sessionFactory; 
    private static final Logger LOG = Logger.getLogger(MediaPlanCreationDAOImpl.class.getName());

    public Mediaplan createNewMediaPlan(Mediaplan mediaPlan) {

        try {
            sessionFactory.getCurrentSession().save(mediaPlan);
            sessionFactory.getCurrentSession().flush();
            return mediaPlan;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ###
    public List<Publisher> getGroupofPublishersList() {


        try {

            Session session = sessionFactory.getCurrentSession();
            Criteria c = session.createCriteria(Publisher.class);
            List<Publisher> list = c.list();
            return list;

        } catch (Exception e) {
            System.out.println("Error in getPublihsersList() in DAO Impl");
            e.printStackTrace();
            return null;
        }

    }

    public List<Publisher> getsearchPublishersList(String catid, String pubname, String plctypeid) {


        try {
            List<Publisher> l = null;
            String cnot = "";
            String pnot = "";
            if (catid.equals("0") || catid.equals("")) {
                catid = "0";
                cnot = " NOT ";
            }
            if (pubname.equals("0")) {
                pubname = "";
            }
            if (plctypeid.equals("0") || plctypeid.equals("")) {
                plctypeid = "0";
                pnot = " NOT ";
            }


            if (catid.length() == 0) {
                l = sessionFactory.getCurrentSession().createCriteria(Publisher.class, "pub").add(Restrictions.like("pub.name", "%" + pubname + "%")).list();

            } else {
                String str = "SELECT P FROM Publisher P,Publishercategory pc,Adunits A WHERE P.id = pc.publisherid AND P.id = A.publisherId AND (pc.categoryid " + cnot + " IN (" + catid + ") OR A.placementType " + pnot + " IN (" + plctypeid + ")) AND P.name like '%" + pubname + "%' GROUP By pc.publisherid";
                Query c = sessionFactory.getCurrentSession().createQuery(str);
                l = c.list();
            }
            return l;

        } catch (Exception e) {
            System.out.println("Error in getPublihsersList() in DAO Impl");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Invtargeting> lineList(Integer mpId, Integer lineId) {

        List listVal = null;

        try {

            if (mpId != 0) {
                String str = "SELECT inv FROM Mediaplanline  mpl INNER JOIN mpl.invtargetingList AS inv WHERE mpl.planId = :mpid GROUP BY inv.publisherId, inv.planLineId ";
                Query c = sessionFactory.getCurrentSession().createQuery(str).setInteger("mpid", mpId);
                listVal = c.list();
                for (Iterator it = listVal.iterator(); it.hasNext();) {
                    Invtargeting inv = (Invtargeting) it.next();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listVal;
    }

    public List<Invtargeting> publishersSearchList(Integer mpId, Integer lineId) {

        List listVal = null;

        try {

            if (mpId != 0) {
                String str = "SELECT inv FROM Mediaplanline  mpl INNER JOIN mpl.invtargetingList AS inv WHERE mpl.planId = :mpid GROUP BY inv.publisherId, inv.planLineId ";
                Query c = sessionFactory.getCurrentSession().createQuery(str).setInteger("mpid", mpId);
                listVal = c.list();
                System.out.println(" Inv target lsit ==  " + listVal);
                for (Iterator it = listVal.iterator(); it.hasNext();) {
                    Invtargeting inv = (Invtargeting) it.next();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listVal;
    }

    //USED
    public Integer getPublisherImpressions(Integer mpid, Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            if (mpid != 0) {
                qstr = "SELECT SUM(M.inventoryApproved) As app FROM Mediaplanline M WHERE M.planId = :mpid AND M.publisherId = :pid GROUP BY M.publisherId";
                query = session.createQuery(qstr).setInteger("mpid", mpid).setInteger("pid", pubid);
            } else {
                qstr = "SELECT SUM(M.inventoryApproved) As app FROM Mediaplanline M WHERE M.publisherId = :pid GROUP BY M.publisherId";
                query = session.createQuery(qstr).setInteger("pid", pubid);

            }


            if (query.list().size() > 0) {
                return Integer.valueOf(query.list().get(0).toString());
            } else {
                return 0;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public Integer getPublisherData(Integer mpid, Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            if (mpid != 0) {
                qstr = "SELECT P FROM Publisher P INNER JOIN P.adunitsList AS A INNER JOIN P.publishercontact WHERE mpl.planId = :mpid GROUPr BY inv.publisherId, inv.planLineId ";
                query = sessionFactory.getCurrentSession().createQuery(qstr).setInteger("mpid", mpid);

            } else {
                qstr = "SELECT SUM(M.inventoryApproved) As app FROM Mediaplanline M WHERE GROUP BY M.publisherId";
                query = session.createQuery(qstr);
            }

            if (query.list().size() > 0) {
                return Integer.valueOf(query.list().get(0).toString());
            } else {
                return 0;
            }



        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public List<Publisher> getPublisherList() {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT P FROM Publisher P";
            query = sessionFactory.getCurrentSession().createQuery(qstr);

            List<Publisher> p = query.list();


            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List publishersAdunitsList(Integer publisherId, Integer mplid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT A FROM Adunits A,Invtargeting inv WHERE A.parentId IS NULL AND A.publisherId =:pid AND A.id = inv.adUnitId AND inv.planLineId =:mplid";
            query = sessionFactory.getCurrentSession().createQuery(qstr).setInteger("pid", publisherId).setInteger("mplid", mplid);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    /*
     * returns a list of both invtargeting 
     * and adunits list for subadunits list
     */
    @Override
    public List publishersSubAdunitsList(Integer mplid, Integer publisherId, Integer adunitId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT A FROM Adunits A,Invtargeting inv WHERE A.publisherId =:pid AND A.parentId =:parentid AND inv.planLineId =:mplid AND A.id = inv.adUnitId";
            query = sessionFactory.getCurrentSession().createQuery(qstr).setInteger("pid", publisherId).setInteger("parentid", adunitId).setInteger("mplid", mplid);
            //List<Adunits> aulist = query.list(); 
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean AddToLine(Integer mediaplanid, Integer publisherId, Integer adunitId, Integer placementid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            System.out.println(" media id =  " + mediaplanid + " == " + publisherId + " == " + adunitId + "==" + placementid);
            Mediaplanline mpl = new Mediaplanline();
            Publisher p = (Publisher) session.get(Publisher.class, publisherId);
            Adunits a = (Adunits) session.get(Adunits.class, adunitId);
            mpl.setName(a.getSizes() + a.getStyle());
            mpl.setPublisherId(p);
            mpl.setCpm(a.getCpm());
            Integer impr = this.getAdUnitImpCount(adunitId); // error you get later
            mpl.setInventoryProposed(impr);
            mpl.setStatus("PENDING"); // ###
            Mediaplan mp = (Mediaplan) session.get(Mediaplan.class, mediaplanid);
            mpl.setPlanId(mp);
            mpl.setStartDate(mp.getStartDate());
            mpl.setEndDate(mp.getEndDate());
            mpl.setCreatedBy(new Userprofile(1));
            mpl.setUpdatedBy(new Userprofile(1));
            mpl.setCreated(new Date());
            mpl.setUpdated(new Date());

            session.save(mpl);

            this.AddToSubLine(mediaplanid, mpl, p, adunitId, null, placementid, Double.valueOf(a.getCpm().toString()), impr);


            List<Adunits> list = this.getPlcSubAdUnitsList(adunitId);


            for (Adunits adu : list) {
                Integer adId = adu.getId();
                Integer impression = this.getAdUnitImpCount(adId);
                Double CPM = Double.valueOf(adu.getCpm().toString());
                this.AddToSubLine(mediaplanid, mpl, p, adId, adunitId, placementid, CPM, impression);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean AddToSubLine(Integer mediaplanid, Mediaplanline mpl, Publisher p, Integer adunitId, Integer parentid, Integer placementid, Double cpm, Integer impr) {
        try {
            Session session = sessionFactory.getCurrentSession();

            Invtargeting inv = new Invtargeting();
            inv.setPublisherId(p);
            Adunits a = (Adunits) session.get(Adunits.class, adunitId);
            if (parentid != null) {
                Adunits a1 = (Adunits) session.get(Adunits.class, parentid);
                inv.setParentAdUnitId(a1);
            }
            inv.setAdUnitId(a);
            Adunitsplacements ap = (Adunitsplacements) session.get(Adunitsplacements.class, placementid);
            inv.setPlacementId(ap.getPlacementId());
            inv.setParentAdUnitId(a);
            inv.setCpm(BigDecimal.valueOf(cpm));
            inv.setImpressionBooked(impr);
            inv.setPlanLineId(mpl);
            session.save(inv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<String, Integer> getInventorySelected(Integer mpid) {
        try {
            Map m = null;
            m.put("publishers", this.getPublisher(mpid));
            m.put("lines", this.getLines(mpid));
            m.put("adunits", this.getAdUnits(mpid));
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Integer getPublisher(Integer mpid) {
        try {
            Integer m = null;
            Session session = sessionFactory.getCurrentSession();
            String qstr = "FROM Mediaplanline M WHERE M.planId = :id GROUP BY M.publisherId";
            Query query = session.createQuery(qstr).setInteger("id", mpid);
            m = query.list().size();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public Integer getLines(Integer mpid) {
        try {
            Integer l = 0;
            Session session = sessionFactory.getCurrentSession();
            String qstr = "FROM Mediaplanline M WHERE M.planId = :id";
            Query query = session.createQuery(qstr).setInteger("id", mpid);
            l = query.list().size();
            return l;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public Integer getAdUnits(Integer mpid) {
        try {
            Integer a = 0;
            Integer adunits = 0;
            Session session = sessionFactory.getCurrentSession();
            String qstr = "FROM Mediaplanline M WHERE M.planId = :id";
            Query query = session.createQuery(qstr).setInteger("id", mpid);
            List<Mediaplanline> lst = query.list();
            ListIterator mpl = lst.listIterator();
            while (query.list().listIterator().hasNext()) {
                Mediaplanline mpll = (Mediaplanline) mpl.next();
                adunits += mpll.getInvtargetingList().size();
            }


            return adunits;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    // USED###
    // Mediaplanline is nothing but placements
    public List<Placements> getPlacementsLines(Integer pid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "FROM Placements P WHERE P.publisherId = :pid";
            query = session.createQuery(qstr).setInteger("pid", pid);
            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Integer getPlacementsLinesAdUnits(Integer mplid, Integer pid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "FROM Invtargeting I WHERE I.planLineId = :mplid AND  I.publisherId = :pid";
            query = session.createQuery(qstr).setInteger("mplid", mplid).setInteger("pid", pid);

            return query.list().size();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Adunitsplacements> getPlcAdUnitsList(Integer plcid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT A FROM Adunitsplacements A WHERE A.placementId = :plcid ";
            query = session.createQuery(qstr).setInteger("plcid", plcid);

            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //USED ###
    public List<Adunits> getPlcSubAdUnitsList(Integer adUnitId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT A FROM Adunits A WHERE A.parentId = :aduid ";
            query = session.createQuery(qstr).setInteger("aduid", adUnitId);

            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    //USED###
    @Override
    public Integer getPublisherPlacementCount(Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT P FROM Placements P WHERE P.publisherId = :pid";
            query = session.createQuery(qstr).setInteger("pid", pubid);
            return query.list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //USED### 
    public Integer getPublisherAdunitsCount(Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT P FROM Placements P,Adunitsplacements AP WHERE P.publisherId = :pid AND P.id = AP.placementId";
            query = session.createQuery(qstr).setInteger("pid", pubid);
            return query.list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //USED### 
    public Integer getPlacementAdunitsCount(Integer plcid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT I FROM Invtargeting I WHERE I.placementId = :plcid";
            query = session.createQuery(qstr).setInteger("plcid", plcid);
            return query.list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //USED### 
    public Integer getPlacementImpression(Integer plcid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT SUM(I.impressionBooked) AS booked FROM Invtargeting I WHERE I.placementId = :plcid";
            query = session.createQuery(qstr).setInteger("plcid", plcid);
            if (query.list().size() > 0) {
                return Integer.valueOf(query.list().get(0).toString());
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //USED ###
    public Integer getAdUnitImpCount(Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT SUM(I.impressionBooked) AS booked FROM Invtargeting I WHERE I.adUnitId = :aduid";
            query = session.createQuery(qstr).setInteger("aduid", aduid);
            if (query.list().size() > 0) {
                return Integer.valueOf(query.list().get(0).toString());
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //NOTUSED ###

    public Double getAdUnitCPM(Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT AVG(I.cpm) AS CPM FROM Invtargeting I WHERE I.adUnitId = :aduid";
            query = session.createQuery(qstr).setInteger("aduid", aduid);
            if (query.list().size() > 0) {
                return Double.valueOf(query.list().get(0).toString());
            } else {
                return 0.0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // 3rd page    
    @Override
    public boolean DeleteSubAdunits(Integer mplid, Integer publisherId, Integer adunitId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            query = session.createQuery("DELETE Invtargeting I WHERE I.planLineId = :planlineid AND I.publisherId = :publisherid AND I.adUnitId = :adunitid");
            query.setInteger("planlineid", mplid).setInteger("publisherid", publisherId).setInteger("adunitid", adunitId);
            int result = query.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean DeleteAdunits(Integer mplid, Integer publisherId, Integer adunitId, Integer plcid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;

            if (plcid > 0) {

                query = session.createQuery("DELETE Invtargeting I WHERE I.planLineId = :planlineid AND I.publisherId = :publisherid AND I.placementId = :plcid OR I.parentAdUnitId = :plcid");
                query.setInteger("planlineid", mplid).setInteger("publisherid", publisherId).setInteger("plcid", plcid);

            } else {
                query = session.createQuery("DELETE Invtargeting I WHERE I.planLineId = :planlineid AND I.publisherId = :publisherid AND I.adUnitId = :adunitid OR I.parentAdUnitId = :adunitid");
                query.setInteger("planlineid", mplid).setInteger("publisherid", publisherId).setInteger("adunitid", adunitId);


            }

            int result = query.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean DeletePublisher(Integer mpid, Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            query = session.createQuery("DELETE Mediaplanline M WHERE M.planId = :mpid AND M.publisherId = :pubid");
            query.setInteger("mpid", mpid).setInteger("pubid", pubid);
            int result = query.executeUpdate();

            if (result > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean DeletePlacement(Integer mplid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            query = session.createQuery("DELETE Mediaplanline M WHERE M.id = :mplid");
            query.setInteger("mplid", mplid);//.setInteger("pubid", pubid);
            int result = query.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public List getPublisherPieChartData(Integer mid) {

        try {
            Session session = sessionFactory.getCurrentSession();

            String subqstr = "SELECT SUM(ML.inventoryApproved) AS impbooked FROM Mediaplanline ML , Publisher P WHERE ML.planId = :mid AND ML.publisherId = P.id";
            String qstr = "SELECT P.id, P.name,SUM(ML.inventoryApproved) AS impbooked,  (" + subqstr + ") AS TOT FROM Mediaplanline ML , Publisher P WHERE ML.planId = :mid AND ML.publisherId = P.id GROUP BY ML.publisherId";
            Query query = session.createQuery(qstr).setInteger("mid", mid);
            System.out.println("Piec cahrt size ==  " + query.list().size());
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List getBarChartData(Integer mid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT ML.name AS linename, ML.publisherId, DATE_FORMAT(ML.startDate,'%Y-%m-%d'), P.name, SUM(I.impressionBooked) AS IMP FROM Mediaplanline ML, Publisher P, Mediaplan M, Invtargeting I WHERE ML.planId = :mid AND M.id = ML.planId AND P.id = ML.publisherId AND ML.id=I.planLineId AND DATE_FORMAT(ML.startDate,'%yy-%mm-%dd') >= DATE_FORMAT(M.startDate,'%yy-%mm-%dd') AND DATE_FORMAT(ML.endDate,'%yy-%mm-%dd')<=DATE_FORMAT(M.endDate,'%yy-%mm-%dd') GROUP BY DATE_FORMAT(ML.startDate ,'%yy-%mm-%dd') , ML.name ORDER BY DATE_FORMAT(ML.startDate,'%YY-%mm-%dd')";

            Query query = session.createQuery(qstr).setInteger("mid", mid);

            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Fourth Page start
    // USED ###
    @Override
    public boolean DeleteCreativeList(Integer cid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Creative cst = (Creative) session.get(Creative.class, cid);
            session.delete(cst);
            session.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean DeleteCreativeListForPlan(Integer cid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Creativelist cst = (Creativelist) session.get(Creativelist.class, cid);
            session.delete(cst);
            session.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    // USED ### 
    public List<Creative> showCreativeListforline(Integer mplid) {
        try {
            Session session = sessionFactory.getCurrentSession();



            String qstr = "SELECT C FROM Creative C , Creativelist L WHERE C.planLineId = :mplid AND L.id = C.creativeListId";
            Query query = session.createQuery(qstr).setInteger("mplid", mplid);
            System.out.println(" Query list size ===  " + query.list().size());
            return query.list();

        } catch (Exception e) {
            System.out.println(" ERROR On creative table  ");
            e.printStackTrace();
            return null;
        }


    }

    // USED ### 
    public List<Creativelist> showCreativeListForMediaplan(Integer mpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT L FROM Creativelist L WHERE L.planId =:mpid";
            Query query = session.createQuery(qstr).setInteger("mpid", mpid);
            System.out.println("  query == " + query.getQueryString());
            System.out.println(" Query list size ===  " + query.list().size());
            return query.list();

        } catch (Exception e) {
            System.out.println(" ERROR On creative table  ");
            e.printStackTrace();
            return null;
        }


    }

    //USED ### 
    public List<Creativelist> showCreativeList(Integer mplid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT C FROM Creative C , Creativelist L WHERE C.planLineId = :mplid AND L.id = C.creativeId";
            Query query = session.createQuery(qstr).setInteger("mplid", mplid);
            return query.list();

        } catch (Exception e) {
            System.out.println(" ERROR On creative table  ");
            e.printStackTrace();
            return null;
        }


    }

    //USED ###
    public UploadData uploadCreative(UploadData ud) {
        try {

            System.out.println("  " + ud.getLink() + ud.getSize() + ud.getName() + ud.getMediaPlanId() + ud.getMediaPlanLineId());
            Session session = sessionFactory.getCurrentSession();
            Creativelist cst = null;
            Mediaplan mp = (Mediaplan) session.get(Mediaplan.class, ud.getMediaPlanId());
            cst = new Creativelist();
            cst.setPlanId(mp);
            cst.setName(ud.getName());
            cst.setLink(ud.getLink());
            cst.setSizes(ud.getSize());
            cst.setCreated(new Date());
            cst.setUpdated(new Date());
            session.save(cst);
            Integer i = 0;

            ud.setCid(cst.getId());


            if (ud.getMediaPlanLineId() > 0) {

                Mediaplanline mpl = (Mediaplanline) session.get(Mediaplanline.class, ud.getMediaPlanLineId());

                i = this.savelinecreatives(mpl, cst, i);

            } else {
                List<Mediaplanline> mpllist = this.getallMediaplanline(ud.getMediaPlanId(), ud.getSize());

                for (Mediaplanline mpline : mpllist) {
                    UploadData ud1 = new UploadData();
                    System.out.println("  " + ud1.getLink() + ud1.getSize() + ud1.getName() + ud1.getMediaPlanId() + ud1.getMediaPlanLineId());

                    i = this.savelinecreatives(mpline, cst, i);
                }


            }
            return ud;
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG.log(Level.SEVERE, "Exception in uploadCreative {0}  {1}", new Object[]{ex.getMessage(), ex.getClass()});

            return null;
        }


    }

    public boolean MediaplanExist(Integer mpid) {
        Session session = sessionFactory.getCurrentSession();
        Mediaplan mp = (Mediaplan) session.get(Mediaplan.class, mpid);
        if (mp == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean MediaplanlineExist(Integer mplid) {
        Session session = sessionFactory.getCurrentSession();
        Mediaplanline mp = (Mediaplanline) session.get(Mediaplanline.class, mplid);
        if (mp == null) {
            return false;
        } else {
            return true;
        }
    }

    public Integer savelinecreatives(Mediaplanline mpl, Creativelist clst, Integer i) {
        Session session = sessionFactory.getCurrentSession();
        Creative cr = new Creative();
        cr.setId(null);

        cr.setCreated(new Date());
        cr.setPlanLineId(mpl);
        cr.setCreativeListId(clst);
        cr.setUpdated(new Date());
        session.saveOrUpdate(cr);
        return i++;

    }
//## NOT USED

    public void savelinecreatives1(UploadData ud) {
        Session session = sessionFactory.getCurrentSession();
        Mediaplan mp = (Mediaplan) session.get(Mediaplan.class, ud.getMediaPlanId());
        Mediaplanline mpl = (Mediaplanline) session.get(Mediaplanline.class, ud.getMediaPlanLineId());
        Creative cr = null;
        if (ud.getCid() == null) {
            cr = new Creative();
            Creativelist i = getCreativeExist(mp.getId(), "");
            cr = (Creative) session.get(Creative.class, i);
            if (ud.getCid() != null) {
                cr.setId(cr.getId());
            } else {
                cr.setCreated(new Date());

            }
            cr.setPlanLineId(mpl);
            cr.setUpdated(new Date());
            session.saveOrUpdate(cr);


        } else {
            cr = (Creative) session.get(Creative.class, ud.getCid());
        }

        Creativelist cst = new Creativelist();
        cst.setCreated(new Date());
        cst.setUpdated(new Date());
        session.save(cst);
    }

    public Creativelist getCreativeExist(Integer mpid, String size) {
        Creativelist id = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "SELECT C FROM Creativelist C WHERE  C.planId =:mpid AND C.size =:size";
            Query query = session.createQuery(qstr).setInteger("mpid", mpid).setString("size", size);

            id = (Creativelist) query.uniqueResult();

            return id;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getCreativeExist {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            return id;
        }

    }

    public List<Mediaplanline> getallMediaplanline(Integer mpid, String sizes) {

        try {
            Session session = sessionFactory.getCurrentSession();

            System.out.println("MPID ==     " + mpid);
            String qstr = "SELECT M FROM Mediaplanline M,Invtargeting I,Adunits A WHERE  A.sizes =:sizes AND A.id = I.adUnitId AND M.planId=:mpid AND I.planLineId = M.id";
            Query query = session.createQuery(qstr).setInteger("mpid", mpid).setString("sizes", sizes);
            System.out.println("  " + query.getQueryString());


            List<Mediaplanline> mpl = query.list();
            return mpl;

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in getallMediaplanline {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            ex.printStackTrace();
            return null;
        }

    }

    //USED ###
    @Override
    public Mediaplan getMediaPlan(Integer mpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Mediaplan mp = (Mediaplan) session.get(Mediaplan.class, mpid);
            return mp;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //NOT USED
    public Integer getplacementId(String plcType) {
        try {
            String qstr = "SELECT A.id FROM Listofvalues A WHERE A.value =:plctype AND A.name= :plctypename";
            Query query = sessionFactory.getCurrentSession().createQuery(qstr).setString("plctype", plcType).setString("plctypename", "PlacementType");

            return Integer.parseInt(query.list().get(0).toString());
        } catch (Exception e) {
            return 0;
        }



    }

    //USED ###
    @Override
    public List<Mediaplanline> getMediaPlanlineCreatives(Integer mpid, Integer plcTypeid) {
        try {

            Session session = sessionFactory.getCurrentSession();
            if (plcTypeid == 0) {
                String qstr = "SELECT M FROM Mediaplanline M,Invtargeting I, Adunits A WHERE M.planId = :mpid AND M.id=I.planLineId AND (I.adUnitId= A.id)  GROUP BY M.id";
                Query query = session.createQuery(qstr).setInteger("mpid", mpid);//.setInteger("plcid", plcTypeid);
                return query.list();

            } else {
                String qstr = "SELECT M FROM Mediaplanline M,Invtargeting I, Adunits A WHERE M.planId = :mpid AND M.id=I.planLineId AND (I.adUnitId= A.id) AND A.placementType = :plcid GROUP BY M.id";
                Query query = session.createQuery(qstr).setInteger("mpid", mpid).setInteger("plcid", plcTypeid);
                return query.list();
            }


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //USED ###
    public List getAdUnitCreativesSizes(Integer mplid, Integer plcTypeid) {

        try {
            Session session = sessionFactory.getCurrentSession();

            if (plcTypeid == 0) {
                String qstr = "SELECT A.sizes FROM Invtargeting I, Adunits A WHERE  I.planLineId=:mplid AND I.adUnitId= A.id  GROUP BY A.sizes";

                Query query = session.createQuery(qstr).setInteger("mplid", mplid);//.setInteger("plcid", plcTypeid);

                System.out.println("  " + query.list().size());
                return query.list();
            } else {
                String qstr = "SELECT A.sizes FROM Invtargeting I, Adunits A WHERE  I.planLineId=:mplid AND I.adUnitId= A.id AND A.placementType = :plcid GROUP BY A.sizes";

                Query query = session.createQuery(qstr).setInteger("mplid", mplid).setInteger("plcid", plcTypeid);

                System.out.println("  " + query.list().size());
                return query.list();

            }

        } catch (Exception e) {
            System.out.println("getAdUnitCreatives sizes");
            e.printStackTrace();
            return null;
        }
    }

    //NOT USED ###
    @Override
    public List<Invtargeting> getAdUnitCreatives(Integer mplid, Integer plcTypeid) {

        try {
            Session session = sessionFactory.getCurrentSession();
            // Integer plcid = this.getplacementId(plcType);

            if (plcTypeid == 0) {

                String qstr = "SELECT I FROM Mediaplanline M,Invtargeting I, Adunits A WHERE M.id = :mpid AND M.id=I.planLineId AND I.adUnitId= A.id AND I.parentAdUnitId IS NULL";
                Query query = session.createQuery(qstr).setInteger("mpid", mplid).setInteger("plctype", plcTypeid);

                System.out.println("  " + query.list().size());
                return query.list();
            } else {
                String qstr = "SELECT I FROM Mediaplanline M,Invtargeting I, Adunits A WHERE M.id = :mpid AND M.id=I.planLineId AND I.adUnitId= A.id AND  A.placementType = :plctype AND I.parentAdUnitId IS NULL";
                Query query = session.createQuery(qstr).setInteger("mpid", mplid).setInteger("plctype", plcTypeid);

                System.out.println("  " + query.list().size());
                return query.list();

            }

        } catch (Exception e) {
            System.out.println("getAdUnitCreatives");
            e.printStackTrace();
            return null;
        }
    }

    //NOT USED ###
    @Override
    public List<Invtargeting> getSubAdUnitCreatives(Integer mplid, Integer plcTypeid, Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            if (plcTypeid == 0) {
                String qstr = "SELECT I FROM Mediaplanline M,Invtargeting I, Adunits A WHERE M.id = :mpid AND M.id=I.planLineId AND I.adUnitId= A.id  AND I.parentAdUnitId = :aduid";
                Query query = session.createQuery(qstr).setInteger("mpid", mplid).setInteger("invType", plcTypeid).setInteger("aduid", aduid);

                return query.list();
            } else {

                String qstr = "SELECT I FROM Mediaplanline M,Invtargeting I, Adunits A WHERE M.id = :mpid AND M.id=I.planLineId AND I.adUnitId= A.id AND A.placementType = :plctype AND I.parentAdUnitId = :aduid";
                Query query = session.createQuery(qstr).setInteger("mpid", mplid).setInteger("invType", plcTypeid).setInteger("aduid", aduid);

                return query.list();
            }

        } catch (Exception e) {
            System.out.println("getAdUnitCreatives");
            e.printStackTrace();
            return null;
        }
    }
} // END CLASS
