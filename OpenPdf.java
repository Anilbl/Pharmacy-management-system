/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import javax.swing.JOptionPane;
import java.io.File;
import dao.PharmacyUtil;

/**
 *
 * @author Anil
 */
public class OpenPdf {
   /* public static void openById(String id)
    {
    try{
        if(new File(PharmacyUtil.billPath+id+".pdf").exists()){
        Process p = Runtime
                .getRuntime()
                .exec("rundll32 url:dll,FileProtocalHandler "+PharmacyUtil.billPath+" "+id+".pdf");
     
        }
        else{
        JOptionPane.showMessageDialog(null, "File Does Not Exist");
        }
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    }*/
   
    /*public static void OpenBYID(String id){
        try{
         if((new File(Inventoryutils.billpath + id + ".pdf")).exists()){
         Process p =Runtime
                 .getRuntime()
                 .exec("rundll32 url.dll,FileProtocolHandler "+Inventoryutils.billpath+""+id+".pdf");}
         else{
                 JOptionPane.showMessageDialog(null, "File is not Exists!");
                 }     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }*/
    public static void OpenBYID(String id) {
    try {
        File pdfFile = new File(PharmacyUtil.billPath  + id + ".pdf");

        if (pdfFile.exists()) {
            ProcessBuilder processBuilder = new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", pdfFile.getAbsolutePath());
            processBuilder.start();
        } else {
            JOptionPane.showMessageDialog(null, "File does not exist!");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());

}


    }
    
}
