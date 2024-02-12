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

public class SalonImpl implements Repository<Salon>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Salon crearSalon(ResultSet campo) throws SQLException {
        Salon s = new Salon();
        s.setSalon_id(campo.getInt("id"));
        s.setCapacidad_alumnos(campo.getByte("capacidad_alumnos"));
        s.setPiso(campo.getByte("piso"));
        s.setNumero_especifico(campo.getString("numero_especifico"));
        s.setNombre_edificio(campo.getString("edificio_nombre"));
        return s;
    }
    
    @Override
    public List<Salon> listar() {
        List<Salon> listaSalones = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet fila = stmt.executeQuery("SELECT * FROM salon ")) {
            while (fila.next()) {
                listaSalones.add(crearSalon(fila));
            }

        } catch (SQLException e) {
            System.out.println("Error enlistando");
            System.out.println("Revise try linea 37");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion");
                System.out.println("try linea 49");
                ex.printStackTrace();
            }
        }

        return listaSalones;
    }

    @Override
    public Salon porCodigo(int id) {
        Salon s = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Salon WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                s = crearSalon(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error en la busqueda por codigo");
            System.out.println("verifique try de la linea 65");
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

        return s;
    }

    @Override
    public void guardar(Salon entidad) {
        String sql = """
                     INSERT INTO Salon(capacidad_alumnos, piso, numero_especifico, edificio_nombre)
                     VALUES (?, ?, ?, ?)""";

        try (PreparedStatement fila = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            fila.setInt(1, entidad.getCapacidad_alumnos());
            fila.setInt(2, entidad.getPiso());
            fila.setString(3, entidad.getNumero_especifico());
            fila.setString(4, entidad.getNombre_edificio());

            int affectedRows = fila.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar la persona, no se modificaron filas.");
            }

            try (ResultSet generatedKeys = fila.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entidad.setSalon_id(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al programa la persona, no se obtuvo el ID generado.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal Guardando el salón,"
                    + "\ncomuniquese con el desarrollador.");
            System.out.println("Guardando el salón está el error");
            System.out.println("Verifique el try linea 96 SalónImpl.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 123.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement fila = getConnection().prepareStatement("DELETE FROM Salon WHERE id=?")) {
            fila.setInt(1, id);
            fila.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando datos.");
            System.out.println("error try linea 135.");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion de eliminar datos");
                System.out.println("error try linea 144.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void modificar(Salon entidad) {
        String sql = """
                     UPDATE Asignatura
                     SET capacidad_alumnos = ?,
                         piso = ?,
                         numero_especifico = ?,
                         edificio_nombre = ?
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setInt(1, entidad.getCapacidad_alumnos());
            fila.setInt(2, entidad.getPiso());
            fila.setString(3, entidad.getNumero_especifico());
            fila.setString(4, entidad.getNombre_edificio());
            fila.setInt(5, entidad.getSalon_id());

            int affectedRows = fila.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la persona, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, """
                                                Algo salió mal Modificando el salón SalonImpl,
                                                comuniquese con el desarrollador.""");
            System.out.println("Modificando el salón está el error");
            System.out.println("Verifique el try linea 165.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 185.");
                ex.printStackTrace();
            }
        }
    }
}
