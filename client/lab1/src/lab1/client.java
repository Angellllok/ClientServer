package lab1;
import java.io.*;
import java.lang.Object;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.*;

public class client {

	 public static void main(String args[])
	    {
	        byte bKbdInput[] = new byte[256];
	        Socket s;
	        InputStream is;

	        OutputStream os;

	        
	        
	        OutputStream osq2;
	       // String str6; 
	        String str6 = new String(); 
	           String str4 = new String(); 
	           String str5 = new String(); 
	      // 	StringBuffer sb = new StringBuffer();
/////
	        int swValue;
	      //  is = s.getInputStream();
	      

	              
	            
	//    String text = "[This new text1 This new text2       This new text3 This new text4] ";//���� ��� ������ � ����
	      String FileName = "d://downloads//Mi.txt";  // ���� � ������ ���������� �����
	      String FileName1 = "d://downloads//Mi1.txt";  // ���� � ������ ���������� �����
	//     write(FileName, text);// ������ ������ � ����
	    	 readinn(FileName); // ������ �� �����
	    //	 write2(FileName1,"dpfsokokfopirkopigf");// ������ ������ � ����
	    	 
		        System.out.println("|   MENU SELECTION            |");
		        System.out.println("| Options:                    |");
		        System.out.println("|        1.  [ >> (            |");
		        System.out.println("|        2. Space delete      |");
		        System.out.println("|        3. 1 and 2           |");
		        System.out.println("|        4. Exit              |");
		        swValue = Keyin.inInt(" Select option: ");

		        // Switch construct
		        switch (swValue) {
		        
        
		        case 3:
		          System.out.println("Option 3 selected"); 
		          swValue = 3; 

	     try
	       {
	           s = new Socket("localhost", 9999);
	            is = s.getInputStream();
	            os = s.getOutputStream();
	            byte buf[] = new byte[512];
	           int length;
	           String str;
	          
	////////////////////////////////
	 FileInputStream fstream = new FileInputStream(FileName);
  BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
  String strLine;
 StringBuffer sb = new StringBuffer(512);
 StringBuffer sa = new StringBuffer(512);

	
while ((strLine = br.readLine()) != null)
	     //     while(true)
		 
	           {
	   strLine = strLine+"\3"; 
 	 byte[] b4 =strLine.getBytes();
     	
 	 length = b4.length;
		             // length = System.in.read(bKbdInput);
	           	  
	        	  
	               if(length != 1)
	               {
	          	
	            	   str = strLine;
	            	 //  System.out.println("out > " + str);
	            	   byte[] b3 =str.getBytes();
	            	   length = b3.length;
	                    StringTokenizer st;
	                    st   = new StringTokenizer(str, "\r\n");
	                    str = new String((String)st.nextElement());
	                    
	                    String str00 = str.replaceAll("\3", "");

	                  System.out.println("ToServer >> " + str00);
	             
	           	                 ///////////  �������� ���������� 
	                               os.write(b3, 0, length);
                                   os.flush();
	                              length = is.read(buf);
	                              if(length == - 1)
	                   {   break;}

	                   str = new String(buf, 0);
	                   st   = new StringTokenizer(str, "\r\n");
	                     str = new String((String)st.nextElement());
	              	             //      str4 = str;
	                //   str5 += str4;
	                     System.out.println("SendPrint >>    " + str);
	                    str6 += str;  
	                 	                                    
	                                	                                      
	                    if(str.equals("quit"))
	                    { break;}
	                }
	                }

	           is.close();
	           os.close();
	           
	            s.close();
	     
	     }
	    
	       catch(Exception ioe)
	       {
	          System.out.println(ioe.toString());
	       }   
	   
	       try
	        {
	    //	System.out.println("infa na zapis =====  " + str6);
	    	   write2(FileName1,str6);// ������ ������ � ����
	           System.out.println("Press  to terminate application.");
	          System.in.read(bKbdInput);
	      }
	        catch(Exception ioe)
	       {
	           System.out.println(ioe.toString());
	        } 
	       break;
	       case 1:
	          System.out.println("Option 1 selected");
	          swValue = 1;
		   	     try
		   	       {
		   	           s = new Socket("localhost", 9999);
		   	            is = s.getInputStream();

		   	            os = s.getOutputStream();
		
		   	            byte buf[] = new byte[512];
		   	           int length;
		   	           String str;
		   	          
		   	////////////////////////////////
		   	 FileInputStream fstream = new FileInputStream(FileName);
		     BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		     String strLine = null;
		    StringBuffer sb = new StringBuffer(512);
		    StringBuffer sa = new StringBuffer(512);
		    
		   

		   // write(FileName, text1);// ������ ������ � ����
		   while ((strLine = br.readLine()) != null)
		   	     //     while(true)
		   		 
		   	           {
			   strLine = strLine+"\1"; 
		    	 byte[] b4 =strLine.getBytes();
		        	
		    	 length = b4.length;
		   		             // length = System.in.read(bKbdInput);
		   	           	  
		   	        	  
		   	               if(length != 1)
		   	               {
		   	          	
		   	            	   str = strLine;
		   	            	   
		   	            	 //  System.out.println("out > " + str);
		   	            	   byte[] b3 =str.getBytes();
		   	            	   length = b3.length;
		   	                    StringTokenizer st;
		   	                    st   = new StringTokenizer(str, "\r\n");
		   	                    str = new String((String)st.nextElement());

		   	                 String str00 = str.replaceAll("\1", "");
		   	                  System.out.println("ToServer >> " + str00);
		   	             
		   	           	                 ///////////  �������� ���������� 
		   	                               os.write(b3, 0, length);
		                                      os.flush();
		   	                              length = is.read(buf);
		   	                              if(length == - 1)
		   	                   {   break;}

		   	                   str = new String(buf, 0);
		   	                   st   = new StringTokenizer(str, "\r\n");
		   	                     str = new String((String)st.nextElement());
		   	              	                //   str4 = str;
		   	                  // str5 += str4;
		   	                   
		   	                     System.out.println("SendPrint >>    " + str);
		   	                    str6 += str;  
		   	                 	                                    
		   	                                	                                      
		   	                    if(str.equals("quit"))
		   	                    { break;}
		   	                }
		   	                }

		   	           is.close();
		   	           os.close();
		   	           
		   	            s.close();
		   	     
		   	     }
		   	    
		   	       catch(Exception ioe)
		   	       {
		   	          System.out.println(ioe.toString());
		   	       }   
		   	   
		   	       try
		   	        {
		   	    //	System.out.println("infa na zapis =====  " + str6);
		   	    	   write2(FileName1,str6);// ������ ������ � ����
		   	           System.out.println("Press  to terminate application.");
		   	          System.in.read(bKbdInput);
		   	      }
		   	        catch(Exception ioe)
		   	       {
		   	           System.out.println(ioe.toString());
		   	        } 
	          break;
	        case 2:

	   	     try
	   	       {
	   	           s = new Socket("localhost", 9999);
	   	           
	   	           
	   	           
	   	           
	   	            is = s.getInputStream();
	   	            os = s.getOutputStream();
	   	            byte buf[] = new byte[512];
	   	           int length;
	   	           String str;
	   	          
	   	////////////////////////////////
	   	 FileInputStream fstream = new FileInputStream(FileName);
	     BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	     String strLine;
	    StringBuffer sb = new StringBuffer(512);
	    StringBuffer sa = new StringBuffer(512);
	   // strLine = strLine+"\1/"; 
	   	
	   while ((strLine = br.readLine()) != null)
	   	     //     while(true)
	   		 
	   	           {
		   strLine = strLine+"\2"; 
	    	 byte[] b4 =strLine.getBytes();
	        	
	    	 length = b4.length;
	   		             // length = System.in.read(bKbdInput);
	   	           	  
	   	        	  
	   	               if(length != 1)
	   	               {
	   	          	
	   	            	   str = strLine;
	   	            	 //  System.out.println("out > " + str);
	   	            	   byte[] b3 =str.getBytes();
	   	            	   length = b3.length;
	   	                    StringTokenizer st;
	   	                    st   = new StringTokenizer(str, "\r\n");
	   	                    str = new String((String)st.nextElement());
	   	                    

	   	                 String str00 = str.replaceAll("\2", "");
	   	                  System.out.println("ToServer >> " + str00);
	   	             
	   	           	                 ///////////  �������� ���������� 
	   	                               os.write(b3, 0, length);
	                                      os.flush();
	   	                              length = is.read(buf);
	   	                              if(length == - 1)
	   	                   {   break;}

	   	                   str = new String(buf, 0);
	   	                   st   = new StringTokenizer(str, "\r\n");
	   	                     str = new String((String)st.nextElement());
	   	              	              //     str4 = str;
	   	                 //  str5 += str4;
	   	                 ;
	   	                     System.out.println("SendPrint >>    " + str);
	   	                    str6 += str;  
	   	                 	                                    
	   	                                	                                      
	   	                    if(str.equals("quit"))
	   	                    { break;}
	   	                }
	   	                }

	   	           is.close();
	   	           os.close();
	   	           
	   	            s.close();
	   	     
	   	     }
	   	    
	   	       catch(Exception ioe)
	   	       {
	   	          System.out.println(ioe.toString());
	   	       }   
	   	   
	   	       try
	   	        {
	   	    //	System.out.println("infa na zapis =====  " + str6);
	   	    	   write2(FileName1,str6);// ������ ������ � ����
	   	           System.out.println("Press  to terminate application.");
	   	          System.in.read(bKbdInput);
	   	      }
	   	        catch(Exception ioe)
	   	       {
	   	           System.out.println(ioe.toString());
	   	        } 
	          break;
	       
	        case 4:
		          System.out.println("Exit selected");
		          break;
		        default:
	          System.out.println("Invalid selection");
	          break; // This break is not really necessary
	        }

	    
	       
	
	      
	       
	       
	       //
	           }
	 

