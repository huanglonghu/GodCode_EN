package com.example.godcode_en.bean;

import java.util.List;

public class CommodityRoadList {


    /**
     * result : {"code":0,"msg":null,"count":1,"data":[{"fK_ProductID":276,"commodityRoadNumber":0,"fK_PresentID":6,"presentName":"嗨皮","sellPrice":1,"gamePrice":2,"probability":3,"currentStocks":1,"capacity":1,"addDateTime":"2019-02-13T10:47:00.5310042","imgUrl":"/Files/Pictures/Commodity/a2526a3b-4a9d-4a39-adf7-d200a221e07b.jpg","id":2}]}
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
         * code : 0
         * msg : null
         * count : 1
         * data : [{"fK_ProductID":276,"commodityRoadNumber":0,"fK_PresentID":6,"presentName":"嗨皮","sellPrice":1,"gamePrice":2,"probability":3,"currentStocks":1,"capacity":1,"addDateTime":"2019-02-13T10:47:00.5310042","imgUrl":"/Files/Pictures/Commodity/a2526a3b-4a9d-4a39-adf7-d200a221e07b.jpg","id":2}]
         */

        private int code;
        private Object msg;
        private int count;
        private List<DataBean> data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Object getMsg() {
            return msg;
        }

        public void setMsg(Object msg) {
            this.msg = msg;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * fK_ProductID : 276
             * commodityRoadNumber : 0
             * fK_PresentID : 6
             * presentName : 嗨皮
             * sellPrice : 1.0
             * gamePrice : 2.0
             * probability : 3
             * currentStocks : 1
             * capacity : 1
             * addDateTime : 2019-02-13T10:47:00.5310042
             * imgUrl : /Files/Pictures/Commodity/a2526a3b-4a9d-4a39-adf7-d200a221e07b.jpg
             * id : 2
             */

            private int fK_ProductID;
            private int commodityRoadNumber;
            private int fK_PresentID;
            private String presentName;
            private String sellPrice;
            private String gamePrice;
            private String probability;
            private int currentStocks;
            private int capacity;
            private String addDateTime;
            private String imgUrl;
            private int id;

            public int getFK_ProductID() {
                return fK_ProductID;
            }

            public void setFK_ProductID(int fK_ProductID) {
                this.fK_ProductID = fK_ProductID;
            }

            public int getCommodityRoadNumber() {
                return commodityRoadNumber;
            }

            public void setCommodityRoadNumber(int commodityRoadNumber) {
                this.commodityRoadNumber = commodityRoadNumber;
            }

            public int getFK_PresentID() {
                return fK_PresentID;
            }

            public void setFK_PresentID(int fK_PresentID) {
                this.fK_PresentID = fK_PresentID;
            }

            public String getPresentName() {
                return presentName;
            }

            public void setPresentName(String presentName) {
                this.presentName = presentName;
            }

            public String getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(String sellPrice) {
                this.sellPrice = sellPrice;
            }

            public String getGamePrice() {
                return gamePrice;
            }

            public void setGamePrice(String gamePrice) {
                this.gamePrice = gamePrice;
            }

            public String getProbability() {
                return probability;
            }

            public void setProbability(String probability) {
                this.probability = probability;
            }

            public int getCurrentStocks() {
                return currentStocks;
            }

            public void setCurrentStocks(int currentStocks) {
                this.currentStocks = currentStocks;
            }

            public int getCapacity() {
                return capacity;
            }

            public void setCapacity(int capacity) {
                this.capacity = capacity;
            }

            public String getAddDateTime() {
                return addDateTime;
            }

            public void setAddDateTime(String addDateTime) {
                this.addDateTime = addDateTime;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
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
