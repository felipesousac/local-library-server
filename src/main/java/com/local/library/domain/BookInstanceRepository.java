package com.local.library.domain;

import com.local.library.model.BookInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookInstanceRepository extends JpaRepository<BookInstance, Long> {

    @Query("select count(*) from Bookinstance WHERE status = 'AVAILABLE'")
    long activeBookInstancesCount();

    @Query("select b, a from Bookinstance b inner join Book a on (b.bookid = a.id)")
    Iterable<BookInstance> findBookinstanceWithBookNames();

    @Query("select a from Bookinstance a where a.bookid = :id")
    List<BookInstance> findAllByBookId(Long id);
}
