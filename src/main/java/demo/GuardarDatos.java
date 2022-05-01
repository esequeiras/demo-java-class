package demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;

@Named
public class GuardarDatos implements JavaDelegate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String nombre = (String) delegateExecution.getVariable("nombre");
        String apellido = (String) delegateExecution.getVariable("apellido");
        String estado = (String) delegateExecution.getVariable("estado");
        String telefono = (String) delegateExecution.getVariable("telefono");
        System.out.println("Nombre: " + nombre + " " + apellido + " " + estado);

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CLIENTE (id SERIAL, firstName varchar(255)," +
                "lastName varchar(255), estado varchar(255),telefono varchar(255),creado date)");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS ESTADOS (id number, estado varchar(255),descripcion varchar(255)," +
                "modificado date)");


        jdbcTemplate.update("Insert into CLIENTE (firstName,lastName, estado,telefono ,creado) " +
                " values (?,?,?,?,?)",nombre,apellido, estado,telefono,LocalDate.now());
        // aqui tienen un select all
        List<Persona> personas  = jdbcTemplate.query("Select * from CLIENTE", (rs, rowNum) ->
                new Persona(
                  rs.getLong("id"),
                  rs.getString("firstName"),
                  rs.getString("lastName"),
                  rs.getString("estado"), rs.getString("telefono"),rs.getDate("creado")
                ));
        //modifico la primera persona

        for (Persona persona: personas) {
            if(persona.getId()==1){
                jdbcTemplate.update("Insert into ESTADOS (id, estado,descripcion ,modificado) " +
                        " values (?,?,?,?,?)",persona.getId(),persona.getEstado(),persona.estadoPersona.llamado(), LocalDate.now());
                jdbcTemplate.update("Insert into ESTADOS (id, estado,descripcion ,modificado) " +
                        " values (?,?,?,?,?)",persona.getId(),persona.getEstado(),persona.estadoPersona.proforma(), LocalDate.now());
                jdbcTemplate.update("Insert into ESTADOS (id, estado,descripcion ,modificado) " +
                        " values (?,?,?,?,?)",persona.getId(),persona.getEstado(),persona.estadoPersona.pago(), LocalDate.now());

            };
        }
        //selecciono los estados de la persona 1
        List<Estado> estados  = jdbcTemplate.query("Select * from ESTADOS where id=1", (rs, rowNum) ->
                new Estado(
                        rs.getLong("id"),
                        rs.getString("estado"),
                        rs.getString("descripcion"),
                        rs.getDate("creado")
                ));
        for (Estado est: estados) {
            if(est.getId()==1){
                System.out.println(est.getId()+","+est.getEstado()+" ,"+est.getDescripcion()+" ,"+est.getModificado());
            };
        }
    }
}
