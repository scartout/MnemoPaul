package pl.scartout.mnemopaul.dao;

import java.io.Serializable;
 
public interface GenericDAO <T, PK extends Serializable> {

    T create(T object);
    T read(PK id);
    boolean update(T object);
    boolean delete(PK id);
    
}