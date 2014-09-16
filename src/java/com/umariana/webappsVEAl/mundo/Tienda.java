/**
 *
 * @author Pear Team
 */

package com.umariana.webappsVEAl.mundo;

import java.util.*;

/**
 * Clase principal de la aplciación - webappsVEAl
 */
public class Tienda 
{
    /// ---------------------------------------
    /// Atributos
    /// ---------------------------------------
    /**
     * Lista de las lineas de marcas registradas en el sistema
     */
    private ArrayList<Linea> lineas;
    
    /**
     * Lista de las marcas vehiculares registradas en el sistema
     */
    private ArrayList<Marca> marcas;
    
    /**
     * Lista de los vehiculos registrados en el sistema
     */
    private ArrayList<Vehiculo> vehiculos;
    
    /// ---------------------------------------
    /// Constructor
    /// ---------------------------------------
    /**
     * Constructor de la clase principal.
     */
    public Tienda()
    {
        lineas = new ArrayList<Linea>();
        marcas = new ArrayList<Marca>();
        vehiculos = new ArrayList<Vehiculo>();
    }
    
    /// ---------------------------------------
    /// Metodos
    /// ---------------------------------------
    /**
     * Método que adiciona una nueva línea de marca vehicular al sistema
     * @param pMarca - Marca de la línea. pMarca != null
     * @param pNombre - Nombre de la línea. pNombre != null
     * @throws Exception - La línea ya existe
     */
    public void adicionarLinea(String pMarca, String pNombre) throws Exception
    {
        Marca marca = buscarMarca(pMarca);
        if (marca != null)
        {
            marca.adicionarLinea(pNombre);
        }
        else
            throw new Exception("La marca: " + pMarca + " no se encuentra registrada.");
    }
    
    /**
     * Método que adiciona una nueva marca vehicular al sistema
     * @param pNombre - Nombre de la marca. pNombre != null
     * @param pPais - País del origen de la marca. pPais != null
     * @throws Exception - La marca ya existe
     */
    public void adicionarMarca(String pNombre, String pPais) throws Exception
    {
        Marca marca = buscarMarca(pNombre);
        if (marca == null)
        {
            marca = new Marca(pNombre, pPais);
            marcas.add(marca);
        }
        else
            throw new Exception("La Marca con nombre: " + pNombre + " ya existe.");
    }
    
    /**
     * Método que adiciona un nuevo vehículo al sistema
     * @param pCosto - Costo, valor o precio del vehículo en el mercado. pCosto != null && pCosto > 0.
     * @param pImagen - Imagen del vehículo. pImagen != null.
     * @param pLinea - Linea de la marca vehicular. pLinea != null.
     * @param pMarca - Marca vehicular. pMarca != null.
     * @param pModelo - Modelo o año en que el vehículo fue fabricado. pModelo != null.
     * @param pPlaca - Placa del vehículo. pPlaca != null.
     * @throws Exception - El vehículo ya existe
     */
    public void adicionarVehiculo(double pCosto, String pImagen, String pLinea, String pMarca, String pModelo, String pPlaca) throws Exception
    {
        Marca marca = buscarMarca(pMarca);
        if (marca != null)
        {
            marca.adicionarVehiculo(pCosto, pImagen, pLinea, marca, pModelo, pPlaca);
        }
        else
            throw new Exception("La marca: " + pMarca + " no se encuetra registrada.");
    }
    
    /**
     * Método que retorna una linea dado su nombre como parametro.
     * @param pMarca - Nombre de la marca a la que pertenece la línea. pMarca != null.
     * @param pNombre - Nombre de la línea. pNombre != null.
     * @return linea
     * @throws Exception - Si la marca no existe
     */
    public Linea buscarLinea(String pMarca, String pNombre) throws Exception
    {
        Linea linea = null;
        Marca marca = buscarMarca(pMarca);
        {
            if (marca != null)
            {
                linea = marca.buscarLinea(pNombre);
            }
            else
                throw new Exception("La marca: " + pMarca + " no se encuentra registrada.");
        }
        return linea;
    }
    
    /**
     * Método que retorna una linea dado su nombre como parametro.
     * @param pNombre - Nombre de la marca. pNombre != null.
     * @return marca
     */
    public Marca buscarMarca(String pNombre)
    {
        Marca marca = null;
        boolean encontrado = false;
        for (int i=0; i<marcas.size() && !encontrado; i++)
        {
            if (marcas.get(i).getNombreMarca().equals(pNombre))
            {
                marca = marcas.get(i);
                encontrado = true;
            }
        }
        return marca;
    }
    
    /**
     * Método que retorna un vehículo dada su placa como parametro
     * @param pLinea - Linea del Vehículo. pLinea != null.
     * @param pMarca - Marca vehicular. pMarca != null.
     * @param pPlaca - Placa del vehículo a buscar. pPlaca != null.
     * @return vehiculo
     * @throws Exception - Si la linea no existe || Si la marca no existe 
     */
    public Vehiculo buscarVehiculo(String pLinea, String pMarca, String pPlaca) throws Exception
    {
        Vehiculo vehiculo = null;
        Marca marca = buscarMarca(pMarca);
        if (marca != null)
        {
            vehiculo = marca.buscarVehiculo(pLinea, pPlaca);
        }
        else
            throw new Exception("La marca: " + pMarca + " no se encuetra registrada.");
        return vehiculo;
    }
    
