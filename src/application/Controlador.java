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
		 JSONArray info = new JSONArray();
		 
		 if(Tid.getText() != null)
		 {
			 JSONObject id = new JSONObject();
			 id.put("id", Tid.getText());
			 info.add(id.toJSONString());
		 }
		 
		 if(Tname.getText() != null)
		 {
		 	JSONObject name = new JSONObject();
		 	name.put("name", Tname.getText());
		 	info.add(name.toJSONString());
		 }
		 
		 if(tip != 0)
		 {
			 JSONObject tipo = new JSONObject();
			 tipo.put("tipo", tip);
			 info.add(tipo.toJSONString());
		 }
		 
		 if(Tdep.getText() != null)
		 {
		 	JSONObject dep = new JSONObject();
		 	dep.put("dep", Tdep.getText());
		 	info.add(dep.toJSONString());
		 }
		 
		 if(Tsueldo.getText() != null)
		 {
			JSONObject sueldo = new JSONObject();
			sueldo.put("sueldo", Tdep.getText());
			info.add(sueldo.toJSONString());
		 }
		 //-----no obligatorios
		 
		 if(Tcurp.getText() != null)
		 {
			 JSONObject curp = new JSONObject();
			 curp.put("curp", Tdep.getText());
			 info.add(curp.toJSONString());
		 }
		 
		 if(Trfc.getText() != null)
		 {
			 JSONObject rfc = new JSONObject();
			 rfc.put("rfc", Tdep.getText());
			 info.add(rfc.toJSONString());
		 }
		 
		 if(Tcol.getText() != null)
		 {
			 JSONObject col = new JSONObject();
			 col.put("col", Tcol.getText());
			 info.add(col.toJSONString());
		 }
		 
		 if(Tcol.getText() != null)
		 {
			 JSONObject mun = new JSONObject();
			 mun.put("mun", Tdep.getText());
			 info.add(mun.toJSONString());
		 }
		 
		 if(Tcalle.getText() != null)
		 {
			 JSONObject calle = new JSONObject();
			 calle.put("calle", Tcalle.getText());
			 info.add(calle.toJSONString());
		 }
		 
		 if(TgEst.getText() != null)
		 {
			 JSONObject gEst = new JSONObject();
			 gEst.put("gEst", TgEst.getText());
			 info.add(info.toJSONString());
		 }
		 
		 if(Ttel.getText() != null)
		 {
			 JSONObject tel = new JSONObject();
			 tel.put("tel", Ttel.getText());
			 info.add(tel.toJSONString());
		 }
		 
		 if(TedoC.getText() != null)
		 {
			 JSONObject edoC = new JSONObject();
			 edoC.put("gEst", TgEst.getText());
			 info.add(info.toJSONString());
		 }
		 
		 if(Tsex.getText() != null)
		 {
			 JSONObject sex = new JSONObject();
			 sex.put("sex", Tsex.getText());
			 info.add(sex.toJSONString());
		 }
		 
		 if(Tine.getText() != null)
		 {
			 JSONObject ine = new JSONObject();
			 ine.put("ine", Tine.getText());
			 info.add(ine.toJSONString());
		 }
		 
		 if(Tcarr.getText() != null)
		 {
			 JSONObject carr = new JSONObject();
			 carr.put("carr", Tcarr.getText());
			 info.add(carr.toJSONString());
		 }
		 
		 if(Tinst.getText() != null)
		 {
			 JSONObject inst = new JSONObject();
			 inst.put("inst", Tinst.getText());
			 info.add(inst.toJSONString());
		 }	
		 
		 if(Tname.getText() != null && Tid.getText() != null && Tdep != null && Tcurp != null && Trfc != null && Tsueldo != null && tip != 0)
		 {
			 JSONObject workers = new JSONObject();
			 workers.put("trabajador", Tname.getText() + " " + Tid.getText());
			 workers.put("info", info);
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