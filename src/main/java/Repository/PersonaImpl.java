package Repository;

import Model.Direccion;
import Model.Persona;
import Util.Conexion;
import java.sql.*;
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

public class PersonaImpl implements Repository<Persona>{

    private static final Repository direccionRepository= new DireccionImpl();
    
    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Persona crearPersona(ResultSet rs) throws SQLException {
        Persona persona = new Persona();
        persona.setId(rs.getInt("id"));
        persona.setTipo_documento(rs.getString("tipo_documento"));
        persona.setNumero_documento(rs.getInt("numero_documento"));
        persona.setNombre(rs.getString("nombre"));
        persona.setApellido(rs.getString("apellido"));
        persona.setTelefono(rs.getString("telefono"));
        persona.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
        persona.setGenero(rs.getString("genero"));
        
        // Obtener la dirección asociada a la persona
        int direccionId = rs.getInt("direccion_id");
        Direccion direccion = (Direccion) direccionRepository.porCodigo(direccionId); // Suponiendo que tengas un repositorio de direcciones
        persona.setDireccion(direccion);
        
        return persona;
    }
    
    @Override
    public List<Persona> listar() {
        List<Persona> listaPersonas = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM persona ")) {
            while (rs.next()) {
                listaPersonas.add(crearPersona(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta de la base de datos: PersonaImpl: try linea 50");
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexión de la base de datos: PersonaImpl: try linea 62");
            }
        }

        return listaPersonas;
    }

    @Override
    public Persona porCodigo(int id) {
        Persona persona = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM persona WHERE ID=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    persona = crearPersona(rs);
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
        
        return persona;
    }

    @Override
    public void guardar(Persona entidad) {
        String sql = "INSERT INTO Persona(tipo_documento, numero_documento, nombre, apellido, telefono, fecha_nacimiento, genero, direccion_id)\n" +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, entidad.getTipo_documento());
            stmt.setInt(2, entidad.getNumero_documento());
            stmt.setString(3, entidad.getNombre());
            stmt.setString(4, entidad.getApellido());
            stmt.setString(5, entidad.getTelefono());
            stmt.setDate(6, java.sql.Date.valueOf(entidad.getFecha_nacimiento()));
            stmt.setString(7, String.valueOf(entidad.getGenero()));
            stmt.setInt(8, entidad.getDireccion().getDirecion_id());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar la persona, no se modificaron filas.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entidad.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al guardar la persona, no se obtuvo el ID generado.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal en la base de datos");
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
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM Persona WHERE id=?")) {
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
    public void modificar(Persona entidad) {
        String sql = """
                     UPDATE Persona
                     SET tipo_documento = ?,
                         numero_documento = ?,
                         nombre = ?,
                         apellido = ?,
                         telefono = ?,
                         fecha_nacimiento = ?,
                         genero = ?,
                         direccion_id = ?
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, entidad.getTipo_documento());
            stmt.setInt(2, entidad.getNumero_documento());
            stmt.setString(3, entidad.getNombre());
            stmt.setString(4, entidad.getApellido());
            stmt.setString(5, entidad.getTelefono());
            stmt.setDate(6, java.sql.Date.valueOf(entidad.getFecha_nacimiento()));
            stmt.setString(7, entidad.getGenero());
            stmt.setInt(8, entidad.getDireccion().getDirecion_id()); // Asignamos el ID de la dirección
            stmt.setInt(9, entidad.getId());

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
