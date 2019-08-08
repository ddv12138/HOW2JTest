package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;
import tk.ddvudo.Mybatis.JavaBeans.Enterprise;
import tk.ddvudo.Mybatis.JavaBeans.EnterpriseExample;

import java.util.List;
import java.util.Map;

public interface EnterpriseDao {
    long countByExample(EnterpriseExample example);

    int deleteByExample(EnterpriseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    List<Enterprise> selectByExample(EnterpriseExample example);

    List<Map> selectByExample_Map(EnterpriseExample example);

    void selectByExample_Map_Forward(EnterpriseExample example, ResultHandler<Enterprise> handler);

    Enterprise selectByPrimaryKey(Integer id);

    Map selectByPrimaryKey_Map(Integer id);

    int updateByExampleSelective(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

    int updateByExample(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
}