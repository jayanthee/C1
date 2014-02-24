/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.REST;

import com.lrl.c1.entity.Ratecard;
import com.lrl.c1.entity.Timeperiod;
import com.lrl.c1.entity.Volumediscount;
import com.lrl.c1.service.MediaPlanCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lrl.c1.service.SellsideService;
import com.lrl.c1.wrapper.AdunitsPlacementsData;
import com.lrl.c1.wrapper.AdvertiserData;
import com.lrl.c1.wrapper.PublisherData;
import com.lrl.c1.wrapper.RatecardData;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author logic
 */
@Component
@Path("/sellside")
public class SellsideWebservice {

    private static final Logger LOG = Logger.getLogger(SellsideWebservice.class.getName());
    @Autowired
    private SellsideService sellsideService;
    @Autowired
    private MediaPlanCreationService mediaplancreationService;
    SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat mdy = new SimpleDateFormat("MM/dd/yyyy");

    // FIRST PAGE START ### NOT USED
    @GET
    @Path("/advertiser/{advname:.*}") // Layer 1
    @Produces({"application/json"})
    public List<AdvertiserData> getAdvertisers(@PathParam("advname") String advname) {
        // System.out.println("   hai from advertiser");
        List<AdvertiserData> m = sellsideService.getAllAdvertisers(advname);
        return m;
    }

