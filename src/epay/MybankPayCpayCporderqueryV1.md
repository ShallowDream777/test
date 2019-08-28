
### 工银e企付支付申请查询服务
###### 1 适用场景
该服务用于合作方对接工行工银e企付产品，发起支付申请后，对支付申请主动发起查询。

###### 2 请求路径

| 环境     | 地址                                                         |
| -------- | ------------------------------------------------------------ |
| 正式环境 | https://gw.open.icbc.com.cn/api/mybank/pay/cpay/cporderquery/V1 |

###### 3 通用请求参数
| 参数                 | 类型 | 是否必输 | 最大长度 | 描述                                           | 示例值      	             |
| -------------------- | ---- | -------- | -------- | -----------------------------------------------| ------------------------- |
| app_id               | str  | true     | 20       | APP的编号,应用在API开放平台注册时生成          | Oikeclo001                |
| msg_id               | str  | true     | 40       | 消息通讯唯一编号，每次调用独立生成，APP级唯一  | urcnl24ciutr9             |
| format               | str  | false    | 5        | 请求参数格式，仅支持json                       | json                      |
| charset              | str  | false    | 10       | 字符集 ,缺省为UTF-8                            | UTF-8                     |
| encrypt_type         | str  | false    | 5        | 现在仅支持AES，部分接口支持加密，如接口无需加密，参数中此字段无需上送                           | 无                     |
| sign_type            | str  | false    | 5        | 签名类型，CA-工行颁发的证书认证，RSA-RSAWithSha1，RSA2-RSAWithSha256，缺省为RSA | RSA |
| sign                 | str  | true     | 300      | 报文签名                                       | ERITJKEIJKJHKKHJEREEEEEEEEEEE |
| timestamp            | str  | true     | 19       | 交易发生时间戳，yyyy-MM-dd HH:mm:ss格式        | 2016-10-29 20:44:38       |
| ca                   | str  | false    | 2048     | 采用ca认证方式时，需上送证书                   | FSGFRHRGHTHTFDFER         |
| biz_content          | str  | true     | -        | 请求参数的集合                                 |    -                      |

###### 4 请求参数

| 参数名     | 类型 | 是否必输 | 最大长度 | 描述                                 | 示例值 |
| ---------- | ---- | -------- | -------- | ------------------------------------ | ------ |
| agreeCode  | str  | true     | 34       | 合作方协议编号，需跟工行客户经理获取 | 12345  |
| orderCode  | str  | true     | 34       | 订单号                               | 1234   |
| partnerSeq | str  | true     | 34       | 交易流水号                           | 123456 |

###### 5 公共响应参数                                                                                                                   
| 参数                 | 类型 | 是否必输  | 最大长度 | 描述                                           | 示例值      	              |
| -------------------  | ---- | --------- | -------- | -----------------------------------------------| -------------------------   |
| response_biz_content | str  | true      | -        | 返回参数集合                                   |                             |
| sign                 | str  | true      | 300      | 针对返回参数集合的签名                         | -                           |

