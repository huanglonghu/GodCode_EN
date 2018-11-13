package com.example.godcode.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.godcode.greendao.entity.Bank;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BANK".
*/
public class BankDao extends AbstractDao<Bank, Integer> {

    public static final String TABLENAME = "BANK";

    /**
     * Properties of entity Bank.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", true, "ID");
        public final static Property BankNumber = new Property(1, String.class, "bankNumber", false, "BANK_NUMBER");
        public final static Property BankName = new Property(2, String.class, "bankName", false, "BANK_NAME");
        public final static Property BankType = new Property(3, int.class, "bankType", false, "BANK_TYPE");
        public final static Property UserId = new Property(4, int.class, "userId", false, "USER_ID");
    }


    public BankDao(DaoConfig config) {
        super(config);
    }
    
    public BankDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BANK\" (" + //
                "\"ID\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"BANK_NUMBER\" TEXT," + // 1: bankNumber
                "\"BANK_NAME\" TEXT," + // 2: bankName
                "\"BANK_TYPE\" INTEGER NOT NULL ," + // 3: bankType
                "\"USER_ID\" INTEGER NOT NULL );"); // 4: userId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BANK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Bank entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String bankNumber = entity.getBankNumber();
        if (bankNumber != null) {
            stmt.bindString(2, bankNumber);
        }
 
        String bankName = entity.getBankName();
        if (bankName != null) {
            stmt.bindString(3, bankName);
        }
        stmt.bindLong(4, entity.getBankType());
        stmt.bindLong(5, entity.getUserId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Bank entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String bankNumber = entity.getBankNumber();
        if (bankNumber != null) {
            stmt.bindString(2, bankNumber);
        }
 
        String bankName = entity.getBankName();
        if (bankName != null) {
            stmt.bindString(3, bankName);
        }
        stmt.bindLong(4, entity.getBankType());
        stmt.bindLong(5, entity.getUserId());
    }

    @Override
    public Integer readKey(Cursor cursor, int offset) {
        return cursor.getInt(offset + 0);
    }    

    @Override
    public Bank readEntity(Cursor cursor, int offset) {
        Bank entity = new Bank( //
            cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // bankNumber
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // bankName
            cursor.getInt(offset + 3), // bankType
            cursor.getInt(offset + 4) // userId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Bank entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setBankNumber(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBankName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBankType(cursor.getInt(offset + 3));
        entity.setUserId(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Integer updateKeyAfterInsert(Bank entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public Integer getKey(Bank entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Bank entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
