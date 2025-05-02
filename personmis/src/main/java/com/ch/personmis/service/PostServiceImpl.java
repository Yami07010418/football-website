package com.ch.personmis.service;

import com.ch.personmis.entity.Post;
import com.ch.personmis.entity.PostByCon;
import com.ch.personmis.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements  PostService{
    @Resource
    private PostRepository postRepository;
    @Override
    public String addPost(Post post) {
        if(postRepository.addPost(post) > 0)
            return "ok";
        return "no";
    }

    @Override
    public Map<String, Object> selectPostByPage(PostByCon postByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        postByCon.setAct("byPage");
        List<Post> posts = postRepository.selectPost(postByCon);
        map.put("posts", posts);
        postByCon.setAct("byNoPage");
        map.put("total", postRepository.selectPost(postByCon).size());
        return map;
    }

    @Override
    public Map<String, Object> selectPostByCon(PostByCon postByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        postByCon.setAct("byPage");
        List<Post> posts = postRepository.selectPostByCon(postByCon);
        map.put("posts", posts);
        postByCon.setAct("byNoPage");
        map.put("total", postRepository.selectPostByCon(postByCon).size());
        return map;
    }

    @Override
    public Post getPostDetail(int id) {
        return postRepository.selectAPost(id);
    }

    @Override
    public String updatePost(Post post) {
        if(postRepository.updatePost(post) > 0)
            return "ok";
        return "no";
    }

    @Override
    public List<Post> getPost() {
        return postRepository.selectPost(null);
    }

    @Override
    public String deletePost(int id) {
        //先查询是否有关联数据
        List<Map<String, Object>>  listMap =postRepository.selectAssociatePost(id);
        if (listMap.size() <= 0) {
            if (postRepository.deletePost(id) > 0)
                return "ok";
        }
        return "no";
    }
}