    /**
     * Método que elimina una línea de marca vehicular del sistema según su nombre.
     * @param pMarca - Marca a la que la línea pertenece. pMarca != null.
     * @param pNombre - Nombre de la línea. pNombre != null.
     * @throws Exception - La marca no existe || La línea no existe.
     */
    public void eliminarLinea(String pMarca, String pNombre) throws Exception
    {
        Marca marca = buscarMarca(pMarca);
        if (marca != null)
        {
            marca.eliminarLinea(pNombre);
        }
        else
            throw new Exception("La marca: " + pMarca + " no se encuetra registrada.");
    }
    
    /**
     * Método que elimina una marca vehicular del sistema según su nombre.
     * @param pNombre - Nombre de la marca. pNombre != null.
     * @throws Exception - La marca no existe.
     */
    public void eliminarMarca(String pNombre) throws Exception
    {
        Marca marca = buscarMarca(pNombre);
        if (marca != null)
        {
            marcas.remove(marca);
        }
        else
            throw new Exception("La marca: " + pNombre + " no se encuetra registrada.");
    }
    
    /**
     * Método que elimina un vehículo del sistema según su placa.
     * @param pLinea - Linea del vehículo. pLinea != null.
     * @param pMarca - Marca vehicular. pMarca != null.
     * @param pPlaca - Placa del vehículo. pPlaca != null.     
     * @throws Exception - El vehículo no existe.
     */
    public void eliminarVehiculo(String pLinea, String pMarca, String pPlaca) throws Exception
    {
        Marca marca = buscarMarca(pPlaca);
        if (marca != null)
        {
            marca.eliminarVehiculo(pLinea, pPlaca);
        }
        else
            throw new Exception("La marca: " + pMarca + " no se encuetra registrada.");
    }
    
    /**
     * Método que módifica los datos de una línea. 
     * Para su modificación es necesario conocer la marca a la que pertenece la línea, la línea que se desea modificar y los nuevos valores de la línea.
     * @param pLinea - Nombre de la linea que se desea modificar. pLinea != null.
     * @param pMarca - Nombre de la marca a la que pertenece la línea. pMarca != null.
     * @param pNombre - Nombre modificado de la línea.
     * @throws Exception - La marca no existe || La línea no exise
     */
    public void modificarLinea(String pLinea, String pMarca, String pNombre) throws Exception
    {
        Marca marca = buscarMarca(pMarca);
        if (marca != null)
        {
            marca.modificarLinea(pLinea, pNombre);;
        }
        else
            throw new Exception("La marca: " + pMarca + " no se encuetra registrada.");
    }
    
    /**
     * Método que modifica los datos de una marca.
     * Para su modificación es ncesario conocer la marca a la que se desea modificar y los nuevos valores de la marca.
     * @param pMarca - Nombre de la marca que se desa modificar. pMarca != null.
     * @param pNombre - Nombre modificado de la marca. pNombre != null.
     * @param pPaisOrigen - País modificado de la marca. pPais != null.
     * @throws Exception - La marca no existe || El nuevo nombre de la marca ya se encuentra reistrado
     */
    public void modificarMarca(String pMarca, String pNombre, String pPaisOrigen) throws Exception
    {
        Marca marca = buscarMarca(pMarca);
        if (marca != null)
        {
            marca.setNombreMarca(pNombre);
            marca.setPaisOrigen(pPaisOrigen);
        }
        else
            throw new Exception("La marca: " + pMarca + " no se encuetra registrada.");
    }
    
    /**
     * Método que modifica los datos de un vehículo.     
     * @param pCosto - Costo modificado del vehículo. pCosto != null.
     * @param pImagen - Imagen modificada del vehículo. pImagen != null.
     * @param pLinea - Linea modificada del vehículo. pLinea != null.
     * @param pMarca - Marca modificada del vehículo. pMarca != null.
     * @param pModelo - Modelo modificado del vehículo. pModelo != null.
     * @param pPlaca - Placa modificada del vehículo. pPlaca != null.
     * @param pVehiculo - Vehículo que se desea modificar. actualPlaca != null.
     * @throws Exception - El vehículo no existe || La nueva placa del vehículo ya se encuentra registrada
     */
    public void modificarVehiculo(double pCosto, String pImagen, String pLinea, String pMarca, String pModelo, String pPlaca, String pVehiculo) throws Exception
    {
        Marca marca = buscarMarca(pMarca);
        if (marca != null)
        {
            marca.modificarVehiculo(pCosto, pImagen, pLinea, marca, pModelo, pPlaca, pVehiculo);
        }
        else
            throw new Exception("La marca: " + pMarca + " no se encuetra registrada.");
    }
    
    /**
     * Método que retorna la lista de las lineas registradas en el sistema
     * @return lineas
     */
    public ArrayList<Linea> darListaLineas()
    {
        return lineas;
    }
    
    /**
     * Método que retorna la lista de las marcas registradas en el sistema
     * @return marcas
     */
    public ArrayList<Marca> darListaMarcas()
    {
        return marcas;
    }
    
    /**
     * Método que retorna la lista de vehiculos registrados en el sistema
     * @return vehiculos
     */
    public ArrayList<Vehiculo> darListaVehiculos()
    {
        return vehiculos;
    }
}