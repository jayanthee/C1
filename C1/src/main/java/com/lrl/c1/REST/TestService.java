/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.REST;

import com.lrl.c1.service.MediaPlanCreationService;
import com.lrl.c1.service.SellsideService;
import com.lrl.c1.util.SendEmail;
import com.lrl.c1.util.UploadFile;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//@Component
@Path("/test")
@Controller
public class TestService {

    private static final Logger LOG = Logger.getLogger(SellsideWebservice.class.getName());
    @Autowired
    private SellsideService sellsideService;
    @Autowired
    private MediaPlanCreationService mediaplancreationService;
    SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat mdy = new SimpleDateFormat("MM/dd/yyyy");

  /**
     *
     * @param image
     * @return
     */
    @GET
    @Path("/images/{image}")
    @Produces("image/*")
    public Response getImage(@PathParam("image") String image) {


        File f = new File(image);
        File[] files = f.listFiles();


        if (!f.exists()) {
            throw new WebApplicationException(404);
        }

        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/upload/") 
    public Response uploadFile(@FormDataParam("id") Integer id,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws Exception{
//            @RequestParam("id") String name,
//        @RequestParam("file") MultipartFile file) throws IOException{
       // System.out.println(" File detail "+file.getName() +" == "+file.getOriginalFilename());
        UploadFile udf = new UploadFile(); 
        String ud = udf.uploadCreatives(uploadedInputStream,fileDetail);
        //String ud = udf.uploadCreatives(file.getInputStream(), file.getName()); 
        return Response.status(200).entity("ok").build();
    }

  // save uploaded file to new location
    private void saveToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {

        try {

            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     @GET
    @Path("/sendmail")
    @Produces({"application/json"})
    public Response createContact() throws IOException {

        SendEmail sm = new SendEmail();
        String s = sm.sendMail("usernam", "PWD", "pjayam.thee@gmail.com");
        return Response.status(200).entity("ok" + s).build();
    }
     
    @GET
    @Path("/testexe")
    @Produces({"application/json"}) 
    public  @ResponseBody Integer ExeTest() throws Exception {

        Integer i=10;
        Integer j = 0;
        Integer k =i/j;
        
        return k;//Response.status(200).entity("ok" + k).build();
    } 
     
     
}

