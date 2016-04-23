package myddl.constant;

public enum ErrorCode {

//    // base
//    KEY_0("api调用失败"), KEY_3("参数userId为空"), KEY_4("参数pageNow为空"), KEY_5("参数pageSize为空"), KEY_6("系统错误"), KEY_8(
//            "对象转换成json格式错误"), KEY_9("手机验证码发送失败"), KEY_10("参数错误，sql语句执行失败"),
//
//    // User
//    KEY_001("用户不存在"), KEY_002("手机验证码不正确"), KEY_003("密码不正确"), KEY_004("手机验证码和密码均为空"), KEY_005("accessToken为空，第三方授权失败！"), KEY_006(
//            "参数mobile为空"), KEY_007("参数loginType为空"), KEY_008("参数loginType的取值范围不在(weixin,qq,weibo)之内"), KEY_009(
//            "参数openId为空"), KEY_010("参数userName为空"),
//
//    // shop
//    KEY_011("手机验证码为空"), KEY_012("密码为空"), KEY_013("手机验证码失效"), KEY_014("参数type(手机验证码客户端类型)为空"), KEY_015(
//            "参数codeType(手机验证码类型)为空"), KEY_016("参数type(手机验证码客户端类型)的取值范围不在(PC,APP)之内"), KEY_017(
//            "参数codeType(手机验证码类型)的取值范围不在(Register,UpdatePassword,Login)之内"), KEY_018("该手机号已经连续5次输入错误的验证码，临时冻结1小时"), KEY_019(
//            "该手机号今天已经发送5次验证码，请明天再使用"), KEY_020("该手机号重发验证码的时间间隔小于60秒"), KEY_021("该手机号已经被注册了"), KEY_101("参数state为空"), KEY_102(
//            "参数city为空"), KEY_103("参数district为空"), KEY_104("参数longitude为空"), KEY_105("参数latitude为空"), KEY_106(
//            "用户名或密码有误，请重新输入，注意大小写"), KEY_107("验证码输入错误"), KEY_108("该手机号已经被注册"), KEY_109("验证码错误次数过多，请一小时后再试"), KEY_110(
//            "今日已达验证码发送上限"), KEY_111("请先发送手机验证码"), KEY_112("手机验证码无效"),
//
//    // UserAddress
//    KEY_201("参数addressId为空"), KEY_202("参数name为空"), KEY_203("参数mobile为空"), KEY_204("参数state为空"), KEY_205("参数city为空"), KEY_206(
//            "参数district为空"), KEY_207("参数userAddressId为空"), KEY_208("参数isDefaultAddress的取值范围是（0,1）"), KEY_209(
//            "参数错误，sql语句执行失败"),
//
//    // Trade
//    KEY_301("参数tid为空"), KEY_302("参数payment为空"), KEY_303("参数payType为空"), KEY_304("参数orders为空"), KEY_305("参数type为空"), // 此参数为订单状态的类型，1：付款成功，2：交易成功，3：申请退款
//    KEY_306("参数deliveryPeriods为空"), // 送达时间段
//    KEY_307("订单不存在"), KEY_308("参数addressId 无效"), KEY_309("参数orders格式无效（必须是数组格式的json字符串）");

    ERROR_PARAMETER(1000, "参数错误"),
    ERROR_SYSTEM(1001, "系统错误"),
    ERROR_RESOURCE_NOT_FOUND(1002, "资源不存在"),
    ERROR_PARAMETER_NICKNAME(1003, "参数错误,昵称不能超过50个字"),
    ERROR_PARAMETER_PHONE(1004, "参数错误,手机格式不正确"),
    ERROR_PARAMETER_BRAND_ID_LIST(1005, "参数错误,喜好品牌格式不正确"),
    ERROR_PARAMETER_UPDATE_USER_INFO(1006, "参数错误,昵称,肤质,喜好品牌,头像必须填写一个"),

