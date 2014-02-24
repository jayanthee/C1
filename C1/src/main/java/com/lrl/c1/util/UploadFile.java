/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.sun.jersey.core.header.FormDataContentDisposition;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class UploadFile {
public UploadFile(){}

    public String uploadCreatives(InputStream uploadedInputStream,
            FormDataContentDisposition fileDetail) {
        try{
     System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            String existingBucketName = "c1x";
            String keyName = "banners/" + fileDetail.getFileName();
            String amazonFileUploadLocationOriginal = existingBucketName;
            String filepath = "";
            AWSCredentials awsc = new AWSCredentials() {
                @Override
                public String getAWSAccessKeyId() {
                    return "AKIAILCKQVF2DPF3KBCQ";
                }

                @Override
                public String getAWSSecretKey() {
                    return "tvWOg3YWbVKgiMpqFS72q8MDTeVeeR7Xtw2Cy+gU";
                }
            };
             String ext = fileDetail.getFileName().split("\\.")[1].toString(); 
            AmazonS3 s3Client = new AmazonS3Client(awsc);
            System.out.println("s3client "+s3Client.toString()); 
//            s3Client.getBucketLocation("c1x");
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType("image/" + ext);
            PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, uploadedInputStream, objectMetadata);
           putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
            PutObjectResult result = s3Client.putObject(putObjectRequest);
            GetObjectRequest request = new GetObjectRequest(existingBucketName, keyName);
//            System.out.println("Etag:" + result.getETag() + "-->" + result);
            
            
            //Listing the buckets produces unmarsahll exception
//                   List<Bucket> bck = s3Client.listBuckets();
//            for (Bucket bucket : bck) {
//                System.out.println("Bucket  " + bucket.getName());
//            }

            return result.getETag(); 
            //return  "OK ";
        } catch (AmazonClientException e) {
            e.printStackTrace();
            return "ERROR : " + e;
        } catch (Exception ex) {
            return "Error" +ex;
        }

    
    
    }
    public static void main(String[] args) {
        
    
        try {
        System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            String existingBucketName = "c1x";
            String keyName = "banners/" +"i5.jpg"; //fileDetail.getFileName();
            String amazonFileUploadLocationOriginal = existingBucketName;
            String filepath = "";
            AWSCredentials awsc = new AWSCredentials() {
                @Override
                public String getAWSAccessKeyId() {
                    return "AKIAILCKQVF2DPF3KBCQ";
                }

                @Override
                public String getAWSSecretKey() {
                    return "tvWOg3YWbVKgiMpqFS72q8MDTeVeeR7Xtw2Cy+gU";
                }
            };
            //String ext = fileDetail.getFileName().split("\\.")[1].toString();
            String ext = "i5.jpg".split("\\.")[1].toString();
            
            FileInputStream fis = new FileInputStream("/Users/logic/Desktop/SHARE/i5.jpg");
            
            AmazonS3 s3Client = new AmazonS3Client(awsc);
            List<Bucket> bck = s3Client.listBuckets();
            for (Bucket bucket : bck) {
                System.out.println("Bucket  " + bucket.getName());
            }
            s3Client.getBucketLocation("c1x");
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType("image/" + ext);
            PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, fis, objectMetadata);
            putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
            PutObjectResult result = s3Client.putObject(putObjectRequest);
            GetObjectRequest request = new GetObjectRequest(existingBucketName, keyName);
            System.out.println("Etag:" + result.getETag() + "-->" + result);


            //return result.getETag();
            //return "OK";
        } catch (AmazonClientException e) {
            e.printStackTrace();
            //return "ERROR : " + e;
        } catch (Exception ex) {
            ex.printStackTrace();
            //return "Error" +ex;
        }


    }
    
    
     public String uploadCreatives(InputStream uploadedInputStream,
            String fileDetail) {
        try{
     System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            String existingBucketName = "c1x";
            String keyName = "banners/" + fileDetail;
            String amazonFileUploadLocationOriginal = existingBucketName;
            String filepath = "";
            AWSCredentials awsc = new AWSCredentials() {
                @Override
                public String getAWSAccessKeyId() {
                    return "AKIAILCKQVF2DPF3KBCQ";
                }

                @Override
                public String getAWSSecretKey() {
                    return "tvWOg3YWbVKgiMpqFS72q8MDTeVeeR7Xtw2Cy+gU";
                }
            };
             String ext = fileDetail.split("\\.")[1].toString(); 
            AmazonS3 s3Client = new AmazonS3Client(awsc);
            System.out.println("s3client "+s3Client.toString()); 
//            s3Client.getBucketLocation("c1x");
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType("image/" + ext);
            PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, uploadedInputStream, objectMetadata);
           putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
            PutObjectResult result = s3Client.putObject(putObjectRequest);
            GetObjectRequest request = new GetObjectRequest(existingBucketName, keyName);
//            System.out.println("Etag:" + result.getETag() + "-->" + result);
            
            
            //Listing the buckets produces unmarsahll exception
//                   List<Bucket> bck = s3Client.listBuckets();
//            for (Bucket bucket : bck) {
//                System.out.println("Bucket  " + bucket.getName());
//            }

            return result.getETag(); 
            //return  "OK ";
        } catch (AmazonClientException e) {
            e.printStackTrace();
            return "ERROR : " + e;
        } catch (Exception ex) {
            return "Error" +ex;
        }

    
    
    }
}