package database.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import database.entity.kov;


@Dao
public interface kovDao {


        @Query(value = "SELECT * FROM kov order by id ")
        List<kov> getRules();



}
