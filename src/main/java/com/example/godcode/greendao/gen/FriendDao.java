package com.example.godcode.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.godcode.greendao.entity.Friend;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FRIEND".
*/
public class FriendDao extends AbstractDao<Friend, Long> {

    public static final String TABLENAME = "FRIEND";

    /**
     * Properties of entity Friend.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UserName = new Property(1, String.class, "userName", false, "USER_NAME");
        public final static Property UserId = new Property(2, int.class, "userId", false, "USER_ID");
        public final static Property FriendId = new Property(3, int.class, "friendId", false, "FRIEND_ID");
        public final static Property Area = new Property(4, String.class, "area", false, "AREA");
        public final static Property HeadImageUrl = new Property(5, String.class, "headImageUrl", false, "HEAD_IMAGE_URL");
        public final static Property Id_ = new Property(6, int.class, "id_", false, "ID_");
        public final static Property SyNum = new Property(7, String.class, "syNum", false, "SY_NUM");
        public final static Property FirstChar = new Property(8, String.class, "firstChar", false, "FIRST_CHAR");
    }


    public FriendDao(DaoConfig config) {
        super(config);
    }
    
    public FriendDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FRIEND\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USER_NAME\" TEXT," + // 1: userName
                "\"USER_ID\" INTEGER NOT NULL ," + // 2: userId
                "\"FRIEND_ID\" INTEGER NOT NULL ," + // 3: friendId
                "\"AREA\" TEXT," + // 4: area
                "\"HEAD_IMAGE_URL\" TEXT," + // 5: headImageUrl
                "\"ID_\" INTEGER NOT NULL ," + // 6: id_
                "\"SY_NUM\" TEXT," + // 7: syNum
                "\"FIRST_CHAR\" TEXT);"); // 8: firstChar
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FRIEND\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Friend entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(2, userName);
        }
        stmt.bindLong(3, entity.getUserId());
        stmt.bindLong(4, entity.getFriendId());
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(5, area);
        }
 
        String headImageUrl = entity.getHeadImageUrl();
        if (headImageUrl != null) {
            stmt.bindString(6, headImageUrl);
        }
        stmt.bindLong(7, entity.getId_());
 
        String syNum = entity.getSyNum();
        if (syNum != null) {
            stmt.bindString(8, syNum);
        }
 
        String firstChar = entity.getFirstChar();
        if (firstChar != null) {
            stmt.bindString(9, firstChar);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Friend entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(2, userName);
        }
        stmt.bindLong(3, entity.getUserId());
        stmt.bindLong(4, entity.getFriendId());
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(5, area);
        }
 
        String headImageUrl = entity.getHeadImageUrl();
        if (headImageUrl != null) {
            stmt.bindString(6, headImageUrl);
        }
        stmt.bindLong(7, entity.getId_());
 
        String syNum = entity.getSyNum();
        if (syNum != null) {
            stmt.bindString(8, syNum);
        }
 
        String firstChar = entity.getFirstChar();
        if (firstChar != null) {
            stmt.bindString(9, firstChar);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Friend readEntity(Cursor cursor, int offset) {
        Friend entity = new Friend( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // userName
            cursor.getInt(offset + 2), // userId
            cursor.getInt(offset + 3), // friendId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // area
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // headImageUrl
            cursor.getInt(offset + 6), // id_
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // syNum
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // firstChar
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Friend entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUserId(cursor.getInt(offset + 2));
        entity.setFriendId(cursor.getInt(offset + 3));
        entity.setArea(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setHeadImageUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setId_(cursor.getInt(offset + 6));
        entity.setSyNum(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setFirstChar(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Friend entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Friend entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Friend entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
