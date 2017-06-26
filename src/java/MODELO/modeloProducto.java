/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import CLASES.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author cvalenciano
 */
public class modeloProducto extends conexion{
    
    public ArrayList<Producto> getAllProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            String sql = "CALL selectProductos";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                productos.add(new Producto(rs.getInt("id_producto"),rs.getString("nombre"),rs.getString("img_producto"),rs.getString("id_categoria"),rs.getDouble("precio"),rs.getInt("stock")));
                
            }
        } catch (Exception e) {
        } finally{
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }
        return productos;
    }
    
    public Producto getProducto(int id){
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            String sql = "SELECT  FROM productor WHERE id_producto=?";
            pst.setInt(1, id);
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                producto= new Producto(rs.getInt("id_producto"),rs.getString("nombre"),rs.getString("img_producto"),rs.getString("id_categoria"),rs.getDouble("precio"),rs.getInt("stock"));
            }
        } catch (Exception e) {
        } finally{
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }
        return producto;
    }
    
    public static void main (String[] args){
        modeloProducto mp = new modeloProducto();
        for (Producto p : mp.getAllProductos()) {
            System.out.println(p.getNombre());
        }
    }
    
}
