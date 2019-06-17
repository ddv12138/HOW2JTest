package tk.ddvudo.Mybatis.JavaBeans;

import java.io.Serializable;

/**
 * user_role_map
 *
 * @author
 */
public class UserRoleMap implements Serializable {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 角色id
     */
    private Integer roleid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
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
        UserRoleMap other = (UserRoleMap) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
                && (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", userid=" + userid +
                ", roleid=" + roleid +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}