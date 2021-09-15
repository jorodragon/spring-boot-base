package com.jorodragon.springbootbase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    @Column(name="created_date", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name="last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name="is_active")
    private boolean isActive = Boolean.TRUE;
}
