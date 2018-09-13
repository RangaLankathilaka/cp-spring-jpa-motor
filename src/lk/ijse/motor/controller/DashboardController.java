/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.controller;

import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import lk.ijse.motor.bussiness.custom.PartBO;
import lk.ijse.motor.bussiness.custom.VehicleBO;
import lk.ijse.motor.bussiness.custom.impl.PartBOImpl;
import lk.ijse.motor.bussiness.custom.impl.VehicleBOImpl;
import lk.ijse.motor.dto.PartDTO;
import lk.ijse.motor.main.AppInitializer;
import lk.ijse.motor.view.util.tblmodel.LessQty;

/**
 *
 * @author Ranga Lankathilaka
 */
public class DashboardController implements Initializable {

    @FXML
    private PieChart chartsell;
    PartBO partBO;
    VehicleBO vehicleBO;
    @FXML
    private JFXListView<String> listview;
    @FXML
    private Label vehicleCountlable;
    @FXML
    private Pane root;
    @FXML
    private ImageView home;
    @FXML
    private ImageView customer;
    @FXML
    private ImageView part;

    public DashboardController() {

        partBO =  AppInitializer.ctx.getBean(PartBOImpl.class);
        vehicleBO=AppInitializer.ctx.getBean(VehicleBOImpl.class);
    }

    private void getSellParts() {

    }

    private void lessQty() {
        try {
            ArrayList<PartDTO> arr = partBO.showQtyLessFive();
            ArrayList<String> arr2 = new ArrayList<>();
            for (PartDTO partDTO : arr) {
                int pid = partDTO.getPid();
                String name = partDTO.getPname();
                LessQty lessqty = new LessQty(pid, name);

                arr2.add(name);

            }
            ObservableList<String> arr3 = FXCollections.observableArrayList(arr2);
            listview.setItems(arr3);

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        lessQty();
        getVehicleCount();

//        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//                new PieChart.Data("SE",50),
//                new PieChart.Data("Architect",25),
//                new PieChart.Data("Lead", 25)
//        );
//             
//        chartsell.setData(pieChartData);
//        
        getQty();
    }

    private void getQty() {

        try {
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

            ArrayList<PartDTO> arr = partBO.showSumQty();
            ArrayList<String> arr2 = new ArrayList<>();
            for (PartDTO partDTO : arr) {
                String pid = String.valueOf(partDTO.getPid());
                int qty = partDTO.getQty();

                //pieChartData = FXCollections.observableArrayList(
                        //new PieChart.Data(pid, qty)
                //);
                
                pieChartData.add(new PieChart.Data(pid,qty));

            }
            chartsell.setData(pieChartData);
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void getVehicleCount(){
        try {
            String vehicleCount = String.valueOf(vehicleBO.getVehicleCount());
            System.out.println("vehi"+vehicleCount);
            vehicleCountlable.setText(vehicleCount);
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void navigate(MouseEvent event) throws IOException {
        
          if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            Parent root = null;
            
            switch(icon.getId()){
                case "home":
                    //root = FXMLLoader.load(this.getClass().getResource(name));
                    break;
                case "customer":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/motor/view/CustomerManageForm.fxml"));
                    break;
                case "part":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/motor/view/PartManageForm.fxml"));
                    break;
                case "imgReport":
                    break;
            }
            
            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                
                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
                
            }
        }
        
        
        
        
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
          if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
          
            
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play(); 
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);            
        }
    }

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
            
      
         if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
           
        }
    
    
    
    }
    
    

}
