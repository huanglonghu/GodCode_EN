package com.example.godcode_en.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.godcode_en.greendao.entity.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Area = new Property(1, String.class, "area", false, "AREA");
        public final static Property Sex = new Property(2, String.class, "sex", false, "SEX");
        public final static Property HeadImageUrl = new Property(3, String.class, "headImageUrl", false, "HEAD_IMAGE_URL");
        public final static Property UserName = new Property(4, String.class, "userName", false, "USER_NAME");
        public final static Property UserId = new Property(5, int.class, "userId", false, "USER_ID");
        public final static Property SyNumber = new Property(6, String.class, "syNumber", false, "SY_NUMBER");
        public final static Property PhoneNumer = new Property(7, String.class, "phoneNumer", false, "PHONE_NUMER");
        public final static Property SetPwd = new Property(8, boolean.class, "setPwd", false, "SET_PWD");
        public final static Property IsMakeCode = new Property(9, boolean.class, "isMakeCode", false, "IS_MAKE_CODE");
        public final static Property EmailAddress = new Property(10, String.class, "emailAddress", false, "EMAIL_ADDRESS");
        public final static Property IsProxy = new Property(11, boolean.class, "isProxy", false, "IS_PROXY");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"AREA\" TEXT," + // 1: area
                "\"SEX\" TEXT," + // 2: sex
                "\"HEAD_IMAGE_URL\" TEXT," + // 3: headImageUrl
                "\"USER_NAME\" TEXT," + // 4: userName
                "\"USER_ID\" INTEGER NOT NULL ," + // 5: userId
                "\"SY_NUMBER\" TEXT," + // 6: syNumber
                "\"PHONE_NUMER\" TEXT," + // 7: phoneNumer
                "\"SET_PWD\" INTEGER NOT NULL ," + // 8: setPwd
                "\"IS_MAKE_CODE\" INTEGER NOT NULL ," + // 9: isMakeCode
                "\"EMAIL_ADDRESS\" TEXT," + // 10: emailAddress
                "\"IS_PROXY\" INTEGER NOT NULL );"); // 11: isProxy
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(2, area);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(3, sex);
        }
 
        String headImageUrl = entity.getHeadImageUrl();
        if (headImageUrl != null) {
            stmt.bindString(4, headImageUrl);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(5, userName);
        }
        stmt.bindLong(6, entity.getUserId());
 
        String syNumber = entity.getSyNumber();
        if (syNumber != null) {
            stmt.bindString(7, syNumber);
        }
 
        String phoneNumer = entity.getPhoneNumer();
        if (phoneNumer != null) {
            stmt.bindString(8, phoneNumer);
        }
        stmt.bindLong(9, entity.getSetPwd() ? 1L: 0L);
        stmt.bindLong(10, entity.getIsMakeCode() ? 1L: 0L);
 
        String emailAddress = entity.getEmailAddress();
        if (emailAddress != null) {
            stmt.bindString(11, emailAddress);
        }
        stmt.bindLong(12, entity.getIsProxy() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(2, area);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(3, sex);
        }
 
        String headImageUrl = entity.getHeadImageUrl();
        if (headImageUrl != null) {
            stmt.bindString(4, headImageUrl);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(5, userName);
        }
        stmt.bindLong(6, entity.getUserId());
 
        String syNumber = entity.getSyNumber();
        if (syNumber != null) {
            stmt.bindString(7, syNumber);
        }
 
        String phoneNumer = entity.getPhoneNumer();
        if (phoneNumer != null) {
            stmt.bindString(8, phoneNumer);
        }
        stmt.bindLong(9, entity.getSetPwd() ? 1L: 0L);
        stmt.bindLong(10, entity.getIsMakeCode() ? 1L: 0L);
 
        String emailAddress = entity.getEmailAddress();
        if (emailAddress != null) {
            stmt.bindString(11, emailAddress);
        }
        stmt.bindLong(12, entity.getIsProxy() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // area
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // sex
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // headImageUrl
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // userName
            cursor.getInt(offset + 5), // userId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // syNumber
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // phoneNumer
            cursor.getShort(offset + 8) != 0, // setPwd
            cursor.getShort(offset + 9) != 0, // isMakeCode
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // emailAddress
            cursor.getShort(offset + 11) != 0 // isProxy
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setArea(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSex(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setHeadImageUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUserName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUserId(cursor.getInt(offset + 5));
        entity.setSyNumber(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPhoneNumer(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setSetPwd(cursor.getShort(offset + 8) != 0);
        entity.setIsMakeCode(cursor.getShort(offset + 9) != 0);
        entity.setEmailAddress(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setIsProxy(cursor.getShort(offset + 11) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}