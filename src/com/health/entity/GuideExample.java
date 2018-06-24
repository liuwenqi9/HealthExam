package com.health.entity;

import java.util.ArrayList;
import java.util.List;

public class GuideExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideExample() {
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

        public Criteria andPersoninfoidIsNull() {
            addCriterion("PERSONINFOID is null");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidIsNotNull() {
            addCriterion("PERSONINFOID is not null");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidEqualTo(Integer value) {
            addCriterion("PERSONINFOID =", value, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidNotEqualTo(Integer value) {
            addCriterion("PERSONINFOID <>", value, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidGreaterThan(Integer value) {
            addCriterion("PERSONINFOID >", value, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PERSONINFOID >=", value, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidLessThan(Integer value) {
            addCriterion("PERSONINFOID <", value, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidLessThanOrEqualTo(Integer value) {
            addCriterion("PERSONINFOID <=", value, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidIn(List<Integer> values) {
            addCriterion("PERSONINFOID in", values, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidNotIn(List<Integer> values) {
            addCriterion("PERSONINFOID not in", values, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidBetween(Integer value1, Integer value2) {
            addCriterion("PERSONINFOID between", value1, value2, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andPersoninfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("PERSONINFOID not between", value1, value2, "personinfoid");
            return (Criteria) this;
        }

        public Criteria andAllsummaryIsNull() {
            addCriterion("ALLSUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andAllsummaryIsNotNull() {
            addCriterion("ALLSUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andAllsummaryEqualTo(Object value) {
            addCriterion("ALLSUMMARY =", value, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryNotEqualTo(Object value) {
            addCriterion("ALLSUMMARY <>", value, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryGreaterThan(Object value) {
            addCriterion("ALLSUMMARY >", value, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryGreaterThanOrEqualTo(Object value) {
            addCriterion("ALLSUMMARY >=", value, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryLessThan(Object value) {
            addCriterion("ALLSUMMARY <", value, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryLessThanOrEqualTo(Object value) {
            addCriterion("ALLSUMMARY <=", value, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryIn(List<Object> values) {
            addCriterion("ALLSUMMARY in", values, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryNotIn(List<Object> values) {
            addCriterion("ALLSUMMARY not in", values, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryBetween(Object value1, Object value2) {
            addCriterion("ALLSUMMARY between", value1, value2, "allsummary");
            return (Criteria) this;
        }

        public Criteria andAllsummaryNotBetween(Object value1, Object value2) {
            addCriterion("ALLSUMMARY not between", value1, value2, "allsummary");
            return (Criteria) this;
        }

        public Criteria andOvertimeIsNull() {
            addCriterion("OVERTIME is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeIsNotNull() {
            addCriterion("OVERTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeEqualTo(Object value) {
            addCriterion("OVERTIME =", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotEqualTo(Object value) {
            addCriterion("OVERTIME <>", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeGreaterThan(Object value) {
            addCriterion("OVERTIME >", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeGreaterThanOrEqualTo(Object value) {
            addCriterion("OVERTIME >=", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLessThan(Object value) {
            addCriterion("OVERTIME <", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLessThanOrEqualTo(Object value) {
            addCriterion("OVERTIME <=", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeIn(List<Object> values) {
            addCriterion("OVERTIME in", values, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotIn(List<Object> values) {
            addCriterion("OVERTIME not in", values, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeBetween(Object value1, Object value2) {
            addCriterion("OVERTIME between", value1, value2, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotBetween(Object value1, Object value2) {
            addCriterion("OVERTIME not between", value1, value2, "overtime");
            return (Criteria) this;
        }

        public Criteria andChargeidIsNull() {
            addCriterion("CHARGEID is null");
            return (Criteria) this;
        }

        public Criteria andChargeidIsNotNull() {
            addCriterion("CHARGEID is not null");
            return (Criteria) this;
        }

        public Criteria andChargeidEqualTo(Integer value) {
            addCriterion("CHARGEID =", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidNotEqualTo(Integer value) {
            addCriterion("CHARGEID <>", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidGreaterThan(Integer value) {
            addCriterion("CHARGEID >", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHARGEID >=", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidLessThan(Integer value) {
            addCriterion("CHARGEID <", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidLessThanOrEqualTo(Integer value) {
            addCriterion("CHARGEID <=", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidIn(List<Integer> values) {
            addCriterion("CHARGEID in", values, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidNotIn(List<Integer> values) {
            addCriterion("CHARGEID not in", values, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidBetween(Integer value1, Integer value2) {
            addCriterion("CHARGEID between", value1, value2, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidNotBetween(Integer value1, Integer value2) {
            addCriterion("CHARGEID not between", value1, value2, "chargeid");
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