package demo;

import java.sql.Date;
import java.time.LocalDate;

public class Persona extends Estado{

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Estado estadoPersona=new Estado();
    private Long id;
    private String nombre;
    private String apellido;
    private String estado;
    private String telefono;
    private LocalDate creado;

    public Persona(Long id, String nombre, String apellido, String estado, String telefono, LocalDate creado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.telefono = telefono;
        this.creado = creado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }

    public Persona(long id, String firstName, String lastName, String estado, String telefono, Date creado) {
    }
}
