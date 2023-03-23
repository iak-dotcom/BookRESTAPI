package com.api.book.bootrestbook.entitiies;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.dialect.MySQL55Dialect;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor 
@Setter
@Getter
@ToString
@AllArgsConstructor
@Entity
@Table(name="books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private  int id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
   
}
