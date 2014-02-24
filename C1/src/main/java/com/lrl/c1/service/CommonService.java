/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.entity.Account;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.entity.Userprofile;
import java.util.List;
import java.util.Map;

public interface CommonService {

    public String getPublisherOverviewByName(String publisher);

    public String getPublisherOverviewById(int publisher_id);

    public Map getPublisherContactAsMap(int publisher_id);

    public String getPublisherContactAsJson(int publisher_id);

    public String getGender();

    public String getAgeRange();

    public String getPlacementTypes();

    public String getCategory();

    public String getCountries();

    public String getStates(String country);

    public String getCities(String state);

    public List getGenderList();

    public List getAgeRangeList();

    public List getPlacementTypesList();

    public List getCategoryList();

    public List getCountriesList();

    public List getStatesList(String country);

    public List getCitiesList(String state);

    public List getPublisherIdList(String categoryidlist);

    public List<Publisher> getSearchPublishers(String categorylist);

    public boolean authenticate(String username, String Pasword);

    public String generatePassword();

    public Account createNewAccount(Account account);

    public Userprofile createNewUserProfile(Userprofile userprofile);

    public String encryptPassword(String passWord);
}
