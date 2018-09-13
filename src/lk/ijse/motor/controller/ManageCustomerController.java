/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import lk.ijse.motor.bussiness.custom.CustomerBO;
import lk.ijse.motor.bussiness.custom.CustomerDetailBO;
import lk.ijse.motor.bussiness.custom.InvoiceBO;
import lk.ijse.motor.bussiness.custom.InvoicedetailBO;
import lk.ijse.motor.bussiness.custom.PartBO;
import lk.ijse.motor.bussiness.custom.VehicleBO;
import lk.ijse.motor.bussiness.custom.impl.*;
import lk.ijse.motor.dto.CustomerDTO;
import lk.ijse.motor.dto.CustomerDetailDTO;
import lk.ijse.motor.dto.InvoiceDTO;
import lk.ijse.motor.dto.InvoiceDetailDTO;
import lk.ijse.motor.dto.PartDTO;
import lk.ijse.motor.dto.VehicleDTO;
import lk.ijse.motor.main.AppInitializer;
import lk.ijse.motor.view.util.tblmodel.ListTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ranga Lankathilaka
 */
public class ManageCustomerController implements Initializable {

    @FXML
    private JFXTextField txtPname;
    @FXML
    private JFXComboBox<String> comboPid;
    @FXML
    private JFXTextField txtPrice;
    @FXML
    private JFXTextField txtDes;
    @FXML
    private TableView<ListTM> tblPart;
    @FXML
    private JFXTextField txtTotal;
    @FXML
    private JFXTextField txtCid;
    @FXML
    private JFXTextField txtCName;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtxVNum;
    @FXML
    private JFXTextField txtVIssue;
    @FXML
    private JFXTextField txtQty;

    PartBO partBO;
    InvoiceBO invoiceBO;
    CustomerBO customerBO;
    VehicleBO vehicleBO;
    InvoicedetailBO invoicedetailBO;
    CustomerDetailBO customerDetailBO;
    @FXML
    private JFXTextField txtInvDis;
    @FXML
    private JFXTextField txtxVType;
    @FXML
    private ImageView imgbike;
    @FXML
    private ImageView imgthree;
    @FXML
    private Pane root;
    
    
    

    public ManageCustomerController() {
        partBO =  AppInitializer.ctx.getBean(PartBOImpl.class);
        invoiceBO = AppInitializer.ctx.getBean(InvoiceBOImpl.class);
        customerBO = AppInitializer.ctx.getBean(CustomerBOImpl.class);
        vehicleBO = AppInitializer.ctx.getBean(VehicleBOImpl.class);
        invoicedetailBO = AppInitializer.ctx.getBean(InvoicedetailBOImpl.class);
        customerDetailBO = AppInitializer.ctx.getBean(CustomerDetailBO.class);
    }

    @FXML
    private void btnAddToList(ActionEvent event) {

//        ObservableList<ListTM> arr=tblPart.getItems();
//        for (ListTM listTM : arr) {
//            System.out.println("nnknnklnl");
//            int pid = listTM.getPid();
//            if(pid==Integer.parseInt(comboPid.getValue())){
//                repeartID();
//               
//            }
//                
//            
//                
//            
//        }
        addTotable();

    }

