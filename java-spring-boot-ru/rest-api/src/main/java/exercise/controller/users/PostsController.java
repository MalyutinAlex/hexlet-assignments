package exercise.controller.users;

import java.util.List;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@SpringBootApplication
@RestController
@RequestMapping("/api")
public class PostsController {
    @Setter
    private static List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> getPosts(@PathVariable int id) {
        return posts.stream().filter(post -> post.getUserId() == id).toList();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> addPost(@RequestBody Post post, @PathVariable int id) {
        post.setUserId(id);
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
// END
