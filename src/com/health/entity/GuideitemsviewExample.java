package com.health.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class GuideitemsviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideitemsviewExample() {
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

        public Criteria andItemnameIsNull() {
            addCriterion("ITEMNAME is null");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNotNull() {
            addCriterion("ITEMNAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemnameEqualTo(Object value) {
            addCriterion("ITEMNAME =", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotEqualTo(Object value) {
            addCriterion("ITEMNAME <>", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThan(Object value) {
            addCriterion("ITEMNAME >", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThanOrEqualTo(Object value) {
            addCriterion("ITEMNAME >=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThan(Object value) {
            addCriterion("ITEMNAME <", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThanOrEqualTo(Object value) {
            addCriterion("ITEMNAME <=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameIn(List<Object> values) {
            addCriterion("ITEMNAME in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotIn(List<Object> values) {
            addCriterion("ITEMNAME not in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameBetween(Object value1, Object value2) {
            addCriterion("ITEMNAME between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotBetween(Object value1, Object value2) {
            addCriterion("ITEMNAME not between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("COST is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("COST is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(Long value) {
            addCriterion("COST =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(Long value) {
            addCriterion("COST <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(Long value) {
            addCriterion("COST >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(Long value) {
            addCriterion("COST >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(Long value) {
            addCriterion("COST <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(Long value) {
            addCriterion("COST <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<Long> values) {
            addCriterion("COST in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<Long> values) {
            addCriterion("COST not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(Long value1, Long value2) {
            addCriterion("COST between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(Long value1, Long value2) {
            addCriterion("COST not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNull() {
            addCriterion("CLASSIFY is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNotNull() {
            addCriterion("CLASSIFY is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyEqualTo(Short value) {
            addCriterion("CLASSIFY =", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotEqualTo(Short value) {
            addCriterion("CLASSIFY <>", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThan(Short value) {
            addCriterion("CLASSIFY >", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThanOrEqualTo(Short value) {
            addCriterion("CLASSIFY >=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThan(Short value) {
            addCriterion("CLASSIFY <", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThanOrEqualTo(Short value) {
            addCriterion("CLASSIFY <=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyIn(List<Short> values) {
            addCriterion("CLASSIFY in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotIn(List<Short> values) {
            addCriterion("CLASSIFY not in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyBetween(Short value1, Short value2) {
            addCriterion("CLASSIFY between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotBetween(Short value1, Short value2) {
            addCriterion("CLASSIFY not between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNull() {
            addCriterion("DEPTID is null");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNotNull() {
            addCriterion("DEPTID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptidEqualTo(Integer value) {
            addCriterion("DEPTID =", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotEqualTo(Integer value) {
            addCriterion("DEPTID <>", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThan(Integer value) {
            addCriterion("DEPTID >", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPTID >=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThan(Integer value) {
            addCriterion("DEPTID <", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThanOrEqualTo(Integer value) {
            addCriterion("DEPTID <=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidIn(List<Integer> values) {
            addCriterion("DEPTID in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotIn(List<Integer> values) {
            addCriterion("DEPTID not in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidBetween(Integer value1, Integer value2) {
            addCriterion("DEPTID between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPTID not between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("DEPTNAME is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("DEPTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(Object value) {
            addCriterion("DEPTNAME =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(Object value) {
            addCriterion("DEPTNAME <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(Object value) {
            addCriterion("DEPTNAME >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(Object value) {
            addCriterion("DEPTNAME >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(Object value) {
            addCriterion("DEPTNAME <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(Object value) {
            addCriterion("DEPTNAME <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<Object> values) {
            addCriterion("DEPTNAME in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<Object> values) {
            addCriterion("DEPTNAME not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(Object value1, Object value2) {
            addCriterion("DEPTNAME between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(Object value1, Object value2) {
            addCriterion("DEPTNAME not between", value1, value2, "deptname");
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