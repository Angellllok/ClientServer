package lab1;
import java.io.*;
import java.net.*;
import java.util.*;

public class server {


	 public static void main(String[] args) {
	        // TODO code application logic here
	       byte bKbdInput[] = new byte[256];
	        ServerSocket ss;
	        Socket s;
	        InputStream is;
	        OutputStream os;
	        
	        ////

		        OutputStream osq1;
		        OutputStream osq2;

	        System.out.println("Socket Server Application");
	        try
	        {
	            ss = new ServerSocket(9999);
	            s = ss.accept();
	            is = s.getInputStream();
	            os = s.getOutputStream();
	            osq1 = s.getOutputStream();
	            osq2 = s.getOutputStream();
	            byte buf[] = new byte[512];
	            byte buf1[] = new byte[512];
	            int lenght;
	            
	       
	            while(true)
	            {
	                lenght = is.read(buf);
	                if(lenght == - 1)    {   break; }
	                
	             

	                String str = new String(buf, 0);
	                
	                                      
	                StringTokenizer st;

	                st   = new StringTokenizer(str, "\r");

	                str= new String((String)st.nextElement());
	                String str00 = str.replaceAll("\1", "").replaceAll("\2", "").replaceAll("\3", "");
	             	                System.out.println("Input >>  " + str00);

	             	               boolean isContain1 = str.contains("\1");
	             	              boolean isContain2 = str.contains("\2");
	   	             	           boolean isContain3 = str.contains("\3");
	   	             	           
	   	             	           
	             	        if(isContain1 == true      ) {
	             	  
	             	        	 String str0 = str.replaceAll("\1", "");        
	                String str1 = str0.replaceAll("\\[", "\\(").replaceAll("\\]", "\\)");       
	                
	                System.out.println("Output 1>> " + str1);
	                   byte[] b5 =str1.getBytes();
  	            	// int length = b3.length;
  	                   // StringTokenizer st;
	                      st   = new StringTokenizer(str1, "\r");
  	                    str1 = new String((String)st.nextElement());
  	                    
  	                  byte[] buf5 =str1.getBytes();
  	                os.write(buf5, 0, lenght);
	             
	                
	             	        }
	             	        
	             	        
	             	        
	             	       if(isContain3 == true      ) {
	             	    	   String str0 = str.replaceAll("\3", "");
	             	       String str1 = str0.replaceAll("\\[", "\\(").replaceAll("\\]", "\\)");      
	             	       String b = str1; //наша строка
	                while(b.contains("  ")) {
	                             String replace = b.replace("  ", " ");
	                               b=replace;

	               }
	                             String  str2 = b;
	                             
	                             while(b.contains("  ")) {
		                             String replace = b.replace("  ", " ");
		                               b=replace;

		               }
	                             
	                             System.out.println("Output 3 >> " + str2);
 	         	            	   byte[] b3 =str2.getBytes();

 	         	                    st   = new StringTokenizer(str2, "\r");
 	         	                    str2 = new String((String)st.nextElement());
 	         	                    
 	         	                  
 	         		                byte[] buf3 =str2.getBytes();
 	         		                os.write(buf3, 0, lenght);
 	         		                //////////////////////////

	             	       }
	             	       
	             	       
	             	       
	             	      if(isContain2 == true      ) {
	                             
	                             //////spaces
	             	    	 String str0 = str.replaceAll("\2", "");
	                             String bq = str0; //наша строка
	           	              
	         	                while(bq.contains("  ")) {
	         	                             String replaceq = bq.replace("  ", " ");
	         	                               bq=replaceq;

	         	               }
	         	                             String  strq = bq;
	         	                             
	         	                             while(bq.contains("  ")) {
	         		                             String replaceq = bq.replace("  ", " ");
	         		                               bq=replaceq;

	         		               }
	         	                            System.out.println("Output 2 >> " + strq);
	     	         	            	   byte[] b4 =strq.getBytes();
	     	         	            	// int length = b3.length;
	     	         	                   // StringTokenizer st;
	     	         	                    st   = new StringTokenizer(strq, "\r");
	     	         	                    strq = new String((String)st.nextElement());
	     	         	                    
	     	         	                    
	     	         	       
	   	         	                    
	   	         	                   byte[] buf4 =strq.getBytes();
	   	         		                osq2.write(buf4, 0, lenght);
	                             }
	                             
	         	   
	                os.flush();

	            }

	            is.close();
	            os.close();
	          
	            s.close();
;
	        }
	        catch(Exception ioe)
	        {
	            System.out.println(ioe.toString());
	        }   

	        try
	        {
	            System.out.println("Terminate  application.");
	            System.in.read(bKbdInput);
	        }
	        catch(Exception ioe)
	        {
	            System.out.println(ioe.toString());
	        }
	    }
	
	
	
	
}