###### 6 响应参数                                                                                                                          
| 参数                 | 类型   | 是否必输  | 最大长度 | 描述  	                                                          | 示例值      	              |
| -------------------  | -----  | --------- | -------- | -----------------------------------------------------------------| -------------------------   |
| return_code          | int    | true      | 10       |       |返回码，交易成功返回0，正表示业务报错，负表示系统报错，负值时须考虑疑帐|
| return_msg           | str    | true      | -        | 返回码说明                                                       |                             |
| serialNo             | str    | true      | 34       | 银行指令序号                                                     | 2019021314280026            |
| agreeCode            | str    | true      | 34       | 合作方协议编号                                                   | 000000000009000000000185016  |
| agreeName | str | true | 140 | 平台名称 | 路飞 |
| partnerSeq | str    | true      | 34       | 合作方支付流水号                                                 | 20190470026                 |
| payMode         | str    | true      | 3        | 支付方式                                                         | 1-直接支付2-保留支付         |
| payType | str | true | 3 | 支付申请类型 | 当支付方式为1时：101-支付  当支付方式为2时：201-保留，202-解保留撤销，203-解保留支付 |
| orderAmount  | str    | true      | 17       | 订单金额                                                         | 详见6.5币种表             |
| orderCurr            | str    | true      | 3        | 订单币种                                                         | 详见6.5币种表                 |
| sumPayamt            | str    | true      | 17       | 本次支付金额                                                     | 详见6.5币种表                |
| source               | str    | true      | 3        | 资金来源                                                         | 0：现汇；1：购汇；2：其他；3：现汇和购汇。    |
| accrualCny           | str    | true      | 17       | 购汇金额                                                         | 详见6.5币种表                 |
| accrualForeign       | str    | true      | 17       | 现汇金额                                                         | 详见6.5币种表                 |
| payerAccno           | str    | true      | 34       | 人民币付方账号                                                   | 2000298092000024            |
| payerAccname         | str    | true      | 140      | 人民币付方户名                                                   | 人民币付方户名24            |
| payerAccnoForeign | str | true | 34 | 外币付方账号 | 2000298092000024 |
| payerAccnameForeign | str | true | 140 | 外币付方户名 | 外币户名 |
| payStatus | str | true | 3 | 支付申请状态 | 1-成功 2-失败 3-处理中 4-部分成功（当支付方案中所有记录状态为成功时，该笔支付申请状态为成功；当支付方案中所有记录状态为失败时，该笔支付申请状态为失败；当支付方案中所有记录状态均为成功或或者失败，不存在处理中的状态时为部分成功。其余情况都为处理中，处理中请参考支付方案状态。即1、2、4均为终态） |
| payPlanList          | list   | true      | -        | 支付方案列表                                                 | 详见6.1支付工具信息响应参数        |
| payeeList            | list   | true      | -        | 收方信息                                                         | 详见6.2收方信息响应参数           |
| goodsList | list   | true      | -        | 商品详情信息                                                     | 详见6.3商品信息响应参数     |

###### 6 .1支付方案响应参数

| 参数名         | 类型 | 是否必输 | 最大长度 | 描述           | 示例值                                                       |
| -------------- | ---- | -------- | -------- | -------------- | ------------------------------------------------------------ |
| payPlanSubcode | str  | true     | 3        | 支付工具子序号 |                                                              |
| payEntity      | str  | true     | 3        | 支付工具       | 0-未知 1-现金 2-票据 3-融资 4-承诺（银行处理中时，可能支付工具为未知状态） |
| payAmount      | str  | true     | 17       | 支付金额       | 详见6.5币种表                                                |
| payCurr        | str  | true     | 3        | 支付币种       | 详见6.5币种表                                                |
| status         | str  | true     | 3        | 支付状态       | 0-同步登记 1-成功 2-失败 3-可疑 4-银行已受理 5-异步登记 6-主动关闭 7-超期作废（成功终态：1-成功;失败终态：2-失败，6-主动关闭，7-超期作废;非终态：4-银行已受理，表示记录提交成功，需要落地处理；3-可疑表示处理存在异常，需要进行可疑查询） |
| appendFlag     | str  | true     | 1        | 是否追加保留   | 0-否 1-是                                                    |
| errno          | str  | true     | 8        | 错误码         |                                                              |
| errmsg         | str  | true     | 200      | 错误描述       |                                                              |

###### 6.2 收方信息响应参数

