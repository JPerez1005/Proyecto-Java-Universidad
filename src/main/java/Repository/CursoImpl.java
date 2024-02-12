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

public class CursoImpl implements Repository<Curso> {

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Curso crearCurso(ResultSet campo) throws SQLException {
        Curso c = new Curso();
        c.setCurso_id(campo.getInt("id"));
        c.setCurso_nombre(campo.getString("nombre"));
        c.setGuia_catedra(campo.getString("guia_catedra"));
        c.setDepartamento_id(campo.getInt("departamento_id"));
        return c;
    }
    
    @Override
    public List<Curso> listar() {
        List<Curso> listaCursos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet fila = stmt.executeQuery("SELECT * FROM curso")) {
            while (fila.next()) {
                listaCursos.add(crearCurso(fila));
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

        return listaCursos;
    }

    @Override
    public Curso porCodigo(int id) {
        Curso c = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Periodo WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                c = crearCurso(fila);
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

        return c;
    }

    @Override
    public void guardar(Curso entidad) {
        String sql = """
                     INSERT INTO Curso(nombre, guia_catedra, departamento_id)
                     VALUES (?, ?, ?)""";

        try (PreparedStatement fila = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            fila.setString(1, entidad.getCurso_nombre());
            fila.setString(2, entidad.getGuia_catedra());
            fila.setInt(3, entidad.getDepartamento_id());

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
            JOptionPane.showMessageDialog(null, "Algo salió mal Guardando el curso,"
                    + "\ncomuniquese con el desarrollador.");
            System.out.println("Guardando el periodo está el error");
            System.out.println("Verifique el try linea 95 PeriodoImpl.");
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
        try (PreparedStatement fila = getConnection().prepareStatement("DELETE FROM Curso WHERE id=?")) {
            fila.setInt(1, id);
            fila.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando datos.");
            System.out.println("error try linea 134.");
            e.printStackTrace();
        }finally {
        // Cerrar la conexión al finalizar
        try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion de eliminar datos");
                System.out.println("error try linea 143.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void modificar(Curso entidad) {
        String sql = """
                     UPDATE Curso
                     SET nombre = ?,
                         guia_catedra = ?,
                         departamento_id = ?
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setString(1, entidad.getNombre());
            fila.setString(2, entidad.getGuia_catedra());
            fila.setInt(3, entidad.getDepartamento_id());
            fila.setInt(4, entidad.getCurso_id());

            int affectedRows = fila.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la persona, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, """
                                                Algo sali\u00f3 mal Modificando el programa cursoImpl,
                                                comuniquese con el desarrollador.""");
            System.out.println("Modificando el programa está el error");
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