    @POST
    @Path("/savetimeperiod")
    @Consumes
    @Produces({"application/json"})
    @Transactional
    public Response saveTimeperiod(@FormParam("timeperiodid") Integer timeperiodid, @FormParam("name") String name,
            @FormParam("startDate") String sdt,
            @FormParam("endDate") String edt, @FormParam("status") String status, @FormParam("publisherid") Integer publisherid) {
        try {


            Timeperiod timeperiod = new Timeperiod();
            if (timeperiodid == 0 || timeperiodid == null || timeperiodid.equals("0")) {

                timeperiod.setId(null);//ratecarddata.getTimeperiodid());
            } else {
                timeperiod.setId(timeperiodid);
            }
            timeperiod.setName(name);
            timeperiod.setStartDate(ymd.parse(ymd.format(mdy.parse(sdt))));
            timeperiod.setEndDate(ymd.parse(ymd.format(mdy.parse(edt))));
            timeperiod.setStatus(status);

            timeperiod = sellsideService.saveTimeperiod(timeperiod, publisherid);

            System.out.println("timeperiod ==" + timeperiod.getId());

            Map<Object, Object> m = new HashMap<Object, Object>();
            m.put("timeperiodid", timeperiod.getId());
            m.put("name", timeperiod.getName());
            m.put("startDate", mdy.format(timeperiod.getStartDate()));
            m.put("endDate", mdy.format(timeperiod.getEndDate()));
            m.put("status", timeperiod.getStatus());
            m.put("publisherid", timeperiod.getPublisherId().getId());

            return Response.status(200).entity(m).build();

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception in saveTimeperiod {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});
            ex.printStackTrace();;
            return Response.status(204).entity(LOG).build();
        }


    }

    @POST
    @Path("/saveratecard")
    @Consumes
    @Produces({"application/json"})
    @Transactional
    public Response saveRateCard(@FormParam("timeperiodid") Integer timeperiodid,
            @FormParam("ratecardid") Integer ratecardid,
            @FormParam("name") String name,
            @FormParam("price") Double price,
            @FormParam("status") String status) {
        try {
            Ratecard ratecard = new Ratecard();

            if (ratecardid == 0 || ratecardid == null || ratecardid.equals("0")) {
                ratecard.setId(null);
            } else {
                ratecard.setId(ratecardid);
            }
            ratecard.setName(name);

            ratecard.setPrice(price);
            ratecard.setStatus(status);
            ratecard = sellsideService.saveRateCard(ratecard, timeperiodid);
            Map<Object, Object> m = new HashMap<Object, Object>();
            m.put("ratecardid", ratecard.getId());
            m.put("timeperiodid", ratecard.getTimePeriodId().getId());
            m.put("name", ratecard.getName());
            m.put("price", ratecard.getPrice());
            m.put("status", ratecard.getStatus());




            return Response.status(200).entity(m).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG.log(Level.SEVERE, "Exception in saveRateCard {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});

            return Response.status(204).entity(LOG).build();
        }

    }

    @POST
    @Path("/savevolumediscount")
    @Consumes
    @Produces({"application/json"})
    @Transactional
    public Response saveVolumediscount(
            @FormParam("timeperiodid") Integer timeperiodid,
            @FormParam("volumediscountid") Integer volumediscountid,
            @FormParam("name") String name,
            @FormParam("discount") Double discount,
            @FormParam("totaldays") Integer totaldays) {

        try {
            Volumediscount vd = new Volumediscount();

            if (volumediscountid == 0 || volumediscountid == null || volumediscountid.equals("0")) {
                vd.setId(null);
            } else {
                vd.setId(volumediscountid);
            }

            vd.setName(name);
            vd.setDiscountPercent(BigDecimal.valueOf(discount));
            vd.setTotalDays(totaldays);
            vd = sellsideService.saveVolumeDiscount(vd, timeperiodid);

            Map<Object, Object> m = new HashMap<Object, Object>();
            m.put("volumediscountid", vd.getId());
            m.put("timeperiodid", vd.getTimePeriodId().getId());
            m.put("name", vd.getName());
            m.put("discount", vd.getDiscountPercent());
            m.put("totaldays", vd.getTotalDays());
            return Response.status(200).entity(m).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG.log(Level.SEVERE, "Exception in saveVolumediscount {0}  {1}", new Object[]{ex.getMessage(), ex.getLocalizedMessage()});

            return Response.status(204).entity(LOG).build();
        }


    }

    @GET
    @Path("/timeperiods/{pubid:.*}")
    @Produces({"application/json"})
    public List<RatecardData> getAllTimePeriods(@PathParam("pubid") Integer pubid) {
        return sellsideService.getAllTimePeriods(pubid);

    }

    @GET
    @Path("/ratecards/{timeperiodid}")
    @Produces({"application/json"})
    public List<RatecardData> getAllRateCards(@PathParam("timeperiodid") Integer timeperiodid) {
        return sellsideService.getAllRateCards(timeperiodid);

    }

    @GET
    @Path("/volumediscounts/{timeperiodid}")
    @Produces({"application/json"})
    public List<RatecardData> getAllVolumeDiscount(@PathParam("timeperiodid") Integer timeperiodid) {
        return sellsideService.getAllVolumeDiscount(timeperiodid);

    }

    @GET
    @Path("/removetimeperiod/{timeperiodid}")
    @Produces({"application/json"})
    @Transactional
    public boolean RemoveTimePeriod(@PathParam("timeperiodid") Integer timeperiodid) {
        return sellsideService.RemoveTimePeriod(timeperiodid);

    }

    @GET
    @Path("/removeratecard/{ratecardid}")
    @Produces({"application/json"})
    @Transactional
    public boolean RemoveRateCard(@PathParam("ratecardid") Integer ratecardid) {
        return sellsideService.RemoveRateCard(ratecardid);

    }

    @GET
    @Path("/removevolumediscount/{volumediscountid}")
    @Produces({"application/json"})
    @Transactional
    public boolean RemoveVolumeDiscount(@PathParam("volumediscountid") Integer volumediscountid) {
        return sellsideService.RemoveVolumeDiscount(volumediscountid);

    }

    @GET
    @Path("/updateadunitsratecards/{aduid}/{plcid}/{ratecardid}")
    @Produces({"application/json"})
    @Transactional
    public boolean updatePlacementsRatecard(@PathParam("aduid") Integer aduid, @PathParam("plcid") Integer plcid, @PathParam("ratecardid") Integer ratecardid) {
        try {
            return sellsideService.updatePlacementsRatecard(aduid, plcid, ratecardid);
        } catch (Exception e) {
            return false;
        }

    }

    @GET
    @Path("/ratecardadunitsdata/{ratecardid}")
    @Produces({"application/json"})
    public List<AdunitsPlacementsData> getRatecardAdunitsData(@PathParam("ratecardid") Integer ratecardid) {

        try {
            List<AdunitsPlacementsData> adu = sellsideService.getRatecardAdunitsData(ratecardid);

            return adu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /* 
     * Inventory Overview
     */
    @GET
    @Path("/inventoryoverviewgraph/{pubid}/{month}/{year}")
    @Produces({"application/json"})
    public List<AdunitsPlacementsData> getDoubleClickForPublisher(@PathParam("pubid") Integer pubid,
            @PathParam("month") Integer month,
            @PathParam("year") Integer year) {

        try {
            List<AdunitsPlacementsData> adu = sellsideService.getDoubleClickForPublisher(pubid, month, year);
            return adu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @GET
    @Path("/inventoryoverview/{pubid}/{month}/{year}")
    @Produces({"application/json"})
    public PublisherData getPublisheroverviewgraph(@PathParam("pubid") Integer pubid,
            @PathParam("month") Integer month,
            @PathParam("year") Integer year) {

        try {
            PublisherData adu = sellsideService.getGraphOverview(pubid, month, year);
            return adu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    
}