| 参数             | 类型 | 是否必输 | 最大长度 | 描述                        | 示例值             |
| ---------------- | ---- | -------- | -------- | --------------------------- | ------------------ |
| payAmount        | str  | TRUE     | 17       | 支付金额                    | 详见6.5币种表      |
| payeeCompanyName | str  | TRUE     | 140      | 收款人户名                  | 1608               |
| payeeAccno       | str  | TRUE     | 34       | 收款账号                    | C024               |
| payeeBankCountry | str  | TRUE     | 140      | 收款行地址                  | SWIFT024           |
| payeeBankSign    | str  | TRUE     | 12       | 收款行标识（SWIFT CODE BIC) | 924                |
| rbankname        | str  | TRUE     | 140      | 收款行全称                  | XX024              |
| payeeCountry     | str  | TRUE     | 3        | 收款人常驻国家/地区         | 详见6.4国家代码表  |
| racAddress1      | str  | TRUE     | 140      | 收款人地址（国家）          | ZG24               |
| racAddress2      | str  | TRUE     | 140      | 收款人地址（省/州）         | A024               |
| racAddress3      | str  | TRUE     | 140      | 收款人地址（城市/城镇）     | B024               |
| racAddress4      | str  | TRUE     | 140      | 收款人地址（街/路）         | D024               |
| racPostcode      | str  | TRUE     | 15       | 收款人地址（邮编）          | YZHDQ024           |
| agentbic         | str  | TRUE     | 11       | 收款行之代理BIC码           | 200062019212019000 |
| payeeAddress     | str  | TRUE     | 360      | 收款人地址                  | 非加拿大必输。加拿大地区收款不输入 |

###### 6.3 商品信息响应参数

| 参数             | 类型 | 是否必输 | 最大长度 | 描述       | 示例值        |
| ---------------- | ---- | -------- | -------- | ---------- | ------------- |
| payeeCompanyName | str  | TRUE     | 140      | 收款人户名 | 收款人名称025 |
| goodsName        | str  | TRUE     | 140      | 商品名称   | 商品名024     |
| goodsNumber      | str  | TRUE     | 17       | 商品数量   | 224           |
| goodsAmt         | str  | TRUE     | 17       | 商品金额   | 详见6.5币种表 |

###### 6.4 国家代码表

