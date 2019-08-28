
### 工银e企付解保留撤销服务


###### 1 功能说明
合作方平台通过工商银行的开放化服务，发起保留支付撤销申请，实现资金解控至付方账号。

###### 2 请求路径
| 环境         | HTTPS请求地址 |
| ------------ | ------------------------ |
| 正式环境 | https://gw.open.icbc.com.cn/api/mybank/pay/cpay/cppreservationcancel/V1 |




###### 3 通用请求参数：
| 参数名 | 类型 | 是否必输 | 最大长度 | 描述 | 示例值 |
| -------------------- | ---- | -------- | -------- | ---------------------- | ------------------------   |
| app_id | str | true | 20 | APP的编号,应用在API开放平台注册时生成 | Oikeclo001 |
| msg_id | str | true | 40 | 消息通讯唯一编号，每次调用独立生成，APP级唯一 | urcnl24ciutr9 |
| format | str | false | 5 | 请求参数格式，仅支持json | json |
| charset | str | false | 10 | 字符集 ,缺省为UTF-8 | UTF-8 |
| encrypt_type | str | false | 5 | 现在仅支持AES，部分接口支持加密，如接口无需加密，参数中此字段无需上送 | AES |
| sign_type | str | false | 5 | 签名类型，CA-工行颁发的证书认证，RSA-RSAWithSha1，RSA2-RSAWithSha256，缺省为RSA | RSA  |
| sign | str | true | 300 | 报文签名 | ERITJKEIJKJHKKKHJEREEEEEE |
| timestamp | str | true | 19 | 交易发生时间戳，yyyy-MM-dd HH:mm:ss格式 | 2016-10-29 20:44:38 |
| ca | str | false | 2048 | 采用ca认证方式时，需上送证书 | FSGFRHRGHTHTFDFER |
| biz_content | str | true | - | 请求参数的集合 | - |

###### 4 请求参数

| 参数名           | 类型 | 是否必输 | 最大长度 | 描述                                                         | 示例值                                         |
| ---------------- | ---- | -------- | -------- | ------------------------------------------------------------ | ---------------------------------------------- |
| agreeCode        | str  | true     | 34       | 合作方协议编号                                               | AGREECODE20190215                              |
| orderCode        | str  | true     | 34       | 订单编号                                                     | 20190215                                       |
| partnerSeq       | str  | true     | 34       | 合作方交易流水号（每笔交易必须唯一）                         | 12                                             |
| partnerSeqOrigin | str  | true     | 34       | 原交易流水号（原保留支付的交易流水号）                       | 1                                              |
| payAmount        | str  | false    | 17       | 本次解保留金额（单位：分；境外支付场景不送，仅支持全额解保留支付） | 1                                              |
| orderCurr        | str  | true     | 3        | 交易币种（输入订单币种）                                     | 详见4.1币种表                                  |
| payeeAccno       | str  | false    | 34       | 收款人账号                                                   | 020019900333。保留时有多个收款方该字段必须上送 |
| payeeCompanyName | str  | false    | 140      | 收款人户名                                                   | 华为旗舰店。保留时有多个收款方该字段必须上送   |
| submitTime       | str  | true     | 14       | 交易平台提交时间（yyyyMMddHHmmss）                           | 20190228230000                                 |
| orderRemark      | str  | false    | 140      | 订单备注                                                     | 备注20190215                                   |
###### 4.1 币种表

| 币种中文名     | 币种代码 | 金额单位             |
| -------------- | -------- | -------------------- |
| 人民币         | 1        | 分                   |
| 美元           | 14       | 分                   |
| 欧元           | 38       | 分                   |
| 日元           | 27       | 分（1日元需上送100） |
| 港币           | 13       | 分                   |
| 新加坡元       | 18       | 分                   |
| 加元           | 28       | 分                   |
| 澳门币         | 81       | 分                   |
| 新西兰元       | 87       | 分                   |
| 澳元           | 29       | 分                   |
| 英镑           | 12       | 分                   |
| 丹麦克朗       | 22       | 分                   |
| 瑞典克朗       | 21       | 分                   |
| 挪威克朗       | 23       | 分                   |
| 瑞士法郎       | 15       | 分                   |
| 泰株           | 84       | 分                   |
| 卢布           | 70       | 分                   |
| 南非兰特       | 88       | 分                   |
| 科威特第纳尔   | 104      | 分                   |
| 马来西亚林吉特 | 32       | 分                   |
| 哈萨克斯坦坚戈 | 89       | 分                   |
| 韩国元         | 103      | 分                   |

