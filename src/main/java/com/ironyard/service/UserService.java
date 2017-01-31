package com.ironyard.service;

import com.google.gson.Gson;
import com.ironyard.data.IronYardUser;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jasonskipper on 1/26/17.
 */
public class UserService {

    public ArrayList<IronYardUser> getAllUsers(){
        ArrayList<IronYardUser> found = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try (FileReader fr = new FileReader(classLoader.getResource("users.json").getFile())) {

            Gson tmpG = new Gson();
            IronYardUser[] t = tmpG.fromJson(fr, IronYardUser[].class);
            if(t != null && t.length>0){
                found = new ArrayList<IronYardUser>(Arrays.asList(t));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return found;
    }

    public IronYardUser getUser(String email, String pass) {
        IronYardUser foundUser = null;
        List<IronYardUser> all = getAllUsers();
        for(IronYardUser tmpUser:all) {
            if (tmpUser.getUsername().equals(email) && tmpUser.getPassword().equals(pass)){
                foundUser = tmpUser;
            }
        }
        return foundUser;
    }
}
