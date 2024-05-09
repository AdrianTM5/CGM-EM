package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Controlador 
{
	Stage primaryStage;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//----------------------------------Cambiar vistas----------------------------------------------------
	
	public void showNWorker(ActionEvent event)
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("WorkersScreen.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void showNomina(ActionEvent event)
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("NominaScreen.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void showLogs(ActionEvent event)
	{
		try 
		{
			root = FXMLLoader.load(getClass().getResource("LogsScreen.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------------------------
	
	//--------------------------------------Login y contraseña-------------------------------------------
	@FXML
	private TextField pTextField;
	private String password = "1234";
	
	public void logIn(ActionEvent event)
	{
		if(pTextField.getText().equals(password))
		{
			try 
			{
				root = FXMLLoader.load(getClass().getResource("NominaScreen.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
				
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			pTextField.clear();
		}
	}
	//-------------------------------------------------------------------------------------------------
	 
	//-------------------------------------------Botones Trabajadores----------------------------------
	@FXML
	private Button ButtonInfoP, ButtonInfoA, ButtonHorario;
	@FXML
	private AnchorPane InfoP, InfoA, Horario;
	 
	public void changeInfoP(ActionEvent event)
	 {
		 disguiseInfoA();
		 disguiseHorario();
		 InfoP.setVisible(true);
		 ButtonInfoP.setDefaultButton(true);
	 }
	 
	public void changeInfoA(ActionEvent event)
	 {
		 disguiseInfoP();
		 disguiseHorario();
		 InfoA.setVisible(true);
		 ButtonInfoA.setDefaultButton(true);
	 }
	 
	public void changeHorario(ActionEvent event)
	 {
		 disguiseInfoA();
		 disguiseInfoP();
		 Horario.setVisible(true);
		 ButtonHorario.setDefaultButton(true);
	 }
	 
	private void disguiseInfoA()
	 {
		 if(InfoA.isVisible() == true)  InfoA.setVisible(false);
		 if(ButtonInfoA.isDefaultButton() == true) ButtonInfoA.setDefaultButton(false);
	 }
	 
	private void disguiseInfoP()
	 {
		 if(InfoP.isVisible() == true) InfoP.setVisible(false);
		 if(ButtonInfoP.isDefaultButton() == true)  ButtonInfoP.setDefaultButton(false);
	 }
	 
	private void disguiseHorario()
	 {
		 if(Horario.isVisible() == true) Horario.setVisible(false);
		 if(ButtonHorario.isDefaultButton() == true) ButtonHorario.setDefaultButton(false);
	 }
	//--------------------------------------------------------------------------------------------------
	 
	//-------------------------------------------Botones Nominas---------------------------------------
	 
	 @FXML
	 private AnchorPane AnNominaL, AnNominaR, AnAguinaldo;
	 @FXML
	 private Button BtnNomina, BtnAguinaldo;
	 
	 public void changeNomina()
	 {
		 if(AnAguinaldo.isVisible() == true) AnAguinaldo.setVisible(false);
		 if(BtnAguinaldo.isDefaultButton() == true) BtnAguinaldo.setDefaultButton(false);
		 AnNominaL.setVisible(true);
		 AnNominaR.setVisible(true);
		 BtnNomina.setDefaultButton(true);
	 }
	 
	 public void changeAguinaldo()
	 {
		 if(AnNominaL.isVisible() == true) AnNominaL.setVisible(false);
		 if(AnNominaR.isVisible() == true) AnNominaR.setVisible(false);
		 if(BtnNomina.isDefaultButton() == true) BtnNomina.setDefaultButton(false);
		 AnAguinaldo.setVisible(true);
		 BtnAguinaldo.setDefaultButton(true);
	 }
	 //-------------------------------------------------------------------------------------------------
	 
	 //-------------------------------Guardar datos trabajadores---------------------------------------
	 private int tip = 0;
	 
	 @FXML
	 private TextField Tid, Tname, Tdep, Tcurp, Trfc, Tsueldo, Tcol, Tmun, Tcalle, TgEst, Ttel, TedoC, Tsex, Tine, Tcarr, Tinst;
	 
	 @FXML
	 private Button btnGuardar;
	 
	 @FXML
	 private MenuButton Mtipo;
	 
	 @FXML
	 private MenuItem MIObrero, MIAdmin;
	 
	 public void clickOb()
	 {
		 tip = 1;
		 Mtipo.setText("Obrero");
	 }
	 
	 public void clickAd()
	 {
		 tip = 2;
		 Mtipo.setText("Admin");
	 }
	 
	 @SuppressWarnings("unchecked")
	 public void createWorker()
	 {
		 JSONObject info = new JSONObject();
		 
		 if(Tid.getText() != null)
		 {
			 info.put("id", Tid.getText());
		 }
		 
		 if(Tname.getText() != null)
		 {
		 	info.put("name", Tname.getText());
		 }
		 
		 if(tip != 0)
		 {
			 info.put("tipo", tip);
		 }
		 
		 if(Tdep.getText() != null)
		 {
		 	info.put("dep", Tdep.getText());
		 }
		 
		 if(Tsueldo.getText() != null)
		 {
			info.put("sueldo", Tdep.getText());
		 }
		 //-----no obligatorios
		 
		 if(Tcurp.getText() != null)
		 {
			 info.put("curp", Tdep.getText());
		 }
		 
		 if(Trfc.getText() != null)
		 {
			 info.put("rfc", Tdep.getText());
		 }
		 
		 if(Tcol.getText() != null)
		 {
			 info.put("col", Tcol.getText());
		 }
		 
		 if(Tcol.getText() != null)
		 {
			 info.put("mun", Tdep.getText());
		 }
		 
		 if(Tcalle.getText() != null)
		 {
			 info.put("calle", Tcalle.getText());
		 }
		 
		 if(TgEst.getText() != null)
		 {
			 info.put("gEst", TgEst.getText());
		 }
		 
		 if(Ttel.getText() != null)
		 {
			 info.put("tel", Ttel.getText());
		 }
		 
		 if(TedoC.getText() != null)
		 {
			 info.put("gEst", TgEst.getText());
		 }
		 
		 if(Tsex.getText() != null)
		 {
			 info.put("sex", Tsex.getText());
		 }
		 
		 if(Tine.getText() != null)
		 {
			 info.put("ine", Tine.getText());
		 }
		 
		 if(Tcarr.getText() != null)
		 {
			 info.put("carr", Tcarr.getText());
		 }
		 
		 if(Tinst.getText() != null)
		 {
			 info.put("inst", Tinst.getText());
		 }	
		 
		 if(Tname.getText() != null && Tid.getText() != null && Tdep != null && Tcurp != null && Trfc != null && Tsueldo != null && tip != 0)
		 {
			 JSONArray workers = new JSONArray();
//			 workers.put("trabajador", Tname.getText() + " " + Tid.getText());
			 workers.add(info);
			 try(FileWriter file = new FileWriter("workers.json"))
			 {
				 file.write(workers.toJSONString());
				 file.flush();
			 }
			 catch(IOException e)
			 {
				 e.printStackTrace();
			 }
			 successWindow();
		 }
		 else
		 {
			 errorWindow();
		 }
	 }
	 
	 public void errorWindow()
	 {
		 Stage dialogStage = new Stage();
		 dialogStage.initModality(Modality.WINDOW_MODAL);

		 VBox vbox = new VBox(new Text("Favor de llenar los campos obligatorios"), new Button("Ok"));
		 vbox.setAlignment(Pos.CENTER);

		 dialogStage.setScene(new Scene(vbox));
		 dialogStage.show();
	 }
	 
	 public void successWindow()
	 {
		 Stage dialogStage = new Stage();
		 dialogStage.initModality(Modality.WINDOW_MODAL);

		 VBox vbox = new VBox(new Text("Trabajador creado correctamente!"), new Button("Ok"));
		 vbox.setAlignment(Pos.CENTER);

		 dialogStage.setScene(new Scene(vbox));
		 dialogStage.show();
	 }
}