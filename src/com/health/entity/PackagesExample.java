package com.health.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class PackagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PackagesExample() {
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

        public Criteria andPackdetailIsNull() {
            addCriterion("PACKDETAIL is null");
            return (Criteria) this;
        }

        public Criteria andPackdetailIsNotNull() {
            addCriterion("PACKDETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andPackdetailEqualTo(Object value) {
            addCriterion("PACKDETAIL =", value, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailNotEqualTo(Object value) {
            addCriterion("PACKDETAIL <>", value, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailGreaterThan(Object value) {
            addCriterion("PACKDETAIL >", value, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailGreaterThanOrEqualTo(Object value) {
            addCriterion("PACKDETAIL >=", value, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailLessThan(Object value) {
            addCriterion("PACKDETAIL <", value, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailLessThanOrEqualTo(Object value) {
            addCriterion("PACKDETAIL <=", value, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailIn(List<Object> values) {
            addCriterion("PACKDETAIL in", values, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailNotIn(List<Object> values) {
            addCriterion("PACKDETAIL not in", values, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailBetween(Object value1, Object value2) {
            addCriterion("PACKDETAIL between", value1, value2, "packdetail");
            return (Criteria) this;
        }

        public Criteria andPackdetailNotBetween(Object value1, Object value2) {
            addCriterion("PACKDETAIL not between", value1, value2, "packdetail");
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