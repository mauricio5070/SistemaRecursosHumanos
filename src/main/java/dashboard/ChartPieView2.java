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
@Named(value = "chartPieView2")
@SessionScoped
public class ChartPieView2 implements Serializable {    
    private PieChartModel pieModel2;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }

    public PieChartModel getPieModel2() {
        return pieModel2;
    }
 
    private void createPieModels() {
        createPieModel2();
    }
 
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
 int x= 6;
        int y= 2;
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
        pieModel2.set("Activos", x);
        pieModel2.set("Inactivos", y);
 
        pieModel2.setTitle("Porcentajes");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        pieModel2.setShadow(false);
    } 
}