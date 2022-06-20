package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.RequestUserRegistration;
import com.katkova.ekatkova.dto.ResponseUserFilter;
import com.katkova.ekatkova.entity.UserEntity;
import com.katkova.ekatkova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    public void saveUser(RequestUserRegistration userDto) {
        UserEntity userEntity = dtoConvertor.toEntity(userDto, UserEntity.class);
        userRepository.save(userEntity);
    }

    public boolean hasSameUserLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    public boolean hasUserByLoginAndPassword(String login, String password){
        return userRepository.existsByLoginAndPassword(login, password);
    }

    public List<ResponseUserFilter> findAllUsingFilter(Long officeId, String firstName, String lastName,
                                                       String middleName, Long docCode, Long countryCode) {
        List<UserEntity> users = null;
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (null != officeId) {
                    predicates.add(criteriaBuilder.equal(root.get("office"), officeId));
                }
                if (null != firstName) {
                    predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%"));
                }
                if (null != lastName) {
                    predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));
                }
                if (null != middleName) {
                    predicates.add(criteriaBuilder.like(root.get("middleName"), "%" + middleName + "%"));
                }
                if (null != docCode) {
                    predicates.add(criteriaBuilder.equal(root.get("doc"), docCode));
                }
                if (null != countryCode) {
                    predicates.add(criteriaBuilder.equal(root.get("country"), countryCode));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        users = userRepository.findAll(specification);
        return dtoConvertor.toDtoList(users, ResponseUserFilter.class);
    }
}
