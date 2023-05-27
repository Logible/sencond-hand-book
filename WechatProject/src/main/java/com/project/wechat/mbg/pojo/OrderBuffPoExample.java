package com.project.wechat.mbg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderBuffPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderBuffPoExample() {
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

        public Criteria andOrderbIdIsNull() {
            addCriterion("orderb_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderbIdIsNotNull() {
            addCriterion("orderb_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbIdEqualTo(Integer value) {
            addCriterion("orderb_id =", value, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdNotEqualTo(Integer value) {
            addCriterion("orderb_id <>", value, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdGreaterThan(Integer value) {
            addCriterion("orderb_id >", value, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderb_id >=", value, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdLessThan(Integer value) {
            addCriterion("orderb_id <", value, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdLessThanOrEqualTo(Integer value) {
            addCriterion("orderb_id <=", value, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdIn(List<Integer> values) {
            addCriterion("orderb_id in", values, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdNotIn(List<Integer> values) {
            addCriterion("orderb_id not in", values, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdBetween(Integer value1, Integer value2) {
            addCriterion("orderb_id between", value1, value2, "orderbId");
            return (Criteria) this;
        }

        public Criteria andOrderbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("orderb_id not between", value1, value2, "orderbId");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andChatWidIsNull() {
            addCriterion("chat_wid is null");
            return (Criteria) this;
        }

        public Criteria andChatWidIsNotNull() {
            addCriterion("chat_wid is not null");
            return (Criteria) this;
        }

        public Criteria andChatWidEqualTo(Integer value) {
            addCriterion("chat_wid =", value, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidNotEqualTo(Integer value) {
            addCriterion("chat_wid <>", value, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidGreaterThan(Integer value) {
            addCriterion("chat_wid >", value, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_wid >=", value, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidLessThan(Integer value) {
            addCriterion("chat_wid <", value, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidLessThanOrEqualTo(Integer value) {
            addCriterion("chat_wid <=", value, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidIn(List<Integer> values) {
            addCriterion("chat_wid in", values, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidNotIn(List<Integer> values) {
            addCriterion("chat_wid not in", values, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidBetween(Integer value1, Integer value2) {
            addCriterion("chat_wid between", value1, value2, "chatWid");
            return (Criteria) this;
        }

        public Criteria andChatWidNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_wid not between", value1, value2, "chatWid");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusIsNull() {
            addCriterion("agree_status is null");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusIsNotNull() {
            addCriterion("agree_status is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusEqualTo(String value) {
            addCriterion("agree_status =", value, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusNotEqualTo(String value) {
            addCriterion("agree_status <>", value, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusGreaterThan(String value) {
            addCriterion("agree_status >", value, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("agree_status >=", value, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusLessThan(String value) {
            addCriterion("agree_status <", value, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusLessThanOrEqualTo(String value) {
            addCriterion("agree_status <=", value, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusLike(String value) {
            addCriterion("agree_status like", value, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusNotLike(String value) {
            addCriterion("agree_status not like", value, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusIn(List<String> values) {
            addCriterion("agree_status in", values, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusNotIn(List<String> values) {
            addCriterion("agree_status not in", values, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusBetween(String value1, String value2) {
            addCriterion("agree_status between", value1, value2, "agreeStatus");
            return (Criteria) this;
        }

        public Criteria andAgreeStatusNotBetween(String value1, String value2) {
            addCriterion("agree_status not between", value1, value2, "agreeStatus");
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