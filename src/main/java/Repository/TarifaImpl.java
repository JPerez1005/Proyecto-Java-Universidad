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
public class TarifaImpl implements Repository<Tarifa>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Tarifa crearTarifa(ResultSet campo) throws SQLException {
        Tarifa t = new Tarifa();
        t.setId(campo.getInt("id"));
        t.setCosto_credito(campo.getDouble("costo_credito"));
        t.setPeriodo_id(campo.getInt("periodo_id"));
        t.setPrograma_id(campo.getInt("programa_id"));
        return t;
    }
    
    @Override
    public List<Tarifa> listar() {
        List<Tarifa> listaTarifas = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet fila = stmt.executeQuery("SELECT * FROM tarifa ")) {
            while (fila.next()) {
                listaTarifas.add(crearTarifa(fila));
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

        return listaTarifas;
    }

    @Override
    public Tarifa porCodigo(int id) {
        Tarifa t = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Periodo WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                t = crearTarifa(fila);
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

        return t;
    }

    @Override
    public void guardar(Tarifa entidad) {
        String sql = """
                     INSERT INTO Tarifa(costo_credito, periodo_id, programa_id)
                     VALUES (?, ?, ?)""";

        try (PreparedStatement fila = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            fila.setDouble(1, entidad.getCosto_credito());
            fila.setInt(2, entidad.getPeriodo_id());
            fila.setInt(3, entidad.getPrograma_id());

            int affectedRows = fila.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar la persona, no se modificaron filas.");
            }

            try (ResultSet generatedKeys = fila.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entidad.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Fallo al programa la persona, no se obtuvo el ID generado.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal Guardando la asignatura,"
                    + "\ncomuniquese con el desarrollador.");
            System.out.println("Guardando el periodo está el error");
            System.out.println("Verifique el try linea 97 PeriodoImpl.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 125.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement fila = getConnection().prepareStatement("DELETE FROM Tarifa WHERE id=?")) {
            fila.setInt(1, id);
            fila.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando datos.");
            System.out.println("error try linea 139.");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion de eliminar datos");
                System.out.println("error try linea 148.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void modificar(Tarifa entidad) {
        String sql = """
                     UPDATE Asignatura
                     SET costo_credito = ?,
                         periodo_id = ?,
                         programa_id = ?
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setDouble(1, entidad.getCosto_credito());
            fila.setInt(2, entidad.getPeriodo_id());
            fila.setInt(3, entidad.getPrograma_id());
            fila.setInt(4, entidad.getId());

            int affectedRows = fila.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la persona, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, """
                                                Algo sali\u00f3 mal Modificando el programa ProgramaImpl,
                                                comuniquese con el desarrollador.""");
            System.out.println("Modificando el programa está el error");
            System.out.println("Verifique el try linea 171.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 193.");
                ex.printStackTrace();
            }
        }
    }
}
