package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.RealFindDataVO;

@Mapper
@Repository
public interface RealFindDataMapper {
	@Insert("INSERT INTO realFindData_2 VALUES("
			+ "(SELECT NVL(MAX(no)+1,1) FROM realFindData_2),#{word},#{images})")
	public void realFindDataInsert(RealFindDataVO vo);
	
	@Update("TRUNCATE FROM realFindData_2")
	public void realFindDataDelete();
	
	@Select("SELECT * FROM realFindData_2 ORDER BY no ASC")
	public List<RealFindDataVO> realFindDataAllData();
}
