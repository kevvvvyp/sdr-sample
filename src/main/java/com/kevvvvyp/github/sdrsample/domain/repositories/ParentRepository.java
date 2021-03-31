package com.kevvvvyp.github.sdrsample.domain.repositories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kevvvvyp.github.sdrsample.domain.entities.Child1;
import com.kevvvvyp.github.sdrsample.domain.entities.Child2;
import com.kevvvvyp.github.sdrsample.domain.entities.Parent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@RepositoryRestResource(excerptProjection = ParentRepository.ArrayProjection.class)
public interface ParentRepository extends PagingAndSortingRepository<Parent, Long> {

    interface ArrayProjection {
        @JsonIgnore
        @Value("#{target}")
        Parent getParent();

        default String getParentValue(){
            return this.getParent().getParentValue();
        }

        default Child1 getChild1(){
            //TODO what are we actually trying to return here? Given we join the parent to
            // the child on id & id is the primary key on both entities can we ever get more than one child?
            return CollectionUtils.firstElement(this.getParent().getChild1());
        }

        default List<Long> getChild2() {
            return this.getParent().getChild2().stream()
                    .map(Child2::getId)
                    .collect(Collectors.toList());
        }

    }
}