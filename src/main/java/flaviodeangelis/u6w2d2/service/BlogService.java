package flaviodeangelis.u6w2d2.service;

import flaviodeangelis.u6w2d2.entities.Author;
import flaviodeangelis.u6w2d2.entities.BlogPost;
import flaviodeangelis.u6w2d2.exception.NotFoundException;
import flaviodeangelis.u6w2d2.repository.AuthorRepository;
import flaviodeangelis.u6w2d2.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public BlogPost save(BlogPost body) throws NotFoundException {
        Random rdnm = new Random();
        long id = rdnm.nextInt(1, 5);
        Author author = authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        body.setAuthor(author);
        return blogRepository.save(body);
    }

    public List<BlogPost> getBlogPosts() {
        return blogRepository.findAll();
    }

    public BlogPost findById(long id) throws NotFoundException {
        return blogRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        BlogPost found = this.findById(id);
        blogRepository.delete(found);
    }

    public BlogPost findByIdAndUpdate(long id, BlogPost body) throws NotFoundException {
        BlogPost found = this.findById(id);
        found.setId(id);
        found.setTitle(body.getTitle());
        found.setCategory(body.getCategory());
        found.setContent(body.getContent());
        found.setCover(body.getCover());
        return blogRepository.save(found);
    }
}
