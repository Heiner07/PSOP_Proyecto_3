/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_3;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Heiner
 */
public class Archivo {
    
    int id;
    int tamanio;
    String nombre;
    String ubicacion;
    String permisos;
    Date fechaCreacion;
    Date ultimaModificacion;
    Usuario propietario;
    GrupoUsuarios grupoUsuarios;
    Bloque bloqueInicial;
    Boolean esCarpeta;
    Boolean estaAbierto;
    List<Archivo> contenido;

    /**
     * 
     * @param id
     * @param tamanio
     * @param nombre
     * @param ubicacion
     * @param permisos
     * @param fechaCreacion
     * @param ultimaModificacion
     * @param propietario
     * @param grupoUsuarios 
     * @param bloque 
     * @param estaAbierto 
     * @param contenido 
     */
    public Archivo(int id, int tamanio, String nombre, String ubicacion,
            String permisos, Date fechaCreacion, Date ultimaModificacion,
            Usuario propietario, GrupoUsuarios grupoUsuarios, Bloque bloque,
            Boolean estaAbierto, List<Archivo> contenido) {
        this.id = id;
        this.tamanio = tamanio;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.permisos = permisos;
        this.fechaCreacion = fechaCreacion;
        this.ultimaModificacion = ultimaModificacion;
        this.propietario = propietario;
        this.grupoUsuarios = grupoUsuarios;
        this.bloqueInicial = bloque;
        this.estaAbierto = estaAbierto;
        this.contenido = contenido;
    }
}