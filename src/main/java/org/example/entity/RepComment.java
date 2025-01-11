package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.example.entity.enums.Status;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "RepComment")
@Table(name = "repcomment", schema = "flowershop")
public class RepComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RepcommentID", nullable = false)
    private Integer repcommentID;

    @ManyToOne
    @JoinColumn(name = "CommentID", nullable = false)
    private Comment comment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    private Account account;

    @Column(name = "Repcommentdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime repcommentdate;

    @Column(name = "Repcommenttext", nullable = false,columnDefinition = "TEXT")
    private String repcommenttext;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    protected Status status;

    @Column(name = "Image", length = 1000)
    private String image;
}
