package icbc;

import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.UiIcbcClient;
import com.icbc.api.internal.util.internal.util.fastjson.JSONObject;
import com.icbc.api.request.MybankPayCpayCppayapplyRequestV1;
import com.icbc.api.response.MybankPayCpayCppayapplyResponseV1;

import java.util.ArrayList;
import java.util.List;


public class IcbcEpay {

    //1、网关公钥
    protected static final String APIGW_PUBLIC_KEY ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwFgHD4kzEVPdOj03ctKM7KV+16bWZ5BMNgvEeuEQwfQYkRVwI9HFOGkwNTMn5hiJXHnlXYCX+zp5r6R52MY0O7BsTCLT7aHaxsANsvI9ABGx3OaTVlPB59M6GPbJh0uXvio0m1r/lTW3Z60RU6Q3oid/rNhP3CiNgg0W6O3AGqwIDAQAB";

    //2、appid
    protected static final String APP_ID = "10000000000000100000";

    //3、密钥对认证方式，公钥在API平台登记，此处为私钥
    protected static final String MY_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCghoYah5NstNhmKR37xk7GWiG7q+9+zvIyn+L7gpWC5IUSApJmESNRk0Z+y3rAQnIfp8/WFooOdQpHosFcYZySHD1+i8cxxJ22WY0E5IBkzjLg/4WkVsLPQQ0ShKfH6o6JIzeoroCjPCMSad4U2dPdC8nzGPm3q7Lq/XNShXUAtGEgq4M/4I1sNfO+riwAYdVydkUb0Sj4d4pCIyBbWwFjU6duHlMtojYxUL0qA6DAT+b8txncsWp5WUvNf9Nq0VzeXiqthzEv2DBEb2xKUONEPsgfqsYizk/+cBS7bgDzcQKa59qcaan6mK80tUnkVKBbGUHXDRe9q8t0yoaSN+zpAgMBAAECggEAVcIIervbYsPqqAlnX06+XvFf/CcKt7BPbARG+x70SQ1Umh6Nn8GgIMCRdMO4PGZDGe5I9pLsBnU4nLSyoGv1fYlgwO5j6I6lwvlsgSSiAzi1rcZU20sOoDKcjTwZdpA0vcb2wUMYrhw+kGPGpVUJ/pmBtkGthxZPa4MjzP5HV6wpSciQyKertfs8VDjrixTdNmCdFCXueVe3/yI8k0f9xzpLorX7tpiTXMbeFDnAlGX1ZH4sNWDPUAO4wCsAwrHSPL9EOSlstCc6RKRXpTAFgMOI//Hn3C3uH94p4hxOfmnzUr9ygVtVvYty+77SH0aBQh1+aLW/NCQJWd/ospCMAQKBgQD2bCRN3i8L3qz/bxYNg9JHnpV2RBSQrMhAWxPLr6h5Nln/rDHJScMW2fui58++8Q6c+ELVAItu5lPdOiUPMalTCN7sR8341MY/V3m3DdtuaWeItj2B/x7Ohh7IdAiTfQdaQk7F2zjL8RXn7PSV5Sd4ktQqTd3GlFtKEs7ZmS6RiQKBgQCmw7kdVOE8FDJHOv6/udSas7FnAohPpq+Kx/QxCV8rf04olW1iOg+KlJa90KqmEj3ap9xpr3OKf7mlphMTNRJ5+lZg4GcylSBIo4BO1LFGwXJci7ZiqHvPKpsa2Wk5rN4bXrC7moNDV7z58TKE7D+5McX66oShqjZKAQULkbKIYQKBgEe+2p8VRmtVTNcd97S9oZaalHeXgMlSlQcvvUa7gPixm2h2MRSi9jsMAli+11yHgLKxEXxEqVQDmX06tZmD4wG6/nSav1xoTsQYauaiETZHWA6UyLm1lrmYkRPZvLl8WIyt65NtrU6rha497kRKMMDJNx6OBzkO7rlVWoY+NDHJAoGAdWoy6Pr9Rq61o79e5CD0FyRT0MJQtTwYNq+IOApwLpEIt7xV8qYMkTcDV4wWyqznTg+IOgUlZat+S6o9nfVtF+LxdG4rWsrymxI7YcWRN882NQDNnnMgEQHfiSzwUIJtM3odF0m4B+87iAOR3VL1nu/zhDIgxi6w4LQNGFMyD6ECgYBP6QC/Kjk7pEcsUR71Vr6ez2G4g4dZhg+FBBJ4neSCN3owyeW3IPVF2NKr31GmyPlP4smjYHDYWPCu3gpsho+tgC5uW5igPtryM0De6NzlatrRCrkQwx/MjBVToOHcFWHV2WyaofPmslwIvhPiWS+JoWUs5dBBTMx6eGusFnvcSQ==";

    public static void main(String[] args) throws IcbcApiException {
//        DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
        UiIcbcClient client1 = new UiIcbcClient(APP_ID,MY_PRIVATE_KEY,"UTF-8");
        MybankPayCpayCppayapplyRequestV1 request = new MybankPayCpayCppayapplyRequestV1();
        request.setServiceUrl("https://apipcs3.dccnet.com.cn/api/mybank/pay/cpay/cppayapply/V1");

        MybankPayCpayCppayapplyRequestV1.MybankPayCpayCppayapplyRequestV1Biz bizContent = new MybankPayCpayCppayapplyRequestV1.MybankPayCpayCppayapplyRequestV1Biz();
        MybankPayCpayCppayapplyRequestV1.BeanGoodsInfo beanGoodsInfo = new MybankPayCpayCppayapplyRequestV1.BeanGoodsInfo();
        MybankPayCpayCppayapplyRequestV1.BeanRecvMallInfo beanRecvMallInfo = new MybankPayCpayCppayapplyRequestV1.BeanRecvMallInfo();

        List<MybankPayCpayCppayapplyRequestV1.BeanGoodsInfo> beanGoodsInfoList = new ArrayList<MybankPayCpayCppayapplyRequestV1.BeanGoodsInfo>();
        List<MybankPayCpayCppayapplyRequestV1.BeanRecvMallInfo> beanRecvMallInfoList = new ArrayList<MybankPayCpayCppayapplyRequestV1.BeanRecvMallInfo>();
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
//
//        MybankPayCpayCppayapplyResponseV1 response = client.execute(request);
//        System.out.println(JSONObject.toJSONString(response));
//        if (response.isSuccess()) {
//            // 业务成功处理
//            System.out.println(response.getReturnCode());
//        } else {
//            // 失败
//            System.out.println(response.getReturnCode());
//            System.out.println(response.getReturnMsg());
//        }




    }
}
