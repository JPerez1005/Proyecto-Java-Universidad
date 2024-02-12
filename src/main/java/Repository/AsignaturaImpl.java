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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;
public class AsignaturaImpl implements Repository<Asignatura>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance().conectar();
    }
    
    private Asignatura crearAsignatura(ResultSet campo) throws SQLException {
        Asignatura a = new Asignatura();
        a.setAsignatura_id(campo.getInt("id"));
        a.setNombre_combinado(campo.getString("nombre_combinado"));
        a.setCreditos(campo.getInt("creditos"));
        a.setDia_semana(campo.getString("dia_semana"));

        // Convertir hora_inicio de Timestamp a LocalTime
        Timestamp horaInicioTimestamp = campo.getTimestamp("hora_inicio");
        LocalDateTime horaInicioLocalDateTime = horaInicioTimestamp.toLocalDateTime();
        LocalTime horaInicio = horaInicioLocalDateTime.toLocalTime();
        a.setHora_inicio(horaInicio);

        // Convertir hora_fin de Timestamp a LocalTime
        Timestamp horaFinTimestamp = campo.getTimestamp("hora_fin");
        LocalDateTime horaFinLocalDateTime = horaFinTimestamp.toLocalDateTime();
        LocalTime horaFin = horaFinLocalDateTime.toLocalTime();
        a.setHora_fin(horaFin);

        a.setCupos_disponibles(campo.getByte("cupos_disponibles"));
        a.setProfesor_id(campo.getInt("profesor_id"));
        a.setSalon_id(campo.getInt("salon_id"));
        return a;
    }
    
    @Override
    public List<Asignatura> listar() {
        List<Asignatura> listaAsignaturas = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet fila = stmt.executeQuery("SELECT * FROM asignatura ")) {
            while (fila.next()) {
                listaAsignaturas.add(crearAsignatura(fila));
            }

        } catch (SQLException e) {
            System.out.println("Error enlistando asignaturas asignaturaImpl");
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

        return listaAsignaturas;
    }

    @Override
    public Asignatura porCodigo(int id) {
        Asignatura a = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Asignatura WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet fila = stmt.executeQuery();

            if (fila.next()) {
                a = crearAsignatura(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error en la busqueda por codigo la asignaturaImpl");
            System.out.println("verifique try de la linea 65");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexion de busqueda por codigo");
                System.out.println("verifique try linea 78");
                ex.printStackTrace();
            }
        }

        return a;
    }

    @Override
    public void guardar(Asignatura entidad) {
        String sql = """
             INSERT INTO Asignatura(
                nombre_combinado,
                creditos,
                cupos_disponibles,
                dia_semana,
                hora_inicio,
                hora_fin,
                profesor_id,
                salon_id)
             VALUES (?, ?, ?, ?, ?, ?, ?, ?)""";

        try (PreparedStatement fila = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            fila.setString(1, entidad.getNombre_combinado());
            fila.setInt(2, entidad.getCreditos());
            fila.setInt(3, entidad.getCupos_disponibles());
            fila.setString(4, entidad.getDia_semana());
            fila.setObject(5, Timestamp.valueOf(entidad.getHora_inicio().atDate(LocalDate.now()))); 
            fila.setObject(6, Timestamp.valueOf(entidad.getHora_fin().atDate(LocalDate.now())));
            fila.setInt(7, entidad.getProfesor_id());
            fila.setInt(8, entidad.getSalon_id());

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
            JOptionPane.showMessageDialog(null, "Algo salió mal Guardando la asignatura, AsignaturaImpl"
                    + "\ncomuniquese con el desarrollador.");
            System.out.println("Guardando la Asignatura está el error");
            System.out.println("Verifique el try linea 104 AsignaturaImpl.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                Conexion.getInstance().cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error cerrando base de datos metodo guardar.");
                System.out.println("verifique try linea 134.");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement fila = getConnection().prepareStatement("DELETE FROM Asignatura WHERE id=?")) {
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
    public void modificar(Asignatura entidad) {
        String sql = """
             UPDATE Asignatura
             SET nombre_combinado = ?,
                 creditos = ?,
                 cupos_disponibles = ?,
                 dia_semana = ?,
                 hora_inicio = ?,
                 hora_fin = ?,
                 profesor_id = ?,
                 salon_id = ?
             WHERE id = ?;""";


        try (PreparedStatement fila = getConnection().prepareStatement(sql)) {
            fila.setString(1, entidad.getNombre_combinado());
            fila.setInt(2, entidad.getCreditos());
            fila.setInt(3, entidad.getCupos_disponibles());
            fila.setString(4, entidad.getDia_semana());
            fila.setObject(5, Timestamp.valueOf(entidad.getHora_inicio().atDate(LocalDate.now()))); 
            fila.setObject(6, Timestamp.valueOf(entidad.getHora_fin().atDate(LocalDate.now())));
            fila.setInt(7, entidad.getProfesor_id());
            fila.setInt(8, entidad.getSalon_id());
            fila.setInt(9, entidad.getAsignatura_id());

            int affectedRows = fila.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Fallo al modificar la persona, no se encontró el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, """
                                                Algo salió mal Modificando el programa AsignaturaImpl,
                                                comuniquese con el desarrollador.""");
            System.out.println("Modificando el programa está el error");
            System.out.println("Verifique el try linea 169.");
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