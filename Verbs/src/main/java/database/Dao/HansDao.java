package database.Dao;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import database.entity.hanslexicon;

@Dao
public interface HansDao {





    @Query("SELECT * FROM hansdictionary where rootword=:root")
    List<hanslexicon> getHansDefinition(String root);





}
