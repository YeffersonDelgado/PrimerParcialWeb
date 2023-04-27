import java.sql.SQLException;

import primerParcialWeb.dao.PacienteDao;
import primerParcialWeb.modelo.Paciente;

public class main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Paciente p = new Paciente(123456, "carlos", "cabezas", "sdsdf@homtial.com", "M", "22-10-2001", "123456", "av20 sim", 66, 190);
		
		PacienteDao c = new PacienteDao();
		
		p.IMC();
		
	//	c.insert(p);
		
		
	//	System.out.println(p  +  "sirve");
		
		c.delete(2);
		System.out.println("elimino");

	}

}
