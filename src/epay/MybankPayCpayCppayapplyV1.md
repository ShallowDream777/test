### 工银e企付支付申请服务

<button type='button' class='btn btn-sm btn-success apply'>申请使用</button>


###### 1 功能说明
该功能用于合作方平台调用工银e企付付款台，发起支付申请服务

###### 2 请求路径
| 环境         | 请求地址 |
| ------------ | ------------------------ |
| 正式环境 | https://gw.open.icbc.com.cn/api/mybank/pay/cpay/cppayapply/V1 |


###### 3 通用请求参数
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

| 参数名            | 类型 | 是否必输 | 最大长度 | 描述                                           | 示例值                                                       |
| ----------------- | ---- | -------- | -------- | :--------------------------------------------- | :----------------------------------------------------------- |
| agreeCode         | str  | true     | 34       | 合作方协议编号                                 | 合作方签约协议编号                                           |
| partnerSeq        | str  | true     | 34       | 交易流水号                                     | 每笔交易必须唯一                                             |
| payChannel        | str  | true     | 3        | 渠道类型                                       | 1-PC端 2-移动端                                              |
| internationalFlag | str  | true     | 3        | 境内外标志                                     | 1-境内 2-境外                                                |
| payMode           | str  | true     | 3        | 支付方式                                       | 1-直接支付：资金直接支付给收款方 2-保留支付：资金保留在付款方或者收款方账户，后续需要调用方主动调起指令划拨或解保留 |
| reservDirect      | str  | false    | 3        | 保留方向                                       | 保留支付时上送，1-付方保留，2-收方保留(收方保留时，收款账号仅支持工行往来户) |
| payEntitys        | str  | true     | 20       | 支付工具                                       | 10000000000000000000(第一位代表现金,第二位代表票据，暂启用第一、二位） |
| asynFlag          | str  | true     | 3        | 是否异步支付（0-否，1-是）                     | 异步支付：适用于采购与财务分离的场景，采购人员仅下单，由财务人员登录工行企业网银进行订单支付；选择异步支付时，付款人账号必送。境外不支持异步支付。 |
| logonId           | str  | false    | 24       | 企网登录ID                                     | 当异步支付需要指定提交人时才上送(预留字段，本期暂不支持)     |
| payerAccno        | str  | false    | 34       | 付款人账号                                     | 异步支付时必须送账号；其他场景如果送，则为指定账号支付。     |
| payerAccname      | str  | false    | 140      | 付款人户名                                     | 付款人账号和付款人户名必须同时输入                           |
| payerFeeAccno     | str  | false    | 34       | 付方付费账号                                   | 境外支付时上送。上送时，则取该账号付手续费;若不上送，则取付方账号付手续费。付方付费账号、付方付费账号户名、付方付费账号币种同时上送或者都不上送. |
| payerFeeAccName   | str  | false    | 140      | 付方付费账号户名                               | 境外支付时上送。付方付费账号、付方付费账号户名、付方付费账号币种同时上送或者都不上送 |
| payerFeeCurr      | str  | false    | 3        | 付方付费账号币种                               | 境外支付时上送。目前只支持人民币。付方付费账号、付方付费账号户名、付方付费账号币种同时上送或者都不上送 |
| payMemno          | str  | true     | 15       | 付款人会员号                                   | 客户在合作方平台注册的唯一编号                               |
| orgcode           | str  | false    | 18       | 组织机构代码                                   | 境外必须上送                                                 |
| orderCode         | str  | true     | 34       | 订单编号                                       | 001                                                          |
| orderAmount       | str  | true     | 17       | 订单金额（单位：分）                           | 20180710142122                                               |
| orderCurr         | str  | true     | 3        | 订单币种                                       | 详见4.4币种表，暂不支持科威特第纳尔币种。                    |
| sumPayamt         | str  | true     | 17       | 本次汇总支付金额（单位：分）                   | 本次支付金额=收款金额之和                                    |
| orderRemark       | str  | false    | 140      | 订单备注                                       | 页面展示                                                     |
| rceiptRemark      | str  | false    | 140      | 回单补充信息备注                               | 当需要打印在回单信息中时上送                                 |
| submitTime        | str  | true     | 14       | 交易平台提交时间                               | 20190319172255系统会校验平台提交时间与系统时间差，前1小时，后12小时 |
| returnUrl         | str  | false    | 140      | 返回页面地址                                   | 用于支付结果页面跳转回商城页面地址                           |
| callbackUrl       | str  | false    | 140      | 回调通知地址                                   | 推送通知消息                                                 |
| agreementId       | str  | false    | 20       | 合同号                                         | 境外支付时上送，三单号不能都上送为空                         |
| invoiceId         | str  | false    | 25       | 发票号                                         | 境外支付时上送                                               |
| manifestId        | str  | false    | 50       | 报关单号                                       | 境外支付时上送                                               |
| agreementImageId  | str  | false    | 32       | 影像批次号                                     | 境外支付时上送                                               |
| payeeList         | str  | true     | -        | 收方商户信息列表                               | 请求参数中收方商户信息参数的集合，详见4.1收方商户信息参数    |
| goodsList         | str  | false    | -        | 商品信息列表(境内付款台时，必送，用于页面展示) | 请求参数中商品信息参数的集合，详见4.2收方商品信息参数,商品金额没有核对，需要调用方自行保证 |

###### 4 .1收方商户信息参数

| 参数名              | 类型 | 是否必输 | 最大长度 | 描述                                  | 示例值                                                       |
| ------------------- | ---- | -------- | -------- | ------------------------------------- | ------------------------------------------------------------ |
| mallCode            | str  | true     | 34       | 收方商户号                            | 收款商户在合作方平台注册的唯一编号                           |
| mccCode             | str  | false    | 20       | 商户类别（MCC码）                     | 合规性检查                                                   |
| mccName             | str  | false    | 140      | MCC码名称                             | 合规性检查                                                   |
| businessLicense     | str  | false    | 64       | 商户证件编号                          | 合规性检查                                                   |
| businessLicenseType | str  | false    | 3        | 商户证件类型                          | 合规性检查                                                   |
| mallName            | str  | true     | 140      | 商户名称                              |                                                              |
| payeeCompanyName    | str  | true     | 140      | 收款人户名                            | 长度控制140个字符，境外支付时收款行位于中国大陆、香港、澳门（SWIFT CODE第5 6位为CN、HK、MO）时允许录入中文；非加拿大时：收款人名称与地址加总不能超过140个字符。要求SWIFT字符集+中文汉字 |
| payeeSysflag        | str  | true     | 3        | 账户系统内外标志                      | 1-境内工行，2-境内他行，3-境外                               |
| payeeBankCode       | str  | false    | 12       | 收方行联行号                          | 当收方为境内他行时上送，需要合作方自行查询                   |
| payeeHeadBankCode   | str  | false    | 12       | 收方行总行行号                        | 该字段为预留字段，目前暂不支持。当收方为境内他行时上送，如上送该字段，则根据交易金额如满足跨行快汇的要求则优先走跨行快汇。 |
| payeeAccno          | str  | true     | 34       | 收款人账号                            | 要求SWIFT字符集                                              |
| payAmount           | str  | true     | 17       | 收款金额（单位：分）                  |                                                              |
| rbankname           | str  | false    | 140      | 收款行全称                            | 当收方为境外时必须上送,要SWIFT字符集+中文汉字（收款行位于中国大陆、香港、澳门（SWIFT CODE第5 6位为CN、HK、MO）时允许录入中文；） |
| payeeBankCountry    | str  | false    | 3        | 收款行所在国家地区代码                | 当收方为境外时必须上送，详见4.3国家代码表                    |
| payeeBankSign       | str  | false    | 11       | 收款行标识：SWIFT Code（BIC）         | 当收方为境外时必须上送，11位字符，只能录入数字和字母         |
| payeeCountry        | str  | false    | 3        | 收款人常驻国家/地区                   | 当收方为境外时必须上送，详见4.3国家代码表                    |
| payeeAddress        | str  | false    | 140      | 收款人地址                            | 境外非加拿大时必须上送，收款人户名加收款地址不能超过140个字符，要求SWIFT字符集+中文汉字（收款行位于中国大陆、香港、澳门（SWIFT CODE第5 6位为CN、HK、MO）时允许录入中文；） |
| racaddress1         | str  | false    | 60       | 收款人地址（国家）                    | 境外加拿大时必须上送，（swift code 码第5，6位为CA，本地清算号前两位为CC）或汇款币种为加元：街道、城市、州/省、国家、邮编必输。送英文简称，CHINA或者CHN等之类的字符，不要送数字代码。加拿大时：收款人名称 + 收款人地址（国家）+ 收款人地址（省/州）+ 收款人地址（城市/城镇）+ 收款人地址（街/路）+ 收款人地址（邮编）相加不超过140个字符，要求SWIFT字符集 |
| racaddress2         | str  | false    | 140      | 收款人地址（省/州）                   | 英文简称，加拿大地区必输，要求SWIFT字符集                    |
| racaddress3         | str  | false    | 140      | 收款人地址（城市/城镇）               | 英文简称，加拿大地区必输，要求SWIFT字符集                    |
| racaddress4         | str  | false    | 140      | 收款人地址（街/路）                   | 英文简称，加拿大地区必输，要求SWIFT字符集                    |
| racpostcode         | str  | false    | 15       | 收款人地址（邮编）                    | 加拿大地区必输，要求SWIFT字符集                              |
| agentbic            | str  | false    | 11       | 收款行之代理行BIC码（境外支付才上送） | 11位BIC，只能录入数字和字母。                                |
| payeePhone          | str  | false    | 22       | 收款人手机号                          |
###### 4 .2商品信息参数

| 参数名           | 类型 | 是否必输 | 最大长度 | 描述                 | 示例值 |
| ---------------- | ---- | -------- | -------- | -------------------- | ------ |
| goodsSubId       | str  | true     | 5        | 商品信息子序号       | 1      |
| goodsName        | str  | true     | 140      | 商品名称             |        |
| payeeCompanyName | str  | true     | 140      | 收款人户名           |        |
| goodsNumber      | str  | true     | 17       | 商品数量             |        |
| goodsUnit        | str  | true     | 10       | 商品单位             |        |
| goodsAmt         | str  | true     | 17       | 商品金额（单位：分） |        |

注意事项：

  1、SWIFT支持的字符集：

    a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z  
    A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z 
    0  1  2  3  4  5  6  7  8  9 
    /  -  ?  :  (  )  .  ,  '  +   空格  
        
        String expr1 = "[A-Z]{6}[A-Z2-9][A-NP-Z0-9]([A-Z0-9]{3}){0,1}";//BIC的检查
        String expr2 = "[0-9]*";  //数字字符的检查
        String expr3 = "[A-Z]*";  //字母字符的检查
        String expr4 = "[0-9|A-Z]*";  //数字字母字符的检查
        String expr5 = "^[a-zA-Z0-9-?:().,'+ /]*$";//SWIFT字符集检查


###### 4 .3 国家代码表

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

###### 4 .4 币种表

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

| 参数名        | 类型 | 是否必输 | 最大长度 | 描述                     | 示例值                                                       |
| ------------- | ---- | -------- | -------- | ------------------------ | ------------------------------------------------------------ |
| serialNo      | str  | true     | 34       | 银行指令序号             | 1                                                            |
| agreeCode     | str  | true     | 34       | 合作方协议编号           |                                                              |
| agreeName     | str  | true     | 140      | 合作方名称               |                                                              |
| partnerSeq    | str  | true     | 34       | 合作方交易流水号         |                                                              |
| payMode       | str  | true     | 3        | 支付方式                 | 1-直接支付2-保留支付                                         |
| orderAmount   | str  | true     | 17       | 订单金额（单位：分）     |                                                              |
| orderCurr     | str  | true     | 3        | 订单币种                 |                                                              |
| sumPayamt     | str  | true     | 17       | 本次支付金额（单位：分） |                                                              |
| status        | str  | true     | 3        | 状态                     | 1-成功 2-失败 3-银行处理中                                   |
| return_code   | int  | true     | 12       | 错误码                   | 返回码，交易成功返回0，非0则交易处理报错                     |
| return_msg    | str  | true     | 200      | 返回描述                 |                                                              |
| redirectParam | str  | true     | 140      | 页面重定向参数           | <http://ip:port/XXXServlet?unique_serialno=>交易唯一流水号&signstr=签名串 |



###### 6  使用示例

```java
		DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
		
		MybankPayCpayCppayapplyRequestV1 request = new MybankPayCpayCppayapplyRequestV1();
		request.setServiceUrl("https://IP:PORT/api/mybank/pay/cpay/cppayapply/V1");
		
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
         beanRecvMallInfo.setPayeePhone("1");
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
```

###### 7 请求示例
```json
POST HTTP/1.1
Content-Type: application/x-www-form-urlencoded; charset=UTF-8

https://gw.open.icbc.com.cn/api/mybank/pay/cpay/cppayapply/V1?app_id=Oikeclo001&msg_id=urcnl24ciutr9&format=json&charset=utf-8&sign_type=RSA&sign=TRFEWHYUFCEW&timestamp=2016-10-29 20:44:38&biz_content=
{"orderCurr":"14",
"reservDirect":"1",
"rceiptRemark":"1",
"payerAccno":"2025585255",
"payerFeeAccno":"2025585255",
"payerFeeAccName":"payerFeeAccName",
"payerFeeCurr":"1",
"internationalFlag":"2",
"goodsList":
[{"goodsNumber":"1",
"goodsSubId":"1",
"goodsUnit":"1公斤",
"goodsName":"1",
"payeeCompanyName":"1",
"goodsAmt":"100"
}],
"payChannel":"1",
"sumPayamt":"100",
"payeeList":
[{"businessLicense":"1",
"payeeSysflag":"3",
"mallName":"mallName",
"payeeAccno":"0200062009011223306",
"payeeBankCode":"",
"agentbic":"",
"payeePhone":"",
"racpostcode":"",
"racaddress4":"",
"rbankname":"rbankname",
"racaddress2":"",
"payeeCompanyName":"meiguo",
"racaddress3":"",
"racaddress1":"",
"mccCode":"1",
"payeeAddress":"shoukaufna",
"payeeCountry":"840",
"payAmount":"100",
"businessLicenseType":"0",
"mccName":"1",
"mallCode":"1001",
"payeeBankCountry":"adreess",
"payeeBankSign":"20555225"}],
"orderAmount":"100",
"payMode":"2",
"agreementId":"1",
"returnUrl":"1",
"manifestId":"1",
"app_id":"aaaaaaaaaaaaa",
"payerAccname":"payerAccname",
"orderCode":"order0003",
"orgcode":"101204723",
"payMemno":"1025",
"agreeCode":"1120000998140010446437000000201002",
"payEntitys":"1",
"partnerSeq":"MQOY252201205102116",
"submitTime":"20190324123457",
"callbackUrl":"1",
"invoiceId":"1",
"orderRemark":"1",
"asynFlag":"0",
"agreementImageId":"1"}

```

###### 8 响应示例
```json
HTTP/1.1 200 OK 
Content-Type: application/json; charset=UTF-8

{
    "response_biz_content": {
        "return_code": "0",
        "return_msg": "OK",
        "sumPayamt": "1",
        "orderCurr": "001",
        "orderAmount": "1",
        "agreeName": "1",
        "serialNo": "1",
        "agreeCode": "1",
        "partnerSeq": "1",
        "redirectParam": "1",
        "payMode": "1",
        "status": "1"
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
|	80008002	| 金额验证失败	|
|	80008003	| 数字字典校验失败	|
|	80008004	| 时间校验不通过	|
|	80008005	| 查询协议失败	|
|	80008006	| 合作方协议不存在	|
|	80008007	| 协议不支持该支付方式	|
|	80008008	| 协议不支持异步支付	|
|	80008010	| 协议状态异常	|
|	80008009	| appid不一致	|
|	80008021	| 商户信息必须上送且只能存在一条	|
|	80008022	| 保留支付必须上送保留方向	|

###### 11通知接口说明

###### 11.1 通知接口通用输入参数

| 参数名       | 类型 | 是否必输 | 最大长度 | 描述                                                         | 示例值                |
| ------------ | ---- | -------- | -------- | ------------------------------------------------------------ | --------------------- |
| from         | str  | true     | -        | 工行调用写死为icbc-api                                       | icbc-api              |
| api          | str  | true     | -        | 调用哪一个接口的回调                                         | ./pay/cpay/cppayapply |
| appid        | str  | true     | -        | 合作方在工行开具的应用编号                                   | 2014072300007140      |
| charset      | str  | true     | -        | 调用过程使用的编码格式                                       | utf-8                 |
| format       | str  | true     | -        | 报文类型                                                     | json                  |
| encrypt_type | str  | false    | -        | 加密方式，可选。若该字段值为AES，则上行网关会使用对称密钥对biz_content进行加密，且合作方响应时应使用对称密钥对response_biz_content进行加密 | AES                   |
| timestamp    | str  | true     | -        | 回调发生的时间，格式为“yyyy-MM-dd HH:mm:ss”                  | 2017-01-12 17:33:56   |
| biz_content  | str  | true     | -        | 调用业务参数集合，详见biz_content字段说明                    | -                     |
| sign_type    | str  | true     | -        | 签名类型。目前网关回调请求的签名只支持RSA方式，需要合作方使用网关公钥验签 | RSA                   |
| sign         | str  | true     | -        | 工行签名                                                     | FSDFDRYXDS342FDSR     |

###### 11.2 输入参数biz_content字段说明

| 参数名              | 类型 | 是否必输 | 最大长度 | 描述                                  | 示例值                                                       |
| ------------------- | ---- | -------- | -------- | ------------------------------------- | ------------------------------------------------------------ |
| app_id              | str  | true     | 3        | APP的编号,应用在API开放平台注册时生成 | 0                                                            |
| serialNo            | str  | true     | 34       | 银行流水号                            | 1                                                            |
| agreeCode           | str  | true     | 34       | 合作方协议编号                        |                                                              |
| agreeName           | str  | true     | 140      | 合作方名称                            | 0000001                                                      |
| partnerSeq          | str  | true     | 34       | 交易流水号                            | 0000001                                                      |
| payMode             | str  | true     | 3        | 支付方式                              | 1-直接支付2-保留支付                                         |
| payType             | str  | true     | 3        | 支付申请类型                          | 当支付方式为1时：101-支付  当支付方式为2时：201-保留，202-解保留，203-解保留支付 |
| orderAmount         | str  | true     | 17       | 订单金额（单位：分）                  | 100                                                          |
| orderCurr           | str  | true     | 3        | 订单币种                              | 1                                                            |
| sumPayamt           | str  | true     | 17       | 支付金额（单位：分）                  | 100                                                          |
| source              | str  | false    | 3        | 资金来源                              | 0：现汇；1：购汇；2：其他；3：现汇和购汇                     |
| accrualCny          | str  | false    | 17       | 购汇金额（单位：分）                  |                                                              |
| accrualForeign      | str  | false    | 17       | 现汇金额（单位：分）                  |                                                              |
| payerAccno          | str  | true     | 34       | 人民币付方账号                        | 2000298092000024                                             |
| payerAccname        | str  | true     | 140      | 人民币付方户名                        | 人民币付方户名24                                             |
| payerAccnoForeign   | str  | true     | 34       | 外币付方账号                          | 2000298092000024                                             |
| payerAccnameForeign | str  | true     | 140      | 外币付方户名                          | 外币户名                                                     |
| payStatus           | str  | true     | 3        | 支付申请状态                          | 1-成功 2-失败 3-处理中 4-部分成功（当支付方案中所有记录状态为成功时，该笔支付申请状态为成功；当支付方案中所有记录状态为失败时，该笔支付申请状态为失败；当支付方案中所有记录状态均为成功或或者失败，不存在处理中的状态时为部分成功。其余情况都为处理中。即1、2、4均为终态） |
| payPlanList         | str  | true     | -        | 支付方案列表                          | 详见11.3支付方案响应参数                                     |
| payeeList           | str  | true     | -        | 收方信息列表                          | 详见11.4收方信息响应参数                                     |

###### 11 .3支付方案响应参数

| 参数名         | 类型 | 是否必输 | 最大长度 | 描述                 | 示例值                                                       |
| -------------- | ---- | -------- | -------- | -------------------- | ------------------------------------------------------------ |
| payPlanSubcode | str  | true     | 3        | 支付工具子序号       |                                                              |
| payEntity      | str  | true     | 3        | 支付工具             | 0-未知 1-现金 2-票据 3-融资 4-承诺（银行处理中时，可能支付工具为0-未知状态） |
| payAmount      | str  | true     | 17       | 支付金额（单位：分） | 1                                                            |
| payCurr        | str  | true     | 3        | 支付币种             |                                                              |
| status         | str  | true     | 3        | 支付状态             | 0-同步登记 1-成功 2-失败 3-可疑 4-银行已受理 5-异步登记 6-主动关闭 7-超期作废（成功终态：1-成功;失败终态：2-失败，6-主动关闭，7-超期作废;非终态：4-银行已受理，表示记录提交成功，需要落地处理；3-可疑表示处理存在异常，需要进行可疑查询） |
| appendFlag     | str  | true     | 1        | 是否追加保留         | 0-否 1-是（仅境外汇款涉及）                                  |
| errno          | str  | true     | 8        | 错误码               |                                                              |
| errmsg         | str  | true     | 200      | 错误描述             |                                                              |
| billno         | str  | true     | 30       | 票据号码             | 使用票据支付时返回具体值                                     |
| instrSerialno  | str  | true     | 10       | 指令序号             | 使用票据支付时返回具体值                                     |

###### 11 .4收方信息响应参数

| 参数名           | 类型 | 是否必输 | 最大长度 | 描述                 | 示例值                       |
| ---------------- | ---- | -------- | -------- | -------------------- | ---------------------------- |
| payAmount        | str  | true     | 17       | 支付金额（单位：分） | 1                            |
| payeeCompanyName | str  | true     | 140      | 收款人户名           |                              |
| payeeSysflag     | str  | true     | 3        | 系统内外标志         | 1-境内工行 2-境内他行 3-境外 |
| payeeAccno       | str  | true     | 34       | 收款账号             |                              |

###### 11.5 请求示例

```json
HTTP/1.1 200 OK 
Content-Type: application/json; charset=UTF-8

{
  biz_content={"serial_no":"",
    "agreeCode":"20180904",
    "agreeName":"1800137",
    "partnerSeq":"100001",
    "payMode":"1",
    "payType":"201",
    "orderAmount":"100",
    "orderCurr":"5205",
    "sumPayamt":"100",
    "payStatus":"1",
    "source":"1",
    "accrualCny":"100",
    "accrualForeign":"200",
    "payerAccno":"1",
    "payerAccname":"100",
    "payerAccnoForeign":"200",
    "payerAccnameForeign":"200",
     "payPlanList": [
        {
            "payPlanSubcode":"1"
            "payAmount": "1608",
            "status": 5,
            "payCurr": "14",
            "payEntity": "1",
            "appendFlag":"0",
            "errorCode":"0",
            "errorMsg":""
        }
    ],
    "payeeList":"100",
    "appId":"10000000000000008031"
     },
  "from"="icbc-api",
  "api"="/mybank/pay/multipaydesk/mpdeskentry/V1",
  "app_id"="2014072300007140",
  "charset"="utf-8",
  "format"="json",
  "timestamp"="2017/01/12 17:33:56",
  "sign_type"="RSA",
  "signMsg":"ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE"
}
```

###### 11.6 通知消息的验签

使用API开放平台提供的SDK对报文进行验签，验签串为通知地址路径path+”?”+请求参数asc排序（参数中间通过”&”连接，参数名值对之间通过”=”连接），具体参见SDK提供的demo。

###### 11.7 交易错误码说明

| 返回码   | 返回说明              |
| -------- | --------------------- |
| 01309    | 上送参数不合法        |
| 96111452 | 通讯失败,指令处理失败 |
| 08563    | 协议不存在            |
| 42246    | U盾权限不符           |
| 01987    | 入账失败              |