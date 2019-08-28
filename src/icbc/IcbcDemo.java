package icbc;

import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.UiIcbcClient;
import com.icbc.api.internal.util.internal.util.fastjson.JSONObject;
import com.icbc.api.request.MybankPayCpayCppayapplyRequestV1;
import com.icbc.api.response.MybankPayCpayCppayapplyResponseV1;

import java.util.ArrayList;
import java.util.List;


public class IcbcDemo {

    //1、网关公钥
    protected static final String APIGW_PUBLIC_KEY ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwFgHD4kzEVPdOj03ctKM7KV+16bWZ5BMNgvEeuEQwfQYkRVwI9HFOGkwNTMn5hiJXHnlXYCX+zp5r6R52MY0O7BsTCLT7aHaxsANsvI9ABGx3OaTVlPB59M6GPbJh0uXvio0m1r/lTW3Z60RU6Q3oid/rNhP3CiNgg0W6O3AGqwIDAQAB";

    //2、appid
    protected static final String APP_ID = "10000000000000121011";

    //3、密钥对认证方式，公钥在API平台登记，此处为私钥
    protected static final String MY_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCyXA5t2IatLbMbT9MJya6myxMpkEt2IduY6Ydoqk9Gk/vOqgWz7W9akt6rTzh6YEtXMzFsTsOoAlH1pfo/+xixr7JefVgOiwT4UKmTueSs8XZ5yQG8pmMCBeuYsVxJP/mtumyQZWHR5WGrb8gEL56DY8iHESK5UQJERusSXq/E87EE8CSyOmrgN3jxKl33eNTq/+CyleLjTveyo8JQ84tXRIlkfeTFm2O4RJPG41u/IHQLkCoYJVZyvlTZv6j/TCfmbAAuqXrKYQqRH05dLFJeoLTsVDKeDoieSYVnq0VNHNUuxd337df7ukJemzQw0YewVWLKSmMhBdNKqvXkI7YBAgMBAAECggEAGxTtP/KTqHH68xewxJiyAzNsinAVdS9454P2AodxmBbaMiwQx5wyvz7zvnE98x7x8aCdTYO8I6OOjE0SbWqT+k7iN4SyvSqQq5+b0Al21menhKBnuhxNhj4d4sZza8/h+mYHG/m426UHqn9DkJcma27YQOHyMs9BF9ro0JY9/Bp+7GdRpkDP35+Wrge8H1PCEzMmTZE1QCmxubBqKkSoGbhHMVUXKtPyWHNEOWAhLu8kBCKhGMoAMIUgb5N1GD+1ezoUSJOrdOaH63TrRM79r3/EI2qaZoDWWNtrpr/gxihzEQD3kUi0dcfSMrW5PFNWoP09oOqOIN/vZH6Fhx5orQKBgQD1xwPhCCYtMRKHX+7B2O950NechGr4T+M9oelMsTnajHKYxCxI7TTprfEMrDdDTWdkr39lHNXxmQJe8vQI30iwLTSMlaVUmpjEBwX5E6GLAl77F5uHaxyKK2UVDG3rxKNeJzC9ratysjZw99tfdPqTJPOcqNc5VXZJU2ErBWt8+wKBgQC5xzDf1SHzHmxgiJqcvDBb7S6vVi8qcbIDZoVqhLezQJWQKd5lBnJvU/1uVtYeE5vPjUngFhAOk+E9HnGRKPik2UHBK66BmjYazjMx5S2WFRY7guS3aoh+xzp0KNQkdZX2skYofX+n7k8N6854c/9sa2HPO9B4dFJuwzH4NWRwMwKBgQD01wB3Qc3+QR+LOrc35yuRt8nDA2so2TSwZkZqfzb6D+XtZ6gSMjP/Aqfajwkyg76XX/lSOiqrVlk1S2RuHjlkQHRUBJPCN4wt5C1AFx1bxM3n53mpqruwrVAyasJqF+cDWZlFq+fbB8wSN+gTLQ6eXTZOfyiA1jFTFLv8xpZw1wKBgQCDpMrVUcpE5QIXRbWJ6zC5c1DpnkC96uMh1bwkxvcFZnaVOZYGMJNWoEWtsor3tR1r7cqzp+6o5dFt5ezD2CyZY/pcT//Qht5gEE3mxWeQOlEOyqoX7r3aWILrXSM20rv5nEpq1sNm1E/gpYAhitEsmsssdk47jPH82wTFxc/uUQKBgQDYCWvXIULD9jv/mIFP9dVaO23YyJ+wp0StthCas6XrTfgVigvhzJX52ETQAfVF1pkQyjXQlRKWXDhdP1qQk5/dJxE/CauboZEjlvi3zbx8iF7ueZ4f+ecKIcJhZO4TomQF+Dvd0niszM63UlvoNwr6uRewR/iSrcWISFwCpT/2Mg==";


