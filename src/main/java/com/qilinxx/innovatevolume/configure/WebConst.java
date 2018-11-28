package com.qilinxx.innovatevolume.configure;

import java.util.List;

/**
 * @Auther: dqsdc
 * @Date: 2018-11-14 16:48
 * @Description: 系统需要的所有静态字段
 */

public class WebConst {
    public static final String SESSION_USER_KEY = "super";
    public static final String SESSION_USER_VALUE = "管理员";
    public static final String SUPER_USERNAME="admin";
    public static final String SUPER_PASSWORD="123456";
    public static  final String  ALL_STUDENT="all_student";
    public static  final String  ALL_TACHER="all_teacher";
    public static final String[] VOUCHER_CATEGORY={"一般创新券","合作协议创新券","公共技术创新券","扩展型创新券","专项券"};
    public static  final String [] USER_TYPE={"提供商","科技企业","管理员"};

    //存在session中正确的验证码
    public static final String SESSION_IDENTIFY_CODE = "identify";

    public static final String USER_TYPE_PROVIDER="provider";

    public static final String USER_TYPE_ENTERPRISE="enterprise";

    public static final String IDENTIFY_TYPE_ENTERPRISE="enterprise";


}