    private void saveVehicle() {
        try {
            int num = Integer.parseInt(txtxVNum.getText());
            String type = txtxVType.getText();
            String issue = txtVIssue.getText();
            int cid = Integer.parseInt(txtCid.getText());
            VehicleDTO vehicleDTO = new VehicleDTO(num, type, issue, cid);
            boolean save = vehicleBO.save(vehicleDTO);
        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveCustomer() {
        try {
            int cid = Integer.parseInt(txtCid.getText());
            String name = txtCName.getText();
            int contact = Integer.parseInt(txtContact.getText());
            String address = txtAddress.getText();

            CustomerDTO customerDTO = new CustomerDTO(cid, name, contact, address);
            // System.out.println(cid);
            boolean save = customerBO.save(customerDTO);

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void saveInvoice() {
//        try {
//
//            String invDis = txtInvDis.getText();
//            int cid = Integer.parseInt(txtCid.getText());
//
//            InvoiceDTO invoiceDTO = new InvoiceDTO(invDis, cid);
//            boolean save = invoiceBO.save(invoiceDTO);
//            if (save) {
//                Alert b = new Alert(Alert.AlertType.INFORMATION);
//                b.show();
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @FXML
    private void btnSell(ActionEvent event) {

        try {
            //saveCustomer()
            int cid = Integer.parseInt(txtCid.getText());
           // System.out.println(cid);
            String name = txtCName.getText();
            //System.out.println(name);
            int contact = Integer.parseInt(txtContact.getText());
            String address = txtAddress.getText();

            CustomerDTO customerDTO = new CustomerDTO(cid, name, contact, address);

            // saveInvoice();
            String invDis = txtInvDis.getText();

            int lastIID = invoiceBO.getLastIID();
            int iid = lastIID+1; ////////////////////////////////////////////////////////////////


            InvoiceDTO invoiceDTO = new InvoiceDTO(iid,invDis, cid);
//            boolean save1 = invoiceBO.save(invoiceDTO);

            // printBillItemSave();

            System.out.println("<<<<<<<<<<<"+iid);
          //  System.out.println(iid);
            int totalAmount = Integer.parseInt(txtTotal.getText());
            String detail = txtDes.getText();
            ArrayList<InvoiceDetailDTO> arrlist = new ArrayList<>();
            ObservableList<ListTM> arr = tblPart.getItems();
            for (ListTM listTM : arr) {
                int pid = listTM.getPid();
              //  String pname = listTM.getPname();
                int qty = listTM.getQty();
                int selling_price = listTM.getSelling_price();
                int total = listTM.getTotal();
                InvoiceDetailDTO invoiceDetailDTO = new InvoiceDetailDTO(pid, iid, detail, qty, selling_price, total, totalAmount);
                
                
                arrlist.add(invoiceDetailDTO);

            }

            // addCustomerDetail();
            // int cid  = Integer.parseInt(txtCid.getText());
            int pid = Integer.parseInt(comboPid.getValue());
            CustomerDetailDTO customerDetailDTO = new CustomerDetailDTO(cid, pid, null);
            //customerDetailBO.save(customerDetailDTO);
            //subtractQtyFromStore();

            ObservableList<ListTM> arr2 = tblPart.getItems();
            PartDTO partDTO =null;
            for (ListTM listTM : arr2) {

                int qty = listTM.getQty();
                // int pid=listTM.getPid();
                PartDTO find = partBO.find(pid);
                int qty1 = find.getQty();
                System.out.println(qty1);
                int newqty = qty1 - qty;
               // System.out.println(newqty);
                partDTO = new PartDTO(pid, newqty);
                //boolean updateQty = partBO.updateQty(partDTO);

            }

            boolean save = customerBO.save(customerDTO, invoiceDTO, arrlist, customerDetailDTO, partDTO);

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //    saveInvoice();
//        printBillItemSave();
//      addCustomerDetail();
        //   subtractQtyFromStore();
        
        
         InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/motor/reports/Bill.jasper");

        //double tot = Double.parseDouble(toString.getText());
        //double bal = Double.parseDouble(balance.getText());
        int total=Integer.parseInt(txtTotal.getText());

        HashMap map = new HashMap();
        map.put("total", total);
      //  map.put("balance", bal);
        try {
            JasperPrint jasperPrint =JasperFillManager.fillReport(resourceAsStream, map, new JRBeanCollectionDataSource(tblPart.getItems()));
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
    }

    private void test() {
        ObservableList<ListTM> arr = tblPart.getItems();

        for (ListTM listTM : arr) {
            int pid = listTM.getPid();
            if (pid == Integer.valueOf(comboPid.getValue())) {
                int index = arr.indexOf(arr);
                System.out.println(index);
            }
            int index = arr.indexOf(arr);
            System.out.println(index);
        }
    }

    @FXML
    private void btnRemoveList(ActionEvent event) {
        //repeartID();
        int selectedIndex = tblPart.getSelectionModel().getSelectedIndex();
        //System.out.println(selectedIndex);
        tblPart.getItems().remove(selectedIndex);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // table1.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("mid"));

        tblPart.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("pid"));

        tblPart.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("pname"));

        tblPart.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("selling_price"));
        tblPart.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblPart.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

       // getAllPartID();

    }

    private void addTotable() {
        int pid = Integer.parseInt((String) comboPid.getValue());
        String pname = txtPname.getText();
        int price = Integer.parseInt(txtPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        int total = price * qty;

        ListTM list = new ListTM(pid, pname, price, qty, total);
        ObservableList<ListTM> arr = tblPart.getItems();

//         for (OrderDetailTM item : items) {
//            if (item.getCode().equals(cmbItemCode.getValue())) {
//
//                if (tblOrderDetails.getSelectionModel().getSelectedIndex() == -1) {
//                    orderDetail.setQty(qty + item.getQty());
//                }
//
//                int index = items.indexOf(item);
//
//                items.set(index, orderDetail);
//                cmbItemCode.getSelectionModel().clearSelection();
//                cmbItemCode.requestFocus();
//
//                return;
//            }
//        }
        for (ListTM listTM : arr) {
            if (listTM.getPid() == Integer.parseInt(comboPid.getValue())) {

                if (tblPart.getSelectionModel().getSelectedIndex() == -1) {
                    int newqty1 = qty + listTM.getQty();
                    list.setQty(newqty1);
                    list.setTotal(newqty1 * price);
                    String a = String.valueOf(newqty1 * price);
                    txtTotal.setText(a);
                }

                int index = arr.indexOf(listTM);

                arr.set(index, list);

                return;
            }
        }

        arr.add(list);
        // ObservableList<ListTM> arr2=FXCollections.observableArrayList(arr);
        tblPart.setItems(arr);
        setTotal();

        //  repeartID();
    }

    private void setTotal() {
        int finalTotal = 0;
        ObservableList<ListTM> arr = tblPart.getItems();
        for (ListTM listTM : arr) {
            int a = listTM.getTotal();
            finalTotal += a;
            txtTotal.setText(String.valueOf(finalTotal));
        }

    }

    private void repeartID() {
        int totalQty = 0;
        ObservableList<ListTM> arr = tblPart.getItems();
        for (ListTM listTM : arr) {

            int pid = listTM.getPid();

            String pname = listTM.getPname();
            int selling_price = listTM.getSelling_price();
            int qty = listTM.getQty();
            int total = listTM.getTotal();

            if (pid == Integer.parseInt((String) comboPid.getValue())) {
                int selectedIndex = Integer.parseInt((String) comboPid.getValue());
                System.out.println(selectedIndex);
                tblPart.getItems().remove(selectedIndex);
//
//
//                qty = qty + Integer.parseInt(txtQty.getText());
//                int newtotal = selling_price * qty;
//                ListTM list2 = new ListTM(pid, pname, selling_price, qty, newtotal);
//                ObservableList<ListTM> arr4 = tblPart.getItems();
//                arr4.add(list2);
//                tblPart.setItems(arr4);

                System.out.println(pid);

            }

        }//System.out.println(totalQty);
    }

    private void getAllPartID() {
        try {
            ArrayList<PartDTO> arr = partBO.getAllPartID();
            ArrayList<String> arr2 = new ArrayList();

            for (PartDTO partDTO : arr) {
                String id = String.valueOf(partDTO.getPid());
                // PartDTO partDTO1=new PartDTO(id);
                arr2.add(id);
            }

            ObservableList<String> arr3 = FXCollections.observableArrayList(arr2);
            comboPid.setItems(arr3);

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setPNameSellPrice() {
        try {
            int pid = Integer.parseInt(comboPid.getValue());
            System.out.println(pid);
            PartDTO partDTO = partBO.find(pid);
            txtPname.setText(partDTO.getPname());
            System.out.println(partDTO.getPname());
            txtPrice.setText(String.valueOf(partDTO.getSelling_price()));

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void combpPartClick(ActionEvent event) {
        setPNameSellPrice();

    }

    @FXML
    private void btnService(ActionEvent event) {
       
  
    String name=txtCName.getText();
    String cid=txtCid.getText();
    String contact=txtContact.getText();
    
//    if (!name.matches("[A-Za-z. ]+")){
//            new Alert(Alert.AlertType.ERROR,"Invalid name",ButtonType.OK).show();
//            txtCName.requestFocus();
//            return;
//        }
//     if (!contact.matches("\\d{3}-\\d{7}")){
//            new Alert(Alert.AlertType.ERROR,"Invalid phone number",ButtonType.OK).show();
//            txtContact.requestFocus();
//            return;
//        }
    
    
     saveCustomer();
        saveVehicle();
    Alert b=new Alert(Alert.AlertType.INFORMATION);
    b.show();
    
    }

    private void printBillItemSave() {
//
//        try {
//            //          pid           | int(11)     | NO   | PRI | NULL    |       |
////| iid           | int(11)     | NO   | PRI | NULL    |       |
////| detail        | varchar(45) | YES  |     | NULL    |       |
////| qty           | int(11)     | YES  |     | NULL    |       |
////| selling_price | int(11)     | YES  |     | NULL    |       |
////| total         | int(11)     | YES  |     | NULL    |       |
////| total_amount  |
//            InvoiceDTO lastIID = invoiceBO.getLastIID();
//            int iid = lastIID.getIid();
//            System.out.println(iid);
//            int totalAmount = Integer.parseInt(txtTotal.getText());
//            String detail = txtDes.getText();
//
//            ObservableList<ListTM> arr = tblPart.getItems();
//            for (ListTM listTM : arr) {
//                int pid = listTM.getPid();
//                String pname = listTM.getPname();
//                int qty = listTM.getQty();
//                int selling_price = listTM.getSelling_price();
//                int total = listTM.getTotal();
//                InvoiceDetailDTO invoiceDetailDTO = new InvoiceDetailDTO(pid, iid, detail, qty, selling_price, total, total);
//                ArrayList<InvoiceDetailDTO> arrlist=new ArrayList<>();
//                arrlist.add(invoiceDetailDTO);
//                
//           
//        
//            }
//
//            
//           
//
//        } catch (Exception ex) {
//            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    private void addCustomerDetail() {
//        try {
//            int cid  = Integer.parseInt(txtCid.getText());
//            int pid=Integer.parseInt(comboPid.getValue());
//            CustomerDetailDTO customerDetailDTO=new CustomerDetailDTO(cid, pid,null);
//            customerDetailBO.save(customerDetailDTO);
//        } catch (Exception ex) {
//            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        

    }

    private void subtractQtyFromStore() {
//        ObservableList<ListTM> arr=tblPart.getItems();
//        for (ListTM listTM : arr) {
//            try {
//                int qty = listTM.getQty();
//                int pid=listTM.getPid();
//                PartDTO find = partBO.find(pid);
//                int qty1 = find.getQty();
//                System.out.println(qty1);
//                int newqty=qty1-qty;
//                PartDTO partDTO=new PartDTO(pid,newqty);
//                boolean updateQty = partBO.updateQty(partDTO);
//            } catch (Exception ex) {
//                Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            
//        }
    }

    @FXML
    private void btnService(MouseEvent event) {
   
    
    
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
    private void bikeclick(MouseEvent event) {
        txtxVType.setText("Motor bike");
        getAllPartID();
    }

    @FXML
    private void threeclick(MouseEvent event) {
        txtxVType.setText("Three wheel");
        getAllPartID();
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
          AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    
    
    
    
}
