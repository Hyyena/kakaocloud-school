package gmail.sjtxm0320.springbootjpa.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import gmail.sjtxm0320.springbootjpa.dto.MemoDTO;

@Repository
public interface MemoMapper {
    @Select("select * from tbl_memo")
    public List<MemoDTO> listMemo();
}
