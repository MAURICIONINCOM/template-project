package com.delapaz.test.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "delapaz", catalog = "")
public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente that = (Cliente) o;
        return id == that.id &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, telefono);
    }
}
