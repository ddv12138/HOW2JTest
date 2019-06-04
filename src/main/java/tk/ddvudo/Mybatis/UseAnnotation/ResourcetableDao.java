package tk.ddvudo.Mybatis.UseAnnotation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.ddvudo.Mybatis.JavaBeans.Resourcetable;
import tk.ddvudo.Mybatis.JavaBeans.ResourcetableExample;

public interface ResourcetableDao {
    long countByExample(ResourcetableExample example);

    int deleteByExample(ResourcetableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Resourcetable record);

    int insertSelective(Resourcetable record);

    List<Resourcetable> selectByExample(ResourcetableExample example);

    Resourcetable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Resourcetable record, @Param("example") ResourcetableExample example);

    int updateByExample(@Param("record") Resourcetable record, @Param("example") ResourcetableExample example);

    int updateByPrimaryKeySelective(Resourcetable record);

    int updateByPrimaryKey(Resourcetable record);
}