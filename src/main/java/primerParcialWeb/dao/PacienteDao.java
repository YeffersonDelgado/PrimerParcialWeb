package primerParcialWeb.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import primerParcialWeb.modelo.Paciente;
import primerParcialWeb.util.ConexionPostgreSQL;



public class PacienteDao {

	
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario(nombre, email, pais) VALUES(?, ?, ?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id=?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre = ?, email = ?, pais = ? WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_USUARIO = "SELECT * FROM usuario;";
	
	
	
	

	public PacienteDao() {
		
		this.conexion = ConexionPostgreSQL.getConexion();
	}

	public void insert(Paciente paciente) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setInt(1, paciente.getDocumento());
			preparedStatement.setString(2, paciente.getNombre());
			preparedStatement.setString(3, paciente.getApellido());
			preparedStatement.setString(4, paciente.getEmail());
			preparedStatement.setString(5, paciente.getGenero());
			preparedStatement.setString(6, paciente.getFechaNacimiento());
			preparedStatement.setString(7, paciente.getTelefono());
			preparedStatement.setString(8, paciente.getDireccion());
			preparedStatement.setInt(9, paciente.getPeso());
			preparedStatement.setInt(10, paciente.getEstatura());


			conexion.execute();
			

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);
			conexion.execute();

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(Paciente paciente) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setInt(1, paciente.getDocumento());
			preparedStatement.setString(2, paciente.getNombre());
			preparedStatement.setString(3, paciente.getApellido());
			preparedStatement.setString(4, paciente.getEmail());
			preparedStatement.setString(5, paciente.getGenero());
			preparedStatement.setString(6, paciente.getFechaNacimiento());
			preparedStatement.setString(7, paciente.getTelefono());
			preparedStatement.setString(8, paciente.getDireccion());
			preparedStatement.setInt(9, paciente.getPeso());
			preparedStatement.setInt(10, paciente.getEstatura());
			preparedStatement.setInt(11, paciente.getId());
			
			conexion.execute();

		} catch(SQLException e) {
			
		}
	}
	
	
	public List<Paciente> selectAll(){
		
		List<Paciente> pacientes = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_USUARIO);
            ResultSet rs = conexion.query();
            
            while(rs.next()) {
            	int id = rs.getInt("id");
            	int documento = rs.getInt("documento");
            	String nombre = rs.getString("nombre");
            	String apellido = rs.getString("apellido");
            	String email = rs.getString("email");
            	String genero = rs.getString("genero");
            	String fechaNacimiento = rs.getString("fechaNacimiento");
            	String telefono = rs.getString("telefono");
            	String direccion = rs.getString("direccion");
            	int peso = rs.getInt("peso");
            	int estatura = rs.getInt("estatura");
            	
            
            	
            	pacientes.add(new Paciente(id, documento, nombre, apellido, email, 
            			genero, fechaNacimiento, telefono, direccion, peso, estatura));
            	
            }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return pacientes;
		
	}
	
	
	public Paciente select(int id){
		
	    Paciente paciente = null;
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
            preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
            
            while(rs.next()) {
            	
              	
            	int documento = rs.getInt("documento");
            	String nombre = rs.getString("nombre");
            	String apellido = rs.getString("apellido");
            	String email = rs.getString("email");
            	String genero = rs.getString("genero");
            	String fechaNacimiento = rs.getString("fechaNacimiento");
            	String telefono = rs.getString("telefono");
            	String direccion = rs.getString("direccion");
            	int peso = rs.getInt("peso");
            	int estatura = rs.getInt("estatura");
            	
            	paciente = new Paciente(id, documento, nombre, apellido, email, 
            			genero, fechaNacimiento, telefono, direccion, peso, estatura);
				
            	
            	
            }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return paciente;
		
	}
	
	
	
	
	
}

