package Repository;

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

/**
 * @author Julián <Julián at Google>
 */
public class HorarioImpl implements Repository<Horario>{
    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Horario crearHorario(ResultSet campo) throws SQLException {
        Horario h = new Horario();
        
        h.setId(campo.getInt("id"));
        h.setAsignatura_id(campo.getInt("asignatura_id"));
        h.setMatricula_id(campo.getInt("matricula_id"));
        
        return h;
    }

    @Override
    public List<Horario> listar() {
        List<Horario> listaHorarios = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM horario ")) {
            while (rs.next()) {
                listaHorarios.add(crearHorario(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta de la base de datos:HorarioImpl: try linea 36");
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexión de la base de datos: PersonaImpl: try linea 46");
            }
        }

        return listaHorarios;
    }

    @Override
    public Horario porCodigo(int id) {
        Horario h = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM persona WHERE ID=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    h = crearHorario(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexión de la base de datos: PersonaImpl: try linea 62");
            }
        }
        
        return h;
    }

    @Override
    public void guardar(Horario entidad) {
        String sql = """
                     INSERT INTO Horario(matricula_id, asignatura_id)
                     VALUES (?, ?)""";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, entidad.getMatricula_id());
            stmt.setInt(2, entidad.getAsignatura_id());
            System.out.println("Asignatura id: "+entidad.getAsignatura_id());
            System.out.println("Matricula id: "+entidad.getMatricula_id());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar el Horario, no se modificaron filas.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entidad.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al guardar el Horario, no se obtuvo el ID generado.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos\nError con el horario.");
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
    public void eliminar(int id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM Horario WHERE id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void modificar(Horario entidad) {
        String sql = """
                     UPDATE Horario
                     SET asignatura_id = ?,
                         matricula_id = ?
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, entidad.getAsignatura_id());
            stmt.setInt(2, entidad.getMatricula_id());
            stmt.setInt(3, entidad.getId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la persona, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos al modificar la persona.");
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
}
