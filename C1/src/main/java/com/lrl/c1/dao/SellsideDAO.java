/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Advertiser;
import com.lrl.c1.entity.Ratecard;
import com.lrl.c1.entity.Timeperiod;
import com.lrl.c1.entity.Volumediscount;
import java.util.Date;
import java.util.List;

/**
 *
 * @author logic
 */
public interface SellsideDAO {

    public List<Advertiser> getAllAdvertisers(String advname);

    public Date getMinStartdt(Integer advid);

    public Date getMaxEnddt(Integer advid);

    public Integer getAdvertisersImpressions(Integer advid);

    public Integer getAdvertisersAdunits(Integer advid);

    public Integer getAdvertisersLines(Integer advid);

    public Integer[] getAdvertisersStatus(Integer id);

    public List<Timeperiod> getAllTimePeriods(Integer pubid);

    public List<Ratecard> getAllRateCards(Integer tpid);

    public List<Volumediscount> getAllVolumeDiscount(Integer tpid);

    public boolean RemoveTimePeriod(Integer tpid);

    public boolean RemoveRateCard(Integer rcid);

    public boolean RemoveVolumeDiscount(Integer vdid);

    public Timeperiod saveTimeperiod(Timeperiod t, Integer publisherid);

    public Ratecard saveRateCard(Ratecard r, Integer tpid);

    public Volumediscount saveVolumeDiscount(Volumediscount v, Integer tpid);

    public Integer getRatecardPlacementsCount(Integer rcid);

    public Integer getRatecardAdunitsCount(Integer rcid);

    public Integer getRatecardSubAdunitsCount(Integer rcid);

    public boolean updateAdunitsRatecard(Integer aduid, Integer rcid);

    public boolean updatePlacementsRatecard(Integer aduid, Integer plcid, Integer rcid);

    public Integer getRatecardTotalImpression(Integer id);

    public List<Adunits> getRatecardAdunitsData(Integer rcid);

    public boolean RemoveRatecardAdunits(Integer rcid, Integer aduid);

    public List<Adunitsplacements> PlacementsAdunitsList(Integer pubid);

    public Integer getCountOfAdunitsInPlacements(Integer plcid);

    public Integer getPrivateAvailable(Integer plcid, Integer aduid);

    public Integer getBooked(Integer plcid, Integer pubid, Integer aduid, String flag);

    public Integer getRFP(Integer plcid, Integer pubid, Integer aduid, String flag);

    public Integer getPublicAvailable(Integer plcid, Integer aduid);

    public Integer getPublicBooked(Integer plcid, Integer pubid, Integer aduid);

    public Integer getPublicRFP(Integer plcid, Integer pubid, Integer aduid);

    public Ratecard getRatecardforadunits(Integer plcid, Integer pubid, Integer aduid);

    public List<Adunits> getAllParentAdunits(Integer pubid);

    public List<Adunits> getAllChildAdunits(Integer pubid);

    public List<Adunitsplacements> getRatecardAdunitsData_Placement(Integer rcid);

    public List<Adunits> getRatecardAdunitsData_Adunits(Integer rcid);

    public Integer[] getPercentage(Integer month, Integer year);

    public Double[] getCPM(Integer plcid, Integer pubid, Integer aduid, String flag);

    public Integer getOverviewImpression(Integer pubid);

    public Integer getPublisherBooked(Integer pubid);

    public Double getPublisherCPM(Integer pubid);

    public Double getPublisherTotalRevenue(Integer pubid);

    public List<Adunitsplacements> ChildPlacementsAdunitsList(Integer pubid);
}
