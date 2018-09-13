/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.motor.bussiness.custom.PartBO;
import lk.ijse.motor.bussiness.custom.impl.PartBOImpl;
import lk.ijse.motor.dto.PartDTO;
import lk.ijse.motor.main.AppInitializer;
import lk.ijse.motor.view.util.tblmodel.PartTM;

/**
 *
 * @author Ranga Lankathilaka
 */
public class ManagePartController implements Initializable{

    @FXML
    private TableView<PartTM> tblPart;
    @FXML
    private JFXTextField txtid;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtbuy;
    @FXML
    private JFXTextField txtSell;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtSup;
    @FXML
    private JFXComboBox<?> combowarrenty;
    
    private PartBO partBO;
    @FXML
    private AnchorPane root;
    
    
    public ManagePartController(){
        partBO =  AppInitializer.ctx.getBean(PartBOImpl.class);
    }
    private void save(){
        try {
            ArrayList<PartDTO> arrpart=partBO.getAll();
            for (PartDTO partDTO : arrpart) {
                int pid = partDTO.getPid();
                if(pid==Integer.parseInt(txtid.getText())){
                    update();
                    return;
                }
               
            }
            add();
        } catch (Exception ex) {
            Logger.getLogger(ManagePartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void update(){
        try {
            int id = Integer.parseInt(txtid.getText());
            String name = txtName.getText();
            int but = Integer.parseInt(txtbuy.getText());
            int sell = Integer.parseInt(txtSell.getText());
            int qty = Integer.parseInt(txtQty.getText());
            String supplier = txtSup.getText();
            
            PartDTO find = partBO.find(id);
            int qty1 = find.getQty();
            int newqty=qty+qty1;
            PartDTO dto=new PartDTO(id, name, but, sell,newqty, supplier);
            
            boolean update = partBO.update(dto);
        } catch (Exception ex) {
            Logger.getLogger(ManagePartController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
          
    }
    private  void delete(){
        try {
            int id=Integer.parseInt(txtid.getText());
            partBO.delete(id);
            loadAll();
            Alert b=new Alert(Alert.AlertType.INFORMATION);
            b.show();
        } catch (Exception ex) {
          

Logger.getLogger(ManagePartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadAll(){
        try {
            ArrayList<PartDTO> arr=partBO.getAll();
            ArrayList<PartTM> arr2=new ArrayList<>();
            for (PartDTO partDTO : arr) {
                int pid = partDTO.getPid();
                String pname = partDTO.getPname();
                int buying_price = partDTO.getBuying_price();
                int selling_price = partDTO.getSelling_price();
                int qty = partDTO.getQty();
                String supplier = partDTO.getSupplier();
            
            
            PartTM partTM=new PartTM(pid, pname, buying_price, selling_price, qty, supplier);
            arr2.add(partTM);
            
            
            
            }
            ObservableList<PartTM> arr3=FXCollections.observableArrayList(arr2);
            tblPart.setItems(arr3);
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(ManagePartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private  void add(){
        try {
            int id = Integer.parseInt(txtid.getText());
            String name = txtName.getText();
            int but = Integer.parseInt(txtbuy.getText());
            int sell = Integer.parseInt(txtSell.getText());
            int qty = Integer.parseInt(txtQty.getText());
            String supplier = txtSup.getText();
            
            
            PartDTO partDTO=new PartDTO(id, name, but, sell, qty, supplier);
            boolean rst = partBO.save(partDTO);
            if(rst){
               // txtid.setText("");
                Alert b=new Alert(Alert.AlertType.INFORMATION);
                b.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePartController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @FXML
    private void btnsavePart(ActionEvent event) {
     save();
        loadAll();
      
    }

    @FXML
    private void btndeletePart(ActionEvent event){
        delete();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    
      tblPart.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        
       tblPart.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("pname"));
        tblPart.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("buying_price"));
        
       tblPart.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("selling_price"));
        tblPart.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("qty"));
        
       tblPart.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("supplier"));
        
        
        loadAll();
        
        //table1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Member>()
        
         tblPart.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PartTM>(){
             
         @Override
         public void changed(ObservableValue<? extends PartTM> observable, PartTM oldValue, PartTM newValue){
             txtid.setText(String.valueOf(newValue.getId()));
             txtName.setText(newValue.getPname());
             txtbuy.setText(String.valueOf(newValue.getBuying_price()));
             txtSell.setText(String.valueOf(newValue.getSelling_price()));
             txtQty.setText(String.valueOf(newValue.getQty()));
             txtSup.setText(newValue.getSupplier());


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
     });
    
    
}

    @FXML
    private void navigateToHome(javafx.scene.input.MouseEvent event) {
          AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }
}
