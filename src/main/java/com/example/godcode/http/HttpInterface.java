package com.example.godcode.http;

import com.example.godcode.bean.AddBankCard;
import com.example.godcode.bean.BatchReturn;
import com.example.godcode.bean.BatchSettingBody;
import com.example.godcode.bean.BatchTransfer;
import com.example.godcode.bean.BindPackage;
import com.example.godcode.bean.ChangePsd;
import com.example.godcode.bean.DivideIncome;
import com.example.godcode.bean.EditBankCard;
import com.example.godcode.bean.EditGroupItemName;
import com.example.godcode.bean.EditPackage;
import com.example.godcode.bean.EditPresonal;
import com.example.godcode.bean.AddFriend;
import com.example.godcode.bean.BindBankCard;
import com.example.godcode.bean.BindProduct;
import com.example.godcode.bean.CheckPsd;
import com.example.godcode.bean.ConcurAddFriend;
import com.example.godcode.bean.CreateDivide;
import com.example.godcode.bean.CreateOrder;
import com.example.godcode.bean.EditProduct;
import com.example.godcode.bean.EditProductPrice;
import com.example.godcode.bean.EditProductSetting;
import com.example.godcode.bean.FrcationOption;
import com.example.godcode.bean.GetVerification;
import com.example.godcode.bean.Id;
import com.example.godcode.bean.LoginBody;
import com.example.godcode.bean.MobileRecharge;
import com.example.godcode.bean.PayByBalance;
import com.example.godcode.bean.PresentOption;
import com.example.godcode.bean.RechargeBody;
import com.example.godcode.bean.RefreshDiviceToken;
import com.example.godcode.bean.RefreshToken;
import com.example.godcode.bean.RegisterBody;
import com.example.godcode.bean.ResetPwdBean;
import com.example.godcode.bean.ReturnEquity;
import com.example.godcode.bean.SetPayPsd;
import com.example.godcode.bean.TransationDetail;
import com.example.godcode.bean.TransferBody;
import com.example.godcode.bean.TransferDivide;
import com.example.godcode.bean.Tx;
import com.example.godcode.bean.TxSyBody;
import com.example.godcode.bean.UnLockMc;
import com.example.godcode.bean.UpdateFriend;
import com.example.godcode.bean.WxPay;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface HttpInterface {

    @POST("/api/TokenAuth/Authenticate")
    Call<ResponseBody> login(@Body LoginBody body);

    @POST("api/services/app/User/RegisterMobileUser")
    Call<ResponseBody> register(@Body RegisterBody body);

    @GET("api/services/app/ProductCategory/GetAllProductCategorys")
    Call<ResponseBody> getAllProductCategory();

    @GET("api/services/app/Product/GetPagedProducts")
    Call<ResponseBody> getPagedProducts(@QueryMap Map<String, String> map);

    @GET("api/services/app/Product/GetProductByIdAsync")
    Call<ResponseBody> getProductById(@Query("Id") int Id);

    @GET("api/services/app/MerchantOwner/GetPagedMobileMerchantOwners")
    Call<ResponseBody> getProductByType(@QueryMap Map<String, String> map);

    @GET("api/services/app/Friends/GetFriendsByUserId")
    Call<ResponseBody> getFriendList(@QueryMap Map<String, String> map);

    @GET("api/services/app/User/GetMobileUserByID")
    Call<ResponseBody> getUserById(@Query("Id") int Id);

    @GET("api/services/app/User/GetUserByUserName")
    Call<ResponseBody> getUserByUserName(@Query("userNameOrPhoneNumber") String userName);

    @GET("api/services/app/Friends/GetFriendsByIdAsync")
    Call<ResponseBody> getFriendById(@Query("Id") int Id);

    @POST("api/services/app/Friends/CreateOrUpdateFriends")
    Call<ResponseBody> addFriend(@Body AddFriend addFriend);

    @POST("api/services/app/Friends/CreateOrUpdateFriends")
    Call<ResponseBody> updateFriend(@Body UpdateFriend updateFriend);

    @POST("api/services/app/MerchantOwner/BindOrRelieveBindMerchantOwner")
    Call<ResponseBody> bindProduct(@Body BindProduct body);

    @POST("api/services/app/MerchantOwner/BindOrRelieveBindMerchantOwner")
    Call<ResponseBody> bindProduct2(@Body BindProduct bindProduct);

    @GET("api/services/app/Balance/GetBalanceByUserIdAsync")
    Call<ResponseBody> queryBalance(@Query("Id") int Id);

    @GET("api/services/app/RevenueDivide/GetRevenueDivideByPitureIdAsync")
    Call<ResponseBody> getRevenueDivideById(@Query("Id") int Id);

    @POST("api/services/app/RevenueDivide/CreateOrUpdateRevenueDivide")
    Call<ResponseBody> createRevenueDivide(@Body CreateDivide createDivide);

    @POST("api/services/app/Friends/ConcurAddFriend")
    Call<ResponseBody> concurAddFriend(@Body ConcurAddFriend concurAddFriend);

    @POST("api/services/app/ProductPrice/CreateOrUpdateProductPrice")
    Call<ResponseBody> editProductPrice(@Body EditProductPrice editProductPrice);

    @GET("api/services/app/Enum/GetTeansactionInTypeList")
    Call<ResponseBody> getTeansantionTypeList();

    @GET("api/services/app/Enum/GetTransactionOutTypeList")
    Call<ResponseBody> getTeansantionTypeList2();

    @GET("api/services/app/TransactionReport/GetPagedTransactionReports")
    Call<ResponseBody> getTransaction(@QueryMap Map<String, String> map);

    @POST("api/services/app/CommonPaymentAppServices/TransferToUser")
    Call<ResponseBody> transfer(@Body TransferBody transferBody);

    @GET("api/services/app/CommonPaymentAppServices/GetPaymentKey")
    Call<ResponseBody> getPublicKey(@Query("Id") int Id);

    @PUT("api/services/app/PayPassword/UpdatePayPasswordAsync")
    Call<ResponseBody> changePsd(@Body ChangePsd changePsd);

    @POST("api/services/app/PayPassword/CreatePayPasswordAsync")
    Call<ResponseBody> createPsd(@Body SetPayPsd setPayPsd);

    @POST("api/services/app/PayPassword/VerificationPayPassword")
    Call<ResponseBody> checkPsyPsd(@Body CheckPsd checkPsd);

    @GET("api/services/app/PayPassword/GetPayPasswordByIdAsync")
    Call<ResponseBody> getPsyPsdById(@Query("Id") int Id);

    @GET("api/services/app/DivideIncome/GetDivideIncomesByUserID")
    Call<ResponseBody> getDivideIncomeById(@Query("Id") int Id);

    @POST("api/services/app/DivideIncome/ExtractDivideIncome")
    Call<ResponseBody> extractDivideIncome(@Body Id id);

    @POST("/api/services/app/BankCard/BindBankCard")
    Call<ResponseBody> bindBankCard(@Body BindBankCard bindBankCard);

    @GET("api/services/app/BankCard/GetBankCardsByUserID")
    Call<ResponseBody> getBankCardsByUserID(@Query("Id") int Id);

    @POST("api/services/app/BankCard/PresenBindBankCard")
    Call<ResponseBody> sendBankCardMsg(@Body AddBankCard editBankCard);

    @DELETE("api/services/app/RevenueDivide/DeleteRevenueDivide")
    Call<ResponseBody> deleteRevenueDivide(@Query("Id") int Id);

    @POST("api/services/app/PutMoney/CreateMobilePutMoney")
    Call<ResponseBody> tx(@Body Tx tx);

    @POST("WeChatPay/MoblieWXPayRequest")
    Call<ResponseBody> getPrepareOrder(@Body WxPay wxPay);

    @GET("MoblieWeChatAuth/MoblieWXAuthToken")
    Call<ResponseBody> getOpenId(@Query("code") String code);

    @GET("api/services/app/PayOrder/GetMobliePagedPayOrders")
    Call<ResponseBody> getYSRecord(@Query("StratTime") String time, @Query("EndTime") String time2, @Query("UserId") long userId, @Query("page") int page, @Query("limit") int limit);

    @POST("api/services/app/User/QueryMoblieVerificationCode")
    Call<ResponseBody> getVerificationCode(@Body GetVerification getVerification);

    @DELETE("api/services/app/Friends/DeleteFriends")
    Call<ResponseBody> deleteFriend(@Query("FK_UserID") int id1, @Query("ToUserID") int id2);

    @POST("api/services/app/CommonPaymentAppServices/TerracePayment")
    Call<ResponseBody> payByBanlance(@Body PayByBalance payByBalance);

    @GET("api/services/app/Product/GetProductByNumberAsync")
    Call<ResponseBody> querryProduct(@Query("ProductID") Integer ProductID, @Query("ProductNumber") String produceNumber);

    @POST("api/services/app/PayOrder/MobilePaymentProduct")
    Call<ResponseBody> getOrderNumber(@Body CreateOrder createOrder);

    @POST("api/services/app/CommonPaymentAppServices/RefundPayment")
    Call<ResponseBody> refundPayment(@Body PayByBalance payByBalance);

    @POST("api/services/app/PayMoney/CreateOrUpdatePayMoney")
    Call<ResponseBody> recharge(@Body RechargeBody body);

    @POST("api/services/app/TransactionReport/QueryTransationDetail")
    Call<ResponseBody> getTransactionDetail(@Body TransationDetail transationDetail);

    @DELETE("api/services/app/BankCard/DeleteBankCard")
    Call<ResponseBody> deleteBankCard(@Query("Id") int id);

    @POST("api/TokenAuth/MobileLoginOut")
    Call<ResponseBody> exit(@Query("UserId") int UserId, @Query("UniquenessToken") String diviceToken);

    @POST("api/services/app/User/MoblieUpdateUser")
    Call<ResponseBody> editPresonal(@Body EditPresonal editPresonal);

    @Multipart
    @POST("/api/PictureApi/UploadPicture")
        //1产品图片 2 用户头像 3产品类别图片
    Call<ResponseBody> uploadPicture(@Query("type") int type, @Part MultipartBody.Part file);

    @GET("api/services/app/Notice/GetNoticeByIdAsync")
    Call<ResponseBody> getNoticeById(@Query("Id") long id);

    @GET("api/services/app/Notice/GetPagedNotices")
    Call<ResponseBody> getNotices(@Query("page") int page, @Query("limit") int limit);

    @POST("api/services/app/Product/CreateOrUpdateProduct")
    Call<ResponseBody> editProduct(@Body EditProduct editProduct);


    @POST("/api/TokenAuth/RefreshAuthenticate")
    Call<ResponseBody> refreshAccessToken(@Body RefreshToken refreshToken);


    @POST("/api/services/app/MerchantOwner/TransferEquity")
    Call<ResponseBody> transferDivide(@Body TransferDivide transferDivide);

    @POST("/api/services/app/MerchantOwner/ReturnEquity")
    Call<ResponseBody> returnEquity(@Body ReturnEquity returnEquity);

    @GET("/api/services/app/RechargeSetting/GetRechargeSettingList")
    Call<ResponseBody> getMobileRechargeList();

    @POST("/api/services/app/RechargeRecord/Recharge")
    Call<ResponseBody> mobileRecharge(@Body MobileRecharge mobileRecharge);

    @GET("/api/services/app/MerchantOwner/GetMobileGroupMerchantOwners")
    Call<ResponseBody> getGroup(@Query("UserId") int userId, @Query("PeriodType") int periodType);

    @GET("/api/services/app/MerchantOwner/GetPagedMobileMerchantOwnersOne")
    Call<ResponseBody> getGroupById(@QueryMap Map<String, Integer> map);

    @POST("/api/services/app/GroupAppellation/CreateOrUpdate")
    Call<ResponseBody> editGroupItemName(@Body EditGroupItemName editGroupItemName);

    @GET("/api/services/app/ProductSetting/GetByProductId")
    Call<ResponseBody> getProductSettingMsg(@Query("id") int id);

    @POST("/api/services/app/ProductSetting/CreateOrUpdate")
    Call<ResponseBody> editProductSetting(@Body EditProductSetting eps);

    @PUT("/api/services/app/User/UpdateDeviceToken")
    Call<ResponseBody> refreshDiviceToken(@Body RefreshDiviceToken refreshDiviceToken);

    @GET("/api/services/app/Present/GetById")
    Call<ResponseBody> querryPresentById(@Query("Id") long id);//获取礼品列表

    @GET("/api/services/app/Present/GetPresentPaged")
    Call<ResponseBody> getPresentList(@Query("UserId") long userId, @Query("page") int page, @Query("limit") int limit);

    @GET("/api/services/app/Present/GetPresentPaged")
    Call<ResponseBody> searchPresent(@Query("UserId") long userId, @Query("PresentName") String presentName, @Query("page") int page, @Query("limit") int limit);

    @POST("/api/services/app/Present/CreateOrUpdate")
    Call<ResponseBody> createOrUpdatePresent(@Body PresentOption presentOption);

    @DELETE("/api/services/app/Present/Delete")
    Call<ResponseBody> deletePresent(@Query("Id") long id);

    @GET("/api/services/app/CommodityRoad/GetPaged")
    Call<ResponseBody> getCommodityRoadList(@Query("FK_ProductID") long FK_ProductID, @Query("PresentNameOrNumber") String PresentNameOrNumber, @Query("page") int page, @Query("limit") int limit);

    @POST("/api/services/app/CommodityRoad/CreateOrUpdate")
    Call<ResponseBody> editCommdityRoad(@Body BindProduct.CommodityRoadBeanX commodityRoadBeanX);

    @POST("/api/services/app/BankCard/CreateOrUpdateBankCard")
    Call<ResponseBody> editBankCard(@Body EditBankCard editBankCard);


    @GET("/api/services/app/PayOrder/GetAndroidBoardOrder")
    Call<ResponseBody> qurryOrderById(@Query("Id") long id);

    @POST("/api/services/app/CommodityRoad/BatchReplenishment")
    Call<ResponseBody> buHuo(@Query("costNumber") int costNumber, @Body ArrayList<Long> commodityRoadList);

    @GET("/api/services/app/SellGoodsRecord/GetSellGoodsRecordByOrderID")
    Call<ResponseBody> getSellGoodsOrderById(@Query("Id") long id);

    @POST("/api/services/app/CommodityRoad/BatchPositionSetting")
    Call<ResponseBody> batchSetting(@Body BatchSettingBody batchSettingBody);

    @GET("/api/services/app/ProductPackage/GetPagedProductPackage")
    Call<ResponseBody> getPackageList(@Query("FK_UserID") long userId, @Query("FK_ProductCategoryID") long categorId, @Query("page") int page, @Query("limit") int limit);

    @POST("/api/services/app/ProductPackage/CreateOrUpdate")
    Call<ResponseBody> editPackage(@Body EditPackage editPackage);

    @GET("/api/services/app/ProductPackageSetting/GetListProductPackageSetting")
    Call<ResponseBody> getPackageSettingList(@Query("FK_ProductID") long FK_ProductID);

    @POST("/api/services/app/ProductPackageSetting/CreateOrUpdate")
    Call<ResponseBody> bindPackage(@Body BindPackage bindPackage);

    @DELETE("/api/services/app/ProductPackageSetting/Delete")
    Call<ResponseBody> deletePackageSetting(@Query("Id") long id);

    @DELETE("/api/services/app/ProductPackage/Delete")
    Call<ResponseBody> deletePackage(@Query("Id") long id);

    @POST("/api/services/app/CommonPaymentAppServices/FreePlay")
    Call<ResponseBody> freePlay(@Body HashMap<String, String> map);

    @GET("/api/services/app/MCMerchantOwner/GetMobileGroupMCMerchantOwners")
    Call<ResponseBody> getDmMsg(@Query("UserID") int userId);

    @POST("/api/services/app/CommonPaymentAppServices/RechargeMCFraction")
    Call<ResponseBody> buyScore(@Body HashMap<String, Object> map);

    @GET("/api/services/app/MCMerchantOwner/GetMobileMCMerchantOwners")
    Call<ResponseBody> getDmMsgDetail(@Query("MCProductNumber") String productNum, @Query("UserID") int userId, @Query("CurrentGroupUserID") int groupId, @Query("page") int page, @Query("limit") int limit);


    @POST("/api/services/app/MakeCodeProduct/MCProductBatchTransfer")
    Call<ResponseBody> batchTransfer(@Body BatchTransfer batchTransfer);

    @POST("/api/services/app/MakeCodeProduct/MCProductBatchReturn")
    Call<ResponseBody> batchReturn(@Body BatchReturn batchReturn);

    @GET("/api/services/app/MCFraction/GetBuyFractionPriceByUserId")
    Call<ResponseBody> getPriceScale(@Query("Id") int userId);//积分换算比例

    @POST("/api/services/app/MakeCodeProduct/MCProductUnlock")
    Call<ResponseBody> unlock(@Body UnLockMc unLockMc);

    @GET("/api/services/app/MCProductUnlockRecord/GetPaged")
    Call<ResponseBody> getMcUnLockDetail(@Query("UserID") int userId, @Query("MCProductID") Integer productId, @Query("page") int page, @Query("limit") int limit);

    @POST("/api/services/app/MCFraction/RequestOrReturnFraction")
    Call<ResponseBody> requestOrReturnFraction(@Body HashMap<String, Integer> map);

    @GET("/api/services/app/RechargeMCFractionRecord/GetFractionRecordByUserID")
    Call<ResponseBody> getFractionRecord(@Query("UserID") int userId);

    @PUT("/api/services/app/MCFraction/UpdateRequestOrReturnFraction")
    Call<ResponseBody> frcationOption(@Body FrcationOption frcationOption);//申请积分、返回积分 同意或拒绝

    @GET("/api/services/app/RechargeMCFractionRecord/GetPagedByUserID")
    Call<ResponseBody> getScoreOptionRecord(@Query("UserID") int userId, @Query("page") int page, @Query("limit") int limit);

    @POST("/api/services/app/PayPassword/ResetPayPassword")
    Call<ResponseBody> resetPassword(@Body ResetPwdBean resetPwd);


    @POST("/api/services/app/MakeCodeProduct/CheckMCProductUnlockInfo")
    Call<ResponseBody> look(@Body HashMap<String, String> map);


    @GET("/api/services/app/SystemSettings/GetSystemSettings")
    Call<ResponseBody> getSystemSetting();

    @POST("/api/services/app/WithdrawMoneyProxy/QueryPagedWitharawMoneyProxyIncomes")
    Call<ResponseBody> getTxSy(@Body TxSyBody txSyBody);

    @GET("/api/services/app/DivideIncome/GetMobliePagedCoinDivideIncome")
    Call<ResponseBody> getCoinDivide(@Query("StratTime") String time, @Query("EndTime") String time2, @Query("UserID") long userId, @Query("page") int page, @Query("limit") int limit);


    @POST("/api/services/app/Balance/ClearCoinBalanceByUserID")
    Call<ResponseBody> clearCoinBalance(@Body HashMap<String, Integer> map);

    @POST("/api/services/app/User/ResetUserPassword")
    Call<ResponseBody> resetPwd(@Body HashMap<String, String> map);

}