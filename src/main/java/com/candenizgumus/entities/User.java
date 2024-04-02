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
@Table(name = "tbluser")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String username;
    String password;
    @Column(unique = true)
    String email;
    String tel;
    String profileimageurl;
    String konum;
    @Temporal(TemporalType.DATE)
    LocalDate createat;
    @Temporal(TemporalType.DATE)
    LocalDate updateat;
    @Enumerated(EnumType.STRING)
    Status status;
}
