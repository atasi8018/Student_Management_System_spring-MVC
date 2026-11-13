package com.studentmangement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3)
    @NotBlank(message = "Student name is required")
    private String fullName;

    @Email
    @Column(unique = true)
    @NotBlank(message = "Email is required")
   private String email	;

    @NotBlank(message = "")
    @Pattern(
            regexp = "^[6-9]\\d{9}$", message = "Enter a valid 10-digit mobile number")
    private String mobile;

    @NotNull(message = "Age is required")
    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 100, message = "Age cannot exceed 100")
    private Integer age;

    @NotBlank(message = "Student course is mandatory")
   private String course;

    private LocalDateTime createdAt;
   private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
