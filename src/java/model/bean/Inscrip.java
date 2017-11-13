
package model.bean;

import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model.annotations.Inscrip_PasswordsAnnotation;
import model.annotations.Inscrip_UniqueLoginAnnotation;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Inscrip_PasswordsAnnotation(password="password", password2="password2")
public class Inscrip {
    @Size(min=5, max=30) 
    @Inscrip_UniqueLoginAnnotation(message="Veuillez saisir un autre login. Ceci est déjà pris.")
    private String login;
    
    @Size(min=6, max=30) 
    private String password;
    
    @Size(min=6, max=30)
    private String password2;

    @Size(min=3, max=30) 
    private String name;
    @Size(min=3, max=30) 
    private String surname;
    @NotBlank @Email 
    private String email;
    

    public Inscrip() {
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
}
