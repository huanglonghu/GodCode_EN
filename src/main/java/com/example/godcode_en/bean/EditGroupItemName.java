package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/11/17.
 */

public class EditGroupItemName {

    /**
     * groupAppellation : {"userID":0,"toUserID":0,"groupName":"string"}
     */

    private GroupAppellationBean groupAppellation;

    public GroupAppellationBean getGroupAppellation() {
        return groupAppellation;
    }

    public void setGroupAppellation(GroupAppellationBean groupAppellation) {
        this.groupAppellation = groupAppellation;
    }

    public static class GroupAppellationBean {
        /**
         * userID : 0
         * toUserID : 0
         * groupName : string
         */

        private int userID;
        private int toUserID;
        private String groupName;

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public int getToUserID() {
            return toUserID;
        }

        public void setToUserID(int toUserID) {
            this.toUserID = toUserID;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }
    }
}
