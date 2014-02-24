/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

import com.lrl.c1.entity.Inventorysettings;
import com.lrl.c1.entity.Vendors;
import com.lrl.c1.wrapper.AdunitsData;
import com.lrl.c1.wrapper.SellSideSyncSettingData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author logic
 */
public interface SellSideInventorySyncDAO {

    public boolean syncAdunitsTable(Map<String, AdunitsData> dataObj, Map<String, String> map, Integer venId, Integer pubId, Integer invSetId, String display);

    public boolean syncPlacementTable(Map<String, Object> obj1, List<AdunitsData> obj2);

    public SellSideSyncSettingData createVendors(SellSideSyncSettingData sync);

    public SellSideSyncSettingData createInvSync(SellSideSyncSettingData sync);

    public SellSideSyncSettingData updateVendors(SellSideSyncSettingData sync);

    public SellSideSyncSettingData updateInvSync(SellSideSyncSettingData sync);

    public boolean deleteVendors(Integer venId);

    public boolean deleteInvSyncVendors(Integer syncId);

    public SellSideSyncSettingData setSyncSettingsData(Integer syncId);

    public List<Vendors> getVendorsList();

    public List<Inventorysettings> getSyncSetVendorsData(Integer venid);

    public SellSideSyncSettingData getVendor(Integer venId);

    public List<Inventorysettings> fetchGrpVendorsData();

    public boolean updateImpressionSetting(Integer venId, Integer month, Integer year, String prvtflag, Integer percent, Integer pubId);

    public boolean yearlyImpressionSetting(Integer syncId, Integer impression, Integer pubPercent, Integer prvtPercent, Integer month, Integer year);
}
