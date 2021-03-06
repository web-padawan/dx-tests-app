package com.example.application.data.endpoint;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import com.example.application.data.entity.Person;
import com.example.application.data.service.PersonService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Endpoint
@AnonymousAllowed
public class PersonEndpoint {

    private PersonService service;

    public PersonEndpoint(@Autowired PersonService service) {
        this.service = service;
    }

    @Nonnull
    public Page<@Nonnull Person> list(Pageable page) {
        return service.list(page);
    }

    public Optional<Person> get(@Nonnull UUID id) {
        return service.get(id);
    }

    @Nonnull
    public Person update(@Nonnull Person entity) {
        return service.update(entity);
    }

    public void delete(@Nonnull UUID id) {
        service.delete(id);
    }

    public int count() {
        return service.count();
    }

}
