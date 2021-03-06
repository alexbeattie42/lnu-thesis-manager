package se.lnu.entity;
import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade  {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "document_type")
    private String documentType;
    private String grade;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getDocumentType() {
        return documentType;
    }
    
    public void setDocumentType(String document_type) {
        this.documentType = document_type;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
}

