/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mycompany.lab6;
import java.util.*;
import java.io.*;
public class Arxmlfiles {
    public static void main(String[] args) throws Exception {
       try{
           String fileName=args[0];
           //Scanner fileName= new Scanner(System.in);
           File file = new File(fileName);
           if(!fileName.endsWith(".arxml")){
               throw new NotVaildAutosarFileException("Not Vaild Autosar File Exception");
           }
           //The size of the empty file is 8 bytes due to its Type (.arxml)file 
           // the only empty file that of size 0 bytes is the text file
           if(file.length()==8){//The size of the empty file is 8 bytes due to its Type (.arxml)file   
               throw new EmptyAutosarFileException("Empty Autosar File Exception");
           }
           FileInputStream input=new FileInputStream(file);
           int i;
           StringBuilder stringBuilder = new StringBuilder();
           while((i=input.read())!=-1){
               stringBuilder.append((char)i);
           }
           String data = stringBuilder.toString();
           Scanner scanner= new Scanner(data);
           ArrayList<CONTAINER> containers=new ArrayList<>();
           while(scanner.hasNextLine()){String line = scanner.nextLine();
           if(line.contains("<CONTAINER")){
            String UUID=line.substring(line.indexOf(" UUID="),line.indexOf(">"));  
            String SHORT_NAME=scanner.nextLine();
            String s=SHORT_NAME.substring(SHORT_NAME.indexOf(">")+1 , SHORT_NAME.indexOf("</"));
            String LONG_NAME=scanner.nextLine();
            String l=LONG_NAME.substring(LONG_NAME.indexOf(">")+1 , LONG_NAME.indexOf("</"));
            CONTAINER container= new CONTAINER();
            container.setUUID(UUID);
            container.setSHORT_NAME(s);
            container.setLONG_NAME(l); 
            containers.add(container);
           }
           Collections.sort(containers);
           String outputName=file.getName().substring(0, file.getName().indexOf("."))+ "_mod.arxml";
           FileOutputStream output=new FileOutputStream(outputName);
           output.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
           output.write("<AUTOSAR>\n".getBytes());
           for(int j=0; j<containers.size(); j++){
               output.write(containers.get(j).toString().getBytes());
           }
           output.write("  </CONTAINER>\n".getBytes());
           output.write("</AUTOSAR>\n".getBytes());
           }
       }
          catch(EmptyAutosarFileException e){ 
           } 
           catch(NotVaildAutosarFileException e){       
           }
}
}
// Exception Classes:

//Not Vaild Autosar File Exception
class NotVaildAutosarFileException extends Exception {
    public NotVaildAutosarFileException(String msg) {
         System.out.println(msg);
    }   
}

//Empty Autosar File Exception 
 class EmptyAutosarFileException extends Exception{  
    public EmptyAutosarFileException(String msg) {
         System.out.println(msg);
    }    
} 

// CONTAINER Class
class CONTAINER implements Comparable<CONTAINER> {
  private String UUID;
  private String SHORT_NAME;
  private String LONG_NAME;

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setSHORT_NAME(String SHORT_NAME) {
        this.SHORT_NAME = SHORT_NAME;
    }

    public void setLONG_NAME(String LONG_NAME) {
        this.LONG_NAME = LONG_NAME;
    }

    public String getUUID() {
        return UUID;
    }

    public String getSHORT_NAME() {
        return SHORT_NAME;
    }

    public String getLONG_NAME() {
        return LONG_NAME;
    }
    @Override
    public String toString(){
      return "  <CONTAINER" +this.getUUID()+ ">\n"
              + "    <SHORT-NAME>" + this.getSHORT_NAME()+ "</SHORT-NAME>\n"
              + "    <LONG-NAME>" + this.getLONG_NAME()+ "</LONG-NAME>\n";
    }
    @Override
    public int compareTo(CONTAINER c){
     if(this.getSHORT_NAME().charAt(9)>c.getSHORT_NAME().charAt(9)){
         return 1;
    }
     else if (this.getSHORT_NAME().charAt(9)<c.getSHORT_NAME().charAt(9)){
         return -1;
     }
     else{
         return 0;
     }     }
}



