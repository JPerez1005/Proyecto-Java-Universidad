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

public class DepartamentoImpl implements Repository<Departamento>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Departamento crearDepartamento(ResultSet campo) throws SQLException {
        Departamento d = new Departamento();
        d.setDepartamento_id(campo.getInt("id"));
        d.setDepartamento_nombre(campo.getString("nombre"));
        return d;
    }
    
    @Override
    public List<Departamento> listar() {
        List<Departamento> listaDepartamentos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet fila = stmt.executeQuery("SELECT * FROM departamento ")) {
            while (fila.next()) {
                listaDepartamentos.add(crearDepartamento(fila));
            }

        } catch (SQLException e) {
            System.out.println("Fallo al enlistar departamentos");
            System.out.println("Verificar linea 32 DepartamentoImpl");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return listaDepartamentos;
    }

    @Override
    public Departamento porCodigo(int id) {
        Departamento d = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Departamento WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                d = crearDepartamento(fila);
            }
        } catch (SQLException e) {
            System.out.println("fallo al buscar por codigo.");
            System.out.println("Verifique el try linea 59 DepartamentoImpl.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return d;
    }

    @Override
    public void guardar(Departamento entidad) {
        String sql = "INSERT INTO Departamento(id, nombre) VALUES (?, ?)";

        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setInt(1, entidad.getDepartamento_id());
            fila.setString(2, entidad.getDepartamento_nombre());

            int affectedRows = fila.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al guardar el departamento, no se modificaron filas.");
            }
        } catch (SQLException e) {
            System.out.println("Fallo el guardar del DepartamentoImpl");
            System.out.println("Verifique linea try 87 en guardar");
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
        try (PreparedStatement fila = getConnection().prepareStatement("DELETE FROM Departamento WHERE id=?")) {
            fila.setInt(1, id);
            fila.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando datos.");
            System.out.println("error try linea 110.");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion de eliminar datos");
                System.out.println("error try linea 120.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void modificar(Departamento entidad) {
        String sql = """
                     UPDATE Departamento
                     SET nombre = ?
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setString(1, entidad.getDepartamento_nombre());
            fila.setInt(2, entidad.getDepartamento_id());

            int affectedRows = fila.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la persona, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, """
                                                Algo sali\u00f3 mal Modificando el programa ProgramaImpl,
                                                comuniquese con el desarrollador.""");
            System.out.println("Modificando el programa está el error");
            System.out.println("Verifique el try linea 138.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 155.");
                ex.printStackTrace();
            }
        }
    }
}
