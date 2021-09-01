package com.michael.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FilmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilmExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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
            List<java.sql.Date> dateList = new ArrayList<>();
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

        public Criteria andFilmIdIsNull() {
            addCriterion("film_id is null");
            return (Criteria) this;
        }

        public Criteria andFilmIdIsNotNull() {
            addCriterion("film_id is not null");
            return (Criteria) this;
        }

        public Criteria andFilmIdEqualTo(Long value) {
            addCriterion("film_id =", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdNotEqualTo(Long value) {
            addCriterion("film_id <>", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdGreaterThan(Long value) {
            addCriterion("film_id >", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("film_id >=", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdLessThan(Long value) {
            addCriterion("film_id <", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdLessThanOrEqualTo(Long value) {
            addCriterion("film_id <=", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdIn(List<Long> values) {
            addCriterion("film_id in", values, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdNotIn(List<Long> values) {
            addCriterion("film_id not in", values, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdBetween(Long value1, Long value2) {
            addCriterion("film_id between", value1, value2, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdNotBetween(Long value1, Long value2) {
            addCriterion("film_id not between", value1, value2, "filmId");
            return (Criteria) this;
        }

        public Criteria andChineseNameIsNull() {
            addCriterion("chinese_name is null");
            return (Criteria) this;
        }

        public Criteria andChineseNameIsNotNull() {
            addCriterion("chinese_name is not null");
            return (Criteria) this;
        }

        public Criteria andChineseNameEqualTo(String value) {
            addCriterion("chinese_name =", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotEqualTo(String value) {
            addCriterion("chinese_name <>", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameGreaterThan(String value) {
            addCriterion("chinese_name >", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameGreaterThanOrEqualTo(String value) {
            addCriterion("chinese_name >=", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLessThan(String value) {
            addCriterion("chinese_name <", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLessThanOrEqualTo(String value) {
            addCriterion("chinese_name <=", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLike(String value) {
            addCriterion("chinese_name like", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotLike(String value) {
            addCriterion("chinese_name not like", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameIn(List<String> values) {
            addCriterion("chinese_name in", values, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotIn(List<String> values) {
            addCriterion("chinese_name not in", values, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameBetween(String value1, String value2) {
            addCriterion("chinese_name between", value1, value2, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotBetween(String value1, String value2) {
            addCriterion("chinese_name not between", value1, value2, "chineseName");
            return (Criteria) this;
        }

        public Criteria andForeignNameIsNull() {
            addCriterion("foreign_name is null");
            return (Criteria) this;
        }

        public Criteria andForeignNameIsNotNull() {
            addCriterion("foreign_name is not null");
            return (Criteria) this;
        }

        public Criteria andForeignNameEqualTo(String value) {
            addCriterion("foreign_name =", value, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameNotEqualTo(String value) {
            addCriterion("foreign_name <>", value, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameGreaterThan(String value) {
            addCriterion("foreign_name >", value, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameGreaterThanOrEqualTo(String value) {
            addCriterion("foreign_name >=", value, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameLessThan(String value) {
            addCriterion("foreign_name <", value, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameLessThanOrEqualTo(String value) {
            addCriterion("foreign_name <=", value, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameLike(String value) {
            addCriterion("foreign_name like", value, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameNotLike(String value) {
            addCriterion("foreign_name not like", value, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameIn(List<String> values) {
            addCriterion("foreign_name in", values, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameNotIn(List<String> values) {
            addCriterion("foreign_name not in", values, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameBetween(String value1, String value2) {
            addCriterion("foreign_name between", value1, value2, "foreignName");
            return (Criteria) this;
        }

        public Criteria andForeignNameNotBetween(String value1, String value2) {
            addCriterion("foreign_name not between", value1, value2, "foreignName");
            return (Criteria) this;
        }

        public Criteria andOtherNameIsNull() {
            addCriterion("other_name is null");
            return (Criteria) this;
        }

        public Criteria andOtherNameIsNotNull() {
            addCriterion("other_name is not null");
            return (Criteria) this;
        }

        public Criteria andOtherNameEqualTo(String value) {
            addCriterion("other_name =", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameNotEqualTo(String value) {
            addCriterion("other_name <>", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameGreaterThan(String value) {
            addCriterion("other_name >", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameGreaterThanOrEqualTo(String value) {
            addCriterion("other_name >=", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameLessThan(String value) {
            addCriterion("other_name <", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameLessThanOrEqualTo(String value) {
            addCriterion("other_name <=", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameLike(String value) {
            addCriterion("other_name like", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameNotLike(String value) {
            addCriterion("other_name not like", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameIn(List<String> values) {
            addCriterion("other_name in", values, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameNotIn(List<String> values) {
            addCriterion("other_name not in", values, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameBetween(String value1, String value2) {
            addCriterion("other_name between", value1, value2, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameNotBetween(String value1, String value2) {
            addCriterion("other_name not between", value1, value2, "otherName");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNull() {
            addCriterion("director is null");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNotNull() {
            addCriterion("director is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorEqualTo(String value) {
            addCriterion("director =", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotEqualTo(String value) {
            addCriterion("director <>", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThan(String value) {
            addCriterion("director >", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("director >=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThan(String value) {
            addCriterion("director <", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThanOrEqualTo(String value) {
            addCriterion("director <=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLike(String value) {
            addCriterion("director like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotLike(String value) {
            addCriterion("director not like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorIn(List<String> values) {
            addCriterion("director in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotIn(List<String> values) {
            addCriterion("director not in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorBetween(String value1, String value2) {
            addCriterion("director between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotBetween(String value1, String value2) {
            addCriterion("director not between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andScreenwriterIsNull() {
            addCriterion("screenwriter is null");
            return (Criteria) this;
        }

        public Criteria andScreenwriterIsNotNull() {
            addCriterion("screenwriter is not null");
            return (Criteria) this;
        }

        public Criteria andScreenwriterEqualTo(String value) {
            addCriterion("screenwriter =", value, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterNotEqualTo(String value) {
            addCriterion("screenwriter <>", value, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterGreaterThan(String value) {
            addCriterion("screenwriter >", value, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterGreaterThanOrEqualTo(String value) {
            addCriterion("screenwriter >=", value, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterLessThan(String value) {
            addCriterion("screenwriter <", value, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterLessThanOrEqualTo(String value) {
            addCriterion("screenwriter <=", value, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterLike(String value) {
            addCriterion("screenwriter like", value, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterNotLike(String value) {
            addCriterion("screenwriter not like", value, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterIn(List<String> values) {
            addCriterion("screenwriter in", values, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterNotIn(List<String> values) {
            addCriterion("screenwriter not in", values, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterBetween(String value1, String value2) {
            addCriterion("screenwriter between", value1, value2, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andScreenwriterNotBetween(String value1, String value2) {
            addCriterion("screenwriter not between", value1, value2, "screenwriter");
            return (Criteria) this;
        }

        public Criteria andToStarIsNull() {
            addCriterion("to_star is null");
            return (Criteria) this;
        }

        public Criteria andToStarIsNotNull() {
            addCriterion("to_star is not null");
            return (Criteria) this;
        }

        public Criteria andToStarEqualTo(String value) {
            addCriterion("to_star =", value, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarNotEqualTo(String value) {
            addCriterion("to_star <>", value, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarGreaterThan(String value) {
            addCriterion("to_star >", value, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarGreaterThanOrEqualTo(String value) {
            addCriterion("to_star >=", value, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarLessThan(String value) {
            addCriterion("to_star <", value, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarLessThanOrEqualTo(String value) {
            addCriterion("to_star <=", value, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarLike(String value) {
            addCriterion("to_star like", value, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarNotLike(String value) {
            addCriterion("to_star not like", value, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarIn(List<String> values) {
            addCriterion("to_star in", values, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarNotIn(List<String> values) {
            addCriterion("to_star not in", values, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarBetween(String value1, String value2) {
            addCriterion("to_star between", value1, value2, "toStar");
            return (Criteria) this;
        }

        public Criteria andToStarNotBetween(String value1, String value2) {
            addCriterion("to_star not between", value1, value2, "toStar");
            return (Criteria) this;
        }

        public Criteria andFilmTypeIsNull() {
            addCriterion("film_type is null");
            return (Criteria) this;
        }

        public Criteria andFilmTypeIsNotNull() {
            addCriterion("film_type is not null");
            return (Criteria) this;
        }

        public Criteria andFilmTypeEqualTo(String value) {
            addCriterion("film_type =", value, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeNotEqualTo(String value) {
            addCriterion("film_type <>", value, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeGreaterThan(String value) {
            addCriterion("film_type >", value, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("film_type >=", value, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeLessThan(String value) {
            addCriterion("film_type <", value, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeLessThanOrEqualTo(String value) {
            addCriterion("film_type <=", value, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeLike(String value) {
            addCriterion("film_type like", value, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeNotLike(String value) {
            addCriterion("film_type not like", value, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeIn(List<String> values) {
            addCriterion("film_type in", values, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeNotIn(List<String> values) {
            addCriterion("film_type not in", values, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeBetween(String value1, String value2) {
            addCriterion("film_type between", value1, value2, "filmType");
            return (Criteria) this;
        }

        public Criteria andFilmTypeNotBetween(String value1, String value2) {
            addCriterion("film_type not between", value1, value2, "filmType");
            return (Criteria) this;
        }

        public Criteria andProductionCountryIsNull() {
            addCriterion("production_country is null");
            return (Criteria) this;
        }

        public Criteria andProductionCountryIsNotNull() {
            addCriterion("production_country is not null");
            return (Criteria) this;
        }

        public Criteria andProductionCountryEqualTo(String value) {
            addCriterion("production_country =", value, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryNotEqualTo(String value) {
            addCriterion("production_country <>", value, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryGreaterThan(String value) {
            addCriterion("production_country >", value, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryGreaterThanOrEqualTo(String value) {
            addCriterion("production_country >=", value, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryLessThan(String value) {
            addCriterion("production_country <", value, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryLessThanOrEqualTo(String value) {
            addCriterion("production_country <=", value, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryLike(String value) {
            addCriterion("production_country like", value, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryNotLike(String value) {
            addCriterion("production_country not like", value, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryIn(List<String> values) {
            addCriterion("production_country in", values, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryNotIn(List<String> values) {
            addCriterion("production_country not in", values, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryBetween(String value1, String value2) {
            addCriterion("production_country between", value1, value2, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andProductionCountryNotBetween(String value1, String value2) {
            addCriterion("production_country not between", value1, value2, "productionCountry");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("language like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("language not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNull() {
            addCriterion("release_date is null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNotNull() {
            addCriterion("release_date is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateEqualTo(Date value) {
            addCriterionForJDBCDate("release_date =", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("release_date <>", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("release_date >", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("release_date >=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThan(Date value) {
            addCriterionForJDBCDate("release_date <", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("release_date <=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIn(List<Date> values) {
            addCriterionForJDBCDate("release_date in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("release_date not in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("release_date between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("release_date not between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andFilmLengthIsNull() {
            addCriterion("film_length is null");
            return (Criteria) this;
        }

        public Criteria andFilmLengthIsNotNull() {
            addCriterion("film_length is not null");
            return (Criteria) this;
        }

        public Criteria andFilmLengthEqualTo(Integer value) {
            addCriterion("film_length =", value, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthNotEqualTo(Integer value) {
            addCriterion("film_length <>", value, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthGreaterThan(Integer value) {
            addCriterion("film_length >", value, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("film_length >=", value, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthLessThan(Integer value) {
            addCriterion("film_length <", value, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthLessThanOrEqualTo(Integer value) {
            addCriterion("film_length <=", value, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthIn(List<Integer> values) {
            addCriterion("film_length in", values, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthNotIn(List<Integer> values) {
            addCriterion("film_length not in", values, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthBetween(Integer value1, Integer value2) {
            addCriterion("film_length between", value1, value2, "filmLength");
            return (Criteria) this;
        }

        public Criteria andFilmLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("film_length not between", value1, value2, "filmLength");
            return (Criteria) this;
        }

        public Criteria andHrefIsNull() {
            addCriterion("href is null");
            return (Criteria) this;
        }

        public Criteria andHrefIsNotNull() {
            addCriterion("href is not null");
            return (Criteria) this;
        }

        public Criteria andHrefEqualTo(String value) {
            addCriterion("href =", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotEqualTo(String value) {
            addCriterion("href <>", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThan(String value) {
            addCriterion("href >", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThanOrEqualTo(String value) {
            addCriterion("href >=", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLessThan(String value) {
            addCriterion("href <", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLessThanOrEqualTo(String value) {
            addCriterion("href <=", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLike(String value) {
            addCriterion("href like", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotLike(String value) {
            addCriterion("href not like", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefIn(List<String> values) {
            addCriterion("href in", values, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotIn(List<String> values) {
            addCriterion("href not in", values, "href");
            return (Criteria) this;
        }

        public Criteria andHrefBetween(String value1, String value2) {
            addCriterion("href between", value1, value2, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotBetween(String value1, String value2) {
            addCriterion("href not between", value1, value2, "href");
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