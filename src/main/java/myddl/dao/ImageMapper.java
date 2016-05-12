package myddl.dao;

import myddl.entity.Image;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("imageMapper")
public interface ImageMapper {
    int deleteByPrimaryKey(Long imageId);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Long imageId);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKeyWithBLOBs(Image record);
}