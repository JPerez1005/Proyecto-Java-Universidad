package Repository;

/**
 * @author Julián <Julián at Google>
 */

import Model.*;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EstudianteImpl implements Repository<Estudiante>{

    private static final Repository ciudadRepository= new CiudadImpl();
    private static final Repository direccionRepository= new DireccionImpl();
    private static final Repository personaRepository= new PersonaImpl();
    
    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Estudiante crearEstudiante(ResultSet rs) throws SQLException {
        Estudiante e=new Estudiante();
        
        e.setEstudiante_id(rs.getInt("id"));
        e.setPersona_id(rs.getInt("persona_id"));
        return e;
    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> listaEstudiantes = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Alumno")) {
            while (rs.next()) {
                listaEstudiantes.add(crearEstudiante(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return listaEstudiantes;
    }
    
    

    public Estudiante porCodigoEstudiante(int id){
        Estudiante es = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM alumno WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                es = crearEstudiante(fila);
            }
        } catch (SQLException e) {
            System.out.println("fallo al buscar por codigo.");
            System.out.println("Verifique el try linea 49 DepartamentoImpl.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return es;
    }
    
    @Override
    public Estudiante porCodigo(int id) {
        Estudiante es = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Alumno WHERE persona_id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                es = crearEstudiante(fila);
            }
        } catch (SQLException e) {
            System.out.println("fallo al buscar por codigo.");
            System.out.println("Verifique el try linea 49 DepartamentoImpl.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return es;
    }

    @Override
    public void guardar(Estudiante entidad) {
        String sql = "INSERT INTO Alumno(persona_id) VALUES (?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, entidad.getId());
            System.out.println(entidad.getId()+" id del estudiante");
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar el estudiante, no se modificaron filas.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entidad.setEstudiante_id(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al guardar el estudiante, no se generó el ID.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al guardar el estudiante.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id_persona) {
        String sql = "DELETE FROM Alumno WHERE persona_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id_persona);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al eliminar el estudiante, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al eliminar el estudiante.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void modificar(Estudiante entidad) {
    }
}
