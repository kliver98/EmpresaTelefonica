package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.Date;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class consultarYconectar {

	
	private Connection con;
	
	public void conectarBD(String username, String password) {

		System.out.println("-------- Prueba de Registro de Oracle JDBC ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("¡Oracle JDBC Driver no encontrado!");
			return;
		}
		System.out.println("¡Oracle JDBC Driver Registrado!");

		try {

			 //con = DriverManager.getConnection("jdbc:Oracle:thin:@//172.16.0.103:1522/ESTUD", username,
					//password);
				con = DriverManager.getConnection("jdbc:Oracle:thin:@//200.3.193.24:1522/ESTUD", username,
					password);
				System.out.println("Exito!");
		} catch (SQLException e) {
			System.out.println("Fallo al conectar! Ver consola de salida");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void verificarCliente(String cedula) {
		
		 try {
			CallableStatement cst = con.prepareCall("{call verificarCliente(?,?,?)}");
			
			cst.setString(1, cedula);
			cst.registerOutParameter(2, Types.NUMERIC);
			cst.registerOutParameter(3, Types.VARCHAR);
			cst.execute();
			
			int cod = 0;
			String msj = "";
			ResultSet rs = cst.getResultSet();
			
			cod =  rs.getInt(0);
			msj = rs.getString(1);
			
			if(cod == -20001) {
				System.out.println(msj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
				
	}
	
	public void crearTipoSolicitud(int CODIGO , String DESCRIPCION , String NOMBRE ) {
		
		try {
			CallableStatement cst = con.prepareCall("{call crearTipoSolicitud(?, ?, ?, ?, ?)}");
			
			cst.setInt(1, CODIGO);
			cst.setString(2, DESCRIPCION);
			cst.setString(3, NOMBRE);
			cst.registerOutParameter(4, Types.NUMERIC);
			cst.registerOutParameter(5, Types.VARCHAR);
			cst.execute();
			
			int cod = 0;
			String msj = "";
			ResultSet rs = cst.getResultSet();
			
			cod =  rs.getInt(0);
			msj = rs.getString(1);
			
			if(cod == -20001) {
				System.out.println(msj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
	}

	public void crearSolicitud(int CODIGO, Date FECHA_REGISTRO, Date FECHA_ATENCION, Date FECHA_ASIGNACION, String OBSERVACION, int TIPO_SOLICITUD_CODIGO, int CLIENTE_CEDULA, int FUNCIONARIO_CEDULA, int PRODUCTO_CODIGO) {
		
		try {
			CallableStatement cst = con.prepareCall("{call crearSolicitud(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			
			cst.setInt(1, CODIGO);
			cst.setDate(2, FECHA_REGISTRO);
			cst.setDate(3, FECHA_ATENCION);
			cst.setDate(4, FECHA_ASIGNACION);
			cst.setString(5, OBSERVACION);
			cst.setInt(6, TIPO_SOLICITUD_CODIGO);
			cst.setInt(7, CLIENTE_CEDULA);
			cst.setInt(8, FUNCIONARIO_CEDULA);
			cst.setInt(9, PRODUCTO_CODIGO);
			cst.registerOutParameter(10, Types.NUMERIC);
			cst.registerOutParameter(11, Types.VARCHAR);
			cst.execute();
			
			int cod = 0;
			String msj = "";
			ResultSet rs = cst.getResultSet();
			
			cod =  rs.getInt(0);
			msj = rs.getString(1);
			
			if(cod == -20001) {
				System.out.println(msj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

	public void registrarCliente(int CEDULA, String NOMBRE, String DIRECCION, int TELEFONO, Date FECHA_NACIMIENTO) {
		
		try {
			CallableStatement cst = con.prepareCall("{call registrarCliente(?, ?, ?, ?, ?, ?, ?)}");
			
			cst.setInt(1, CEDULA);
			cst.setString(2, NOMBRE);
			cst.setString(3, DIRECCION);
			cst.setInt(4, TELEFONO);
			cst.setDate(5, FECHA_NACIMIENTO);
			cst.registerOutParameter(6, Types.NUMERIC);
			cst.registerOutParameter(7, Types.VARCHAR);
			cst.execute();
			
			int cod = 0;
			String msj = "";
			ResultSet rs = cst.getResultSet();
			
			cod =  rs.getInt(0);
			msj = rs.getString(1);
			
			if(cod == -20001) {
				System.out.println(msj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

	public void registrarFuncionario(int CEDULA, String NOMBRE, String DIRECCION, int TELEFONO, Date FECHA_NACIMIENTO) {
		
		try {
			CallableStatement cst = con.prepareCall("{call registrarFuncionario(?, ?, ?, ?, ?, ?, ?)}");
			
			cst.setInt(1, CEDULA);
			cst.setString(2, NOMBRE);
			cst.setString(3, DIRECCION);
			cst.setInt(4, TELEFONO);
			cst.setDate(5, FECHA_NACIMIENTO);
			cst.registerOutParameter(6, Types.NUMERIC);
			cst.registerOutParameter(7, Types.VARCHAR);
			cst.execute();
			
			int cod = 0;
			String msj = "";
			ResultSet rs = cst.getResultSet();
			
			cod =  rs.getInt(0);
			msj = rs.getString(1);
			
			if(cod == -20001) {
				System.out.println(msj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

	public void registrarProducto(int CODIGO, String DESCRIPCION, int TIPO_PRODUCTO_CODIGO) {
		
		try {
			CallableStatement cst = con.prepareCall("{call registrarProducto(?, ?, ?, ?, ?)}");
			
			cst.setInt(1, CODIGO);
			cst.setString(2, DESCRIPCION);
			cst.setInt(3, TIPO_PRODUCTO_CODIGO);
			cst.registerOutParameter(4, Types.NUMERIC);
			cst.registerOutParameter(5, Types.VARCHAR);
			cst.execute();
			
			int cod = 0;
			String msj = "";
			ResultSet rs = cst.getResultSet();
			
			cod =  rs.getInt(0);
			msj = rs.getString(1);
			
			if(cod == -20001) {
				System.out.println(msj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}
	public void registrarTipoDeProducto(int CODIGO, String DESCRIPCION, String NOMBRE) {
		
		try {
			CallableStatement cst = con.prepareCall("{call registrarProducto(?, ?, ?, ?, ?)}");
			
			cst.setInt(1, CODIGO);
			cst.setString(2, DESCRIPCION);
			cst.setString(3, NOMBRE);
			cst.registerOutParameter(4, Types.NUMERIC);
			cst.registerOutParameter(5, Types.VARCHAR);
			cst.execute();
			
			int cod = 0;
			String msj = "";
			ResultSet rs = cst.getResultSet();
			
			cod =  rs.getInt(0);
			msj = rs.getString(1);
			
			if(cod == -20001) {
				System.out.println(msj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

//    procedure crearTipoSolicitud(CODIGO NUMBER, DESCRIPCION VARCHAR2, NOMBRE VARCHAR2, COD_ERROR OUT NUMBER, MSJ_ERROR OUT VARCHAR2);
//    procedure crearSolicitud(CODIGO NUMBER, FECHA_REGISTRO DATE, FECHA_ATENCION DATE, FECHA_ASIGNACION DATE, OBSERVACION VARCHAR2, TIPO_SOLICITUD_CODIGO NUMBER, CLIENTE_CEDULA NUMBER,  FUNCIONARIO_CEDULA NUMBER, PRODUCTO_CODIGO NUMBER, COD_ERROR OUT NUMBER, MSJ_ERROR OUT VARCHAR2);
//    procedure registrarCliente(CEDULA NUMBER, NOMBRE VARCHAR2, DIRECCION VARCHAR2, TELEFONO NUMBER,  FECHA_NACIMIENTO DATE, COD_ERROR OUT NUMBER, MSJ_ERROR OUT VARCHAR2);
//    procedure registrarFuncionario(CEDULA NUMBER, NOMBRE VARCHAR2,  DIRECCION VARCHAR2, TELEFONO NUMBER,  FECHA_NACIMIENTO DATE, COD_ERROR OUT NUMBER, MSJ_ERROR OUT VARCHAR2);
//    procedure registrarProducto(CODIGO NUMBER, DESCRIPCION VARCHAR2, TIPO_PRODUCTO_CODIGO NUMBER, COD_ERROR OUT NUMBER, MSJ_ERROR OUT VARCHAR2);
//    procedure registrarTipoDeProducto(CODIGO NUMBER, DESCRIPCION VARCHAR2, NOMBRE VARCHAR2, COD_ERROR OUT NUMBER, MSJ_ERROR OUT VARCHAR2);

}
