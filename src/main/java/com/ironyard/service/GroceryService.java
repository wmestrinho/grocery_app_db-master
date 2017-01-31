package com.ironyard.service;


import com.ironyard.data.GroceryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 1/26/17.
 */
public class GroceryService {
    /**
     * Get Pet that matches the given id
     * @param id
     * @return
     */
    public GroceryItem getGroceryById(long id){
        GroceryItem found = null;
        Connection con = null;
        DbService dbService = new DbService();
        try {
            con = dbService.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM helloworld.grocery where id= "+id);
            while (rs.next()) {
                found = getGroceryItem(rs);
            }
        }catch(Throwable t){
            t.printStackTrace();
        } finally {
            if(con !=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return found;
    }

    public GroceryItem save(GroceryItem aGroceryToSave){
        Connection con = null;
        try {
            DbService dbService = new DbService();
            con = dbService.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO helloworld.grocery" +
                            "(name, isle, price, category)  " +
                            "VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            // set values
            ps.setString(1,aGroceryToSave.getName());
            ps.setInt(2,aGroceryToSave.getIsle());
            ps.setDouble(3,aGroceryToSave.getPrice());
            ps.setString(4,aGroceryToSave.getCat());
            ps.execute();

            // populate id that was generated from DB
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                aGroceryToSave.setId(rs.getLong("id"));
            }
            //
            rs.close();
            ps.close();
        }catch(Throwable t){
            t.printStackTrace();
        }finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return aGroceryToSave;
    }

    /**
     * Get Pet By the name given from database
     * @return
     */
    public GroceryItem getGroceryItemByName(String aItemName){
        GroceryItem found = null;
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM helloworld.grocery where name= ?");
            ps.setString(1,aItemName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                found = getGroceryItem(rs);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return found;
    }

    public List<GroceryItem> getAllGroceryFromDatabase(){
        List<GroceryItem> foundPets = new ArrayList<GroceryItem>();
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM helloworld.grocery");

            while (rs.next()) {
                foundPets.add(getGroceryItem(rs));
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return foundPets;
    }

    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    private GroceryItem getGroceryItem(ResultSet rs) throws SQLException {
        int isle = rs.getInt("isle");
        double price = rs.getDouble("price");
        String name = rs.getString("name");
        String cat = rs.getString("category");
        long id = rs.getLong("id");
        return new GroceryItem(name, price, cat, isle, id);
    }
}