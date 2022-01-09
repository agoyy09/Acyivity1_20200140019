/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ControllerBuah;

/**
 *
 * @author asus
 */
class proses {
    
    double early;
    public Double njumlahbayar(String inputHarga, String inputJumlahBeli){
        Integer hargaBuah = Integer.valueOf(inputHarga);
        Double jumlahBeli = Double.valueOf(inputJumlahBeli);

        Double jumlahBayar = hargaBuah * jumlahBeli;
        early = jumlahBayar;
        return jumlahBayar;
    }
    
    public String ndiskon (){
        String diskon = null;
        
        if (early < 16000){
            diskon = "0%";
        }
        else if (early >= 16000 && early <= 25000){
            diskon = "10%";
        }
        else if (early > 25000){
            diskon = "15%";
        }
        
        return diskon;
    }
    
    double hargadiskon;
    
    public Double njumlahDiskon(){
        Double jumlahDiskon = null;
        if (early < 16000){
            jumlahDiskon = early*0/100;
        }
        else if (early >= 16000 && early <= 25000){
            jumlahDiskon = early*10/100;
        }
        else if (early > 25000){
            jumlahDiskon = early*15/100;
        }
        hargadiskon = jumlahDiskon;
        return jumlahDiskon;  
    }
    
    public Double ntotalBayar(){
        Double totalBayar = null;
        totalBayar = early - hargadiskon;

        return totalBayar;

    }
    
    public String kembalian(String c){
        String info;
        
        double back;
        double douc = Double.parseDouble(c);
        if (douc == ntotalBayar())
        {
            
            info = "uang anda cukup";
        }
        
        else if (douc < ntotalBayar())
        {
            back = ntotalBayar() - douc;
            info = "uang anda kurang " + " Rp" + back;
        }
        
        else 
        {
            back = douc - ntotalBayar();
            info = "uang kembalian anda " +"Rp" + back; 
        }
        
        return info;
    }
   
}
