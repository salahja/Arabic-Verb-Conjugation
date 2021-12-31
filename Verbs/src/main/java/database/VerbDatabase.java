package database;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import database.Dao.BuckwaterDao;
import database.Dao.HansDao;
import database.Dao.LaneDao;
import database.Dao.QuranicVerbsDao;
import database.Dao.VerbsTriMazeedDictDao;
import database.Dao.kovDao;
import database.Dao.mazeedDao;
import database.Dao.mujarradDao;
import database.entity.BuckwaterEntitiy;
import database.entity.Mazeed;
import database.entity.MujarradVerbs;
import database.entity.QuranicVerbsEntity;
import database.entity.VerbsTriMazeedDictEntity;
import database.entity.hanslexicon;
import database.entity.kov;
import database.entity.lanelexicon;


//@Database(entities= {VerseEntit.class,ErabEntity.class,ChaptersAnaEntity.class},version= 1)
@Database(entities = {hanslexicon.class, lanelexicon.class,Mazeed.class,MujarradVerbs.class,kov.class, VerbsTriMazeedDictEntity.class,  BuckwaterEntitiy.class,   QuranicVerbsEntity.class}, version = 2)

public abstract class VerbDatabase extends RoomDatabase {

    public static VerbDatabase verbDatabaseInstance;
    private static Callback initialCallBack = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            //  new InitialAsyncTask(quranAppDatabaseInstance).execute();
        }
    };

    public static synchronized VerbDatabase getInstance(Context context) {
        if (null == verbDatabaseInstance) {


            verbDatabaseInstance = Room.databaseBuilder(context,  VerbDatabase.class, "v3-conjugator.db")
                    .createFromAsset("database/v3-conjugator.db")

         .fallbackToDestructiveMigration()
                    .addCallback(initialCallBack)
                    .allowMainThreadQueries()
                    .build();

        }

        return verbDatabaseInstance;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `mazeeddictionary` (`root` TEXT NOT NULL, `form` TEXT NOT NULL, `verbtype` TEXT NOT NULL, `id` INTEGER NOT NULL, `babname` TEXT NOT NULL, PRIMARY KEY(`id`))");

        }
    };

    public abstract BuckwaterDao BuckwaterDao();



    public abstract QuranicVerbsDao QuranicVerbsDao();




    public abstract VerbsTriMazeedDictDao VerbsTriMazeedDictDao();



  public abstract kovDao kovDao();
    public abstract mujarradDao mujarradDao();
    public abstract mazeedDao mazeedDao();
    public abstract HansDao HansDao();
    public abstract LaneDao LaneDao();

}
