package com.example.godcode_en.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.godcode_en.greendao.entity.ProductCategoryInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PRODUCT_CATEGORY_INFO".
*/
public class ProductCategoryInfoDao extends AbstractDao<ProductCategoryInfo, Void> {

    public static final String TABLENAME = "PRODUCT_CATEGORY_INFO";

    /**
     * Properties of entity ProductCategoryInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ProductType = new Property(0, String.class, "ProductType", false, "PRODUCT_TYPE");
        public final static Property ProductId = new Property(1, int.class, "productId", false, "PRODUCT_ID");
    }


    public ProductCategoryInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ProductCategoryInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PRODUCT_CATEGORY_INFO\" (" + //
                "\"PRODUCT_TYPE\" TEXT NOT NULL ," + // 0: ProductType
                "\"PRODUCT_ID\" INTEGER NOT NULL );"); // 1: productId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PRODUCT_CATEGORY_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ProductCategoryInfo entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getProductType());
        stmt.bindLong(2, entity.getProductId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ProductCategoryInfo entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getProductType());
        stmt.bindLong(2, entity.getProductId());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public ProductCategoryInfo readEntity(Cursor cursor, int offset) {
        ProductCategoryInfo entity = new ProductCategoryInfo( //
            cursor.getString(offset + 0), // ProductType
            cursor.getInt(offset + 1) // productId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ProductCategoryInfo entity, int offset) {
        entity.setProductType(cursor.getString(offset + 0));
        entity.setProductId(cursor.getInt(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(ProductCategoryInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(ProductCategoryInfo entity) {
        return null;
    }

    @Override
    public boolean hasKey(ProductCategoryInfo entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