###### 5 响应参数说明                                                                                                                 
| 参数名        | 类型 | 是否必输 | 最大长度 | 描述           | 示例值                                                       |
| ------------- | ---- | -------- | -------- | -------------- | ------------------------------------------------------------ |
| serialNo | str | true | 34 | 银行指令序号 | 2019022817160974800000000000086005 |
| agreeCode     | str  | true     | 34       | 合作方协议编号 | AGREECODE20190215 |
| partnerSeq | str  | true     | 34       | 合作方交易流水号 | 12 |
| orderCurr     | str  | true     | 3        | 订单币种       | 001 |
| payAmount | str | false    | 17       | 本次解保留金额（单位：分） | 1 |
| status        | str  | true     | 3        | 状态：1-处理成功；2-处理失败；3-银行处理中; | 1 |
| return_code   | int | true     | 12       | 返回码（交易成功返回0，正表示业务报错，负表示系统报错，负值时须考虑） | 0 |
| return_msg    | str  | true     | 200      | 返回描述       |  |





###### 6 使用示例
```java
package com.icbc.api.test;

import java.util.Random;

import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.IcbcConstants;
import com.icbc.api.request.MybankPayCpayCppreservationcancelRequestV1;
import com.icbc.api.request.MybankPayCpayCppreservationcancelRequestV1.MybankPayCpayCppreservationcancelRequestV1Biz;
import com.icbc.api.response.MybankPayCpayCppreservationcancelResponseV1;

public class MybankPayCpayCppreservationcancelTest {
	protected static final String MY_PRIVATE_KEY = "BKcYpFbllOCOFO9edvl82KOEtxYeppjGtvtmQELrK6D1SG70UGbJtRlYT9zaUNoD2jz8/IaaSh9YDoTm2e2wbFXnpEuzbmAXI4M8fxzcn3gD+UEs4eZcss+6p7PVyWu3hVfMD9sMLMOnrGsXpJG9xHnBa4DKKY6zzTOGbnblXIqI3tzWYop9jf2ggm+0fY/ns3iz78bOX/9Xocx0PdFT0RP+rxrnzY9ObCeVZieHXo5vekttMat+B4l0uRKsg1/QZ79OMb5amhFgliuXvnQ6MDXvUgz99LgjRKUqI6eln4eXm1azecXXbhupuhY5mvOxe08MfNSw4Fj/2oTQvUQky+ibZKQMQWOCMPxVZ3C3/GVh1XBYUgcGWKovMTPadyesSy0/2jZ4M5Vy+XKLmlgywYXbhUXQ/7FucHxQmjl+y5mtr1Ne/O4wFZ90A2BhDKacqpgezdzQLJKpgDDI1DFLKcdIimGFzmAHvgTAeTHfqGQYYYRRRfZ+emNo0U0VkmFoobaoh0Tuf1VkthATjupVptx3UpWULnwMrRrGQgjRn+HR8mXAIPkUdhXQ/eQTZ9CP4N21iZO+91Mtbc0gJZQ9svqmSOKhruOtuTN0OhyvxE2SEMoMbRqp0Gk9kp1ACk9Rqd35nYbIXKvbteBFI1eVn2JuqFybySG1LZU/M2M751twkt1AGZ6SKa2EyCJRE/svfi0vzW4rSrxoSXJCKM2+YAfkgc08c1LgSEIvBu7c1xVTph8wylm4OQAEUfXZCAwb++uwvtj/EGFDGdHiKiF5QOU03pjQwj8TMFwYEN+6+PwleAlfExT78XDi6NAlvUhlYPq5Xmb/S5I+xQoHr1ghsdnPzMdIgZY33uFlUSX/0HWxSIzMfQbIn1IFq/PPxIxo18oqA8IKEZe7FvIlfNq4phM2C2XTpaKFvFqbzS2tbSJXOUonxrFB/kdZXDM1yMCI+UmnQETl4ndpvsTV6EQEhQpXrR0zp0XgJzItrfcABSjtstqJtyNo/si+xxPjU6O8xn7YLi/RlC//Se+YF12WoOTurakJruuGR1dynFSv2zp74OFSKv+eaODnzDBvI8vdq/jB0z8LTa9HY4h/+bsujyJz3IcOam+Yyxf3h53/82EPZ69vzRn+kUzoSm2yBUi9ISS3bSpfnfBhyOLIT2g6m+3Ho/lEsnZTjvjTstslJpyX3TyyQRtvLWv2X49wAIETQsWksurcrQWUsfLETHvwCQE1rF1GNWho1qfupagqxJt0z9+5v1WofbVQBsyphX2HOQP9advd4r53EZrMSh3/Isn9BN6iU67Ebp16WhYI2QwCmwFR1nzo5QxASV/dPNClFxrIPa5nubLTL495UEhhn4A3HJs20RCRXcetYQ/bVYA6uqPIP76pr8mXg4W9eDvoWJb1Y9aor2JxdbtY/0/OwPnnyDMMO8u5kVqxaY4Es+a43WXat0Cs+/vTMFR9v/MVV7MOWGD9RwvMAnTMFfiOCSUKFWfPGd2o7wyY4+aCUOnI+L6nmrqfuYFAwP7Bi/QmK80yXDXI1078LBjGlICSoGFIjsyJ1wQec5H1rg5UHF7qt28qkVsxMok=";

	protected static final String APIGW_PUBLIC_KEY = "MIIDljCCAn6gAwIBAgIKbaHKEE0tAAI7+jANBgkqhkiG9w0BAQsFADA3MRkwFwYDVQQKExBjb3JiYW5rNDMuY29tLmNuMRowGAYDVQQDExFjb3JiYW5rMTI4IHNkYyBDTjAeFw0xODEwMzEwNTM3MzFaFw0yOTAxMzEwNTM3MzFaMEkxHTAbBgNVBAMMFDAyMDBFSDAwMTMwMzUuZS4wMjAwMQ0wCwYDVQQLDAQwMjAwMRkwFwYDVQQKDBBjb3JiYW5rNDMuY29tLmNuMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnqvltq3gG1eVgTJ547CNI0jfzgC6GphVQyE7YzhHwJLnufTBAx/Zezg9M+R1UJWqg3R+WYPu4VXpkaIz0N/0obG5FkMFqyViz8ZSwUHcntLK5R65vBbbJ/UVcAe3GYpIBONB7ApeLuWjh5SZ0Bq8rXZ/DVjg/JMbBnqG50rbjETRHsaLODn447yJMK4H3wEq9DaRHH8xEkd01qv3lnRb0PpU78EWyMwoyHgvo7GLuR0sAjOeRAqNeYrenm2rG+UGyYsT9/K4Lw6H2fAfdtFUMaAQ+q3p+qQpPfMJXRTXLgTfQTdlqweVIppYFMNp1IkwbWtqbXliN4rCknj1VxjNaQIDAQABo4GRMIGOMB8GA1UdIwQYMBaAFJ6AEaO7V853/fEnZ/7k4X8i8lHzMEwGA1UdHwRFMEMwQaA/oD2kOzA5MQ0wCwYDVQQDDARjcmwzMQ0wCwYDVQQLDARjY3JsMRkwFwYDVQQKDBBjb3JiYW5rNDMuY29tLmNuMB0GA1UdDgQWBBQEmtl3SpIDUN49NC3V+kprWYraTTANBgkqhkiG9w0BAQsFAAOCAQEAQKBKbgxSwRoZbqgOza+CZFcP3Sp16x2Yek1C5nlcX5REHCinbNVeMKmqnTEl8DK/XX0f/nuj+5WPsSMeQ1ltSjfMm1NAJNwwTqdq1zU5jK4YCA0dZhj90pooVgcXu152erCcP2lHncAk3xrVxgMWIL82sYQu3pE/TmEc6K6ofuPzcCdNxoAJpn82qYuCxNQUxu3fKdZsEpwt0sgJBhSiVkzxUMK9GcEXz177f6ktivJfw61VKZUq3BQXv9VvuprLEeCC9xJLX7quph/Nl9Q/4/4NU2dRFqXdWgpW98exaKQv6g2+a9f7PqW+cAKVEOZvvkdDzxkntv7yrccFEDJi6w==";

	protected static final String APP_ID = "0200EH0013035"; 

	public static void main(String[] args) {

   DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
		
		// 设置请求对象request
		MybankPayCpayCppreservationcancelRequestV1 req = new MybankPayCpayCppreservationcancelRequestV1();
		
		// 设置请求路径
		req.setServiceUrl("http://IP:PORT/api/mybank/pay/cpay/cppreservationcancel/V1");

		MybankPayCpayCppreservationcancelRequestV1Biz biz = new MybankPayCpayCppreservationcancelRequestV1Biz();
		
        biz.setAgreeCode("AGREECODE20190215");//合作方协议编号
        biz.setOrderCode("20190215");//订单编号
        biz.setPartnerSeq("12");//合作方支付流水号
        biz.setPartnerSeqOrigin("1");//原合作方支付流水号
        biz.setPayAmount("1");//本次解保留金额
        biz.setOrderCurr("001");//交易币种
        biz.setSubmitTime("20190215090400");//交易平台提交时间
        biz.setOrderRemark("备注20190215");//订单备注
        biz.setPayeeAccno("0200062009212098448-000000014");//收款账号
        biz.setPayeeCompanyName("3065脚本账户名称_普通存款人民币");//收款人户名

		req.setBizContent(biz);
		MybankPayCpayCppreservationcancelResponseV1 response = new MybankPayCpayCppreservationcancelResponseV1();

		Random rand = new Random();
		String msgId = rand.nextInt(99999) + "msg";
		System.out.println(msgId);

		try {
			response = client.execute(req, msgId);
			System.out.println("response:" + response.toString());
			if (response.isSuccess()) {
				// 业务成功处理
				System.out.println("success");//
			} else {
				// 失败
				System.out.println("error");
			}
		} catch (IcbcApiException e) {
			e.printStackTrace();
		} finally {
		}
	}
}

```

