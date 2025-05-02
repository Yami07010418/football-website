package com.ch.personmis.controller;

import com.ch.personmis.entity.Post;
import com.ch.personmis.entity.PostByCon;

import com.ch.personmis.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
//@RestController 注解的作用是将一个类标识为 RESTful 服务的控制器，
// 其中的方法返回的对象将作为 HTTP 响应的主体返回给客户端，通常是以 JSON 或 XML 格式进行序列化。这使得开发 RESTful 服务更加简洁和方便。
public class PostController {
    @Resource
    private PostService postService;
    @GetMapping("/getPostByPage")
    public Map<String, Object> selectPostByPage(PostByCon postByCon) {
        return postService.selectPostByPage(postByCon);
    }
    @PostMapping("/addPost")
    public  String addPost(@RequestBody Post post){
        return  postService.addPost(post);
    }
    @PostMapping("/selectPostByCon")
    public Map<String, Object> selectPostByCon(@RequestBody PostByCon postByCon) {
        return postService.selectPostByCon(postByCon);
    }
    @GetMapping("/getPostDetail")
    public Post getPostDetail(int id) {
        return postService.getPostDetail(id);
    }
    @PostMapping("/updatePost")
    public  String updatePost(@RequestBody Post post){
        return  postService.updatePost(post);
    }
    @GetMapping("/getPost")
    public List<Post> getPost() {
        return postService.getPost();
    }
    @PostMapping("/deletePost")
    public  String deletePost(int id){
        return postService.deletePost(id);
    }
}
