package com.example.godcode_en.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.godcode_en.greendao.entity.TransationName;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TRANSATION_NAME".
*/
public class TransationNameDao extends AbstractDao<TransationName, Void> {

    public static final String TABLENAME = "TRANSATION_NAME";

    /**
     * Properties of entity TransationName.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property TransationName = new Property(0, String.class, "transationName", false, "TRANSATION_NAME");
        public final static Property TransationId = new Property(1, String.class, "transationId", false, "TRANSATION_ID");
    }


    public TransationNameDao(DaoConfig config) {
        super(config);
    }
    
    public TransationNameDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TRANSATION_NAME\" (" + //
                "\"TRANSATION_NAME\" TEXT," + // 0: transationName
                "\"TRANSATION_ID\" TEXT);"); // 1: transationId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TRANSATION_NAME\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TransationName entity) {
        stmt.clearBindings();
 
        String transationName = entity.getTransationName();
        if (transationName != null) {
            stmt.bindString(1, transationName);
        }
 
        String transationId = entity.getTransationId();
        if (transationId != null) {
            stmt.bindString(2, transationId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TransationName entity) {
        stmt.clearBindings();
 
        String transationName = entity.getTransationName();
        if (transationName != null) {
            stmt.bindString(1, transationName);
        }
 
        String transationId = entity.getTransationId();
        if (transationId != null) {
            stmt.bindString(2, transationId);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public TransationName readEntity(Cursor cursor, int offset) {
        TransationName entity = new TransationName( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // transationName
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // transationId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TransationName entity, int offset) {
        entity.setTransationName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTransationId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(TransationName entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(TransationName entity) {
        return null;
    }

    @Override
    public boolean hasKey(TransationName entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}