package com.project.wechat.mbg.pojo;

import java.util.ArrayList;
import java.util.List;

public class ChatsPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatsPoExample() {
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

        public Criteria andChatIdIsNull() {
            addCriterion("chat_id is null");
            return (Criteria) this;
        }

        public Criteria andChatIdIsNotNull() {
            addCriterion("chat_id is not null");
            return (Criteria) this;
        }

        public Criteria andChatIdEqualTo(Integer value) {
            addCriterion("chat_id =", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdNotEqualTo(Integer value) {
            addCriterion("chat_id <>", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdGreaterThan(Integer value) {
            addCriterion("chat_id >", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_id >=", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdLessThan(Integer value) {
            addCriterion("chat_id <", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdLessThanOrEqualTo(Integer value) {
            addCriterion("chat_id <=", value, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdIn(List<Integer> values) {
            addCriterion("chat_id in", values, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdNotIn(List<Integer> values) {
            addCriterion("chat_id not in", values, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdBetween(Integer value1, Integer value2) {
            addCriterion("chat_id between", value1, value2, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_id not between", value1, value2, "chatId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdIsNull() {
            addCriterion("chat_window_Id is null");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdIsNotNull() {
            addCriterion("chat_window_Id is not null");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdEqualTo(Integer value) {
            addCriterion("chat_window_Id =", value, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdNotEqualTo(Integer value) {
            addCriterion("chat_window_Id <>", value, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdGreaterThan(Integer value) {
            addCriterion("chat_window_Id >", value, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_window_Id >=", value, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdLessThan(Integer value) {
            addCriterion("chat_window_Id <", value, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdLessThanOrEqualTo(Integer value) {
            addCriterion("chat_window_Id <=", value, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdIn(List<Integer> values) {
            addCriterion("chat_window_Id in", values, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdNotIn(List<Integer> values) {
            addCriterion("chat_window_Id not in", values, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdBetween(Integer value1, Integer value2) {
            addCriterion("chat_window_Id between", value1, value2, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andChatWindowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_window_Id not between", value1, value2, "chatWindowId");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
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