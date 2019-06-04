package tk.ddvudo.Mybatis.JavaBeans;

import java.util.ArrayList;
import java.util.List;

public class ResourcetableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ResourcetableExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCnnameIsNull() {
            addCriterion("cnname is null");
            return (Criteria) this;
        }

        public Criteria andCnnameIsNotNull() {
            addCriterion("cnname is not null");
            return (Criteria) this;
        }

        public Criteria andCnnameEqualTo(String value) {
            addCriterion("cnname =", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotEqualTo(String value) {
            addCriterion("cnname <>", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameGreaterThan(String value) {
            addCriterion("cnname >", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameGreaterThanOrEqualTo(String value) {
            addCriterion("cnname >=", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLessThan(String value) {
            addCriterion("cnname <", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLessThanOrEqualTo(String value) {
            addCriterion("cnname <=", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLike(String value) {
            addCriterion("cnname like", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotLike(String value) {
            addCriterion("cnname not like", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameIn(List<String> values) {
            addCriterion("cnname in", values, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotIn(List<String> values) {
            addCriterion("cnname not in", values, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameBetween(String value1, String value2) {
            addCriterion("cnname between", value1, value2, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotBetween(String value1, String value2) {
            addCriterion("cnname not between", value1, value2, "cnname");
            return (Criteria) this;
        }

        public Criteria andIstopIsNull() {
            addCriterion("istop is null");
            return (Criteria) this;
        }

        public Criteria andIstopIsNotNull() {
            addCriterion("istop is not null");
            return (Criteria) this;
        }

        public Criteria andIstopEqualTo(Integer value) {
            addCriterion("istop =", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotEqualTo(Integer value) {
            addCriterion("istop <>", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThan(Integer value) {
            addCriterion("istop >", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThanOrEqualTo(Integer value) {
            addCriterion("istop >=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThan(Integer value) {
            addCriterion("istop <", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThanOrEqualTo(Integer value) {
            addCriterion("istop <=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopIn(List<Integer> values) {
            addCriterion("istop in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotIn(List<Integer> values) {
            addCriterion("istop not in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopBetween(Integer value1, Integer value2) {
            addCriterion("istop between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotBetween(Integer value1, Integer value2) {
            addCriterion("istop not between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andLeftvalueIsNull() {
            addCriterion("leftvalue is null");
            return (Criteria) this;
        }

        public Criteria andLeftvalueIsNotNull() {
            addCriterion("leftvalue is not null");
            return (Criteria) this;
        }

        public Criteria andLeftvalueEqualTo(Integer value) {
            addCriterion("leftvalue =", value, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueNotEqualTo(Integer value) {
            addCriterion("leftvalue <>", value, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueGreaterThan(Integer value) {
            addCriterion("leftvalue >", value, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("leftvalue >=", value, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueLessThan(Integer value) {
            addCriterion("leftvalue <", value, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueLessThanOrEqualTo(Integer value) {
            addCriterion("leftvalue <=", value, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueIn(List<Integer> values) {
            addCriterion("leftvalue in", values, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueNotIn(List<Integer> values) {
            addCriterion("leftvalue not in", values, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueBetween(Integer value1, Integer value2) {
            addCriterion("leftvalue between", value1, value2, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andLeftvalueNotBetween(Integer value1, Integer value2) {
            addCriterion("leftvalue not between", value1, value2, "leftvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueIsNull() {
            addCriterion("rightvalue is null");
            return (Criteria) this;
        }

        public Criteria andRightvalueIsNotNull() {
            addCriterion("rightvalue is not null");
            return (Criteria) this;
        }

        public Criteria andRightvalueEqualTo(Integer value) {
            addCriterion("rightvalue =", value, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueNotEqualTo(Integer value) {
            addCriterion("rightvalue <>", value, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueGreaterThan(Integer value) {
            addCriterion("rightvalue >", value, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("rightvalue >=", value, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueLessThan(Integer value) {
            addCriterion("rightvalue <", value, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueLessThanOrEqualTo(Integer value) {
            addCriterion("rightvalue <=", value, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueIn(List<Integer> values) {
            addCriterion("rightvalue in", values, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueNotIn(List<Integer> values) {
            addCriterion("rightvalue not in", values, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueBetween(Integer value1, Integer value2) {
            addCriterion("rightvalue between", value1, value2, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andRightvalueNotBetween(Integer value1, Integer value2) {
            addCriterion("rightvalue not between", value1, value2, "rightvalue");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("`level` is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("`level` is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("`level` =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("`level` <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("`level` >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("`level` >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("`level` <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("`level` <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("`level` in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("`level` not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("`level` between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("`level` not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andOrderIsNull() {
            addCriterion("`order` is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("`order` is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("`order` =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("`order` <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("`order` >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("`order` >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(Integer value) {
            addCriterion("`order` <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("`order` <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("`order` in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("`order` not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("`order` between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("`order` not between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andUrlpathIsNull() {
            addCriterion("urlpath is null");
            return (Criteria) this;
        }

        public Criteria andUrlpathIsNotNull() {
            addCriterion("urlpath is not null");
            return (Criteria) this;
        }

        public Criteria andUrlpathEqualTo(String value) {
            addCriterion("urlpath =", value, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathNotEqualTo(String value) {
            addCriterion("urlpath <>", value, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathGreaterThan(String value) {
            addCriterion("urlpath >", value, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathGreaterThanOrEqualTo(String value) {
            addCriterion("urlpath >=", value, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathLessThan(String value) {
            addCriterion("urlpath <", value, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathLessThanOrEqualTo(String value) {
            addCriterion("urlpath <=", value, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathLike(String value) {
            addCriterion("urlpath like", value, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathNotLike(String value) {
            addCriterion("urlpath not like", value, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathIn(List<String> values) {
            addCriterion("urlpath in", values, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathNotIn(List<String> values) {
            addCriterion("urlpath not in", values, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathBetween(String value1, String value2) {
            addCriterion("urlpath between", value1, value2, "urlpath");
            return (Criteria) this;
        }

        public Criteria andUrlpathNotBetween(String value1, String value2) {
            addCriterion("urlpath not between", value1, value2, "urlpath");
            return (Criteria) this;
        }

        public Criteria andHaschildIsNull() {
            addCriterion("haschild is null");
            return (Criteria) this;
        }

        public Criteria andHaschildIsNotNull() {
            addCriterion("haschild is not null");
            return (Criteria) this;
        }

        public Criteria andHaschildEqualTo(Boolean value) {
            addCriterion("haschild =", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildNotEqualTo(Boolean value) {
            addCriterion("haschild <>", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildGreaterThan(Boolean value) {
            addCriterion("haschild >", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildGreaterThanOrEqualTo(Boolean value) {
            addCriterion("haschild >=", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildLessThan(Boolean value) {
            addCriterion("haschild <", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildLessThanOrEqualTo(Boolean value) {
            addCriterion("haschild <=", value, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildIn(List<Boolean> values) {
            addCriterion("haschild in", values, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildNotIn(List<Boolean> values) {
            addCriterion("haschild not in", values, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildBetween(Boolean value1, Boolean value2) {
            addCriterion("haschild between", value1, value2, "haschild");
            return (Criteria) this;
        }

        public Criteria andHaschildNotBetween(Boolean value1, Boolean value2) {
            addCriterion("haschild not between", value1, value2, "haschild");
            return (Criteria) this;
        }
    }

    /**
     *
     */
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