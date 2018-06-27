package com.health.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ExampeopleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExampeopleExample() {
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

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Object value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Object value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Object value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Object value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Object value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Object value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Object> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Object> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Object value1, Object value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Object value1, Object value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(Object value) {
            addCriterion("TELEPHONE =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(Object value) {
            addCriterion("TELEPHONE <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(Object value) {
            addCriterion("TELEPHONE >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(Object value) {
            addCriterion("TELEPHONE >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(Object value) {
            addCriterion("TELEPHONE <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(Object value) {
            addCriterion("TELEPHONE <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<Object> values) {
            addCriterion("TELEPHONE in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<Object> values) {
            addCriterion("TELEPHONE not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(Object value1, Object value2) {
            addCriterion("TELEPHONE between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(Object value1, Object value2) {
            addCriterion("TELEPHONE not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(Object value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(Object value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(Object value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(Object value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(Object value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(Object value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<Object> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<Object> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(Object value1, Object value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(Object value1, Object value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
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

        public Criteria andCheckstateIsNull() {
            addCriterion("CHECKSTATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckstateIsNotNull() {
            addCriterion("CHECKSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckstateEqualTo(Short value) {
            addCriterion("CHECKSTATE =", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateNotEqualTo(Short value) {
            addCriterion("CHECKSTATE <>", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateGreaterThan(Short value) {
            addCriterion("CHECKSTATE >", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateGreaterThanOrEqualTo(Short value) {
            addCriterion("CHECKSTATE >=", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateLessThan(Short value) {
            addCriterion("CHECKSTATE <", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateLessThanOrEqualTo(Short value) {
            addCriterion("CHECKSTATE <=", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateIn(List<Short> values) {
            addCriterion("CHECKSTATE in", values, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateNotIn(List<Short> values) {
            addCriterion("CHECKSTATE not in", values, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateBetween(Short value1, Short value2) {
            addCriterion("CHECKSTATE between", value1, value2, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateNotBetween(Short value1, Short value2) {
            addCriterion("CHECKSTATE not between", value1, value2, "checkstate");
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

        public Criteria andPackagepriceIsNull() {
            addCriterion("PACKAGEPRICE is null");
            return (Criteria) this;
        }

        public Criteria andPackagepriceIsNotNull() {
            addCriterion("PACKAGEPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPackagepriceEqualTo(BigDecimal value) {
            addCriterion("PACKAGEPRICE =", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceNotEqualTo(BigDecimal value) {
            addCriterion("PACKAGEPRICE <>", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceGreaterThan(BigDecimal value) {
            addCriterion("PACKAGEPRICE >", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PACKAGEPRICE >=", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceLessThan(BigDecimal value) {
            addCriterion("PACKAGEPRICE <", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PACKAGEPRICE <=", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceIn(List<BigDecimal> values) {
            addCriterion("PACKAGEPRICE in", values, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceNotIn(List<BigDecimal> values) {
            addCriterion("PACKAGEPRICE not in", values, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PACKAGEPRICE between", value1, value2, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PACKAGEPRICE not between", value1, value2, "packageprice");
            return (Criteria) this;
        }
        
        //额外添加 --- 模糊查询
        public Criteria andNameLike(Object value) {  //姓名
        	addCriterion("NAME like", value, "name");
        	return (Criteria) this;
        }
        
        public Criteria andTelephoneLike(Object value) {  //电话
        	addCriterion("TELEPHONE like", value, "telephone");
        	return (Criteria) this;
        }
        
        public Criteria andBarcodeLike(Object value) {  //条形码
        	addCriterion("BARCODE like", value, "barcode");
        	return (Criteria) this;
        }
        
        public Criteria andGuidetimeLike(Object value) {  //日期
        	addCriterion("GUIDETIME like", value, "guidetime");
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