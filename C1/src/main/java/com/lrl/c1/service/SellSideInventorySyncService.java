/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.wrapper.SellSideSyncSettingData;
import java.util.List;

/**
 *
 * @author logic
 */
public interface SellSideInventorySyncService {
    
    public boolean syncAdUnits(Integer venId, Integer pubId, Integer invSetId ,String display);

    public boolean syncPlacements();
    
    public SellSideSyncSettingData createVendors(SellSideSyncSettingData sync);
    
    public SellSideSyncSettingData createInvSync(SellSideSyncSettingData sync);
    
    public SellSideSyncSettingData updateVendors(SellSideSyncSettingData sync);
    
    public SellSideSyncSettingData updateInvSync(SellSideSyncSettingData sync);
    
    public boolean deleteVendors(Integer venId);
    
    public boolean deleteSyncInvVendors(Integer syncId);

    public List<SellSideSyncSettingData> getAllVendorsList();
    
    public List<SellSideSyncSettingData> getVendorInvSettingList(Integer venId);
    
    public SellSideSyncSettingData getVendor(Integer venId);

    public List<SellSideSyncSettingData> fetchVendorsListData();

    public boolean updateImpressionSetting(Integer venId, Integer month, Integer year, String prvtflag, Integer percent, Integer pubid);

    public boolean twelveMonthImpressionSetting(Integer syncId, Integer impression, Integer pubPercent, Integer prvtPercent, Integer month, Integer year);
}
