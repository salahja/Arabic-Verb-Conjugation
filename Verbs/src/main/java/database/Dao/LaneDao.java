package database.Dao;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import database.entity.lanelexicon;

@Dao
public interface LaneDao {


    @Query("SELECT * FROM laneslexicon where rootword=:root")
    List<lanelexicon> getLanesDefinition(String root);





}