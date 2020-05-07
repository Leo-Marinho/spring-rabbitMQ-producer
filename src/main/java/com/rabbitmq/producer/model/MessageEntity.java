package com.rabbitmq.producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank @NotEmpty @Size(max = 200 )
    private String text;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate dateCreated;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate dateUpdated;


    public MessageEntity(final String text) {
        this.text = text;
    }
}
