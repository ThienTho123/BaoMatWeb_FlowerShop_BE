package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "Flower")
@Table(name = "flower", schema = "flowershop")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FlowerID", nullable = false)
    private Integer flowerID;

    @Column(name = "Name",length = 100, nullable = false)
    private String name;

    @Column(name = "Description", nullable = false,columnDefinition = "TEXT")
    private String description;

    @Column(name = "Image", nullable = false,length = 500)
    private String image;

    @Column(name = "language_of_flowers", nullable = false,length = 500)
    private String languageOfFlowers;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "PurposeID")
    private Purpose purpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    protected Status status;

    @OneToMany(mappedBy = "flower", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<FlowerSize> flowerSizes;

}
