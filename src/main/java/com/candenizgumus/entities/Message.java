package com.candenizgumus.entities;

import com.candenizgumus.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    User sender_id;
    @ManyToOne
    User receiver_id;
    String text;
    @Temporal(TemporalType.DATE)
    LocalDate send_date;
    @Temporal(TemporalType.DATE)
    LocalDate updateat;
    @Enumerated(EnumType.STRING)
    Status status;
}