| 国家中文 | 国家代码                   |
| -------- | -------------------------- |
| 032      | 阿根廷                     |
| 036      | 澳大利亚                   |
| 040      | 奥地利                     |
| 044      | 巴哈马                     |
| 048      | 巴林                       |
| 050      | 孟加拉国                   |
| 051      | 亚美尼亚                   |
| 052      | 巴巴多斯                   |
| 056      | 比利时                     |
| 060      | 百慕大                     |
| 064      | 不丹                       |
| 068      | 玻利维亚                   |
| 070      | 波斯尼亚和黑塞哥维那       |
| 072      | 博茨瓦纳                   |
| 074      | 布维岛                     |
| 076      | 巴西                       |
| 084      | 伯利兹                     |
| 086      | 英属印度洋领土             |
| 090      | 所罗门群岛                 |
| 092      | 英属维尔京群岛             |
| 096      | 文莱                       |
| 100      | 保加利亚                   |
| 104      | 缅甸                       |
| 108      | 布隆迪                     |
| 112      | 白俄罗斯                   |
| 116      | 柬埔寨                     |
| 120      | 喀麦隆                     |
| 124      | 加拿大                     |
| 132      | 佛得角                     |
| 136      | 开曼群岛                   |
| 140      | 中非                       |
| 144      | 斯里兰卡                   |
| 148      | 乍得                       |
| 152      | 智利                       |
| 156      | 中国                       |
| 158      | 中国台湾                   |
| 162      | 圣诞岛                     |
| 166      | 科科斯(基林)群岛           |
| 170      | 哥伦比亚                   |
| 174      | 科摩罗                     |
| 175      | 马约特                     |
| 178      | 刚果（布）                 |
| 180      | 刚果（金）                 |
| 184      | 库克群岛                   |
| 188      | 哥斯达黎加                 |
| 191      | 克罗地亚                   |
| 192      | 古巴                       |
| 196      | 塞浦路斯                   |
| 203      | 捷克                       |
| 204      | 贝宁                       |
| 208      | 丹麦                       |
| 212      | 多米尼克                   |
| 214      | 多米尼加共和国             |
| 218      | 厄瓜多尔                   |
| 222      | 萨尔瓦多                   |
| 226      | 赤道几内亚                 |
| 231      | 埃塞俄比亚                 |
| 232      | 厄立特里亚                 |
| 233      | 爱沙尼亚                   |
| 234      | 法罗群岛                   |
| 238      | 马尔维纳斯群岛(福克兰群岛) |
| 239      | 南乔治亚岛和南桑德韦奇岛   |
| 242      | 斐济                       |
| 246      | 芬兰                       |
| 250      | 法国                       |
| 254      | 法属圭亚那                 |
| 258      | 法属波利尼西亚             |
| 260      | 法属南部领土               |
| 262      | 吉布提                     |
| 266      | 加蓬                       |
| 268      | 格鲁吉亚                   |
| 270      | 冈比亚                     |
| 275      | 巴勒斯坦                   |
| 276      | 德国                       |
| 288      | 加纳                       |
| 292      | 直布罗陀                   |
| 296      | 基里巴斯                   |
| 300      | 希腊                       |
| 304      | 格陵兰                     |
| 308      | 格林纳达                   |
| 312      | 瓜德罗普                   |
| 316      | 关岛                       |
| 320      | 危地马拉                   |
| 324      | 几内亚                     |
| 328      | 圭亚那                     |
| 332      | 海地                       |
| 334      | 赫德岛和麦克唐纳岛         |
| 336      | 梵蒂冈                     |
| 340      | 洪都拉斯                   |
| 344      | 中国香港                   |
| 348      | 匈牙利                     |
| 349      | 塞尔维亚和黑山             |
| 352      | 冰岛                       |
| 356      | 印度                       |
| 360      | 印度尼西亚                 |
| 364      | 伊朗                       |
| 368      | 伊拉克                     |
| 372      | 爱尔兰                     |
| 376      | 以色列                     |
| 380      | 意大利                     |
| 384      | 科特迪瓦                   |
| 388      | 牙买加                     |
| 392      | 日本                       |
| 398      | 哈萨克斯坦                 |
| 400      | 约旦                       |
| 404      | 肯尼亚                     |
| 408      | 朝鲜                       |
| 410      | 韩国                       |
| 414      | 科威特                     |
| 417      | 吉尔吉斯斯坦               |
| 418      | 老挝                       |
| 422      | 黎巴嫩                     |
| 426      | 莱索托                     |
| 428      | 拉脱维亚                   |
| 430      | 利比里亚                   |
| 434      | 利比亚                     |
| 438      | 列支敦士登                 |
| 440      | 立陶宛                     |
| 442      | 卢森堡                     |
| 446      | 中国澳门                   |
| 450      | 马达加斯加                 |
| 454      | 马拉维                     |
| 458      | 马来西亚                   |
| 462      | 马尔代夫                   |
| 466      | 马里                       |
| 470      | 马耳他                     |
| 474      | 马提尼克                   |
| 478      | 毛里塔尼亚                 |
| 480      | 毛里求斯                   |
| 484      | 墨西哥                     |
| 492      | 摩纳哥                     |
| 496      | 蒙古                       |
| 498      | 摩尔多瓦                   |
| 500      | 蒙特塞拉特                 |
| 504      | 摩洛哥                     |
| 508      | 莫桑比克                   |
| 512      | 阿曼                       |
| 516      | 纳米比亚                   |
| 520      | 瑙鲁                       |
| 524      | 尼泊尔                     |
| 528      | 荷兰                       |
| 530      | 荷属安的列斯               |
| 533      | 阿鲁巴                     |
| 540      | 新喀里多尼亚               |
| 548      | 瓦努阿图                   |
| 554      | 新西兰                     |
| 558      | 尼加拉瓜                   |
| 562      | 尼日尔                     |
| 566      | 尼日利亚                   |
| 570      | 纽埃                       |
| 574      | 诺福克岛                   |
| 578      | 挪威                       |
| 580      | 北马里亚纳                 |
| 581      | 美属太平洋各群岛           |
| 583      | 密克罗尼西亚               |
| 584      | 马绍尔群岛                 |
| 585      | 贝劳                       |
| 586      | 巴基斯坦                   |
| 591      | 巴拿马                     |
| 598      | 巴布亚新几内亚             |
| 600      | 巴拉圭                     |
| 604      | 秘鲁                       |
| 608      | 菲律宾                     |
| 612      | 皮特凯恩群岛               |
| 616      | 波兰                       |
| 620      | 葡萄牙                     |
| 624      | 几内亚比绍                 |
| 626      | 东帝汶                     |
| 630      | 波多黎各                   |
| 634      | 卡塔尔                     |
| 638      | 留尼汪                     |
| 642      | 罗马尼亚                   |
| 643      | 俄罗斯                     |
| 646      | 卢旺达                     |
| 654      | 圣赫勒拿                   |
| 659      | 圣基茨和尼维斯             |
| 660      | 安圭拉                     |
| 662      | 圣卢西亚                   |
| 666      | 圣皮埃尔和密克隆           |
| 670      | 圣文森特和格林纳丁斯       |
| 674      | 圣马力诺                   |
| 004      | 阿富汗                     |
| 008      | 阿尔巴尼亚                 |
| 010      | 南极洲                     |
| 012      | 阿尔及利亚                 |
| 016      | 美属萨摩亚                 |
| 020      | 安道尔                     |
| 024      | 安哥拉                     |
| 028      | 安提瓜和巴布达             |
| 031      | 阿塞拜疆                   |
| 678      | 圣多美和普林西比           |
| 682      | 沙特阿拉伯                 |
| 686      | 塞内加尔                   |
| 690      | 塞舌尔                     |
| 694      | 塞拉利昂                   |
| 702      | 新加坡                     |
| 703      | 斯洛伐克                   |
| 704      | 越南                       |
| 705      | 斯洛文尼亚                 |
| 706      | 索马里                     |
| 710      | 南非                       |
| 716      | 津巴布韦                   |
| 724      | 西班牙                     |
| 732      | 西撒哈拉                   |
| 736      | 苏丹                       |
| 740      | 苏里南                     |
| 744      | 斯瓦尔巴群岛               |
| 748      | 斯威士兰                   |
| 752      | 瑞典                       |
| 756      | 瑞士                       |
| 760      | 叙利亚                     |
| 762      | 塔吉克斯坦                 |
| 764      | 泰国                       |
| 768      | 多哥                       |
| 772      | 托克劳                     |
| 776      | 汤加                       |
| 780      | 特立尼达和多巴哥           |
| 784      | 阿联酋                     |
| 788      | 突尼斯                     |
| 792      | 土耳其                     |
| 795      | 土库曼斯坦                 |
| 796      | 特克斯科斯群岛             |
| 798      | 图瓦卢                     |
| 800      | 乌干达                     |
| 804      | 乌克兰                     |
| 807      | 马其顿                     |
| 818      | 埃及                       |
| 826      | 英国                       |
| 834      | 坦桑尼亚                   |
| 840      | 美国                       |
| 850      | 美属维尔京群岛             |
| 854      | 布基纳法索                 |
| 858      | 乌拉圭                     |
| 860      | 乌兹别克斯坦               |
| 862      | 委内瑞拉                   |
| 876      | 瓦利斯和富图纳群岛         |
| 882      | 西萨摩亚                   |
| 887      | 也门                       |
| 894      | 赞比亚                     |

