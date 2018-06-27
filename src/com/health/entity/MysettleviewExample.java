package com.health.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MysettleviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MysettleviewExample() {
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

        public Criteria andCompanyaccIsNull() {
            addCriterion("COMPANYACC is null");
            return (Criteria) this;
        }

        public Criteria andCompanyaccIsNotNull() {
            addCriterion("COMPANYACC is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyaccEqualTo(Object value) {
            addCriterion("COMPANYACC =", value, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccNotEqualTo(Object value) {
            addCriterion("COMPANYACC <>", value, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccGreaterThan(Object value) {
            addCriterion("COMPANYACC >", value, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccGreaterThanOrEqualTo(Object value) {
            addCriterion("COMPANYACC >=", value, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccLessThan(Object value) {
            addCriterion("COMPANYACC <", value, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccLessThanOrEqualTo(Object value) {
            addCriterion("COMPANYACC <=", value, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccIn(List<Object> values) {
            addCriterion("COMPANYACC in", values, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccNotIn(List<Object> values) {
            addCriterion("COMPANYACC not in", values, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccBetween(Object value1, Object value2) {
            addCriterion("COMPANYACC between", value1, value2, "companyacc");
            return (Criteria) this;
        }

        public Criteria andCompanyaccNotBetween(Object value1, Object value2) {
            addCriterion("COMPANYACC not between", value1, value2, "companyacc");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andRecordtimeIsNull() {
            addCriterion("RECORDTIME is null");
            return (Criteria) this;
        }

        public Criteria andRecordtimeIsNotNull() {
            addCriterion("RECORDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRecordtimeEqualTo(Object value) {
            addCriterion("RECORDTIME =", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotEqualTo(Object value) {
            addCriterion("RECORDTIME <>", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeGreaterThan(Object value) {
            addCriterion("RECORDTIME >", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeGreaterThanOrEqualTo(Object value) {
            addCriterion("RECORDTIME >=", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeLessThan(Object value) {
            addCriterion("RECORDTIME <", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeLessThanOrEqualTo(Object value) {
            addCriterion("RECORDTIME <=", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeIn(List<Object> values) {
            addCriterion("RECORDTIME in", values, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotIn(List<Object> values) {
            addCriterion("RECORDTIME not in", values, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeBetween(Object value1, Object value2) {
            addCriterion("RECORDTIME between", value1, value2, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotBetween(Object value1, Object value2) {
            addCriterion("RECORDTIME not between", value1, value2, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordstateIsNull() {
            addCriterion("RECORDSTATE is null");
            return (Criteria) this;
        }

        public Criteria andRecordstateIsNotNull() {
            addCriterion("RECORDSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andRecordstateEqualTo(Integer value) {
            addCriterion("RECORDSTATE =", value, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateNotEqualTo(Integer value) {
            addCriterion("RECORDSTATE <>", value, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateGreaterThan(Integer value) {
            addCriterion("RECORDSTATE >", value, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECORDSTATE >=", value, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateLessThan(Integer value) {
            addCriterion("RECORDSTATE <", value, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateLessThanOrEqualTo(Integer value) {
            addCriterion("RECORDSTATE <=", value, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateIn(List<Integer> values) {
            addCriterion("RECORDSTATE in", values, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateNotIn(List<Integer> values) {
            addCriterion("RECORDSTATE not in", values, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateBetween(Integer value1, Integer value2) {
            addCriterion("RECORDSTATE between", value1, value2, "recordstate");
            return (Criteria) this;
        }

        public Criteria andRecordstateNotBetween(Integer value1, Integer value2) {
            addCriterion("RECORDSTATE not between", value1, value2, "recordstate");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("PID not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("PNAME is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("PNAME is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(Object value) {
            addCriterion("PNAME =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(Object value) {
            addCriterion("PNAME <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(Object value) {
            addCriterion("PNAME >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(Object value) {
            addCriterion("PNAME >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(Object value) {
            addCriterion("PNAME <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(Object value) {
            addCriterion("PNAME <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<Object> values) {
            addCriterion("PNAME in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<Object> values) {
            addCriterion("PNAME not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(Object value1, Object value2) {
            addCriterion("PNAME between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(Object value1, Object value2) {
            addCriterion("PNAME not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("IDENTITY is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("IDENTITY is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(Object value) {
            addCriterion("IDENTITY =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(Object value) {
            addCriterion("IDENTITY <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(Object value) {
            addCriterion("IDENTITY >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(Object value) {
            addCriterion("IDENTITY >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(Object value) {
            addCriterion("IDENTITY <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(Object value) {
            addCriterion("IDENTITY <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<Object> values) {
            addCriterion("IDENTITY in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<Object> values) {
            addCriterion("IDENTITY not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(Object value1, Object value2) {
            addCriterion("IDENTITY between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(Object value1, Object value2) {
            addCriterion("IDENTITY not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNull() {
            addCriterion("BARCODE is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNotNull() {
            addCriterion("BARCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeEqualTo(BigDecimal value) {
            addCriterion("BARCODE =", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotEqualTo(BigDecimal value) {
            addCriterion("BARCODE <>", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThan(BigDecimal value) {
            addCriterion("BARCODE >", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BARCODE >=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThan(BigDecimal value) {
            addCriterion("BARCODE <", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BARCODE <=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIn(List<BigDecimal> values) {
            addCriterion("BARCODE in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotIn(List<BigDecimal> values) {
            addCriterion("BARCODE not in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BARCODE between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BARCODE not between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNull() {
            addCriterion("COMPANYNAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNotNull() {
            addCriterion("COMPANYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanynameEqualTo(Object value) {
            addCriterion("COMPANYNAME =", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotEqualTo(Object value) {
            addCriterion("COMPANYNAME <>", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThan(Object value) {
            addCriterion("COMPANYNAME >", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThanOrEqualTo(Object value) {
            addCriterion("COMPANYNAME >=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThan(Object value) {
            addCriterion("COMPANYNAME <", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThanOrEqualTo(Object value) {
            addCriterion("COMPANYNAME <=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIn(List<Object> values) {
            addCriterion("COMPANYNAME in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotIn(List<Object> values) {
            addCriterion("COMPANYNAME not in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameBetween(Object value1, Object value2) {
            addCriterion("COMPANYNAME between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotBetween(Object value1, Object value2) {
            addCriterion("COMPANYNAME not between", value1, value2, "companyname");
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

        public Criteria andGuidestateIsNull() {
            addCriterion("GUIDESTATE is null");
            return (Criteria) this;
        }

        public Criteria andGuidestateIsNotNull() {
            addCriterion("GUIDESTATE is not null");
            return (Criteria) this;
        }

        public Criteria andGuidestateEqualTo(Integer value) {
            addCriterion("GUIDESTATE =", value, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateNotEqualTo(Integer value) {
            addCriterion("GUIDESTATE <>", value, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateGreaterThan(Integer value) {
            addCriterion("GUIDESTATE >", value, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("GUIDESTATE >=", value, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateLessThan(Integer value) {
            addCriterion("GUIDESTATE <", value, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateLessThanOrEqualTo(Integer value) {
            addCriterion("GUIDESTATE <=", value, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateIn(List<Integer> values) {
            addCriterion("GUIDESTATE in", values, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateNotIn(List<Integer> values) {
            addCriterion("GUIDESTATE not in", values, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateBetween(Integer value1, Integer value2) {
            addCriterion("GUIDESTATE between", value1, value2, "guidestate");
            return (Criteria) this;
        }

        public Criteria andGuidestateNotBetween(Integer value1, Integer value2) {
            addCriterion("GUIDESTATE not between", value1, value2, "guidestate");
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