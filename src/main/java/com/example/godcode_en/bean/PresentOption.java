package com.example.godcode_en.bean;

public class PresentOption {

    /**
     * present : {"id":0,"fK_UserID":0,"presentName":"string","costPrice":0,"presentImgUrl":"string"}
     */

    private PresentBean present;

    public PresentBean getPresent() {
        return present;
    }

    public void setPresent(PresentBean present) {
        this.present = present;
    }

    public static class PresentBean {
        /**
         * id : 0
         * fK_UserID : 0
         * presentName : string
         * costPrice : 0
         * presentImgUrl : string
         */

        private String id;
        private int fK_UserID;
        private String presentName;
        private String costPrice;
        private String presentImgUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public String getPresentName() {
            return presentName;
        }

        public void setPresentName(String presentName) {
            this.presentName = presentName;
        }

        public String getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(String costPrice) {
            this.costPrice = costPrice;
        }

        public String getPresentImgUrl() {
            return presentImgUrl;
        }

        public void setPresentImgUrl(String presentImgUrl) {
            this.presentImgUrl = presentImgUrl;
        }
    }
}
