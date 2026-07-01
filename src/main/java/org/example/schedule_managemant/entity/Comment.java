package org.example.schedule_managemant.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comments")
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cm_id;

    @Column(length = 200, nullable = false)
    private String cm_content;
    @Column(nullable = false)
    private String cm_name;
    @Column(nullable = false)
    private String cm_password;
    @Column(nullable = false)
    private Long schedule_id;

    public Comment(String cm_content, String cm_name, String cm_password, Long schedule_id) {
        this.cm_content = cm_content;
        this.cm_name = cm_name;
        this.cm_password = cm_password;
        this.schedule_id = schedule_id;
    }
    public void cm_update(String cm_content){
        this.cm_content = cm_content;
    }
}
