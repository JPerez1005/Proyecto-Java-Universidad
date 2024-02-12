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

public class ProgramaImpl implements Repository<Programa>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Programa crearPrograma(ResultSet campo) throws SQLException {
        Programa p = new Programa();
        p.setPrograma_id(campo.getInt("id"));
        p.setNombre(campo.getString("nombre"));
        p.setNivel(campo.getString("nivel"));
        p.setCantidad_semestres((byte) campo.getInt("cantidad_semestres"));
        return p;
    }
    
    @Override
    public List<Programa> listar() {
        List<Programa> listaProgramas = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet fila = stmt.executeQuery("SELECT * FROM programa ")) {
            while (fila.next()) {
                listaProgramas.add(crearPrograma(fila));
            }

        } catch (SQLException e) {
            System.out.println("Error enlistando");
            System.out.println("Revise try linea 34");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion");
                System.out.println("try linea 46");
                ex.printStackTrace();
            }
        }

        return listaProgramas;
    }

    @Override
    public Programa porCodigo(int id) {
        Programa p = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Programa WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                p = crearPrograma(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error en la busqueda por codigo");
            System.out.println("verifique try de la linea 63");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion de busqueda por codigo");
                System.out.println("verifique try linea 76");
                ex.printStackTrace();
            }
        }

        return p;
    }

    @Override
    public void guardar(Programa entidad) {
        String sql = """
                     INSERT INTO Programa(nombre, nivel, cantidad_semestres)
                     VALUES (?, ?, ?)""";

        try (PreparedStatement fila = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            fila.setString(1, entidad.getNombre());
            fila.setString(2, entidad.getNivel());
            fila.setInt(3, entidad.getCantidad_semestres());

            int affectedRows = fila.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar la persona, no se modificaron filas.");
            }

            try (ResultSet generatedKeys = fila.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entidad.setPrograma_id(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al programa la persona, no se obtuvo el ID generado.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal Guardando el programa,"
                    + "\ncomuniquese con el desarrollador.");
            System.out.println("Guardando el programa está el error");
            System.out.println("Verifique el try linea 94.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 124.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement fila = getConnection().prepareStatement("DELETE FROM Programa WHERE id=?")) {
            fila.setInt(1, id);
            fila.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando datos.");
            System.out.println("error try linea 132.");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion de eliminar datos");
                System.out.println("error try linea 141.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void modificar(Programa entidad) {
        String sql = """
                     UPDATE Programa
                     SET nombre = ?,
                         nivel = ?,
                         cantidad_semestres = ?
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setString(1, entidad.getNombre());
            fila.setString(2, entidad.getNivel());
            fila.setInt(3, entidad.getCantidad_semestres());
            fila.setInt(4, entidad.getPrograma_id());
            System.out.println(entidad.getPrograma_id());

            int affectedRows = fila.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la persona, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, """
                                                Algo sali\u00f3 mal Modificando el programa ProgramaImpl,
                                                comuniquese con el desarrollador.""");
            System.out.println("Modificando el programa está el error");
            System.out.println("Verifique el try linea 162.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 180.");
                ex.printStackTrace();
            }
        }
    }
    
}
