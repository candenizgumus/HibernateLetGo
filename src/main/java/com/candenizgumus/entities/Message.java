package com.candenizgumus.entities;

import com.candenizgumus.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblmessage")
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User sender;
    @ManyToOne
    User receiver;
    @ManyToOne
    Ilan ilan;
    String text;
    @CreationTimestamp()
    LocalDateTime send_date;
    @Temporal(TemporalType.DATE)
    LocalDate updateat;
    @Enumerated(EnumType.STRING)
    Status status;
}
