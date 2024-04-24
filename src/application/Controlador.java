package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controlador 
{
	Stage primaryStage;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//----------------------------------Cambiar vistas----------------------------------------------------
	
	public void showWorkers(ActionEvent event)
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
}