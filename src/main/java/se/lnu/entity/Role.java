package se.lnu.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class Role  {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    private String role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
