package ia.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import ia.demo.mapper.SubMapper;
import ia.demo.po.Sub;

@Service
public class SubService {

	@Autowired
	SubMapper subMapper;
	
	/**
	 * 根据userId查询该用户预订书籍情况
	 * @param userId
	 * @return
	 */
	public List<Sub> getSubByUserId(long userId){
        return subMapper.getSubByUserId(userId);
    }

	/**
	 * 根据bookId查询该书籍的预订情况
	 * @param userId
	 * @return
	 */
	public List<Sub> getSubByBookId(long bookId){
        return subMapper.getSubByBookId(bookId);
    }
	
	/**
	 * 保存
	 * @param sub
	 */
	public void saveSub(Sub sub){
		subMapper.save(sub);
    }
	
	/**
	 * 获取所有预订
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Sub> getAllSub(int pageNum,int pageSize)throws Exception{
		PageHelper.startPage(pageNum,pageSize);
		return subMapper.getAll();
	}
	
	/**
	 * 删除所有预订
	 */
	public void deleteByUserId(long userId) {
		subMapper.deleteByUserId(userId);
	}
	
	/**
	 * 删除所有预订
	 */
	public void deleteAllSub() {
		subMapper.deleteAll();
	}
	
}
