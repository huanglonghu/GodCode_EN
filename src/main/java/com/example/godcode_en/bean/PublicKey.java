package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/3.
 */

public class PublicKey {


    /**
     * result : {"xmlKey":"<RSAKeyValue><Modulus>sGCRtJaiAqkNtKNE38jFnwKTI37Ud6tlbQCahgHHPsBeGNdTCOEHeSvX0psOeJhT5+9zL2pcMzc6YYl56Bx4fVfIMlJmNCyFvRksqbPG47M4b2RqP/yyYt7TBmmqYlOdxSQowfUSa+QLtJ8LfToueInajCTyWuahWUpJHa6+NMsjtdM7v70ZbsdVoge1St1++OuPfIbLbEmxnUqNzC7cwtJNWu5C83rWK1yYEPhEe/NavekYvX9r1zp/SLMysYWwUHslM7syO66xy9Fvizrc/yXIYh//SjzJK5k0uZXPXFcitShecR5mo7Y/01EDORPAXBevcFdXme7PBDZOgUJZsQ==<\/Modulus><Exponent>AQAB<\/Exponent><\/RSAKeyValue>","pemKey":"-----BEGIN PUBLIC KEY-----\r\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsGCRtJaiAqkNtKNE38jF\r\nnwKTI37Ud6tlbQCahgHHPsBeGNdTCOEHeSvX0psOeJhT5+9zL2pcMzc6YYl56Bx4\r\nfVfIMlJmNCyFvRksqbPG47M4b2RqP/yyYt7TBmmqYlOdxSQowfUSa+QLtJ8LfTou\r\neInajCTyWuahWUpJHa6+NMsjtdM7v70ZbsdVoge1St1++OuPfIbLbEmxnUqNzC7c\r\nwtJNWu5C83rWK1yYEPhEe/NavekYvX9r1zp/SLMysYWwUHslM7syO66xy9Fvizrc\r\n/yXIYh//SjzJK5k0uZXPXFcitShecR5mo7Y/01EDORPAXBevcFdXme7PBDZOgUJZ\r\nsQIDAQAB\r\n-----END PUBLIC KEY-----\r\n"}
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
         * xmlKey : <RSAKeyValue><Modulus>sGCRtJaiAqkNtKNE38jFnwKTI37Ud6tlbQCahgHHPsBeGNdTCOEHeSvX0psOeJhT5+9zL2pcMzc6YYl56Bx4fVfIMlJmNCyFvRksqbPG47M4b2RqP/yyYt7TBmmqYlOdxSQowfUSa+QLtJ8LfToueInajCTyWuahWUpJHa6+NMsjtdM7v70ZbsdVoge1St1++OuPfIbLbEmxnUqNzC7cwtJNWu5C83rWK1yYEPhEe/NavekYvX9r1zp/SLMysYWwUHslM7syO66xy9Fvizrc/yXIYh//SjzJK5k0uZXPXFcitShecR5mo7Y/01EDORPAXBevcFdXme7PBDZOgUJZsQ==</Modulus><Exponent>AQAB</Exponent></RSAKeyValue>
         * pemKey : -----BEGIN PUBLIC KEY-----
         MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsGCRtJaiAqkNtKNE38jF
         nwKTI37Ud6tlbQCahgHHPsBeGNdTCOEHeSvX0psOeJhT5+9zL2pcMzc6YYl56Bx4
         fVfIMlJmNCyFvRksqbPG47M4b2RqP/yyYt7TBmmqYlOdxSQowfUSa+QLtJ8LfTou
         eInajCTyWuahWUpJHa6+NMsjtdM7v70ZbsdVoge1St1++OuPfIbLbEmxnUqNzC7c
         wtJNWu5C83rWK1yYEPhEe/NavekYvX9r1zp/SLMysYWwUHslM7syO66xy9Fvizrc
         /yXIYh//SjzJK5k0uZXPXFcitShecR5mo7Y/01EDORPAXBevcFdXme7PBDZOgUJZ
         sQIDAQAB
         -----END PUBLIC KEY-----

         */

        private String xmlKey;
        private String pemKey;

        public String getXmlKey() {
            return xmlKey;
        }

        public void setXmlKey(String xmlKey) {
            this.xmlKey = xmlKey;
        }

        public String getPemKey() {
            return pemKey;
        }

        public void setPemKey(String pemKey) {
            this.pemKey = pemKey;
        }
    }
}
