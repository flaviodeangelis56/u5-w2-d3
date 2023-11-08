package flaviodeangelis.u6w2d2.controller;

import flaviodeangelis.u6w2d2.entities.Author;
import flaviodeangelis.u6w2d2.exception.NotFoundException;
import flaviodeangelis.u6w2d2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getBlogPosts() {
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable long id) throws NotFoundException {
        return authorService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Author sevePost(@RequestBody Author body) {
        return authorService.save(body);
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable long id, @RequestBody Author body) throws NotFoundException {
        return authorService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id) {
        authorService.findByIdAndDelete(id);
    }
}
