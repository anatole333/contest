package org.ansj.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.lang.*;
 
public class TextSplit {
	public static String[]str = new String[10];
    public static void main(String[] args) throws Exception {
        String input = new String("F:\\比特能_专家机器人\\文献.txt");
        String output = new String("C:\\Users\\鑫\\Desktop\\文献.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input),"utf-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output),"utf-8"));   
        try {
        	int i = 104735;
            String line = null;
            writer.write("<add>");
            while((line = reader.readLine()) != null){
            	
            	if("".equals(line.trim())){
                    writer.write("\n");
                    continue;
                }
           // 	if(line.contains("date"))              //字符串包含
//            	if("{".equals(line.trim()))
//            	{
//            	//	writer.write("  \"id\" : \"" + i +"\"," );
//            		writer.write("<doc>");
//            		writer.newLine();
//            		continue;
//            	}
            	line = line.replace("[","");
            	line = line.replace("]","");
            	line = line.replace("'","");
            	line = line.replace("？","");
            	line = line.replace("～","");
            	line = line.replace("<","");
            	line = line.replace(">","");
            	line = line.replace("&","");
            	line = line.replace("&mainkey","");
            	line = line.replace("\\","");
            	line = line.replace("/","");
        		line = line.replace("\"","");
        		line = line.replace(",","");
        		line = line.replace(" ","");
        		line = line.replace("<sub>","");
        		line = line.replace("</sub>","");
        		line = line.replace("<sup>","");
        		line = line.replace("</sup>","");
 //       		line = line.replaceAll("[^\u4e00-\u9fa5]", "");  
        		str = line.split(":",2);   //字符串分解
//            	if("},".equals(line.trim())) 
//            	{

 //          		System.out.println(line);
 //          		System.out.println(str[1]);
//           		System.out.println(str[2]);
//           		System.out.println(str[3]);
//           		System.out.println(str[4]);
////            		s = str[4].string(1,str[4].length()-2);
////            	//	s = s.replaceAll("[^\u4e00-\u9fa5]", "");       //去除特殊符号
////            	    s = s.replace("\\","");
////            	    s = s.replace("/","");
////            	    s = s.replace(",","");
////            	    s = s.replace("\"","");
// //           		writer.write("<field name=\"id\">" + s + "</field>");
// //           	    writer.write(s);
//            	//	writer.newLine();
// //         		System.out.println(line);
//                	writer.write("}");
//                	writer.newLine();
//                	i++;
//                	continue;
//            	}
            	if("{".equals(line.trim())) 
            	{
            		writer.write("<doc>");
            		writer.newLine();
            		writer.write("<field name=\"id\">" + i + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("title")) 
            	{
            
            		writer.write("<field name=\"title\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("applicant")) 
            	{
            
            		writer.write("<field name=\"applicant\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	
//            	if(line.contains("url")) 
//            	{
//            
//            		writer.write("<field name=\"url\">" + str[1] + "</field>");
//            		writer.newLine();
//            		continue;
//            	}
            	if(line.contains("abs")) 
            	{
            
            		writer.write("<field name=\"abs\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("inventor")) 
            	{
            
            		writer.write("<field name=\"inventor\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("expert_name")) 
            	{
            
            		writer.write("<field name=\"expert_name\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("expert_org")) 
            	{
            
            		writer.write("<field name=\"expert_org\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("date")) 
            	{
            
            		writer.write("<field name=\"date\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("author_cn")) 
            	{
            
            		writer.write("<field name=\"author_cn\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("unit")) 
            	{
            
            		writer.write("<field name=\"unit\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("journal_cn")) 
            	{
            
            		writer.write("<field name=\"journal_cn\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if(line.contains("key")) 
            	{
            
            		writer.write("<field name=\"key\">" + str[1] + "</field>");
            		writer.newLine();
            		continue;
            	}
            	if("}".equals(line.trim())) 
            	{
            		writer.write("</doc>");
            		writer.newLine();
            		i++;
            		continue;
            	}
            	writer.write(line);
            	writer.newLine();
            }
            writer.write("</add>");
    		writer.newLine();
        } catch (Exception e) {
        	System.out.println("EORROR");
        }
        finally{
            if(writer!=null)
            	writer.close();
         }
        System.out.println("end");
    }
    
}