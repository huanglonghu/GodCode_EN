package com.example.godcode_en.greendao.option;

import com.example.godcode_en.greendao.entity.ProductCategoryInfo;
import com.example.godcode_en.greendao.gen.ProductCategoryInfoDao;
import com.example.godcode_en.ui.base.GodCodeApplication;

import java.util.List;


public class ProductCategoryOption {
    private ProductCategoryOption() {
    }

    private static ProductCategoryOption defaultInstance;

    public static ProductCategoryOption getInstance() {
        ProductCategoryOption productCategoryOption = defaultInstance;
        if (defaultInstance == null) {
            synchronized (ProductCategoryOption.class) {
                if (defaultInstance == null) {
                    productCategoryOption = new ProductCategoryOption();
                    defaultInstance = productCategoryOption;
                }
            }
        }
        return productCategoryOption;
    }


    public List<ProductCategoryInfo> getProductCategoryList() {
        ProductCategoryInfoDao productCategoryInfoDao = GodCodeApplication.getInstance().getDaoSession().getProductCategoryInfoDao();
        List<ProductCategoryInfo> list = productCategoryInfoDao.queryBuilder().list();
        return list;
    }


    private boolean isExit(ProductCategoryInfo info) {
        ProductCategoryInfoDao productCategoryInfoDao = GodCodeApplication.getInstance().getDaoSession().getProductCategoryInfoDao();
        ProductCategoryInfo unique = productCategoryInfoDao.queryBuilder()
                .where(ProductCategoryInfoDao.Properties.ProductType.eq(info.getProductType())).where(ProductCategoryInfoDao.Properties.ProductId.eq(info.getProductId())).unique();
        return unique != null;
    }

    public void add(ProductCategoryInfo info) {
        ProductCategoryInfoDao productCategoryInfoDao = GodCodeApplication.getInstance().getDaoSession().getProductCategoryInfoDao();
        if (isExit(info)) {
            productCategoryInfoDao.insert(info);
        }
    }


    public int querryProductId(String productType) {
        int productCategoryId = 0;
        ProductCategoryInfoDao productCategoryInfoDao = GodCodeApplication.getInstance().getDaoSession().getProductCategoryInfoDao();
        ProductCategoryInfo unique = productCategoryInfoDao.queryBuilder()
                .where(ProductCategoryInfoDao.Properties.ProductType.eq(productType)).unique();

        if (unique != null) {
            productCategoryId = unique.getProductId();
        }
        return productCategoryId;
    }

}
