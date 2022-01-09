/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ControllerBuah;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author asus
 */
@Controller
public class ControllerBuah {
    @RequestMapping("/Welcome")
    public String getData(HttpServletRequest data, Model proses){
        
        String inputBuah = data.getParameter("var_namabuah");
        String inputHarga = data.getParameter("var_hargaperkilo");
        String inputJumlahBeli = data.getParameter("var_jumlahbeli");
        String uangCostoumer = data.getParameter("var_uang");
        
        
        proses pd = new proses();
        
        Double tjumlahbayar = pd.njumlahbayar(inputHarga, inputJumlahBeli);
        String tdiskon = pd.ndiskon();
        Double tjumlahDiskon = pd.njumlahDiskon();
        Double ttotalBayar = pd.ntotalBayar();
        String tkembali = pd.kembalian(uangCostoumer);
        
        
        
        
        proses.addAttribute("nama", inputBuah);
        proses.addAttribute("hargaKilo", inputHarga);
        proses.addAttribute("jbeli", inputJumlahBeli);
        proses.addAttribute("harga", tjumlahbayar);
        proses.addAttribute("dci", tdiskon);
        proses.addAttribute("totdc", tjumlahDiskon);
        proses.addAttribute("tot_harga", ttotalBayar);
        proses.addAttribute("uang", tkembali);
        proses.addAttribute("costoumer",  uangCostoumer);
   
        return "prayoga";
 }
}
