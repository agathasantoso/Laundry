/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author NAT
 */
public class LaundryController implements Initializable {

    @FXML
    private TextField nama;
    @FXML
    private TextField alamat;
    @FXML
    private TextField berat;
    @FXML
    private TextField no;
    @FXML
    private RadioButton kering;
    @FXML
    private ToggleGroup paket;
    @FXML
    private RadioButton keringsetrika;
    @FXML
    private RadioButton setrika;
    @FXML
    private TextField tgl;
    @FXML
    private Button ok;
    @FXML
    private Button hapuss;
    @FXML
    private TextArea hasil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void proses(ActionEvent event) {
        String paket;
        int harga = 0;
        if(kering.isSelected())
            paket = "Cuci kering";
        else if(keringsetrika.isSelected())
            paket = "Cuci kering setrika";
        else if (setrika.isSelected())
            paket = "Setrika";
        else
            paket = " ";
        
        if(!(kering.isSelected() || keringsetrika.isSelected() || setrika.isSelected())){
            JOptionPane.showMessageDialog(null, "Harap mengisi data dengan benar!");
        }
        else{
            
            String editnama = nama.getText();
            String editalamat = alamat.getText();
            String editberat = berat.getText()+"kg";
            String edittanggal = tgl.getText();
            
            int hitung = Integer.parseInt(berat.getText());
            
            if(kering.isSelected())
            harga = hitung * 5000;
            else if(keringsetrika.isSelected())
            harga = hitung * 8000;
            else if(setrika.isSelected())
            harga = hitung * 4000;
            String editno = no.getText();
            
            hasil.setText("Nama: "+ editnama +"\n"+"Alamat: "+ editalamat +"\n"+"Berat cucian: "+ editberat +
               "\n"+"No telepon: "+ editno +"\n"+"Pilihan paket: "+ paket +"\n"+"Tanggal pengambilan: "+ 
                    edittanggal+ "\n"+ "Harga: "+ harga );
        }
    }

    @FXML
    private void hapus(ActionEvent event) {
        nama.setText("");
        alamat.setText("");
        berat.setText("");
        no.setText("");
        kering.setSelected(false);
        keringsetrika.setSelected(false);
        setrika.setSelected(false);
        tgl.setText("");
    }
    
}
