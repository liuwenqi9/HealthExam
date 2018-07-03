package com.health.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ExamreportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamreportExample() {
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

        public Criteria andGuidetimeIsNull() {
            addCriterion("GUIDETIME is null");
            return (Criteria) this;
        }

        public Criteria andGuidetimeIsNotNull() {
            addCriterion("GUIDETIME is not null");
            return (Criteria) this;
        }

        public Criteria andGuidetimeEqualTo(Object value) {
            addCriterion("GUIDETIME =", value, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeNotEqualTo(Object value) {
            addCriterion("GUIDETIME <>", value, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeGreaterThan(Object value) {
            addCriterion("GUIDETIME >", value, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeGreaterThanOrEqualTo(Object value) {
            addCriterion("GUIDETIME >=", value, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeLessThan(Object value) {
            addCriterion("GUIDETIME <", value, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeLessThanOrEqualTo(Object value) {
            addCriterion("GUIDETIME <=", value, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeIn(List<Object> values) {
            addCriterion("GUIDETIME in", values, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeNotIn(List<Object> values) {
            addCriterion("GUIDETIME not in", values, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeBetween(Object value1, Object value2) {
            addCriterion("GUIDETIME between", value1, value2, "guidetime");
            return (Criteria) this;
        }

        public Criteria andGuidetimeNotBetween(Object value1, Object value2) {
            addCriterion("GUIDETIME not between", value1, value2, "guidetime");
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

        public Criteria andDetailnameIsNull() {
            addCriterion("DETAILNAME is null");
            return (Criteria) this;
        }

        public Criteria andDetailnameIsNotNull() {
            addCriterion("DETAILNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDetailnameEqualTo(Object value) {
            addCriterion("DETAILNAME =", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameNotEqualTo(Object value) {
            addCriterion("DETAILNAME <>", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameGreaterThan(Object value) {
            addCriterion("DETAILNAME >", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameGreaterThanOrEqualTo(Object value) {
            addCriterion("DETAILNAME >=", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameLessThan(Object value) {
            addCriterion("DETAILNAME <", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameLessThanOrEqualTo(Object value) {
            addCriterion("DETAILNAME <=", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameIn(List<Object> values) {
            addCriterion("DETAILNAME in", values, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameNotIn(List<Object> values) {
            addCriterion("DETAILNAME not in", values, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameBetween(Object value1, Object value2) {
            addCriterion("DETAILNAME between", value1, value2, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameNotBetween(Object value1, Object value2) {
            addCriterion("DETAILNAME not between", value1, value2, "detailname");
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

        public Criteria andParameteridIsNull() {
            addCriterion("PARAMETERID is null");
            return (Criteria) this;
        }

        public Criteria andParameteridIsNotNull() {
            addCriterion("PARAMETERID is not null");
            return (Criteria) this;
        }

        public Criteria andParameteridEqualTo(Integer value) {
            addCriterion("PARAMETERID =", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridNotEqualTo(Integer value) {
            addCriterion("PARAMETERID <>", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridGreaterThan(Integer value) {
            addCriterion("PARAMETERID >", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARAMETERID >=", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridLessThan(Integer value) {
            addCriterion("PARAMETERID <", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridLessThanOrEqualTo(Integer value) {
            addCriterion("PARAMETERID <=", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridIn(List<Integer> values) {
            addCriterion("PARAMETERID in", values, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridNotIn(List<Integer> values) {
            addCriterion("PARAMETERID not in", values, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridBetween(Integer value1, Integer value2) {
            addCriterion("PARAMETERID between", value1, value2, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridNotBetween(Integer value1, Integer value2) {
            addCriterion("PARAMETERID not between", value1, value2, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParamnameIsNull() {
            addCriterion("PARAMNAME is null");
            return (Criteria) this;
        }

        public Criteria andParamnameIsNotNull() {
            addCriterion("PARAMNAME is not null");
            return (Criteria) this;
        }

        public Criteria andParamnameEqualTo(Object value) {
            addCriterion("PARAMNAME =", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotEqualTo(Object value) {
            addCriterion("PARAMNAME <>", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThan(Object value) {
            addCriterion("PARAMNAME >", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThanOrEqualTo(Object value) {
            addCriterion("PARAMNAME >=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThan(Object value) {
            addCriterion("PARAMNAME <", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThanOrEqualTo(Object value) {
            addCriterion("PARAMNAME <=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameIn(List<Object> values) {
            addCriterion("PARAMNAME in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotIn(List<Object> values) {
            addCriterion("PARAMNAME not in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameBetween(Object value1, Object value2) {
            addCriterion("PARAMNAME between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotBetween(Object value1, Object value2) {
            addCriterion("PARAMNAME not between", value1, value2, "paramname");
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