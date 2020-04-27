package com.example.godcode_en.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */

public class ApplyFriend {

    /**
     * result : {"totalCount":1,"items":[{"fK_UserID":20087,"toUserID":20084,"nickName":"ifelse","toUserName":"sy1535125855","friendImgPath":"http://thirdwx.qlogo.cn/mmopen/vi_32/5kohBTxbgtjGicjtBcAEaup8Ojia40libIZNKcQo0l3ex1hAvb0avCn2WZ4WSkyL1YtQYGqsy5LjeICz2oo7XyW1w/132","addTime":null,"isConcur":false,"id":20305}]}
     * targetUrl : null
     * success : true
     * error : null
     * unAuthorizedRequest : false
     * __abp : true
     */

    private ResultBean result;
    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public boolean isUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public boolean is__abp() {
        return __abp;
    }

    public void set__abp(boolean __abp) {
        this.__abp = __abp;
    }

    public static class ResultBean {
        /**
         * totalCount : 1
         * items : [{"fK_UserID":20087,"toUserID":20084,"nickName":"ifelse","toUserName":"sy1535125855","friendImgPath":"http://thirdwx.qlogo.cn/mmopen/vi_32/5kohBTxbgtjGicjtBcAEaup8Ojia40libIZNKcQo0l3ex1hAvb0avCn2WZ4WSkyL1YtQYGqsy5LjeICz2oo7XyW1w/132","addTime":null,"isConcur":false,"id":20305}]
         */

        private int totalCount;
        private List<ItemsBean> items;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * fK_UserID : 20087
             * toUserID : 20084
             * nickName : ifelse
             * toUserName : sy1535125855
             * friendImgPath : http://thirdwx.qlogo.cn/mmopen/vi_32/5kohBTxbgtjGicjtBcAEaup8Ojia40libIZNKcQo0l3ex1hAvb0avCn2WZ4WSkyL1YtQYGqsy5LjeICz2oo7XyW1w/132
             * addTime : null
             * isConcur : false
             * id : 20305
             */

            private int fK_UserID;
            private int toUserID;
            private String nickName;
            private String toUserName;
            private String friendImgPath;
            private Object addTime;
            private boolean isConcur;
            private int id;

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

            public String getToUserName() {
                return toUserName;
            }

            public void setToUserName(String toUserName) {
                this.toUserName = toUserName;
            }

            public String getFriendImgPath() {
                return friendImgPath;
            }

            public void setFriendImgPath(String friendImgPath) {
                this.friendImgPath = friendImgPath;
            }

            public Object getAddTime() {
                return addTime;
            }

            public void setAddTime(Object addTime) {
                this.addTime = addTime;
            }

            public boolean isIsConcur() {
                return isConcur;
            }

            public void setIsConcur(boolean isConcur) {
                this.isConcur = isConcur;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
