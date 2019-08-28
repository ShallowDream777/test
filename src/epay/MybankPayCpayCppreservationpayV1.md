
### 工银e企付解保留支付服务


###### 1 功能说明
合作方平台通过工商银行的开放化服务，发起保留支付确认支付申请，实现资金解控并划拨至收方账号。

###### 2 请求路径
| 环境         | HTTPS请求地址 |
| ------------ | ------------------------ |
| 正式环境 | https://gw.open.icbc.com.cn/api/mybank/pay/cpay/cppreservationpay/V1 |




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

| 参数名           | 类型 | 是否必输 | 最大长度 | 描述                                                         | 示例值                       |
| ---------------- | ---- | -------- | -------- | ------------------------------------------------------------ | ---------------------------- |
| agreeCode        | str  | true     | 34       | 合作方协议编号，联系银行获取                                        | 合作方签约协议编号           |
| orderCode        | str  | true     | 34       | 订单编号，合作方系统生成订单编号 | alipay112233                 |
| partnerSeq | str  | true     | 34       | 合作方交易流水号（每笔交易必须唯一）                         | alipay112233101              |
| partnerSeqOrigin | str  | true     | 34       | 原合作方支付流水号（原保留的支付申请流水号）                 | alipay112233100              |
| payAmount        | str | false    | 17       | 本次解保留划拨金额（单位：分；境外支付场景无需上送，全额解保留支付） | 100                          |
| orderCurr        | str  | true     | 3        | 交易币种                                                     | 详见4.1币种表                 |
| payeeSysflag     | str  | true     | 3        | 收款方系统内外标志（1-境内工行，2-境内他行，3-境外；收方保留场景，收款方只支持境内工行） | 1                            |
| payeeAccno       | str  | true     | 34       | 收款人账号                                                   | 020019900333                 |
| payeeCompanyName | str  | true     | 140      | 收款人户名                                              | 华为旗舰店                   |
| payeeBankCode    | str  | false    | 12       | 收方行联行号（收款方系统内外标志为2时必输）                  | 102585002171                 |
| submitTime       | str  | true     | 14       | 交易平台提交时间                                             | 20190227212900               |
| orderRemark      | str  | false    | 140     | 订单备注                                                     | 页面展示 |
| receiptRemark    | str  | false    | 140      | 回单补充信息备注                                             | 当需要打印在回单信息中时上送 |

###### 4 .1 币种表

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
| serialNo | str | true | 34 | 银行指令序号，支付申请唯一编号 | 030240009650001674589821420 |
| agreeCode     | str  | true     | 34       | 合作方协议编号 |                                                              |
| partnerSeq | str  | true     | 34       | 合作方流水号   |                                                              |
| orderCurr     | str  | true     | 3        | 订单币种       |                                                              |
| payAmount | str | false    | 17       | 本次解保留划拨金额（单位：分） |                                                              |
| status        | str  | true     | 3        | 状态：1-成功 2-失败 3-银行处理中 | 1                        |
| return_code   | int | true     | 12       | 返回码（交易成功返回0，正表示业务报错，负表示系统报错，负值时须考虑 ） |                                                              |
| return_msg    | str  | true     | 200      | 返回描述       |                                                              |





###### 6 使用示例	
```java
		DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
		
		PayApplyRequestV1 request = new PayApplyRequestV1();
		request.setServiceUrl("http://IP:PORT/api/mybank/pay/cpay/cppreservationpay/V1");
		
		PayApplyRequestV1.PayApplyRequestV1Biz bizContent = new PayApplyRequestV1.PayApplyRequestV1Biz();
		
		bizContent.setAgreeCode("0");
		bizContent.setOrderCode("0");
		bizContent.setPartnerSeq("0");
		bizContent.setPartnerSeqOrigin("0");
		bizContent.setPayAmount("1");
		bizContent.setOrderCurr("1");
		bizContent.setPayeeSysflag("1");
		bizContent.setPayeeAccno("0");
		bizContent.setPayeeCompanyName("1");
		bizContent.setPayeeBankCode("1");
		bizContent.setSubmitTime("1");
		bizContent.setOrderRemark("1");
		bizContent.setReceiptRemark("1");
		bizContent.setPurpose("1");
		bizContent.setSummary("1");
		
		request.setBizContent(bizContent);
		
		PayApplyResponseV1 response = client.execute(request);
		
		System.out.println(JSONObject.toJSONString(response));
		if (response.isSuccess()) {
			// 业务成功处理
			System.out.println(response.getReturnCode());
		} else {
			// 失败
			System.out.println(response.getReturnCode());
			System.out.println(response.getReturnMsg());
		}
```

###### 7 请求示例
```json
POST HTTP/1.1
Content-Type: application/x-www-form-urlencoded; charset=UTF-8

https://gw.open.icbc.com.cn/api/mybank/pay/cpay/cppayapply/V1?app_id=Oikeclo001&msg_id=urcnl24ciutr9&format=json&charset=utf-8&sign_type=RSA&sign=TRFEWHYUFCEW&timestamp=2016-10-29 20:44:38&biz_content=
{
    "agreeCode": "1",
    "orderCode": "1",
    "partnerSeq": "1",
    "partnerSeqOrigin": "1",
    "payAmount": "1",
    "orderCurr": "1",
    "payeeSysflag": "1",
    "payeeAccno": "1",
    "payeeCompanyName": "1",
    "payeeBankCode": "1",
    "submitTime": "2019",
    "orderRemark": "1",
    "receiptRemark": "1"
}


```

###### 8 响应示例
```json
HTTP/1.1 200 OK 
Content-Type: application/json; charset=UTF-8

{
    "response_biz_content": {
        "serialNo": "0",
        "agreeCode": "0",
        "partnerSeq": "0",
        "orderCurr": "0",
        "payAmount": "1",
        "status": "1",
        "return_code": "02313",
        "return_msg": "11313231"
    },
    "sign": "FTGECGYUYTGREVCIKKIU"
}

```

###### 9 异常示例
```json
HTTP/1.1 200 OK 
Content-Type: application/json; charset=UTF-8

{
  "response_biz_content":{
	   "return_code":500020,
	   "return_msg":"非法调用"
   },
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
|	80008001	| 业务逻辑错误	|


###### 
