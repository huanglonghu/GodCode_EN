package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/4.
 */

public class EditDivide {

    /**
     * revenueDivide : {"id":0,"fK_ProductID":0,"fK_UserIDOwner":0,"fK_UserIDDivide":0,"divideRate":0,"isValid":true,"remark":"string"}
     */

    private RevenueDivideBean revenueDivide;

    public RevenueDivideBean getRevenueDivide() {
        return revenueDivide;
    }

    public void setRevenueDivide(RevenueDivideBean revenueDivide) {
        this.revenueDivide = revenueDivide;
    }

    public static class RevenueDivideBean {
        /**
         * id : 0
         * fK_ProductID : 0
         * fK_UserIDOwner : 0
         * fK_UserIDDivide : 0
         * divideRate : 0
         * isValid : true
         * remark : string
         */

        private int id;
        private int fK_ProductID;
        private int fK_UserIDOwner;
        private int fK_UserIDDivide;
        private int divideRate;
        private boolean isValid;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFK_ProductID() {
            return fK_ProductID;
        }

        public void setFK_ProductID(int fK_ProductID) {
            this.fK_ProductID = fK_ProductID;
        }

        public int getFK_UserIDOwner() {
            return fK_UserIDOwner;
        }

        public void setFK_UserIDOwner(int fK_UserIDOwner) {
            this.fK_UserIDOwner = fK_UserIDOwner;
        }

        public int getFK_UserIDDivide() {
            return fK_UserIDDivide;
        }

        public void setFK_UserIDDivide(int fK_UserIDDivide) {
            this.fK_UserIDDivide = fK_UserIDDivide;
        }

        public int getDivideRate() {
            return divideRate;
        }

        public void setDivideRate(int divideRate) {
            this.divideRate = divideRate;
        }

        public boolean isIsValid() {
            return isValid;
        }

        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
