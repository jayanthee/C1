/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.entity.Ratecard;
import com.lrl.c1.entity.Timeperiod;
import com.lrl.c1.entity.Volumediscount;
import com.lrl.c1.wrapper.AdunitsPlacementsData;
import com.lrl.c1.wrapper.AdvertiserData;
import com.lrl.c1.wrapper.PublisherData;
import com.lrl.c1.wrapper.RatecardData;
import java.util.List;

public interface SellsideService {

    public List<AdvertiserData> getAllAdvertisers(String advname);

    public List<RatecardData> getAllTimePeriods(Integer pubid);

    public List<RatecardData> getAllRateCards(Integer tpid);

    public List<RatecardData> getAllVolumeDiscount(Integer tpid);

    public boolean RemoveTimePeriod(Integer tpid);

    public boolean RemoveRateCard(Integer rcid);

    public boolean RemoveVolumeDiscount(Integer vdid);

    public Timeperiod saveTimeperiod(Timeperiod t, Integer publisherid);

    public Ratecard saveRateCard(Ratecard r, Integer tpid);

    public Volumediscount saveVolumeDiscount(Volumediscount v, Integer tpid);

    public boolean updateAdunitsRatecard(Integer aduid, Integer rcid);

    public boolean updatePlacementsRatecard(Integer aduid, Integer plcid, Integer rcid);

    public List<AdunitsPlacementsData> getRatecardAdunitsData(Integer rcid);

    public List<AdunitsPlacementsData> getDoubleClickForPublisher(Integer pubid, Integer month, Integer year);

    public PublisherData getGraphOverview(Integer pubid, Integer month, Integer year);
}