    ERROR_PARAMETER_SKIN(1007, "参数错误,肤质取值范围必须在1-5之间"),
    ERROR_PARAMETER_TRIAL_ITEM_NOT_EXISTS(1008, "参数错误,此试用宝贝不存在"),
    ERROR_PARAMETER_ADDRESS_NOT_EXISTS(1009, "参数错误,此地址不存在"),
    ERROR_PARAMETER_TRIAL_APPLICATION_NOT_EXISTS(1010, "参数错误,此试用申请不存在"),
    ERROR_PARAMETER_USER_NAME_LENGTH(1011, "参数错误,收货人姓名长度在0-10个字之间"),
    ERROR_PARAMETER_ZIP_CODE_LENGTH(1012, "参数错误,邮编必须是6位数字"),
    ERROR_PARAMETER_UPDATE_ADDRESS(1013, "参数错误,收货人,电话号码,收货地址,邮编必须填写一个"),
    ERROR_PARAMETER_ADDRESS_LENGTH(1014, "参数错误,收货地址长度在0-50个字之间"),
    ERROR_PARAMETER_ITEM_NOT_EXISTS(1015, "参数错误,此宝贝不存在"),


    //用户注册类错误码
    ERROR_USER_REGISTER(10001, "系统错误:用户注册失败"),
    ERROR_USERNAME_OR_PASSWORD_EMPTY(10002, "用户名或者密码未填写"),
    ERROR_WECHAT_USER_NOT_FOUND(10003, "未能找到此微信用户"),
    ERROR_USER_NOT_FOUND(10004, "该用户不存在"),
    ERROR_USER_LOGIN(10005, "系统错误:用户登录失败"),
    ERROR_USER_UPDATE_USER(10009, "系统错误:更新用户信息失败"),
    ERROR_USER_HEAD_IMG(10006, "系统错误:保存用户头像url失败"),
    ERROR_USER_VALIDATE_CHECKCODE(10007, "验证码校验不通过"),
    ERROR_USER_ALREADY_EXISTS(10008, "此用户信息已经完善"),

    ERROR_BEAUTICIAN_NOT_FOUND(20001, "未找到此美容师信息"),

    ERROR_ADDRESS_EXCEED_MAX_NUMBER(30001, "收货地址最多不能超过10条"),
    ERROR_ADDRESS_ADD(30002, "系统错误:新增地址失败"),
    ERROR_ADDRESS_NOT_ITEM(30003, "此地区不提供这项服务"),

    ERROR_COMMENT_ADD(40001, "系统国务:创建评论失败"),
    ERROR_CREATE_ORDER_ERROR(40002, "系统错误,创建订单失败，请重试"),
    ERROR_RANKING_ITEMS_NOT_FOUND(40003, "未找到排行榜产品信息"),


    ERROR_RANKING_NUMBER_ADD(50003, "系统错误:排行榜期数保存失败"),
    ERROR_COUPON_LIMIT_ERROR(50004, "此优惠券不满足满减金额"),
    ERROR_COUPON_TIME_ERROR(50005, "优惠券使用时间有误"),
    ERROR_COUPON_ITEM_ERROR(50006, "优惠券不能用于此服务"),

    ERROR_CREATE_TRIAL_APPLICATION_ERROR(60001, "系统错误,创建申请试用失败，请重试"),
    ERROR_CANCEL_TRIAL_APPLICATION_ERROR(60002, "系统错误,取消试用申请失败，请重试"),
    ERROR_SUCCEED_TRIAL_APPLICATION_ERROR(60003, "系统错误,评论失败失败，请重试"),
    ERROR_SUCCEED_TRIAL_APPLICATION_EXIST(60004, "您已经申请了此试用"),


    ERROR_ITEM_NOT_FOUND(110002, "未找到此服务信息"),
    ERROR_ITEM_GET_ERROR(120001, "系统错误:加载服务失败");


    private final int errorCode;

    private final String errorMsg;

    ErrorCode(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