###### 7 请求示例
```json
POST HTTP/1.1
Content-Type: application/x-www-form-urlencoded; charset=UTF-8

https://gw.open.icbc.com.cn/api/mybank/pay/cpay/cppreservationcancel/V1?app_id=Oikeclo001&msg_id=urcnl24ciutr9&format=json&charset=utf-8&sign_type=RSA&sign=TRFEWHYUFCEW&timestamp=2016-10-29 20:44:38&biz_content=
{
   "agreeCode": "AGREECODE20190215",
	"orderCode": "20190215",
	"partnerSeq": "12",
	"partnerSeqOrigin": "1",
	"payAmount": "1",
	"orderCurr": "001",
	"submitTime": "20190228230000",
	"orderRemark": "备注20190215",
     "payeeAccno":"0200062009212098448-000000014",
     "payeeCompanyName":"3065脚本账户名称_普通存款人民币"
}

```

###### 8 响应示例
```json
HTTP/1.1 200 OK 
Content-Type: application/json; charset=UTF-8

{
   "response_biz_content":{
        "return_code": "0",
        "return_msg": "",
        "agreeCode": "AGREECODE20190215",
        "orderCurr": "001",
        "partnerSeq": "12",
        "payAmount": 1,
        "orderCurr": "001",
        "status": "1"},
  "sign":"ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE"
  
}


```

