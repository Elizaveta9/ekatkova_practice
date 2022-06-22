package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.*;
import com.katkova.ekatkova.entity.CountryEntity;
import com.katkova.ekatkova.entity.DocEntity;
import com.katkova.ekatkova.entity.OfficeEntity;
import com.katkova.ekatkova.entity.UserEntity;
import com.katkova.ekatkova.repository.CountryRepository;
import com.katkova.ekatkova.repository.DocRepository;
import com.katkova.ekatkova.repository.OfficeRepository;
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
    private DocRepository docRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    public Response saveUser(Request userDto) {
        UserEntity userEntity = dtoConvertor.toEntity(userDto, UserEntity.class);
        userRepository.save(userEntity);
        return new ResponseResult(ResultTypeEnum.SUCCESS);
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

    public Response findById(Long id) {
        if (userRepository.existsById(id)){
            return dtoConvertor.toDto(userRepository.findFirstById(id), ResponseUserId.class);
        } else {
            return new ResponseResult(ResultTypeEnum.NO_SUCH_USER);
        }
    }

    public Response update(RequestUserUpdate userUpdatedDto) {
        if (userRepository.existsById(userUpdatedDto.getId())){
            UserEntity userEntity = userRepository.findFirstById(userUpdatedDto.getId());
            DocEntity docEntity;
            CountryEntity countryEntity;
            OfficeEntity officeEntity;

            if (null == userUpdatedDto.getDocCode()){
            } else if (!docRepository.existsById(userUpdatedDto.getDocCode())){
                return new ResponseResult(ResultTypeEnum.NO_SUCH_DOC);
            } else {
                docEntity = docRepository.findByCode(userUpdatedDto.getDocCode());
                userEntity.setDoc(docEntity);
            }

            if (null == userUpdatedDto.getCountryCode()){
            } else if (!countryRepository.existsById(userUpdatedDto.getCountryCode())){
                return new ResponseResult(ResultTypeEnum.NO_SUCH_COUNTRY);
            } else {
                countryEntity = countryRepository.findByCode(userUpdatedDto.getCountryCode());
                userEntity.setCountry(countryEntity);
            }

            if (null == userUpdatedDto.getOfficeId()){
            } else if (!officeRepository.existsById(userUpdatedDto.getOfficeId())) {
                return new ResponseResult(ResultTypeEnum.NO_SUCH_OFFICE);
            } else {
                officeEntity = officeRepository.findFirstById(userUpdatedDto.getId());
                userEntity.setOffice(officeEntity);
            }

            dtoConvertor.updateFromDto(userUpdatedDto, userEntity);
            userRepository.save(userEntity);
            return new ResponseResult(ResultTypeEnum.SUCCESS);
        } else {
            return new ResponseResult(ResultTypeEnum.NO_SUCH_USER);
        }
    }
}
