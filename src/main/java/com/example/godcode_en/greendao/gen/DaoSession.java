package com.example.godcode_en.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.godcode_en.greendao.entity.Bank;
import com.example.godcode_en.greendao.entity.City;
import com.example.godcode_en.greendao.entity.Friend;
import com.example.godcode_en.greendao.entity.LoginResult;
import com.example.godcode_en.greendao.entity.Notification;
import com.example.godcode_en.greendao.entity.ProductCategoryInfo;
import com.example.godcode_en.greendao.entity.Province;
import com.example.godcode_en.greendao.entity.TransationName;
import com.example.godcode_en.greendao.entity.TranscationType;
import com.example.godcode_en.greendao.entity.User;
import com.example.godcode_en.greendao.entity.VersionMsg;
import com.example.godcode_en.greendao.entity.Zone;

import com.example.godcode_en.greendao.gen.BankDao;
import com.example.godcode_en.greendao.gen.CityDao;
import com.example.godcode_en.greendao.gen.FriendDao;
import com.example.godcode_en.greendao.gen.LoginResultDao;
import com.example.godcode_en.greendao.gen.NotificationDao;
import com.example.godcode_en.greendao.gen.ProductCategoryInfoDao;
import com.example.godcode_en.greendao.gen.ProvinceDao;
import com.example.godcode_en.greendao.gen.TransationNameDao;
import com.example.godcode_en.greendao.gen.TranscationTypeDao;
import com.example.godcode_en.greendao.gen.UserDao;
import com.example.godcode_en.greendao.gen.VersionMsgDao;
import com.example.godcode_en.greendao.gen.ZoneDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bankDaoConfig;
    private final DaoConfig cityDaoConfig;
    private final DaoConfig friendDaoConfig;
    private final DaoConfig loginResultDaoConfig;
    private final DaoConfig notificationDaoConfig;
    private final DaoConfig productCategoryInfoDaoConfig;
    private final DaoConfig provinceDaoConfig;
    private final DaoConfig transationNameDaoConfig;
    private final DaoConfig transcationTypeDaoConfig;
    private final DaoConfig userDaoConfig;
    private final DaoConfig versionMsgDaoConfig;
    private final DaoConfig zoneDaoConfig;

    private final BankDao bankDao;
    private final CityDao cityDao;
    private final FriendDao friendDao;
    private final LoginResultDao loginResultDao;
    private final NotificationDao notificationDao;
    private final ProductCategoryInfoDao productCategoryInfoDao;
    private final ProvinceDao provinceDao;
    private final TransationNameDao transationNameDao;
    private final TranscationTypeDao transcationTypeDao;
    private final UserDao userDao;
    private final VersionMsgDao versionMsgDao;
    private final ZoneDao zoneDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bankDaoConfig = daoConfigMap.get(BankDao.class).clone();
        bankDaoConfig.initIdentityScope(type);

        cityDaoConfig = daoConfigMap.get(CityDao.class).clone();
        cityDaoConfig.initIdentityScope(type);

        friendDaoConfig = daoConfigMap.get(FriendDao.class).clone();
        friendDaoConfig.initIdentityScope(type);

        loginResultDaoConfig = daoConfigMap.get(LoginResultDao.class).clone();
        loginResultDaoConfig.initIdentityScope(type);

        notificationDaoConfig = daoConfigMap.get(NotificationDao.class).clone();
        notificationDaoConfig.initIdentityScope(type);

        productCategoryInfoDaoConfig = daoConfigMap.get(ProductCategoryInfoDao.class).clone();
        productCategoryInfoDaoConfig.initIdentityScope(type);

        provinceDaoConfig = daoConfigMap.get(ProvinceDao.class).clone();
        provinceDaoConfig.initIdentityScope(type);

        transationNameDaoConfig = daoConfigMap.get(TransationNameDao.class).clone();
        transationNameDaoConfig.initIdentityScope(type);

        transcationTypeDaoConfig = daoConfigMap.get(TranscationTypeDao.class).clone();
        transcationTypeDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        versionMsgDaoConfig = daoConfigMap.get(VersionMsgDao.class).clone();
        versionMsgDaoConfig.initIdentityScope(type);

        zoneDaoConfig = daoConfigMap.get(ZoneDao.class).clone();
        zoneDaoConfig.initIdentityScope(type);

        bankDao = new BankDao(bankDaoConfig, this);
        cityDao = new CityDao(cityDaoConfig, this);
        friendDao = new FriendDao(friendDaoConfig, this);
        loginResultDao = new LoginResultDao(loginResultDaoConfig, this);
        notificationDao = new NotificationDao(notificationDaoConfig, this);
        productCategoryInfoDao = new ProductCategoryInfoDao(productCategoryInfoDaoConfig, this);
        provinceDao = new ProvinceDao(provinceDaoConfig, this);
        transationNameDao = new TransationNameDao(transationNameDaoConfig, this);
        transcationTypeDao = new TranscationTypeDao(transcationTypeDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        versionMsgDao = new VersionMsgDao(versionMsgDaoConfig, this);
        zoneDao = new ZoneDao(zoneDaoConfig, this);

        registerDao(Bank.class, bankDao);
        registerDao(City.class, cityDao);
        registerDao(Friend.class, friendDao);
        registerDao(LoginResult.class, loginResultDao);
        registerDao(Notification.class, notificationDao);
        registerDao(ProductCategoryInfo.class, productCategoryInfoDao);
        registerDao(Province.class, provinceDao);
        registerDao(TransationName.class, transationNameDao);
        registerDao(TranscationType.class, transcationTypeDao);
        registerDao(User.class, userDao);
        registerDao(VersionMsg.class, versionMsgDao);
        registerDao(Zone.class, zoneDao);
    }
    
    public void clear() {
        bankDaoConfig.clearIdentityScope();
        cityDaoConfig.clearIdentityScope();
        friendDaoConfig.clearIdentityScope();
        loginResultDaoConfig.clearIdentityScope();
        notificationDaoConfig.clearIdentityScope();
        productCategoryInfoDaoConfig.clearIdentityScope();
        provinceDaoConfig.clearIdentityScope();
        transationNameDaoConfig.clearIdentityScope();
        transcationTypeDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
        versionMsgDaoConfig.clearIdentityScope();
        zoneDaoConfig.clearIdentityScope();
    }

    public BankDao getBankDao() {
        return bankDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public FriendDao getFriendDao() {
        return friendDao;
    }

    public LoginResultDao getLoginResultDao() {
        return loginResultDao;
    }

    public NotificationDao getNotificationDao() {
        return notificationDao;
    }

    public ProductCategoryInfoDao getProductCategoryInfoDao() {
        return productCategoryInfoDao;
    }

    public ProvinceDao getProvinceDao() {
        return provinceDao;
    }

    public TransationNameDao getTransationNameDao() {
        return transationNameDao;
    }

    public TranscationTypeDao getTranscationTypeDao() {
        return transcationTypeDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public VersionMsgDao getVersionMsgDao() {
        return versionMsgDao;
    }

    public ZoneDao getZoneDao() {
        return zoneDao;
    }

}
