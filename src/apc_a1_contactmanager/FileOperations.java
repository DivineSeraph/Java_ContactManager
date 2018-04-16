/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc_a1_contactmanager;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author KARAN ACER
 */
public class FileOperations {
    
    public static void addCon(ArrayList <C2> newCon)
    {   
        int i=0;
        try{
            FileOutputStream fos = new FileOutputStream("Contact.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            while(newCon.size()>i)
                oos.writeObject(newCon.get(i++));
            oos.close();
        }
        catch(FileNotFoundException exception)
        {
            System.err.println("File not found");
        }
        catch(IOException ioe)
        {
            System.err.println("IOException");
            //ioe.printStackTrace();
        }
    }
    
    public static ArrayList readAllCon()
    {   C2 oldCon;
        ArrayList <C2> cList = new ArrayList<>();
        ObjectInputStream ois = null;
        try{
             FileInputStream fis = new FileInputStream("Contact.ser");
             ois = new ObjectInputStream(fis);
             while(true)
             {
                 oldCon = (C2) ois.readObject();
                 cList.add(oldCon);
             }
         }
        catch(EOFException eof)
        {
            return cList;
        }
         catch(Exception e){
             System.err.println("Error");
            // e.printStackTrace();
         }
        finally{
            try{
                if(ois != null)
                    ois.close();
            }
            catch(IOException io)
            {
                System.err.println("error closing input stream in readall");
            }
        }
        return cList;
        
    }
    
    public static void conSearch(String key)
    {
        C2 oldCon;
        ObjectInputStream ois = null;
        try
        {
            FileInputStream fis = new FileInputStream("Contact.ser");
            ois = new ObjectInputStream(fis);
            while(true)
             {
                 oldCon = (C2) ois.readObject();
                 if(oldCon.getName().equals(key)||oldCon.getNumber().equals(key))
                 {
                     System.out.println("Contact found : "+oldCon);
                     ois.close();
                     return;
                 }
                 
             }
        }
        catch(EOFException eof)
        {
            System.out.println("No such record");
        }
        catch(Exception e)
        {
            System.err.println("Error in searching");
        }
        finally{
           try{
                if(ois != null)
                    ois.close();
            }
            catch(IOException exception)
            {
                System.err.println("Error closing input stream in search");
            }
        }
    }
    
    public static void conDelete(String key)
    {
         C2 oldCon;
         ObjectInputStream ois = null;
         ObjectOutputStream oos = null;
        try
        {
            FileInputStream fis = new FileInputStream("Contact.ser");
            ois = new ObjectInputStream(fis);
            FileOutputStream fos = new FileOutputStream("Contacttmp.ser");
            oos = new ObjectOutputStream(fos);
            while(true)
             {
                 oldCon = (C2) ois.readObject();
                 if(oldCon.getName().equals(key)||oldCon.getNumber().equals(key))
                 {
                     System.out.println("Contact deleted : "+oldCon);
                     continue;
                 }
                 oos.writeObject(oldCon);
                 
             }
        }
        catch(EOFException eof)
        {   
            try{
                if(ois != null)
                    ois.close();
                if(oos != null)
                    oos.close();
            }
            catch(IOException ioe)
            {
                System.err.println("Error closing streams in delete");
            } 
        }
        catch(Exception e)
        {
            System.err.println("Error in searching");
        }
        finally{
             try
            {   //System.out.println("In try block after catching eof");
                File file = new File("Contacttmp.ser");
                File file2  = new File("Contact.ser");
                file2.delete();
                file.renameTo(file2);
                //if(file2.delete())
                    //System.out.println("File deleted");
                if(file.exists())
                    System.out.println("File not deleted");
                //if(file.renameTo(file2))
                    //System.out.println("File renamed");
            }
            catch(Exception e)
            {
                System.err.println("Error in rename");
            }
           
        }
    }
    
        public static void conUpdate(String key)
    {
         C2 oldCon;
         ObjectInputStream ois = null;
         ObjectOutputStream oos = null;
         Scanner sc = new Scanner(System.in);
        try
        {
            FileInputStream fis = new FileInputStream("Contact.ser");
            ois = new ObjectInputStream(fis);
            FileOutputStream fos = new FileOutputStream("Contacttmp.ser");
            oos = new ObjectOutputStream(fos);
            while(true)
             {
                 oldCon = (C2) ois.readObject();
                 if(oldCon.getName().equals(key)||oldCon.getNumber().equals(key))
                 {
                     System.out.println("Conatct: "+oldCon+"\nContact Enter new Details: ");
                     System.out.println("Name: ");
                     oldCon.setName(sc.next());
                     System.out.println("Number : ");
                     oldCon.setNumber(sc.next());
                 }
                 oos.writeObject(oldCon);
                 
             }
        }
        catch(EOFException eof)
        {   
            try{
                if(ois != null)
                    ois.close();
                if(oos != null)
                    oos.close();
            }
            catch(IOException ioe)
            {
                System.err.println("Error closing streams in delete");
            }
           
        }
        catch(Exception e)
        {
            System.err.println("Error in searching");
        }
        finally{
             try
            {  // System.out.println("In try block after catching eof");
                File file = new File("Contacttmp.ser");
                File file2  = new File("Contact.ser");
                file2.delete();
                file.renameTo(file2);
                //if(file2.delete())
                  //  System.out.println("File deleted");
                if(file.exists())
                    System.out.println("File not deleted");
               // if(file.renameTo(file2))
                    //System.out.println("File renamed");
            }
            catch(Exception e)
            {
                System.err.println("Error in rename");
            }
           
        }
    }
    
}
