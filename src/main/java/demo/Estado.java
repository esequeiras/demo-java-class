package demo;

import java.util.Date;

public  class Estado {
    private Long id;
    private String estado,descripcion;
    private Date modificado;
    public  String proforma() {return "se envió proforma ";};
    public  String llamado() {return "Llamada de seguimiento";}
    public  String pago() {return "Realizo parte del pago";}
    public  String cancelar() {return "Realizó el pago completo";}

    public Estado() {
    }

    public Estado(Long id, String estado, String descripcion, Date modificado) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.modificado = modificado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
