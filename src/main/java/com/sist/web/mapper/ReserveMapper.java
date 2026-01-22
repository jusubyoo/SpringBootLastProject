package com.sist.web.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;

@Mapper
@Repository
public interface ReserveMapper {
	public List<SeoulVO> seoulReserveData(Map map);
	public int seoulReserveTotalPage(String address);
	
	// 예약 저장
	@Insert("INSERT INTO reserve_2(no,cno,id,rday,rtime,rinwon) "
			+ "VALUES(r2_no_seq.nextval,#{cno},#{id},#{rday},#{rtime},#{rinwon})")
	public void reserveInsert(ReserveVO vo);
	
	@ResultMap("resMap")
	@Select("SELECT r.no,r.id,cno,rday,rtime,rinwon,TO_CHAR(regdate,'yyyy-mm-dd') as dbday,isReserve,isCancel,title,image1,address "
			+ "FROM reserve_2 r,seoultravel s "
			+ "WHERE r.cno=s.contentid "
			+ "AND id=#{id} "
			+ "ORDER BY no DESC")
	public List<ReserveVO> reserveMyData(String id);
	  
	@ResultMap("resMap")
	@Select("SELECT r.no,r.id,cno,rday,rtime,rinwon,TO_CHAR(regdate,'yyyy-mm-dd') as dbday,isReserve,isCancel,title,image1,address "
			+ "FROM reserve_2 r,seoultravel s "
			+ "WHERE r.cno=s.contentid "
			+ "ORDER BY no DESC")
	public List<ReserveVO> reserveAdminData();
	
	@Update("UPDATE reserve_2 SET "
			+ "isReserve=1 "
			+ "WHERE no=#{no}")
	public void reserveOk(int no);
	
	@Update("UPDATE reserve_2 SET "
			+ "isCancel=1 "
			+ "WHERE no=#{no}")
	public void reserveCancel(int no);
	
	@Delete("DELETE FROM reserve_2 "
			+ "WHERE no=#{no}")
	public void reserveDelete(int no);
	
	@ResultMap("resMap")
	@Select("SELECT r.no,cno,rday,rtime,rinwon,title,image1,address "
			+ "FROM reserve_2 r,seoultravel s "
			+ "WHERE r.cno=s.contentid "
			+ "AND r.no=#{no}")
	public ReserveVO reserveDetailData(int no);
}
