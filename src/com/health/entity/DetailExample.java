package com.health.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetailExample() {
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

        public Criteria andDetailidIsNull() {
            addCriterion("DETAILID is null");
            return (Criteria) this;
        }

        public Criteria andDetailidIsNotNull() {
            addCriterion("DETAILID is not null");
            return (Criteria) this;
        }

        public Criteria andDetailidEqualTo(Integer value) {
            addCriterion("DETAILID =", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotEqualTo(Integer value) {
            addCriterion("DETAILID <>", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThan(Integer value) {
            addCriterion("DETAILID >", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DETAILID >=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThan(Integer value) {
            addCriterion("DETAILID <", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThanOrEqualTo(Integer value) {
            addCriterion("DETAILID <=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidIn(List<Integer> values) {
            addCriterion("DETAILID in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotIn(List<Integer> values) {
            addCriterion("DETAILID not in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidBetween(Integer value1, Integer value2) {
            addCriterion("DETAILID between", value1, value2, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotBetween(Integer value1, Integer value2) {
            addCriterion("DETAILID not between", value1, value2, "detailid");
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

        public Criteria andParamidIsNull() {
            addCriterion("PARAMID is null");
            return (Criteria) this;
        }

        public Criteria andParamidIsNotNull() {
            addCriterion("PARAMID is not null");
            return (Criteria) this;
        }

        public Criteria andParamidEqualTo(Integer value) {
            addCriterion("PARAMID =", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidNotEqualTo(Integer value) {
            addCriterion("PARAMID <>", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidGreaterThan(Integer value) {
            addCriterion("PARAMID >", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARAMID >=", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidLessThan(Integer value) {
            addCriterion("PARAMID <", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidLessThanOrEqualTo(Integer value) {
            addCriterion("PARAMID <=", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidIn(List<Integer> values) {
            addCriterion("PARAMID in", values, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidNotIn(List<Integer> values) {
            addCriterion("PARAMID not in", values, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidBetween(Integer value1, Integer value2) {
            addCriterion("PARAMID between", value1, value2, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidNotBetween(Integer value1, Integer value2) {
            addCriterion("PARAMID not between", value1, value2, "paramid");
            return (Criteria) this;
        }

        public Criteria andUplimitIsNull() {
            addCriterion("UPLIMIT is null");
            return (Criteria) this;
        }

        public Criteria andUplimitIsNotNull() {
            addCriterion("UPLIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andUplimitEqualTo(BigDecimal value) {
            addCriterion("UPLIMIT =", value, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitNotEqualTo(BigDecimal value) {
            addCriterion("UPLIMIT <>", value, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitGreaterThan(BigDecimal value) {
            addCriterion("UPLIMIT >", value, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UPLIMIT >=", value, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitLessThan(BigDecimal value) {
            addCriterion("UPLIMIT <", value, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UPLIMIT <=", value, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitIn(List<BigDecimal> values) {
            addCriterion("UPLIMIT in", values, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitNotIn(List<BigDecimal> values) {
            addCriterion("UPLIMIT not in", values, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UPLIMIT between", value1, value2, "uplimit");
            return (Criteria) this;
        }

        public Criteria andUplimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UPLIMIT not between", value1, value2, "uplimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitIsNull() {
            addCriterion("LOWLIMIT is null");
            return (Criteria) this;
        }

        public Criteria andLowlimitIsNotNull() {
            addCriterion("LOWLIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andLowlimitEqualTo(BigDecimal value) {
            addCriterion("LOWLIMIT =", value, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitNotEqualTo(BigDecimal value) {
            addCriterion("LOWLIMIT <>", value, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitGreaterThan(BigDecimal value) {
            addCriterion("LOWLIMIT >", value, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOWLIMIT >=", value, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitLessThan(BigDecimal value) {
            addCriterion("LOWLIMIT <", value, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOWLIMIT <=", value, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitIn(List<BigDecimal> values) {
            addCriterion("LOWLIMIT in", values, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitNotIn(List<BigDecimal> values) {
            addCriterion("LOWLIMIT not in", values, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOWLIMIT between", value1, value2, "lowlimit");
            return (Criteria) this;
        }

        public Criteria andLowlimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOWLIMIT not between", value1, value2, "lowlimit");
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