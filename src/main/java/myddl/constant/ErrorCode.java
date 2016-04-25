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
    ERROR_USER_NOT_EXSIST(10001, "用户不存在");


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
