package com.health.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class DetaildataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetaildataExample() {
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

        public Criteria andDataidIsNull() {
            addCriterion("DATAID is null");
            return (Criteria) this;
        }

        public Criteria andDataidIsNotNull() {
            addCriterion("DATAID is not null");
            return (Criteria) this;
        }

        public Criteria andDataidEqualTo(Integer value) {
            addCriterion("DATAID =", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotEqualTo(Integer value) {
            addCriterion("DATAID <>", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidGreaterThan(Integer value) {
            addCriterion("DATAID >", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DATAID >=", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidLessThan(Integer value) {
            addCriterion("DATAID <", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidLessThanOrEqualTo(Integer value) {
            addCriterion("DATAID <=", value, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidIn(List<Integer> values) {
            addCriterion("DATAID in", values, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotIn(List<Integer> values) {
            addCriterion("DATAID not in", values, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidBetween(Integer value1, Integer value2) {
            addCriterion("DATAID between", value1, value2, "dataid");
            return (Criteria) this;
        }

        public Criteria andDataidNotBetween(Integer value1, Integer value2) {
            addCriterion("DATAID not between", value1, value2, "dataid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidIsNull() {
            addCriterion("GUIDEITEMID is null");
            return (Criteria) this;
        }

        public Criteria andGuideitemidIsNotNull() {
            addCriterion("GUIDEITEMID is not null");
            return (Criteria) this;
        }

        public Criteria andGuideitemidEqualTo(Integer value) {
            addCriterion("GUIDEITEMID =", value, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidNotEqualTo(Integer value) {
            addCriterion("GUIDEITEMID <>", value, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidGreaterThan(Integer value) {
            addCriterion("GUIDEITEMID >", value, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("GUIDEITEMID >=", value, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidLessThan(Integer value) {
            addCriterion("GUIDEITEMID <", value, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidLessThanOrEqualTo(Integer value) {
            addCriterion("GUIDEITEMID <=", value, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidIn(List<Integer> values) {
            addCriterion("GUIDEITEMID in", values, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidNotIn(List<Integer> values) {
            addCriterion("GUIDEITEMID not in", values, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidBetween(Integer value1, Integer value2) {
            addCriterion("GUIDEITEMID between", value1, value2, "guideitemid");
            return (Criteria) this;
        }

        public Criteria andGuideitemidNotBetween(Integer value1, Integer value2) {
            addCriterion("GUIDEITEMID not between", value1, value2, "guideitemid");
            return (Criteria) this;
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

        public Criteria andDetaildataIsNull() {
            addCriterion("DETAILDATA is null");
            return (Criteria) this;
        }

        public Criteria andDetaildataIsNotNull() {
            addCriterion("DETAILDATA is not null");
            return (Criteria) this;
        }

        public Criteria andDetaildataEqualTo(BigDecimal value) {
            addCriterion("DETAILDATA =", value, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataNotEqualTo(BigDecimal value) {
            addCriterion("DETAILDATA <>", value, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataGreaterThan(BigDecimal value) {
            addCriterion("DETAILDATA >", value, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DETAILDATA >=", value, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataLessThan(BigDecimal value) {
            addCriterion("DETAILDATA <", value, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DETAILDATA <=", value, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataIn(List<BigDecimal> values) {
            addCriterion("DETAILDATA in", values, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataNotIn(List<BigDecimal> values) {
            addCriterion("DETAILDATA not in", values, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DETAILDATA between", value1, value2, "detaildata");
            return (Criteria) this;
        }

        public Criteria andDetaildataNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DETAILDATA not between", value1, value2, "detaildata");
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