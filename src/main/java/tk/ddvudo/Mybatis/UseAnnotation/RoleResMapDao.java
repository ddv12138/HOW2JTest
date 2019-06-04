package tk.ddvudo.Mybatis.UseAnnotation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.ddvudo.Mybatis.JavaBeans.RoleResMap;
import tk.ddvudo.Mybatis.JavaBeans.RoleResMapExample;

public interface RoleResMapDao {
    long countByExample(RoleResMapExample example);

    int deleteByExample(RoleResMapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleResMap record);

    int insertSelective(RoleResMap record);

    List<RoleResMap> selectByExample(RoleResMapExample example);

    RoleResMap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleResMap record, @Param("example") RoleResMapExample example);

    int updateByExample(@Param("record") RoleResMap record, @Param("example") RoleResMapExample example);

    int updateByPrimaryKeySelective(RoleResMap record);

    int updateByPrimaryKey(RoleResMap record);
}