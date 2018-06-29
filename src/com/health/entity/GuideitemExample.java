package com.health.entity;

import java.util.ArrayList;
import java.util.List;

public class GuideitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideitemExample() {
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

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(Object value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(Object value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(Object value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(Object value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(Object value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(Object value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<Object> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<Object> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(Object value1, Object value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(Object value1, Object value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andExamtimeIsNull() {
            addCriterion("EXAMTIME is null");
            return (Criteria) this;
        }

        public Criteria andExamtimeIsNotNull() {
            addCriterion("EXAMTIME is not null");
            return (Criteria) this;
        }

        public Criteria andExamtimeEqualTo(Object value) {
            addCriterion("EXAMTIME =", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotEqualTo(Object value) {
            addCriterion("EXAMTIME <>", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeGreaterThan(Object value) {
            addCriterion("EXAMTIME >", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeGreaterThanOrEqualTo(Object value) {
            addCriterion("EXAMTIME >=", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLessThan(Object value) {
            addCriterion("EXAMTIME <", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLessThanOrEqualTo(Object value) {
            addCriterion("EXAMTIME <=", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeIn(List<Object> values) {
            addCriterion("EXAMTIME in", values, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotIn(List<Object> values) {
            addCriterion("EXAMTIME not in", values, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeBetween(Object value1, Object value2) {
            addCriterion("EXAMTIME between", value1, value2, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotBetween(Object value1, Object value2) {
            addCriterion("EXAMTIME not between", value1, value2, "examtime");
            return (Criteria) this;
        }

        public Criteria andPictureurlIsNull() {
            addCriterion("PICTUREURL is null");
            return (Criteria) this;
        }

        public Criteria andPictureurlIsNotNull() {
            addCriterion("PICTUREURL is not null");
            return (Criteria) this;
        }

        public Criteria andPictureurlEqualTo(Object value) {
            addCriterion("PICTUREURL =", value, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlNotEqualTo(Object value) {
            addCriterion("PICTUREURL <>", value, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlGreaterThan(Object value) {
            addCriterion("PICTUREURL >", value, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlGreaterThanOrEqualTo(Object value) {
            addCriterion("PICTUREURL >=", value, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlLessThan(Object value) {
            addCriterion("PICTUREURL <", value, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlLessThanOrEqualTo(Object value) {
            addCriterion("PICTUREURL <=", value, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlIn(List<Object> values) {
            addCriterion("PICTUREURL in", values, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlNotIn(List<Object> values) {
            addCriterion("PICTUREURL not in", values, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlBetween(Object value1, Object value2) {
            addCriterion("PICTUREURL between", value1, value2, "pictureurl");
            return (Criteria) this;
        }

        public Criteria andPictureurlNotBetween(Object value1, Object value2) {
            addCriterion("PICTUREURL not between", value1, value2, "pictureurl");
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