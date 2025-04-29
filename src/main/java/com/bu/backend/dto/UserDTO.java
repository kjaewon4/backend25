package com.bu.backend.dto;

import com.bu.backend.BackEnd25Application;
import com.bu.backend.entity.EntityUser;
import com.bu.backend.LoginStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private String id;
    private String pass;


    public LoginStatus isLogin(){
        String db_pass = BackEnd25Application.db_list.get(id);

        if(pass.equals(db_pass)) {
            return LoginStatus.ok;
        }else{
            if (db_pass == null ) {
                return LoginStatus.idError;
            }
            if (!db_pass.equals(pass)) {
                return LoginStatus.passError;
            }
        }

        return LoginStatus.none;
    }

    public EntityUser ToEntity(){
        return new EntityUser(this.id, this.pass);
    }

}
