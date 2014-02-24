/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.controller;

//import com.lrl.c1.buyside.entity.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.lrl.c1.service.MediaPlanService;
import java.util.List;

import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.service.MediaPlanCreationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lrl.c1.service.CommonService;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
/**
 *
 * @author logic
 */
@Controller
public class MediaPlanController {

   
    
    private static final Log log = LogFactory.getLog(MediaPlanController.class);
    
    @Autowired
    private MediaPlanService mediaplanService;
    
    @Autowired
    private MediaPlanCreationService mediaplancreationService;
    
    @Autowired
    private CommonService commonService;
    private static final Logger logger = Logger.getLogger( MediaPlanController.class); 
 
   
    @RequestMapping("/requestproposals")
    public String listRequestProposal(Model model) {
        log.debug("Inside the  listRequestProposal() methods");
        List<Mediaplan> mediaplan = mediaplanService.FetchReqProposals();
        model.addAttribute("data", mediaplan);
        return "proposals";

    }

    @RequestMapping(value = "/mediacreation", method = RequestMethod.GET)
    public ModelAndView mediaplanCreationPage() {
        log.debug("Inside the  mediaplanCreationPage() methods");
        return new ModelAndView("mediaplanCreation");
    }

    @RequestMapping(value = "/addMedia", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView addMedia() {
        Map<String, Object> model = new HashMap<String, Object>();
        // DON'T DELETE BELOW LINE  
        // mediaplancreationService.createNewMediaPlan( prepareBean(mpBean,mplBean));
        log.debug("Inside the  addMedia() methods");
        return new ModelAndView("mediaplanCreation", model);
    }

   
 @RequestMapping(value = "/lineList", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView lineList() {
        Map<String, Object> model = new HashMap<String, Object>();        
        log.debug("Inside the  lineList() methods");
        return new ModelAndView("mediacreation", model);
    }
  
    
   @RequestMapping("/publisheroverviewname")  
  public String getPublisherOverviewByName(Model model){
         String overview  = new String();
         String publisher = "yatra.com";         
         overview = commonService.getPublisherOverviewByName(publisher);                   
         model.addAttribute("data",overview);
         return "category";
    }
   @RequestMapping("/publisheroverviewid")  
   public String getPublisherOverviewById(Model model){
         String overview  = new String();
         int id = 345; // for egm car tech
         overview = commonService.getPublisherOverviewById(id);
         model.addAttribute("data",overview);      
         return "category";
     }   
  
   @RequestMapping("/publishercontactmap")  
   public String getPublisherContactAsMap(Model model){
        int publisher_id = 567;        
        HashMap m  = (HashMap) commonService.getPublisherContactAsMap(publisher_id);
        model.addAttribute("data",m);
        return "category";            
     }  
        
    /*List of values sri */
   @RequestMapping("/gender")  
   public String getGender(Model model){   
        String s  =  commonService.getGender();
        model.addAttribute("data",s);
        return "category";            
     }  
    
   @RequestMapping("/agerange")  
   public String getAgeRange(Model model){           
        String s  =  commonService.getAgeRange();
        model.addAttribute("data",s);
        return "category";            
     }  
    
   @RequestMapping("/placementtypes")  
   public String getPlacementTypes(Model model){           
        String s  =  commonService.getPlacementTypes();
        model.addAttribute("data",s);
        return "category";            
     }  
    
   @RequestMapping("/categorylist")  
   public String getCategoryList(Model model){           
        List s  =  commonService.getCategoryList();
        model.addAttribute("data",s);
        return "category";            
     }  
    
    
   @RequestMapping("/countries")  
   public String getCountries(Model model){           
        String s  =  commonService.getCountries();
        model.addAttribute("data",s);
        return "category";            
     }      
     
   @RequestMapping("/states")  
   public String getStates(Model model){     
        String c = "USA"; 
        String s  =  commonService.getStates(c);
        model.addAttribute("data",s);
        return "category";            
     }  
    
     
   @RequestMapping("/cities")  
   public String getCities(Model model){     
        String c  = "California"; 
        String s  =  commonService.getCities(c);
        model.addAttribute("data",s);
        return "category";            
     }   


}
