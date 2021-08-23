package com.example.advancedsearch.specification;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.model.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonSpecification {

    public Specification<Person> persons(PersonFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (!ObjectUtils.isEmpty(filter.getName())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("name")), filter.getName().toUpperCase().concat("%")
                        )
                );
            }

            if (!ObjectUtils.isEmpty(filter.getEmail())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("email")), filter.getEmail().toLowerCase().concat("%")
                        )
                );
            }

            if (!ObjectUtils.isEmpty(filter.getMaritalStatus())) {
                predicateList.add(
                        criteriaBuilder.equal(root.get("maritalStatus"), filter.getMaritalStatus())
                );
            }

            if (!ObjectUtils.isEmpty(filter.getDistrict())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("district")), filter.getDistrict().toUpperCase().concat("%")
                        )
                );
            }

            if (!ObjectUtils.isEmpty(filter.getCity())) {
                predicateList.add(
                        criteriaBuilder.equal(root.get("city"), filter.getCity())
                );
            }

            if (!ObjectUtils.isEmpty(filter.getState())) {
                predicateList.add(
                        criteriaBuilder.equal(root.get("state"), filter.getState())
                );
            }

            if (!ObjectUtils.isEmpty(filter.getInitialBirthday())) {
                predicateList.add(
                        criteriaBuilder.greaterThanOrEqualTo(root.get("birthday"), filter.getInitialBirthday())
                );
            }

            if (!ObjectUtils.isEmpty(filter.getFinalBirthday())) {
                predicateList.add(
                        criteriaBuilder.lessThanOrEqualTo(root.get("birthday"), filter.getFinalBirthday())
                );
            }

            return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
        };
    }

}
