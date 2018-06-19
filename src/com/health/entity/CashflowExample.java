package com.health.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class CashflowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CashflowExample() {
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

        public Criteria andCashflowidIsNull() {
            addCriterion("CASHFLOWID is null");
            return (Criteria) this;
        }

        public Criteria andCashflowidIsNotNull() {
            addCriterion("CASHFLOWID is not null");
            return (Criteria) this;
        }

        public Criteria andCashflowidEqualTo(Integer value) {
            addCriterion("CASHFLOWID =", value, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidNotEqualTo(Integer value) {
            addCriterion("CASHFLOWID <>", value, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidGreaterThan(Integer value) {
            addCriterion("CASHFLOWID >", value, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CASHFLOWID >=", value, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidLessThan(Integer value) {
            addCriterion("CASHFLOWID <", value, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidLessThanOrEqualTo(Integer value) {
            addCriterion("CASHFLOWID <=", value, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidIn(List<Integer> values) {
            addCriterion("CASHFLOWID in", values, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidNotIn(List<Integer> values) {
            addCriterion("CASHFLOWID not in", values, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidBetween(Integer value1, Integer value2) {
            addCriterion("CASHFLOWID between", value1, value2, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andCashflowidNotBetween(Integer value1, Integer value2) {
            addCriterion("CASHFLOWID not between", value1, value2, "cashflowid");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNull() {
            addCriterion("ACCOUNTID is null");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNotNull() {
            addCriterion("ACCOUNTID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountidEqualTo(Object value) {
            addCriterion("ACCOUNTID =", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotEqualTo(Object value) {
            addCriterion("ACCOUNTID <>", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThan(Object value) {
            addCriterion("ACCOUNTID >", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThanOrEqualTo(Object value) {
            addCriterion("ACCOUNTID >=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThan(Object value) {
            addCriterion("ACCOUNTID <", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThanOrEqualTo(Object value) {
            addCriterion("ACCOUNTID <=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIn(List<Object> values) {
            addCriterion("ACCOUNTID in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotIn(List<Object> values) {
            addCriterion("ACCOUNTID not in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidBetween(Object value1, Object value2) {
            addCriterion("ACCOUNTID between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotBetween(Object value1, Object value2) {
            addCriterion("ACCOUNTID not between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andReferamountIsNull() {
            addCriterion("REFERAMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReferamountIsNotNull() {
            addCriterion("REFERAMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReferamountEqualTo(Long value) {
            addCriterion("REFERAMOUNT =", value, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountNotEqualTo(Long value) {
            addCriterion("REFERAMOUNT <>", value, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountGreaterThan(Long value) {
            addCriterion("REFERAMOUNT >", value, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountGreaterThanOrEqualTo(Long value) {
            addCriterion("REFERAMOUNT >=", value, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountLessThan(Long value) {
            addCriterion("REFERAMOUNT <", value, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountLessThanOrEqualTo(Long value) {
            addCriterion("REFERAMOUNT <=", value, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountIn(List<Long> values) {
            addCriterion("REFERAMOUNT in", values, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountNotIn(List<Long> values) {
            addCriterion("REFERAMOUNT not in", values, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountBetween(Long value1, Long value2) {
            addCriterion("REFERAMOUNT between", value1, value2, "referamount");
            return (Criteria) this;
        }

        public Criteria andReferamountNotBetween(Long value1, Long value2) {
            addCriterion("REFERAMOUNT not between", value1, value2, "referamount");
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

        public Criteria andOperationIsNull() {
            addCriterion("OPERATION is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("OPERATION is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(Short value) {
            addCriterion("OPERATION =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(Short value) {
            addCriterion("OPERATION <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(Short value) {
            addCriterion("OPERATION >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(Short value) {
            addCriterion("OPERATION >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(Short value) {
            addCriterion("OPERATION <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(Short value) {
            addCriterion("OPERATION <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<Short> values) {
            addCriterion("OPERATION in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<Short> values) {
            addCriterion("OPERATION not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(Short value1, Short value2) {
            addCriterion("OPERATION between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(Short value1, Short value2) {
            addCriterion("OPERATION not between", value1, value2, "operation");
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