/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

//import c1.buyside.entity.Mediaplan;
import com.lrl.c1.entity.Account;
import com.lrl.c1.entity.Listofvalues;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.entity.Publishercategory;
import com.lrl.c1.entity.Publishercontact;
import com.lrl.c1.entity.Userprofile;
import java.util.List;

/**
 *
 * @author logic
 */
public interface CommonDAO {

    //public List<Categorylist> GetAllCategory();
    // public List<Placementtypelist> GetAllPlacements();
    public List<Publisher> getPublisherOverviewByName(String publisher);

    public List<Publisher> getPublisherOverviewById(int id);

    public List<Publishercontact> getPublisherContact(int publisher_id);

    public List<Listofvalues> getGender(String gen);

    public List<Listofvalues> getAgeRange();

    public List<Listofvalues> getPlacementTypes();

    public List<Listofvalues> getCategoryList();

    public List<Listofvalues> getCountries();

    public List<Listofvalues> getStates(String country);

    public List<Listofvalues> getCities(String state);

    public List<Publishercategory> getPublishersId(String categoryid);

    public List<Publisher> getSearchPublishers(String categorylist);

    public List<Userprofile> getUser(String username);

    public Account createNewAccount(Account account);

    public Userprofile createNewUserProfile(Userprofile userprofile);
}
