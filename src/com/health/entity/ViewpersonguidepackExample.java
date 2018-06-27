package com.health.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class ViewpersonguidepackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewpersonguidepackExample() {
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

        public Criteria andRownumberIsNull() {
            addCriterion("ROWNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andRownumberIsNotNull() {
            addCriterion("ROWNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andRownumberEqualTo(BigDecimal value) {
            addCriterion("ROWNUMBER =", value, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberNotEqualTo(BigDecimal value) {
            addCriterion("ROWNUMBER <>", value, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberGreaterThan(BigDecimal value) {
            addCriterion("ROWNUMBER >", value, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ROWNUMBER >=", value, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberLessThan(BigDecimal value) {
            addCriterion("ROWNUMBER <", value, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ROWNUMBER <=", value, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberIn(List<BigDecimal> values) {
            addCriterion("ROWNUMBER in", values, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberNotIn(List<BigDecimal> values) {
            addCriterion("ROWNUMBER not in", values, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ROWNUMBER between", value1, value2, "rownumber");
            return (Criteria) this;
        }

        public Criteria andRownumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ROWNUMBER not between", value1, value2, "rownumber");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(Object value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(Object value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(Object value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(Object value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(Object value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(Object value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<Object> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<Object> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(Object value1, Object value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(Object value1, Object value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(Object value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(Object value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(Object value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(Object value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(Object value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(Object value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<Object> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<Object> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(Object value1, Object value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(Object value1, Object value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andGuideidIsNull() {
            addCriterion("GUIDEID is null");
            return (Criteria) this;
        }

        public Criteria andGuideidIsNotNull() {
            addCriterion("GUIDEID is not null");
            return (Criteria) this;
        }

        public Criteria andGuideidEqualTo(Integer value) {
            addCriterion("GUIDEID =", value, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidNotEqualTo(Integer value) {
            addCriterion("GUIDEID <>", value, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidGreaterThan(Integer value) {
            addCriterion("GUIDEID >", value, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidGreaterThanOrEqualTo(Integer value) {
            addCriterion("GUIDEID >=", value, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidLessThan(Integer value) {
            addCriterion("GUIDEID <", value, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidLessThanOrEqualTo(Integer value) {
            addCriterion("GUIDEID <=", value, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidIn(List<Integer> values) {
            addCriterion("GUIDEID in", values, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidNotIn(List<Integer> values) {
            addCriterion("GUIDEID not in", values, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidBetween(Integer value1, Integer value2) {
            addCriterion("GUIDEID between", value1, value2, "guideid");
            return (Criteria) this;
        }

        public Criteria andGuideidNotBetween(Integer value1, Integer value2) {
            addCriterion("GUIDEID not between", value1, value2, "guideid");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("TIME is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Object value) {
            addCriterion("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Object value) {
            addCriterion("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Object value) {
            addCriterion("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Object value) {
            addCriterion("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Object value) {
            addCriterion("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Object value) {
            addCriterion("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Object> values) {
            addCriterion("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Object> values) {
            addCriterion("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Object value1, Object value2) {
            addCriterion("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Object value1, Object value2) {
            addCriterion("TIME not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Short value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Short value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Short value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Short value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Short value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Short value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Short> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Short> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Short value1, Short value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Short value1, Short value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPackageidIsNull() {
            addCriterion("PACKAGEID is null");
            return (Criteria) this;
        }

        public Criteria andPackageidIsNotNull() {
            addCriterion("PACKAGEID is not null");
            return (Criteria) this;
        }

        public Criteria andPackageidEqualTo(Integer value) {
            addCriterion("PACKAGEID =", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotEqualTo(Integer value) {
            addCriterion("PACKAGEID <>", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidGreaterThan(Integer value) {
            addCriterion("PACKAGEID >", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PACKAGEID >=", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidLessThan(Integer value) {
            addCriterion("PACKAGEID <", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidLessThanOrEqualTo(Integer value) {
            addCriterion("PACKAGEID <=", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidIn(List<Integer> values) {
            addCriterion("PACKAGEID in", values, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotIn(List<Integer> values) {
            addCriterion("PACKAGEID not in", values, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidBetween(Integer value1, Integer value2) {
            addCriterion("PACKAGEID between", value1, value2, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotBetween(Integer value1, Integer value2) {
            addCriterion("PACKAGEID not between", value1, value2, "packageid");
            return (Criteria) this;
        }

        public Criteria andPacknameIsNull() {
            addCriterion("PACKNAME is null");
            return (Criteria) this;
        }

        public Criteria andPacknameIsNotNull() {
            addCriterion("PACKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andPacknameEqualTo(Object value) {
            addCriterion("PACKNAME =", value, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameNotEqualTo(Object value) {
            addCriterion("PACKNAME <>", value, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameGreaterThan(Object value) {
            addCriterion("PACKNAME >", value, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameGreaterThanOrEqualTo(Object value) {
            addCriterion("PACKNAME >=", value, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameLessThan(Object value) {
            addCriterion("PACKNAME <", value, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameLessThanOrEqualTo(Object value) {
            addCriterion("PACKNAME <=", value, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameIn(List<Object> values) {
            addCriterion("PACKNAME in", values, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameNotIn(List<Object> values) {
            addCriterion("PACKNAME not in", values, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameBetween(Object value1, Object value2) {
            addCriterion("PACKNAME between", value1, value2, "packname");
            return (Criteria) this;
        }

        public Criteria andPacknameNotBetween(Object value1, Object value2) {
            addCriterion("PACKNAME not between", value1, value2, "packname");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
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