package com.example.godcode_en.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.godcode_en.greendao.entity.Notification;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NOTIFICATION".
*/
public class NotificationDao extends AbstractDao<Notification, Long> {

    public static final String TABLENAME = "NOTIFICATION";

    /**
     * Properties of entity Notification.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Content = new Property(1, String.class, "content", false, "CONTENT");
        public final static Property Date = new Property(2, String.class, "date", false, "DATE");
        public final static Property UserId = new Property(3, int.class, "userId", false, "USER_ID");
        public final static Property TransactionType = new Property(4, int.class, "transactionType", false, "TRANSACTION_TYPE");
        public final static Property RelatedKey = new Property(5, int.class, "relatedKey", false, "RELATED_KEY");
        public final static Property TransactionId = new Property(6, int.class, "transactionId", false, "TRANSACTION_ID");
        public final static Property Type = new Property(7, int.class, "type", false, "TYPE");
        public final static Property Title = new Property(8, String.class, "title", false, "TITLE");
    }


    public NotificationDao(DaoConfig config) {
        super(config);
    }
    
    public NotificationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NOTIFICATION\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CONTENT\" TEXT," + // 1: content
                "\"DATE\" TEXT," + // 2: date
                "\"USER_ID\" INTEGER NOT NULL ," + // 3: userId
                "\"TRANSACTION_TYPE\" INTEGER NOT NULL ," + // 4: transactionType
                "\"RELATED_KEY\" INTEGER NOT NULL ," + // 5: relatedKey
                "\"TRANSACTION_ID\" INTEGER NOT NULL ," + // 6: transactionId
                "\"TYPE\" INTEGER NOT NULL ," + // 7: type
                "\"TITLE\" TEXT);"); // 8: title
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NOTIFICATION\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Notification entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(2, content);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(3, date);
        }
        stmt.bindLong(4, entity.getUserId());
        stmt.bindLong(5, entity.getTransactionType());
        stmt.bindLong(6, entity.getRelatedKey());
        stmt.bindLong(7, entity.getTransactionId());
        stmt.bindLong(8, entity.getType());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(9, title);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Notification entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(2, content);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(3, date);
        }
        stmt.bindLong(4, entity.getUserId());
        stmt.bindLong(5, entity.getTransactionType());
        stmt.bindLong(6, entity.getRelatedKey());
        stmt.bindLong(7, entity.getTransactionId());
        stmt.bindLong(8, entity.getType());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(9, title);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Notification readEntity(Cursor cursor, int offset) {
        Notification entity = new Notification( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // content
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // date
            cursor.getInt(offset + 3), // userId
            cursor.getInt(offset + 4), // transactionType
            cursor.getInt(offset + 5), // relatedKey
            cursor.getInt(offset + 6), // transactionId
            cursor.getInt(offset + 7), // type
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // title
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Notification entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setContent(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDate(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUserId(cursor.getInt(offset + 3));
        entity.setTransactionType(cursor.getInt(offset + 4));
        entity.setRelatedKey(cursor.getInt(offset + 5));
        entity.setTransactionId(cursor.getInt(offset + 6));
        entity.setType(cursor.getInt(offset + 7));
        entity.setTitle(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Notification entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Notification entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Notification entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}