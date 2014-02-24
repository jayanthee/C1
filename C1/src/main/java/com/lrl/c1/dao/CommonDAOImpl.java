/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

import com.lrl.c1.entity.Account;
import com.lrl.c1.entity.Listofvalues;
import java.util.List;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.entity.Publishercategory;
import com.lrl.c1.entity.Publishercontact;
import com.lrl.c1.entity.Userprofile;
import java.util.ListIterator;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author logic
 */
@Repository("commonDao")
public class CommonDAOImpl implements CommonDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(CommonDAOImpl.class);

    public List<Publisher> getPublisherOverviewByName(String publisher) {
        try {

            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Publisher.class).add(Restrictions.like("name", publisher));
            System.out.println(" size in name = " + criteria.list().size());
            return criteria.list();
        } catch (Exception e) {
            logger.info("getPublisherOverviewByName " + e.getMessage());
            return null;
        }
    }

    public List<Publisher> getPublisherOverviewById(int id) {
        try {

            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Publisher.class).add(Restrictions.like("id", id));
            System.out.println(" size in id = " + criteria.list().size());

            return criteria.list();
        } catch (Exception e) {
            logger.info("getPublisherOverviewById " + e.getMessage());
            return null;
        }
    }

    public List<Publishercontact> getPublisherContact(int publisher_id) {
        try {
            List categoryl = sessionFactory.getCurrentSession().createQuery("FROM Publishercontact as pc  WHERE pc.publisherId =:pid  ").setInteger("pid", publisher_id).list();

            return categoryl;
        } catch (Exception e) {
            logger.info("getPublisherContact " + e.getMessage());
            return null;
        }
    }

    public List<Listofvalues> getGender(String gen) {
        try {
            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE name like 'gender'").list();

            return criteriaq;
        } catch (Exception e) {
            logger.info("logging started");
            logger.info("----------------");
            logger.info("getGender " + e);
            logger.info("---------------------------");
            return null;
        }
    }

    public List<Listofvalues> getAgeRange() {
        try {
            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE name like 'age'").list();
            //return criteria.list();
            return criteriaq;
        } catch (Exception e) {
            //e.printStackTrace();
            logger.info("getAgeRange " + e.getMessage());
            return null;
        }
    }

    public List<Listofvalues> getPlacementTypes() {
        try {

            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE name like 'PlacementType'").list();
            return criteriaq;
        } catch (Exception e) {
            logger.info("getPlacementTypes " + e.getMessage());
            return null;
        }
    }

    public List<Listofvalues> getCategoryList() {
        try {
            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE name like 'CategoryList'").list();
            return criteriaq;
        } catch (Exception e) {
            logger.info("getCategoryList " + e.getMessage());
            return null;
        }
    }

    public List<Listofvalues> getCountries() {
        try {
            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE name like 'Country'").list();
            return criteriaq;
        } catch (Exception e) {
            logger.info("getCountries " + e.getMessage());
            return null;
        }
    }

    public int getCountryId(String country) {
        int countryid = 0;
        try {

            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE value like '" + country + "'").list();
            ListIterator recordings = criteriaq.listIterator();
            while (recordings.hasNext()) {
                Listofvalues r = (Listofvalues) recordings.next();
                countryid = r.getId();
            }

        } catch (Exception e) {
            logger.info("getCountryId " + e.getMessage());
        }
        return countryid;
    }

    public int getStateId(String state) {
        int countryid = 0;
        try {

            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE value = '" + state + "'").list();
            ListIterator recordings = criteriaq.listIterator();

            while (recordings.hasNext()) {
                Listofvalues r = (Listofvalues) recordings.next();
                countryid = r.getId();
            }

        } catch (Exception e) {
            logger.info("getStateId " + e.getMessage());
        }
        //System.out.println(" country id "+countryid);
        return countryid;
    }

    public List<Listofvalues> getStates(String country) {
        try {
            int countryid = this.getCountryId(country);
            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE parentid like " + countryid).list();
            return criteriaq;
        } catch (Exception e) {
            logger.info("getStates " + e.getMessage());
            return null;
        }
    }

    public List<Listofvalues> getCities(String state) {
        try {
            int stateid = this.getStateId(state);
            List<Listofvalues> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Listofvalues listofvalues WHERE parentid like " + stateid).list();
            return criteriaq;
        } catch (Exception e) {
            logger.info("getCities " + e.getMessage());
            return null;
        }
    }

    public List<Publishercategory> getPublishersId(String categorylist) {
        try {
            List<Publishercategory> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Publishercategory publishercategory WHERE categoryid  IN ( " + categorylist + ") group by publishercategory.publisherid  ").list();

            List<Publisher> pub = sessionFactory.getCurrentSession().createQuery("SELECT publishercategory.publisherid FROM Publishercategory publishercategory WHERE publishercategory.categoryid  IN ( " + categorylist + ") group by publishercategory.publisherid  ").list();
            for (Publisher p : pub) {
                System.out.println(" pub.name " + p.getName());
            }


            return criteriaq;
        } catch (Exception e) {
            logger.info("getPublisherOverviewByName " + e.getMessage());
            return null;
        }

    }

    public List<Publisher> getSearchPublishers(String categorylist) {
        try {

            List<Publisher> pub = sessionFactory.getCurrentSession().createQuery("SELECT publishercategory.publisherid FROM Publishercategory publishercategory WHERE publishercategory.categoryid  IN ( " + categorylist + ") group by publishercategory.publisherid  ").list();
            return pub;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("getPublisherOverviewByName " + e.getMessage());
            return null;
        }

    }

    public List<Userprofile> getUser(String username) {
        try {
            List<Userprofile> criteriaq = sessionFactory.getCurrentSession().createQuery("FROM Userprofile userprofile WHERE userprofile.userName like '" + username + "' ").setMaxResults(1).list();
            return criteriaq;
        } catch (Exception e) {
            logger.info("getCountries " + e.getMessage());
            return null;
        }

    }

    public Account createNewAccount(Account account) {

        try {
            sessionFactory.getCurrentSession().saveOrUpdate("Account", account);
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Userprofile createNewUserProfile(Userprofile userprofile) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate("Userprofile", userprofile);
            return userprofile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
