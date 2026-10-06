package in.kumar.HibernateDemo.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "student_DB")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_name",
            nullable = false,
            length = 100)
    private String name;

    @Column(unique = true,
            nullable = false,
            length = 100)
    private String email;

    @Column(updatable = false)
    private int age;

//    @Column(precision = 5,scale = 2)
//    private BigDecimal percentage;
//
//    private LocalDate dateOfBirth;
//
//    @Enumerated(EnumType.STRING)
//    private StudentStatus status;
//
//    private LocalDateTime createdAt;
//
//    @Lob
//    private String profileDescription;
//
//    @Transient
//    private String displayName;
//
//    @Convert(converter = BooleanToStringConverter.class)
//    private Boolean isMonitor;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "house_no",
                    column = @Column(name = "current_House_No")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "current_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "current_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "current_state")
            ),
            @AttributeOverride(
                    name = "pincode",
                    column = @Column(name = "current_pincode")
            )
    })
    private Address currentAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "house_no",
                    column = @Column(name = "permanent_House_No")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "permanent_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "permanent_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "permanent_state")
            ),
            @AttributeOverride(
                    name = "pincode",
                    column = @Column(name = "permanent_pincode")
            )
    })
    private Address permanentAddress;

    @ElementCollection
    @CollectionTable(
            name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<String> skills;

    public Student() {
    }

    public Student(String name, String email,
                   int age, Address currentAddress,
                   Address permanentAddress,
                   Set<String> skills) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
        this.skills = skills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public BigDecimal getPercentage() {
//        return percentage;
//    }
//
//    public void setPercentage(BigDecimal percentage) {
//        this.percentage = percentage;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public StudentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(StudentStatus status) {
//        this.status = status;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getProfileDescription() {
//        return profileDescription;
//    }
//
//    public void setProfileDescription(String profileDescription) {
//        this.profileDescription = profileDescription;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public Boolean getMonitor() {
//        return isMonitor;
//    }
//
//    public void setMonitor(Boolean monitor) {
//        isMonitor = monitor;
//    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}
