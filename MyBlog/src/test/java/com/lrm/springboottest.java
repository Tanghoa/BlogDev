package com.lrm;

import com.lrm.entity.BlogExample;
import com.lrm.entity.BlogWithBLOBs;
import com.lrm.mapper.BlogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;


@RunWith(SpringRunner.class)
@SpringBootTest
public class springboottest {

    @Autowired
    BlogMapper blogMapper;

    @Test
    public void tes(){
        BlogWithBLOBs bs = blogMapper.selectByPrimaryKey(1L);

        BlogExample example = new BlogExample();
        BlogExample.Criteria criteria = example.createCriteria();
//        criteria.andCommentabledEqualTo("s")
//        blogMapper.selectByExample();
        System.out.println(bs);

    }
}
