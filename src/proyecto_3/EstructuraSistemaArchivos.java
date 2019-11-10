/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_3;

/**
 *
 * @author Heiner
 */
public class EstructuraSistemaArchivos {
    public static final String INICIO_BLOQUE            = "[B]";
    public static final String FINAL_BLOQUE             = "[/B]";
    public static final String INICIO_BLOQUE_SIGUIENTE  = "[BS]";
    public static final String FINAL_BLOQUE_SIGUIENTE   = "[/BS]";
    public static final String INICIO_INFORMACION       = "[I]";
    public static final String FINAL_INFORMACION        = "[/I]";
    public static final String INICIO_ID                = "[Id]";
    public static final String FINAL_ID                 = "[/Id]";
    public static final String INICIO_TAMANIO           = "[1]";
    public static final String FINAL_TAMANIO            = "[/1]";
    public static final String INICIO_NUMERO_BLOQUES    = "[2]";
    public static final String FINAL_NUMERO_BLOQUES     = "[/2]";
    public static final String INICIO_BLOQUES_LIBRES    = "[3]";
    public static final String FINAL_BLOQUES_LIBRES     = "[/3]";
    public static final String INICIO_BLOQUE_USUARIOS   = "[4]";
    public static final String FINAL_BLOQUE_USUARIOS    = "[/4]";
    public static final String INICIO_BLOQUE_G_USUARIOS = "[5]";
    public static final String FINAL_BLOQUE_G_USUARIOS  = "[/5]";
    public static final String INICIO_USUARIO           = "[U]";
    public static final String FINAL_USUARIO            = "[/U]";
    public static final String INICIO_G_USUARIO         = "[GU]";
    public static final String FINAL_G_USUARIO          = "[/GU]";
    public static final String INICIO_NOMBRE            = "[N]";
    public static final String FINAL_NOMBRE             = "[/N]";
    public static final String INICIO_CONTRASENIA       = "[Con]";
    public static final String FINAL_CONTRASENIA        = "[/Con]";
    public static final String INICIO_CARPETA           = "[C]";
    public static final String FINAL_CARPETA            = "[/C]";
    public static final String INICIO_ARCHIVO           = "[A]";
    public static final String FINAL_ARCHIVO            = "[/A]";
    public static final String CARACTER_RELLENO         = ".";
    
    /**
     * Genera el contenido base del sistema de archivos.
     * @param tamanioDisco
     * @param cantidadBloques
     * @param tamanioBloque
     * @param cBloquesLibres
     * @param contrasenia
     * @return String
     */
    public static String obtenerContenidoInicial(int tamanioDisco,
            int cantidadBloques, int tamanioBloque, String cBloquesLibres,
            String contrasenia){
        String bloquesDisco
                = INICIO_BLOQUE                                             +"\n"
                // Se define el bloque siguiente
                + INICIO_BLOQUE_SIGUIENTE+"\n-1\n"+FINAL_BLOQUE_SIGUIENTE   +"\n"
                // Se define el inicio de la información
                + INICIO_INFORMACION                                        +"\n"
                // Se define el Id del bloque
                + INICIO_ID+"\n0\n"+FINAL_ID                                +"\n"
                // Se define el tamaño del disco (info del sistema de archivos)
                + INICIO_TAMANIO+"\n"+tamanioDisco+"\n"+FINAL_TAMANIO       +"\n"
                // Se define la cantidad de bloques y tamaño de cada bloque
                + INICIO_NUMERO_BLOQUES+"\n"+cantidadBloques                +"\n"
                + tamanioBloque+"\n"+FINAL_NUMERO_BLOQUES                   +"\n"
                // Se definen los bloques libres
                + INICIO_BLOQUES_LIBRES+"\n"+cBloquesLibres                 +"\n"
                + FINAL_BLOQUES_LIBRES                                      +"\n"
                // Se define el bloque de usuarios
                + INICIO_BLOQUE_USUARIOS                                    +"\n"
                // Se define el usuario root
                + INICIO_USUARIO                                            +"\n"
                + INICIO_ID+"\n0\n"+FINAL_ID                                +"\n"
                + INICIO_NOMBRE+"\nroot\n"+FINAL_NOMBRE                     +"\n"
                + INICIO_CONTRASENIA+"\n"+contrasenia+"\n"+FINAL_CONTRASENIA+"\n"
                + FINAL_USUARIO                                             +"\n"
                // Se cierra el bloque de usuarios
                + FINAL_BLOQUE_USUARIOS                                     +"\n"
                // Se define el bloque de grupos de usuarios
                + INICIO_BLOQUE_G_USUARIOS                                  +"\n"
                // Se define el grupo root
                + INICIO_G_USUARIO                                          +"\n"
                // Se define el usuario (root) que pertenece a este grupo
                + INICIO_ID+"\n0\n"+FINAL_ID                                +"\n"
                + INICIO_NOMBRE+"\nGrupoRoot\n"+FINAL_NOMBRE                +"\n"
                + INICIO_USUARIO                                            +"\n"
                + INICIO_ID+"\n0\n"+FINAL_ID                                +"\n"
                + FINAL_USUARIO                                             +"\n"
                + FINAL_G_USUARIO                                           +"\n"
                // Se cierra el bloque de usuarios
                + FINAL_BLOQUE_G_USUARIOS                                   +"\n"
                // Se cierra el bloque de información
                + FINAL_INFORMACION                                         +"\n"
                // Se cierra el bloque
                + FINAL_BLOQUE                                              +"\n";
        // Se crean el resto de bloques (libres)
        for(int i = 1; i < cantidadBloques; i++){
            bloquesDisco
                    += INICIO_BLOQUE                    + "\n"
                    + INICIO_BLOQUE_SIGUIENTE+"\n-1\n"+FINAL_BLOQUE_SIGUIENTE+"\n"
                    + INICIO_INFORMACION                + "\n"
                    + INICIO_ID+"\n"+i+"\n"+FINAL_ID    + "\n"
                    + FINAL_INFORMACION                 + "\n"
                    + FINAL_BLOQUE                      + "\n";
        }
        return bloquesDisco;
    }
    
    /**
     * Genera el string, del usuario nuevo, utilizado para agregar un usuario...
     * ...al archivo (Disco)
     * @param usuario
     * @return String
     */
    public static String generarContenidoUsuario(Usuario usuario){
        String cUsuario
                = INICIO_USUARIO        + "\n"
                // Se define el Id
                + INICIO_ID             + "\n"
                + usuario.id            + "\n"
                + FINAL_ID              + "\n"
                // Se define en Nombre
                + INICIO_NOMBRE         + "\n"
                + usuario.nombre        + "\n"
                + FINAL_NOMBRE          + "\n"
                // Se define la contraseña
                + INICIO_CONTRASENIA    + "\n"
                + usuario.contrasenia   + "\n"
                + FINAL_CONTRASENIA     + "\n"
                // Se cierra el Usuario
                + FINAL_USUARIO;
        return cUsuario;
    }
}
