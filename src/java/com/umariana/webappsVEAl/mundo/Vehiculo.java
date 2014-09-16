/**
 *
 * @author Pear Team
 */

package com.umariana.webappsVEAl.mundo;

/**
 * Clase que representa a un vehículo
 */
public class Vehiculo
{
    ///----------------------------------------------
    /// Constantes
    ///----------------------------------------------
    /**
     * Representa al estado alquilado del Vehículo
     */
    static final String  ALQUILADO = "Alquilado";

    /**
     * Representa al estado disponible del Vehículo
     */
    static final String  DISPONIBLE = "Disponible";

    ///----------------------------------------------
    /// Atributos
    ///----------------------------------------------
    /**
     * Costo o precio del vehículo
     */
    private double costo;

    /**
     * Imagen del vehículo
     */
    private String imagen;

    /**
     * Línea del vehículo
     */
    private Linea linea;

    /**
     * Marca vehículo
     */
    private Marca marca;

    /**
     * Modelo del vehículo
     */
    private String modelo;

    /**
     * Placa del vehículo
     */
    private String placa;

    ///----------------------------------------------
    /// Constructor
    ///----------------------------------------------
    /**
    * Constructor de la clase vehiculo
    * @param pCosto costo del vehiculo. costo > 0
    * @param pImagen imagen del vehiculo. imagen !=null
    * @param pLinea linea del vehiculo. linea !=null
    * @param pMarca marca del vehiculo. marca !=null
    * @param pModelo modelo del vehiculo. modelo !="" and modelo !=null
    * @param pPlaca placa del vehiculo. placa !="" and placa !=null
    */
    public Vehiculo(double pCosto, String pImagen, Linea pLinea, Marca pMarca, String pModelo, String pPlaca)
    {
        costo = pCosto;
        imagen = pImagen;
        linea = pLinea;
        marca = pMarca;
        modelo = pModelo;
        placa = pPlaca;
    }
    
    ///----------------------------------------------
    /// Metodos
    ///----------------------------------------------

    /**
    * Metodo que retorna el costo del vehiculo.
    * @return costo
    */
    public double getCosto()
    {
        return costo;
    }

    /**
    * Metodo que modifica el costo del vehiculo.
    * @param pCosto - Costo del vehiculo. pCosto > 0
    */
    public void  setCosto(double pCosto)
    {
        costo = pCosto;
    }

    /**
    * Metodo que retorna la imagen del vehiculo.
    * @return imagen
    */
    public String getImagen()
    {
        return imagen;
    }

    /**
    * Metodo que modifica la imagen del vehiculo.
    * @param pImagen imagen del vehiculo. pImagen != null
    */
    public void  setImagen(String pImagen)
    {
        imagen = pImagen;
    }

    /**
    * Metodo que retorna la linea del vehiculo.
    * @return linea
    */
    public Linea getLinea()
    {
        return linea;
    }

    /**
    * Metodo que modifica la linea del vehiculo.
    * @param pLinea - Linea del vehiculo. pLinea !=null
    */
    public void  setLinea(Linea pLinea)
    {
        linea = pLinea;
    }

    /**
    * Metodo que retorna la marca del vehiculo.
    * @return marca
    */
    public Marca getMarca()
    {
        return marca;
    }

    /**
    * Metodo que modifica la marca del vehiculo.
    * @param pMarca - Marca del vehiculo. pMarca !=null
    */
    public void  setMarca(Marca pMarca)
    {
        marca = pMarca;
    }

    /**
    * Metodo que retorna el modelo del vehiculo.
    * @return modelo
    */
    public String getModelo()
    {
        return modelo;
    }

    /**
    * Metodo que modifica el modelo del vehiculo.
    * @param pModelo - Modelo del vehiculo. pModelo !="" and pModelo !=null
    */
    public void  setModelo(String pModelo)
    {
        modelo = pModelo;
    }

    /**
    * metodo que retorna la placa del vehiculo.
    * @return placa
    */
    public String getPlaca()
    {
        return placa;
    }

    /**
    * metodo que modifica el modelo del vehiculo.
    * @param pPlaca - Placa del vehiculo. pPlaca != "" and pPlaca != null
    */
    public void  setPlaca(String pPlaca)
    {
        placa = pPlaca;
    }
}