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

public class MatriculaImpl implements Repository<Matricula>{
    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Matricula crearMatricula(ResultSet campo) throws SQLException {
        Matricula m = new Matricula();
        m.setId(campo.getInt("id"));
        m.setAlumno_id(campo.getInt("alumno_id"));
        m.setPrograma_id(campo.getInt("programa_id"));
        return m;
    }

    @Override
    public List<Matricula> listar() {
        List<Matricula> listaMatriculas = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet fila = stmt.executeQuery("SELECT * FROM Matricula ")) {
            while (fila.next()) {
                listaMatriculas.add(crearMatricula(fila));
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

        return listaMatriculas;
    }

    @Override
    public Matricula porCodigo(int id) {
        Matricula m = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Matricula WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                m = crearMatricula(fila);
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

        return m;
    }

    @Override
    public void guardar(Matricula entidad) {
        String sql = """
                     INSERT INTO Matricula(alumno_id, programa_id)
                     VALUES (?, ?)""";

        try (PreparedStatement fila = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            System.out.println("Alumno ID: "+entidad.getAlumno_id());
            fila.setInt(1, entidad.getAlumno_id());
            fila.setInt(2, entidad.getPrograma_id());

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
            System.out.println("Verifique el try linea 93 MatriculaImpl.");
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
        try (PreparedStatement fila = getConnection().prepareStatement("DELETE FROM Matricula WHERE id=?")) {
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
    public void modificar(Matricula entidad) {
        String sql = """
                     UPDATE Matricula
                     SET alumno_id = ?,
                         programa_id = ?
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setInt(1, entidad.getAlumno_id());
            fila.setInt(2, entidad.getPrograma_id());
            fila.setInt(3, entidad.getId());

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