###### 9 异常示例
```json
HTTP/1.1 200 OK 
Content-Type: application/json; charset=UTF-8

{
    "response_biz_content":{
	   "return_code":500020,
	   "return_msg":"非法调用"},
  "sign":"ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE"
 
}

```

###### 10 返回码解释
|	返回码	|	返回说明	|
| ------------ | ------------ |
|	0	| 成功 |
|	-31	| 响应请求转换失败 |
|	-30	| 服务方响应状态错误	 |
|	400011	| 参数非法，原因可能为app id为空、app id非法、签名为空、应用系统时间与API平台系统时间不在限定差值以内、时间戳非法 |
|	500018	| 访问的API不存在	|
|	500020	| 非法调用	|
|	400016	| app公钥未维护	|
|	400017	| 签名验证失败	|
|	400019	| 授权验证失败	|
|	500031	| 速率超限	|
|	500032	| 并发超限	|
|	-500041	| 代理异常	|
|	-500042	| 代理超时	|
|	-500044	| 网关签名失败	|
|	500043	| 网关配置文件错误，无法从配置文件中读取配置	|
|	400051	| app id前缀错误，沙箱测试时app id必须添加sandboxie_前缀	|
|	500052	| 沙箱测试不支持UI类型的API	|
|	500091	| 没有管理权限	|
|	-500099	| 网关内部异常	|
|	5205	| 系统繁忙，请您稍后重试	|
|	9990	| 字段检查失败	|
|	80003001	| 渠道不正确	|
|	80004001	| 渠道不正确	|
|	80008013	| 业务逻辑错误	|


###### 
