package icbc;

import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.IcbcConstants;
import com.icbc.api.request.AccountBillInfoQueryRequestV2;
import com.icbc.api.request.AccountBillInfoQueryRequestV2.AccountBillInfoQueryRequestV2Biz;
import com.icbc.api.response.AccountBillInfoQueryResponseV2;

/**
 * 信用卡账单信息查询接口
 * 
 * 请商户配置SDK中的lib文件夹中的jar包后，根据备注1-6提示进行数据替换
 */
public class AccountBillInfoQueryTest {

	//1、网关公钥
	protected static final String APIGW_PUBLIC_KEY ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwFgHD4kzEVPdOj03ctKM7KV+16bWZ5BMNgvEeuEQwfQYkRVwI9HFOGkwNTMn5hiJXHnlXYCX+zp5r6R52MY0O7BsTCLT7aHaxsANsvI9ABGx3OaTVlPB59M6GPbJh0uXvio0m1r/lTW3Z60RU6Q3oid/rNhP3CiNgg0W6O3AGqwIDAQAB";

	//2、appid
	protected static final String APP_ID = "10000000000001392000";

	//3、密钥对认证方式，公钥在API平台登记，此处为私钥
	protected static final String MY_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCghoYah5NstNhmKR37xk7GWiG7q+9+zvIyn+L7gpWC5IUSApJmESNRk0Z+y3rAQnIfp8/WFooOdQpHosFcYZySHD1+i8cxxJ22WY0E5IBkzjLg/4WkVsLPQQ0ShKfH6o6JIzeoroCjPCMSad4U2dPdC8nzGPm3q7Lq/XNShXUAtGEgq4M/4I1sNfO+riwAYdVydkUb0Sj4d4pCIyBbWwFjU6duHlMtojYxUL0qA6DAT+b8txncsWp5WUvNf9Nq0VzeXiqthzEv2DBEb2xKUONEPsgfqsYizk/+cBS7bgDzcQKa59qcaan6mK80tUnkVKBbGUHXDRe9q8t0yoaSN+zpAgMBAAECggEAVcIIervbYsPqqAlnX06+XvFf/CcKt7BPbARG+x70SQ1Umh6Nn8GgIMCRdMO4PGZDGe5I9pLsBnU4nLSyoGv1fYlgwO5j6I6lwvlsgSSiAzi1rcZU20sOoDKcjTwZdpA0vcb2wUMYrhw+kGPGpVUJ/pmBtkGthxZPa4MjzP5HV6wpSciQyKertfs8VDjrixTdNmCdFCXueVe3/yI8k0f9xzpLorX7tpiTXMbeFDnAlGX1ZH4sNWDPUAO4wCsAwrHSPL9EOSlstCc6RKRXpTAFgMOI//Hn3C3uH94p4hxOfmnzUr9ygVtVvYty+77SH0aBQh1+aLW/NCQJWd/ospCMAQKBgQD2bCRN3i8L3qz/bxYNg9JHnpV2RBSQrMhAWxPLr6h5Nln/rDHJScMW2fui58++8Q6c+ELVAItu5lPdOiUPMalTCN7sR8341MY/V3m3DdtuaWeItj2B/x7Ohh7IdAiTfQdaQk7F2zjL8RXn7PSV5Sd4ktQqTd3GlFtKEs7ZmS6RiQKBgQCmw7kdVOE8FDJHOv6/udSas7FnAohPpq+Kx/QxCV8rf04olW1iOg+KlJa90KqmEj3ap9xpr3OKf7mlphMTNRJ5+lZg4GcylSBIo4BO1LFGwXJci7ZiqHvPKpsa2Wk5rN4bXrC7moNDV7z58TKE7D+5McX66oShqjZKAQULkbKIYQKBgEe+2p8VRmtVTNcd97S9oZaalHeXgMlSlQcvvUa7gPixm2h2MRSi9jsMAli+11yHgLKxEXxEqVQDmX06tZmD4wG6/nSav1xoTsQYauaiETZHWA6UyLm1lrmYkRPZvLl8WIyt65NtrU6rha497kRKMMDJNx6OBzkO7rlVWoY+NDHJAoGAdWoy6Pr9Rq61o79e5CD0FyRT0MJQtTwYNq+IOApwLpEIt7xV8qYMkTcDV4wWyqznTg+IOgUlZat+S6o9nfVtF+LxdG4rWsrymxI7YcWRN882NQDNnnMgEQHfiSzwUIJtM3odF0m4B+87iAOR3VL1nu/zhDIgxi6w4LQNGFMyD6ECgYBP6QC/Kjk7pEcsUR71Vr6ez2G4g4dZhg+FBBJ4neSCN3owyeW3IPVF2NKr31GmyPlP4smjYHDYWPCu3gpsho+tgC5uW5igPtryM0De6NzlatrRCrkQwx/MjBVToOHcFWHV2WyaofPmslwIvhPiWS+JoWUs5dBBTMx6eGusFnvcSQ==";

	public static void main(String[] args) throws Exception {

		//签名类型为RSA2时，需传入appid，私钥和网关公钥，签名类型使用定值IcbcConstants.SIGN_TYPE_RSA2，其他参数使用缺省值
		DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, IcbcConstants.SIGN_TYPE_RSA2, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
		
		AccountBillInfoQueryRequestV2 request = new AccountBillInfoQueryRequestV2();
		
		//4、根据测试环境和生产环境替换相应ip和端口
		request.setServiceUrl("https://gw-sandbox.open.icbc.com.cn/api/account/bill/info/query/V2");

		//5、请对照接口文档用bizContent.setxxx()方法对业务上送数据进行赋值
		AccountBillInfoQueryRequestV2Biz bizContent = new AccountBillInfoQueryRequestV2Biz();
		bizContent.setCompanyCode("AESJD00021");
		bizContent.setChannelCode("3320");
		bizContent.setPageCode("SS620");
		bizContent.setCardNo("6222350027751195");
		bizContent.setAccBillDate("201806");
		bizContent.setSemiYearFlag("");
		request.setBizContent(bizContent);

		AccountBillInfoQueryResponseV2 response;
		try {
			response = client.execute(request, "msgId");//msgId消息通讯唯一编号，要求每次调用独立生成，APP级唯一
			if (response.isSuccess()) {
				//6、业务成功处理，请根据接口文档用response.getxxx()获取同步返回的业务数据
				System.out.println("ReturnCode:"+response.getReturnCode());
				System.out.println("response:" + response);
			} else {
				//失败
				System.out.println("ReturnCode:"+response.getReturnCode());
				System.out.println("ReturnMsg:"+response.getReturnMsg());
			}		
		} catch (IcbcApiException e) {
			e.printStackTrace();
		}
	}

	
}


