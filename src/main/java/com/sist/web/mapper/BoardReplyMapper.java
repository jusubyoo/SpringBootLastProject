package com.sist.web.mapper;

import java.util.*;
import com.sist.web.vo.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardReplyMapper {
	@Select("SELECT no,bno,id,name,sex,msg,TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday "
			+ "FROM board_reply_2 "
			+ "WHERE bno=#{bno} "
			+ "ORDER BY no DESC")
	public List<ReplyVO> replyListData(int bno);
	
	@Select("SELECT COUNT(*) FROM board_reply_2 "
			+ "WHERE bno=#{bno}")
	public int replyCount(int bno);
	
	@Insert("INSERT INTO board_reply_2 VALUES(br2_no_seq.nextval,#{bno},#{id},#{name},#{sex},#{msg},SYSDATE)")
	public void boardReplyInsert(ReplyVO vo);
	
	@Delete("DELETE FROM board_reply_2 WHERE no=#{no}")
	public void boardReplyDelete(int no);
	
	@Update("UPDATE board_reply_2 SET "
			+ "msg=#{msg} "
			+ "WHERE no=#{no}")
	public void boardReplyUpdate(ReplyVO vo);
}
