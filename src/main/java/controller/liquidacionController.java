/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import gestion.liquidacionGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.liquidaciones;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;

/**
 *
 * @author Mauricio
 */
@Named(value = "liquidacionController")
@SessionScoped
public class liquidacionController extends liquidaciones implements Serializable{
    
     public liquidacionController() {
    }
   
    public List<liquidaciones> getLiquidacion() {
        return liquidacionGestion.getLiquidacion();
    }
    
   
    
    public String insertarLiquidacion(boolean e,float m,int i){
        liquidaciones li;
        li = new liquidaciones(e,m,i);
        
       if(liquidacionGestion.insertarLiquidacion(li)){
            return "liquidaciones.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al liquidar el empleado");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:id", msg);
            return "liquidaEmp.xhtml";
        }
    }
    
    
      public float calculaLiquidacion(Date d,float mont){
        Date last = new Date();
        Calendar a = getCalendar(d);
        Calendar b = getCalendar(last);
    int diff = b.get(YEAR) - a.get(YEAR);
    if (a.get(MONTH) > b.get(MONTH) || 
        (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
        diff--;
    }
    int c=1;
    if(diff<1){
        c=1;
    }
    else if(diff >=1 && diff<2){
        c=2;
    }
    else if(diff >=2 && diff<3){
        c=3;
    }
    else if(diff >=3 && diff<4){
        c=4;
    }
    else if(diff >=4 && diff<5){
        c=5;
    }
    else if(diff >=5 && diff<6){
        c=6;
    }
    else if(diff >=6 && diff<7){
        c=7;
    }
    else if(diff >=7 && diff<8){
        c=8;
    }
    else if(diff >=8){
        c=9;
    }
        switch(c)
      {
	 case 1:
	   mont =(((mont/4)/5)*17);
	 case 2:
	   mont =(((mont/4)/5)*19);
	 case 3:
	  mont =(((mont/4)/5)*20*2);
	 case 4:
          mont =(((mont/4)/5)*20*3);
           case 5:
          mont =(((mont/4)/5)*21*4);
	  case 6:
          mont =(((mont/4)/5)*21*5);
           case 7:
          mont =(((mont/4)/5)*22*6);
           case 8:
          mont =(((mont/4)/5)*22*7);
           case 9:
          mont =(((mont/4)/5)*22*8);
      }
    return mont;
    
    }
    
    public static Calendar getCalendar(Date date) {
    Calendar cal = Calendar.getInstance(Locale.US);
    cal.setTime(date);
    return cal;
}
    
     public float cL(float mont){
        float m = mont;
        m++;
        m++;
    return m;
    
    }
    
    
}
