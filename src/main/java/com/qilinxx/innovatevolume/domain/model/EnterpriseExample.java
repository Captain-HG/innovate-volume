package com.qilinxx.innovatevolume.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andAdminIsNull() {
            addCriterion("admin is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsNotNull() {
            addCriterion("admin is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEqualTo(String value) {
            addCriterion("admin =", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotEqualTo(String value) {
            addCriterion("admin <>", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThan(String value) {
            addCriterion("admin >", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThanOrEqualTo(String value) {
            addCriterion("admin >=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThan(String value) {
            addCriterion("admin <", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThanOrEqualTo(String value) {
            addCriterion("admin <=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLike(String value) {
            addCriterion("admin like", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotLike(String value) {
            addCriterion("admin not like", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminIn(List<String> values) {
            addCriterion("admin in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotIn(List<String> values) {
            addCriterion("admin not in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminBetween(String value1, String value2) {
            addCriterion("admin between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotBetween(String value1, String value2) {
            addCriterion("admin not between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNull() {
            addCriterion("reg_date is null");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNotNull() {
            addCriterion("reg_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegDateEqualTo(Long value) {
            addCriterion("reg_date =", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotEqualTo(Long value) {
            addCriterion("reg_date <>", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThan(Long value) {
            addCriterion("reg_date >", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThanOrEqualTo(Long value) {
            addCriterion("reg_date >=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThan(Long value) {
            addCriterion("reg_date <", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThanOrEqualTo(Long value) {
            addCriterion("reg_date <=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateIn(List<Long> values) {
            addCriterion("reg_date in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotIn(List<Long> values) {
            addCriterion("reg_date not in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateBetween(Long value1, Long value2) {
            addCriterion("reg_date between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotBetween(Long value1, Long value2) {
            addCriterion("reg_date not between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateIsNull() {
            addCriterion("found_date is null");
            return (Criteria) this;
        }

        public Criteria andFoundDateIsNotNull() {
            addCriterion("found_date is not null");
            return (Criteria) this;
        }

        public Criteria andFoundDateEqualTo(Long value) {
            addCriterion("found_date =", value, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateNotEqualTo(Long value) {
            addCriterion("found_date <>", value, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateGreaterThan(Long value) {
            addCriterion("found_date >", value, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateGreaterThanOrEqualTo(Long value) {
            addCriterion("found_date >=", value, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateLessThan(Long value) {
            addCriterion("found_date <", value, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateLessThanOrEqualTo(Long value) {
            addCriterion("found_date <=", value, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateIn(List<Long> values) {
            addCriterion("found_date in", values, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateNotIn(List<Long> values) {
            addCriterion("found_date not in", values, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateBetween(Long value1, Long value2) {
            addCriterion("found_date between", value1, value2, "foundDate");
            return (Criteria) this;
        }

        public Criteria andFoundDateNotBetween(Long value1, Long value2) {
            addCriterion("found_date not between", value1, value2, "foundDate");
            return (Criteria) this;
        }

        public Criteria andRegMoneyIsNull() {
            addCriterion("reg_money is null");
            return (Criteria) this;
        }

        public Criteria andRegMoneyIsNotNull() {
            addCriterion("reg_money is not null");
            return (Criteria) this;
        }

        public Criteria andRegMoneyEqualTo(BigDecimal value) {
            addCriterion("reg_money =", value, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyNotEqualTo(BigDecimal value) {
            addCriterion("reg_money <>", value, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyGreaterThan(BigDecimal value) {
            addCriterion("reg_money >", value, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reg_money >=", value, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyLessThan(BigDecimal value) {
            addCriterion("reg_money <", value, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reg_money <=", value, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyIn(List<BigDecimal> values) {
            addCriterion("reg_money in", values, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyNotIn(List<BigDecimal> values) {
            addCriterion("reg_money not in", values, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reg_money between", value1, value2, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reg_money not between", value1, value2, "regMoney");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNull() {
            addCriterion("reg_addr is null");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNotNull() {
            addCriterion("reg_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRegAddrEqualTo(String value) {
            addCriterion("reg_addr =", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotEqualTo(String value) {
            addCriterion("reg_addr <>", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThan(String value) {
            addCriterion("reg_addr >", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThanOrEqualTo(String value) {
            addCriterion("reg_addr >=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThan(String value) {
            addCriterion("reg_addr <", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThanOrEqualTo(String value) {
            addCriterion("reg_addr <=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLike(String value) {
            addCriterion("reg_addr like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotLike(String value) {
            addCriterion("reg_addr not like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrIn(List<String> values) {
            addCriterion("reg_addr in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotIn(List<String> values) {
            addCriterion("reg_addr not in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrBetween(String value1, String value2) {
            addCriterion("reg_addr between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotBetween(String value1, String value2) {
            addCriterion("reg_addr not between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrIsNull() {
            addCriterion("contact_addr is null");
            return (Criteria) this;
        }

        public Criteria andContactAddrIsNotNull() {
            addCriterion("contact_addr is not null");
            return (Criteria) this;
        }

        public Criteria andContactAddrEqualTo(String value) {
            addCriterion("contact_addr =", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrNotEqualTo(String value) {
            addCriterion("contact_addr <>", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrGreaterThan(String value) {
            addCriterion("contact_addr >", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrGreaterThanOrEqualTo(String value) {
            addCriterion("contact_addr >=", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrLessThan(String value) {
            addCriterion("contact_addr <", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrLessThanOrEqualTo(String value) {
            addCriterion("contact_addr <=", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrLike(String value) {
            addCriterion("contact_addr like", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrNotLike(String value) {
            addCriterion("contact_addr not like", value, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrIn(List<String> values) {
            addCriterion("contact_addr in", values, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrNotIn(List<String> values) {
            addCriterion("contact_addr not in", values, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrBetween(String value1, String value2) {
            addCriterion("contact_addr between", value1, value2, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andContactAddrNotBetween(String value1, String value2) {
            addCriterion("contact_addr not between", value1, value2, "contactAddr");
            return (Criteria) this;
        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return (Criteria) this;
        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return (Criteria) this;
        }

        public Criteria andSalesEqualTo(BigDecimal value) {
            addCriterion("sales =", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotEqualTo(BigDecimal value) {
            addCriterion("sales <>", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThan(BigDecimal value) {
            addCriterion("sales >", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales >=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThan(BigDecimal value) {
            addCriterion("sales <", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales <=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesIn(List<BigDecimal> values) {
            addCriterion("sales in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotIn(List<BigDecimal> values) {
            addCriterion("sales not in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andTaxsIsNull() {
            addCriterion("taxs is null");
            return (Criteria) this;
        }

        public Criteria andTaxsIsNotNull() {
            addCriterion("taxs is not null");
            return (Criteria) this;
        }

        public Criteria andTaxsEqualTo(BigDecimal value) {
            addCriterion("taxs =", value, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsNotEqualTo(BigDecimal value) {
            addCriterion("taxs <>", value, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsGreaterThan(BigDecimal value) {
            addCriterion("taxs >", value, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taxs >=", value, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsLessThan(BigDecimal value) {
            addCriterion("taxs <", value, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taxs <=", value, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsIn(List<BigDecimal> values) {
            addCriterion("taxs in", values, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsNotIn(List<BigDecimal> values) {
            addCriterion("taxs not in", values, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxs between", value1, value2, "taxs");
            return (Criteria) this;
        }

        public Criteria andTaxsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxs not between", value1, value2, "taxs");
            return (Criteria) this;
        }

        public Criteria andNetAssetsIsNull() {
            addCriterion("net_assets is null");
            return (Criteria) this;
        }

        public Criteria andNetAssetsIsNotNull() {
            addCriterion("net_assets is not null");
            return (Criteria) this;
        }

        public Criteria andNetAssetsEqualTo(BigDecimal value) {
            addCriterion("net_assets =", value, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsNotEqualTo(BigDecimal value) {
            addCriterion("net_assets <>", value, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsGreaterThan(BigDecimal value) {
            addCriterion("net_assets >", value, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_assets >=", value, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsLessThan(BigDecimal value) {
            addCriterion("net_assets <", value, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_assets <=", value, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsIn(List<BigDecimal> values) {
            addCriterion("net_assets in", values, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsNotIn(List<BigDecimal> values) {
            addCriterion("net_assets not in", values, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_assets between", value1, value2, "netAssets");
            return (Criteria) this;
        }

        public Criteria andNetAssetsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_assets not between", value1, value2, "netAssets");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("domain is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("domain =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("domain <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("domain >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("domain >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("domain <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("domain <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("domain like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("domain not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("domain in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("domain not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("domain between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("domain not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andIdentifyIsNull() {
            addCriterion("identify is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyIsNotNull() {
            addCriterion("identify is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyEqualTo(String value) {
            addCriterion("identify =", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotEqualTo(String value) {
            addCriterion("identify <>", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyGreaterThan(String value) {
            addCriterion("identify >", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("identify >=", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLessThan(String value) {
            addCriterion("identify <", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLessThanOrEqualTo(String value) {
            addCriterion("identify <=", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLike(String value) {
            addCriterion("identify like", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotLike(String value) {
            addCriterion("identify not like", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyIn(List<String> values) {
            addCriterion("identify in", values, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotIn(List<String> values) {
            addCriterion("identify not in", values, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyBetween(String value1, String value2) {
            addCriterion("identify between", value1, value2, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotBetween(String value1, String value2) {
            addCriterion("identify not between", value1, value2, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoIsNull() {
            addCriterion("identify_no is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoIsNotNull() {
            addCriterion("identify_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoEqualTo(String value) {
            addCriterion("identify_no =", value, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoNotEqualTo(String value) {
            addCriterion("identify_no <>", value, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoGreaterThan(String value) {
            addCriterion("identify_no >", value, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoGreaterThanOrEqualTo(String value) {
            addCriterion("identify_no >=", value, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoLessThan(String value) {
            addCriterion("identify_no <", value, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoLessThanOrEqualTo(String value) {
            addCriterion("identify_no <=", value, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoLike(String value) {
            addCriterion("identify_no like", value, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoNotLike(String value) {
            addCriterion("identify_no not like", value, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoIn(List<String> values) {
            addCriterion("identify_no in", values, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoNotIn(List<String> values) {
            addCriterion("identify_no not in", values, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoBetween(String value1, String value2) {
            addCriterion("identify_no between", value1, value2, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andIdentifyNoNotBetween(String value1, String value2) {
            addCriterion("identify_no not between", value1, value2, "identifyNo");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardOwnerIsNull() {
            addCriterion("card_owner is null");
            return (Criteria) this;
        }

        public Criteria andCardOwnerIsNotNull() {
            addCriterion("card_owner is not null");
            return (Criteria) this;
        }

        public Criteria andCardOwnerEqualTo(String value) {
            addCriterion("card_owner =", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerNotEqualTo(String value) {
            addCriterion("card_owner <>", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerGreaterThan(String value) {
            addCriterion("card_owner >", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("card_owner >=", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerLessThan(String value) {
            addCriterion("card_owner <", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerLessThanOrEqualTo(String value) {
            addCriterion("card_owner <=", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerLike(String value) {
            addCriterion("card_owner like", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerNotLike(String value) {
            addCriterion("card_owner not like", value, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerIn(List<String> values) {
            addCriterion("card_owner in", values, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerNotIn(List<String> values) {
            addCriterion("card_owner not in", values, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerBetween(String value1, String value2) {
            addCriterion("card_owner between", value1, value2, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andCardOwnerNotBetween(String value1, String value2) {
            addCriterion("card_owner not between", value1, value2, "cardOwner");
            return (Criteria) this;
        }

        public Criteria andContacterIsNull() {
            addCriterion("contacter is null");
            return (Criteria) this;
        }

        public Criteria andContacterIsNotNull() {
            addCriterion("contacter is not null");
            return (Criteria) this;
        }

        public Criteria andContacterEqualTo(String value) {
            addCriterion("contacter =", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotEqualTo(String value) {
            addCriterion("contacter <>", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterGreaterThan(String value) {
            addCriterion("contacter >", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterGreaterThanOrEqualTo(String value) {
            addCriterion("contacter >=", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLessThan(String value) {
            addCriterion("contacter <", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLessThanOrEqualTo(String value) {
            addCriterion("contacter <=", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLike(String value) {
            addCriterion("contacter like", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotLike(String value) {
            addCriterion("contacter not like", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterIn(List<String> values) {
            addCriterion("contacter in", values, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotIn(List<String> values) {
            addCriterion("contacter not in", values, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterBetween(String value1, String value2) {
            addCriterion("contacter between", value1, value2, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotBetween(String value1, String value2) {
            addCriterion("contacter not between", value1, value2, "contacter");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNull() {
            addCriterion("contact_email is null");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNotNull() {
            addCriterion("contact_email is not null");
            return (Criteria) this;
        }

        public Criteria andContactEmailEqualTo(String value) {
            addCriterion("contact_email =", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotEqualTo(String value) {
            addCriterion("contact_email <>", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThan(String value) {
            addCriterion("contact_email >", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThanOrEqualTo(String value) {
            addCriterion("contact_email >=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThan(String value) {
            addCriterion("contact_email <", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThanOrEqualTo(String value) {
            addCriterion("contact_email <=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLike(String value) {
            addCriterion("contact_email like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotLike(String value) {
            addCriterion("contact_email not like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailIn(List<String> values) {
            addCriterion("contact_email in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotIn(List<String> values) {
            addCriterion("contact_email not in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailBetween(String value1, String value2) {
            addCriterion("contact_email between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotBetween(String value1, String value2) {
            addCriterion("contact_email not between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(String value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(String value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(String value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(String value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(String value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(String value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLike(String value) {
            addCriterion("is_use like", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotLike(String value) {
            addCriterion("is_use not like", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<String> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<String> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(String value1, String value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(String value1, String value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("updater is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("updater is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("updater =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("updater <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("updater >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("updater >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("updater <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("updater <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("updater like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("updater not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("updater in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("updater not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("updater between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("updater not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}