###### 6.5 币种表

| 币种中文名     | 币种代码 | 单位                 |
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

###### 7 使用示例

```java
package com.icbc.api.test;

import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.internal.util.internal.util.fastjson.JSONObject;
import com.icbc.api.request.MybankPayCpayCporderqueryRequestV1;
import com.icbc.api.response.MybankPayCpayCporderqueryResponseV1;



import java.util.ArrayList;
import java.util.List;

public class QueryPayApplyTestV1 {
	
	protected static final String MY_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALAWAcPiTMRU906PTdy0ozspX7XptZnkEw2C8R64RDB9BiRFXAj0cU4aTA1MyfmGIlceeVdgJf7OnmvpHnYxjQ7sGxMItPtodrGwA2y8j0AEbHc5pNWU8Hn0zoY9smHS5e+KjSbWv+VNbdnrRFTpDeiJ3+s2E/cKI2CDRbo7cAarAgMBAAECgYABiA933q4APyTvf/uTYdbRmuiEMoYr0nn/8hWayMt/CHdXNWs5gLbDkSL8MqDHFM2TqGYxxlpOPwnNsndbW874QIEKmtH/SSHuVUJSPyDW4B6MazA+/e6Hy0TZg2VAYwkB1IwGJox+OyfWzmbqpQGgs3FvuH9q25cDxkWntWbDcQJBAP2RDXlqx7UKsLfM17uu+ol9UvpdGoNEed+5cpScjFcsB0XzdVdCpp7JLlxR+UZNwr9Wf1V6FbD2kDflqZRBuV8CQQCxxpq7CJUaLHfm2kjmVtaQwDDw1ZKRb/Dm+5MZ67bQbvbXFHCRKkGI4qqNRlKwGhqIAUN8Ynp+9WhrEe0lnxo1AkEA0flSDR9tbPADUtDgPN0zPrN3CTgcAmOsAKXSylmwpWciRrzKiI366DZ0m6KOJ7ew8z0viJrmZ3pmBsO537llRQJAZLrRxZRRV6lGrwmUMN+XaCFeGbgJ+lphN5/oc9F5npShTLEKL1awF23HkZD9HUdNLS76HCp4miNXbQOVSbHi2QJAUw7KSaWENXbCl5c7M43ESo9paHHXHT+/5bmzebq2eoBofn+IFsyJB8Lz5L7WciDK7WvrGC2JEbqwpFhWwCOl/w==";
	
	protected static final String APIGW_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwFgHD4kzEVPdOj03ctKM7KV+16bWZ5BMNgvEeuEQwfQYkRVwI9HFOGkwNTMn5hiJXHnlXYCX+zp5r6R52MY0O7BsTCLT7aHaxsANsvI9ABGx3OaTVlPB59M6GPbJh0uXvio0m1r/lTW3Z60RU6Q3oid/rNhP3CiNgg0W6O3AGqwIDAQAB";
	
	protected static final String APP_ID = "10000000000000002166";
	

	public void test_cop() throws IcbcApiException {
		
		DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
		
		MybankPayCpayCporderqueryRequestV1 request = new MybankPayCpayCporderqueryRequestV1();
		request.setServiceUrl("http://IP:PORT/api/mybank/pay/cpay/cporderquery/V1");
		
		MybankPayCpayCporderqueryRequestV1.QueryPayApplyRequestV1Biz bizContent = new MybankPayCpayCporderqueryRequestV1.QueryPayApplyRequestV1Biz();
		
		bizContent.setApi_name("REQ_OPENPAY");
		bizContent.setApi_version("001.001.001.001");
		bizContent.setApp_id("");
		bizContent.setBiz_content("");
		bizContent.setCa("");
		bizContent.setCharset("utf‐8");
		bizContent.setEncrypt_type("");
		bizContent.setFormat("json");
		bizContent.setMsg_id("");
		bizContent.setSign("");
		bizContent.setTimestamp("");

		bizContent.setPartnerSeq("123456");
		bizContent.setAgreeCode("12345");
		bizContent.setOrderCode("1234");

		
		request.setBizContent(bizContent);
		
		MybankPayCpayCporderqueryResponseV1 response = client.execute(request);
		
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


```

