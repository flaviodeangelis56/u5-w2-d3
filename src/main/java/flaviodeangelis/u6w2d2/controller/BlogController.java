package flaviodeangelis.u6w2d2.controller;

import flaviodeangelis.u6w2d2.entities.BlogPost;
import flaviodeangelis.u6w2d2.exception.NotFoundException;
import flaviodeangelis.u6w2d2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blogpost")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public List<BlogPost> getBlogPosts() {
        return blogService.getBlogPosts();
    }

    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable long id) throws NotFoundException {
        return blogService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost sevePost(@RequestBody BlogPost body) {
        return blogService.save(body);
    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable long id, @RequestBody BlogPost body) throws NotFoundException {
        return blogService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id) {
        blogService.findByIdAndDelete(id);
    }
}
