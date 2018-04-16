/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc_a1_contactmanager;
import java.io.Serializable;
import java.util.Scanner;
/**
 * @author KARAN ACER
 */
public class C2 implements Serializable{
    private String name;
    private String number;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public C2(String name, String number) {
        this.name = name;
        this.number = number;
    }
     public static C2 newContact()
    {
        String contactName,phoneNumber;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Contact Name : ");
        contactName = sc.next();
        System.out.println("Enter a phone number : ");
        phoneNumber = sc.next();
        C2 newCon = new C2(contactName,phoneNumber);
        return newCon;
    }

    @Override
    public String toString() {
        return "\nName=" + name + ", Number=" + number;
    }
       
}
