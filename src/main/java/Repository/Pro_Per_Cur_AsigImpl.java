package Repository;

import Model.Curso;
import Model.Pro_Per_Cur_Asig;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Julián <Julián at Google>
 */
public class Pro_Per_Cur_AsigImpl implements Repository<Pro_Per_Cur_Asig>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Pro_Per_Cur_Asig crearMultitabla(ResultSet campo) throws SQLException {
        Pro_Per_Cur_Asig m = new Pro_Per_Cur_Asig();
        m.setId_Pro_Per_Cur_Asig(campo.getInt("id"));
        m.setPrograma_id(campo.getInt("programa_id"));
        m.setPeriodo_id(campo.getInt("periodo_id"));
        m.setCurso_id(campo.getInt("curso_id"));
        m.setAsignatura_id(campo.getInt("asignatura_id"));
        return m;
    }
    
    @Override
    public List<Pro_Per_Cur_Asig> listar() {
        List<Pro_Per_Cur_Asig> listaMultitabla = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet fila = stmt.executeQuery("SELECT * FROM Pro_Per_Cur_Asig")) {
            while (fila.next()) {
                listaMultitabla.add(crearMultitabla(fila));
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

        return listaMultitabla;
    }

    @Override
    public Pro_Per_Cur_Asig porCodigo(int id) {
        Pro_Per_Cur_Asig m = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Periodo WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                m = crearMultitabla(fila);
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

        return m;
    }

    @Override
    public void guardar(Pro_Per_Cur_Asig entidad) {
        String sql = """
                     INSERT INTO Pro_Per_Cur_Asig(programa_id, periodo_id, curso_id, asignatura_id)
                     VALUES (?, ?, ?, ?)""";

        try (PreparedStatement fila = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            int[] campos = {entidad.getPrograma_id(), entidad.getPeriodo_id(), entidad.getCurso_id(), entidad.getAsignatura_id()};
            System.out.println("Programa Id: "+entidad.getPrograma_id());
            System.out.println("Periodo Id: "+entidad.getPeriodo_id());
            System.out.println("Curso Id: "+entidad.getCurso_id());
            System.out.println("Asignatura Id: "+entidad.getAsignatura_id());
            // Iterar sobre los campos
            for (int i = 0; i < campos.length; i++) {
                if (campos[i] == 0) {
                    fila.setNull(i + 1, Types.INTEGER); // Establecer el parámetro como nulo si el valor es cero
                } else {
                    fila.setInt(i + 1, campos[i]); // Establecer el parámetro como el valor correspondiente
                }
            }
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
            JOptionPane.showMessageDialog(null, "Algo salió mal Guardando el Pro_Per_Cur_Asig,"
                    + "\ncomuniquese con el desarrollador.");
            System.out.println("Guardando el Pro_Per_Cur_Asig está el error");
            System.out.println("Verifique el try linea 98 Pro_Per_Cur_AsigImpl.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 129.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement fila = getConnection().prepareStatement("DELETE FROM Pro_Per_Cur_Asig WHERE id=?")) {
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
    public void modificar(Pro_Per_Cur_Asig entidad) {
        String sql = """
                     UPDATE Curso
                     SET programa_id = ?,
                         periodo_id = ?,
                         curso_id = ?,
                         asignatura_id
                     WHERE id = ?;""" // Agregamos la actualización del campo direccion_id
        ;

        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setInt(1, entidad.getPrograma_id());
            fila.setInt(2, entidad.getPeriodo_id());
            fila.setInt(3, entidad.getCurso_id());
            fila.setInt(4, entidad.getAsignatura_id());
            fila.setInt(5, entidad.getId_Pro_Per_Cur_Asig());

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
