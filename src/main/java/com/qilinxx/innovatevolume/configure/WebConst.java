package com.qilinxx.innovatevolume.configure;

/**
 * @Auther: dqsdc
 * @Date: 2018-11-14 16:48
 * @Description: 系统需要的所有静态字段
 */

public class WebConst {


    //UserInfo的类型
    public static final String USER_TYPE_PROVIDER = "provider";
    public static final String USER_TYPE_ENTERPRISE = "enterprise";
    public static final String USER_TYPE_ADMIN = "admin";

    //创新券的类型
    public static final String[] VOUCHER_CATEGORY = {"一般创新券", "合作协议创新券", "公共技术创新券", "扩展型创新券", "专项券"};

    //服务提供商类型
    public static final String PROVIDER_SECIENCE = "科技";
    public static final String PROVIDER_FARMING = "农业";
    public static final String PROVIDER_ELECTRONIC = "电子信息";
    public static final String PROVIDER_OTHER = "其他";

    //人才类型
    public static final String MEMBER_HIGH = "高级人才";
    public static final String MEMBER_MIDDLE = "中级人才";
    public static final String MEMBER_LOW = "初级人才";

    //创新科技企业的单位性质
    public static final String ENTERPRISE_UNIT_TEAM = "创新团队";
    public static final String ENTERPRISE_UNIT_SCIENCE = "科技企业";
    public static final String ENTERPRISE_UNIT_OTHER = "其他";

    //创新科技企业的产业领域
    public static final String ENTERPRISE_DOMAIN_TECHNOLOGY = "科学技术领域";
    public static final String ENTERPRISE_DOMAIN_SERVICE = "服务类领域";
    public static final String ENTERPRISE_DOMAIN_FARMING = "农业类领域";

    //创新科技企业的企业认定情况
    public static final String ENTERPRISE_IDENTIFY_YES = "已认定";
    public static final String ENTERPRISE_IDENTIFY_NO = "未认定";

    //核心领军人员学位
    public static final String DEGREE_COLLAGE = "本科";
    public static final String DEGREE_MASTER = "硕士";
    public static final String DEGREE_DOCTOR = "博士";

    public static final String[] USER_TYPE = {"提供商", "科技企业", "管理员"};

    //存在session中正确的验证码
    public static final String SESSION_IDENTIFY_CODE = "identify";

    public static final String SESSION_USER_NAME = "username";
}
