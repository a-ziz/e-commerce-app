package com.aziz.ecommercerestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "sub_categories"
)
public class SubCategory {
  @Id
  @GeneratedValue(
          strategy = GenerationType.IDENTITY
  )
  private Long id;

  @Column(name = "sub_category_name", nullable = false, unique = true)
  private String subCategoryName;

  @Column(name = "sub_category_description")
  private String subCategoryDescription;

  @Column(name = "sub_category_image")
  private String subCategoryImage;

  private int position;
  private boolean status;

  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JoinColumn(
          name = "category_id",
          nullable = false
  )
  private Category category;

  @OneToMany(
          mappedBy = "subCategory",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private Set<Product> products = new HashSet<>();

}
