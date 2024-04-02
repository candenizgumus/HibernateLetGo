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
@Table(name = "tblimage")
public class Image
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Ilan ilan;
    String imageurl;
    @Temporal(TemporalType.DATE)
    LocalDate createat;
    @Temporal(TemporalType.DATE)
    LocalDate updateat;
    @Enumerated(EnumType.STRING)
    Status status;

}