###### 8 请求示例
```json
POST HTTP/1.1
Content-Type: application/x-www-form-urlencoded; charset=UTF-8

https://gw.open.icbc.com.cn/api/mybank/pay/cpay/cporderquery/V1?app_id=Oikeclo001&msg_id=urcnl24ciutr9&format=json&charset=utf-8&sign_type=RSA&sign=TRFEWHYUFCEW&timestamp=2016-10-29 20:44:38&biz_content=
{
    "agreeCode": "0000000000090000000001000000085016",
    "orderCode": "2019021314281026",
    "partnerSeq": "20190470026"
}

```

###### 9 响应示例
```json
HTTP/1.1 200 OK 
Content-Type: application/json; charset=UTF-8

{
   "response_biz_content":{
    "orderCurr": "14",
    "transOk": 0,
    "payeeList": [
        {
            "payeeCompanyName": "SHQY024",
            "payAmount": "1608",
            "racpostcode": "C024",
            "payeeBankSign": "SWIFT024",
            "payeeAddress":"shoukaufna",
            "payeeCountry": "924",
            "racaddress1": "XX024",
            "racaddress2": "DZ2024",
            "payeeBankCountry": "ZG24",
            "racaddress3": "A024",
            "racaddress4": "B024",
            "agentbic": "D024",
            "rbankname": "YZHDQ024",
            "payeeAccno": "0200062019212019112"
        }
    ],
    "payMode": "3",
    "errorNo": "",
    "sumPayamt": "1608",
    "source":"1",
    "accrualCny":"100",
    "accrualForeign":"200",
    "payerAccno": "2000298092000024",
    "orderRemark": "备注024",
    "payPlanList": [
        {
            "payAmount": "1608",
            "status": 5,
            "payCurr": "14",
            "payEntity": "1",
            "billno": ""
        }
    ],
    "errorName": "",
    "serialNo": "2019021314280026",
    "agreeName": "E企付协议024",
    "payerAccname": "人民币付方户名24",
    "agreeCode": "0000000000090000000001000000085016",
    "orderAmount": "2024",
    "partnerSeq": "20190470026",
    "payerAccnoForeign":"200",
    "payerAccnameForeign":"200",
    "payType":"201",
    "payStatus":"1"},
  "sign":"ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE"
}

```

