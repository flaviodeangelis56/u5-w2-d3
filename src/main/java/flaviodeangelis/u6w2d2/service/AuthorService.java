package flaviodeangelis.u6w2d2.service;

import flaviodeangelis.u6w2d2.entities.Author;
import flaviodeangelis.u6w2d2.exception.NotFoundException;
import flaviodeangelis.u6w2d2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author body) {
        return authorRepository.save(body);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author findById(long id) throws NotFoundException {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        Author found = this.findById(id);
        authorRepository.delete(found);
    }

    public Author findByIdAndUpdate(long id, Author body) throws NotFoundException {
        Author found = this.findById(id);
        found.setId(id);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setBirthDate(body.getBirthDate());
        found.setAvatar(body.getAvatar());
        return authorRepository.save(found);
    }
}
