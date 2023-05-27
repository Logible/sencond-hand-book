package com.project.wechat.mbg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderPo_OTIExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderPo_OTIExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andSellerStatusIsNull() {
            addCriterion("seller_status is null");
            return (Criteria) this;
        }

        public Criteria andSellerStatusIsNotNull() {
            addCriterion("seller_status is not null");
            return (Criteria) this;
        }

        public Criteria andSellerStatusEqualTo(Integer value) {
            addCriterion("seller_status =", value, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusNotEqualTo(Integer value) {
            addCriterion("seller_status <>", value, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusGreaterThan(Integer value) {
            addCriterion("seller_status >", value, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_status >=", value, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusLessThan(Integer value) {
            addCriterion("seller_status <", value, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusLessThanOrEqualTo(Integer value) {
            addCriterion("seller_status <=", value, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusIn(List<Integer> values) {
            addCriterion("seller_status in", values, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusNotIn(List<Integer> values) {
            addCriterion("seller_status not in", values, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusBetween(Integer value1, Integer value2) {
            addCriterion("seller_status between", value1, value2, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andSellerStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_status not between", value1, value2, "sellerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusIsNull() {
            addCriterion("buyer_status is null");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusIsNotNull() {
            addCriterion("buyer_status is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusEqualTo(String value) {
            addCriterion("buyer_status =", value, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusNotEqualTo(String value) {
            addCriterion("buyer_status <>", value, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusGreaterThan(String value) {
            addCriterion("buyer_status >", value, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_status >=", value, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusLessThan(String value) {
            addCriterion("buyer_status <", value, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusLessThanOrEqualTo(String value) {
            addCriterion("buyer_status <=", value, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusLike(String value) {
            addCriterion("buyer_status like", value, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusNotLike(String value) {
            addCriterion("buyer_status not like", value, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusIn(List<String> values) {
            addCriterion("buyer_status in", values, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusNotIn(List<String> values) {
            addCriterion("buyer_status not in", values, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusBetween(String value1, String value2) {
            addCriterion("buyer_status between", value1, value2, "buyerStatus");
            return (Criteria) this;
        }

        public Criteria andBuyerStatusNotBetween(String value1, String value2) {
            addCriterion("buyer_status not between", value1, value2, "buyerStatus");
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