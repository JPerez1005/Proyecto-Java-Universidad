package Repository;

import Model.Departamento;
import Model.Estudiante;
import Model.Profesor;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfesorImpl implements Repository<Profesor> {

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }

    @Override
    public List<Profesor> listar() {
        List<Profesor> listaProfesores = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Profesor")) {
            while (rs.next()) {
                listaProfesores.add(crearProfesor(rs));
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

        return listaProfesores;
    }

    public Profesor porCodigoProfesor(int id){
        Profesor es = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM profesor WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                es = crearProfesor(fila);
            }
        } catch (SQLException e) {
            System.out.println("fallo al buscar por codigo.");
            System.out.println("Verifique el try linea 49 ProfesorImpl.");
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
    public Profesor porCodigo(int id) {
        Profesor p = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Profesor WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                p = crearProfesor(fila);
            }
        } catch (SQLException e) {
            System.out.println("fallo al buscar por codigo.");
            System.out.println("Verifique el try linea 75 ProfesorImpl.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return p;
    }

    @Override
    public void guardar(Profesor entidad) {
        String sql = "INSERT INTO Profesor(persona_id, departamento_id) VALUES (?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, entidad.getPersona_id());
            stmt.setInt(2, entidad.getDepartamento_id());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar el profesor, no se modificaron filas.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entidad.setProfesor_id(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al guardar el profesor, no se generó el ID.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al guardar el profesor.");
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
    public void eliminar(int profesorId) {
        String sql = "DELETE FROM Profesor WHERE persona_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, profesorId);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al eliminar el profesor, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al eliminar el profesor.");
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
    public void modificar(Profesor entidad) {
        // Implementar el método modificar para Profesor
    }

    private Profesor crearProfesor(ResultSet rs) throws SQLException {
        Profesor profesor = new Profesor();
        profesor.setProfesor_id(rs.getInt("id"));
        profesor.setDepartamento_id(rs.getInt("departamento_id"));
        profesor.setPersona_id(rs.getInt("persona_id"));
        // Otros atributos de Profesor si los hay
        return profesor;
    }
}
