package com.example.godcode_en.bean;

public class AddFriend {

    /**
     * friends : {"fK_UserID":0,"toUserID":0,"nickName":"string","addTime":"2018-08-16T06:49:12.214Z","isConcur":true}
     */

    private FriendsBean friends;

    public FriendsBean getFriends() {
        return friends;
    }

    public void setFriends(FriendsBean friends) {
        this.friends = friends;
    }

    public static class FriendsBean {
        /**
         * fK_UserID : 0
         * toUserID : 0
         * nickName : string
         * addTime : 2018-08-16T06:49:12.214Z
         * isConcur : true
         */
        private int fK_UserID;
        private int toUserID;
        private String nickName;
        private String addTime;
        private boolean isConcur;

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public int getToUserID() {
            return toUserID;
        }

        public void setToUserID(int toUserID) {
            this.toUserID = toUserID;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public boolean isIsConcur() {
            return isConcur;
        }

        public void setIsConcur(boolean isConcur) {
            this.isConcur = isConcur;
        }
    }
}
