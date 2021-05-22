/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.primefaces.model.chart.PieChartModel;
import model.estado;
import gestion.empleadosGestion;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import static javax.management.Query.value;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Mauricio
 */
@Named(value = "chartPieView1")
@SessionScoped
public class ChartPieView1 implements Serializable {
    private PieChartModel pieModel1;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }
 
    private void createPieModels() {
        createPieModel1();
    }
 
    /*private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        pieModel1.set("Brand 1", 540);
        pieModel1.set("Brand 2", 325);
        pieModel1.set("Brand 3", 702);
        pieModel1.set("Brand 4", 421);
 
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }*/
    
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        int x= 6;
        int y= 2;
        String label1 = "";
        String label2 = "";
        ArrayList<estado> datos = empleadosGestion.getEstados();
        int mayor = datos.get(0).getTotal();
        ArrayList<Boolean> lista = new ArrayList<>();
        datos.forEach(linea -> {
            lista.add(linea.isEstadoEmpleado());
        });
        
        List<Boolean> distinctElements = lista.stream()
                .distinct()
                .collect(Collectors.toList());
        
        for (Boolean value : distinctElements) {
            if (value.equals(true)) {
                x=x+1;
            } else {  
            }
            if (value.equals(false)) {
                y=y+1;

            }
        }
        pieModel1.set("Activos", x);
        pieModel1.set("Inactivos", y);
        pieModel1.setTitle("Estado del empleado");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
    
    
    
    
  
}