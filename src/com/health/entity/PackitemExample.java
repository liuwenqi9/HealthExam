package com.health.entity;

import java.util.ArrayList;
import java.util.List;

public class PackitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PackitemExample() {
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

        public Criteria andPackitemidIsNull() {
            addCriterion("PACKITEMID is null");
            return (Criteria) this;
        }

        public Criteria andPackitemidIsNotNull() {
            addCriterion("PACKITEMID is not null");
            return (Criteria) this;
        }

        public Criteria andPackitemidEqualTo(Integer value) {
            addCriterion("PACKITEMID =", value, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidNotEqualTo(Integer value) {
            addCriterion("PACKITEMID <>", value, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidGreaterThan(Integer value) {
            addCriterion("PACKITEMID >", value, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PACKITEMID >=", value, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidLessThan(Integer value) {
            addCriterion("PACKITEMID <", value, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidLessThanOrEqualTo(Integer value) {
            addCriterion("PACKITEMID <=", value, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidIn(List<Integer> values) {
            addCriterion("PACKITEMID in", values, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidNotIn(List<Integer> values) {
            addCriterion("PACKITEMID not in", values, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidBetween(Integer value1, Integer value2) {
            addCriterion("PACKITEMID between", value1, value2, "packitemid");
            return (Criteria) this;
        }

        public Criteria andPackitemidNotBetween(Integer value1, Integer value2) {
            addCriterion("PACKITEMID not between", value1, value2, "packitemid");
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

        public Criteria andItemidIsNull() {
            addCriterion("ITEMID is null");
            return (Criteria) this;
        }

        public Criteria andItemidIsNotNull() {
            addCriterion("ITEMID is not null");
            return (Criteria) this;
        }

        public Criteria andItemidEqualTo(Integer value) {
            addCriterion("ITEMID =", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotEqualTo(Integer value) {
            addCriterion("ITEMID <>", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThan(Integer value) {
            addCriterion("ITEMID >", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ITEMID >=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThan(Integer value) {
            addCriterion("ITEMID <", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThanOrEqualTo(Integer value) {
            addCriterion("ITEMID <=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidIn(List<Integer> values) {
            addCriterion("ITEMID in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotIn(List<Integer> values) {
            addCriterion("ITEMID not in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidBetween(Integer value1, Integer value2) {
            addCriterion("ITEMID between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotBetween(Integer value1, Integer value2) {
            addCriterion("ITEMID not between", value1, value2, "itemid");
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