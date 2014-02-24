/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.dao.CommonDAO;
import com.lrl.c1.dao.MediaPlanDAO;
import com.lrl.c1.entity.Account;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.lrl.c1.entity.Listofvalues;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.entity.Publishercategory;
import com.lrl.c1.entity.Publishercontact;
import com.lrl.c1.entity.Userprofile;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author logic
 */
@Service("CommonService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDAO commonDAO;
    private MediaPlanDAO mediaplanDao;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    SimpleDateFormat sdfhms = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    Integer id = -1;
    String value = "No data available";

    public String getPublisherOverviewByName(String publisher) {
        String overview = new String();
        List<Publisher> pub = commonDAO.getPublisherOverviewByName(publisher);
        ListIterator recordings = pub.listIterator();
        while (recordings.hasNext()) {
            Publisher r = (Publisher) recordings.next();
            overview = r.getOverview();
        }
        return overview;
    }

    public String getPublisherOverviewById(int id) {
        String overview = new String();
        List<Publisher> pub = commonDAO.getPublisherOverviewById(id);
        ListIterator recordings = pub.listIterator();
        while (recordings.hasNext()) {
            Publisher r = (Publisher) recordings.next();
            overview = r.getOverview();
        }
        return overview;
    }

    @Override
    public Map getPublisherContactAsMap(int publisher_id) {
        List<Publishercontact> publisher_contact = commonDAO.getPublisherContact(publisher_id);
        HashMap m = new HashMap();

        ListIterator recordings = publisher_contact.listIterator();
        while (recordings.hasNext()) {
            Publishercontact r = (Publishercontact) recordings.next();
            m.put("Id", r.getId());
            m.put("PublisherId", r.getPublisherId().getId());
            m.put("FirstName", r.getFirstName());
            m.put("LastName", r.getLastName());
            m.put("EmailId", r.getEmailId());
            m.put("ContactNo", r.getContactNo());
            m.put("Role", r.getRole());
            m.put("Image", r.getImage());
        }

        return m;
    }

    @Override
    public String getPublisherContactAsJson(int publisher_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getGender() {
        String gen = "Gender";
        List<Listofvalues> genderlist = commonDAO.getGender(gen);
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = genderlist.listIterator();
        System.out.println(" size = " + genderlist.size());
        while (recordings.hasNext()) {
            Listofvalues r = (Listofvalues) recordings.next();
            al.add(r.getValue());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            s = mapper.writeValueAsString(al);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    public String getAgeRange() {
        List<Listofvalues> agelist = commonDAO.getAgeRange();
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = agelist.listIterator();

        while (recordings.hasNext()) {
            Listofvalues r = (Listofvalues) recordings.next();
            al.add(r.getValue());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            s = mapper.writeValueAsString(al);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    public String getPlacementTypes() {
        List<Listofvalues> placementtypelist = commonDAO.getPlacementTypes();
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = placementtypelist.listIterator();

        while (recordings.hasNext()) {
            Listofvalues r = (Listofvalues) recordings.next();
            al.add(r.getValue());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            s = mapper.writeValueAsString(al);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public String getCategory() {
        List<Listofvalues> categorylist = commonDAO.getCategoryList();
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = categorylist.listIterator();

        while (recordings.hasNext()) {
            Listofvalues r = (Listofvalues) recordings.next();
            al.add(r.getValue());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            s = mapper.writeValueAsString(al);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public String getCountries() {
        List<Listofvalues> categorylist = commonDAO.getCountries();
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = categorylist.listIterator();

        while (recordings.hasNext()) {
            Listofvalues r = (Listofvalues) recordings.next();
            al.add(r.getValue());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            s = mapper.writeValueAsString(al);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public String getStates(String country) {
        List<Listofvalues> categorylist = commonDAO.getStates(country);
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = categorylist.listIterator();

        while (recordings.hasNext()) {
            Listofvalues r = (Listofvalues) recordings.next();
            al.add(r.getValue());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            s = mapper.writeValueAsString(al);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public String getCities(String states) {
        List<Listofvalues> categorylist = commonDAO.getStates(states);
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = categorylist.listIterator();

        while (recordings.hasNext()) {
            Listofvalues r = (Listofvalues) recordings.next();
            al.add(r.getValue());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            s = mapper.writeValueAsString(al);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public List<ArrayList> getGenderList() {
        String gen = "Gender";
        List<Listofvalues> genderlist = commonDAO.getGender(gen);
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = genderlist.listIterator();
        System.out.println(" size = " + genderlist.size());
        while (recordings.hasNext()) {
            Listofvalues r = (Listofvalues) recordings.next();
            id = r.getId();
            value = r.getValue();
            ListofValues lv = new ListofValues(id, value);
            al.add(lv);
        }
        return al;
    }

    public List<ArrayList> getAgeRangeList() {
        List<Listofvalues> agelist = commonDAO.getAgeRange();
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = agelist.listIterator();
        if (agelist.size() > 0) {
            while (recordings.hasNext()) {
                Listofvalues r = (Listofvalues) recordings.next();
                id = r.getId();
                value = r.getValue();
                ListofValues lv = new ListofValues(id, value);
                al.add(lv);
            }
        } else {
            ListofValues lv = new ListofValues(id, value);
            al.add(lv);
        }
        return al;
    }

    public List<ArrayList> getPlacementTypesList() {
        List<Listofvalues> placementtypelist = commonDAO.getPlacementTypes();
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = placementtypelist.listIterator();
        if (placementtypelist.size() > 0) {
            while (recordings.hasNext()) {
                Listofvalues r = (Listofvalues) recordings.next();
                id = r.getId();
                value = r.getValue();
                ListofValues lv = new ListofValues(id, value);
                al.add(lv);
            }
        } else {
            ListofValues lv = new ListofValues(id, value);
            al.add(lv);
        }
        return al;

    }

    public List<ArrayList> getCategoryList() {
        List<Listofvalues> categorylist = commonDAO.getCategoryList();
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = categorylist.listIterator();
        if (categorylist.size() > 0) {
            while (recordings.hasNext()) {
                Listofvalues r = (Listofvalues) recordings.next();
                id = r.getId();
                value = r.getValue();
                ListofValues lv = new ListofValues(id, value);
                al.add(lv);
            }
        } else {
            ListofValues lv = new ListofValues(id, value);
            al.add(lv);
        }
        return al;


    }

    public List<ArrayList> getCountriesList() {
        List<Listofvalues> countrylist = commonDAO.getCountries();
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = countrylist.listIterator();
        if (countrylist.size() > 0) {
            while (recordings.hasNext()) {
                Listofvalues r = (Listofvalues) recordings.next();
                id = r.getId();
                value = r.getValue();
                ListofValues lv = new ListofValues(id, value);
                al.add(lv);
            }
        } else {
            ListofValues lv = new ListofValues(id, value);
            al.add(lv);
        }
        return al;
    }

    public List<ArrayList> getStatesList(String country) {
        List<Listofvalues> statelist = commonDAO.getStates(country);
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = statelist.listIterator();
        if (statelist.size() > 0) {
            while (recordings.hasNext()) {
                Listofvalues r = (Listofvalues) recordings.next();
                id = r.getId();
                value = r.getValue();
                ListofValues lv = new ListofValues(id, value);
                al.add(lv);
            }
        } else {
            ListofValues lv = new ListofValues(id, value);
            al.add(lv);
        }
        return al;

    }

    public List<ArrayList> getCitiesList(String states) {
        List<Listofvalues> citylist = commonDAO.getStates(states);
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = citylist.listIterator();
        if (citylist.size() > 0) {
            while (recordings.hasNext()) {
                Listofvalues r = (Listofvalues) recordings.next();
                id = r.getId();
                value = r.getValue();
                ListofValues lv = new ListofValues(id, value);
                al.add(lv);
            }
        } else {
            ListofValues lv = new ListofValues(id, value);
            al.add(lv);
        }
        return al;
    }

    //Not used 
    @Override
    public List<ArrayList> getPublisherIdList(String categoryidlist) {
        List<Publishercategory> citylist = commonDAO.getPublishersId(categoryidlist);
        String s = new String();
        ArrayList al = new ArrayList();
        ListIterator recordings = citylist.listIterator();
        if (citylist.size() > 0) {
            while (recordings.hasNext()) {
                Publishercategory r = (Publishercategory) recordings.next();
                id = r.getId();
                value = r.getPublisherid().getId().toString();
                ListofValues lv = new ListofValues(id, value);
                al.add(lv);
            }
        } else {
            ListofValues lv = new ListofValues(id, value);
            al.add(lv);
        }
        return al;
    }

    @Override
    public List<Publisher> getSearchPublishers(String categoryidlist) {
        List<Publisher> pub = commonDAO.getSearchPublishers(categoryidlist);
        return pub;
    }

    public boolean authenticate(String username, String password) {

        boolean returnvalue = false;
        ArrayList al = new ArrayList();
        String dbpassword = "";
        String temp = "";
        List<Userprofile> up = commonDAO.getUser(username);
        System.out.println(" size = " + up.size());
        try {
            if (up.size() > 0) {
                ListIterator recordings = up.listIterator();
                while (recordings.hasNext()) {
                    Userprofile r = (Userprofile) recordings.next();
                    id = r.getId();

                    dbpassword = r.getPassWord();
                    returnvalue = this.verifyPassword(password, dbpassword);
                    System.out.println(" stage-1" + returnvalue);
                    if (returnvalue) {
                        Boolean blnObj = new Boolean(returnvalue);
                        temp = "true";
                        System.out.println(" stage -1 id =" + id + " temp =" + temp);
                        returnvalue = true;
                    } else { // for future use
                        value = "Password is wrong";
                    }
                }
            } else { // for future use
                id = -1;
                value = "User Name Not Available";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnvalue;
    }

    /*
     *  Generate 8 character length Alpahnumeric Password.
     */
    public String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    /*
     *  SHA-1
     *  Salt Size - 16 bytes
     *  100000 iterations
     *  refer : http://www.jasypt.org/api/jasypt/1.9.1/index.html
     */
    public String encryptPassword(String pwd) {

        StrongPasswordEncryptor encryptor2 = new StrongPasswordEncryptor();
        String enc_password = encryptor2.encryptPassword(pwd);
        System.out.println("Password encrypted by String password encryptor: " + enc_password);
        return enc_password;

    }

    public boolean verifyPassword(String userPassword, String db_password) {
        System.out.println(" userPassword =" + userPassword);
        System.out.println(" db password = " + db_password);
        StrongPasswordEncryptor encryptor2 = new StrongPasswordEncryptor();
        String password3 = encryptor2.encryptPassword(userPassword);
        boolean isOkay = encryptor2.checkPassword(userPassword, db_password);
        return isOkay;
    }

    public boolean verifyPassword() {
        String userPassword = "abc123!@#";
        String db_password = "Un7il8JUm3XS2bzDqdI5r1/2MHsudYGJP1cgT1YgpiRH2Pw1uMZQTI8bgbXfF0/j";
        StrongPasswordEncryptor encryptor2 = new StrongPasswordEncryptor();
        String password3 = encryptor2.encryptPassword(userPassword);
        boolean isOkay = encryptor2.checkPassword(userPassword, db_password);
        return isOkay;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Account createNewAccount(Account account) {
        return commonDAO.createNewAccount(account);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Userprofile createNewUserProfile(Userprofile userprofile) {
        return commonDAO.createNewUserProfile(userprofile);
    }
}

class ListofValues {

    private Integer id;
    private String value;

    ListofValues() {
    }

    ListofValues(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
