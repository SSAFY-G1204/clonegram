package com.jpastudy.clonegram.domain.SocialRelations.repository;

import com.jpastudy.clonegram.domain.SocialRelations.dao.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
    List<Relation> findRelationByFollowerId(Long userId);
}
