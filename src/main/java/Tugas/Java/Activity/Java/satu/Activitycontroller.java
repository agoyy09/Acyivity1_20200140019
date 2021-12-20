/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas.Java.Activity.Java.satu;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Raihan
 */
@Controller
public class Activitycontroller {
    
    @RequestMapping("/kirimdata")
    public String getData(HttpServletRequest data, Model kurir){
        
        String nmbuah = data.getParameter("var_nmbuah");
        String hgkilo = data.getParameter("var_hgkilo");
        String jhbeli = data.getParameter("var_jhbeli");
        
        Double harga_perkilo = Double.parseDouble(hgkilo);
        Double jumlah_beli = Double.parseDouble(jhbeli);
        
        Double harga = harga_perkilo * jumlah_beli;
        String potongan_harga = null;
        Double jumlah_potongan_harga = null;
        Double total_harga = null;
        
        if (harga < 16000){
            potongan_harga = "0%";
            jumlah_potongan_harga = harga*0/100;
            total_harga = harga - (harga*0/100);
        }
        else if (harga >= 16000 && harga <= 25000){
            potongan_harga = "10%";
            jumlah_potongan_harga = harga*10/100;
            total_harga = harga - (harga*10/100);
        }
        else if (harga > 25000){
            potongan_harga = "15%";
            jumlah_potongan_harga = harga*15/100;
            total_harga = harga - (harga*15/100);
        }
        
        kurir.addAttribute("nb", nmbuah);
        kurir.addAttribute("hk", hgkilo);
        kurir.addAttribute("jhbeli", jhbeli);
        kurir.addAttribute("harga", harga);
        kurir.addAttribute("ph", potongan_harga);
        kurir.addAttribute("jph", jumlah_potongan_harga);
        kurir.addAttribute("tot_harga", total_harga);
   
        return "Raihanf";
        
    }
    
}