	 /////////////////////////////////////////////////////////..������ � ����
	 public static void write(String filename, String text) {
		    //���������� ����
		  File file = new File(filename);

		    try {
		        //���������, ��� ���� ���� �� ���������� �� ������� ���
		        if(!file.exists()){
		            file.createNewFile();
		        }

		        //PrintWriter ��������� ����������� ������ � ����
		        PrintWriter out = new PrintWriter(file.getAbsoluteFile());

		        try {
		            //���������� ����� � ����
		            out.print(text);
		        } finally {
		            //����� ���� �� ������ ������� ����
		            //����� ���� �� ���������
		            out.close();
		        }
		    } catch(IOException e) {
		        throw new RuntimeException(e);
		    }
	 }
		    ///////////
	 
	
/////////////////////////////////////////////////////////..������ � ����2
	 public static void write2(String filename, String text)
	 {
		    //���������� ����
		  File file = new File(filename);

		  try {
		        //���������, ��� ���� ���� �� ���������� �� ������� ���
		        if(file.exists()){
		            file.createNewFile();
		        }

		        //PrintWriter ��������� ����������� ������ � ����
		        PrintWriter out = new PrintWriter(file.getAbsoluteFile());

		        try {
		            //���������� ����� � ����
		            out.print(text);
		        } finally {
		            //����� ���� �� ������ ������� ����
		            //����� ���� �� ���������
		            out.close();
		        }
		    } catch(IOException e) {
		        throw new RuntimeException(e);
		    }
	 }
	
	 
	 
