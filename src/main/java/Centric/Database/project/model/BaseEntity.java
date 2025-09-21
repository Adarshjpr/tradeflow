package Centric.Database.project.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class BaseEntity {

    @CreatedDate
    @Column(nullable = false , updatable = false)
    private Instant createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedDate;

    @CreatedBy
     @Column(nullable = false)
    private String  createdBy;
     
    @LastModifiedBy
    private String updatedby;

    @Column
    private Instant deletedAt;
 


}
