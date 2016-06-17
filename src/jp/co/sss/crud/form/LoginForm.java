package jp.co.sss.crud.form;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Edu
 *
 */
public class LoginForm extends ValidatorForm {
    private static final long serialVersionUID = 1L;

    private int id = 0;
    private String password = null;


    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {


        this.password = password;
    }
}