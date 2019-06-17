package tk.ddvudo.Mybatis.JavaBeans;

import java.io.Serializable;

/**
 * Resourcetable
 *
 * @author
 */
public class Resourcetable implements Serializable {
    private Integer id;

    private String name;

    private String cnname;

    private Integer istop;

    private Integer leftvalue;

    private Integer rightvalue;

    private Integer level;

    private Integer order;

    private String urlpath;

    private Boolean haschild;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public Integer getIstop() {
        return istop;
    }

    public void setIstop(Integer istop) {
        this.istop = istop;
    }

    public Integer getLeftvalue() {
        return leftvalue;
    }

    public void setLeftvalue(Integer leftvalue) {
        this.leftvalue = leftvalue;
    }

    public Integer getRightvalue() {
        return rightvalue;
    }

    public void setRightvalue(Integer rightvalue) {
        this.rightvalue = rightvalue;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getUrlpath() {
        return urlpath;
    }

    public void setUrlpath(String urlpath) {
        this.urlpath = urlpath;
    }

    public Boolean getHaschild() {
        return haschild;
    }

    public void setHaschild(Boolean haschild) {
        this.haschild = haschild;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Resourcetable other = (Resourcetable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getCnname() == null ? other.getCnname() == null : this.getCnname().equals(other.getCnname()))
                && (this.getIstop() == null ? other.getIstop() == null : this.getIstop().equals(other.getIstop()))
                && (this.getLeftvalue() == null ? other.getLeftvalue() == null : this.getLeftvalue().equals(other.getLeftvalue()))
                && (this.getRightvalue() == null ? other.getRightvalue() == null : this.getRightvalue().equals(other.getRightvalue()))
                && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
                && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()))
                && (this.getUrlpath() == null ? other.getUrlpath() == null : this.getUrlpath().equals(other.getUrlpath()))
                && (this.getHaschild() == null ? other.getHaschild() == null : this.getHaschild().equals(other.getHaschild()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCnname() == null) ? 0 : getCnname().hashCode());
        result = prime * result + ((getIstop() == null) ? 0 : getIstop().hashCode());
        result = prime * result + ((getLeftvalue() == null) ? 0 : getLeftvalue().hashCode());
        result = prime * result + ((getRightvalue() == null) ? 0 : getRightvalue().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
        result = prime * result + ((getUrlpath() == null) ? 0 : getUrlpath().hashCode());
        result = prime * result + ((getHaschild() == null) ? 0 : getHaschild().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", name=" + name +
                ", cnname=" + cnname +
                ", istop=" + istop +
                ", leftvalue=" + leftvalue +
                ", rightvalue=" + rightvalue +
                ", level=" + level +
                ", order=" + order +
                ", urlpath=" + urlpath +
                ", haschild=" + haschild +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}