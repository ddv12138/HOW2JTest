package tk.ddvudo.Mybatis.JavaBeans;

import java.io.Serializable;

/**
 * role_res_map
 *
 * @author
 */
public class RoleResMap implements Serializable {
    private Integer id;

    private Integer roleid;

    private Integer resid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
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
        RoleResMap other = (RoleResMap) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()))
                && (this.getResid() == null ? other.getResid() == null : this.getResid().equals(other.getResid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        result = prime * result + ((getResid() == null) ? 0 : getResid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", roleid=" + roleid +
                ", resid=" + resid +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}