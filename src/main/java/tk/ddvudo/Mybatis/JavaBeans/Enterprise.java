package tk.ddvudo.Mybatis.JavaBeans;

import java.io.Serializable;

/**
 * Enterprise_all
 *
 * @author
 */
public class Enterprise implements Serializable {
    private String id;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 统一社会信用代码
     */
    private String code;

    /**
	 * 注册日期
	 */
	private String regday;

    /**
     * 企业类型
     */
    private String character;

    /**
     * 法人代表
     */
    private String legalrepresentative;

    /**
     * 注册资金
     */
    private String capital;

    /**
     * 经营范围
     */
    private String businessscope;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 地区
     */
    private String city;

    /**
     * 注册地址
     */
    private String address;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public String getRegday() {
		return regday;
	}

	public void setRegday(String regday) {
		this.regday = regday;
	}

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getLegalrepresentative() {
        return legalrepresentative;
    }

    public void setLegalrepresentative(String legalrepresentative) {
        this.legalrepresentative = legalrepresentative;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getBusinessscope() {
        return businessscope;
    }

    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKey() {
        return this.getName() + "/" + this.getRegday() + "/" + this.getLegalrepresentative();
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
        Enterprise other = (Enterprise) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
                && (this.getRegday() == null ? other.getRegday() == null : this.getRegday().equals(other.getRegday()))
                && (this.getCharacter() == null ? other.getCharacter() == null : this.getCharacter().equals(other.getCharacter()))
                && (this.getLegalrepresentative() == null ? other.getLegalrepresentative() == null : this.getLegalrepresentative().equals(other.getLegalrepresentative()))
                && (this.getCapital() == null ? other.getCapital() == null : this.getCapital().equals(other.getCapital()))
                && (this.getBusinessscope() == null ? other.getBusinessscope() == null : this.getBusinessscope().equals(other.getBusinessscope()))
                && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
                && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getRegday() == null) ? 0 : getRegday().hashCode());
        result = prime * result + ((getCharacter() == null) ? 0 : getCharacter().hashCode());
        result = prime * result + ((getLegalrepresentative() == null) ? 0 : getLegalrepresentative().hashCode());
        result = prime * result + ((getCapital() == null) ? 0 : getCapital().hashCode());
        result = prime * result + ((getBusinessscope() == null) ? 0 : getBusinessscope().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"code\":\"")
                .append(code).append('\"');
        sb.append(",\"regday\":\"")
                .append(regday).append('\"');
        sb.append(",\"character\":\"")
                .append(character).append('\"');
        sb.append(",\"legalrepresentative\":\"")
                .append(legalrepresentative).append('\"');
        sb.append(",\"capital\":\"")
                .append(capital).append('\"');
        sb.append(",\"businessscope\":\"")
                .append(businessscope).append('\"');
        sb.append(",\"province\":\"")
                .append(province).append('\"');
        sb.append(",\"city\":\"")
                .append(city).append('\"');
        sb.append(",\"address\":\"")
                .append(address).append('\"');
        sb.append('}');
        return sb.toString();
    }
}