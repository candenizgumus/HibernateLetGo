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
@Table(name = "tblfavouriteilan")
public class FavouriteIlan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User user_id;
    @ManyToOne
    Ilan ilan_id;
    @Temporal(TemporalType.DATE)
    LocalDate createat;
    @Enumerated(EnumType.STRING)
    Status status;
}
