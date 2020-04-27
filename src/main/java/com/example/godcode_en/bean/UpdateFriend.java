package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/8/16.
 */

public class UpdateFriend {

    /**
     * friends : {"id":20216,"fK_UserID":20075,"toUserID":20076,"nickName":"ss","isConcur":true}
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
         * id : 20216
         * fK_UserID : 20075
         * toUserID : 20076
         * nickName : ss
         * isConcur : true
         */

        private int id;
        private int fK_UserID;
        private int toUserID;
        private String nickName;
        private boolean isConcur;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public boolean isIsConcur() {
            return isConcur;
        }

        public void setIsConcur(boolean isConcur) {
            this.isConcur = isConcur;
        }
    }
}