    public static void main(String[] args) throws IcbcApiException {


     //   DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, "RSA", MY_PRIVATE_KEY, "UTF-8", "json", APIGW_PUBLIC_KEY, "AES", "GHMZ0T49qfgtZ46n4MpqcA==", (String)null, (String)null, (String)null, (String)null, (String)null);;
//
        DefaultIcbcClient client = new DefaultIcbcClient(APP_ID,MY_PRIVATE_KEY,APIGW_PUBLIC_KEY);
        UiIcbcClient client1 = new UiIcbcClient(APP_ID,MY_PRIVATE_KEY,"UTF-8");


        MybankPayCpayCppayapplyRequestV1 request = new MybankPayCpayCppayapplyRequestV1();
        request.setServiceUrl("https://apipcs3.dccnet.com.cn//api/mybank/pay/cpay/cppayapply/V1");
        MybankPayCpayCppayapplyRequestV1.MybankPayCpayCppayapplyRequestV1Biz bizContent = new
                MybankPayCpayCppayapplyRequestV1.MybankPayCpayCppayapplyRequestV1Biz();

        MybankPayCpayCppayapplyRequestV1.BeanGoodsInfo beanGoodsInfo = new
                MybankPayCpayCppayapplyRequestV1.BeanGoodsInfo();
        MybankPayCpayCppayapplyRequestV1.BeanRecvMallInfo beanRecvMallInfo = new
                MybankPayCpayCppayapplyRequestV1.BeanRecvMallInfo();
        List<MybankPayCpayCppayapplyRequestV1.BeanGoodsInfo> beanGoodsInfoList = new
                ArrayList<>();
        List<MybankPayCpayCppayapplyRequestV1.BeanRecvMallInfo> beanRecvMallInfoList = new
                ArrayList<>();


        beanGoodsInfo.setGoodsSubId("1");
        beanGoodsInfo.setGoodsName("shangpin");
        beanGoodsInfo.setPayeeCompanyName("1");
        beanGoodsInfo.setGoodsNumber("1");
        beanGoodsInfo.setGoodsUnit("1");
        beanGoodsInfo.setGoodsAmt("1");
        beanGoodsInfoList.add(beanGoodsInfo);
        beanRecvMallInfo.setMallCode("1");
        beanRecvMallInfo.setMccCode("1");
        beanRecvMallInfo.setMccName("1");
        beanRecvMallInfo.setBusinessLicense("1");
        beanRecvMallInfo.setBusinessLicenseType("0");
        beanRecvMallInfo.setMallName("mallname");
        beanRecvMallInfo.setPayeeCompanyName("1");
        beanRecvMallInfo.setPayeeSysflag("1");
        beanRecvMallInfo.setPayeeBankCode("1");
        beanRecvMallInfo.setPayeeAccno("1");
        beanRecvMallInfo.setPayAmount("1");
        beanRecvMallInfo.setPayeeBankCountry("840");
        beanRecvMallInfo.setRbankname("1");
        beanRecvMallInfo.setPayeeBankSign("1");
        beanRecvMallInfo.setPayeeCountry("1");
        beanRecvMallInfo.setPayeeAddress("1");
        beanRecvMallInfo.setRacaddress1("1");
        beanRecvMallInfo.setRacaddress2("1");
        beanRecvMallInfo.setRacaddress3("1");
        beanRecvMallInfo.setRacaddress4("1");
        beanRecvMallInfo.setRacpostcode("1");
        beanRecvMallInfo.setAgentbic("1");
        beanRecvMallInfoList.add(beanRecvMallInfo);
        bizContent.setPayMode("1");
        bizContent.setPayEntitys("1");
        bizContent.setPartnerSeq("1");
        bizContent.setAsynFlag("1");
        bizContent.setReservDirect("1");
        bizContent.setPayChannel("1");
        bizContent.setLogonId("");
        bizContent.setOrgcode("4334");
        bizContent.setAgreeCode("0020000002012345678912000000000011");
        bizContent.setReturnUrl("1");
        bizContent.setCallbackUrl("1");
        bizContent.setPayerAccname("1");
        bizContent.setPayerFeeAccno("1");
        bizContent.setPayerFeeAccName("1");
        bizContent.setPayerFeeCurr("1");
        bizContent.setPayMemno("1");
        bizContent.setPayerAccno("1");
        bizContent.setOrderCode("1");
        bizContent.setOrderAmount("1");
        bizContent.setOrderCurr("1");
        bizContent.setSumPayamt("1");
        bizContent.setSubmitTime("20190213151000");
        bizContent.setRceiptRemark("1");
        bizContent.setOrderRemark("1");
        bizContent.setInternationalFlag("1");
        bizContent.setPayeeList(beanRecvMallInfoList);
        bizContent.setGoodsList(beanGoodsInfoList);
        bizContent.setAgreementId("1");
        bizContent.setInvoiceId("1");
        bizContent.setManifestId("1");
        bizContent.setAgreementImageId("1");
        request.setBizContent(bizContent);



       String s = client1.buildPostForm(request);
        System.out.println(s);

        MybankPayCpayCppayapplyResponseV1 response = client.execute(request);
        System.out.println(JSONObject.toJSONString(response));
        if (response.isSuccess()) {
            // 业务成功处理
            System.out.println(response.getReturnCode());

        } else {
            // 失败
            System.out.println(response.getReturnCode());
            System.out.println(response.getReturnMsg());
        }



    }
}
