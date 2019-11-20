package vista;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class MainController {
	
	@FXML
	private ComboBox<String> cbTipoProducto;
	@FXML
	private TextField tfCedula;
	@FXML
	private TextArea taObservacion;
	
	public void botonCrear(ActionEvent evento) {
		//Este metodo es el que se llama cuando se da clic
		String cedula = tfCedula.getText();
		String tipoProducto = cbTipoProducto.getSelectionModel().getSelectedItem();
		String observacion = taObservacion.getText();
		System.out.println("cedula: "+cedula+"\nTipo Producto: "+tipoProducto+"\nObservación: "+observacion);
		//Llamar a metodo de modelo
	}
	
	public void crearUsuarioPrueba() {
		String cedula = getRespuestaPopUp("Registrar Cliente de Prueba","Digite el número de la cédula"
				+ " asociada con el cliente que se registrara: ");
		System.out.println("Cedula: "+cedula);
		//Llamar a metodo de modelo, los demas campos se generan el modelo (ejemplo: nombre=Prueba#cedula,...)
	}
	
	private String getRespuestaPopUp(String title, String message) {
		String r = null;
		try {
			TextInputDialog dialog = new TextInputDialog("");
			dialog.setTitle(title);
			dialog.setHeaderText(null);
			dialog.setContentText(message);

			Optional<String> result = dialog.showAndWait();
			r = result.get();
		} catch(Exception e) {
			return null;
		}
		return r;
	}
	
	//Este metodo es util para mostrar mensajes de error
	private void mensajePopUp(String titulo, String mensaje, AlertType tipoAlerta) {
		Alert alert = new Alert(tipoAlerta);
		
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();
	}
	
}