###### 10 异常示例
```json
HTTP/1.1 200 OK 
Content-Type: application/json; charset=UTF-8

{
  "response_biz_content":{
    "return_code":400014,
    "return_msg":"交易时间戳解析异常",
	"msg_id":"urcnl24ciutr9"
  },
  "sign":"ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE"
}
```

###### 11 错误码解释
| 返回码  | 返回说明                                                                     |
| ------- | ------------------                                                           |
| 0       | 成功                                                                         |
| 400019  |	授权验证失败                                                                 |
| 400011  |	应用ID为空                                                                   |
| 400012  |	应用ID非法                                                                   |
| 400013  |	签名为空                                                                     |
| 400014  |	交易时间戳解析异常                                                           |
| -500044 |	网关签名失败                                                                 |
| -500031 |	速率超限                                                                     |
| -500032 |	并发超限                                                                     |
| -500018 |	访问的资源不存在                                                             |
| -500020 |	非法调用                                                                     |
| 400016  |	应用公钥未维护                                                               |
| 400017  |	签名验证失败                                                                 |
| -500041 |	代理错误                                                                     |
| -500042 |	代理超时                                                                     |
| -500043 |	网关配置文件错误，无法从配置文件中读取配置                                   |
| 93001162| 该产品报价不存在                                                             |
| 5399	  | 终端上送数据错                                                               |
