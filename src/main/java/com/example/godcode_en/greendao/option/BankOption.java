package com.example.godcode_en.greendao.option;

import com.example.godcode_en.greendao.entity.Bank;
import com.example.godcode_en.greendao.gen.BankDao;
import com.example.godcode_en.ui.base.GodCodeApplication;

import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */

public class BankOption {
    private static BankOption defaultInstance;
    private final BankDao bankDao;

    private BankOption() {
        bankDao = GodCodeApplication.getInstance().getDaoSession().getBankDao();
    }

    public static BankOption getInstance() {
        BankOption bankOption = defaultInstance;
        if (defaultInstance == null) {
            synchronized (BankOption.class) {
                if (defaultInstance == null) {
                    bankOption = new BankOption();
                    defaultInstance = bankOption;
                }
            }
        }
        return bankOption;
    }

    public void insertBank(Bank bank) {
        Bank mBank = bankDao.queryBuilder().where(BankDao.Properties.UserId.eq(bank.getUserId()), BankDao.Properties.BankNumber.eq(bank.getBankNumber())).unique();
        if (mBank == null) {
            bankDao.insert(bank);
        }
    }

    public List<Bank> getBankList(int userId) {
        List<Bank> list = bankDao.queryBuilder().where(BankDao.Properties.UserId.eq(userId)).list();
        return list;
    }

    public void deleteBank(String bankNum, int userId) {
        Bank bank = bankDao.queryBuilder().where(BankDao.Properties.UserId.eq(userId), BankDao.Properties.BankNumber.eq(bankNum)).unique();
        if (bank != null) {
            bankDao.delete(bank);
        }
    }
}