	 //////////////////��������� ������ �����
		    
		    public static void readinn(String fileName) 
		    {
		      
		        try {   
		            FileInputStream fstream = new FileInputStream(fileName);
		            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		            String strLine;
		            while ((strLine = br.readLine()) != null){
		               System.out.println(strLine);
		            }
		         }catch (IOException e){
		            System.out.println("������");
		         }
		           }


}

///////////////
class Keyin {

	  //*******************************
	  //   support methods
	  //*******************************
	  //Method to display the user's prompt string
	  public static void printPrompt(String prompt) {
	    System.out.print(prompt + " ");
	    System.out.flush();
	  }

	  //Method to make sure no data is available in the
	  //input stream
	  public static void inputFlush() {
	    int dummy;
	    int bAvail;

	    try {
	      while ((System.in.available()) != 0)
	        dummy = System.in.read();
	    } catch (java.io.IOException e) {
	      System.out.println("Input error");
	    }
	  }
	  public static String inString() {
	    int aChar;
	    String s = "";
	    boolean finished = false;

	    while (!finished) {
	      try {
	        aChar = System.in.read();
	        if (aChar < 0 || (char) aChar == '\n')
	          finished = true;
	        else if ((char) aChar != '\r')
	          s = s + (char) aChar; // Enter into string
	      }

	      catch (java.io.IOException e) {
	        System.out.println("Input error");
	        finished = true;
	      }
	    }
	    return s;
	  }

	  public static int inInt(String prompt) {
	    while (true) {
	      inputFlush();
	      printPrompt(prompt);
	      try {
	        return Integer.valueOf(inString().trim()).intValue();
	      }

	      catch (NumberFormatException e) {
	        System.out.println("Invalid input. Not an integer");
	      }
	    }
	  }
	  
}