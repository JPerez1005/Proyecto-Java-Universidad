package Repository;

import Model.Ciudad;
import Model.Direccion;
import Model.Persona;
import Model.PersonaCompleta;
import Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Julián <Julián at Google>
 */
public class Consultas {
    
    private static final Repository ciudadRepository= new CiudadImpl();
    private static final Repository direccionRepository= new DireccionImpl();
    private static final Repository personaRepository= new PersonaImpl();
    private static final Repository estudianteRepository= new EstudianteImpl();
    
    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Persona crearPersonaCompleta(ResultSet rs) throws SQLException {
        Persona personaCompleta = (Persona) personaRepository.porCodigo(rs.getInt("persona_id"));
        Direccion direccionCompleta=(Direccion) direccionRepository.porCodigo(rs.getInt("direccion_id"));
        Ciudad ciudadCompleta=(Ciudad) ciudadRepository.porCodigo(rs.getInt("ciudad_id"));
        personaCompleta.setDireccion(direccionCompleta);
        direccionCompleta.setCiudad(ciudadCompleta);
        
        return personaCompleta;
    }
    
    public List<Persona> listarPersonasCompletas(){
        List<Persona> listaPersonas=new ArrayList<>();
        
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT \n" +
                "    p.id AS persona_id,\n" +
                "    p.tipo_documento,\n" +
                "    p.numero_documento,\n" +
                "    p.nombre AS persona_nombre,\n" +
                "    p.apellido AS persona_apellido,\n" +
                "    p.telefono,\n" +
                "    p.fecha_nacimiento,\n" +
                "    p.genero,\n" +
                "    d.id AS direccion_id,\n" +
                "    d.tipo AS direccion_tipo,\n" +
                "    d.numero AS direccion_numero,\n" +
                "    c.id AS ciudad_id,\n" +
                "    c.nombre AS ciudad_nombre\n" +
                "FROM \n" +
                "    Persona p\n" +
                "INNER JOIN \n" +
                "    Direccion d ON p.direccion_id = d.id\n" +
                "INNER JOIN \n" +
                "    Ciudad c ON d.ciudad_id = c.id;")) {
            while (rs.next()) {
                listaPersonas.add(crearPersonaCompleta(rs));
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la consulta: verifique try linea 110.");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexion cverifique try linea 140");
                ex.printStackTrace();
            }
        }
        
        return listaPersonas;
    }
}
