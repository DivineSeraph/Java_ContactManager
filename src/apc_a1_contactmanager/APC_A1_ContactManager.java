/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc_a1_contactmanager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KARAN ACER
 */
public class APC_A1_ContactManager {

    /**
     * @param contactList display arguments
     * @param args the command line arguments
     */
    
    
    public static void display(ArrayList <C2> contactList)
    {
        if(contactList.size()>0)
        {
            for(C2 i : contactList)
               System.out.println(i);
        }
        else
            System.out.println("No contacts in contact list");
    }
    
    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        ArrayList <C2> contactList;
        ArrayList <C2> oldConList;
        do{
            System.out.println("WELCOME TO CONTACT MANAGER");
            System.out.println("Press 1.Add new contact 2.Search for a contact "
                    + "3.Delete a contact 4.Update a contact 5.Display all contacts 6.Exiit");
            ch=sc.nextInt();
            if(ch==6)
                break;
            switch(ch)
            {
                case 1: contactList=FileOperations.readAllCon();
                        contactList.add(C2.newContact());
                        FileOperations.addCon(contactList);
                        break;
                case 2: System.out.println("Enter Name or Number of Contact : ");
                        String Searchkey = sc.next();
                        FileOperations.conSearch(Searchkey);
                        break;
                case 3: System.out.println("Enter Name or Number of Contact : ");
                        String delKey = sc.next();
                        FileOperations.conDelete(delKey);
                        break;
                case 4: System.out.println("Enter Name or Number of Contact : ");
                        String key = sc.next();
                        FileOperations.conUpdate(key);
                        break;
                case 5: oldConList = FileOperations.readAllCon();
                        display(oldConList);
                        break;
                default: System.out.println("Invalid Choice...Try again");
            }
        }while(true);
    }
    
}
